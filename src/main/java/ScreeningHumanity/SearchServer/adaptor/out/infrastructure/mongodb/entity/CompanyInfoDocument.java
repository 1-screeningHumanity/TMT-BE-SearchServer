package ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "company_info")
public class CompanyInfoDocument {
    @Id
    private String id;
    private String name;
    private String stockCode;
    private String registerdAt;
    private String mainCategoryId;
    private String subCategoryId;
}
