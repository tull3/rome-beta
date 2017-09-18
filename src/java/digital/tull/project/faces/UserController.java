/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital.tull.project.faces;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import digital.tull.project.faces.util.User;
import digital.tull.project.faces.util.UserFile;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author will
 */

@Named("userController")
@SessionScoped
public class UserController implements Serializable

{
    private User current;
    private boolean admin = false;
    private boolean writer = false;
    private boolean guest = false;
    ExternalContext external = FacesContext.getCurrentInstance().getExternalContext();
    HttpServletRequest request = (HttpServletRequest) external.getRequest();
    
    public UserController ()
    {
            
    }
    
    public User getCurrent()
    {
        if (current == null)
        {
            current = new User();
        }
        
        return current;
    }
    
    
}
