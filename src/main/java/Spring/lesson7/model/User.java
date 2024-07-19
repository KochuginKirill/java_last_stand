package Spring.lesson7.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "login")
  private String login;

  @Column(name = "password")
  private String password;

  @Column(name = "roleId")
  private Long roleId;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name="usersRole",
          joinColumns=  @JoinColumn(name="roles_id", referencedColumnName="id"),
          inverseJoinColumns= @JoinColumn(name="user_roleId", referencedColumnName="id") )
  private Set<Role> roles = new HashSet<>();

//  @ManyToMany
//  Set<Role> roles;
}
