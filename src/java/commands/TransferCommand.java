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
import dk.cphbusiness.bank.contract.eto.InsufficientFundsException;
import dk.cphbusiness.bank.contract.eto.NoSuchAccountException;
import dk.cphbusiness.bank.contract.eto.TransferNotAcceptedException;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Ahmed Sadiq
 */
public class TransferCommand extends TargetCommand
{

    public TransferCommand(String target, List<SecurityRole> roles)
    {
	super(target, roles);
    }


    @Override
    public String execute(HttpServletRequest req)
    {
	BankManager manager = Factory.getInstance().getManager();

	BigDecimal amount = new BigDecimal(req.getParameter("amount"));
	AccountIdentifier source = AccountIdentifier.fromString(req.getParameter("sourceAccount"));
	AccountIdentifier target = AccountIdentifier.fromString(req.getParameter("targetAccount"));

	try {
	    AccountDetail account = manager.transferAmount(amount, source, target);
	    req.setAttribute("account", account);
	} catch (NoSuchAccountException ex) {
	    Logger.getLogger(TransferCommand.class.getName()).log(Level.SEVERE, null, ex);
	} catch (TransferNotAcceptedException ex) {
	    Logger.getLogger(TransferCommand.class.getName()).log(Level.SEVERE, null, ex);
	} catch (InsufficientFundsException ex) {
	    Logger.getLogger(TransferCommand.class.getName()).log(Level.SEVERE, null, ex);
	}
	return super.execute(req); //To change body of generated methods, choose Tools | Templates.
    }

}
