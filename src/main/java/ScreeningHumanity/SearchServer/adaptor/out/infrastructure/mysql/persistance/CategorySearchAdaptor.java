package ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mysql.persistance;

import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mysql.entity.MainCategoryEntity;
import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mysql.entity.SubCategoryEntity;
import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mysql.repository.MainCategoryJpaRepository;
import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mysql.repository.SubCategoryJpaRepository;
import ScreeningHumanity.SearchServer.application.port.out.outdto.CategoryOutDto;
import ScreeningHumanity.SearchServer.application.port.out.outport.LoadCategorySearchPort;
import ScreeningHumanity.SearchServer.global.common.exception.CustomException;
import ScreeningHumanity.SearchServer.global.common.response.BaseResponseCode;
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

    @Override
    public List<CategoryOutDto.SubCategory> loadSubCategory(String mainCategoryId) {
        MainCategoryEntity findMainCategoryData = mainCategoryJpaRepository.findById(Long.parseLong(mainCategoryId))
                .orElseThrow(
                        () -> new CustomException(BaseResponseCode.SEARCH_SUB_CATEGORY_MAIN_CATEGORY_ID_EMPTY)
                );
        List<SubCategoryEntity> findData = subCategoryJpaRepository.findAllByMainCategory(
                findMainCategoryData);

        return findData.stream().map(
                data -> CategoryOutDto.SubCategory
                        .builder()
                        .id(data.getId())
                        .name(data.getName())
                        .image(data.getImage())
                        .build()).collect(Collectors.toList());
    }
}
