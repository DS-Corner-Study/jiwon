import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateMemberRepository(DataSource dataSource){
        jdbcTemplate=new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member){
        return null;
    }

    @Override
    public Optional<Member> findById(Long id){
        return jdbcTemplate.query("select*from member where id=?",);
    }

    @Override
    public Optional<Memeber> findByName(String name){
        return Optional.empty();
    }

    @Override
    public List<Member> findAll(){
        return null;
    }

    private RowMapper<Member> memberRowMapper(){
        return new package src.main.java.hello.hellospring.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MemberController{
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMappint("/members")
    public String create(MemberForm form){
        Member member=new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

}
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute(attributeName:"data", attributeValue:"hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model)
        model.addAttribute(attributeName:"name",name);
    return"hello-template"

    @GetMapping("hello-string")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
<Member>(){
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
                Member member=new Member();
                member.setId(rs.getLong(columnLabel:"id"));
                member.setName(rs.getString(columnLabel:"name"));
                return member;
            }
        }
    }
}
