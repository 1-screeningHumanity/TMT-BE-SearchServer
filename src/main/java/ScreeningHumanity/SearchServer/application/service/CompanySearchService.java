package ScreeningHumanity.SearchServer.application.service;

import ScreeningHumanity.SearchServer.application.port.in.usecase.CompanySearchUseCase;
import ScreeningHumanity.SearchServer.application.port.out.outdto.CompanyInfoSearchOutDto;
import ScreeningHumanity.SearchServer.application.port.out.outport.LoadCompanyInfoSearchPort;
import ScreeningHumanity.SearchServer.global.common.exception.CustomException;
import ScreeningHumanity.SearchServer.global.common.response.BaseResponseCode;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanySearchService implements CompanySearchUseCase {

    private final LoadCompanyInfoSearchPort loadCompanyInfoSearchPort;

    @Override
    public List<CompanyInfoSearchOutDto> companyInfoSearchByKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>();
        }

        return loadCompanyInfoSearchPort.loadCompanyInfoByKeyword(keyword);
    }
}
