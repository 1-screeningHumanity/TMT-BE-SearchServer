package ScreeningHumanity.SearchServer.global.common.exception;

import ScreeningHumanity.SearchServer.global.common.response.BaseResponseCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final BaseResponseCode status;

    public CustomException(BaseResponseCode status) {
        this.status = status;
    }
}
