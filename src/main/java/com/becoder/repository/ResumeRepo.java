package com.becoder.repository;

import java.io.Serializable;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.becoder.entity.Resume;




@Repository
/*public interface ResumeRepo extends JpaRepository<Resume, Integer>{*/
public interface ResumeRepo extends JpaRepository<Resume, Serializable>{
	
//	@Query(value = "SELECT * FROM STUDENT_Resume e WHERE " +
//	        "e.name LIKE :keyword " +
//	        "OR e.father LIKE :keyword " +
//	        "OR e.mother LIKE :keyword " +
//	        "OR e.email LIKE :keyword " +
//	        "OR e.linkden LIKE :keyword", nativeQuery = true)
//	List<Resume> findBykeyword(@Param("keyword") String keyword);
//
//	
	@Query(value="select * from STUDENT_Resume e where e.name like %:keyword% or e.father like %:keyword% or e.mother like %:keyword% or e.mobile like %:keyword% or e.email like %:keyword% " , nativeQuery=true)
	List<Resume> findBykeyword(@Param("keyword") String keyword);


	
	
	

}
