package ma.onlinelearning.cours.repository;

import ma.onlinelearning.cours.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "professors")
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
