package springweb.mvc.service;

import springweb.mvc.domain.Member;

public interface MemberService {
    void Join(Member member);
    Member findMember(Long memberId);
}
