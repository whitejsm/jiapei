package com.woniu.jiapei.tools;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class UploadFile {
    // 保存成功返回 路径，失败返回 null
    public static String saveFile(MultipartFile file, String realPath) {
        String fileName = file.getOriginalFilename();

        File dir = new File(realPath);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        fileName = UUID.randomUUID() + ".xlsx";
        File target = new File(dir, fileName);

        boolean flag = false;
        try {
            file.transferTo(target);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag ? target.getPath() : null;
    }
}
