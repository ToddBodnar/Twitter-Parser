/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterParser.TweetParser.filters;

import TwitterParser.TweetParser.processors.twitterprocess;


/**
 * Something that tweets are piped through before sent to another twitter process.
 * @author toddbodnar
 */
public interface tweetFilter extends twitterprocess{
    public tweetFilter clone(twitterprocess next)  ;
}
