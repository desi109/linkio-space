package com.linkiospace.generator;

import java.util.Random;

public class IdGenerator {
    private static final char[] baseChars =
            "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
                    .toCharArray();

    private static final Random random = new Random();

    public static String GetBase36(int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(baseChars[random.nextInt(36)]);
        }

        return sb.toString();
    }

}
