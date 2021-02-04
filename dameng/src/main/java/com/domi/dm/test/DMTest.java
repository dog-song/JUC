package com.domi.dm.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Domi on 2020/11/12.
 */
@RestController
public class DMTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/get")
    public String test(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from JC.test1");
        System.out.println(list);
        System.out.println("The size is: " + list.size());
        return "over";
    }



    public static void main(String[] args) throws UnsupportedEncodingException {
//        String str = "yanalvjavaagent4lujin2å´å½¦ç¥1";
        String str = "yanalvjavaagent4lujin2å\\u0090´å½¦ç¥\\u00961";
//        String str = "{\"coll_time\":1608681613297,\"value\":{\"agent_id\":10197081336657886,\"nest_threadInfo\":[],\"heapMem\":{\"Max\":922746880,\"Used\":262834136,\"Committed\":392167424},\"data_version\":\"2.8.2\",\"appname_raw\":\"yanalvjavaagent4lujin2å\\u0090´å½¦ç¥\\u00961\",\"noHeapMem\":{\"Max\":-1,\"Used\":68097920,\"Committed\":69746688},\"threadStatis\":{},\"nest_memPool\":[{\"committed\":450399\n" +
//                "616,\"max\":-1,\"name_raw\":\"Metaspace\",\"used\":43988264},{\"committed\":90177536,\"max\":692060160,\"name_raw\":\"PS Old Gen\",\"used\":55992168},{\"committed\":5242880,\"max\":1073741824,\"name_raw\":\"Compressed Class Space\",\"used\":4856728},{\"committed\":33030144,\"max\":33030144,\"name_raw\":\"PS Survivor Space\",\"used\":7663248},{\"committed\":268959744,\"max\":276824064,\"name_raw\":\"PS Eden Space\",\"used\":199178720}," +
//                "{\"committed\":19464192,\"max\":251658240,\"name_raw\":\"Code Cache\",\"used\":19252928}],\"host_id\":7691600115966085,\"resp_status\":1,\"nest_GCS\":[],\"service_type\":214,\"account_id\":1,\"service_qualifier\":\"214x1000\",\"ti\":\"27\",\"uuid_raw\":\"\",\"startTime\":1608641700086,\"tn\":\"jmxmonitor\",\"user_dir_raw\":\"10.0.1.25%3A%2Fdata%2Fyana%2Fjavaagent4%2Fapache-tomcat-7.0.64%2Fbin\",\"cpu_usage\":0.28,\"jvmColltime\":1608681613295,\"jvmVersion_raw\":\"25.251-b08\"}}";
//        String str = "{\"coll_time\":1608717028784,\"value\":{\"agent_id\":1780480094181806,\"nest_threadInfo\":[],\"heapMem\":{\"Max\":3817865216,\"Used\":13353048,\"Committed\":257425408},\"data_version\":\"2.7.4\",\"appname_raw\":\"æµ\\u008Bè¯\\u0095ä¸\u00ADæ\\u0096\\u0087\",\"noHeapMem\":{\"Max\":-1,\"Used\":18034880,\"Committed\":19857408},\"threadStatis\":{},\"nest_memPool\":[{\"committed\":14811136,\"max\":-1,\"name_raw\":\"Metaspace\",\"used\":14317504},{\"committed\":179306496,\"max\":2863661056,\"name_raw\":\"PS Old Gen\",\"used\":8192},{\"committed\":1703936,\"max\":1073741824,\"name_raw\":\"Compressed Class Space\",\"used\":1608576},{\"committed\":11010048,\"max\":11010048,\"name_raw\":\"PS Survivor Space\",\"used\":7438384},{\"committed\":67108864,\"max\":1409286144,\"name_raw\":\"PS Eden Space\",\"used\":3798192},{\"committed\":2555904,\"max\":251658240,\"name_raw\":\"Code Cache\",\"used\":1615680}],\"host_id\":6168692423878378,\"resp_status\":1,\"nest_GCS\":[{\"count\":2,\"name_raw\":\"PS Scavenge\",\"time\":12}],\"service_type\":214,\"account_id\":172420,\"service_qualifier\":\"214x1000\",\"ti\":\"27\",\"uuid_raw\":\"\",\"startTime\":1608717026360,\"tn\":\"jmxmonitor\",\"user_dir_raw\":\"10.0.23.89%3A%2FUsers%2Ftaokailang%2FIdeaProjects%2Fdemo\",\"cpu_usage\":1.0E-5,\"jvmColltime\":1608717028558,\"jvmVersion_raw\":\"25.231-b11\"}}";

//        String str = "{\"username\":\"é\u0083\u008Eæ\u009C\u0097\",\"password\":\"1233344\"}";

        str = UnicodeToCN(str);
        System.out.println("UnicodeToCN 后: " + str);

        String str1 = getEncoding(str);
        System.out.println("编码是: "+str1);

        //转码 utf-8
        String newName=new String(str.getBytes(str1),"UTF-8");
        System.out.println("转码后: " +newName);


//        str = UnicodeToCN(str);
//        System.out.println(str);
    }

    /**
     * unicode编码转换为汉字
     * @param unicodeStr 待转化的编码
     * @return 返回转化后的汉子
     */
    public static String UnicodeToCN(String unicodeStr) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(unicodeStr);
        char ch;
        while (matcher.find()) {
            //group
            String group = matcher.group(2);
            //ch:'李四'
            ch = (char) Integer.parseInt(group, 16);
            //group1
            String group1 = matcher.group(1);
            unicodeStr = unicodeStr.replace(group1, ch + "");
        }
        return unicodeStr.replace("\\", "").trim();
    }


    /**
     *  判断字符编码集
     * @Param [str]
     * @return java.lang.String
     **/
    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }
}
