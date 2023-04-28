package com.rest_api.fs14backend.todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "todo")
@Table(name = "todo")
public class Todo {

  @Id
  @GeneratedValue
  @UuidGenerator
  private UUID id;

  @Column(nullable = false, columnDefinition = "varchar(50)")
  private String title;

  @Column(nullable = false)
  private boolean isCompleted;

  public Todo() {}

  public Todo(String title, boolean isCompleted) {
    this.title = title;
    this.isCompleted = isCompleted;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean getIsCompleted() {
    return isCompleted;
  }

  public void setIsCompleted(boolean isCompleted) {
    this.isCompleted = isCompleted;
  }
}
