package me.luomor.web.dao.mapper;

import me.luomor.dbo.RegionCityDBO;

import java.util.List;

public interface RegionCityQueryMapper {
    RegionCityDBO selectByPrimaryKey(String id);

    List<RegionCityDBO> queryAll();

}