package hello.hellospring.repository;


import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemeberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    } //save () 끝

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    } // findById() 끝

    @Override
    public Optional<Member> findByName(String name) {
       return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    } // findByName () 끝

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    } // findAll() 끝
} // Class 끝
