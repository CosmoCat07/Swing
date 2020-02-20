import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.awt.BorderLayout;
 

public class Main extends JPanel
                        implements ActionListener {
    protected JButton b1, b2, b3;
 
    public Main() {
 
        b1 = new JButton("Disable middle button");
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("disable");
 
        b2 = new JButton("Middle button");
        b2.setMnemonic(KeyEvent.VK_DOWN);
        b2.setActionCommand("print");
 
        b3 = new JButton("Enable middle button");
        //Use the default text position of CENTER, TRAILING (RIGHT).
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setActionCommand("enable");
        b3.setEnabled(false);
 
        //Listen for actions on buttons 1 and 3.
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
 
        b1.setToolTipText("Click this button to disable the middle button.");
        b2.setToolTipText("This middle button does nothing when you click it.");
        b3.setToolTipText("Click this button to enable the middle button.");
        JPanel northPanel = new JPanel();
        northPanel.add(b1);
        northPanel.add(b2);
        northPanel.add(b3);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(northPanel, BorderLayout.SOUTH);
        mainPanel.setSize(0,0);
        
        /*JPanel northPanel = new JPanel();
        northPanel.add(b1);
        northPanel.add(b2);
        northPanel.add(b3);*/
 
        //Add Components to this container, using the default FlowLayout.
    }
 
    public void actionPerformed(ActionEvent e) {
        if ("disable".equals(e.getActionCommand())) {
            b2.setEnabled(false);
            b1.setEnabled(false);
            b3.setEnabled(true);
            b2.setText("Disabled");
        } else if ("enable".equals(e.getActionCommand())) {
            b2.setEnabled(true);
            b1.setEnabled(true);
            b3.setEnabled(false);
            b2.setText("Enabled");
        } else {
          System.out.println("Hello World");
        }
    }
 
    /** Returns an ImageIcon, or null if the path was invalid. */
 
    /**
     * Create the GUI and show it.  For thread safety, 
     * this method should be invoked from the 
     * event-dispatching thread.
     */
    private void createAndShowGUI() {
        Main main = new Main();
        //Create and set up the window.
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Main");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        Main newContentPane = new Main();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        
        //JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(main.mainPanel);
        
        //Display the window.
        frame.setBounds(0, 0, 500, 500);
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        Main guiRunner = new Main();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                guiRunner.createAndShowGUI(); 
            }
        });
    }
}