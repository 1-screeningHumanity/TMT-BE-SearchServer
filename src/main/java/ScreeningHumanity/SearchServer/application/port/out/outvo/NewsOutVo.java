package ScreeningHumanity.SearchServer.application.port.out.outvo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsOutVo {

    private Long id;
    private String title;
    private String description;
    private String originallink;
    private String link;
    private String pubDate;
    private String image;
}
