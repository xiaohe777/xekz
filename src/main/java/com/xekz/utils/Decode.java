package com.xekz.utils;

import java.security.MessageDigest;
import java.util.Base64;


public class Decode {

    public static String encode(String msg) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            return Base64.getDecoder().decode(messageDigest.digest(msg.getBytes())).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {
        System.out.println(encode("123456"));
    }

}
