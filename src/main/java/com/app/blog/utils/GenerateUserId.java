package com.app.blog.utils;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class GenerateUserId {
	
    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyz";

    public String genUserID(int length) {

        StringBuilder userId = new StringBuilder(length);

        for (int i= 0 ; i < length; i++){
            userId.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return userId.toString();

    }
           
}