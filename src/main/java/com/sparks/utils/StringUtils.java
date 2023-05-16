package com.sparks.utils;

public class StringUtils {

    public static String trimText(String text, String textToRemove) {
        String result = text;

        Boolean textIsOnStart = text.indexOf(textToRemove) == 0;
        Boolean textIsOnEnd = text.indexOf(textToRemove, text.length() - textToRemove.length()) != -1;

        if (textIsOnStart) {
            result = result.substring(textToRemove.length());
        }

        if (textIsOnEnd) {
            result = result.substring(0, result.length() - textToRemove.length());
        }

        return result;
    }

    public static String removeBackSlash(String text) {
        return text.replaceAll("\\\\", "");
    }

}
