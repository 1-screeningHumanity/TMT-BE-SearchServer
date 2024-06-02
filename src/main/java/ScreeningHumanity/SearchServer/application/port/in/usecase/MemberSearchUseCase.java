package ScreeningHumanity.SearchServer.application.port.in.usecase;

import ScreeningHumanity.SearchServer.application.port.out.outdto.MemberSearchOutDto;
import java.util.List;

public interface MemberSearchUseCase {

    List<MemberSearchOutDto> MemberSearchByKeyword(String keyword);
}
