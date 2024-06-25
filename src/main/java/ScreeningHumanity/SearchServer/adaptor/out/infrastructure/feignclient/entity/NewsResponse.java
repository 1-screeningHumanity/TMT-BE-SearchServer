package ScreeningHumanity.SearchServer.adaptor.out.infrastructure.feignclient.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponse {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<NewsItem> items;
}
