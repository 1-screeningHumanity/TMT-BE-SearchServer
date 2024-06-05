package ScreeningHumanity.SearchServer.application.port.out.outdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberSearchOutDto {

    private Long id;

    @JsonProperty("name")
    private String nickName;
}
