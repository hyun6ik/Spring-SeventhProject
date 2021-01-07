package springweb.mvc;

import springweb.mvc.domain.Grade;
import springweb.mvc.domain.Member;
import springweb.mvc.service.MemberService;
import springweb.mvc.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
