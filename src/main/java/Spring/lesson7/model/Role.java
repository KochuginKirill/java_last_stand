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
  private Long id = 1l;
  private String name = "empty";

  public Role(String name, Long id) {
    this.id = id;
    this.name = name;
  }

  public Role() {
    this.id = 1l;
    this.name = "empty";
  }

  public String getName() {
    return name;
  }

//  @ManyToMany(cascade = CascadeType.ALL)
//  @JoinTable(name="usersRole",
//          joinColumns=  @JoinColumn(name="user_roleId", referencedColumnName="id"),
//          inverseJoinColumns= @JoinColumn(name="roles_id", referencedColumnName="id") )
//  private Set<User> users = new HashSet<>();

//  @ManyToMany
//  Set<User> users;

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
