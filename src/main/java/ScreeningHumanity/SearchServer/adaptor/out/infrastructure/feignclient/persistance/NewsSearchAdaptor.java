package ScreeningHumanity.SearchServer.adaptor.out.infrastructure.feignclient.persistance;

import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.feignclient.entity.NewsResponse;
import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.feignclient.provider.ProviderCallFeignClient;
import ScreeningHumanity.SearchServer.application.port.out.outdto.NewsSearchOutDto;
import ScreeningHumanity.SearchServer.application.port.out.outport.LoadNewsSearchPort;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NewsSearchAdaptor implements LoadNewsSearchPort {

    private final ProviderCallFeignClient feignClient;

    @Value("${FEIGN_CLIENT.NAVER.NEWS.CLIENT_ID}")
    private String clientId;

    @Value("${FEIGN_CLIENT.NAVER.NEWS.CLIENT_SECRET}")
    private String clientSecret;

    @Override
    public List<NewsSearchOutDto> searchNews(String keyword) {
        NewsResponse newsResponse = feignClient.searchNews(
                clientId,
                clientSecret,
                keyword
        );
        AtomicLong atomicLong = new AtomicLong(1L);

        return newsResponse.getItems().stream().map(
                data -> NewsSearchOutDto
                        .builder()
                        .id(atomicLong.getAndIncrement())
                        .title(data.getTitle())
                        .description(data.getDescription())
                        .originallink(data.getOriginallink())
                        .link(data.getLink())
                        .pubDate(data.getPubDate())
                        .image(getMetaData(data.getOriginallink()) == null ? "https://i.ibb.co/DGk5wK7/TMT.png" : getMetaData(data.getOriginallink()))
                        .build()).collect(Collectors.toList());
    }

    private String getMetaData(String url) {
        String imageUrl;

        try {
            Document document = Jsoup.connect(url).get();
            Element imageElement = document.selectFirst("meta[property=og:image]");
            imageUrl = imageElement.attr("content");
        } catch (Exception e) {
            log.info("Meta Data 추출 실패");
            return null;
        }

        return imageUrl;
    }
}
