package com.polytech.tindog.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {
    boolean existsBySenderIdAndReceiverId(String senderId, String receiverId);
    Optional<List<Message>> findBySenderIdAndReceiverId(String senderId, String receiverId);
    Optional<Message> findFirstBySenderIdAndReceiverIdOrderByCreateDateAsc(String senderId, String receiverId);

}
