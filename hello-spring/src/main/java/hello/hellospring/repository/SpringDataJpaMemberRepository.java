package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//스프링데이터jpa가 JpaRepository를 받고있으면 자동으로 구현체를 만들어서 bean등록을 해줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPQL : select m from Member m where m.name=?
    //규칙에 맞춰서 작성하면 자동으로 처리해줌줌
   @Override
    Optional<Member> findById(Long aLong);
}
