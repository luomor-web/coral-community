package me.luomor.web.dao.mapper;

import me.luomor.dbo.CollectRelationDBO;

public interface CollectRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CollectRelationDBO record);

    int insertSelective(CollectRelationDBO record);
    int updateByPrimaryKeySelective(CollectRelationDBO record);

    int updateByPrimaryKey(CollectRelationDBO record);

    void delete(CollectRelationDBO collectRelationDBO);

}