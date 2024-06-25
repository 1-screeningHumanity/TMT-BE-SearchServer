package ScreeningHumanity.SearchServer.application.port.in.usecase;

import ScreeningHumanity.SearchServer.application.port.out.outvo.CategoryOutVo;
import java.util.List;

public interface CategorySearchUseCase {

    List<CategoryOutVo.MainCategory> searchMainCategory();

    CategoryOutVo.ResponseSubCategory searchSubCategory(String mainCategoryId);

    List<CategoryOutVo.StockList> searchStockListByCategory(String subCategoryId);
}
