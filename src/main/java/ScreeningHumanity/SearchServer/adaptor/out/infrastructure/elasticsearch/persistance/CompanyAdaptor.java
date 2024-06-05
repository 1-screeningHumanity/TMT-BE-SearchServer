package ScreeningHumanity.SearchServer.adaptor.out.infrastructure.elasticsearch.persistance;

import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.elasticsearch.document.CompanyInfoDocument;
import ScreeningHumanity.SearchServer.application.port.out.outdto.CompanyInfoSearchOutDto;
import ScreeningHumanity.SearchServer.application.port.out.outport.LoadCompanyInfoSearchPort;
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
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CompanyAdaptor implements LoadCompanyInfoSearchPort {

    private final ElasticsearchOperations elasticsearchOperations;

    @Override
    public List<CompanyInfoSearchOutDto> loadCompanyInfoByKeyword(String keyword) {
        String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        String indexNameToday = "company-info-logs-" + todayDate;
        //todo : 코드 스멜로 전역 변수 관리하도록 수정 예정. + Document

        String wildcardKeyword = "*" + keyword + "*";
        Query query = QueryBuilders.bool(boolQuery ->
                boolQuery
                        .should(shouldQuery -> shouldQuery
                                .wildcard(wildcardQuery ->
                                        wildcardQuery
                                                .field("name")
                                                .value(wildcardKeyword)
                                                .caseInsensitive(true)
                                )
                        )
                        .should(shouldQuery -> shouldQuery
                                .fuzzy(fuzzyQuery ->
                                        fuzzyQuery
                                                .field("name")
                                                .value(keyword)
                                                .fuzziness("AUTO")
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

        SearchHits<CompanyInfoDocument> result = elasticsearchOperations.search(nativeQuery,
                CompanyInfoDocument.class);

        return result.stream()
                .map(searchHit -> {
                    CompanyInfoDocument findResult = searchHit.getContent();
                    return CompanyInfoSearchOutDto.builder()
                            .name(findResult.getName())
                            .stockCode(findResult.getStockCode())
                            .build();
                })
                .collect(Collectors.toList());
    }
}
