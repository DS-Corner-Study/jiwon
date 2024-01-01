package src.main.java.com.springboot.security.config.security;

import java.io.IOException;

public class CustomAuthenticationEntryPoint implements AuthenticatoinEntryPoint {

    private final Logger LOGGER=LoggerFactory.getLogger(CustomAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException ex) throws IOException{
        ObjectMapper objectMapper=new ObjectMapper();
        LOGGER.info("[commerce] 인증 실패로 response.sendError 발생");

        EntryPointErrorResponse entryPointErrorResponse=new EntryPointErrorResponse();
        entryPointErrorResponse.setMsg("인증이 실패하였습니다.");

        response.setStatus(401);
        response.setContnetType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(entryPointErrorResponse));
    }
}
