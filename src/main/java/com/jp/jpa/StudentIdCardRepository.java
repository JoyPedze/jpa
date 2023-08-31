package com.jp.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 31 August 2023
 * @Project : jpa
 */
@Repository
public interface StudentIdCardRepository extends JpaRepository<StudentIdCard, Long> {
}
