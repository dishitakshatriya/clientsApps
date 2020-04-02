/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jaxrsclientmovie.restservices;

import com.mycompany.jaxrsclientmovie.services.Exception_Exception;
import com.mycompany.jaxrsclientmovie.services.MoviesWebService;
import com.mycompany.jaxrsclientmovie.services.MoviesWebService_Service;
import com.mycompany.jaxrsclientmovie.services.Moviestvshow;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author dishi
 */
@Path("/home")
public class ClientService {
   
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() throws Exception_Exception {
        return Response.ok()
          .entity(new MoviesWebService_Service().getMoviesWebServicePort().findAll())
          .build();
    }  
    
    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }   
    
    @GET
    @Path("/all/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("id") int id){
        MoviesWebService_Service service = new MoviesWebService_Service();
        MoviesWebService port = service.getMoviesWebServicePort();
        Moviestvshow show =port.findContent(id);
        return Response.ok(show).build();
    }
}
