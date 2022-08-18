package me.luomor.web.dao.mapper;

import me.luomor.dbo.ArtistDBO;

public interface ArtistQueryMapper {
    ArtistDBO selectByPrimaryKey(Long id);

    ArtistDBO getByRandomKey(String randomKey);

}