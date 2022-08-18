package me.luomor.web.dao.mapper;

import me.luomor.dbo.VenueDBO;

public interface VenueQueryMapper {
    VenueDBO selectByPrimaryKey(Long id);
}