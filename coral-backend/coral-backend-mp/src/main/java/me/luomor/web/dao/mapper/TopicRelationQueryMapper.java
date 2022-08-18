package me.luomor.web.dao.mapper;

import me.luomor.dbo.TopicRelationDBO;
import me.luomor.web.dto.GroupCountDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicRelationQueryMapper {
    TopicRelationDBO selectByPrimaryKey(Long id);

    List<TopicRelationDBO> queryByTopicId(@Param("artistId") Long artistId, @Param("topicId") Long topicId,
                                          @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    List<GroupCountDTO> countByTopicId(@Param("artistId") Long artistId, @Param("topicIdList") List<Long> topicIdList);

    int countUserByTopicId(@Param("artistId") Long artistId, @Param("topicId") Long topicId);
}