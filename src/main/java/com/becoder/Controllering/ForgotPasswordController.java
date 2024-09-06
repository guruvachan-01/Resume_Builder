package com.becoder.Controllering;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.becoder.repository.UserRepo;
import com.becoder.service.ForgotPasswordService;
import com.becoder.entity.User;
import jakarta.servlet.http.HttpSession;


@Controller
public class ForgotPasswordController{
	
	Random random = new Random();

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

 
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ForgotPasswordService forgotPasswordService;
	
	Random ran=new Random(1000);
	
	
	@RequestMapping("/forgot")
	public String openEmailForm() {
		return "Forgot_Password";
	}
	
	@PostMapping("/send-otp")   //value ya path
	public String sendOTP(@RequestParam("email") String email,HttpSession session) {
		System.out.println("Email"+email);
		//generated otp 4 digist
		
		
		
		int otp = ran.nextInt(9000) + 1000;
		System.out.println("OTP"+otp);
		
		String subject = " OTP sent by Build CV ";
		String message = "" + "<div style='border:1px solid #e2e2e2; padding:20px'>" + "<h2>" + "Your OTP is " + "<b>"
				+ otp + "</n>" + "</h2>" + "</div>";
		String to = email;
		
		boolean flag = this.forgotPasswordService.sendEmail(subject, message, to);

		if (flag) {
			session.setAttribute("myotp", otp);
			session.setAttribute("email", email);

			return "verify_otp";
		} else {

			session.setAttribute("message", "Check your email id !");

			return "Forgot_Password";
		}

		
		
	}
	
	@PostMapping("/verify-otp")
	public String verifyOTP(@RequestParam("otp") int otp, HttpSession session) {

		int myotp = (int) session.getAttribute("myotp");
		String email = (String) session.getAttribute("email");

		if (myotp == otp) {

			User user = this.userRepo.findByEmail(email);

			if (user == null) {

				session.setAttribute("msg", "User does't exist with this email address !");
				return "Forgot_Password";
			} else {

				return "change_password";
			}

		} else {

			session.setAttribute("msg", "You have entered wrong OTP !");

			return "verify_otp";
		}

	}
	
	@PostMapping("/change-password")
	public String changePassword(@RequestParam("newPassword") String newPassword, HttpSession session) {
		String email = (String) session.getAttribute("email");
		User user = this.userRepo.findByEmail(email);
		user.setPassword(this.bCryptPasswordEncoder.encode(newPassword));
		this.userRepo.save(user);

		session.setAttribute("msg", "Your password have been changed successfully ! You can login now !");

		//return "change_password";

		
		  return
		  "redirect:/signin?change=password changed successfully ! You can login now !";
		 

	}


}








