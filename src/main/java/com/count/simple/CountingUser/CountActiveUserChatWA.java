package com.count.simple.CountingUser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * count WA user
 *
 */
public class CountActiveUserChatWA 
{
    public static void main( String[] args )
    {
    	try (BufferedReader br = new BufferedReader(new FileReader("/media/rahman/DATA/wachatsmada.txt"))){
			String txt;
			List<String> list = new ArrayList<>();
			while((txt = br.readLine()) != null){
				if (txt.matches("^([0-9]{2})/([0-9]{2})/([0-9]{4}).*$")){
					list.add(getUser(txt));
					if(getUser(txt).contains("added") || getUser(txt).contains("left") || 
							getUser(txt).contains("changed") || getUser(txt).contains("removed")){
						list.remove(getUser(txt));
					}
				}
					
			}
			count(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private static String getUser(String line){
        final Pattern pattern = Pattern.compile("[\\-':]");
        final String[] result = pattern.split(line);
        return result[2];
    }
    
    private static void count(List<String> list){
    	Set<String> uniqueSet = new HashSet<String>(list);
    	for (String temp : uniqueSet) {
    		System.out.println(temp + ": " + Collections.frequency(list, temp));
    	}
    }
}
