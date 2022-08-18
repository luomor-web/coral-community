package me.luomor.web.service;

import me.luomor.web.dto.MomentImageDTO;
import me.luomor.web.request.QueryVideoCoverRequest;
import me.luomor.web.response.BaseResponse;

import java.util.List;

public interface VideoService {


    BaseResponse<List<MomentImageDTO>> queryVideoCover(QueryVideoCoverRequest request);

}
