package com.test.portlet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CreateAndParseJsonObject {
	public static void main(String[] args) throws IOException, ParseException {
		// creating JSONObject 
        JSONObject jo = new JSONObject();
     // for phone numbers, first create JSONArray  
        JSONArray ja = new JSONArray();
        String [] fieldsNamearr = {"actionPerformedBy", "actionPerformedDate","actionStatus","actionDescription","actionConsumer"};
        
        for(int i=0; i<fieldsNamearr.length; i++) {
        	Map m = new LinkedHashMap(3); 
        	m.put("fieldName",fieldsNamearr[i]);
        	m.put("oldValue", i); 
        	m.put("newValue", i+1); 
        	ja.add(m);
        }
        
		/*
		 * for(int i=0; i<10; i++) { Map m = new LinkedHashMap(2);
		 * m.put("oldDescription"+i, i); m.put("newDescription"+i, i+1);
		 * ja.add(m); }
		 */
        //putting phoneNumbers to JSONObject 
        jo.put("moiaudit", ja);
     // writing JSON to file:"JSONExample.json" in cwd 
        PrintWriter pw = new PrintWriter("JSONExample.json"); 
        pw.write(jo.toJSONString());   
        pw.flush(); 
        pw.close(); 
        System.out.println("Created Successfully...");
        
        
     // parsing file "JSONExample.json" 
        Object obj = new JSONParser().parse(new FileReader("JSONExample.json")); 
        // typecasting obj to JSONObject 
        JSONObject jo1 = (JSONObject) obj; 
        
     // getting phoneNumbers 
        JSONArray ja1 = (JSONArray) jo.get("moiaudit"); 
          
        // iterating description 
        Iterator<LinkedHashMap> itr2 = ja1.iterator(); 
          
        while (itr2.hasNext())  
        { 
        	LinkedHashMap pair = (LinkedHashMap)itr2.next(); 
        	Set<String> keySet = pair.keySet();
        	//Convert set to an array using the toArray method
        	String[] keyArray = keySet.toArray( new String[ keySet.size() ] );
        	
        	for(int j=0;j<keyArray.length;j++) {
        		//get key for the specified index
                String key = keyArray[j];
              //get value from the LinkedHashMap for the key
                System.out.println(key+": " + "Value - "+pair.get(key) );
        	}
        } 
        
        
	}
}
