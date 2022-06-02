echo -e "Compiling Main Class with main()"
javac -d ../bin Main.java

echo -e "Compiling Guesser class with main()"
javac -d ../bin Guesser.java

echo -e "Setting classpath to the Main Class"
javac -cp ../bin Main.java

# 1 Compile the WindowActivity.java and set up class path
echo -e "Compiling WindowActivity and setting classpath to the bin directory"
javac -cp ../bin WindowActivity.java

# 2 Compile the Main_appEvent.java and set up class path
echo -e "Compiling Main_appEvent and setting classpath to the bin directory"
javac -cp ../bin Main_appEvent.java

# 3 Compiling the Guesser.java and set up classpath
echo -e "Compiling Guesser.java and setting classpath to the bin directory"
javac -cp ../bin Guesser.java

# 4 Compile the Main.java and set up class path
echo -e "Compiling Main.java and setting classpath to the bin directory"
javac -cp ../bin Main.java


mv *.class ../bin 

# -------------------------------------------------------------------------
echo -e "Removing unnecessary artifact"
cd ../bin
rm "compile.sh"