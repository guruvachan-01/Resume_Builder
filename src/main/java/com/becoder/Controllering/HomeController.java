package com.becoder.Controllering;

import java.security.Principal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.becoder.entity.Resume;
import com.becoder.entity.User;
import com.becoder.repository.ResumeRepo;
import com.becoder.repository.UserRepo;
import com.becoder.service.ResumeService;
import com.becoder.service.UserService;


import jakarta.servlet.http.HttpSession;

@Controller

public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ResumeRepo resumeRepo;
	
	@Autowired
	private ResumeService resumeService;

	@ModelAttribute
	public void commonUser(Principal p, Model m) {
		if (p != null) {
			String email = p.getName();
			User user = userRepo.findByEmail(email);
			m.addAttribute("user", user);
		}

	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@GetMapping("/user/register")
	public String register1() {
		return "register";
	}
	

	@GetMapping("/signin")
	public String login() {
		return "login";
	}
	@GetMapping("/user/signin")
	public String login1() {
		return "login";
	}
	
	
	  @GetMapping("/user/profile") 
	  public String profile(Principal p, Model m) {
	  String email = p.getName(); 
	  User user = userRepo.findByEmail(email);
	  m.addAttribute("user", user); 
	  return "profile";
	  }
	  
		@GetMapping("/user/university")
		public String univerity() {
			return "university";
		}
		
		
		@GetMapping("/fulldata")
		public String form() {
			return "fulldata";
		}
		
		
		@GetMapping("/user/school")
		public String school() {
			return "school";
		}
		@GetMapping("/user/other")
		public String other() {
			return "other";
		}
	  
	  
	  
	  @GetMapping("/user/home") 
	  public String home() {
		  return "home";
		  }
	 
	  

		@GetMapping("/user/fulldata")
		public String openAddStudent(Model m) {
			
			m.addAttribute("title", "Add Student");
			m.addAttribute("res", new Resume());

			return "fulldata";
		}
		
		@GetMapping("/user/user_profile")
		public String user_profile() {
			return "user_profile";
		}

		@GetMapping("/user/resumeview/{r_id}")
		public String openViewResume(@PathVariable("r_id") Integer r_id,Model m) {
			
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			
			return "resumeview";
		}
		@GetMapping("/user/userDetails")
		public String showResume(Model m) {
			
			List<Resume> res = resumeService.getAllResume();
			
			m.addAttribute("title", "View Students");
			m.addAttribute("res", res);
			
			return "userDetails";
		}

		

		@GetMapping("/user/editresume/{r_id}")
		public String openUpdateStudentPersonal(@PathVariable int r_id, Model m) {
			
			m.addAttribute("title", "Update Students");
			Resume stp = resumeService.getResumeById(r_id);
			m.addAttribute("sti", stp);
			
			return "user/editresume";
		}

		@GetMapping("/user/updateresume")
		public String UpdateResume( @ModelAttribute Resume resume, HttpSession session) {
			
			resumeService.saveResume(resume);
			session.setAttribute("msg", "Student' details updated successsfully !");
			
			return "redirect:/user/editresume";
		}
		
		
		
		@GetMapping("/user/delete/{r_id}")
		public String deleteResume(@PathVariable int r_id, HttpSession session) {
			
			resumeService.deleteResume(r_id);
			session.setAttribute("msg", "Student's personal details deleted successsfully...");
			
			return "resumeview";
		}

		
		
		@PostMapping("/user/save")
		public String saveStudent(@ModelAttribute Resume resume, HttpSession session) {

			System.out.println(resume);
			resumeService.saveResume(resume);

			session.setAttribute("msg", "Student's personal details added successfully !");
		
			return "redirect:/fulldata";  
		}
		
		
		
		
	
		
		
		@RequestMapping("/user/resume01/{r_id}")
		public String openShowResume1(@PathVariable("r_id") Integer r_id, Model m) {
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			

			return "resume01";
		}
		
		@RequestMapping("/user/resume02/{r_id}")
		public String openShowResume02(@PathVariable("r_id") Integer r_id, Model m) {
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			

			return "resume02";
		}
		@RequestMapping("/user/resume03/{r_id}")
		public String openShowResume03(@PathVariable("r_id") Integer r_id, Model m) {
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			

			return "resume03";
		}
		@RequestMapping("/user/resume04/{r_id}")
		public String openShowResume04(@PathVariable("r_id") Integer r_id, Model m) {
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			

			return "resume04";
		}
		@RequestMapping("/user/resume05/{r_id}")
		public String openShowResume05(@PathVariable("r_id") Integer r_id, Model m) {
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			

			return "resume05";
		}
		
		@RequestMapping("/user/resume06/{r_id}")
		public String openShowResume06(@PathVariable("r_id") Integer r_id, Model m) {
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			

			return "resume06";
		}
		
		@RequestMapping("/user/resume07/{r_id}")
		public String openShowResume07(@PathVariable("r_id") Integer r_id, Model m) {
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			

			return "resume07";
		}
		
		@RequestMapping("/user/resume08/{r_id}")
		public String openShowResume08(@PathVariable("r_id") Integer r_id, Model m) {
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			

			return "resume08";
		}
		
		@RequestMapping("/user/resume09/{r_id}")
		public String openShowResume09(@PathVariable("r_id") Integer r_id, Model m) {
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			

			return "resume09";
		}
		@RequestMapping("/user/resume10/{r_id}")
		public String openShowResume10(@PathVariable("r_id") Integer r_id, Model m) {
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			

			return "resume10";
		}
		@RequestMapping("/user/resume11/{r_id}")
		public String openShowResume11(@PathVariable("r_id") Integer r_id, Model m) {
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			

			return "resume11";
		}
		@RequestMapping("/user/resume12/{r_id}")
		public String openShowResume12(@PathVariable("r_id") Integer r_id, Model m) {
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			

			return "resume12";
		}
		@RequestMapping("/user/resume13/{r_id}")
		public String openShowResume13(@PathVariable("r_id") Integer r_id, Model m) {
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			

			return "resume13";
		}
		@RequestMapping("/user/resume14/{r_id}")
		public String openShowResume14(@PathVariable("r_id") Integer r_id, Model m) {
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			

			return "resume14";
		}
		@RequestMapping("/user/resume15/{r_id}")
		public String openShowResume15(@PathVariable("r_id") Integer r_id, Model m) {
			
			m.addAttribute("title", "Show Resume");
			m.addAttribute("res", new Resume());
			
			Optional<Resume> stpOptional = this.resumeRepo.findById(r_id);
			Resume stpinfo = stpOptional.get();
			
			m.addAttribute("res",stpinfo);
			

			return "resume15";
		}
		
		@RequestMapping("/user/filterper")
		public String FilterStudentDetails(Model m,@Param("keyword") String keyword) {
//			List<Resume> stinfo = resumeService.getAllResume();
//
//			if (keyword != null) {
//				m.addAttribute("stinfo", resumeService.findByKeyword(keyword));
//			} else {
//				m.addAttribute("stinfo", stinfo);
//			}
			List<Resume> filter = resumeService.findByKeyword(keyword);
		m.addAttribute("filter", filter);
		m.addAttribute("keyword", keyword);
			return "resumeview";
		}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user, HttpSession session, Model m) {

		// System.out.println(user);

		User u = userService.saveUser(user);

		if (u != null) {
			// System.out.println("save sucess");
			session.setAttribute("msg", "Register successfully");

		} else {
			// System.out.println("error in server");
			session.setAttribute("msg", "Something wrong server");
		}
		return "redirect:/register";
	}

}