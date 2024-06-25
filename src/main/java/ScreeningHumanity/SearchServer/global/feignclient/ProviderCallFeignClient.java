package ScreeningHumanity.SearchServer.global.feignclient;

import ScreeningHumanity.SearchServer.global.feignclient.vo.NewsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "News", url = "${FEIGN_CLIENT.NAVER.NEWS.URL}")
public interface ProviderCallFeignClient {

    @GetMapping
    NewsResponse searchNews(
            @RequestHeader("X-Naver-Client-Id") String Client,
            @RequestHeader("X-Naver-Client-Secret") String Secret,
            @RequestParam(value = "query") String query,
            @RequestParam(value = "display") String display,
            @RequestParam(value = "sort") String sort
    );
}
