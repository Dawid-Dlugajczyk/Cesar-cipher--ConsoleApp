/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.dawid.dlugajczyk.cesar.view;

import java.util.Scanner;

/**
 * Cesar cipher
 *
 * @author Dawid Dlugajczyk
 * @version 1.3
 */
public class View {

    /**
     * Reads the shift value and passes to the function.
     *
     * @return shift
     */
    public int getShift() {
        Scanner input1 = new Scanner(System.in);
        System.out.println("Provide a shift:");
        int shift;

        while (true) {
            try {
                shift = Integer.parseInt(input1.nextLine());
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Key has to be a number, try again: ");
            }
        }

        return shift;
    }

    /**
     * Reads the message and passes to the function.
     *
     * @return message
     */
    public String getMessage() {
        String message;

        Scanner input2 = new Scanner(System.in);
        System.out.println("Provide message to encode:");

        message = input2.nextLine();

        return message;
    }

    /**
     * Reads the encoded message and passes to the function.
     *
     * @return encodedMessage
     */
    public String getEncodedMessage() {

        Scanner input2 = new Scanner(System.in);
        System.out.println("Provide message to decode:");
        String encodedMessage = input2.nextLine();

        return encodedMessage;
    }

    /**
     * Prints encoded message.
     *
     * @param encodedText
     */
    public void printEncodedText(String encodedText) {
        System.out.println("Encoded message: " + encodedText);
        System.out.println(" ");
    }

    /**
     * Prints decoded message.
     *
     * @param decodedText
     */
    public void printDecodedText(String decodedText) {
        System.out.println("Decoded message: " + decodedText);
        System.out.println(" ");
    }
    
    public void printInfo(){
        System.out.println("Select option. Press:");
            System.out.println("(d - to decode message)");
            System.out.println("(e - to encode message)");
            System.out.println("(q - to quit the program)");
    }
    
    public String getInput(){
        Scanner input = new Scanner(System.in);
        String opt = input.nextLine();
        
        return opt;
    }
    
     public void printErrorMessage(Exception e)
    {
        System.err.println(e.getMessage());
    }
}
