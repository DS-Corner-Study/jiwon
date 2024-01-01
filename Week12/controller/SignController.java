package src.main.java.com.springboot.security.controller;

import java.net.http.HttpHeaders;

@RestController
@RequestMapping("/sign-api")
public class SignController {
    private final Logger LOGGER=LoggerFactory.getLogger(SignController.class);
    private final SignService signService;

    @Autowired
    public SignController(SignService signService){
        this.signService=signService;
    }

    @PostMapping(value="/sign-in")
    public SignInResultDto signIn(
            @ApiParam(value="ID", required=true) @RequestParam String id,
            @ApiParam(value="Password", required=true) @RequestParam String password)
        throws RuntimeException{
        LOGGER.info("[signIn] 로그인을 시도하고 있습니다. id:{},pw:****",id);
        SignInResultDto signInResultDto=signService.signIn(id, password);

        if(signInresultDto.getCode()==0){
            LOGGER.info("[signIn] 정상적으로 로그인되었습니다. id:{}, token:{}", id, signInResultDto.getToken());
        }
        return signInResultDto;
    }

    @PostMapping(value="/sign-up")
    public SignUpResultDto signUp(
            @ApiParam(value="ID", required=true) @RequestParam String id,
            @ApiParam(value="비밀번호", required=true) @RequestParam String passsword,
            @ApiParam(value="이름", required=true) @RequestParam String role){
        LOGGER.info("[signUp]회원가입을 수행합니다. id:{}, password:****, name:{}, role:{}",id,name, role);
        SignUpResultDto signUpResultDto=signService.signUp(id, password, name, role);
        LOGGER.info("[signUp] 회원가입을 완료했습니다. id:{}", id);
        return signUpResultDto;
    }

    @GetMapping(value="/exception")
    public void exceptionTest() throws RuntimeExcetion{
        throw new RuntimeException("접근이 금지되었습니다.");
    }

    @ExceptionHandler(value=RuntimeException.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(RuntimeException e){
        HttpHeaders responseHeaders=new HttpHeaders();
        HttpStatus httpStatus=HttpStatus.BAD_REQUEST;

        LOGGER.error("ExceptionHandler 호출, {}, {}", e.getCause(), e.getMessage());

        Map<String, String> map=new HashMap<>();

        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code","400");
        map.put("message","에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }
}
