package ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mysql.persistance;

import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mysql.entity.MainCategoryEntity;
import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mysql.repository.MainCategoryJpaRepository;
import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mysql.repository.SubCategoryJpaRepository;
import ScreeningHumanity.SearchServer.application.port.out.outdto.CategoryOutDto;
import ScreeningHumanity.SearchServer.application.port.out.outport.LoadCategorySearchPort;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategorySearchAdaptor implements LoadCategorySearchPort {

    private final MainCategoryJpaRepository mainCategoryJpaRepository;
    private final SubCategoryJpaRepository subCategoryJpaRepository;

    @Override
    public List<CategoryOutDto.MainCategory> loadMainCategory() {
        List<MainCategoryEntity> findData = mainCategoryJpaRepository.findAll();

        return findData.stream().map(
                data -> CategoryOutDto.MainCategory
                        .builder()
                        .id(data.getId())
                        .name(data.getName())
                        .image(data.getImage())
                        .build()).collect(Collectors.toList());
    }
}
