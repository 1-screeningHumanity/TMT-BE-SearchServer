package ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mysql.repository;

import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mysql.entity.MainCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainCategoryJpaRepository extends JpaRepository<MainCategoryEntity, Long> {

}