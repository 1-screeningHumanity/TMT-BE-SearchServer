package ScreeningHumanity.SearchServer.application.port.in.usecase;

import ScreeningHumanity.SearchServer.application.port.out.outvo.NewsOutVo;
import java.util.List;

public interface NewsSearchUseCase {
    List<NewsOutVo> searchMainCategory(String keyword);
}
