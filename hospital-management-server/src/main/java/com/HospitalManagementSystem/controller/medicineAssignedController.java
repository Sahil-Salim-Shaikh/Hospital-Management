package com.HospitalManagementSystem.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HospitalManagementSystem.dtos.MedicineAssignedDataBackinBean;
import com.HospitalManagementSystem.dtos.Response;
import com.HospitalManagementSystem.services.MedicineAssignedServices;

@CrossOrigin("*")
@RestController@RolesAllowed({"ROLE_DOCTOR","ROLE_ADMIN"})
@RequestMapping("/api/medicinesAssigned")
public class medicineAssignedController {
	@Autowired
	MedicineAssignedServices medicineAssignedServices;

	@PostMapping("/addMedicineToPatient")
	public void addMedicineToPatient(@RequestBody MedicineAssignedDataBackinBean assignedMedicine) {
		medicineAssignedServices.addMedicineToPatient(assignedMedicine);

	}

	@DeleteMapping("/removeMedicineAssigned/{id}")
	public ResponseEntity<?> deletePatientById(@PathVariable("id") int medicineAssignId) {
		medicineAssignedServices.removeMedicineOfPatient(medicineAssignId);
		return Response.success("success removed");

	}

}
