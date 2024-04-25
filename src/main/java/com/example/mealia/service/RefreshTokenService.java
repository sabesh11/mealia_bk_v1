//package com.example.mealia.service;
//
//import com.example.mealia.model.RefreshToken;
//import com.example.mealia.model.User;
//import com.example.mealia.repo.RefreshTokenRepo;
//import com.example.mealia.repo.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.util.Optional;
//import java.util.UUID;
//
//
//@Service
//public class RefreshTokenService {
//
//    @Autowired
//    RefreshTokenRepo refreshTokenRepository;
//
//    @Autowired
//    UserRepo userRepo;
//    
//    @Autowired(required=true)
//    User user;
//
//    public RefreshToken createRefreshToken(String username){
//        RefreshToken refreshToken = RefreshToken.builder()
//                .user(userRepo.findByUsername(username))
//                .token(UUID.randomUUID().toString())
//                .expiryDate(Instant.now().plusMillis(600000))
//                .build();
//        return refreshTokenRepository.save(refreshToken);
//    }
//
//
//
//    public Optional<RefreshToken> findByToken(String token){
//        return refreshTokenRepository.findByToken(token);
//    }
//
//    public RefreshToken verifyExpiration(RefreshToken token){
//        if(token.getExpiryDate().compareTo(Instant.now())<0){
//            refreshTokenRepository.delete(token);
//            throw new RuntimeException(token.getToken() + " Refresh token is expired. Please make a new login..!");
//        }
//        return token;
//
//    }
//
//}