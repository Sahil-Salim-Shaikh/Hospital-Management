package com.HospitalManagementSystem.services;
import static com.HospitalManagementSystem.dtos.MedicineAssignedDataBackinBean.*;
import static com.HospitalManagementSystem.dtos.WardDataBackinBean.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HospitalManagementSystem.daos.IDoctorDao;
import com.HospitalManagementSystem.daos.IEmployeeDao;
import com.HospitalManagementSystem.daos.IMedicineAssignedDao;
import com.HospitalManagementSystem.daos.IMedicineDao;
import com.HospitalManagementSystem.daos.IUserDao;
import com.HospitalManagementSystem.daos.IWardDao;
import com.HospitalManagementSystem.dtos.DoctorDataBackinBean;
import com.HospitalManagementSystem.dtos.MedicineAssignedDataBackinBean;
import com.HospitalManagementSystem.dtos.WardDataBackinBean;
import com.HospitalManagementSystem.entities.Medicine;
import com.HospitalManagementSystem.entities.User;
import com.HospitalManagementSystem.entities.Ward;

@Service @Transactional
public class MedicineServices {
	@Autowired
	IUserDao userDao;
	@Autowired
	IEmployeeDao employeeDao;
	@Autowired
	IWardDao wardDao;
	@Autowired
	IMedicineDao medicineDao;
	@Autowired
	IMedicineAssignedDao medicineAssingedDao;
	
	public List<MedicineAssignedDataBackinBean> getAllMedicines(){
		List<Medicine> medicine=medicineDao.findAll();
		List<MedicineAssignedDataBackinBean> medicinesTosend=createAllMedicineList(medicine);
		return medicinesTosend;
		
	}

	public int addMedicine(MedicineAssignedDataBackinBean medicineData) {
		return  medicineDao.insertIntoMedicineTable(0, medicineData.getMedicineName(), medicineData.getMedicinePrice());
		
	}

	public void removeMedicine(int medicineId) {
		medicineDao.deleteById(medicineId);
		
	}
	
	
	
	
	

}
