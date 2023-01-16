/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.dawid.dlugajczyk.cesar.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Cesar cipher
 *
 * @author Dawid Dlugajczyk
 * @version 1.3
 */
public class ModelTest {
    
   public static char[] values() {
	return new char[] { 'a', 'b', 'g', 'p'};
}
 
    
    /**
     * Test of checkMessage method, of class Model.
     * @param c
     */
    @ParameterizedTest
    @MethodSource("values")
    public void testCheckMessage_Param(char c) {
        
         Model model = new Model();
        assertTrue(model.checkMessage(c), "Char is wrong");

    }

    /**
     * Test of checkMessage method, of class Model.
     */
    @Test
    public void testCheckMessage() {

        //given
        char a = '?';
        Model model = new Model();
        
        //when
        boolean result = model.checkMessage(a);
        
        //then
        boolean expResult = false;
        assertEquals(expResult, result);
    }


    /**
     * Test of encode method, of class Model.
     * @throws Exception
     */
    @Test
    public void testEncode() throws Exception {
        
        //given
        String message = "a";
        int shift = 2;
        Model instance = new Model();
        String expResult = "c";
        //when
        String result = instance.encode(message, shift);
        
        //then
        assertEquals(expResult, result);
    }
    
    /**
     * Test of encode method, of class Model.
     * @throws IncorrectTextException
     */
    @Test
    public void testEncode_Exception() throws IncorrectTextException {
        
       //given
        String message = "sas!";
        int shift = 3;
        Model instance = new Model();

        //then
        Assertions.assertThrows(IncorrectTextException.class, () -> instance.encode(message, shift));
    }
    
    /**
     * Test of encode method, of class Model.
     * @throws Exception
     */
    @Test
    public void testDecode() throws Exception{
        
        //given
        String message = "a";
        int shift = 2;
        Model instance = new Model();
        String expResult = "y";
        //when
        String result = instance.decode(message, shift);
        
        //then
        assertEquals(expResult, result);
    }

    /**
     * Test of decode method, of class Model.
     * @throws IncorrectTextException
     */
    @Test
    public void testDecode_Exception() throws IncorrectTextException {
        
        //given
        String message = "sas!";
        int shift = 3;
        Model instance = new Model();

        //then
        Assertions.assertThrows(IncorrectTextException.class, () -> instance.decode(message, shift));

    }

}
    
    

