package net.roseindia.onlinetest.dao;

import net.roseindia.onlinetest.domain.Question;
import java.util.List;

public interface QuestionDao{
	public List<Question> loadQuestion();
	public List<Question> loadNextQuestion(int questionId);
	public List<Question> loadQuestion(int questionId);
}