package springweb.mvc.repository;

import springweb.mvc.domain.Member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
