package com.count.simple.CountingUser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingString {

	public static void main(String[] args) {
		String txt1 = "15/06/2016, 20:45 - ‪+62 823-0232-8933‬: grum bbm ud pda off kah? kni hdir kmbali grup wa. hai.. kawand, smoga shat slalu dsna..";
		String txt2 = "15/06/2016, 20:44 - abdurrahman: jeuh keng,,";
		String txt3 = "15/06/2016, 20:45 - Denis: Nyaman e Ampel man";
		String txt4 = "15/06/2016, 20:45 - Denis: Kobessa";
		String logEntryLine = "123.45.67.89 - - [27/Oct/2000:09:27:09 -0400] \"GET /java/javaResources.html HTTP/1.0\" 200 10450 \"-\" \"Mozilla/4.6 [en] (X11; U; OpenBSD 2.8 i386; Nav)\"";
		
		String regex = "[(\\s\\-\\s)':]";
		String[] split1 = txt1.split(regex);
		
		String logEntryPattern = "^([0-9]{2})/([0-9]{2})/([0-9]{4}), (\\S+) ([0-9]{2}):([0-9]{2}) (\\S+) - (\\S+)(.w)";
		Pattern p = Pattern.compile(logEntryPattern);
	    Matcher matcher = p.matcher(txt1);
	    
		System.out.println(matcher.group(1));
		List<String> list = new ArrayList<>();
		list.add(txt1);
		list.add(txt2);
		list.add(txt3);
		list.add(txt4);
		
//		String[] input = {"foo     bar", "nope", " "};
//		Pattern p = Pattern.compile("^([0-9]{2})/([0-9]{2})/([0-9]{4}).*$");
//		for (String s: list) {
//		    Matcher m = p.matcher(s);
//		    System.out.printf("Found in %s? %b%n", s);
//		}
	}

}
