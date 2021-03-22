package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);         // 값이 없으면 null이 반환되는것을 Optinal로 감싸서 반환하는 기능
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
