package me.luomor.web.dao.mapper;

import me.luomor.dbo.TopicRelationDBO;

import java.util.List;

public interface TopicRelationMapper {

    void insertBatch(List<TopicRelationDBO> dboList);

}