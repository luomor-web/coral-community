package me.luomor.web.dao.mapper;

import me.luomor.dbo.LikeRelationDBO;

public interface LikeRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LikeRelationDBO record);

    int insertSelective(LikeRelationDBO record);

    int updateByPrimaryKeySelective(LikeRelationDBO record);

    int updateByPrimaryKey(LikeRelationDBO record);

    void delete(LikeRelationDBO likeRelationDBO);
}