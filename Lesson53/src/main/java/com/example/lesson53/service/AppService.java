package com.example.lesson53.service;


import org.apache.commons.lang3.StringUtils;

public class AppService {
    public int findIndexSubstring(String text, String substring){
        if (StringUtils.containsIgnoreCase(text, substring) && !substring.isBlank()){
            return text.toLowerCase().indexOf(substring.toLowerCase());
        }else
        return -1;
    }
}
