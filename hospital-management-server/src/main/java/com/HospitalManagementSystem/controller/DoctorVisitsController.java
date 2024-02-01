package com.HospitalManagementSystem.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HospitalManagementSystem.dtos.DoctorDataBackinBean;
import com.HospitalManagementSystem.dtos.DoctorVisitsDataBackinBean;
import com.HospitalManagementSystem.dtos.PatientDataBacking;
import com.HospitalManagementSystem.dtos.Response;
import com.HospitalManagementSystem.dtos.WardDataBackinBean;
import com.HospitalManagementSystem.services.DoctorServices;
import com.HospitalManagementSystem.services.DoctorVisitsServices;
import com.HospitalManagementSystem.services.PatientServices;
import com.HospitalManagementSystem.services.WardServices;

@CrossOrigin("*")
@RestController@RolesAllowed("ROLE_DOCTOR")
@RequestMapping("/api/doctorVisit")
public class DoctorVisitsController {
	@Autowired
	DoctorVisitsServices visitServices;



	@PostMapping("/addVisit")
	public ResponseEntity<?> addWard(@RequestBody DoctorVisitsDataBackinBean visitData) {
		int updateCount = visitServices.addVisit(visitData);
		if (updateCount == 1)
			return Response.success("VISIT_ADDED");
		return Response.success("FAILED");
	}

	

}
