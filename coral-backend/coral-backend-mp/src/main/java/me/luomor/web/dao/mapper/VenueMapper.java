package me.luomor.web.dao.mapper;

import me.luomor.dbo.VenueDBO;

public interface VenueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueDBO record);

    int insertSelective(VenueDBO record);
    int updateByPrimaryKeySelective(VenueDBO record);

    int updateByPrimaryKey(VenueDBO record);
}