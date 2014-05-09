/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful;

import controllers.Factory;
import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import dk.cphbusiness.bank.contract.dto.TransferRequest;
import dk.cphbusiness.bank.contract.dto.TransferResponse;
import dk.cphbusiness.bank.contract.eto.InsufficientFundsException;
import dk.cphbusiness.bank.contract.eto.NoSuchAccountException;
import dk.cphbusiness.bank.contract.eto.TransferNotAcceptedException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author Frederik
 */
@Path("transfer")
public class TransferResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TransferResource
     */
    public TransferResource() {
    }

    /**
     * Retrieves representation of an instance of commands.TransferResource
     *
     * @return an instance of dk.cphbusiness.bank.contract.dto.TransferRequest
     */
    @GET
    @Produces("application/json")
    public TransferRequest getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public TransferResponse create(TransferRequest transfer) {
       
        try {
            BigDecimal amount = transfer.getAmount();
            AccountIdentifier source = transfer.getSource();
            AccountIdentifier target = transfer.getTarget();
            Factory.getInstance().getManager().transferAmount(amount, source, target);
            TransferResponse resp = new TransferResponse(true, "The transfer was succesfull");
            return resp;
        } catch (NoSuchAccountException ex) {
            TransferResponse resp = new TransferResponse(false, ex.getMessage());
            return resp;
        } catch (TransferNotAcceptedException ex) {
            TransferResponse resp = new TransferResponse(false, ex.getMessage());
            Logger.getLogger(TransferResource.class.getName()).log(Level.SEVERE, null, ex);
            return resp;
        } catch (InsufficientFundsException ex) {
            TransferResponse resp = new TransferResponse(false, ex.getMessage());
           Logger.getLogger(TransferResource.class.getName()).log(Level.SEVERE, null, ex);
            return resp;
        } 
    }

}
