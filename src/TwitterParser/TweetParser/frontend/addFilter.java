/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterParser.TweetParser.frontend;


import TwitterParser.TweetParser.filters.tweetFilter;
import TwitterParser.TweetParser.processors.twitterprocess;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Handler for adding a filter
 * @author toddbodnar
 */
public class addFilter extends JMenu{
    public addFilter(tweetFilter filter, twitterprocess nexts[], List<twitterprocess> processes,JTextArea user, int recursion)
    {
        super(filter.buttonMenu());
        super.setToolTipText(filter.toolTip());
        f = filter;
        ne=nexts;
        process = processes;
        data = user;
        for(twitterprocess t:nexts)
        {
            final twitterprocess tp = t;
            JMenuItem item = new JMenuItem(t.buttonMenu());
            item.setToolTipText(t.toolTip());
            item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twitterprocess proc;
                        proc = f.clone(tp.clone());
                        process.add(proc);
                        data.setText(data.getText()+"\n"+proc.toString());
                    
                
                
            }
        });
            super.add(item);
        }
        
     /*   if(recursion>0)
        {
            for(tweetfilter t:JobFileIO.filters)
            {
                super.add(new addFilter(filter.clone(t),nexts,processes,user,recursion-1));
            }
        }*///Todo: multiple filters
    }
    private tweetFilter f;
    private twitterprocess ne[];
    private List<twitterprocess> process;
    JTextArea data;
}
