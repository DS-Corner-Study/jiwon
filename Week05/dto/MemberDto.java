package src.main.java.hello.hellospring.dto;

public class MemberDto {

    private String name;
    private String email;
    private String organization;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(){
        this.email=email;
    }

    public String getOrganization(){
        return organization;
    }

    public void setOrganization(String organization){
        this.organization=organization;
    }

    @Override
    public String toString(){
        return "MemberDto{"+
                "name='"+name+'\''+
                ", organization='"+organization+'\''+
                '}';

    }
}
