package br.com.centralerros.application.utils;

public class StringUtils {
    public static boolean isNullOrWhiteSpace(String string){
        return string == null || string.trim().isEmpty();
    }
}
