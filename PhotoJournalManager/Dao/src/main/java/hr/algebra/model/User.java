/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

import java.util.Objects;

/**
 *
 * @author majap
 */
public final class User implements Comparable<User> {

  
    private int id; 
    private String UserName;
    private String Pass;
    private boolean Role;

  public User( String UserName, String Pass) {
        this.UserName = UserName;
        this.Pass = Pass;
    }
      public User(String UserName, String Pass, boolean Role) {
  this(UserName, Pass);
        this.Role = Role;
    }
    public String getUserName() {
        return UserName;
    }

    public String getPass() {
        return Pass;
    }

    public boolean isRole() {
        return Role;
    }

    public void setRole(boolean Role) {
        this.Role = Role;
    }
      @Override
    public int compareTo(User u) {
        return UserName.compareTo(u.UserName);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.UserName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.UserName, other.UserName);
    }
    
    
    
}
