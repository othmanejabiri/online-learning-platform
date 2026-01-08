package ma.onlinelearning.inscriptions.service;

import lombok.RequiredArgsConstructor;
import ma.onlinelearning.inscriptions.dto.InscriptionRequestDTO;
import ma.onlinelearning.inscriptions.entity.Etudiant;
import ma.onlinelearning.inscriptions.entity.Inscription;
import ma.onlinelearning.inscriptions.repository.EtudiantRepository;
import ma.onlinelearning.inscriptions.repository.InscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InscriptionService {

    private final InscriptionRepository inscriptionRepository;
    private final EtudiantRepository etudiantRepository;

    public Inscription inscrire(InscriptionRequestDTO dto) {
        Etudiant etudiant = etudiantRepository.findById(dto.getEtudiantId())
                .orElseThrow(() -> new RuntimeException("Etudiant introuvable"));

        Inscription inscription = Inscription.builder()
                .etudiant(etudiant)
                .courseId(dto.getCourseId())
                .status("INSCRIT")
                .build();

        return inscriptionRepository.save(inscription);
    }

    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    public long countByCourseId(Long courseId) {
        return inscriptionRepository.countByCourseId(courseId);
    }
}
