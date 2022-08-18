package me.luomor.web.service;

import me.luomor.web.dto.IndexSwiperDTO;
import me.luomor.web.dto.QueryGuessYouLikeDTO;
import me.luomor.web.dto.QueryIndexBlockDTO;
import me.luomor.web.response.BaseResponse;

import java.util.List;

public interface IndexService {

    BaseResponse<List<IndexSwiperDTO>> queryIndexSwiper();

    BaseResponse<List<QueryIndexBlockDTO>> queryIndexBlock();

    BaseResponse<List<QueryGuessYouLikeDTO>> queryGuessYouLike();

}
