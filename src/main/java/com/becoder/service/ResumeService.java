package com.becoder.service;

import java.util.List;
import java.util.Optional;

import com.becoder.entity.Resume;


public interface ResumeService {
       
	 public Resume saveResume(Resume resume);
	  
	  public List<Resume> getAllResume();
	  
	  public Resume getResumeById(Integer r_id);
	  
	  public String deleteResume(Integer r_id);
	  
	  public Resume editResume(Resume resume, Integer r_id );

	public Optional<Resume> findById(Integer r_id);

	public List<Resume> findByKeyword(String keyword);

	

	

	

}
