package ScreeningHumanity.SearchServer.adaptor.out.infrastructure.elasticsearch.persistance;

import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.elasticsearch.document.MemberDocument;
import ScreeningHumanity.SearchServer.application.port.out.outdto.MemberSearchOutDto;
import ScreeningHumanity.SearchServer.application.port.out.outport.LoadMemberSearchPort;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.SearchTemplateQueryBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MemberAdaptor implements LoadMemberSearchPort {

    private final ElasticsearchOperations elasticsearchOperations;

    /**
     * 필요한 기능 1. 오탈자 검사 및 변경? - 삼성즌자 -> 삼성전자 - tkatjdwjswk -> 삼성전자 - fuzzy 기능 사용해 보기? 2. 영어로 적은 단어도
     * 한글로 입력되어 넘어옴. - 하이 -> Hi - 영어 단어 한글로 변환 3. 유사어 검색 - 삼성전자 -> 삼성전자, 삼성전기, 삼성..{} synonym 필터를
     * 사용한 커스텀 애널라이저 적용? 막노가다인거같은데? 4. 검색 결과 없는 경우, 다른 단어 제안? - suggest 기능을 사용? - 5. 초성 검색 지원 - ㅅㅅㅈㅈ
     * -> 삼성전자 - nori 분석기 사용 검토.
     */
    @Override
    public List<MemberSearchOutDto> LoadMemberByKeyword(String keyword) {
        String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        String indexNameToday = "member-mysql-logs-" + todayDate;
        //todo : 코드 스멜로 전역 변수 관리하도록 수정 예정. + MemberDocument

        String wildcardKeyword = "*" + keyword + "*"; // 키워드 앞뒤로 와일드카드를 추가
        Query query = QueryBuilders.bool(boolQuery ->
                boolQuery
                        .should(shouldQuery -> shouldQuery
                                .wildcard(wildcardQuery ->
                                        wildcardQuery
                                                .field("nickname")
                                                .value(wildcardKeyword)
                                                .caseInsensitive(true)
                                )
                        )
                        .should(shouldQuery -> shouldQuery
                                .fuzzy(fuzzyQuery ->
                                        fuzzyQuery
                                                .field("nickname")
                                                .value(keyword)
                                                .fuzziness("AUTO")
                                )
                        )
                        .mustNot(mustNotQuery -> mustNotQuery
                                .term(termQuery ->
                                        termQuery
                                                .field("status.keyword")
                                                .value("OUT")
                                )
                        )
                        .filter(filterQuery -> filterQuery
                                .term(termQuery ->
                                        termQuery
                                                .field("_index")
                                                .value(indexNameToday)
                                )
                        )
                        .minimumShouldMatch("1")
        );

        NativeQuery nativeQuery = NativeQuery.builder().withQuery(query).build();
        nativeQuery.setMaxResults(500); //max Result 설정.

        SearchHits<MemberDocument> result = elasticsearchOperations.search(nativeQuery,
                MemberDocument.class);

        return result.stream()
                .map(searchHit -> {
                    MemberDocument findResult = searchHit.getContent();
                    return MemberSearchOutDto.builder()
                            .id(findResult.getMember_id())
                            .nickName(findResult.getNickname())
                            .build();
                })
                .collect(Collectors.toList());
    }
}
