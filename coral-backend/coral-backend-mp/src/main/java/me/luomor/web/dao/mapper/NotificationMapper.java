package me.luomor.web.dao.mapper;

import me.luomor.dbo.NotificationDBO;

public interface NotificationMapper {

    int insertSelective(NotificationDBO record);

}