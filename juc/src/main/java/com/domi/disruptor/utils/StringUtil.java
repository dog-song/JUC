package com.domi.disruptor.utils;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/4/10.
 */
public abstract class StringUtil {

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str.trim().length()==0;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(CharSequence cs) {
        return !StringUtil.isBlank(cs);
    }

    public static String obj2String (Object o) {
        return o == null ? "" : o.toString();
    }


    public static List<String> string2ArrayList(String str) {
        List<String> list = new ArrayList<String>();
        if (null != str) {
            try {
                str = StringEscapeUtils.unescapeJava(str);
                // str = str.substring(0,str.length());
                String[] a = str.split(",");
                for (String s : a) {
                    String b = s.trim();
                    list.add(b);
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
