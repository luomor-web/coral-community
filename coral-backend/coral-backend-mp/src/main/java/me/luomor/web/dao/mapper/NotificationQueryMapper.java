package me.luomor.web.dao.mapper;

import me.luomor.dbo.NotificationDBO;
import me.luomor.enums.EnumNotificationCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NotificationQueryMapper {
    NotificationDBO selectByPrimaryKey(Long id);

    List<NotificationDBO> queryByCategory(@Param("artistId") Long artistId, @Param("category") String category,
                                          @Param("receiveUserId") Long receiveUserId, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

}