package com.care.aged.AgedCareArt.jpa;

import com.care.aged.AgedCareArt.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

  List<Message> findByReceiverId(Long id);

  List<Message> findBySenderId(Long id);

  List<Message> findByReceiverAccountUsername(String username);
}
