/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import controllers.Factory;
import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.dto.CustomerSummary;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Ahmed Sadiq
 */
public class EditCustomerCommand extends TargetCommand
{

    public EditCustomerCommand(String target, List<SecurityRole> roles)
    {
	super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest req)
    {
	BankManager manager = Factory.getInstance().getManager();
	CustomerIdentifier cpr = CustomerIdentifier.fromString(req.getParameter("cpr"));
	
	try {
	    CustomerDetail customer = manager.showCustomer(cpr);
	    req.setAttribute("customer", customer);
	} catch (NoSuchCustomerException ex) {
	    Logger.getLogger(EditCustomerCommand.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return super.execute(req); //To change body of generated methods, choose Tools | Templates.
    }
    
}
