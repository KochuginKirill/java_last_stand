package Spring.lesson7.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String name;

  public Role(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

//  @ManyToMany(cascade = CascadeType.ALL)
//  @JoinTable(name="usersRole",
//          joinColumns=  @JoinColumn(name="user_roleId", referencedColumnName="id"),
//          inverseJoinColumns= @JoinColumn(name="roles_id", referencedColumnName="id") )
//  private Set<User> users = new HashSet<>();

  @ManyToMany(fetch = FetchType.EAGER)
  Set<User> users = new HashSet<>();

  @Override
  public String toString() {
    return this.getName();
  }
}

//public enum Role {
//
//  ADMIN("admin"), USER("user");
//
//  private final String name;
//
//  Role(String name) {
//    this.name = name;
//  }
//
//  public String getName() {
//    return name;
//  }
//}
