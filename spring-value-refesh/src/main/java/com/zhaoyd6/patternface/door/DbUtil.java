package com.zhaoyd6.patternface.door;

import java.util.HashMap;
import java.util.Map;

/**
 *  @Description: 模拟从db中获取邮件配置信息
 *  @author: zhao_yd
 *  @Date: 2021/6/29 5:04 下午
 *
 */

public class DbUtil {

    public static Map<String, Object> getMailInfoFromDb() {
        Map<String, Object> result = new HashMap<>();
        result.put("mail.host", "smtzxp.qq.com");
        result.put("mail.username", "xxd");
        result.put("mail.password", "234444");
        return result;
    }
}
