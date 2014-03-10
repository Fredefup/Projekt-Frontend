/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Ahmed Sadiq
 */
public class EditAccountCommand extends TargetCommand
{

    public EditAccountCommand(String target, List<SecurityRole> roles)
    {
	super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest req)
    {
	CustomerIdentifier customer = CustomerIdentifier.fromString(req.getParameter("cpr"));
	req.setAttribute("customer", customer);
	return super.execute(req); //To change body of generated methods, choose Tools | Templates.
    }
    
}
