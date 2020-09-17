package com.hank.ws.utils;

import java.lang.Math;
import java.util.Map;

public class IDConvertor {

    private static final Map<Integer, Character> indexToCharTable = MappingConstants.indexToCharTable;
    private static final Map<Character, Integer> charToIndextable = MappingConstants.charToIndexTable;

    public static String getShortURL(long requestNumber) {
        StringBuffer shortURL = new StringBuffer();

        while (requestNumber > 0) {
            shortURL.append(indexToCharTable.get((int)(requestNumber % 62)));
            requestNumber = requestNumber/62;
        }
        return shortURL.reverse().toString();
    }

    public static long getID(String shortURL) {
        long id = 0;
        for (int i = 0; i < shortURL.length(); i++) {
            id +=  charToIndextable.get(shortURL.charAt(shortURL.length() - 1 - i)) * Math.pow(62, i);
        }
        return id;
    }

}
