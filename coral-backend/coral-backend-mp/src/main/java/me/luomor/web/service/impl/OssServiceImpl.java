package me.luomor.web.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.luomor.enums.EnumFileType;
import me.luomor.exception.BusinessException;
import me.luomor.util.FileTypeUtils;
import me.luomor.util.UUIDUtils;
import me.luomor.util.UserContext;
import me.luomor.web.service.OssService;
import me.luomor.web.util.oss.OssConfig;
import me.luomor.web.util.oss.OssUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class OssServiceImpl implements OssService {

    @Autowired
    private OssConfig ossConfig;

    @Override
    public String uploadImageOrVideo(MultipartFile file) throws Exception {
        log.info("开始上传");
        // 校验文件类型
        boolean isImage = checkFileTypeWithContentType(file);

        String artistName = UserContext.getLoginUser().getArtistName();

        String fileDir = artistName + (isImage ? "/image/" : "/video/");
        String filePath = fileDir + System.currentTimeMillis() + UUIDUtils.getUUID() + FileTypeUtils.getSuffix(file.getOriginalFilename());

        byte[] bytes = file.getBytes();

        long start = System.currentTimeMillis();
        OssUtils.uploadFile(bytes, filePath, file.getOriginalFilename());
        log.info("上传花费：" + (System.currentTimeMillis() - start));
        return ossConfig.getDomainUrl() + filePath;
    }

    private boolean checkFileTypeWithContentType(MultipartFile file) throws IOException {
        String contentType = file.getContentType();
        System.out.println(contentType);
        boolean isImage = StringUtils.endsWithIgnoreCase(contentType, "png")
                || StringUtils.endsWithIgnoreCase(contentType, "jpg")
                || StringUtils.endsWithIgnoreCase(contentType, "jpeg")
                || StringUtils.endsWithIgnoreCase(contentType, "gif");

        boolean isVideo = StringUtils.endsWithIgnoreCase(contentType, "flv")
                || StringUtils.endsWithIgnoreCase(contentType, "mp4")
                || StringUtils.endsWithIgnoreCase(contentType, "png")
                || StringUtils.endsWithIgnoreCase(contentType, "avi");

        if (!isImage && !isVideo) {
            throw new BusinessException("文件不是图片或视频");
        }
        return isImage;
    }

    private boolean checkFileType(MultipartFile file) throws IOException {
        boolean isImage = FileTypeUtils.checkFileType(file.getInputStream(),
                EnumFileType.PNG.toString(),
                EnumFileType.JPG.toString(),
                EnumFileType.GIF.toString());

        boolean isVideo = FileTypeUtils.checkFileType(file.getInputStream(),
                EnumFileType.FLV.toString(),
                EnumFileType.MP4.toString(),
                EnumFileType.PNG.toString(),
                EnumFileType.AVI.toString());

        if (!isImage && !isVideo) {
            throw new BusinessException("文件不是图片或视频");
        }
        return isImage;
    }
}
