###############################
Test suite compilation and execution from command line
From src/ directory containing tests/ subdirectory
###############################
#Compilation ( -cp used to indicate path to required third party libraries for unittesting )
#Note: you may require to adapt path and jar names

#Exemple windows
C:\Users\usrlocal\Desktop\JavaProgSujet\src>javac -cp "C:\Program Files (x86)\eclipse\plugins\org.junit_4.11.0.v201303080030\junit.jar";"C:\Program Files (x86)\eclipse\plugins\org.hamcrest.core_1.3.0.v201303031735.jar" tests\MyTest1.java tests\MyTest2.java ... etc...
#Exemple darwin
javac -classpath "/Applications/eclipse/plugins/org.junit_4.11.0.v201303080030/junit.jar":"/Applications/eclipse/plugins/org.hamcrest.core_1.3.0.v201303031735.jar": tests/MyTestSuite1Runner.java


#Execution
#Note: you may require to adapt path and jar names

#Exemple windows
C:\Users\usrlocal\Desktop\JavaProgSujet\src>java -cp "C:\Program Files (x86)\eclipse\plugins\org.junit_4.11.0.v201303080030\junit.jar";"C:\Program Files (x86)\eclipse\plugins\org.hamcrest.core_1.3.0.v201303031735.jar"; tests/MyTestSuite1Runner
#Exemple darwin
java -classpath "/Applications/eclipse/plugins/org.junit_4.11.0.v201303080030/junit.jar":"/Applications/eclipse/plugins/org.hamcrest.core_1.3.0.v201303031735.jar": tests/MyTestSuite1Runner

 