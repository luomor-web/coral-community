package me.luomor.web.dao.mapper;

import me.luomor.dbo.TagRelationDBO;

public interface TagRelationQueryMapper {
    TagRelationDBO selectByPrimaryKey(Long id);
}