package com.test.portlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.opencsv.CSVWriter;
/**

 * Contains some methods to list files and folders from a directory

 *

 * @author Loiane Groner

 * http://loiane.com (Portuguese)

 * http://loianegroner.com (English)

 */

public class GetCommMetadata {

    /**

     * List all the files and folders from a directory

     * @param directoryName to be listed

     */

    public void listFilesAndFolders(String directoryName){

        File directory = new File(directoryName);

        //get all the files from a directory

        File[] fList = directory.listFiles();

        for (File file : fList){

            System.out.println(file.getName());

        }

    }

    /**

     * List all the files under a directory

     * @param directoryName to be listed

     */

    public void listFiles(String directoryName){

        File directory = new File(directoryName);

        //get all the files from a directory

        File[] fList = directory.listFiles();

        for (File file : fList){

            if (file.isFile()){

                System.out.println(file.getName());

            }

        }

    }

    /**

     * List all the folder under a directory

     * @param directoryName to be listed

     */

    public void listFolders(String directoryName){

        File directory = new File(directoryName);

        //get all the files from a directory

        File[] fList = directory.listFiles();

        for (File file : fList){

            if (file.isDirectory()){

                System.out.println(file.getName());

            }

        }

    }

    /**

     * List all files from a directory and its subdirectories

     * @param directoryName to be listed

     */

    public ArrayList<String[]> listFilesAndFilesSubDirectories(String directoryName, ArrayList<String[]> data){

        File directory = new File(directoryName);

        //get all the files from a directory

        File[] fList = directory.listFiles();
        
        for (File file : fList){

            if (file.isFile()){

               // System.out.println(file.getAbsolutePath()); //commented on 21.10.2020
                String str = file.getAbsolutePath();
                String separator = "\\";
                String[] rowdata=str.replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
                //String[] rowdata = file.getAbsolutePath().split("\\"); 
                int rowdatasize = rowdata.length;
                /*for(int j = 0; j < rowdatasize; j++) {
                	System.out.println("Row Data Value ="+rowdata[j]);
                }*/
                String strLastValue = rowdata[rowdatasize-1];
                System.out.println("strLastValue - "+strLastValue);
                String[] parts = strLastValue.split("\\.");
                String strDocketNo = parts[0];
                String docketDate;
                if (strLastValue == null || strLastValue.length() < 14) {
                	docketDate = strLastValue;
                } else {
                	//docketDate = strLastValue.substring(strLastValue.length() - 14);
                	docketDate = strLastValue.substring(6,16);
                }
                System.out.println("docketDate - "+docketDate);
                
                
                String newarr[] = new String[rowdata.length + 2];
                for(int j = 0; j < rowdata.length; j++) {
                	newarr[j] = rowdata[j];
                }
                
                strDocketNo = strLastValue.substring(0,2);
                System.out.println("strDocketNo----"+strDocketNo);
                newarr[newarr.length-1] = docketDate;
                newarr[newarr.length-2] = strDocketNo;
                
                data.add(newarr);
               // data.add(rowdata); 

            } else if (file.isDirectory()){

                listFilesAndFilesSubDirectories(file.getAbsolutePath(), data);

            }
           
           

        }
        System.out.println("Data Length - "+data.size()); 
        return data;

    }

    public static void main (String[] args){

    	ArrayList<String[]> data = new ArrayList<String[]>();
    	GetCommMetadata listFilesUtil = new GetCommMetadata();

        final String directoryLinuxMac ="/Users/loiane/test";

        //Windows directory example

        final String directoryWindows ="C:\\Users\\Public\\Docket 2019 -2020\\Docket01";

        data = listFilesUtil.listFilesAndFilesSubDirectories(directoryWindows, data);

        try { 
        	
        	String output = "C:\\Users\\Public\\Docket 2019 -2020\\Docketresult01.csv"; 
        	 File output_file_path = new File(output);
            // create FileWriter object with file as parameter 
            FileWriter outputfile = new FileWriter(output_file_path); 

            // create CSVWriter with ';' as separator 
            CSVWriter writer = new CSVWriter(outputfile, '|', 
                                             CSVWriter.NO_QUOTE_CHARACTER, 
                                             CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
                                             CSVWriter.DEFAULT_LINE_END); 

            // create a List which contains Data 

           writer.writeAll(data); 

            // closing writer connection 
            writer.close(); 
        } 
        catch (IOException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        }
        
    }

}


