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
    @OneToOne(cascade = CascadeType.ALL) // default
    @JoinColumn(name = "student_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "student_card_id_student_id_fk"))
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

    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", student=" + student +
                '}';
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
