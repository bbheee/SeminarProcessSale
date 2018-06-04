/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A logger that logs exceptions to files.
 * @author beibei
 */
public class FileLogger extends LogTemplate {
    private PrintWriter logStream;
   /**
    * Creates a new instance and also creates a new log file.
    **/
    public FileLogger(){
        try{
            logStream = new PrintWriter(new FileWriter("log.txt"), true);
        } catch (IOException ioe){
            System.out.println("Can not log.");
            ioe.printStackTrace();
        }
    }
    
    @Override
    protected void specificLog(Exception exception, StringBuilder logMsg){
        logStream.println(logMsg);
        exception.printStackTrace(logStream);
    }
}    
