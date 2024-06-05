package ScreeningHumanity.SearchServer.adaptor.in.web.controller;

import ScreeningHumanity.SearchServer.application.port.in.usecase.MemberSearchUseCase;
import ScreeningHumanity.SearchServer.application.port.out.outdto.MemberSearchOutDto;
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
@Tag(name = "회원 조회 API", description = "회원 조회 API")
public class MemberSearchController {

    private final MemberSearchUseCase memberSearchUseCase;

    @Operation(summary = "회원 키워드 조회 api", description = "회원이름을 키워드로 조회 합니다.")
    @GetMapping("/members")
    public BaseResponse<List<MemberSearchOutDto>> memberSearchByKeyword(
            @RequestParam(value = "searchName", required = false) String searchName
    ){
        List<MemberSearchOutDto> findResult = memberSearchUseCase.MemberSearchByKeyword(
                searchName);
        return new BaseResponse<>(findResult);
    }
}
