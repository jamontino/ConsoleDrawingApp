********************************************
*   ZIP CONTENTS
********************************************

./readMe.txt            (this file)
./ConsoleDrawingApp     (directory containing source code)
./runnable              (directory containing runnable jar for convenience)

********************************************
*   HOW TO RUN
********************************************

Option 1:
After unpacking, open your your console of choice and navigate to the project location and execute below

    java -jar ./runnable/ConsoleDrawingApp-1.0-SNAPSHOT.jar

Option 2:
In case you want to generate from code (and have maven installed), run below:

    mvn clean package -DskipTests

This will generate a new jar file that can then be executed using below:

    java -jar ./ConsoleDrawingApp/target/ConsoleDrawingApp-1.0-SNAPSHOT.jar

********************************************
*   SPECIAL CASES/MENTIONS
********************************************

1.  Creating a new Canvas when one already exists will delete the old Canvas

2.  Lines and Rectangles can overwrite each other. Nothing is mentioned in the challenge about coordinate collision.

3.  Bucket fill can fill any type of "color" or character as long (even the default "x").

4.  Nothing has been mentioned on how the output is to be displayed, only that it be displayed on the console.
    My earlier attempts to just print the out to System.out looked ugly. Hence I started looking for alternatives to the console display.
    I found this small library that helped me with this (Github link below):
        https://github.com/fusesource/jansi
    I'm assuming that the product owner for this challenge might want to support colors in the future (rather than text representation as mentioned in the original challenge).
    Above library might help out with that as it supports colored display on the console.
    Ofcourse, this would mean a change in the code =) But hopefully I've structured the code in a way that will allow easy modification if that is needed.
