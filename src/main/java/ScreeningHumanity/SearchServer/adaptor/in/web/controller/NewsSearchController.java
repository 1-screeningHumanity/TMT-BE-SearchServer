package ScreeningHumanity.SearchServer.adaptor.in.web.controller;

import ScreeningHumanity.SearchServer.application.port.in.usecase.NewsSearchUseCase;
import ScreeningHumanity.SearchServer.application.port.out.outvo.NewsOutVo;
import ScreeningHumanity.SearchServer.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "뉴스 조회 API", description = "뉴스 조회 API")
public class NewsSearchController {

    private final NewsSearchUseCase newsSearchUseCase;

    @Operation(summary = "뉴스 조회 api", description = "메인 화면에 표출될 .")
    @GetMapping("/news")
    private BaseResponse<List<NewsOutVo>> searchMainNews(
            @RequestParam(value = "keyword") String keyword
    ){
        List<NewsOutVo> findData = newsSearchUseCase.searchMainCategory(keyword);
        return new BaseResponse<>(findData);
    }
}