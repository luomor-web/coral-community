package me.luomor.web.dao.mapper;

import me.luomor.dbo.FeedbackDBO;

public interface FeedbackQueryMapper {
    FeedbackDBO selectByPrimaryKey(Long id);
}