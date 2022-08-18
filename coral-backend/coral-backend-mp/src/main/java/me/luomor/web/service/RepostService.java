package me.luomor.web.service;

import me.luomor.web.dto.RepostUserDTO;
import me.luomor.web.request.QueryRepostUserRequest;
import me.luomor.web.request.RepostRequest;
import me.luomor.web.response.BaseResponse;

import java.util.List;

public interface RepostService {

    BaseResponse repost(RepostRequest request);

    BaseResponse<List<RepostUserDTO>> queryRepostUser(QueryRepostUserRequest request);
}
