package ma.onlinelearning.cours.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDTO {

    private Long id;
    private String title;
    private String description;
    private int duration;
    private String videoUrl;
    private String professor;
}
