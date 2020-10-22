package com.company;

public class wordSearchClass extends HTMLFilteredReader {
    public wordSearchClass(String var1) {
        super(var1);
    }

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