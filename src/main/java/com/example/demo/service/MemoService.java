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
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Memo;
import com.example.demo.exception.FileStorageException;
import com.example.demo.repository.MemoRepository;

@Service
public class MemoService {

	@Autowired
	private MemoRepository repo;
	
	@Autowired
	private FACMemberService facService;
	
	public Memo postMemo(int facid, String description1, MultipartFile annex) {
		
		String fileName = StringUtils.cleanPath(annex.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            
            File convertFile = new File("E:\\Spring Boot\\ugs\\src\\main\\resources\\static\\Upload Annex\\Memo\\"+annex.getOriginalFilename());
    		convertFile.createNewFile();
    		FileOutputStream fout = new FileOutputStream(convertFile);
    		fout.write(annex.getBytes());
    		fout.close();
    		
    		String filePath = "E:\\Spring Boot\\ugs\\src\\main\\resources\\static\\Upload Annex\\Memo\\"+annex.getOriginalFilename();
    		
    		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    		Date enteredDate = new Date();
    		
    		Memo memo = new Memo(description1,filePath, enteredDate, facService.getFACMember(facid), "");
    		return repo.save(memo);
    		
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
	}
	
	public Memo getMemo(int mid) {
		return repo.findById(mid).orElse(null);
	}
	
	public List<Memo> getAllMemo(){
		return repo.findAll();
	}
	
	public List<Memo> getMemoByFacId(int facId){
		return repo.findByFacMember(facService.getFACMember(facId));
	}
}
