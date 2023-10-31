package src.main.java.hello.hellospring.controller;

@RestController
@RequestMapping("/hello-spring/v1/put-api")
public class PutController {
    @PutMapping(value="/member")
    public String postMember(@RequestBody Map<String,Object> putData){
        StringBuilder sb=new StringBuilder();

        putData.entrySet().forEach(map->{
            sb.append(map.getKey()+":"+map.getValue()+"\n");
        });
        return sb.toString();
    }
}
