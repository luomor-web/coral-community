package me.luomor.web.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.luomor.dbo.MomentVideoDBO;
import me.luomor.dbo.NotificationDBO;
import me.luomor.enums.EnumMomentType;
import me.luomor.enums.EnumNotificationType;
import me.luomor.util.AssertUtils;
import me.luomor.util.PageUtils;
import me.luomor.web.dao.mapper.*;
import me.luomor.dbo.CollectRelationDBO;
import me.luomor.web.dto.LoginUserDTO;
import me.luomor.enums.EnumCollectTargetType;
import me.luomor.web.dto.MomentDTO;
import me.luomor.web.request.CancelCollectRequest;
import me.luomor.web.request.CollectRequest;
import me.luomor.web.request.PageRequest;
import me.luomor.web.request.QuerySquareMomentRequest;
import me.luomor.web.response.BaseResponse;
import me.luomor.web.service.CollectService;
import me.luomor.util.UserContext;
import me.luomor.web.service.MomentService;
import me.luomor.web.service.NotificationService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CollectServiceImpl implements CollectService {

    @Resource
    private CollectRelationMapper collectRelationMapper;
    @Resource
    private CollectRelationQueryMapper collectRelationQueryMapper;
    @Resource
    private MomentVideoMapper momentVideoMapper;
    @Resource
    private MomentVideoQueryMapper momentVideoQueryMapper;
    @Resource
    private MomentMapper momentMapper;
    @Resource
    private MomentQueryMapper momentQueryMapper;
    @Autowired
    private MomentService momentService;
    @Autowired
    private NotificationService notificationService;

    @Override
    @Transactional
    public void collect(CollectRequest request) {

        LoginUserDTO loginUser = UserContext.getLoginUser();
        Long artistId = loginUser.getArtistId();
        Long userId = loginUser.getUserId();

        EnumCollectTargetType targetType = request.getTargetType();
        Long targetId = request.getTargetId();
        if (Objects.equals(targetType, EnumCollectTargetType.VIDEO)) {

            MomentVideoDBO momentVideoDBO = momentVideoQueryMapper.selectByPrimaryKey(artistId, targetId);
            AssertUtils.notNull(momentVideoDBO, "视频不存在：" + targetId);
            collectRelationMapper.insertSelective(new CollectRelationDBO(userId, targetType.getValue(), targetId, artistId));
            momentVideoMapper.updateCollectCount(targetId, artistId, 1);

            // 发消息
            notificationService.sendNotification(NotificationDBO.builder()
                    .type(EnumNotificationType.COLLECT_VIDEO.name())
                    .momentId(momentVideoDBO.getMomentId())
                    .receiveUserId(momentQueryMapper.getUserId(artistId, momentVideoDBO.getMomentId()))
                    .build());
        }

    }

    @Override
    @Transactional
    public void cancelCollect(CancelCollectRequest request) {
        LoginUserDTO loginUser = UserContext.getLoginUser();
        Long artistId = loginUser.getArtistId();
        Long userId = loginUser.getUserId();

        EnumCollectTargetType targetType = request.getTargetType();
        Long targetId = request.getTargetId();
        if (Objects.equals(targetType, EnumCollectTargetType.VIDEO)) {
            collectRelationMapper.delete(new CollectRelationDBO(userId, targetType.getValue(), targetId, artistId));
            momentVideoMapper.updateCollectCount(targetId, artistId, -1);
        }
    }

    @Override
    public BaseResponse<List<MomentDTO>> queryCollectVideo(PageRequest request) {
        BaseResponse<List<MomentDTO>> response = new BaseResponse<>();
        LoginUserDTO loginUser = UserContext.getLoginUser();
        Long artistId = loginUser.getArtistId();
        Long userId = loginUser.getUserId();

        Integer pageNo = request.getPageNo();
        Integer pageSize = request.getPageSize();
        int start = PageUtils.getStart(pageNo, pageSize);
        List<CollectRelationDBO> collectRelationDBOList = collectRelationQueryMapper.queryByUserTargetType(artistId, userId, EnumCollectTargetType.VIDEO.getValue(), start, pageSize);
        if (CollectionUtils.isEmpty(collectRelationDBOList)) {
            response.setBody(new ArrayList<>());
            return response;
        }

        List<Long> videoIdList = collectRelationDBOList.stream().map(CollectRelationDBO::getTargetId).collect(Collectors.toList());
        List<MomentVideoDBO> videoDBOList = momentVideoQueryMapper.queryByIds(artistId, videoIdList);
        if (CollectionUtils.isEmpty(videoDBOList)) {
            response.setBody(new ArrayList<>());
            return response;
        }

        List<Long> momentIdList = videoDBOList.stream().map(MomentVideoDBO::getMomentId).collect(Collectors.toList());

        List<MomentDTO> momentDTOList = momentService.queryMoment(artistId, userId, EnumMomentType.VIDEO.getValue(), 0L, null, null, momentIdList, null, null);
        response.setBody(momentDTOList);
        return response;
    }
}
