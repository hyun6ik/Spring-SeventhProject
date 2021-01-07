package springweb.mvc.service;

import springweb.mvc.domain.Member;
import springweb.mvc.repository.MemberRepository;
import springweb.mvc.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
