package ma.onlinelearning.inscriptions.service;

import lombok.RequiredArgsConstructor;
import ma.onlinelearning.inscriptions.entity.Etudiant;
import ma.onlinelearning.inscriptions.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    public Etudiant save(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    public Etudiant findById(Long id) {
        return etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));
    }
}
