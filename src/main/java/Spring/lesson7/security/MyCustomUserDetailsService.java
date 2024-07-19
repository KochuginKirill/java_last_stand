package Spring.lesson7.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import Spring.lesson7.model.User;
import Spring.lesson7.repository.UserRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MyCustomUserDetailsService implements UserDetailsService {

  // {SpringSecurity}
  // ... @ UserDetailsService userDetailsService
  // User[admin] --login--> [UserDetails userDetailsService.loadUserByUsername(login)]
  // [UserDetails -> SecurityContext]

  // В нашем случае юзеры хранятся в БД в таблице UserRepository
  // Строго говоря, в этой реализации UserDetailsService можно загружать данные о пользователе из любого источника:
  // внешний auth-service, ldap-сервер, ...
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByLogin(username)
      .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

    List<SimpleGrantedAuthority> userRoles = userRepository.findById(user.getId()).stream()
      .map(it -> new SimpleGrantedAuthority(it.getRoles().toString()))
      .toList();
    return new org.springframework.security.core.userdetails.User(
      user.getLogin(),
      user.getPassword(),
      userRoles
    );
  }

}
