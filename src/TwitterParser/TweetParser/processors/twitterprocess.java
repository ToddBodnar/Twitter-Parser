/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterParser.TweetParser.processors;

import TwitterParser.TweetParser.tweet;



/**
 * 
 * @author toddbodnar
 */
public interface twitterprocess{
    
    /**
     * After being parsed, the tweet will be fed to this twitter process
     * @param t
     * @throws TwitterMessage
     */
    public void consume(tweet t);
    
    /*
     * This is called after all of the tweets have been processed
     */
    public String end();
    
    public boolean quitAtEnd();
    
    /*
     * The lable in the menu, also used in the script.
     */
    public String buttonMenu();
    
    /*
     * This is used when a process is created, it should call your favorite constructor.
     * You can get user input through JFileChooser, JOptionPane, etc. 
     * This is called right after a user clicks on the process's menu entry
     */
    public twitterprocess clone();
    
    
    /**
     * process the rest of the line in the script
     * @param in 
     * @return
     * @throws TwitterMessage 
     */
    public twitterprocess load(String in);
    
    /**
     * Writes the process to a string, do not include ; or line breaks
     * Filters should end their string with ";"+next.save();
     * @return 
     */
    public String save();
    
    /**
     * Used in the gui to describe the process when it's running
     * Not necessary to overwrite, but it'll look cleaner
     * @return 
     */
    public String toString();
    
    /**
     * Hover-over text in the gui's menu
     * @return 
     */
    public String toolTip();
}
