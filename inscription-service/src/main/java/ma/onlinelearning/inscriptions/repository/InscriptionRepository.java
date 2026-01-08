package ma.onlinelearning.inscriptions.repository;

import ma.onlinelearning.inscriptions.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    long countByCourseId(Long courseId);
 }
