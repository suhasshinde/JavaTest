package net.roseindia.onlinetest.dao.daoImpl;

import net.roseindia.onlinetest.dao.QuestionDao;
import net.roseindia.onlinetest.domain.Question;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.Query;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionDaoImpl implements QuestionDao {

		private SessionFactory sessionFactory;
		private static final int NO_OF_RESULT = 1;
		
		@Autowired
		public void setSessionFactory(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}

		public List<Question> loadQuestion(){
			Session session = sessionFactory.openSession();
			String hql = "select obj from Question obj order by id";
			Query query = session.createQuery(hql);	
			query.setMaxResults(1);
			
			List<Question> questionList = query.list(); 
			session.flush();
			session.clear();
			session.close();
			return questionList;
		}

		public List<Question> loadNextQuestion(int questionId){
			Session session = sessionFactory.openSession();
			String hql = "select obj from Question obj where obj.id > "+questionId+" order by obj.id ASC";
			Query query = session.createQuery(hql);
			List<Question> questionList = query.list();
			session.flush();
			session.clear();
			session.close();
			return questionList;
		}

		public List<Question> loadQuestion(int questionId){
			Session session = sessionFactory.openSession();
			String hql = "select obj from Question obj where obj.id ="+questionId;
			Query query = session.createQuery(hql);
			List<Question> questionList = query.list();
			session.flush();
			session.clear();
			session.close();
			return questionList;
		}
}