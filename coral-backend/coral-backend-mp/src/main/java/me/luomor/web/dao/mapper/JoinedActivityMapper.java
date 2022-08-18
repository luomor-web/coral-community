package me.luomor.web.dao.mapper;

import me.luomor.dbo.JoinedActivityDBO;

public interface JoinedActivityMapper {

    int insertSelective(JoinedActivityDBO record);

    int updateByPrimaryKeySelective(JoinedActivityDBO record);

    void delete(JoinedActivityDBO dbo);

}