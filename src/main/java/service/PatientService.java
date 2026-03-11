package service;

import dto.CreatePatientDTO;
import entity.Patient;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PatientService {

    @Transactional
    public Patient createPatient(CreatePatientDTO dto){
        Patient patient = new Patient();
        patient.age = dto.age();
        patient.name = dto.name();
        patient.caloricGoal = dto.caloricGoal();
        patient.height = dto.height();
        patient.weight = dto.weight();
        patient.restrictions = dto.restrictions();
        patient.persist();

        return patient;
    }
    public Patient findById(long id){
        return Patient.findById(id);
    }

    public List<PanacheEntityBase> getAll(){
        return Patient.listAll();
    }
}
