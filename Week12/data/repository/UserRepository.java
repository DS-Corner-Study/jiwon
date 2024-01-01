package src.main.java.com.springboot.security.data.repository;

public class UserRepository extends JpaRepository<User, Long> {

    User getByUid(String uid);
}
