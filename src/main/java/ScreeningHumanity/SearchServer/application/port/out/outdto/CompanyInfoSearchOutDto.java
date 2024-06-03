package ScreeningHumanity.SearchServer.application.port.out.outdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CompanyInfoSearchOutDto {
    private String stockCode;
    private String name;
}
