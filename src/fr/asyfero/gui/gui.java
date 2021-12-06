package fr.asyfero.gui;

// import all dependencies
import javax.swing.*;
import java.awt.*;

public class gui {
    public static void main(String[] args){
        // Create the gui/app
        JFrame frame = new JFrame("App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // Show message when the app start
        JOptionPane.showMessageDialog(frame, "Welcome!\nThis is a basic app made in java!\n\nMade by Asyfero\n\nThe project is on Github:\nhttps://github.com/Asyfero/Java-gui", "App Start Message", JOptionPane.PLAIN_MESSAGE);

        // Create menu bar up of app
        JMenuBar menuBar = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Edit");
        JMenu m3 = new JMenu("Help");
        menuBar.add(m1);
        menuBar.add(m2);
        menuBar.add(m3);

        // Make options for 'File' button
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m12 = new JMenuItem("Save");
        JMenuItem m13 = new JMenuItem("Save As");
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);

        // Make options for 'Edit' button
        JMenuItem m21 = new JMenuItem("Rename");
        JMenuItem m22 = new JMenuItem("Delete");
        m2.add(m21);
        m2.add(m22);

        // Make options for 'Help' button
        JMenuItem m31 = new JMenuItem("Welcome Message");
        m3.add(m31);

        // Set visible all content
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.setVisible(true);
    }
}