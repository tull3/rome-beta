/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital.tull.project.faces.util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author will
 */
public class UserFile
{
    private static ObjectOutputStream output;
    private User user;
    
    public static void openFile()
    {
        try
        {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("keyfile")));
        }
        
        catch (IOException ex)
        {
            Logger.getLogger(UserFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void readRecords()
    {
        try
        {
            Scanner input = new Scanner(Paths.get("keyfile"));
        }
        
        catch (IOException ex)
        {
            Logger.getLogger(UserFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addRecord(User user)
    {
        try
        {
            output.writeObject(user);
        }
        
        catch (IOException ex)
        {
            Logger.getLogger(UserFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeFile()
    {
        try
        {
            if (output != null)
                output.close();
        }
        
        catch (IOException ex)
        {
            Logger.getLogger(UserFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
