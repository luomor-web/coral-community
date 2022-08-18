package me.luomor.web.service;

import me.luomor.web.dto.FriendCountDTO;
import me.luomor.web.dto.UserDTO;
import me.luomor.web.request.CancelFollowRequest;
import me.luomor.web.request.FollowRequest;
import me.luomor.web.request.QueryFriendRequest;
import me.luomor.web.response.BaseResponse;

import java.util.List;

public interface FollowService {

    void follow(FollowRequest request);

    void cancelFollow(CancelFollowRequest request);

    BaseResponse<List<UserDTO>> queryFriend(QueryFriendRequest request);

    BaseResponse<FriendCountDTO> countFriend();

}

