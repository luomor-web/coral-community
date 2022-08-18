package me.luomor.web.dao.mapper;

import me.luomor.dbo.TagDBO;

public interface TagQueryMapper {
    TagDBO selectByPrimaryKey(Long id);
}