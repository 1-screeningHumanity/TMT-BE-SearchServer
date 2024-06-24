package ScreeningHumanity.SearchServer.adaptor.in.web.controller;

import ScreeningHumanity.SearchServer.application.port.in.usecase.CategorySearchUseCase;
import ScreeningHumanity.SearchServer.application.port.out.outvo.CategoryOutVo;
import ScreeningHumanity.SearchServer.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Category 조회 API", description = "Category 조회 관련 API")
public class CategorySearchController {

    private final CategorySearchUseCase categorySearchUseCase;

    @Operation(summary = "Main Category 조회 api", description = "Main Category 조회 API")
    @GetMapping("/subscribe")
    private BaseResponse<List<CategoryOutVo.MainCategory>> subscribeMember(){
        List<CategoryOutVo.MainCategory> findData = categorySearchUseCase.searchMainCategory();

        return new BaseResponse<>(findData);
    }
}
