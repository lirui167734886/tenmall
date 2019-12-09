package com.cn.wanxi.mall.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO //往前端返回信息时的Map包装
 * @ClassName: ReplyMapUtil
 * @Author: Mr.WuGuo
 * @Date: 2019/12/4 14:32
 */
@Component
public class ReplyMapUtil {

    /**
     * @Description: //TODO 返回的Map中没有数据，仅仅告诉前端操作的情况
     * @Param: [message, code]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 15:13 2019/12/4
     **/
    public Map<String,Object> getReply(String message, Integer code){
        Map<String,Object> replyMap=new HashMap<>(2);
        replyMap.put("message",message);
        replyMap.put("code",code);
        return replyMap;
    }

    /**
     * @Description: //TODO 返回操作情况以及请求的数据
     * @Param: [message, code, object]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 15:15 2019/12/4
     **/
    public Map<String,Object> getReply(String message, Integer code, Object object){
        Map<String,Object> replyMap=new HashMap<>(3);
        replyMap.put("message",message);
        replyMap.put("code",code);
        replyMap.put("data",object);
        return replyMap;
    }
}
