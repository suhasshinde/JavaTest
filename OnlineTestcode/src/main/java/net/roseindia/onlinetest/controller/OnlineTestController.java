package net.roseindia.onlinetest.controller;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import net.roseindia.onlinetest.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import net.roseindia.onlinetest.domain.Question;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unchecked")
@Controller
public class OnlineTestController {
	private Service service;
	public static int points;

	@Autowired
	public void setService(Service service){
		this.service = service;
	}

	@RequestMapping(value = "/load-home-page")
	public String loadHomePage(Map model){
		return "index";
	}


	@RequestMapping(value = "/load-exam-page")
	public String loadExamPage(Map model, HttpServletRequest request){
		request.removeAttribute("error");
		model.put("questionForm", service.loadQuestion());
		return "exam-page";
	}

	@RequestMapping(value = "/process-answer")
	public String processAnswer(Map model, HttpServletRequest request){
		int id=0;
		String userOption = "";

		if(request.getParameter("id") != null){
			id = Integer.parseInt(request.getParameter("id"));
		}
		if(request.getParameter("option") != null){
			userOption = request.getParameter("option");
		}else{
			/* Loading the Same Option */		
			model.put("questionForm", service.loadQuestion(id));
			request.setAttribute("error", "Please Choose Any Option");
			return "exam-page";
		}
		String answer = service.getAnswer(id);
		if(userOption.equals(answer)){
			points = points + 1;
			request.removeAttribute("error");
			model.put("questionForm", service.loadNextQuestion(id));
		}
		else{			
			System.out.println("InCorrect");			
			request.removeAttribute("error");
			model.put("questionForm", service.loadNextQuestion(id));
			//request.setAttribute("error", "Incorrect Answer");			
		}
		return "exam-page";
	}

	@RequestMapping(value = "/skip-question")
	public String skipQuestion(Map model, HttpServletRequest request){
		if(request.getParameter("id") !=null){
			request.removeAttribute("error");
			int id = Integer.parseInt(request.getParameter("id"));
			List<Question> questions = service.loadNextQuestion(id);
			if(questions.size() > 0){
				model.put("questionForm", questions);
				return "exam-page";
			}
		}
		return "index";
	}

	@RequestMapping(value = "/show-result")
	public String skipQuestion(Map model){
		model.put("result", points);
		return "result-page";
	}
}