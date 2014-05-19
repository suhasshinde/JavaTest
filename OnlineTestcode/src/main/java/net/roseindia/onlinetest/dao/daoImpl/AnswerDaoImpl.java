package net.roseindia.onlinetest.dao.daoImpl;

import net.roseindia.onlinetest.dao.AnswerDao;
import net.roseindia.onlinetest.domain.Question;
import net.roseindia.onlinetest.domain.Answer;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class AnswerDaoImpl implements AnswerDao {

		private SessionFactory sessionFactory;
		
		@Autowired
		public void setSessionFactory(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}

		public String getAnswer(int questionId){
			Session session = sessionFactory.openSession();
			String hql = "select obj from Answer obj where obj.questionId ="+questionId;
			Query query = session.createQuery(hql);
			List<Answer> questionList = query.list();
			Answer answer = questionList.get(0);
			session.flush();
			session.clear();
			session.close();
			return answer.getAnswer();
		}
}