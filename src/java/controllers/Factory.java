/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import commands.AddAccountCommand;
import commands.Command;
import commands.EditAccountCommand;
import commands.EditCustomerCommand;
import commands.EditTransferCommand;
import commands.ListAccountDetailCommand;
import commands.ListAccountsCommand;
import commands.ListCustomersCommand;
import commands.LoginCommand;
import commands.LogoutCommand;
import commands.SaveCustomerCommand;
import commands.ShowLoginCommand;
import commands.TargetCommand;
import commands.TransferCommand;
import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.dummy.bank.control.DummyBankManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Ahmed Sadiq
 */
public class Factory
{
    private static Factory instance = null;
     private final Map<String,Command> commands = new HashMap<>();
    private final BankManager manager;
    
    private Factory(){
	manager = new DummyBankManager();
	
	commands.put("back",new TargetCommand("all/main.jsp",Arrays.asList(SecurityRole.All)));
	commands.put("main", new TargetCommand("all/main.jsp",Arrays.asList(SecurityRole.All)));
	commands.put("showlogin", new ShowLoginCommand("/login/login.jsp", Arrays.asList(SecurityRole.All)));
	
	
	Map<SecurityRole, String> roles = new HashMap();
	roles.put(SecurityRole.Employee, "/employee/startEmployeePage.jsp");
	roles.put(SecurityRole.SuperEmployee, "/employee/startEmployeePage.jsp");
	roles.put(SecurityRole.Customer, "/customer/startCustomerPage.jsp");
	commands.put("login", new LoginCommand(roles, "/login/login.jsp"));
	commands.put("logout", new LogoutCommand("/all/main.jsp", Arrays.asList(SecurityRole.All)));


	commands.put("employee-main", new TargetCommand("employee/startEmployeePage.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));

	commands.put("create-customer", new TargetCommand("/superEmployee/customer-edit.jsp", Arrays.asList(SecurityRole.SuperEmployee)));
	commands.put("save-customer", new SaveCustomerCommand("/employee/customer-list.jsp",Arrays.asList(SecurityRole.SuperEmployee)));
	commands.put("add-account", new EditAccountCommand("/superEmployee/account-edit.jsp", Arrays.asList(SecurityRole.SuperEmployee)));
	commands.put("edit-customer", new EditCustomerCommand("/superEmployee/customer-edit.jsp", Arrays.asList(SecurityRole.SuperEmployee)));
	commands.put("save-account", new AddAccountCommand("/employee/account-list.jsp", Arrays.asList(SecurityRole.SuperEmployee)));
	
	commands.put("list-customers",new ListCustomersCommand("employee/customer-list.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));
	commands.put("list-accounts",new ListAccountsCommand("employee/account-list.jsp",Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee, SecurityRole.Employee)));
	commands.put("detail-account", new ListAccountDetailCommand("employee/account-detail.jsp",Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee, SecurityRole.Employee)));
	commands.put("edit-transfer", new EditTransferCommand("employee/transfer-edit.jsp",Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee, SecurityRole.Employee)));
	commands.put("detail-account-transaction", new TransferCommand("employee/account-detail.jsp",Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee, SecurityRole.Employee)));
	commands.put("cancel-transaction", new ListCustomersCommand("employee/customer-list.jsp",Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee, SecurityRole.Employee)));
    }
    
    public static Factory getInstance(){
	if(instance == null) instance = new Factory();
	return instance;
    }

    public BankManager getManager()
    {
	return manager;
    }
    public Command getCommand(String cmdStr, HttpServletRequest request)
    {
	if (cmdStr == null) {
	    cmdStr = "main";
	}
	Command cmd = commands.get(cmdStr);
	SecurityCheck(cmd, request);
	return cmd;
    }
        private void SecurityCheck(Command command, HttpServletRequest request) throws SecurityException
    {
	if (command instanceof TargetCommand) {
	    List<SecurityRole> requiredRoles = ((TargetCommand) command).getRoles();
	    boolean requiredRoleFound = false;
	    for (SecurityRole requiredRole : requiredRoles) {
		if (requiredRole == SecurityRole.All || request.isUserInRole(requiredRole.toString())) {
		    requiredRoleFound = true;
		    break;
		}
	    }
	    if (!requiredRoleFound) {
		throw new SecurityException("You don't have the necessary rights to perform this command");
	    }
	}
    }
}
