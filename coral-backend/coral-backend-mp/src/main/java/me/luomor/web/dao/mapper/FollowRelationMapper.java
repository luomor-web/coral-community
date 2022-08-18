package me.luomor.web.dao.mapper;

import me.luomor.dbo.FollowRelationDBO;

public interface FollowRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FollowRelationDBO record);

    int insertSelective(FollowRelationDBO record);

    int updateByPrimaryKeySelective(FollowRelationDBO record);

    int updateByPrimaryKey(FollowRelationDBO record);

    void delete(FollowRelationDBO followRelationDBO);
}