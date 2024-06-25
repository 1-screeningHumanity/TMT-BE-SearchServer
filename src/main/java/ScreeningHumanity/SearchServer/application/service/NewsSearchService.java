package ScreeningHumanity.SearchServer.application.service;

import ScreeningHumanity.SearchServer.adaptor.out.infrastructure.feignclient.entity.NewsResponse;
import ScreeningHumanity.SearchServer.application.port.in.usecase.NewsSearchUseCase;
import ScreeningHumanity.SearchServer.application.port.out.outdto.NewsSearchOutDto;
import ScreeningHumanity.SearchServer.application.port.out.outport.LoadNewsSearchPort;
import ScreeningHumanity.SearchServer.application.port.out.outvo.NewsOutVo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NewsSearchService implements NewsSearchUseCase {

    private final LoadNewsSearchPort loadNewsSearchPort;

    @Transactional
    @Override
    public List<NewsOutVo> searchMainCategory(String keyword) {
        List<NewsSearchOutDto> findData = loadNewsSearchPort.searchNews(keyword);
        return findData.stream().map(
                data -> NewsOutVo
                        .builder()
                        .id(data.getId())
                        .title(data.getTitle())
                        .description(data.getDescription())
                        .originallink(data.getOriginallink())
                        .link(data.getLink())
                        .pubDate(data.getPubDate())
                        .image(data.getImage())
                        .build()).collect(Collectors.toList());
    }
}
