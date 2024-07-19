package Spring.lesson7.model;

import io.swagger.v3.oas.annotations.StringToClassMapItem;
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

  @Column
  private String role;

//  public String role(){
//    Iterator<Role> iterator = roles.iterator();
//    Role element = iterator.next();
//    System.out.println(element.getName());
//    return element.getName();
//  }

//  @ManyToMany(cascade = CascadeType.ALL)
//  @JoinTable(name="usersRole",
//          joinColumns=  @JoinColumn(name="roles_id", referencedColumnName="id"),
//          inverseJoinColumns= @JoinColumn(name="user_roleId", referencedColumnName="id") )
//  private Set<Role> roles = new HashSet<>();

  @ManyToMany(fetch = FetchType.EAGER)
  Set<Role> roles = new HashSet<>();
}
