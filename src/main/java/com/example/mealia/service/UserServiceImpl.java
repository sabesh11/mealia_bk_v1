//package com.example.mealia.service;
//
//import com.example.mealia.dto.UserRequest;
//import com.example.mealia.dto.UserResponse;
//import com.example.mealia.model.User;
//import com.example.mealia.repo.UserRepo;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.lang.reflect.Type;
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    UserRepo userRepo;
//
//    ModelMapper modelMapper = new ModelMapper();
//
//
//
//    @Override
//    public UserResponse saveUser(UserRequest userRequest) {
//        if(userRequest.getUsername() == null){
//            throw new RuntimeException("Parameter username is not found in request..!!");
//        } else if(userRequest.getPassword() == null){
//            throw new RuntimeException("Parameter password is not found in request..!!");
//        }
//
//
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        UserDetails userDetail = (UserDetails) authentication.getPrincipal();
////        String usernameFromAccessToken = userDetail.getUsername();
////
////        UserInfo currentUser = userRepository.findByUsername(usernameFromAccessToken);
//
//        User savedUser = null;
//
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String rawPassword = userRequest.getPassword();
//        String encodedPassword = encoder.encode(rawPassword);
//
//        User user = modelMapper.map(userRequest, User.class);
//        user.setPassword(encodedPassword);
//        if(userRequest.getId() != null){
//            User oldUser = userRepo.findFirstById(userRequest.getId());
//            if(oldUser != null){
//                oldUser.setId(user.getId());
//                oldUser.setPassword(user.getPassword());
//                oldUser.setName(user.getName());
//                oldUser.setRoles(user.getRoles());
//
//                savedUser = userRepo.save(oldUser);
//                userRepo.refresh(savedUser);
//            } else {
//                throw new RuntimeException("Can't find record with identifier: " + userRequest.getId());
//            }
//        } else {
////            user.setCreatedBy(currentUser);
//            savedUser = userRepo.save(user);
//        }
//        userRepo.refresh(savedUser);
//        UserResponse userResponse = modelMapper.map(savedUser, UserResponse.class);
//        return userResponse;
//    }
//
//    @Override
//    public UserResponse getUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetail = (UserDetails) authentication.getPrincipal();
//        String usernameFromAccessToken = userDetail.getUsername();
//        User user = userRepo.findByUsername(usernameFromAccessToken);
//        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
//        return userResponse;
//    }
//
//    @Override
//    public List<UserResponse> getAllUser() {
//        List<User> users = (List<User>) userRepo.findAll();
//        Type setOfDTOsType = new TypeToken<List<UserResponse>>(){}.getType();
//        List<UserResponse> userResponses = modelMapper.map(users, setOfDTOsType);
//        return userResponses;
//    }
//
//
//}