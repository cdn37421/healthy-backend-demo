package tw.ryo.springdemo.service;

import java.util.List;

import tw.ryo.springdemo.entity.Member;

public interface MemberService {

	public List<Member> getMembers();

	public void saveMember(Member theMember);

	public Member getMembers(int theId);

	public void deleteMember(int theId);

}
