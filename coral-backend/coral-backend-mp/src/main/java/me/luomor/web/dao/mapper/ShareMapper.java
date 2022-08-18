package me.luomor.web.dao.mapper;

import me.luomor.dbo.ShareDBO;

public interface ShareMapper {

    int insertSelective(ShareDBO record);
}