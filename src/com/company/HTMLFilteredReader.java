package com.company;

public class HTMLFilteredReader extends MySimpleURLReader {

    public HTMLFilteredReader(String url) {
        super(url);
    }

    @Override
    public String getPageContents() {
        String main = super.getPageContents();
        //First, anything in between "<script" and "</script>" is deleted.

        //Go through the string looking for "<script"
        for (int i = 0; i < main.length() - 7; i++) {
            //When found, keep checking until "</script>"
            if (main.substring(i, i + 7).equals("<script")) {
                //This loops looks for "</script>"
                for (int k = i + 1; k < main.length() - 10; k++) {
                    //when </script> is found edit the the string so that <..> part is deleted
                    if (main.substring(k, k + 9).equals("</script>")) {
                        main = main.substring(0, i) + main.substring(k + 9);
                        k = main.length();
                    }
                }
            }
        }
        //Then anything in between '<' and '>' is deleted.

        //Go through the string looking for <
        for (int i = 0; i < main.length(); i++) {
            //check if the char is <
            if (main.charAt(i) == '<') {
                //go through the string to find >
                for (int k = i + 1; k < main.length(); k++) {
                    //when > is found edit the the string so that <..> part is deleted
                    if (main.charAt(k) == '>') {
                        main = main.substring(0, i) + main.substring(k + 1);
                        k = main.length();
                    }
                }
                //resetting the loop so that html links are not missed when they fall behind the loop.
                i = 0;
            }
        }
        return main;
    }


    public String getUnfilteredPageContents() {

        return super.getPageContents();
    }
}
