package com.example.lesson53.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppServiceTest {
    @Test
    public void testFindIndexSubstring() {
        AppService service = new AppService();
        String text = "Success is not in what you have, but who you are";
        String substring = "YOU";

        int result = service.findIndexSubstring(text, substring);

        Assertions.assertEquals(23, result);
    }

    @Test
    public void testFindSubstringIsBlank() {
        AppService service = new AppService();
        String text = "Success is not in what you have, but who you are";
        String substring = "";

        int result = service.findIndexSubstring(text, substring);

        Assertions.assertEquals(-1, result);
    }

    @Test
    public void testAllIsBlank() {
        AppService service = new AppService();
        String text = "";
        String substring = "";

        int result = service.findIndexSubstring(text, substring);

        Assertions.assertEquals(-1, result);
    }
    @Test
    public void testSubstringIsNull() {
        AppService service = new AppService();
        String text = "Success is not in what you have, but who you are";
        String substring = null;

        int result = service.findIndexSubstring(text, substring);

        Assertions.assertEquals(-1, result);
    }
    @Test
    public void testTextIsNull() {
        AppService service = new AppService();
        String text = null;
        String substring = "You";

        int result = service.findIndexSubstring(text, substring);

        Assertions.assertEquals(-1, result);
    }
    @Test
    public void testNotFoundSubstring() {
        AppService service = new AppService();
        String text = "Success is not in what you have, but who you are";
        String substring = "home";

        int result = service.findIndexSubstring(text, substring);

        Assertions.assertEquals(-1, result);
    }
}
