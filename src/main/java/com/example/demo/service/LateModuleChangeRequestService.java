package com.example.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.LateChanges;
import com.example.demo.entity.LateModuleChangeRequest;
import com.example.demo.exception.FileStorageException;
import com.example.demo.repository.LateChangesRepository;
import com.example.demo.repository.LateModuleChangeRequestRepository;

@Service
public class LateModuleChangeRequestService {

	@Autowired
	private LateModuleChangeRequestRepository lateModuleChangeRequestRepository;

	@Autowired
	private LateChangesRepository lateChangesRepository;

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private StudentService studentService;

	public void submitLateModuleChangeRequest(int sid, MultipartFile annex, MultipartFile sgpa, String reason,
			String isTrainingCompleted, String mcode[], String addOrDrop[], int noOfAttendedLectures[],
			int noOfNotAttendedLectures[], int noOfMissedAssignments[]) {

		String fileName = StringUtils.cleanPath(annex.getOriginalFilename());
		String sgpaName = StringUtils.cleanPath(sgpa.getOriginalFilename());

		try {
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			if (sgpaName.contains("..")) {
				throw new FileStorageException("Sorry! SGPA name contains invalid path sequence " + sgpaName);
			}

			File convertFile = new File(
					"E:\\Spring Boot\\ugs\\src\\main\\resources\\static\\Upload Annex\\Late module change request\\"
							+ annex.getOriginalFilename());
			convertFile.createNewFile();
			FileOutputStream fout1 = new FileOutputStream(convertFile);
			fout1.write(annex.getBytes());
			fout1.close();

			String filePath = "E:\\Spring Boot\\ugs\\src\\main\\resources\\static\\Upload Annex\\Late module change request\\"
					+ annex.getOriginalFilename();

			File convertFileSgpa = new File(
					"E:\\Spring Boot\\ugs\\src\\main\\resources\\static\\Upload Annex\\Late module change request\\"
							+ sgpa.getOriginalFilename());
			convertFile.createNewFile();
			FileOutputStream fout2 = new FileOutputStream(convertFile);
			fout2.write(annex.getBytes());
			fout2.close();

			String sgpaPath = "E:\\Spring Boot\\ugs\\src\\main\\resources\\static\\Upload Annex\\Late module change request\\"
					+ sgpa.getOriginalFilename();

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date enteredDate = new Date();

			LateModuleChangeRequest req = new LateModuleChangeRequest(filePath, "", enteredDate, false,
					studentService.getStudent(sid), reason, sgpaPath, isTrainingCompleted, "Late");

			lateModuleChangeRequestRepository.save(req);

			List<LateChanges> lateChangesList = new ArrayList();

			for (int i = 0; i < mcode.length; i++) {

				LateChanges lateChanges = new LateChanges(req, moduleService.getModuleById(mcode[i]),
						noOfAttendedLectures[i], noOfNotAttendedLectures[i], noOfMissedAssignments[i], "",
						addOrDrop[i]);

				lateChangesList.add(lateChanges);
			}

			lateChangesRepository.saveAll(lateChangesList);

		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public LateModuleChangeRequest getRequest(int rid) {
		return lateModuleChangeRequestRepository.findById(rid).orElse(null);
	}

	public LateModuleChangeRequest getLateModuleChangeRequest(int rid) {

		return lateModuleChangeRequestRepository.findById(rid).orElse(null);
	}
	
	public List<LateModuleChangeRequest> getAllLateModuleChangeRequest(){
		return lateModuleChangeRequestRepository.findAll();
	}

	public List<LateModuleChangeRequest> pastLateModuleChangeRequest(int sid) {

		return lateModuleChangeRequestRepository.findByStd(studentService.getStudent(sid));
	}

	public LateModuleChangeRequest updateRequest(LateModuleChangeRequest request) {

		LateModuleChangeRequest existingRequest = getRequest(request.getRid());

		existingRequest.setDecision(request.getDecision());

		lateModuleChangeRequestRepository.save(existingRequest);

		return existingRequest;
	}
}
