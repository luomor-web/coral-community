package me.luomor.web.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.luomor.dbo.RegionCityDBO;
import me.luomor.dbo.RegionProvinceDBO;
import me.luomor.dbo.UserDBO;
import me.luomor.enums.EnumGender;
import me.luomor.util.BeanCopyUtils;
import me.luomor.util.UserContext;
import me.luomor.web.dao.mapper.*;
import me.luomor.web.dto.LoginUserDTO;
import me.luomor.web.dto.UserDTO;
import me.luomor.web.request.GetUserInfoRequest;
import me.luomor.web.request.UpdateUserInfoRequest;
import me.luomor.web.response.BaseResponse;
import me.luomor.web.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserQueryMapper userQueryMapper;
    @Resource
    private RegionCityQueryMapper regionCityQueryMapper;
    @Resource
    private RegionProvinceQueryMapper regionProvinceQueryMapper;

    @Override
    public BaseResponse<UserDTO> getUserInfo(GetUserInfoRequest request) {
        BaseResponse<UserDTO> response = new BaseResponse<>();
        LoginUserDTO loginUser = UserContext.getLoginUser();
        Long userId = loginUser.getUserId();
        Long artistId = loginUser.getArtistId();

        if (request.getUserId() != null) {
            userId = request.getUserId();
        }

        UserDBO userDBO = userQueryMapper.getById(artistId, userId);
        UserDTO dto = BeanCopyUtils.copy(userDBO, UserDTO.class);
        response.setBody(dto);
        return response;
    }

    @Override
    public BaseResponse updateUserInfo(UpdateUserInfoRequest request) {
        BaseResponse response = new BaseResponse<>();
        LoginUserDTO loginUser = UserContext.getLoginUser();
        Long userId = loginUser.getUserId();
        Long artistId = loginUser.getArtistId();

        UserDBO dbo = BeanCopyUtils.copy(request, UserDBO.class);
        dbo.setArtistId(artistId);
        dbo.setId(userId);

        EnumGender gender = request.getGender();
        if (Objects.nonNull(gender)) {
            dbo.setGender(gender.getValue());
        }

        String cityId = request.getCityId();
        if (StringUtils.isNotBlank(cityId)) {
            RegionCityDBO city = regionCityQueryMapper.selectByPrimaryKey(cityId);
            if (Objects.nonNull(city)) {
                String provinceId = city.getProvinceId();
                RegionProvinceDBO province = regionProvinceQueryMapper.selectByPrimaryKey(provinceId);
                if (Objects.nonNull(province)) {
                    dbo.setProvince(province.getName());
                    dbo.setCity(city.getName());
                }
            }
        }

        userMapper.updateByPrimaryKeySelective(dbo);
        return response;
    }
}
