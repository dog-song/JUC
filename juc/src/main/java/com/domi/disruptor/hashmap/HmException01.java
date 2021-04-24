package com.domi.disruptor.hashmap;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author domisong.
 * @description: hashmap 异常测试
 * @date 2021/4/11.
 */
public class HmException01 {


    /**
     * 仅限于 1.7 版本：
     *         hashmap 异常测试
     *
     * @description: TODO
     * @param args
     * @return void
     * @author domisong.
     * @date: 2021/4/11.
     */
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("1", "1");
        hashMap.put("2", "2");

        Iterator i$ = hashMap.keySet().iterator();

        // fast-fail 机制
        while (i$.hasNext()) {
            String key = (String) i$.next();
            if ("2".equals(key)) {
                hashMap.remove(key);
                i$.remove();
            }
        }
    }
}
