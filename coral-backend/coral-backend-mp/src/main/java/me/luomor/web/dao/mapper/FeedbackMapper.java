package me.luomor.web.dao.mapper;

import me.luomor.dbo.FeedbackDBO;

public interface FeedbackMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FeedbackDBO record);

    int insertSelective(FeedbackDBO record);
    int updateByPrimaryKeySelective(FeedbackDBO record);

    int updateByPrimaryKey(FeedbackDBO record);
}