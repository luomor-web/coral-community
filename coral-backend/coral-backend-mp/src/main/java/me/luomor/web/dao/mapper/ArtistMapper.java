package me.luomor.web.dao.mapper;

import me.luomor.dbo.ArtistDBO;

public interface ArtistMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArtistDBO record);

    int insertSelective(ArtistDBO record);
    int updateByPrimaryKeySelective(ArtistDBO record);

    int updateByPrimaryKey(ArtistDBO record);
}