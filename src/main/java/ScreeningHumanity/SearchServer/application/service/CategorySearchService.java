package ScreeningHumanity.SearchServer.application.service;

import ScreeningHumanity.SearchServer.application.port.in.usecase.CategorySearchUseCase;
import ScreeningHumanity.SearchServer.application.port.out.outdto.CategoryOutDto;
import ScreeningHumanity.SearchServer.application.port.out.outport.LoadCategorySearchListPort;
import ScreeningHumanity.SearchServer.application.port.out.outport.LoadCategorySearchPort;
import ScreeningHumanity.SearchServer.application.port.out.outvo.CategoryOutVo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategorySearchService implements CategorySearchUseCase {

    private final LoadCategorySearchPort loadCategorySearchPort;
    private final LoadCategorySearchListPort loadCategorySearchListPort;

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    @Override
    public CategoryOutVo.ResponseSubCategory searchSubCategory(String mainCategoryId) {
        List<CategoryOutDto.SubCategory> findData = loadCategorySearchPort.loadSubCategory(
                mainCategoryId);

        //main 카테고리 이름 조회.
        String mainCategoryName = loadCategorySearchPort.loadMainCategoryName(mainCategoryId);

        List<CategoryOutVo.SubCategory> collect = findData.stream().map(
                data -> CategoryOutVo.SubCategory
                        .builder()
                        .id(data.getId())
                        .name(data.getName())
                        .image(data.getImage())
                        .build()).collect(Collectors.toList());

        return CategoryOutVo.ResponseSubCategory
                .builder()
                .categoryData(collect)
                .mainCategoryName(mainCategoryName)
                .build();
    }

    @Override
    public CategoryOutVo.ResponseStockList searchStockListByCategory(String subCategoryId) {
        List<CategoryOutDto.StockList> findData = loadCategorySearchListPort.loadStockInformation(subCategoryId);
        CategoryOutDto.CategoryName categoryName = loadCategorySearchPort.loadSubCategoryNames(
                subCategoryId);

        List<CategoryOutVo.StockList> collect = findData.stream().map(
                data -> CategoryOutVo.StockList
                        .builder()
                        .id(data.getId())
                        .stockCode(data.getStockCode())
                        .stockName(data.getStockName())
                        .build()).collect(Collectors.toList());

        return CategoryOutVo.ResponseStockList
                .builder()
                .mainCategoryName(categoryName.getMainCategoryName())
                .subCategoryName(categoryName.getSubCategoryName())
                .stockData(collect)
                .build();
    }
}
