package src.main.java.com.springboot.security.service.impl;

import com.sun.org.slf4j.internal.LoggerFactory;
import src.main.java.com.springboot.security.data.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final Logger LOGGER= LoggerFactory.getLogger(src.main.java.com.springboot.security.service.impl.UserDetailsServiceImpl.class);
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        LOGGER.info("[loadUserByUsername] loadUserByUsername 수행. username : {}", username);
        return userRepository.getByUid(username);
    }
}
