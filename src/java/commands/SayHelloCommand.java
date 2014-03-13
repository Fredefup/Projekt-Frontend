/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.serviceEndpointInterfaceMappingType;
import controllers.Factory;
import dk.cphbusiness.bank.contract.BankManager;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Frederik
 */
public class SayHelloCommand extends TargetCommand {

    public SayHelloCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }

    

    @Override
    public String execute(HttpServletRequest req) {
        BankManager manager = Factory.getInstance().getManager();
        String greeting = manager.sayHello("kurt");
        req.setAttribute("greeting", greeting);
        return super.execute(req); //To change body of generated methods, choose Tools | Templates.
    }
    
}
