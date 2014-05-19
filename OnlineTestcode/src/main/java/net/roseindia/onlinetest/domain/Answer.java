package net.roseindia.onlinetest.domain;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import java.io.Serializable;

@Entity
@Table(name = "answer")
public class Answer implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "question_id")
	private int questionId;

	@Column(name = "answer")
	private String answer;
	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}