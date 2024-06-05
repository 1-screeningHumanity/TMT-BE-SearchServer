package ScreeningHumanity.SearchServer.application.port.out.outdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@JsonPropertyOrder({ "id", "name" })
public class CompanyInfoSearchOutDto {

    @JsonProperty("id")
    private String stockCode;

    private String name;
}
