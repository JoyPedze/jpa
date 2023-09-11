package com.jp.jpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 01 September 2023
 * @Project : jpa
 */

@Entity(name = "Book")
@Table(name = "book")
public class Book {
    @Id
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;
    @Column(name = "book_name", nullable = false, columnDefinition = "TEXT")
    private String bookName;
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false, referencedColumnName = "id",foreignKey = @ForeignKey(name = "book_id_student_id_fk"))
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book(String bookName, LocalDateTime createdAt) {
        this.bookName = bookName;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", createdAt=" + createdAt +
                ", student=" + student +
                '}';
    }
}
