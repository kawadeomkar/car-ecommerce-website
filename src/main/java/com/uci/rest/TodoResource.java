package com.uci.rest;

/**
 * Created by  on 5/28/17.
 */
import com.uci.rest.model.Todo;
import com.uci.rest.model.Cart;
import com.uci.rest.model.Order;
import com.uci.rest.service.TodoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.http.*;
import org.glassfish.jersey.media.multipart.FormDataParam;



/**
 * This class contains the methods that will respond to the various endpoints that you define for your RESTful API Service.
 *
 */
//todos will be the pathsegment that precedes any path segment specified by @Path on a method.
@Path("/todos")
public class TodoResource extends HttpServlet {


    //This method represents an endpoint with the URL /todos/{id} and a GET request ( Note that {id} is a placeholder for a path parameter)
    @Path("{id}")
    @GET
    @Produces( { MediaType.APPLICATION_JSON }) //This provides only JSON responses
    public Response getTodoById(@PathParam("id") String id/* The {id} placeholder parameter is resolved */) {
        //invokes the DB method which will fetch a todo_list item object by id
        Todo todo = TodoService.getTodoById(id);
        //Respond with a 404 if there is no such todo_list item for the id provided
        if(todo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        //Respond with a 200 OK if you have a todo_list_item object to return as response
        return Response.ok(todo).build();
    }
    
    @Path("/cart/{sessionID}")
    @GET
    @Produces( { MediaType.APPLICATION_JSON }) //This provides only JSON responses
    public Response getCartById(@PathParam("sessionID") String sessionID/* The {id} placeholder parameter is resolved */) {
        //invokes the DB method which will fetch a todo_list item object by id
        System.out.println("GETTING CART BY ID: " + sessionID );
        List<Cart> cart = TodoService.getShoppingCartByID(sessionID);
        System.out.println("GOT THE GOODS");
        //Respond with a 404 if there is no such todo_list item for the id provided
        if(cart == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        //Respond with a 200 OK if you have a todo_list_item object to return as response
        return Response.ok(cart).build();
    }

    //This method represents an endpoint with the URL /todos and a GET request.
    // Since there is no @PathParam mentioned, the /todos as a relative path and a GET request will invoke this method.
    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getAllTodos() {
        List<Todo> todoList = TodoService.getAllTodos();
        
        System.out.println("hello");

        if(todoList == null || todoList.isEmpty()) {

        }

        return Response.ok(todoList).build();
    }
    
    
    
    @Path("/orders")
    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getAllOrders() {
        List<Todo> todoList = TodoService.getAllTodos();
        
        System.out.println("hello");

        if(todoList == null || todoList.isEmpty()) {

        }

        return Response.ok(todoList).build();
    }

    //This method represents an endpoint with the URL /todos and a POST request.
    // Since there is no @PathParam mentioned, the /todos as a relative path and a POST request will invoke this method.
    @POST
    @Consumes({MediaType.APPLICATION_JSON}) //This method accepts a request of the JSON type
    public Response addCart() {

        //The todo object here is automatically constructed from the json request. Jersey is so cool!
        if(true) {
            return Response.ok().entity("Cart Added Successfully").build();
        }

        // Return an Internal Server error because something wrong happened. This should never be executed
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }

    //Similar to the method above.
    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED}) //This method accepts form parameters.
    //If you were to send a POST through a form submit, this method would be called.
    public void addCart(
            @FormParam("sessionID") String sessionID,
            @FormParam("id") String id,
            @FormParam("make") String make,
            @FormParam("model") String model
                ) {
        
        
        Cart cart = new Cart();
        
        
        cart.setID(id);
        cart.setsessionID(sessionID);
        cart.setmake(make);
        cart.setmodel(model);
        TodoService.AddCart(cart);
        
        
        //return Response.ok().entity("Cart Added Successfully").build();
       
    }
    //Similar to the method above.
    @POST
    @Path("/testing")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED}) //This method accepts form parameters.
    //If you were to send a POST through a form submit, this method would be called.
    public Response addOrder(
            @FormParam("id") String id,
            @FormParam("firstname") String firstname,
            @FormParam("lastname") String lastname,
            @FormParam("email") String email,
            @FormParam("phonenumber") String phonenumber,
            @FormParam("orderinfo") String orderinfo,
            @FormParam("productcolor") String productcolor,
            @FormParam("shippingaddress") String shippingaddress,
            @FormParam("city") String city,
            @FormParam("state") String state,
            @FormParam("zipcode") String zipcode,
            @FormParam("shippingmethod") String shippingmethod,
            @FormParam("ccnumber") String ccnumber) {
        
        
       
        Order order = new Order();
       
        order.setID(id);
        order.setfirstname(firstname);
        order.setlastname(lastname);
        order.setemail(email);
        order.setphonenumber(phonenumber);
        order.setorderinfo(orderinfo);
        order.setshippingaddress(shippingaddress);
        order.setcity(city);
        order.setstate(state);
        order.setzipcode(zipcode);
        order.setshippingmethod(shippingmethod);
        order.setccnumber(ccnumber);
        
        

        if(TodoService.AddOrder(order)) {
            return Response.ok().entity(" Added Successfully").build();
        }
        
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }

    //This method represents a PUT request where the id is provided as a path parameter and the request body is provided in JSON
    @PUT
    @Path("/order")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response storeOrder(Order order) {
        
        if(TodoService.AddOrder(order)) {
            return Response.ok().entity("Order was successfully added").build();
        }
        
        return Response.ok().entity("Order was NOT successfully added").build();
        

    }

    //This method represents a DELETE request where the id is provided as a path parameter and the request body is provided in JSON
    @DELETE
    @Path("/delete/{id}/{sessionID}")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    public Response deleteCart(@PathParam("id") String id, 
            @PathParam("sessionID") String sessionID) {

        //Retrieve the todo_object that you want to delete.
        Cart retrievedcart = TodoService.getCartById(id, sessionID);
        System.out.println(retrievedcart.getsessionID());
        
        
        TodoService.deleteCart(retrievedcart);
        // This calls the JDBC method which in turn calls the DELETE SQL command.
        if(true) {
            return Response.ok().entity("CART Deleted Successfully").build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }

}
