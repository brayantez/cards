package com.brimatech.cards.repositories;

import com.brimatech.cards.models.Card;
import com.brimatech.cards.models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CardRepository extends JpaRepository<Card,Long> {

    @Query(nativeQuery=true, value="SELECT * FROM cards c WHERE c.user_id = :userId")
    List<Card> cardsByUser(Long userId, Pageable pageable);

    @Query(nativeQuery=true, value="SELECT * FROM cards c WHERE c.user_id=:userId AND c.status LIKE %:status% AND c.name LIKE %:name% AND c.color LIKE %:color%")
    List<Card> searchCard(Long userId, String status, String name, String color, Pageable pageable);

    @Query(nativeQuery=true, value="SELECT * FROM cards c WHERE c.user_id=:userId AND c.status LIKE %:status% AND c.name LIKE %:name% AND c.color LIKE %:color% AND DATE(c.created_at) = DATE(:createdAt)")
    List<Card> searchCard(Long userId, String status, String name, String color, Date createdAt, Pageable pageable);


}
