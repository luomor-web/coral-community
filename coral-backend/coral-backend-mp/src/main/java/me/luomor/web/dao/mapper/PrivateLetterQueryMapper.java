package me.luomor.web.dao.mapper;

import me.luomor.dbo.PrivateLetterDBO;

public interface PrivateLetterQueryMapper {
    PrivateLetterDBO selectByPrimaryKey(Long id);
}