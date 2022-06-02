/* 
    Document   : WindowActivity.java
    Created on : June 1, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
        This is the class for setting up and initializing the GUI elements or components. 
*/

// IMPORT SECTION
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class WindowActivity {
    
    // We can set some attributes here to be used by some methods as an object instance later on.
    static Dimension globalDimension = new Dimension(800, 400); 
    
    // Main Window 
    JFrame main_frame; 

    // Panels
    JPanel mainPanel; 
    JPanel Mcontent_wrapper; 
    JPanel user_area; 
    JPanel emptyPanel1_asPadding;
    
    // Window Menu
    JMenuBar menubar;
    JMenu gameOptions;
    JMenuItem start; 
    JMenuItem restart; 
    JMenuItem about; 
    JMenuItem help;
    JMenu exitOption;
    JMenuItem close;

    // Textfield for user input
    JTextField user_input;

    // Labels 
    JLabel outcome;             // This is where we set up the HIGHER and LOWER labels as indication
    JLabel inputLabel;          // A label to render: "Enter your guess here: "
    JLabel guessLabel;          // Number of guesses: 
    JLabel guessVal;            // the value of the number of guesses
    JLabel hint;
    
    // Event listeners 
    Main_appEvent eventHandler = new Main_appEvent(WindowActivity.this);
    

    // Constructor 
    public WindowActivity() {
        init_mainWindow();
        actionCommander();
        addListeners();
    }



    // Initialize the main frame as the window 
    public void init_mainWindow() {
        // Create an instance of the JFrame and kill the process once close is hit
        main_frame = new JFrame();
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the window title of the main_frame
        main_frame.setTitle("Simple Guesser Game by Cloyd Van S. Secuya");

        // Set the size of the window 
        main_frame.setSize(800, 400);


        // Instantiate and prepare the menubar
        /** NOTE TO SELF: 
         *      We created a menubar where it will act as a container to pack and set the menu and menu items
         */
        menubar = new JMenuBar(); 
        menubar.setOpaque(true); 
        menubar.setBackground(Color.white); 


        // Instantiate and prepare the Game menu and Exit menu items
        gameOptions = new JMenu("Game Options"); 
        exitOption = new JMenu("Exit");
        
        // Prepare and instantiate the menu items for Game Options
        start = new JMenuItem("Start");
        restart = new JMenuItem("Restart");
        about = new JMenuItem("About");
        help = new JMenuItem("Help");

        // Prepare and instantiate the menu items for Exit
        close = new JMenuItem("Close...");

        // Set the hot key for the menu items and actions
        gameOptions.setMnemonic(KeyEvent.VK_G);
        start.setMnemonic(KeyEvent.VK_S);
        restart.setMnemonic(KeyEvent.VK_R);
        about.setMnemonic(KeyEvent.VK_A);
        help.setMnemonic(KeyEvent.VK_H);
        exitOption.setMnemonic(KeyEvent.VK_E);
        close.setMnemonic(KeyEvent.VK_C);

        // Adding the sub-items for the game option. Along with a proper separator
        gameOptions.add(start);
        gameOptions.add(restart); 
        gameOptions.addSeparator();
        gameOptions.add(about);
        gameOptions.addSeparator();
        gameOptions.add(help); 

        // Add the close option to the exit menu
        exitOption.add(close);

        // Now, we want to add the menu items to the menubar
        menubar.add(gameOptions); 
        menubar.add(exitOption);

        

        // Setting up and instantiating the labels
        /** OUTCOME LABEL */
        outcome = new JLabel("'  '", JLabel.CENTER);
        outcome.setOpaque(true);
        outcome.setForeground(Color.white);
        outcome.setBackground(Color.black);
        outcome.setFont(new Font("Calibri", Font.PLAIN, 96)); 

        /** inputLabel */
        inputLabel = new JLabel("Enter your guess here"); 
        /** guessLabel */
        guessLabel = new JLabel("Number of your guesses: ");
        /** guessVal */
        guessVal = new JLabel("0"); 
        /** hint label */
        hint = new JLabel("Guess from 0 to 100", JLabel.CENTER);

        // Setting up the textfield
        user_input = new JTextField();
        user_input.setPreferredSize(new Dimension(450, 25)); 



        // Prepare and instantiate the panels
        mainPanel = new JPanel(new GridLayout(0, 1));
        Mcontent_wrapper = new JPanel(); 
        user_area = new JPanel(); 
        emptyPanel1_asPadding = new JPanel();

        // Set up the panel properties and other attributes
        /** Mcontent_wrapper as a wrapper for the main_panel */
        Mcontent_wrapper.setBackground(new Color(255, 255, 255));
        Mcontent_wrapper.setPreferredSize(new Dimension(600, 100));
        Mcontent_wrapper.setBorder(BorderFactory.createLineBorder(Color.gray));

        /** user area */
        user_area.setBackground(new Color(234, 235, 241));
        user_area.setPreferredSize(new Dimension(50, 100)); 
        user_area.setBorder(BorderFactory.createLineBorder(Color.gray));
        
        /** empty panel as a padding */
        emptyPanel1_asPadding.setOpaque(true);
        emptyPanel1_asPadding.setBackground(Color.white);
        emptyPanel1_asPadding.setPreferredSize(new Dimension(500, 10));
        
        /** main panel */
        mainPanel.add(emptyPanel1_asPadding, BorderLayout.CENTER);      // add the "padding"
        mainPanel.add(outcome, BorderLayout.CENTER);     // add the label for inidicating "HIGHER" and "LOWER"
       
        // Add components and elements to the main_frame
        Mcontent_wrapper.add(mainPanel, BorderLayout.CENTER);       // ad the mainPanel to the wrapper
        user_area.add(inputLabel, BorderLayout.WEST);               // add the inputLabel to the user_area
        user_area.add(user_input, BorderLayout.CENTER);             // add the user_input to the user_area
        user_area.add(guessLabel, BorderLayout.CENTER);             // add the guessLabel to the user_area
        user_area.add(guessVal, BorderLayout.EAST);                 // add this to the user_are as well
        user_area.add(hint, BorderLayout.SOUTH);


        // Fetch the instance of frame object and set all given initialized components to it 
        // We use the BorderLayout to arrange the components
        main_frame.getContentPane();
        main_frame.getContentPane().setPreferredSize(globalDimension);
        main_frame.add(Mcontent_wrapper, BorderLayout.CENTER);
        main_frame.add(user_area, BorderLayout.SOUTH);
        main_frame.setJMenuBar(menubar);
        

        // Pack the frame.
        // Set the location relative to null so we can make it to appear on the center of the screen.
        // And make it visible to the user
        main_frame.pack();
        main_frame.setLocationRelativeTo(null); 
        main_frame.setVisible(true);
    }
    


    // Create a method to set action command for event handling
    public void actionCommander() {
        // Log to console
        System.out.println("Setting up action commands!!!");

        // Menu Events 
        start.setActionCommand("start");
        restart.setActionCommand("restart");
        about.setActionCommand("about");
        help.setActionCommand("help");
        close.setActionCommand("close");;
    }


    // A method to register listener objects to set up event handling
    public void addListeners() {
        // Log to console 
        System.out.println("Setting up action listeners");

        // Registering listener object to menu items
        start.addActionListener(eventHandler);
        restart.addActionListener(eventHandler);
        about.addActionListener(eventHandler);
        help.addActionListener(eventHandler);
        close.addActionListener(eventHandler);

        // Adding key listeners to the textfield
        user_input.setFocusable(true);
        user_input.addKeyListener(eventHandler);
    }
}
