package com.erguotou.utils;

import java.util.Random;

public class StringUtil {
    public static String getRandomString(int length){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i<length; i++){
//            生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n
            int number = random.nextInt(base.length());
//            String.charAt方法返回指定索引位置的值   buffer.append方法拼接字符串
//            往已有的字符串对象后面添加字符
            buffer.append(base.charAt(number));
        }
        return buffer.toString();
    }
}
