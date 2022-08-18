package me.luomor.web.dao.mapper;

import me.luomor.dbo.PrivateLetterDBO;

public interface PrivateLetterMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PrivateLetterDBO record);

    int insertSelective(PrivateLetterDBO record);
    int updateByPrimaryKeySelective(PrivateLetterDBO record);

    int updateByPrimaryKey(PrivateLetterDBO record);
}