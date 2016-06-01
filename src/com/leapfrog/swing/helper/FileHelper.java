/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.swing.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author lenovo
 */
public class FileHelper {
    public static String read(String filename)throws IOException{
        BufferedReader reader=new BufferedReader(new FileReader(filename));
        String line="";
        StringBuilder content=new StringBuilder();
        while((line=reader.readLine())!=null) {
        
        content.append(line+"\r\n");
        }
    
        reader.close();     
        
   return content.toString();
    
    }   
    public static void write (String fileName ,String Content) throws IOException{
    FileWriter writer=new FileWriter(fileName);
    writer.write(Content);
    writer.close();
            
    
}
}
