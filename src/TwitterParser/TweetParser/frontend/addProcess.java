/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterParser.TweetParser.frontend;

import TwitterParser.TweetParser.processors.twitterprocess;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author toddbodnar
 */
public class addProcess extends JMenuItem{
    public addProcess(twitterprocess t, List<twitterprocess> processes,JTextArea user)
    {
        super.setText(t.buttonMenu());
        super.setToolTipText(t.toolTip());
        prototype = t;
        data = user;
        process = processes;
        super.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twitterprocess proc;
                
                    proc = prototype.clone();
                    process.add(proc);
                    data.setText(data.getText()+"\n"+proc.toString());
                
                
            }
        });
    }
    private twitterprocess prototype;
    private List<twitterprocess> process;
    private JTextArea data;
}