package com.becoder.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.becoder.entity.Resume;
import com.becoder.repository.ResumeRepo;



@Service
public class ResumeServiceImpl implements ResumeService{

	@Autowired
	private ResumeRepo resumeRepo;
	
	@Override
	public Resume saveResume(Resume resume) {
		Resume res=resumeRepo.save(resume);
		return res;
	}

	@Override
	public List<Resume> getAllResume() {
		
		return resumeRepo.findAll();
	}

//	@Override
//	public Resume getResumeById(int r_id)
//	{
//		Optional<Resume> stp = resumeRepo.findById(r_id); 
//		if(stp.isPresent()) {
//			return stp.get();
//		}
//		return null;
//	}

	@Override
	public String deleteResume(Integer r_id) {
	Resume resume=resumeRepo.findById(r_id).get();
	if (resume!=null) {
		resumeRepo.delete(resume);
		return "delete resume";
	}
		return"Something wrong on error" ;
	}

	@Override
	public Resume editResume(Resume resume, Integer r_id) {
		Resume resume2=resumeRepo.findById(r_id).get();
		resume2.setName(resume.getName());
		resume2.setAchivement(resume.getAchivement());
		resume2.setAddress(resume.getAddress());
		resume2.setC_name(resume.getC_name());
		resume2.setCity(resume.getCity());
		resume2.setDate(resume.getDate());
		resume2.setDegree_marks(resume.getDegree_marks());
		resume2.setDegreename(resume.getDegreename());
		resume2.setEmail(resume.getEmail());
		resume2.setExpe(resume.getExpe());
		resume2.setFather(resume.getFather());
		resume2.setHobbis(resume.getHobbis());
		resume2.setJoblocation(resume.getJoblocation());
		resume2.setLinkden(resume.getLinkden());
		resume2.setMobile(resume.getMobile());
		resume2.setMother(resume.getMother());
		resume2.setObjtive(resume.getObjtive());
		
		resume2.setPin(resume.getPin());
		resume2.setProject(resume.getProject());
		resume2.setShlname1(resume.getShlname1());
		resume2.setShlname2(resume.getShlname2());
		resume2.setSkills(resume.getSkills());
		resume2.setState(resume.getState());
		resume2.setTenthmarks(resume.getTenthmarks());
		resume2.setTewltmarks(resume.getTewltmarks());
		resume2.setU_name(resume.getU_name());
		return resumeRepo.save(resume2);
	}

	@Override
	public Optional<Resume> findById(Integer r_id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Resume getResumeById(Integer r_id) {
		Optional<Resume> stp = resumeRepo.findById(r_id); 
		if(stp.isPresent()) {
			return stp.get();
		}
		return null;
	}

	public List<Resume> findByKeyword(String keyword){
		return resumeRepo.findBykeyword(keyword);
	}
}
