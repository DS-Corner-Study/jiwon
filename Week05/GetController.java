package src.main.java.hello.hellospring.controller;


/*
import org.sprigframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/hello-spring/v1/get-api")
public class GetController {
    @RequestMapping(value="/hello",method=RequestMethod.GET)
    public String getHello(){
        return "Hello World";
    }
}

 */

public class GetController {
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto) {
        //return memberDto.getName()+""+memberDto.getEmail()+""+memberDto.getOrganization();
        return memberDto.toString();
    }
}