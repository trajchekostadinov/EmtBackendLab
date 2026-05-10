package com.example.emtbackendlab;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class EmtBackendLabApplicationTests {

    @Test
    void contextLoads() {
    }

}

//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//public class EmtBackendLabApplicationTests {
//
//    public static String chechMethod(String string){
//        return string.toLowerCase(); // proveruva buzem
//    }
//
//    public static String getAutoSuggests(String str){
//        return str;
//    }
//    @Test
//    public void testSearchCaseSensitive(){
//
//        String input1 = "Laptop";
//        String input2 = "laptop";
//
//        String result1 = chechMethod(input1);
//        String result2 = chechMethod(input2);
//
//        assertEquals(result1,result2,"Search should be case-insensitive");
//    }
//
//    @Test
//    public void testSearchByKeyword(){
//        String keyword = "java";
//        String result = chechMethod(keyword);
//        assertTrue(result.contains(keyword),"search results should contain this keyword");
//    }
//
//    @Test
//    public void testAutoComplete(){
//        String typeWord="java";
//        String suggestions = getAutoSuggests(typeWord);
//        assertFalse(suggestions.isEmpty(),"the result should provide typeWord + suggestions bellow for that word");
//    }
//
//    @Test
//    public void testSearchMultipleWords() {
//        String input = "full sentence search";
//
//        String results = chechMethod(input);
//
//        assertNotNull(results, "Search should handle multiple words or full sentences");
//    }




