package com.HospitalManagementSystem.services;
import static com.HospitalManagementSystem.dtos.DoctorDataBackinBean.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HospitalManagementSystem.custom_exception.NoSuchPatientFoundException;
import com.HospitalManagementSystem.daos.IDoctorDao;
import com.HospitalManagementSystem.daos.IEmployeeDao;
import com.HospitalManagementSystem.daos.IPatientDao;
import com.HospitalManagementSystem.daos.IUserDao;
import com.HospitalManagementSystem.dtos.DoctorDataBackinBean;
import com.HospitalManagementSystem.dtos.PatientDataBacking;
import com.HospitalManagementSystem.entities.Doctor;
import com.HospitalManagementSystem.entities.User;

@Service @Transactional
public class DoctorServices {
	@Autowired
	IUserDao userDao;
	@Autowired
	IEmployeeDao employeeDao;
	@Autowired
	IDoctorDao doctorDao;
	@Autowired
	IPatientDao patientDao;
	
	public List<DoctorDataBackinBean> getAllDoctors() {
		List<Doctor> doctors=doctorDao.findAll();
		List<DoctorDataBackinBean> doctorDetail=createDoctorsList(doctors);
		
		return doctorDetail;
		
	}

	public void updatePatientDetails(PatientDataBacking patientData) throws NoSuchPatientFoundException  {
		int updateCount;
		if(patientDao.existsById(patientData.getPatId()))
		 updateCount=patientDao.updatePatientPrescription(patientData.getPrescription(),patientData.getPatId());
		else
		throw new NoSuchPatientFoundException("patient  with id "+patientData.getPatId()+" does not exists");
	}
	
	

}
