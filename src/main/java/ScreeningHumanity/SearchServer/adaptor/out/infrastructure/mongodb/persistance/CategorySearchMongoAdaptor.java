package ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mongodb.persistance;

import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mongodb.entity.CompanyInfoDocument;
import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.mongodb.repository.CompanyInfoMongoRepository;
import ScreeningHumanity.SearchServer.application.port.out.outdto.CategoryOutDto;
import ScreeningHumanity.SearchServer.application.port.out.outport.LoadCategorySearchListPort;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategorySearchMongoAdaptor implements LoadCategorySearchListPort {

    private final CompanyInfoMongoRepository companyInfoMongoRepository;

    @Override
    public List<CategoryOutDto.StockList> loadStockInformation(String subCategoryId) {
        List<CompanyInfoDocument> findData = companyInfoMongoRepository.findAllBySubCategoryId(
                subCategoryId);

        AtomicLong atomicLong = new AtomicLong(1L);

        return findData.stream().map(
                data -> CategoryOutDto.StockList
                        .builder()
                        .id(atomicLong.getAndIncrement())
                        .stockName(data.getName())
                        .stockCode(data.getStockCode())
                        .build()).collect(Collectors.toList());
    }
}
