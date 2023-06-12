package com.robert.sessionformdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;



@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String setCount(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {	
			session.setAttribute("count", (int) session.getAttribute("count") + 1);
		}
		return "counterPage.jsp";
	}
	
	@GetMapping("/get/count")
	public String getCount() {
		return "getCount.jsp";
	}
	
	//https://www.google.com/search?keyword=huskies
	@GetMapping("/search")
	public String searchform() {
		return "getForm/form.jsp";
	}
	
	@GetMapping("/search/display")
	public String displayGetForm(@RequestParam("keyword") String searchValue, Model model) {
		model.addAttribute("keyword", searchValue);
		return "getForm/displayForm.jsp";
	}
	
	
	
	@GetMapping("/review/form")
	public String reviewForm() {
		return "postForm/form.jsp";
	}
	
	
	
	@PostMapping("/process/review/form")
	public String processReviewForm(@RequestParam("movie") String movie, @RequestParam("comment") String comment, @RequestParam("rating") Integer rating, HttpSession session,RedirectAttributes redirectAttributes, @RequestParam("reviewer") String reviewer) {
		if(rating < 0 || rating > 5) {
			redirectAttributes.addFlashAttribute("errorRating", "Rating needs to be between 0 and 5");
			return "redirect:/review/form";
		}
		session.setAttribute("movie", movie);
		session.setAttribute("comment", comment);
		session.setAttribute("rating", rating);
		session.setAttribute("reviewer", reviewer);
		session.setAttribute("test", "<script>alert('h1')</script>");
		return "redirect:/display/post/form";
	}
	
	
	@GetMapping("/display/post/form")
	public String displayPostForm() {
		return "postForm/displayForm.jsp";
	}
	
	
	
	
	
	
	
	
	
	

}
