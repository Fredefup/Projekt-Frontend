/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import controllers.Factory;
import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CheckingAccountDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.eto.CustomerBannedException;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Ahmed Sadiq
 */
public class AddAccountCommand extends TargetCommand
{

    public AddAccountCommand(String target, List<SecurityRole> roles)
    {
	super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest req)
    {
	BankManager manager = Factory.getInstance().getManager();
	CustomerIdentifier customer = CustomerIdentifier.fromString(req.getParameter("cpr"));
	
	BigDecimal interest = new BigDecimal(req.getParameter("interest"));
	
//	int lastaccount = manager.listAccounts().size();
//	ArrayList<AccountSummary> accounts = new ArrayList(manager.listAccounts());
//	String lastaccountnumber = accounts.get(lastaccount-1).getNumber();
//	String firstpart = lastaccountnumber.substring(0, 5);
//	int lastpart = Integer.parseInt(lastaccountnumber.substring(5));
//	int number = lastpart++;
//	String accountnr = firstpart+number;
	
	AccountDetail account = new CheckingAccountDetail(interest);
	
	try {
	    manager.createAccount(customer, account);
	} catch (NoSuchCustomerException ex) {
	    Logger.getLogger(AddAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
	} catch (CustomerBannedException ex) {
	    Logger.getLogger(AddAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
	}
	Collection<AccountSummary> accounts = manager.listCustomerAccounts(customer);
	
	req.setAttribute("customer", customer);
	req.setAttribute("accounts", accounts);
	
	return super.execute(req); //To change body of generated methods, choose Tools | Templates.
    }
}
