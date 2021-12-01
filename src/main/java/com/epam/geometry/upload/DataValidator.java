package com.epam.geometry.upload;

import java.util.regex.Pattern;

public class DataValidator {

    //point is given by an expression of the form "(double;double)"
    private final static String PATTERN_DATA_POINT = "[(]{1}[-]?\\d+[.]{1}\\d+[;]{1}[-]?\\d+[.]{1}\\d+[)]{1}";
    private final static String PATTERN_DATA_LINE = "^"+PATTERN_DATA_POINT+"\\s+"+PATTERN_DATA_POINT+"\\s+" +PATTERN_DATA_POINT+"$";

    public boolean isValidLine(String line) {
        return Pattern.matches(PATTERN_DATA_LINE, line);

    }
}
