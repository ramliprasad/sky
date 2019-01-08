JAVA VERSION
The system has been developed in Java version 8. Incase you need to install you can
download the JDK version 8 from the Oracle website or OpenJDK website. 

The system has been developed using eclipse. If the code is not opening properly 
in eclipse then

mvn eclipse:eclipse 

on the command line should help.

Incase you want to port it to IntelliJ then following URL might help
https://stackoverflow.com/questions/13876752/how-to-import-eclipse-projects-to-intellij-idea

Implementation:
The system has been developed on top of spring framework version 4.1.6. The dependent 
jars have been configured in Maven and should automatically download onto the system.

Interface implementation:
The interface has been implemented under the package com.bskyb.internettv.impl

Spring Context: The spring context file is under com.bskyb.internettv.context.InternetTVContext

Main App: The app can be executed using the MainApp.java program written under 
com.bskyb.internettv.app.MainApp.java

Testing: Junit 4 and Mockito frameworks have been used to write Test cases. Mocks have been
created in order to test the application with various scenarios. The test should be
self explanatory. The version details are mentioned under pom.xml.

Thank you and enjoy your setup and testing. Have a nice day!!