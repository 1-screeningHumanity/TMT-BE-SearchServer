package ScreeningHumanity.SearchServer.application.port.out.outport;

import ScreeningHumanity.SearchServer.application.port.out.outdto.MemberSearchOutDto;
import java.util.List;

public interface LoadMemberSearchPort {

    List<MemberSearchOutDto> LoadMemberByKeyword(String keyword);
}
