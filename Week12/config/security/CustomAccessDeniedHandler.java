package src.main.java.com.springboot.security.config.security;

import java.nio.file.AccessDeniedException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    private final Logger LOGGER=LoggerFactory.getLogger(CustomAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException exception) throws IOException{
        LOGGER.info("[handle] 접근이 막혔을 경우 경로 리다이렉트");
        response.sendRedirect("/sign-api/exception");
    }
}
