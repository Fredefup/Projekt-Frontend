package commands;

import controllers.Factory;
import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.dto.CustomerSummary;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import dk.cphbusiness.dummy.bank.model.Person;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import security.SecurityRole;
import static security.SecurityRole.Customer;

/**
 * @author Lars Mortensen
 */
public class SaveCustomerCommand extends TargetCommand
{

    public SaveCustomerCommand(String target, List<SecurityRole> roles)
    {
	super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest req)
    {
	BankManager manager = Factory.getInstance().getManager();

	try {
	    String cpr = req.getParameter("cpr");
	    CustomerIdentifier customerid = CustomerIdentifier.fromString(cpr);
	    CustomerDetail customer = manager.showCustomer(customerid);
	    Person person = Person.find(cpr);
	    person.setTitle(req.getParameter("title"));
	    person.setFirstName(req.getParameter("fname"));
	    person.setLastName(req.getParameter("lname"));
	    person.setStreet(req.getParameter("address"));
	    person.setPostalCode(req.getParameter("postcode"));
	    person.setPostalDistrict(req.getParameter("city"));
	    person.setPhone(req.getParameter("phone"));
	    person.setEmail(req.getParameter("email"));
	    
	    Collection<CustomerSummary> customers = manager.listCustomers();
	    req.setAttribute("customers", customers);
	} catch (NoSuchCustomerException ex) {
	    String title = req.getParameter("title");
	    String cpr = req.getParameter("cpr");
	    String fname = req.getParameter("fname");
	    String lname = req.getParameter("lname");
	    String address = req.getParameter("address");
	    String postcode = req.getParameter("postcode");
	    String city = req.getParameter("city");
	    String phone = req.getParameter("phone");
	    String email = req.getParameter("email");
	    CustomerDetail customer = new CustomerDetail(cpr, title, fname, lname, address, postcode, city, phone, email);
	    manager.saveCustomer(customer);

	    Collection<CustomerSummary> customers = manager.listCustomers();
	    req.setAttribute("customers", customers);
	}
	return super.execute(req);
    }
}
