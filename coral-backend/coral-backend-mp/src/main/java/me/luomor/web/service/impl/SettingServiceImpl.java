package me.luomor.web.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.luomor.dbo.FeedbackDBO;
import me.luomor.dbo.RegionCityDBO;
import me.luomor.util.BeanCopyUtils;
import me.luomor.util.UserContext;
import me.luomor.web.dao.mapper.FeedbackMapper;
import me.luomor.web.dao.mapper.RegionCityMapper;
import me.luomor.web.dao.mapper.RegionCityQueryMapper;
import me.luomor.web.dto.LoginUserDTO;
import me.luomor.web.dto.RegionCityDTO;
import me.luomor.web.request.AddFeedbackRequest;
import me.luomor.web.response.BaseResponse;
import me.luomor.web.service.SettingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class SettingServiceImpl implements SettingService {

    @Resource
    private FeedbackMapper feedbackMapper;
    @Resource
    private RegionCityQueryMapper regionCityQueryMapper;


    @Override
    public BaseResponse addFeedback(AddFeedbackRequest request) {
        BaseResponse response = new BaseResponse();
        LoginUserDTO loginUser = UserContext.getLoginUser();
        Long artistId = loginUser.getArtistId();
        Long userId = loginUser.getUserId();

        String type = request.getType().getValue();
        String content = request.getContent();
        String contactInfo = request.getContactInfo();

        FeedbackDBO dbo = new FeedbackDBO();
        dbo.setType(type);
        dbo.setContactInfo(contactInfo);
        dbo.setContent(content);
        dbo.setArtistId(artistId);
        dbo.setUserId(userId);
        feedbackMapper.insertSelective(dbo);

        return response;
    }

    @Override
    public BaseResponse<List<RegionCityDTO>> queryCity() {
        BaseResponse<List<RegionCityDTO>> response = new BaseResponse<>();

        List<RegionCityDBO> dboList = regionCityQueryMapper.queryAll();
        List<RegionCityDTO> dtoList = BeanCopyUtils.copy(dboList, RegionCityDTO.class);
        response.setBody(dtoList);
        return response;
    }
}
