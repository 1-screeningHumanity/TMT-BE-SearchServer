package ScreeningHumanity.SearchServer.application.port.out.outport;

import ScreeningHumanity.SearchServer.application.port.out.outdto.CompanyInfoSearchOutDto;
import java.util.List;

public interface LoadCompanyInfoSearchPort {

    List<CompanyInfoSearchOutDto> loadCompanyInfoByKeyword(String keyword);
}
