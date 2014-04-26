/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterParser.TweetParser.filters;

import TwitterParser.TweetParser.processors.twitterprocess;
import TwitterParser.TweetParser.tweet;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toddbodnar
 */
public class multiProcess implements tweetFilter{
    public multiProcess()
    {
        runningProcesses = new LinkedList<twitterprocess>();
        allProcesses = new LinkedList<twitterprocess>();
    }
    
    public void add(twitterprocess t)
    {
        runningProcesses.add(t);
        allProcesses.add(t);
    }
    
    @Override
    public void consume(tweet t) {
        LinkedList<twitterprocess> toRemove = new LinkedList<twitterprocess>();
        for(twitterprocess tp : runningProcesses)
        {
                tp.consume(t);
            
            
        }
        
        for(twitterprocess tp : toRemove)
            runningProcesses.remove(tp);
        
        
    }

    @Override
    public String end() {
        String s = "";
        for(twitterprocess tp : allProcesses)
            s+=tp.end()+'\n';
        
        return s;
    }

    @Override
    public boolean quitAtEnd() {
        for(twitterprocess tp : allProcesses)
            if(tp.quitAtEnd())
                return true;
        
        return false;
    }
    
    public String toolTip()
    {
        return "Allows multiple twitter processes";
    }
    
    private List<twitterprocess> runningProcesses, allProcesses;
    




    @Override
    public String buttonMenu() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public tweetFilter clone(twitterprocess p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public twitterprocess load(String in) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String save() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

    @Override
    public twitterprocess clone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}