package ScreeningHumanity.SearchServer.application.port.out.outdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberSearchOutDto {

    private Long id;
    private String name;
    private String nickName;
    private String uuid;
}
