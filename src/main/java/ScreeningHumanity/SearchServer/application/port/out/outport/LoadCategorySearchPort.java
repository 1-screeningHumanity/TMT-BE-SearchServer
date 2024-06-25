package ScreeningHumanity.SearchServer.application.port.out.outport;

import ScreeningHumanity.SearchServer.application.port.out.outdto.CategoryOutDto;
import java.util.List;

public interface LoadCategorySearchPort {

    List<CategoryOutDto.MainCategory> loadMainCategory();

    String loadMainCategoryName(String mainCategoryId);

    List<CategoryOutDto.SubCategory> loadSubCategory(String mainCategoryId);
}
