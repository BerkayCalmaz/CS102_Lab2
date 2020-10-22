//
package com.company;

import java.util.Scanner;

/**
 * This class is an extension to SimpleURLReader which includes further methods.
 * @author: Berkay Çalmaz
 * @date: 22.10.2020
 */
public class MySimpleURLReader extends SimpleURLReader{
    private String url;

    /**
     * @param url This param takes the intended url of the website
     */
    public MySimpleURLReader( String url){
        super(url);
        this.url = url;
    }

    /**
     * @return String returns the URL of the program.
     */
    public String getURL(){
        return url;
    }

    /**
     * @return String returns the name of the URL.
     */
    public String getName() {
        for( int i = url.length() -1; i > 0; i-- ){
            if( url.charAt(i) == '/' ){ //Starting from the end, checking till the first / comes.
                return url.substring(i+1);
            }
        }
        return "";
    }

    /**
     * @return int Returns the number of CSS links in the string.
     */
    public int getNumberOfCSSLinks(){
        Scanner scan = new Scanner( this.getPageContents() );
        String[] lines = new String[getLineCount()];
        int counter = 0;

        //adding every line to the string array
        for(int i = 0; i < lines.length; i++){
            lines[i] = scan.nextLine();
        }

        //checking every line
        for( int i = 0; i < lines.length; i++){
            //if the line has <link check the .css chars.
            if( lines[i].contains( "<link" ) ) {
                for (int k = 0; k < lines[i].length() - 3; k++) {
                    if ( lines[i].substring(k,k+4).equals( ".css") ) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

}
