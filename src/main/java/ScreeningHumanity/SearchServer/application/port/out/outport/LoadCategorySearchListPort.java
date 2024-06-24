package ScreeningHumanity.SearchServer.application.port.out.outport;

import ScreeningHumanity.SearchServer.application.port.out.outdto.CategoryOutDto;
import java.util.List;

public interface LoadCategorySearchListPort {

    List<CategoryOutDto.StockList> loadStockInformation(String subCategoryId);
}
