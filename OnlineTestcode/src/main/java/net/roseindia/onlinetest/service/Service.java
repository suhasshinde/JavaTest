package net.roseindia.onlinetest.service;

import net.roseindia.onlinetest.domain.Question;

import java.util.List;

public interface Service {
	public List<Question> loadQuestion();
	public String getAnswer(int questionId);
	public List<Question> loadNextQuestion(int questionId);
	public List<Question> loadQuestion(int questionId);
}