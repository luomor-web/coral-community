package me.luomor.web.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.luomor.constant.RedisKey;
import me.luomor.web.dto.IndexSwiperDTO;
import me.luomor.web.response.BaseResponse;
import me.luomor.web.service.IndexService;
import me.luomor.web.util.RedisUtils;
import me.luomor.util.UserContext;
import me.luomor.web.dto.QueryGuessYouLikeDTO;
import me.luomor.web.dto.QueryIndexBlockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public BaseResponse<List<IndexSwiperDTO>> queryIndexSwiper() {
        BaseResponse<List<IndexSwiperDTO>> response = new BaseResponse<>();
        List<IndexSwiperDTO> list = redisUtils.getList(UserContext.getRedisKeyPrefix() + RedisKey.INDEX_SWIPER, IndexSwiperDTO.class);
        response.setBody(list);
        return response;
    }

    @Override
    public BaseResponse<List<QueryIndexBlockDTO>> queryIndexBlock() {
        return null;
    }

    @Override
    public BaseResponse<List<QueryGuessYouLikeDTO>> queryGuessYouLike() {
        return null;
    }
}
