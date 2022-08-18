package me.luomor.web.service;

import me.luomor.web.dto.UserDTO;
import me.luomor.web.request.CancelLikeRequest;
import me.luomor.web.request.LikeRequest;
import me.luomor.web.request.QueryLikeUserRequest;
import me.luomor.web.response.BaseResponse;

import java.util.List;

public interface LikeService {


    void like(LikeRequest request);

    void cancelLike(CancelLikeRequest request);

    BaseResponse<List<UserDTO>> queryLikeUser(QueryLikeUserRequest request);

}
