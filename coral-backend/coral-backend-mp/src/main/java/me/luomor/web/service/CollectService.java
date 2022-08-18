package me.luomor.web.service;

import me.luomor.web.dto.MomentDTO;
import me.luomor.web.request.CancelCollectRequest;
import me.luomor.web.request.CollectRequest;
import me.luomor.web.request.PageRequest;
import me.luomor.web.response.BaseResponse;

import java.util.List;

public interface CollectService {


    void collect(CollectRequest request);

    void cancelCollect(CancelCollectRequest request);

    BaseResponse<List<MomentDTO>> queryCollectVideo(PageRequest request);

}
