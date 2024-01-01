package src.main.java.com.springboot.security.config.security;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final Logger LOGGER=LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    private final JwtTokenProvider jwtTokenProvider;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider=jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest servletRequest,
                                    HttpServletResponse servletResponse,
                                    FilterChain filterChain) throws ServletException, IOException{
        String token=jwtTokenProvider.resolveToken(servletRequest);
        LOGGER.info("[doFilterInternal] token 값 추출 완료. token:{}",token);

        LOGGER.info("[doFilterInternal] token 값 유효성 체크 시작");
        if(token !=null&&jwtTokenProvider.validateToken(token)){
            Authentication authentication=jwtTokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            LOGGER.info("[doFilterInternal] token 값 유효성 체크 완료");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}

