package me.luomor.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.luomor.web.request.AddTagRequest;
import me.luomor.web.response.BaseResponse;
import me.luomor.web.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "标签")
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @ApiOperation(value = "添加标签")
    @PostMapping(value = "/addTag")
    public BaseResponse addTag(AddTagRequest request) {

        tagService.addTag(request);
        return new BaseResponse();
    }

}
