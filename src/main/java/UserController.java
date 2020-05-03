import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.xml.ws.Response;

public class UserController {
    private UserInteractor userInteractor;

    public UserController(){
        userInteractor=new UserInteractor();
    }

    @GET
    public String hello(){
        return "hello";
    }

    @GET
    @Path("/{id}")
    public Response getUserByID(@PathParam("id")long id){
        User user= userInteractor.getUserByID(id);
        if(user==null){
            return Response.status(Response.Status.NOT_FOUD)
                    .entitty("There is no user with such id")
                    .build ();
        }
        else{
            return  Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(user)
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/add")
    public Response addUser(@FormDataParam("name") String name,
                            @FormDataParam("surname") String surname,
                            @FormDataParam("username") String username,
                            @FormDataParam("password") String password){
        userInteractor.addUser(name,surname,username,password);
        return Response.status(200).entity("User created").build();
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/update")
    public Response updateUser(@FormDataParam("name") String name,
                            @FormDataParam("surname") String surname,
                            @FormDataParam("username") String username,
                            @FormDataParam("password") String password){
        userInteractor.updateUser(name,surname,username,password);
        return Response.status(200).entity("User updated").build();
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/remove")
    public Response removeUser(@FormDataParam("name") String name,
                            @FormDataParam("surname") String surname,
                            @FormDataParam("username") String username,
                            @FormDataParam("password") String password){
        userInteractor.removeUser(name,surname,username,password);
        return Response.status(200).entity("User deleted").build();
    }
}
