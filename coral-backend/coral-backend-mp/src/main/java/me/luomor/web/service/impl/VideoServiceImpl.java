package me.luomor.web.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.luomor.web.dto.MomentImageDTO;
import me.luomor.web.request.QueryVideoCoverRequest;
import me.luomor.web.response.BaseResponse;
import me.luomor.web.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class VideoServiceImpl implements VideoService {


    @Override
    public BaseResponse<List<MomentImageDTO>> queryVideoCover(QueryVideoCoverRequest request) {
        BaseResponse<List<MomentImageDTO>> response = new BaseResponse<>();
        List<MomentImageDTO> list = new ArrayList<>();
        response.setBody(list);
        MomentImageDTO dto = new MomentImageDTO();
        dto.setUrl("https://p1.music.126.net/lWdsaWpQF7jhfdAwARNKWg==/109951164982312646?imageView&thumbnail=183x103");
        dto.setWidth(260);
        dto.setHeight(146);
        list.add(dto);
        list.add(dto);
        list.add(dto);
        list.add(dto);
        list.add(dto);
        String videoPath = request.getVideoPath();

        return response;
    }
}
