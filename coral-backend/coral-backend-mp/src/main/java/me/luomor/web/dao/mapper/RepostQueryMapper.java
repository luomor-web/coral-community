package me.luomor.web.dao.mapper;

import me.luomor.dbo.RepostDBO;

public interface RepostQueryMapper {
    RepostDBO selectByPrimaryKey(Long id);
}