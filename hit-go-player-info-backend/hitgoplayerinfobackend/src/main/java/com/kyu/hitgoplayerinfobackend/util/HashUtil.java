package com.kyu.hitgoplayerinfobackend.util;
import org.mindrot.jbcrypt.BCrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashUtil {
    public static String hashBCrypt(String s){
        return BCrypt.hashpw(s,BCrypt.gensalt(12));
    }

    public static String hashSha256(String s){
        try {
            MessageDigest md= MessageDigest.getInstance("SHA-256");
            return Base64.getEncoder().encodeToString(md.digest(s.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
    public static boolean checkBCrypt(String s, String sHashed){
        return BCrypt.checkpw(s, sHashed);
    }

}
