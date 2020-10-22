//
package com.company;

import java.util.Scanner;


public class MySimpleURLReader extends SimpleURLReader{
    private String url;

    public MySimpleURLReader( String url){
        super(url);
        this.url = url;
    }

    public String getURL(){
        return url;
    }

    public String getName() {
        for( int i = url.length() -1; i > 0; i-- ){
            if( url.charAt(i) == '/' ){ //Starting from the end, checking till the first / comes.
                return url.substring(i+1);
            }
        }
        return "";
    }

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
