package ScreeningHumanity.SearchServer.adaptor.out.infrastructure.elasticsearch.repository;

import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.elasticsearch.document.MemberDocument;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDocumentRepository extends ElasticsearchRepository<MemberDocument, Long> {

    List<MemberDocument> findByNameContainsIgnoreCase(String name, Sort sort);
}