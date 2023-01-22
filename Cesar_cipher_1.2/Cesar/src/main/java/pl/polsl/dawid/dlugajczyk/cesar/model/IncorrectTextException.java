/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.dawid.dlugajczyk.cesar.model;

/**
 * Cesar cipher- IncorrectException class
 *
 *
 * @author Dawid Dlugajczyk
 * @version 1.3.1
 */
public class IncorrectTextException 
    extends Exception
        {
    
    /**
     * Exception constructor with error message
     * 
     * @param errorMsg Message shown when the exception is caught
     */
    public IncorrectTextException(String errorMsg) 
            {
            super(errorMsg);
            }
}