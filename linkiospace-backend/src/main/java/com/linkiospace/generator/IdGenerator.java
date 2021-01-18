package com.linkiospace.generator;

import com.linkiospace.repositories.UserRepository;


import java.util.Random;
import java.util.Set;

public class IdGenerator {

    private static final char[] baseChars =
            "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
                    .toCharArray();

    private static Random random = new Random();


    public static String getBase36(int length, Set<String> userCodes, String newUserCode) {

        if (userCodes.contains(newUserCode)) {
            newUserCode = generateBase36(length);
            return getBase36(length, userCodes, newUserCode);
        }
            return newUserCode;
    }

    public static String generateBase36(int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(baseChars[random.nextInt(36)]);
        }

        return sb.toString();
    }
}
