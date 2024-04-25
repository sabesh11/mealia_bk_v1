//package com.example.mealia.repo;
//
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.example.mealia.helpers.RefreshableCRUDRepository;
//import com.example.mealia.model.RefreshToken;
//
//@Repository
//public interface RefreshTokenRepo extends RefreshableCRUDRepository<RefreshToken, Integer> {
//	
//	RefreshToken save(RefreshToken refreshToken);
//
//	@Query(value="SELECT * FROM REFRESH_TOKENS  WHERE token = :token",nativeQuery= true)
//	 Optional<RefreshToken> findByToken(String token);
//}
