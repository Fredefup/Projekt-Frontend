/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Ahmed Sadiq
 */
public class TargetCommand implements Command
{
    private final String target;
    List<SecurityRole> roles;

    public TargetCommand(String target,List<SecurityRole> roles)
    {
	this.target = target;
	this.roles = roles;
    }

    public List<SecurityRole> getRoles()
    {
	return roles;
    }

    
    @Override
    public String execute(HttpServletRequest req)
    {
	return target;
    }
    
}
