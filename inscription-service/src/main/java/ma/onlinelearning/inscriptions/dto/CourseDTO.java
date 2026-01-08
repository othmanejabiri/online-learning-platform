package ma.onlinelearning.inscriptions.dto;

import lombok.Data;

@Data
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private int duration;
}
