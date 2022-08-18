package me.luomor.web.service;

import me.luomor.web.dto.ActivityDTO;
import me.luomor.web.request.JoinedActivityRequest;
import me.luomor.web.request.PageRequest;
import me.luomor.web.request.QueryActivityRequest;
import me.luomor.web.response.BaseResponse;

import java.util.List;

public interface ActivityService {

    BaseResponse<List<ActivityDTO>> queryActivity(QueryActivityRequest request);

    BaseResponse joinedActivity(JoinedActivityRequest request);

    BaseResponse<List<ActivityDTO>> queryJoinedActivity(PageRequest request);

}
