/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital.tull.project.faces.util;

import java.io.Serializable;

/**
 *
 * @author will
 */
public class User implements Serializable
{
    private String username;
    private String passwd;
    private String role;
    
    public User()
    {
        
    }
    
    public User(String username, String passwd, String role)
    {
        this.username = username;
        this.passwd = passwd;
        this.role = role;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setPasswd(String passwd)
    {
        this.passwd = passwd;
    }
    
    public String getPasswd()
    {
        return passwd;
    }
    
    public void setRole(String role)
    {
        this.role = role;
    }
    
    public String getRole()
    {
        return role;
    }
}
