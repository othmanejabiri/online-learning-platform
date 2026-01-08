package ma.onlinelearning.statistique.dto;

import lombok.Data;
import java.util.List;

@Data
public class YouTubeApiResponse {

    private List<Item> items;

    @Data
    public static class Item {
        private Snippet snippet;
        private Statistics statistics;
        private ContentDetails contentDetails;
    }

    @Data
    public static class Snippet {
        private String title;
        private String description;
        private String channelTitle;
        private String publishedAt;
    }

    @Data
    public static class Statistics {
        private Long viewCount;
        private Long likeCount;
        private Long commentCount;
    }

    @Data
    public static class ContentDetails {
        private String duration;
    }
}
