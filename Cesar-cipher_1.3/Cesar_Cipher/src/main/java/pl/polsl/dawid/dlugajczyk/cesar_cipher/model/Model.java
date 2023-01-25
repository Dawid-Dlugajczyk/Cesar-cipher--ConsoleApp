/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.dawid.dlugajczyk.cesar_cipher.model;
import java.util.*;

/**
 * Cesar cipher
 *
 * @author Dawid Dlugajczyk
 * @version 1.3
 */
public class Model{

    private int key;
    private String plainText;
    private String encodedText;
    private options optionsChoice;
    
     /**
     * An enum type values corresponding to Program options.
     *
     */
    public enum options{
        
        ENCODE, DECODE, QUIT, WRONG_INPUT;           
    }
     
     /**
     * Sets one of enum options according to parameter.
     *
     * @param option
     */
    public void setOptionEnum(int option){
        options[] choices = options.values();
        optionsChoice = choices[option];
    }
    
        /**
     * This method returns false when a character from message is non-letter value.
     *
     * @param a
     * @return checkedMessage
     */
    
    public boolean checkMessage(char a){
        
        boolean checkedMessage;
        
        if((int) a > 65 && (int) a < 91 || (int) a > 96 && a < 123){
            checkedMessage = true;
        }else if((int) a == 32){
            checkedMessage = true;
        }
        else{
            
            checkedMessage = false;
            
        }
         
        return checkedMessage;
    }
    

    /**
     * Returns one of the enum values.
     *
     * @return optionsChoice
     */  
    public options getOption(){
        return optionsChoice;
    }
    
      /**
     * Sets enum option chosen by User.
     *
     * @param input
      */ 
    /**
    public void setOption(String input){
              
        switch(input){
            case "encode" -> setOptionEnum(0);
            case "decode" -> setOptionEnum(1);
            case "q" -> setOptionEnum(2);
            default -> setOptionEnum(3);
        }    
    }
     */
    
    /**
     * Sets the key value.
     *
     * @param shift
     */
    public void setKey(int shift) {
        this.key = shift;
    }

    /**
     * Gets key to the function.
     *
     * @return key value
     */
    public int getKey() {
        return key;
    }

    /**
     * Sets the plaintext.
     *
     * @param plain
     */
    public void setPlainText(String plain) {
        this.plainText = plain;

    }

    /**
     * Gets the plaintext to the function.
     *
     * @return Plaintext string
     */
    public String getPlainText() {
        return plainText;
    }

    /**
     * Sets the encoded text.
     *
     * @param encoded
     */
    public void setEncodedText(String encoded) {
        this.encodedText = encoded;

    }

    /**
     * Gets the encoded text to the function.
     *
     * @return encodedText
     */
    public String getEncodedText() {
        return encodedText;
    }
    
        /**
     * Encodes passed message to Cesar's code with passed key. Then returns
     * encoded message.
     *
     * @param message A message that will be encoded.
     * @param shift A shift passed by User to encode messsage.
     * @throws IncorrectTextException if the message contains non letters values
     * @return encodedText
     */
    public String encode(String message, int shift) throws IncorrectTextException {

                //String changed to List containing characters
      
      List<Character> encodedText = new ArrayList<>();

        for (char ch: message.toCharArray()) {
            encodedText.add(ch);
        } 
        

        for (int i = 0; i < encodedText.size(); i++) {

            //Condition that prevents encoding value that is not a letter.
            if(!checkMessage((char) encodedText.get(i)))
            {
                throw new IncorrectTextException("Message should contain only letters values");
            }
            
        
                //use shift to find location of encoded character
                if (Character.isUpperCase(encodedText.get(i))) {
                    char ch = (char) (((int) encodedText.get(i)
                            + shift - 65) % 26 + 65);
                    encodedText.set(i, (char)ch);
                } else if (encodedText.get(i) == 32){
                    
                    encodedText.set(i, ' ' );
                    
                }else {
                    char ch = (char) (((int) encodedText.get(i)
                            + shift - 97) % 26 + 97);
                    encodedText.set(i, (char) ch);
                }
                    
                

            

       }
        StringBuilder sb = new StringBuilder();
 
        // Appends characters one by one
        for (Character ch : encodedText) {
            sb.append(ch);
       }
       
 
        // convert in string
        String encodedMessage = sb.toString();

        return String.valueOf(encodedMessage);
    }
    
    /**
     * Decodes passed message to Cesar's code with passed key. Then returns
     * decoded message.
     *
     * @param message A message that will be decoded.
     * @param shift A shift passed by User to decode messsage.
     * @throws IncorrectTextException if the message contains non-letter values.
     * @return decodedText
     */
    public String decode(String message, int shift) throws IncorrectTextException {
        
        //String changed to List containing characters
       List<Character> decodedText = new ArrayList<>();
 
        for (char ch: message.toCharArray()) {
            decodedText.add(ch);
        }

        for (int i = 0; i < decodedText.size(); i++) {

             if(!checkMessage((char) decodedText.get(i))){
            {
                throw new IncorrectTextException("Message should contain only letters (Spacebar is allowed)");
            }}
                //use shift to find location of encoded character
                if (Character.isUpperCase(decodedText.get(i))) {
                    char ch = (char) (((int) decodedText.get(i)
                            - shift - 90) % 26 + 90);
                    decodedText.set(i, (char)ch);
                } else if (decodedText.get(i) == 32){
                    
                    decodedText.set(i, ' ');
                    
                }else {
                    char ch = (char) (((int) decodedText.get(i)
                            - shift - 122) % 26 + 122);
                    decodedText.set(i, (char) ch);
                }


        }
        StringBuilder sb = new StringBuilder();
 
        // Appends characters one by one
        for (Character ch : decodedText) {
            sb.append(ch);
        }
 
        // convert in string
        String decodedMessage = sb.toString();

        return String.valueOf(decodedMessage);
    
    }
  
}
