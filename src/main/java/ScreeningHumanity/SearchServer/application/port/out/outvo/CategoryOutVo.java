package ScreeningHumanity.SearchServer.application.port.out.outvo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CategoryOutVo {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MainCategory {

        private Long id;
        private String name;
        private String image;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SubCategory {

        private Boolean isSubscribe;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StockList {

        private Boolean isSubscribe;
    }
}
