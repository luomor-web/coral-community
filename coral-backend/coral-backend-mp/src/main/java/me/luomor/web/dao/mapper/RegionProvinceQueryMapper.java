package me.luomor.web.dao.mapper;

import me.luomor.dbo.RegionProvinceDBO;

public interface RegionProvinceQueryMapper {
    RegionProvinceDBO selectByPrimaryKey(String id);
}