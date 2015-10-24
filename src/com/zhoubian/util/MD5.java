/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zhoubian.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 */
public class MD5 {
	/**
	 * 
	 * @param plainText
	 * @return
	 */
	public static String md5s(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4',  
                '5', '6', '7', '8', '9',  
                'A', 'B', 'C', 'D', 'E', 'F' };  
        try {  
            byte[] btInput = s.getBytes();  
            //获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            //使用指定的字节更新摘要  
            mdInst.update(btInput);  
            //获得密文  
            byte[] md = mdInst.digest();  
            //把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        }  
        catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
		
		// try {
		// //确定使用md5加密
		// MessageDigest md = MessageDigest.getInstance("MD5");
		// //加密
		// md.update(plainText.getBytes());
		// //加密后得到byte,在转化为字符串�?yy
		// byte b[] = md.digest();
		// int i;
		// StringBuilder buf = new StringBuilder("");
		// for (int offset = 0; offset < b.length; offset++) {
		// i = b[offset];
		// if (i < 0) {
		// i += 256;
		// }
		// if (i < 16) {
		// buf.append("0");
		// }
		// buf.append(Integer.toHexString(i));
		// }
		// buf.toString();
		// return buf.toString();
		//
		// } catch (NoSuchAlgorithmException e) {
		// return null;
		// }
	}
}
