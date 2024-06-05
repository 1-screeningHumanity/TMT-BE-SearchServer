package ScreeningHumanity.SearchServer.adaptor.out.infrastructure.elasticsearch.document;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = "member-mysql-logs-*")
//@Setting(settingPath = "es-config/es-analyzer.json")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberDocument {

    @Id
    @Field(type = FieldType.Long)
    private Long member_id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String nickname;

    @Field(type = FieldType.Text)
    private String password;

    @Field(type = FieldType.Text)
    private String phoneNumber;

    @Field(type = FieldType.Text)
    private String uuid;

    @Field(type = FieldType.Text, name = "paying_password")
    private String payingPassword;

    @Field(type = FieldType.Text)
    private List<String> tags;

    @Field(type = FieldType.Text)
    private String status;

    @Field(type = FieldType.Text, name = "created_at")
    private String createdAt;

    @Field(type = FieldType.Text, name = "modified_at")
    private String modifiedAt;
}
