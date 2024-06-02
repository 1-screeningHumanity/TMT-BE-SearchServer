package ScreeningHumanity.SearchServer.application.service;

import ScreeningHumanity.SearchServer.application.port.in.usecase.MemberSearchUseCase;
import ScreeningHumanity.SearchServer.application.port.out.outdto.MemberSearchOutDto;
import ScreeningHumanity.SearchServer.application.port.out.outport.LoadMemberSearchPort;
import ScreeningHumanity.SearchServer.global.common.exception.CustomException;
import ScreeningHumanity.SearchServer.global.common.response.BaseResponseCode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberSearchService implements MemberSearchUseCase {

    private final LoadMemberSearchPort loadMemberSearchPort;

    @Override
    public List<MemberSearchOutDto> MemberSearchByKeyword(String keyword) {
        //검색 키워드는 공백 제외 1글자 이상 필요.
        if (keyword == null || keyword.trim().isEmpty()) {
            throw new CustomException(BaseResponseCode.SEARCH_KEYWORD_IS_EMPTY);
        }

        return loadMemberSearchPort.LoadMemberByKeyword(keyword);
    }
}
