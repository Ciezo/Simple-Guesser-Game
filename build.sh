echo -e "**** Recompiling source files ****"
sh ./compile.sh

echo -e "\n \n"
echo -e "██████████████████████████████████████████████████████████████████"
echo -e "Attempting to build an executable file.    ::      Format ==> .jar"
echo -e "██████████████████████████████████████████████████████████████████"
mkdir "release"
echo -e " \t ==> Folder created!"
jar -cvfe release/SimpleGuessingGame.jar bin/Main.class bin/*.class 
echo -e "\n \n A copy of generated executable file is in ==>   release folder!"
echo -e "---------------------------------------------------------------------"