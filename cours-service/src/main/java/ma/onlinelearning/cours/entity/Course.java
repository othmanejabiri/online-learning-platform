package ma.onlinelearning.cours.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private int duration;
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
}
