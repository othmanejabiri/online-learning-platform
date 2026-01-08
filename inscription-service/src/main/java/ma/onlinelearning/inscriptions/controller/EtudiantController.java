package ma.onlinelearning.inscriptions.controller;

import lombok.RequiredArgsConstructor;
import ma.onlinelearning.inscriptions.entity.Etudiant;
import ma.onlinelearning.inscriptions.service.EtudiantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
@RequiredArgsConstructor
public class EtudiantController {

    private final EtudiantService etudiantService;

    @PostMapping
    public Etudiant save(@RequestBody Etudiant etudiant) {
        return etudiantService.save(etudiant);
    }

    @GetMapping
    public List<Etudiant> findAll() {
        return etudiantService.findAll();
    }
}
