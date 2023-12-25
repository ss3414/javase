package javautil.security;

import lombok.SneakyThrows;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.MessageDigest;

public class Security {

    @SneakyThrows
    public static String HmacSHA256(String key, String message) {
        Mac HmacSHA256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        HmacSHA256.init(secretKeySpec);
        byte[] bytes = HmacSHA256.doFinal(message.getBytes());
        BigInteger bigInteger = new BigInteger(1, bytes);
        String str = bigInteger.toString(16);
        return str;
    }

    @SneakyThrows
    public static String MD5(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes());
        String md5 = new BigInteger(1, messageDigest.digest()).toString(16);
        return md5;
    }

}
