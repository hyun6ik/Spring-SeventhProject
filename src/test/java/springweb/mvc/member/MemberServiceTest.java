package springweb.mvc.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import springweb.mvc.domain.Grade;
import springweb.mvc.domain.Member;
import springweb.mvc.service.MemberService;
import springweb.mvc.service.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    public void join() {
        //given
        Member member = new Member(1L,"memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
       assertThat(member).isEqualTo(findMember);

    }
}
