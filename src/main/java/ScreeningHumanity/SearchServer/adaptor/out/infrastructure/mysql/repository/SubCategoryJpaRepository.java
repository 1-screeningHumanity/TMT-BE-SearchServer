package ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mysql.repository;

import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mysql.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryJpaRepository extends JpaRepository<SubCategoryEntity, Long> {

}
