package org.acme.controller;

import java.util.List;
import org.acme.dto.CustomerDTO;
import org.acme.service.CustomerService;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/customers")
public class CustomerController {

    @Inject
    CustomerService customerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDTO> findAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GET
    @Path("/{id}/")
    public CustomerDTO findCustomerById(@PathParam("id") Long id){
        return customerService.findCustomerById(id);
    }


    @POST
    @Transactional
    public Response saveCustomer(CustomerDTO customerDTO){
        try {
            customerService.createCustomer(customerDTO);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return  Response.serverError().build();
        }
    } 

    @PUT
    @Path("/{id}/")
    @Transactional
    public Response changeCustomer(@PathParam("id") Long id, CustomerDTO customerDTO){
        try {
            customerService.changeCustomer(id, customerDTO);
            return Response.accepted().build();
        } catch (Exception e) {
            e.printStackTrace();
            return  Response.serverError().build();
        }
    } 

    @DELETE
    @Path("/{id}/")
    @Transactional
    public Response deleteCustomer(@PathParam("id") Long id){
        try {
            customerService.deleteCustomer(id);
            return Response.accepted().build();
        } catch (Exception e) {
            e.printStackTrace();
            return  Response.serverError().build();
        }
    } 
}
