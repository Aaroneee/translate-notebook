package org.autumn.translateNotebook.utils;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaiduTransUtil {
    private final static String appId="20210918000949305";
    private final static String privateKey="2hSXC2uOnueWBh_U7CZv";

    public static SuccessResult getTransResult(String text,Integer type){
        Map<String,Object> map=new HashMap<>();

        Long salt=System.currentTimeMillis()/1000;
        String sign=appId+text+salt+privateKey;

        map.put("q",text);
        map.put("from","auto");
        map.put("to","en");
        map.put("appid",appId);
        map.put("salt",salt);
        map.put("sign", SecureUtil.md5(sign));

        String result = HttpRequest.post("https://fanyi-api.baidu.com/api/trans/vip/translate")
                .header(Header.CONTENT_TYPE, "application/x-www-form-urlencoded")//头信息，多个头信息多次调用此方法即可
                .form(map)//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();

        return JSONUtil.toBean(result, SuccessResult.class);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class SuccessResult{
        private String from;
        private String to;
        private List<SuccessResultList> transResult;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class SuccessResultList{
        private String src;
        private String dst;
    }

}

