package com.care.aged.AgedCareArt.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "sender_id")
  private User sender;

  @OneToOne
  @JoinColumn(name = "parent_message_id")
  private Message parentMessage;

  @ManyToOne
  @JoinColumn(name = "receiver_id")
  private User receiver;

  @Temporal(TemporalType.DATE)
  private Date sendDate;

  private boolean responded;

  private String subject;

  private String body;

  public long getId() {

    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User getSender() {
    return sender;
  }

  public void setSender(User sender) {
    this.sender = sender;
  }

  public User getReceiver() {
    return receiver;
  }

  public void setReceiver(User receiver) {
    this.receiver = receiver;
  }

  public Date getSendDate() {
    return sendDate;
  }

  public void setSendDate(Date sendDate) {
    this.sendDate = sendDate;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String title) {
    this.subject = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public boolean isResponded() {
    return responded;
  }

  public void setResponded(boolean responded) {
    this.responded = responded;
  }

  public Message getParentMessage() {
    return parentMessage;
  }

  public void setParentMessage(Message parentMessage) {
    this.parentMessage = parentMessage;
  }
}
