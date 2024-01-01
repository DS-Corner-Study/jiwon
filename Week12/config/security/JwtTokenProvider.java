package src.main.java.com.springboot.security.config.security;

@Component
@RequiredArgsConstructor

public class JwtTokenProvider {

    private final Logger LOGGER=LoggerFactory.getLogger(JwtTokenProvider.class);
    prviate final UserDetailsService userDetailsService;

    @Value("${sprngboot.jwt.secret}")
    private String secretKey="secretKey";
    private final long tokenValidMillisecond=1000L*60*60;

    @PostConstruct
    protected void init(){
        LOGGER.info("[init] JwtTokenProvider 내 secretKey 초기화 시작");
        System.out.println(secretKey);
        secretKey=Base64.getEncoder().encodeToString(secretKey.getBytes(StandartdCharets.UTF_8));
        System.out.println(secretKey);
        LOGGER.info("[init] JwtTokenProvider 내 secretKey 초기화 완료");
    }

    public String createToken(String userUid, List<String> roles){
        LOGGER.info("[createToken] 토큰 생성 시작");
        Claims claims=Jwt.claims().setSubject(userUid);
        claims.put("roles",roles);

        Date now=new Date();
        String token=Jwts.builder()
                .setClaims(claims)
                .setIssueAt(now)
                .setExpiration(new Date(now.getTime()+tokenValidMillisecond))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        LOGGER.info("[createToken] 토큰 생성 완료");
        return token;
    }

    public Authentication getAuthentication(String token){
        LOGGER.info("[getAuthentication] 토큰 인증 정보 조회 시작");
        UserDetails userDetails=userDetailsService.loadUserByUsername(this.getUsername(token));
        LOGGER.info("[getAuthentication] 토큰 인증 정보 조회 완료, UserDetails UserName : {}", userDetails.getUsername());
        return new UsernamePasswordAuthenticationToken(userDetails,"", userDetails.getAuthorities());
    }

    public String getUsername(String token){
        LOGGER.info("[getUsername] 토큰 기반 회원 구별 정보 추출");
        String info=Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
        LOGGER.info("[getUsername] 토큰 기반 회원 구별 정보 추출 완료, info:{}",info);
        return info;
    }

    public String resolveToken(HttpServletRequest request){
        Logger.info("[resolveToken] HTTP 헤터에서 Token 값 추출");
        return request.getHeader("X-AUTH-TOKEN");
    }

    public boolean validateToken(String token){
        LOGGER.info("[validateToken] 토큰 유효 체크 시작");
        try{
            Jws<Claims> claims=Jwts.parser().setSignKey(secretKey).parseClaimsJws(token);

            return !claims.getBody().getExpiration().before(new Date());
        } catch(Exception e){
            LOGGER.info("[validateToken] 토큰 유효 체크 예외 발생");
            return false;
        }
    }
}
