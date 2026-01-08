package ma.onlinelearning.statistique.service;

import lombok.RequiredArgsConstructor;
import ma.onlinelearning.statistique.dto.YouTubeApiResponse;
import ma.onlinelearning.statistique.dto.YouTubeVideoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class YouTubeService {

    private final WebClient youtubeWebClient;

    @Value("${youtube.api.key}")
    private String apiKey;

    public YouTubeVideoDTO getVideo(String videoUrl) {

        String videoId = extractId(videoUrl);
        if (videoId == null) {
            return null;
        }

        YouTubeApiResponse response = youtubeWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("www.googleapis.com")
                        .path("/youtube/v3/videos")
                        .queryParam("part", "snippet,statistics,contentDetails")
                        .queryParam("id", videoId)
                        .queryParam("key", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(YouTubeApiResponse.class)
                .block();

        if (response == null || response.getItems() == null || response.getItems().isEmpty()) {
            return null;
        }

        YouTubeApiResponse.Item item = response.getItems().get(0);

        YouTubeVideoDTO dto = new YouTubeVideoDTO();
        dto.setVideoId(videoId);
        dto.setTitle(item.getSnippet().getTitle());
        dto.setDescription(item.getSnippet().getDescription());
        dto.setChannelTitle(item.getSnippet().getChannelTitle());
        dto.setPublishedAt(item.getSnippet().getPublishedAt());
        dto.setViewCount(item.getStatistics().getViewCount());
        dto.setLikeCount(item.getStatistics().getLikeCount());
        dto.setCommentCount(item.getStatistics().getCommentCount());
        dto.setDuration(item.getContentDetails().getDuration());

        return dto;
    }

    private String extractId(String url) {
        if (url == null) return null;

        if (url.contains("v=")) {
            return url.substring(url.indexOf("v=") + 2).split("&")[0];
        }

        return null;
    }
}
