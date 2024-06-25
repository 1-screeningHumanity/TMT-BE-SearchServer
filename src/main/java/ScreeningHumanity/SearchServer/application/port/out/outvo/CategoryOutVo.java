package ScreeningHumanity.SearchServer.application.port.out.outvo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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

        @JsonProperty(value = "categoryId")
        private Long id;

        @JsonProperty(value = "categoryName")
        private String name;

        @JsonProperty(value = "img_url")
        private String image;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SubCategory {

        @JsonProperty(value = "categoryId")
        private Long id;

        @JsonProperty(value = "categoryName")
        private String name;

        @JsonProperty(value = "img_url")
        private String image;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseSubCategory {
        private String mainCategoryName;
        private List<SubCategory> categoryData;
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
}
