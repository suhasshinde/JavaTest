package main.java.net.roseindia.onlinetest.service.serviceImpl;

import net.roseindia.onlinetest.service.Service;
import net.roseindia.onlinetest.domain.Question;
import net.roseindia.onlinetest.dao.QuestionDao;
import net.roseindia.onlinetest.dao.AnswerDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ServiceImpl implements Service {

	private QuestionDao questionDao;
	private AnswerDao answerDao;

	@Autowired
	public void setQuestionDao(QuestionDao questionDao){
		this.questionDao = questionDao;
	}

	@Autowired
	public void setAnswerDao(AnswerDao answerDao){
		this.answerDao = answerDao;
	}

	public List<Question> loadQuestion(){
		return questionDao.loadQuestion();
	}
	
	public String getAnswer(int questionId){
		return answerDao.getAnswer(questionId);
	}
	
	public List<Question> loadNextQuestion(int questionId){
		return questionDao.loadNextQuestion(questionId);
	}

	public List<Question> loadQuestion(int questionId){
		return questionDao.loadQuestion(questionId);
	}
}