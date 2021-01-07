package springweb.mvc.service;

import springweb.mvc.domain.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
