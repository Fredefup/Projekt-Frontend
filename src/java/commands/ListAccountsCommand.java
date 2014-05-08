/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import controllers.Factory;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Ahmed Sadiq
 */
public class ListAccountsCommand extends TargetCommand
{

    public ListAccountsCommand(String target, List<SecurityRole> roles)
    {
	super(target, roles);
    }



    @Override
    public String execute(HttpServletRequest req)
    {
        
	BankManager manager = Factory.getInstance().getManager();
	CustomerIdentifier customer = CustomerIdentifier.fromString(req.getParameter("cpr"));
	Collection<AccountSummary> accounts = manager.listCustomerAccounts(customer);
	
	req.setAttribute("accounts", accounts);
	req.setAttribute("customer", customer);
	
	return super.execute(req); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
