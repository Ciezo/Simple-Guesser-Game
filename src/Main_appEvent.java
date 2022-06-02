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
import java.awt.event.*;


public class Main_appEvent implements ActionListener, KeyListener {

    WindowActivity windowActivity;
    public String commander;

    public Main_appEvent(WindowActivity windowActivity) {
        this.windowActivity = windowActivity;
    }

    // KEYBOARD EVENTS

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }


    // Action Events
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        e.getSource();
        commander = e.getActionCommand();
        switch (commander) {
            case "start":
                System.out.println("Start");
                break;
            
            case "restart":
                System.out.println("Restart");
                break;
            
            case "about":
                System.out.println("About");
                break;

            case "help":
                System.out.println("Help");
                break;
            
            case "close":
                System.out.println("Close");
        } 
        
    }
    
}
