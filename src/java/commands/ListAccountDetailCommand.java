/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import controllers.Factory;
import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Ahmed Sadiq
 */
public class ListAccountDetailCommand extends TargetCommand
{

    public ListAccountDetailCommand(String target, List<SecurityRole> roles)
    {
	super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest req)
    {
	BankManager manager = Factory.getInstance().getManager();
	CustomerIdentifier customer = CustomerIdentifier.fromString(req.getParameter("cpr"));
	AccountIdentifier accountNr = AccountIdentifier.fromString(req.getParameter("accountNr"));
	AccountDetail account = manager.showAccountHistory(accountNr);
	
	req.setAttribute("customer", customer);
	req.setAttribute("account", account);
	
	return super.execute(req);
    }
}
