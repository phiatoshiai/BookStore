package cb.codegym.securityrememberme.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "app_role")
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name = "role_name", length = 30, nullable = false)
    private String roleName;

    @ManyToMany(mappedBy = "roleSet")
    private Set<AppUser> userSet;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<AppUser> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<AppUser> userSet) {
        this.userSet = userSet;
    }
}
