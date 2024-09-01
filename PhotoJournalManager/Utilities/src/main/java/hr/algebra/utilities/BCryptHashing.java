
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.utilities;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 *
 * @author majap
 */
public class BCryptHashing {
     public static String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
