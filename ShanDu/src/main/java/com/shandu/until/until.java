package com.shandu.until;

import com.qiniu.util.Auth;

import java.io.File;

public class until {
    public String File() {
        String accessKey = "yjbwxKKF19eg9KBuMCDDp48jnUkeVIfQsbqDEhCB";
        String secretKey = "GSHYnnDAhXt0hG2hiwy6ZMLOtNPfFsRml1skSRN5";
        String bucket = "shandu01";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);
        return upToken;
    }
}
