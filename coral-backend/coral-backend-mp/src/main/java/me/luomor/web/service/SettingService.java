package me.luomor.web.service;

import me.luomor.web.dto.RegionCityDTO;
import me.luomor.web.dto.RepostUserDTO;
import me.luomor.web.request.AddFeedbackRequest;
import me.luomor.web.request.QueryRepostUserRequest;
import me.luomor.web.request.RepostRequest;
import me.luomor.web.response.BaseResponse;

import java.util.List;

public interface SettingService {

    BaseResponse addFeedback(AddFeedbackRequest request);

    BaseResponse<List<RegionCityDTO>> queryCity();

}
