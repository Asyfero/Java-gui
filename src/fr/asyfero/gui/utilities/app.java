package fr.asyfero.gui.utilities;

import com.formdev.flatlaf.IntelliJTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class app extends JFrame implements ActionListener {
    JTextArea t;
    JFrame frame;

    public void start() {
        // Create the gui/app
        frame = new JFrame("Swinger");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // Put Icon
        ImageIcon img = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\Gui\\icon\\icon.png");
        frame.setIconImage(img.getImage());

        // Change the theme
        try {
            IntelliJTheme.setup(app.class.getResourceAsStream("/darcula_sombre.theme.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create Text Area
        t = new JTextArea();

        // Show message when the app start
        JOptionPane.showMessageDialog(frame, "Welcome!\nThis is a basic app made in java!\n\nMade by Asyfero\n\nThe project is on Github:\nhttps://github.com/Asyfero/Java-gui", "App Start Message", JOptionPane.PLAIN_MESSAGE);

        // Create menu bar up of app
        JMenuBar menuBar = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m3 = new JMenu("Help");
        menuBar.add(m1);
        menuBar.add(m3);

        // Make options for 'File' button
        JMenuItem m11 = new JMenuItem("New");
        JMenuItem m12 = new JMenuItem("Close");
        JMenuItem m13 = new JMenuItem("Open");
        JMenuItem m14 = new JMenuItem("Save");
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);
        m1.add(m14);

        // Make options for 'Help' button
        JMenuItem m31 = new JMenuItem("Welcome Message");
        m3.add(m31);

        // Add Action Listener
        m11.addActionListener(this);
        m12.addActionListener(this);
        m13.addActionListener(this);
        m14.addActionListener(this);

        m31.addActionListener(this);

        // Set visible all content
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.add(t);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        switch (s) {
            case "New":
                t.setText("");
                t.setVisible(true);
                break;
            case "Close":
                t.setVisible(false);
                break;
            case "Print":
                try {
                    t.print();
                }catch (Exception evt) {
                    JOptionPane.showMessageDialog(frame, evt.getMessage());
                }
                break;
            case "Open": {
                JFileChooser file = new JFileChooser("f:");

                int r = file.showOpenDialog(null);

                if (r == JFileChooser.APPROVE_OPTION) {
                    File fi = new File(file.getSelectedFile().getAbsolutePath());

                    try {
                        String s1 = "", sl = "";

                        FileReader fr = new FileReader(fi);

                        BufferedReader br = new BufferedReader(fr);

                        sl = br.readLine();

                        while ((s1 = br.readLine()) != null) {
                            sl = sl + "\n" + s1;
                        }
                        t.setText(sl);
                    } catch (Exception evt) {
                        JOptionPane.showMessageDialog(frame, evt.getMessage());
                    }
                }
                break;
            }
            case "Save": {
                JFileChooser file = new JFileChooser("f:");

                int r = file.showSaveDialog(null);

                if (r == JFileChooser.APPROVE_OPTION) {
                    File fi = new File(file.getSelectedFile().getAbsolutePath());

                    try {
                        FileWriter wr = new FileWriter(fi, false);

                        BufferedWriter bw = new BufferedWriter(wr);

                        bw.write(t.getText());

                        bw.flush();
                        bw.close();
                    } catch (Exception evt) {
                        JOptionPane.showMessageDialog(frame, evt.getMessage());
                    }
                }
                break;
            }
            case "Welcome Message":
                JOptionPane.showMessageDialog(frame, "Welcome!\nThis is a basic app made in java!\n\nMade by Asyfero\n\nThe project is on Github:\nhttps://github.com/Asyfero/Java-gui", "App Start Message", JOptionPane.PLAIN_MESSAGE);
                break;
        }
    }
}
