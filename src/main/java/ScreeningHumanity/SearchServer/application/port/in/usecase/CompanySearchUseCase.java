package ScreeningHumanity.SearchServer.application.port.in.usecase;

import ScreeningHumanity.SearchServer.application.port.out.outdto.CompanyInfoSearchOutDto;
import java.util.List;

public interface CompanySearchUseCase {

    List<CompanyInfoSearchOutDto> companyInfoSearchByKeyword(String keyword);
}
