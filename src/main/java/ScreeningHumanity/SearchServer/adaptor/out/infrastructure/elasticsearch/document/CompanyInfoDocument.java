package ScreeningHumanity.SearchServer.adaptor.out.infrastructure.elasticsearch.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "company-info-logs-*")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyInfoDocument {
    @Id
    private String id;

    @Field(type = FieldType.Keyword, name = "stockcode")
    private String stockCode;

    @Field(type = FieldType.Text)
    private String name;
}

