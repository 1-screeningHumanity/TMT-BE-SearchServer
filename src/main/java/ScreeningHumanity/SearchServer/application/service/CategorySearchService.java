package ScreeningHumanity.SearchServer.application.service;

import ScreeningHumanity.SearchServer.application.port.in.usecase.CategorySearchUseCase;
import ScreeningHumanity.SearchServer.application.port.out.outdto.CategoryOutDto;
import ScreeningHumanity.SearchServer.application.port.out.outport.LoadCategorySearchPort;
import ScreeningHumanity.SearchServer.application.port.out.outvo.CategoryOutVo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategorySearchService implements CategorySearchUseCase {

    private final LoadCategorySearchPort loadCategorySearchPort;

    @Override
    public List<CategoryOutVo.MainCategory> searchMainCategory() {
        List<CategoryOutDto.MainCategory> findData = loadCategorySearchPort.loadMainCategory();

        return findData.stream().map(
                data -> CategoryOutVo.MainCategory
                        .builder()
                        .id(data.getId())
                        .name(data.getName())
                        .image(data.getImage())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public List<CategoryOutVo.SubCategory> searchSubCategory(String mainCategoryId) {
        List<CategoryOutDto.SubCategory> findData = loadCategorySearchPort.loadSubCategory(
                mainCategoryId);

        return findData.stream().map(
                data -> CategoryOutVo.SubCategory
                        .builder()
                        .id(data.getId())
                        .name(data.getName())
                        .image(data.getImage())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public List<CategoryOutVo.StockList> searchStockListByCategory(String subCategoryId) {
        return null;
    }
}
