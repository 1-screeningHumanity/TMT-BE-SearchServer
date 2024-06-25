package ScreeningHumanity.SearchServer.application.port.out.outdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsSearchOutDto {

    private Long id;
    private String title;
    private String description;
    private String originallink;
    private String link;
    private String pubDate;
    private String image;
}
