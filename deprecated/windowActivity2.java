/* 
    Document   : windowActivity.java
    Created on : June 1, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
        This is the class for setting up and initializing the GUI elements or components. 
        As well as the JFRAME for the window and more.
*/



// IMPORT SECTION
import java.awt.*;
import javax.swing.*;



public class windowActivity2 extends JFrame {

    // Values for the size of the window
    public static int WIDTH = 800; 
    public static int HEIGHT = 400;
    public static String outcome = "TEST";  

    // Window Menus
    public static JMenuBar menubar; 
    JMenu gameOptions;
    JMenuItem start; 
    JMenuItem restart; 
    JMenuItem about; 
    JMenuItem help;
    JMenuItem exitOption; 

    // Panels
    static JPanel main_container;
    static JPanel labelpanel; 

    // Status bar to keep the information related to the number of guesses
    JPanel statusBar;

    // Labels
    JLabel higher_lower_label;
    JLabel guessLabel; 
    JLabel no_of_guesses; 

    // Textfield for user input in entering a single line input
    JTextField user_input; 

    
    // Constructor
    public windowActivity2() {
        // Call the method to initialize the main panel
        init_mainPanel();

        // Prepare and call the method to initialize the menubar and its menu items
        init_menu(); 

        // Initialize the labels by calling the dedicated method
        init_labels();

        // Then, finally initialize the area where user input and interaction is required
        init_userArea();

        // Additionally, we may want to initialize the status bar as well 
        init_statusBar();

        // Call the dedicated method for adding components
        add_guiComponent();
    }

    

    // Initialize and set up the panel for the main_container 
    // which will act as a parent to contain other panels and components
    private void init_mainPanel() {
        // Create a new instance for the following panels panel
        main_container = new JPanel(new BorderLayout()); 
        
        // Set up the size of of the main container panel. 
        // Along with basic panel properties
        main_container.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        main_container.setOpaque(true);
    }    


    // Initialize and set up the menu 
    private void init_menu() {
        // Create a new instance of the menubar to contain all the menu items
        // Add menu bar properties: 1) Set it opaque 2) Add its white color
        menubar = new JMenuBar(); 
        menubar.setOpaque(true);
        menubar.setBackground(Color.white);

        // Next, add the instances for the menu items: 1) Game Options 2) Exit
        gameOptions = new JMenu("Game Options");
        exitOption = new JMenu("Exit");
        // Create instances of sub-menu items to be put inside the Game Options menu
        /** NOTE: This includes the following:
         *          1. Start Game!
         *          2. Restart
         *          3. About 
         *          4. Help
        */
        start = new JMenuItem("Start Game!"); 
        restart = new JMenuItem("Restart"); 
        about = new JMenuItem("About"); 
        help = new JMenuItem("Help"); 


        // Add the sub-menu items inside the Game Options
        gameOptions.add(start);
        gameOptions.add(restart);
        gameOptions.add(about);
        gameOptions.add(help);


        // Finally, add the menu bar properties
        // Hence, the final menu items inside the menubar are:
        // Game Options      Exit 
        menubar.add(gameOptions);
        menubar.add(exitOption);
    }

    

    public void init_labels() {
       // Create an instance for the label container
       labelpanel = new JPanel();

       // Create an instance for the labels 
       higher_lower_label = new JLabel("TEST");
       guessLabel = new JLabel("Number of Guesses: ");
       no_of_guesses = new JLabel("0");

       // Set opaque properties for the labels
       higher_lower_label.setOpaque(true);
       guessLabel.setOpaque(true);
       no_of_guesses.setOpaque(true);

       // Set Color and Font properties
       higher_lower_label.setBackground(Color.red);
       higher_lower_label.setForeground(Color.white);
       guessLabel.setForeground(Color.white);
       no_of_guesses.setForeground(Color.white);

       higher_lower_label.setFont(new Font("Calibri", Font.BOLD, 100));
       guessLabel.setFont(new Font("Calibri", Font.PLAIN, 18));  
       no_of_guesses.setFont(new Font("Calibri", Font.PLAIN, 18));  

       // Set the preferred size of the label container
       labelpanel.setPreferredSize(new Dimension(100, 100));

       // Add the label to its dedicated panel container
       labelpanel.add(higher_lower_label);
    }



    public void init_userArea() {
        // Create an instance for the textfield 
        user_input = new JTextField(); 

        // Set the preferred size of the user_input area
        user_input.setPreferredSize(new Dimension(500, 55));


    }



    public void init_statusBar() {

    }



    public void add_guiComponent() {
        main_container.add(labelpanel);
        main_container.add(user_input, BorderLayout.SOUTH);
    }


 
    private static void createAndShowGUI() {
        // Initializing and setting up the JFrame and its essentials
        windowActivity2 frame = new windowActivity2(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Setting up the window properties
        frame.setTitle("Simple Guesser Game by Cloyd Van S. Secuya");
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false); 
        
        // Add the following components to the frame
        frame.setJMenuBar(menubar);
        frame.add(main_container, BorderLayout.CENTER); 
        
        
        
        // Pack and set up the frame
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
}
