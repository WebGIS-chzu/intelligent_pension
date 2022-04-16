package com.common;

import java.util.UUID;

public class SortUtil {

    public static String getSalt(){
        String salt = UUID.randomUUID().toString().replace("-","").substring(0,5);
        return salt;
    }

    public static String getRandomString(Integer begin,Integer end){
        String randomString = UUID.randomUUID().toString().replace("-","").substring(0,8);
        return randomString;
    }
}
