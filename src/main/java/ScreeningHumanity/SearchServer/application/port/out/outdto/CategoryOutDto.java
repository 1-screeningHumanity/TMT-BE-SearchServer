package ScreeningHumanity.SearchServer.application.port.out.outdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CategoryOutDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MainCategory{
        private Long id;
        private String name;
        private String image;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SubCategory{
        private Long id;
        private String name;
        private String image;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StockList {

        private Long id;
        private String stockCode;
        private String stockName;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CategoryName {

        private String mainCategoryName;
        private String subCategoryName;
    }
}
