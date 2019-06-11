package cb.codegym.securityrememberme.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @Column(name = "user_name", length = 36, nullable = false)
    private String user_name;

    @Column(name = "encryted_password", length = 128, nullable = false)
    private String encryted_password;

    @Column(name = "enable", length = 1, nullable = false)
    private boolean enable;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEncryted_password() {
        return encryted_password;
    }

    public void setEncryted_password(String encryted_password) {
        this.encryted_password = encryted_password;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
