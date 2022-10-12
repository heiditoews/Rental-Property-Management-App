# ENSF480-FinalProject
******
******
Heidi Toews
******

The database credentials are: 
username: root
password: ensf480

The jar files were created using these credentials, if you want to change them you will need to go into DbConnector at lines 45 and 46, and then re-compile the code. 

To compile our program, navigate to the src directory and run this command to compile the code: 
javac -cp "lib/mysql-connector-java-8.0.23.jar;" Controller/*.java GUI/*.java Model/*.java

Then run the code using the following command: 
java -cp "lib/mysql-connector-java-8.0.23.jar;" Controller.PRMSApp 
