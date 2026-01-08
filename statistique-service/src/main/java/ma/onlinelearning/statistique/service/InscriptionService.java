package ma.onlinelearning.statistique.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class InscriptionService {

    private final WebClient.Builder webClientBuilder;

    public int countByCourseId(Long courseId) {
        try {
            Integer count = webClientBuilder.build()
                    .get()
                    .uri("http://INSCRIPTION-SERVICE/inscriptions/count/{id}", courseId)
                    .retrieve()
                    .bodyToMono(Integer.class)
                    .block();

            return count != null ? count : 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
