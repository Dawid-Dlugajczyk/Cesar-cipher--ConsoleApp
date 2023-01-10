/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.dawid.dlugajczyk.cesar.controller;


import pl.polsl.dawid.dlugajczyk.cesar.model.*;
import pl.polsl.dawid.dlugajczyk.cesar.view.View;

/**
 * Cesar cipher
 *
 * @author Dawid Dlugajczyk
 * @version 1.3
 */

public class Controller {

    Model m = new Model();
    View v = new View();


    /**
     * Method which handles the whole process of encoding and decoding. Allows
     * user to choose between encoding and decoding then calls a proper methods.
     *
     */
    public void Cipher() {

        boolean exit = false; 
        while (!exit) {
            
            
            v.printInfo();
            m.setOption(v.getInput());

            switch(m.getOption()) {

                case DECODE:
                    m.setEncodedText(v.getEncodedMessage());
                    m.setKey(v.getShift());
                    try{
                        
                        v.printDecodedText(m.decode(m.getEncodedText(), m.getKey()));  
                        
                    }catch(IncorrectTextException e){
                        
                        v.printErrorMessage(e);
                    }            
                    break;
                    
                case ENCODE:
                    m.setPlainText(v.getMessage());
                    m.setKey(v.getShift());
                    try{
                        
                        v.printEncodedText(m.encode(m.getPlainText(), m.getKey()));
                        
                    }catch (IncorrectTextException e){
                        
                        v.printErrorMessage(e); 
                    }
                    break;
                    
                case QUIT:
                    exit = true;
                    break;

                case WRONG_INPUT:
                    System.out.println("Incorrect");
                       

            }
        }
    }
}
