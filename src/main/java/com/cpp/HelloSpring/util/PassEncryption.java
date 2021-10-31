
package com.cpp.HelloSpring.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassEncryption {
    public static void main(String[] args) {
        var password = "123";
        System.out.println("Not encrytped password: "+ password);
        System.out.println("Encrypted password: "+ encryptPassword(password));
    }
    
    public static String encryptPassword (String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
