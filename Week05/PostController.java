package src.main.java.hello.hellospring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class PostController {

    @PostMapping(value="/member")
    public String postMember(@RequestBody Map<String,Object> postData){
        StringBuilder sb=new StringBuilder();

        postData.entrySet().forEach(map->{
            sb.append(map.getKey()+":"+map.getValue()+"\n");
        });

        return sb.toString();
    }

    @RestController
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }
}
