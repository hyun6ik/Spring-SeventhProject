package springweb.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springweb.mvc.domain.Member;
import springweb.mvc.repository.MemberRepository;
import springweb.mvc.repository.MemoryMemberRepository;

@Component
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    //테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }


}
