package ma.onlinelearning.statistique.service;

import lombok.RequiredArgsConstructor;
import ma.onlinelearning.statistique.dto.ProfessorDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final WebClient.Builder webClientBuilder;

    public ProfessorDTO getProfessorByCourseId(Long courseId) {
        try {
            return webClientBuilder.build()
                    .get()
                    .uri("http://COURS-SERVICE/courses/{id}/professor", courseId)
                    .retrieve()
                    .bodyToMono(ProfessorDTO.class)
                    .block();
        } catch (Exception e) {
            return null;
        }
    }
}
