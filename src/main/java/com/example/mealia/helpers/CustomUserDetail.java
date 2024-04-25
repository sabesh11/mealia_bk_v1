//package com.example.mealia.helpers;
//
//import com.example.mealia.model.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import com.example.mealia.model.UserRole;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class CustomUserDetail extends User implements UserDetails {
//
//    private String username;
//    private String password;
//    Collection<? extends GrantedAuthority> authorities;
//
//    public CustomUserDetail(User byUsername) {
//        this.username = byUsername.getName();
//        this.password= byUsername.getPassword();
//        List<GrantedAuthority> auths = new ArrayList<>();
//
//        for(UserRole role : byUsername.getRoles()){
//
//            auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
//        }
//        this.authorities = auths;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}