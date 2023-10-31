package src.main.java.hello.hellospring.controller;
@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
    @DeleteMapping(value="/{variable}")
    public String DeleteVariable(@PathVariable String variable){
        return variable;
    }

    @DeleteMapping(value="/request1")
    public String getRequestParam1(@RequestParam String email){
        return "e-mail:"+email;
    }
}
