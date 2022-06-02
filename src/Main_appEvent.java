/* 
    Document   : Main_appEvent.java
    Created on : June 1, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
        This src file is responsible for setting up the Main_app interaction.
        It is where the main activity of application will happen. 
        So, we will need Events! For the events and action listeners to be set in place. 
*/

// IMPORT SECTION
import java.awt.*;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class Main_appEvent implements ActionListener, KeyListener {

    WindowActivity windowActivity;
    public String commander;
    public int input;
    public int numberToGuess;
    Guesser guess = new Guesser();

    public Main_appEvent(WindowActivity windowActivity) {
        this.windowActivity = windowActivity;
    }

    // KEYBOARD EVENTS

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int keyVal = e.getKeyCode(); 

        switch (keyVal) {
            case KeyEvent.VK_ENTER:
                System.out.println("Input received!");
                fetchInputFromText();
                // guessChecker(numberToGuess);
                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {}


    // Action Events
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        e.getSource();
        commander = e.getActionCommand();
        switch (commander) {
            case "start":
                System.out.println("Start");
                windowActivity.gameOptions.remove(windowActivity.start);        // remove the Start option because the game has started
                windowActivity.outcome.setText("Start Guessing!");        // indicate the game has started
                handleStart(e);

                break;
            
            case "restart":
                System.out.println("Restart");
                windowActivity.outcome.setForeground(Color.white);
                windowActivity.outcome.setBackground(Color.black);
                windowActivity.outcome.setText("Start Guessing!");
                handleStart(e);
                break;
            
            case "about":
                System.out.println("About");
                handleAbout(e);
                break;

            case "help":
                System.out.println("Help");
                handleOnHelp();
                break;
            
            case "close":
                System.out.println("Close");
                handleOnClose();
        } 
        
    }



    private void handleStart(ActionEvent e) {
        // Start setting up the random number generation bound 100
        guess.setRGN();

        numberToGuess = guess.getRGN();

        // Get the RGN
        System.out.println("Number to guess: " + numberToGuess);
        
        // Pass the RGN to the checker
        // guessChecker(numberToGuess);
    }



    private void fetchInputFromText() {
        String inputAsTxt = windowActivity.user_input.getText();

        System.out.println("Input from text field in text format: " + inputAsTxt);
        try {
            int number = Integer.parseInt(inputAsTxt);
            System.out.println("Parsed String input as integer: " + number); 
            input = number;

            // Pass the RGN again to the checker for every time there is an input from the user 
            // So that, we can have an active checking in background
            guessChecker(numberToGuess);
        }

        catch (NumberFormatException ex){
            ex.printStackTrace();           // For debugging
            handleInputErrors(ex);
        }

    }



    private void guessChecker(int numberToGuess) {
        int numberOfGuesses = 0; 
        String no_of_tries = ""; 

        System.out.println("Guess checker, input: " + input);

        // Calculate the number of guesses
        guess.no_of_guesses = guess.no_of_guesses + 1;  
        numberOfGuesses = guess.no_of_guesses;

        no_of_tries = Integer.toString(numberOfGuesses);
        // Then, display the number of tries to guess on the label
        windowActivity.guessVal.setText(no_of_tries);

        // Conditions to actively check the user input and compare it with
        // our rgn
        if (input < numberToGuess) {
            // Print to console for logging
            // System.out.println("HIGHER");            // NOTE TO SELF: It consumes so much memory and performance
            
            // Set the outcome label to HIGHER
            windowActivity.outcome.setText("HIGHER");
            windowActivity.outcome.setForeground(Color.white);
            windowActivity.outcome.setBackground(Color.red);
        }
            
        else if (input > numberToGuess) {
            // Print to console for logging purposes
            // System.out.println("LOWER");         // THIS ONE TOO! IT CONSUMES MEMORY WITH THE APPLICATION

            // Set the outcome label to HIGHER
            windowActivity.outcome.setText("LOWER");
            windowActivity.outcome.setForeground(Color.white);
            windowActivity.outcome.setBackground(Color.green);
        }

        if (input == numberToGuess) {
            System.out.println("YOU WON");
            winner(no_of_tries);
        } 

    }



    private void winner(String message) {
        // Instantiate a pop-up dialog
        JOptionPane.showMessageDialog(null, "Number of Guesses: " + message, "You Won!!!!", JOptionPane.INFORMATION_MESSAGE); 
    }



    private void handleInputErrors(NumberFormatException err) {
        // Create a pop-up error
        JOptionPane.showMessageDialog(null, "Please enter a number", "Error", JOptionPane.ERROR_MESSAGE);   
    }



    private void handleAbout(ActionEvent e) {
        // Create a new instance of a frame 
        JFrame frame_about = new JFrame("About game"); 

        // Create panels
            JPanel panel = new JPanel();

        // Log to console 
            System.out.println("Preparing window About");

        // Try link to github 
            JLabel link = new JLabel(new ImageIcon("assets/icons/github.png")); 
        
        // Create a string array of developers 
            String[] devs= {"Cloyd Secuya" };

        // Create a list for the me, the dev 
        JList list = new JList<>(devs);
        list.setPreferredSize(new Dimension(400, 75));

        // Link to github feature 
        link.setPreferredSize(new Dimension(100, 100));
        link.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    final URI link = new URI("https://github.com/Ciezo/Simple-Guesser-Game");
                    Desktop.getDesktop().browse(link); 
                } 
                
                catch (URISyntaxException | IOException e1) {
                    e1.printStackTrace();
                }  
            }
    
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("HOVERED OVER: Github link"); 

                // Change icon when hover
                    ImageIcon gitIcon_hover = new ImageIcon("assets/icons/github_onHover.png");
                    link.setIcon(gitIcon_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("EXITED OVER: Github link"); 

                // Default back to icon when cursor exit over
                    ImageIcon gitIcon_exit = new ImageIcon("assets/icons/github.png");
                    link.setIcon(gitIcon_exit);
            }

        });


        // Add these initialized components in the panel 
            panel.add(list, BorderLayout.PAGE_END);  

        // Fetch the instance of frame object and set all given initialized components to it 
            frame_about.getContentPane();
            frame_about.setPreferredSize(new Dimension(500, 500)); 
            frame_about.add(panel, BorderLayout.CENTER);  
            frame_about.add(link, BorderLayout.SOUTH); 
    
        // Avoid resizing
            frame_about.setResizable(false);
    
        // Pack and center the frame and set visible as true 
            frame_about.pack();
            frame_about.setLocationRelativeTo(null); 
            frame_about.setVisible(true);
    }



    private void handleOnHelp() {
        // Create a new instance of a frame 
        JFrame frame_help = new JFrame("Official instructions"); 

        // Create panels
            JPanel panel = new JPanel();

        // Log to console 
            System.out.println("Help Windowt");

        // Label for instructions 
            JLabel msg = new JLabel();
            JLabel prompt = new JLabel(); 

         // Try wrapping
            /** About content panel */ 
            msg.setText("<html><body><h1>INSTRUCTIONS</h1><p>You need to guess the number in a range of 0 - 100. Keep trying until you get it right<br> Avoid getting hit on the walls and do not bite yourself <br> </p><h2>Developers</h2> </body></html>");

            prompt.setText("<html><body><h3>A Development and Design By:</h3><p>Cloyd Secuya <br> </p> <br> </body></html>");
            
        // Add these initialized components in the panel 
            panel.add(msg, BorderLayout.LINE_START); 
            panel.add(prompt, BorderLayout.SOUTH); 

        // Fetch the instance of frame object and set all given initialized components to it 
            frame_help.getContentPane();
            frame_help.setPreferredSize(new Dimension(500, 500)); 
            frame_help.add(panel, BorderLayout.CENTER);  
    
        // Avoid resizing
            frame_help.setResizable(false);
    
        // Pack and center the frame and set visible as true 
            frame_help.pack();
            frame_help.setLocationRelativeTo(null); 
            frame_help.setVisible(true);
    }



    private void handleOnClose() {
        // Pop-up dialog
        int arg = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the application?", 
        "Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        // Beep 
            Toolkit.getDefaultToolkit().beep();
        
        // Pass the decision as int
            decision_ext(arg);
    }


    private void decision_ext(int arg) {
        // Print the passed parameter from JOption
            //** TEST CASE */
            System.out.println(arg);
        
        switch (arg) {
            
            case 0:
                System.out.println("Closing application!");
                System.exit(0);

                break; 

            case 1:
                System.out.println("Returning to application");
                break; 
            
            default:
                System.out.println("Decision entered");
                break; 
        }
    }
}