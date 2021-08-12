package tw.ryo.springdemo.dao;

import java.util.List;

import tw.ryo.springdemo.entity.Member;



public interface MemberDAO {

	public List<Member> getMembers();

	public void saveMember(Member theMember);

	public Member getMembers(int theId);

	public void deleteMember(int theId);
	
}
