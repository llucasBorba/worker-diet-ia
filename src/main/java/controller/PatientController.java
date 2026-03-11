package controller;

import entity.Patient;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.PatientService;

import java.util.List;

@Path("/patient")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PatientController {

    @Inject
    PatientService patientService;

    @GET
    public List<PanacheEntityBase> getAllPatients(){
        return patientService.getAll();
    }
}
