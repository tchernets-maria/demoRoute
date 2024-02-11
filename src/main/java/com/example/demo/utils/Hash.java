package com.example.demo.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Hash {
    static public String get(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = digest.digest(s.getBytes(StandardCharsets.UTF_8));
            return convertByteArrayToHexString(hashedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error in Hash");
        }
    }

    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte arrayByte : arrayBytes) {
            stringBuilder.append(Integer.toString((arrayByte & 0xff) + 0x100, 16).substring(1));
        }
        return stringBuilder.toString();
    }
}
