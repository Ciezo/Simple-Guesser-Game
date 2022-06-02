echo -e "Compiling src files"
cd src 
javac -d ../bin *.java
echo -e "src files compiled! Move and check in the bin directory"

echo -e "Setting up the classpath"
javac -cp ../bin Main.java
javac -cp ../bin WindowActivity.java
javac -cp ../bin Main_appEvent.java
javac -cp ../bin Guesser.java
echo -e "Classpath has been set to bin"

mv *.class ../bin
echo "All class files are now in bin!"