package me.luomor.web.service;

import me.luomor.web.dto.CommentDTO;
import me.luomor.web.request.GetCommentDetailRequest;
import me.luomor.web.request.PublishCommentRequest;
import me.luomor.web.request.DeleteCommentRequest;
import me.luomor.web.request.QueryMomentCommentRequest;
import me.luomor.web.response.BaseResponse;

import java.util.List;

public interface CommentService {


    BaseResponse<Long> publishComment(PublishCommentRequest request);

    BaseResponse deleteComment(DeleteCommentRequest request);

    BaseResponse<List<CommentDTO>> queryMomentComment(QueryMomentCommentRequest request);

    BaseResponse<CommentDTO> getCommentDetail(GetCommentDetailRequest request);

}
