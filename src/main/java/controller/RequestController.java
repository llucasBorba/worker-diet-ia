package controller;

import dto.RequestDTO;
import dto.ResponseDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.DietAgentAssistant;

@Path("/request")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RequestController {

    @Inject
    DietAgentAssistant assistant;
    @POST
    public ResponseDTO request(RequestDTO userMessage){
        return new ResponseDTO(assistant.chat(userMessage.request()));
    }

}
