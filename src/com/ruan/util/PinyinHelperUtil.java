package com.ruan.util;

import net.sourceforge.pinyin4j.PinyinHelper;

public class PinyinHelperUtil {
    // 传出字符串，获取拼音字母大写
    public static String convertStringToUpperCase(String str){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            String[] arr = PinyinHelper.toHanyuPinyinStringArray(chr);
            if(arr != null){
                builder.append(arr[0].charAt(0));
            }else{
                builder.append(chr);
            }
        }
        return builder.toString().toUpperCase();
    }
}
