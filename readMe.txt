********************************************
*   ZIP CONTENTS
********************************************

./readMe.txt            (this file)
./ConsoleDrawingApp     (directory containingsource code)
./runnable              (directory containng runnable jar for convenience)

********************************************
*   HOW TO RUN
********************************************

Option 1:
After unpacking, open your your console of choice and navigate to the project location and execute below

    java -jar ./runnable/DrawingApp-1.0-SNAPSHOT.jar

Option 2:
In case you want to generate from code, run below

    mvn clean package -DskipTests

This will generate a new jar file that can then be executed using below:

    java -jar ./runnable/DrawingApp-1.0-SNAPSHOT.jar
