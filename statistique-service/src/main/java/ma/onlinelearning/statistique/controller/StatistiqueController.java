package ma.onlinelearning.statistique.controller;

import lombok.RequiredArgsConstructor;
import ma.onlinelearning.statistique.dto.CourseStatistiqueDTO;
import ma.onlinelearning.statistique.service.StatistiqueService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/statistiques")
@RequiredArgsConstructor
public class StatistiqueController {

    private final StatistiqueService statistiqueService;

    @GetMapping("/courses/{id}")
    public Mono<CourseStatistiqueDTO> getStatistiques(
            @PathVariable("id") Long id
    ) {
        return statistiqueService.getStatistiques(id);
    }
}
