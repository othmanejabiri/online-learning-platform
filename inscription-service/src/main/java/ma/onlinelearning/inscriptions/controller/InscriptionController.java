package ma.onlinelearning.inscriptions.controller;

import lombok.RequiredArgsConstructor;
import ma.onlinelearning.inscriptions.dto.InscriptionRequestDTO;
import ma.onlinelearning.inscriptions.entity.Inscription;
import ma.onlinelearning.inscriptions.service.InscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscriptions")
@RequiredArgsConstructor
public class InscriptionController {

    private final InscriptionService inscriptionService;

    // INSCRIRE un étudiant
    @PostMapping
    public Inscription inscrire(@RequestBody InscriptionRequestDTO dto) {
        return inscriptionService.inscrire(dto);
    }

    // LISTER toutes les inscriptions
    @GetMapping
    public List<Inscription> getAll() {
        return inscriptionService.getAllInscriptions();
    }

    // COMPTER par courseId
    @GetMapping("/count/{courseId}")
    public long countByCourseId(@PathVariable("courseId") Long courseId) {
        return inscriptionService.countByCourseId(courseId);
    }
}
