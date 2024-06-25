package ScreeningHumanity.SearchServer.adaptor.in.web.controller;

import ScreeningHumanity.SearchServer.global.common.response.BaseResponse;
import ScreeningHumanity.SearchServer.global.feignclient.ProviderCallFeignClient;
import ScreeningHumanity.SearchServer.global.feignclient.vo.NewsResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "뉴스 조회 API", description = "뉴스 조회 API")
public class NewsSearchController {
    private final ProviderCallFeignClient providerCallFeignClient;


    @Operation(summary = "메인 뉴스 조회 api", description = "메인 화면에 표출될 .")
    @GetMapping("test")
    private BaseResponse<Void> searchMainNews(){

        NewsResponse newsResponse = providerCallFeignClient.searchNews(
                "CkhkMODkpfL12rM5KLOV",
                "h2vVUIST3z",
                "삼성전자",
                "10",
                "sim"
        );

        log.info("title = {}", newsResponse.getItems().get(0).getTitle());
        log.info("Description = {}", newsResponse.getItems().get(0).getDescription());
        log.info("link = {}", newsResponse.getItems().get(0).getLink());
        log.info("originallink = {}", newsResponse.getItems().get(0).getOriginallink());

        try {
            Document document = Jsoup.connect(newsResponse.getItems().get(0).getLink()).get();
            Map<String, String> metadata = new HashMap<>();

            Element titleElement = document.selectFirst("meta[property=og:title]");
            Element descriptionElement = document.selectFirst("meta[property=og:description]");
            Element imageElement = document.selectFirst("meta[property=og:image]");

            if (titleElement != null) {
                metadata.put("title", titleElement.attr("content"));
            }

            if (descriptionElement != null) {
                metadata.put("description", descriptionElement.attr("content"));
            }

            if (imageElement != null) {
                metadata.put("image", imageElement.attr("content"));
            }

            log.info("image = {}", metadata.get("image"));
        }catch (Exception e){
            log.info("메타데이터 추출 중, 오류 발생");
        }


        return new BaseResponse<>();
    }
}
