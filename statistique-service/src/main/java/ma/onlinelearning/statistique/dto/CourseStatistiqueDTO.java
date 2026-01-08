package ma.onlinelearning.statistique.dto;

import lombok.Data;

@Data
public class CourseStatistiqueDTO {
    private Long courseId;
    private String titre;
    private String professeur;
    private int totalInscriptions;
    private YouTubeVideoDTO video;
}
