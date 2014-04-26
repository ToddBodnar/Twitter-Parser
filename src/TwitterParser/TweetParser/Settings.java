/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterParser.TweetParser;

import TwitterParser.helpers.input_type;
import java.io.FileNotFoundException;

/**
 *
 * @author toddbodnar
 */
public class Settings {
    public static input_type data_type = input_type.API_TWEET;
    public static String data_location = null;

    public static void load() throws FileNotFoundException{
        //TODO: implement
    }
}
