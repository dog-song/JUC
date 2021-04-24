package com.domi.disruptor.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/4/17.
 */
public class Test {


    public static void main(String[] args) {

        /*String str = "%7B%0A%20%20%20%20%22agentId%22%3A%205914108851862568%2C%0A%20%20%20%20%22accountId%22%3A%20172420%2C%0A%20%20%20%20%22hostId%22%3A%2010251694837706538%2C%0A%20%20%20%20%22appId%22%3A%205355380039456538%0A%7D";

        String str2 = "{\"%%agentId\": 5914108851862568,\"%%accountId\": 172420,\"hostId\": 10251694837706538,\"appId\": 5355380039456538}";

        String str3 = "{\"%7B\":7011}";

        String str4 = "%7B%22%257B%22:7011%7D";

        String str5 = "%7B%2277%22:7011%7D";

        if (UrlEncoderUtils.hasUrlEncoded(str)) {
            System.out.println("1111");
        } else {
            System.out.println("00000");
        }*/


        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);


        String str = "/flights/fuzzy,/flights/booking/BJS-DLC.do";

        List<String> stringList = new ArrayList<>();

        stringList = StringUtil.string2ArrayList(str);

        System.out.println(stringList);

    }


}
