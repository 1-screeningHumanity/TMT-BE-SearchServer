package ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mongodb.repository;

import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mongodb.entity.CompanyInfoDocument;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyInfoMongoRepository extends MongoRepository<CompanyInfoDocument, String> {

    @Query("{ 'subCategoryId' : ?0 }")
    List<CompanyInfoDocument> findAllBySubCategoryId(String subCategoryId);
}
