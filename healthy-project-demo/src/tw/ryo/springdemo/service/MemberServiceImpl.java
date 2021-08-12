package tw.ryo.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.ryo.springdemo.dao.MemberDAO;
import tw.ryo.springdemo.entity.Member;

@Service
public class MemberServiceImpl implements MemberService {

	//need to inject Member dao
	@Autowired
	private MemberDAO MemberDAO;
	
	//delegate call dao
	@Override
	@Transactional
	public List<Member> getMembers() {
		return MemberDAO.getMembers();
	}

	@Override
	@Transactional
	public void saveMember(Member theMember) {

		 MemberDAO.saveMember(theMember);
	}

	@Override
	@Transactional
	public Member getMembers(int theId) {
		return MemberDAO.getMembers(theId);
	}

	@Override
	@Transactional
	public void deleteMember(int theId) {
		MemberDAO.deleteMember(theId);
	}

}
