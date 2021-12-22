package com.epam.geometry.uploading;

import com.epam.geometry.uploading.DataValidator;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.validation.Validator;

public class DataValidatorTest {

    @Test
    public void testIsValidLineWhenSpecifiedFormatString() {
        //given
        DataValidator validator = new DataValidator();
        String line = "(1.1  ; 2.1 ) ( -1.1 ;  -2.1 )  ( 1.1;-2.1     )";

        //when
        boolean result = validator.isValidLine(line);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsValidLineWhenNotSpecifiedFormatString() {
        //given
        DataValidator validator = new DataValidator();
        String line = "(1.1;2.1) ( -1.1 ;  -2.1 )";

        //when
        boolean result = validator.isValidLine(line);

        //then
        Assert.assertFalse(result);
    }
}
