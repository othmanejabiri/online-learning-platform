package ma.onlinelearning.statistique.dto;

import lombok.Data;

@Data
public class YouTubeVideoDTO {

    private String videoId;
    private String title;
    private String description;
    private String channelTitle;
    private String publishedAt;

    private Long viewCount;
    private Long likeCount;
    private Long commentCount;

    private String duration;
}
