package me.luomor.web.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.luomor.dbo.LikeRelationDBO;
import me.luomor.dbo.MomentDBO;
import me.luomor.dbo.NotificationDBO;
import me.luomor.dbo.ShareDBO;
import me.luomor.enums.*;
import me.luomor.util.AssertUtils;
import me.luomor.util.UserContext;
import me.luomor.web.dao.mapper.MomentMapper;
import me.luomor.web.dao.mapper.MomentQueryMapper;
import me.luomor.web.dao.mapper.ShareMapper;
import me.luomor.web.dao.mapper.ShareQueryMapper;
import me.luomor.web.dto.LoginUserDTO;
import me.luomor.web.request.ShareRequest;
import me.luomor.web.service.NotificationService;
import me.luomor.web.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Slf4j
@Service
public class ShareServiceImpl implements ShareService {

    @Resource
    private MomentMapper momentMapper;
    @Resource
    private MomentQueryMapper momentQueryMapper;
    @Resource
    private ShareMapper shareMapper;
    @Resource
    private ShareQueryMapper shareQueryMapper;
    @Autowired
    private NotificationService notificationService;

    @Override
    @Transactional
    public void share(ShareRequest request) {

        LoginUserDTO loginUser = UserContext.getLoginUser();
        Long artistId = loginUser.getArtistId();
        Long userId = loginUser.getUserId();

        EnumSharePageType pageType = request.getPageType();
        Long momentId = request.getMomentId();
        ShareDBO shareDBO = new ShareDBO();
        shareDBO.setPageType(pageType.getValue());
        shareDBO.setArtistId(artistId);
        shareDBO.setMomentId(momentId);
        shareDBO.setUserId(userId);
        shareMapper.insertSelective(shareDBO);

        if (Objects.equals(pageType, EnumSharePageType.MOMENT_DETAIL)
                || Objects.equals(pageType, EnumSharePageType.VIDEO_DETAIL)) {

            MomentDBO momentDBO = momentQueryMapper.getById(artistId, momentId, EnumStatus.NORMAL.getValue());
            AssertUtils.notNull(momentDBO, "动态不存在：" + momentId);
            momentMapper.updateShareCount(artistId, momentId, 1);

            // 发消息
            if (Objects.equals(momentDBO.getType(), EnumMomentType.VIDEO.getValue())) {
                notificationService.sendNotification(NotificationDBO.builder()
                        .type(EnumNotificationType.SHARE_VIDEO.getValue())
                        .momentId(momentId)
                        .receiveUserId(momentQueryMapper.getUserId(artistId, momentId))
                        .build());
            } else {
                notificationService.sendNotification(NotificationDBO.builder()
                        .type(EnumNotificationType.SHARE_MOMENT.getValue())
                        .momentId(momentId)
                        .receiveUserId(momentQueryMapper.getUserId(artistId, momentId))
                        .build());
            }
        }
    }
}
