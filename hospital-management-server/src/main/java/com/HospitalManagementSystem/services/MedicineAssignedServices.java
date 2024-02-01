package com.HospitalManagementSystem.services;
import static com.HospitalManagementSystem.dtos.WardDataBackinBean.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HospitalManagementSystem.custom_exception.NoSuchMedicineExistsException;
import com.HospitalManagementSystem.daos.IDoctorDao;
import com.HospitalManagementSystem.daos.IEmployeeDao;
import com.HospitalManagementSystem.daos.IMedicineAssignedDao;
import com.HospitalManagementSystem.daos.IMedicineDao;
import com.HospitalManagementSystem.daos.IUserDao;
import com.HospitalManagementSystem.daos.IWardDao;
import com.HospitalManagementSystem.dtos.DoctorDataBackinBean;
import com.HospitalManagementSystem.dtos.MedicineAssignedDataBackinBean;
import com.HospitalManagementSystem.dtos.WardDataBackinBean;
import com.HospitalManagementSystem.entities.User;
import com.HospitalManagementSystem.entities.Ward;

@Service @Transactional
public class MedicineAssignedServices {
	@Autowired
	IUserDao userDao;
	@Autowired
	IEmployeeDao employeeDao;
	@Autowired
	IWardDao wardDao;
	@Autowired
	IMedicineAssignedDao medicineAssingedDao;
	@Autowired
	IMedicineDao medicineDao;
	
	public void addMedicineToPatient(MedicineAssignedDataBackinBean medicineData) throws NoSuchMedicineExistsException {
		
			medicineAssingedDao.addIntoMedicineAssigned(medicineData.getPatId(), medicineData.getMedicineId(), medicineData.getMedicinePrescription(), medicineData.getMedicineQty());
		
		
		
	}
	
	public void removeMedicineOfPatient(int medicineAssignId) {
		medicineAssingedDao.deleteById(medicineAssignId);
	}
	
	
	
	

}
