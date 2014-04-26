/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterParser.helpers;


import TwitterParser.TweetParser.filters.tweetFilter;
import TwitterParser.TweetParser.processors.twitterprocess;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
/**
 * File Structure:
 * 
 * Two numbers which are the first and last dates to read, comma separated
 * ProcessName;Process,info
 * FilterName;Filter,info:NextName;NextInfo
 * 
 * @author toddbodnar
 */
public class JobFileIO {
    public static void save(List<twitterprocess> processes, int dates[]) throws IOException
    {
        JFileChooser jfc = new JFileChooser();
        jfc.showSaveDialog(null);
        File f = jfc.getSelectedFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(f));
        out.write(dates[0]+","+dates[1]+"\n");
        
        for(twitterprocess t:processes)
            out.write(t.buttonMenu()+";"+t.save()+"\n");
        
        out.close();
    }
    public static void load(File f,List<twitterprocess> processes, int dates[]) throws FileNotFoundException, IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(f));
        
        String line = in.readLine();
        dates[0] = Integer.parseInt(line.split(",")[0]);
        dates[1] = Integer.parseInt(line.split(",")[1]);
        
        line = in.readLine();
        while(line!=null)
        {
            System.out.println(line);
            processes.add(load(line));
            line = in.readLine();
        }
        
        
    }
    
    public static void load(List<twitterprocess> processes, int dates[]) throws FileNotFoundException, IOException
    {
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);
        File f = jfc.getSelectedFile();
        load(f,processes,dates);
    }
    public static twitterprocess load(String in)
    {
        String name = in.split(";")[0];
        String remaining = in.substring(in.indexOf(";")+1);
        for(twitterprocess t:processlist)
        {
            if(t.buttonMenu().equals(name))
                
                return t.load(remaining);
            
        }
        for(twitterprocess t:filters)
        {
            if(t.buttonMenu().equals(name))
                return t.load(remaining);
            
        }
        return null;
    }
    public static twitterprocess processlist[] = new twitterprocess[]{};//{new handrate(), new averageLocations(), new keywordFrequencies(), new mapProcess(), new usersbyweek(),new symptomRecorder(), new frequent_keywords(), new tweet_counter(""), new word_frequencies(), new printTweets(), new dynamoFill(), new crowdbreaks_tweets_to_raw_long_lat(), new printReTweets(), new userRating(false)};
    /**
     * 
     */
    public static tweetFilter filters[] = new tweetFilter[]{};//new keyword_filter(null), new countFilter(0,null), new nGramRefactor(null,-1), new regionFilter(0,null)};
}
