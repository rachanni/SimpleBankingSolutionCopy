package com.banking.opeartion.security;

//import com.bank.repository.UserInfoRepository;

import com.banking.opeartion.entity.UserInformation;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetails implements UserDetailsService {

   // @Autowired
  //  UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      //  return userInfoRepository.findByUserName(username).get();
        UserInformation u = new UserInformation();
       u.setUserName("ravi@gmail.com");
       u.setPassword(passwordEncoder().encode("ravi"));
       return u;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder();
    }
}
