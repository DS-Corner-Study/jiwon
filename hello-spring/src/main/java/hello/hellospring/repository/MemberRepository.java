package src.main.java.hello.hellospring.repository;

import src.main.java.hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    Lsit<Member> findAll();
}
