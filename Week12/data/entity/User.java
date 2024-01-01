package src.main.java.com.springboot.security.data.entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private long id;

    @Column(nullable=false, unique=true)
    private String uid;

    @JsonProperty(access=Access.WRITE_ONLY)
    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private String name;

    @ElementCollection(fetch=FetchType.EAGER)
    @Builder.Default
    private List<String> roles=new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @JsonProperty(access=Access.WRITE_ONLY)
    @Override
    public String getUsername(){
        return this.uid;
    }

    @JsonProperty(access=Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @JsonProperty(access=Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @JsonProperty(access=Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @JsonProperty(access=Access.WRITE_ONLY)
    @Override
    public boolean isEnabled(){
        return true;
    }
}
