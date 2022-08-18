package me.luomor.web.dao.mapper;

import me.luomor.dbo.ShareDBO;

public interface ShareQueryMapper {
    ShareDBO selectByPrimaryKey(Long id);
}