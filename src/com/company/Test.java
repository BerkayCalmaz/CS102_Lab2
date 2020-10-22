package com.company;
/**
 * This class is to test classes.
 * @author: Berkay Çalmaz
 * @date: 22.10.2020
 */
public class Test {

    public static void main(String[] args) {
    MySimpleURLReader myReader1 = new MySimpleURLReader("http://www.cs.bilkent.edu.tr/~ozturk/cs102/housman.txt");
    MySimpleURLReader myReader2 = new MySimpleURLReader( "https://scrapethissite.com/pages/simple/" );
    HTMLFilteredReader myReader3 = new HTMLFilteredReader("https://scrapethissite.com/pages/simple/");
    wordSearchClass myReader4 = new wordSearchClass("https://scrapethissite.com/pages/simple/");
        //-----PART B-----
        System.out.println("-------------------- PART B --------------------");
        System.out.println( "Name of the website is: " + myReader1.getName() );
        System.out.println( "The url is: " + myReader1.getURL() );
        System.out.println( myReader2.getPageContents() );

        //-----PART C-----
        System.out.println("-------------------- PART C --------------------");
        System.out.println( myReader2.getNumberOfCSSLinks() );

        //-----PART D-----
        System.out.println("-------------------- PART D --------------------");
//        System.out.println(myReader3.getUnfilteredPageContents());

        //-----PART E------
        System.out.println("-------------------- PART E --------------------");
        System.out.println( "The index of Ankara is:" + myReader4.findWord("Ankara" ) );
        System.out.println( "The index of Turkey is:" + myReader4.findWord("Turkey" ) );


    }
}
