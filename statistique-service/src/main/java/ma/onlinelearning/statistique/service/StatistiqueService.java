package ma.onlinelearning.statistique.service;

import lombok.RequiredArgsConstructor;
import ma.onlinelearning.statistique.dto.CourseDTO;
import ma.onlinelearning.statistique.dto.CourseStatistiqueDTO;
import ma.onlinelearning.statistique.dto.ProfessorDTO;
import ma.onlinelearning.statistique.dto.YouTubeVideoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class StatistiqueService {

    private final WebClient.Builder webClientBuilder;
    private final ProfessorService professorService;
    private final InscriptionService inscriptionService;
    private final YouTubeService youTubeService;

    public Mono<CourseStatistiqueDTO> getStatistiques(Long courseId) {

        // 1️⃣ Cours
        Mono<CourseDTO> courseMono = webClientBuilder.build()
                .get()
                .uri("http://COURS-SERVICE/courses/{id}", courseId)
                .retrieve()
                .bodyToMono(CourseDTO.class);

        // 2️⃣ Professeur
        Mono<ProfessorDTO> professorMono = Mono.fromCallable(
                        () -> professorService.getProfessorByCourseId(courseId)
                )
                .subscribeOn(Schedulers.boundedElastic())
                .defaultIfEmpty(new ProfessorDTO());

        // 3️⃣ Inscriptions
        Mono<Integer> inscriptionMono = Mono.fromCallable(
                        () -> inscriptionService.countByCourseId(courseId)
                )
                .subscribeOn(Schedulers.boundedElastic())
                .defaultIfEmpty(0);

        // 4️⃣ Vidéo YouTube (AUCUN defaultIfEmpty(null) ICI)
        Mono<YouTubeVideoDTO> videoMono = courseMono.flatMap(course -> {
            if (course.getVideoUrl() == null || course.getVideoUrl().trim().isEmpty()) {
                return Mono.empty();
            }
            return Mono.fromCallable(() ->
                            youTubeService.getVideo(course.getVideoUrl())
                    )
                    .subscribeOn(Schedulers.boundedElastic());
        });

        // 5️⃣ Assemblage final
        return Mono.zip(courseMono, professorMono, inscriptionMono)
                .flatMap(tuple -> {
                    CourseDTO course = tuple.getT1();
                    ProfessorDTO prof = tuple.getT2();
                    Integer totalInscriptions = tuple.getT3();

                    return videoMono
                            .defaultIfEmpty(new YouTubeVideoDTO()) // ✅ OBJET, PAS null
                            .map(video -> {
                                CourseStatistiqueDTO dto = new CourseStatistiqueDTO();
                                dto.setCourseId(courseId);
                                dto.setTitre(course.getTitle());
                                dto.setProfesseur(
                                        prof.getName() != null ? prof.getName() : "Non assigné"
                                );
                                dto.setTotalInscriptions(totalInscriptions);

                                // si videoId null → on enlève la vidéo
                                if (video.getVideoId() != null) {
                                    dto.setVideo(video);
                                }

                                return dto;
                            });
                });
    }
}
