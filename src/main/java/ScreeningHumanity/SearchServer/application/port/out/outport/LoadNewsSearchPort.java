package ScreeningHumanity.SearchServer.application.port.out.outport;

import ScreeningHumanity.SearchServer.application.port.out.outdto.NewsSearchOutDto;
import java.util.List;

public interface LoadNewsSearchPort {
    List<NewsSearchOutDto> searchNews(String keyword);
}
