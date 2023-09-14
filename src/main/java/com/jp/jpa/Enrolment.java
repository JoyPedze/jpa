package com.jp.jpa;

import jakarta.persistence.*;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 13 September 2023
 * @Project : jpa
 */

@Entity(name = "Enrolment")
@Table(name = "enrolment")
public class Enrolment {
    @EmbeddedId
    private EnrolmentId enrolmentId;
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    public Enrolment() {
    }

    public Enrolment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public EnrolmentId getEnrolmentId() {
        return enrolmentId;
    }

    public void setEnrolmentId(EnrolmentId enrolmentId) {
        this.enrolmentId = enrolmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
