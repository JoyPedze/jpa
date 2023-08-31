package com.jp.jpa;

import jakarta.persistence.*;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 31 August 2023
 * @Project : jpa
 */

@Entity(name = "StudentIdCard")
@Table(name = "student_id_card")
public class StudentIdCard {
    @Id
    @SequenceGenerator(name = "student_id_card_sequence",sequenceName = "student_id_card_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_card_sequence")
    @Column(name = "id",updatable = false)
    private Long id;
    @Column(name = "card_number", unique = true, nullable = false, length = 15)
    private String cardNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    public StudentIdCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public StudentIdCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
