import java.util.List;
import java.util.Optional;

public class JdbcMemberRepository implements src.main.java.hello.hellospring.repository.MemberRepository {

    private final DataSource dataSource;

    public JdbcMemberRepository(DataSource dataSource){
        this.dataSource=dataSource;

    }
    @Override
    public Member save(Member member) {
        String sql="insert into member(name) values(?)";

        Connection conn=dataSource.getConnection();

        PreparedStatement pstmt=conn
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Lsit<Member> findAll() {
        return null;
    }
}
