package net.hackertalk.model.util;

import java.util.Base64;

public class Cursor {

    public static Long decode(String token) {
        return Long.valueOf(new String(Base64.getDecoder().decode(token)));
    }

    public static String encode(Long id) {
        return Base64.getEncoder().encodeToString(id.toString().getBytes());
    }
}
