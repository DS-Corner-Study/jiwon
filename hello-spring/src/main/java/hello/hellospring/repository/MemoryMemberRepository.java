package src.main.java.hello.hellospring.repository;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member>store = new HashMap<>();
    private static long sequence=OL;

    @Overridepublic Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    @Override
    public Optional<Member> findById(Long id){
        return Optional.ofNullable(store.get(id))

    }
    @Override
    public Optional<Member> findByName(String name){
        return store.valuew().stream()
                .filter(member->member.getName().equals(name))
                .findAny();
    }

}
