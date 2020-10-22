package com.company;

/**
 * This class is an extension to HTMLFilteredReader which includes further methods.
 * @author: Berkay Çalmaz
 * @date: 22.10.2020
 */
public class wordSearchClass extends HTMLFilteredReader {

    /**
     * @param var1 Inherited parameter.
     */
    public wordSearchClass(String var1) {
        super(var1);
    }

    /**
     * Returns the index which the word is in
     * @param str The word which will be found
     * @return 0 if no word, index if there is.
     */
    public int findWord( String str ){
        String main = super.getPageContents();

        for( int i = 0; i < main.length() - str.length(); i++){
            if( main.substring(i, str.length() + i).equals(str) ){
               return i;
            }
        }
        //return 0 if there are no such words.
        return 0;
    }
}