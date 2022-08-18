package me.luomor.web.service;

import me.luomor.web.dto.RegionCityDTO;
import me.luomor.web.dto.TopicDTO;
import me.luomor.web.request.AddFeedbackRequest;
import me.luomor.web.request.GetTopicDetailRequest;
import me.luomor.web.request.QueryTopicRequest;
import me.luomor.web.request.UpdateTopicCoverUrlRequest;
import me.luomor.web.response.BaseResponse;

import java.util.List;

public interface TopicService {

    BaseResponse<List<TopicDTO>> queryTopic(QueryTopicRequest request);

    BaseResponse<TopicDTO> getTopicDetail(GetTopicDetailRequest request);

    BaseResponse updateTopicCoverUrl(UpdateTopicCoverUrlRequest request);
}
