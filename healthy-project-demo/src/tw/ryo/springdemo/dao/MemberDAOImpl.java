package tw.ryo.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.ryo.springdemo.entity.Member;

@Repository
public class MemberDAOImpl implements MemberDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Member> getMembers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Member> theQuery = currentSession.createQuery("from Member order by lastName", Member.class);

		// execute query and get result list
		List<Member> Members = theQuery.getResultList();

		// return the results
		return Members;
	}

	@Override
	public void saveMember(Member theMember) {

		// get current hibernate session

		Session currentSession = sessionFactory.getCurrentSession();
		// save the Member
		currentSession.saveOrUpdate(theMember);
	}

	@Override
	public Member getMembers(int theId) {

		// get the current hibernate session

		Session currentSession = sessionFactory.getCurrentSession();
		// now retrieve/read from database using the primary key
		Member theMember = currentSession.get(Member.class, theId);

		return theMember;
	}

	@Override
	public void deleteMember(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Member where id=:memberId");
		theQuery.setParameter("memberId", theId);
	
		theQuery.executeUpdate();
	}

}
