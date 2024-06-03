package ScreeningHumanity.SearchServer.adaptor.in.web.controller;

import ScreeningHumanity.SearchServer.application.port.in.usecase.CompanySearchUseCase;
import ScreeningHumanity.SearchServer.application.port.out.outdto.CompanyInfoSearchOutDto;
import ScreeningHumanity.SearchServer.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "종목 조회 API", description = "종목 조회 API")
public class CompanySearchController {

    private final CompanySearchUseCase companySearchUseCase;

    @Operation(summary = "종목명 키워드 조회 api", description = "종목명을 키워드로 조회 합니다.")
    @GetMapping("/stocks")
    public BaseResponse<List<CompanyInfoSearchOutDto>> memberSearchByKeyword(
            @RequestParam(value = "searchName", required = true) String searchName
    ) {
        List<CompanyInfoSearchOutDto> findResult = companySearchUseCase.companyInfoSearchByKeyword(
                searchName);

        return new BaseResponse<>(findResult);
    }
}
