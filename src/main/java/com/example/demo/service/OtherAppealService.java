package com.example.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.LeaveRequest;
import com.example.demo.entity.OtherAppeal;
import com.example.demo.exception.FileStorageException;
import com.example.demo.repository.OtherAppealRepository;


@Service
public class OtherAppealService {

	@Autowired
	private OtherAppealRepository repo;

	@Autowired
	private StudentService studentService;

	public OtherAppeal submiOtherAppeal(int sid, String appealbrief, String appealSummary, String isTrainingCompleted, MultipartFile annex, MultipartFile sgpa) {

		String fileName = StringUtils.cleanPath(annex.getOriginalFilename());
		String sgpaName = StringUtils.cleanPath(sgpa.getOriginalFilename());

		try {
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			if (sgpaName.contains("..")) {
				throw new FileStorageException("Sorry! SGPA name contains invalid path sequence " + sgpaName);
			}

			File convertFile = new File("E:\\Spring Boot\\ugs\\src\\main\\resources\\static\\Upload Annex\\Other appeal\\" + annex.getOriginalFilename());
			convertFile.createNewFile();
			FileOutputStream fout1 = new FileOutputStream(convertFile);
			fout1.write(annex.getBytes());
			fout1.close();

			String filePath = "E:\\Spring Boot\\ugs\\src\\main\\resources\\static\\Upload Annex\\Other appeal\\" + annex.getOriginalFilename();

			File convertFileSgpa = new File("E:\\Spring Boot\\ugs\\src\\main\\resources\\static\\Upload Annex\\Other appeal\\"
							+ sgpa.getOriginalFilename());
			convertFile.createNewFile();
			FileOutputStream fout2 = new FileOutputStream(convertFile);
			fout2.write(annex.getBytes());
			fout2.close();

			String sgpaPath = "E:\\Spring Boot\\ugs\\src\\main\\resources\\static\\Upload Annex\\Other appeal\\"
					+ sgpa.getOriginalFilename();

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date enteredDate = new Date();

			OtherAppeal otherAppeal = new OtherAppeal(filePath, "", enteredDate, false, studentService.getStudent(sid),
					appealbrief, appealSummary, sgpaPath, isTrainingCompleted, "Appeal");

			return repo.save(otherAppeal);
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}
	
	public OtherAppeal getRequest(int rid) {
		return repo.findById(rid).orElse(null);
	}
	
	@GetMapping("/pastrequest/getallappeal")
	public List<OtherAppeal> getAllOtherAppeal(){
		return repo.findAll();
	}
	
	public List<OtherAppeal> pastOtherAppeal(int sid) {
		
		return repo.findByStd(studentService.getStudent(sid));
	}
	
	public OtherAppeal updateAppeal(OtherAppeal appeal) {
		
		System.out.println(appeal.getRid());
		
		OtherAppeal existingRequest = getRequest(appeal.getRid());
		
		existingRequest.setDecision(appeal.getDecision());
		
		repo.save(existingRequest);
		
		return existingRequest;
	}
}
