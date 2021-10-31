/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cpp.HelloSpring.dao;

import com.cpp.HelloSpring.domain.Usr;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cpenaloz
 */
public interface UserDao extends JpaRepository<Usr, Long>{
    Usr findByUsername(String username);
}
