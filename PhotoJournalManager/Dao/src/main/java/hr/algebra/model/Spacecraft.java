/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author majap
 */
public final class Spacecraft implements Comparable<Spacecraft> {
    private int id;
    private String spacecraftName;

    public Spacecraft() {
    }

    public Spacecraft(String spacecraftName) {
        this.spacecraftName = spacecraftName;
    }

    public Spacecraft(int id, String spacecraftName) {
        this(spacecraftName);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getSpacecraftName() {
        return spacecraftName;
    }

    public void setSpacecraftName(String spacecraftName) {
        this.spacecraftName = spacecraftName;
    }

    @Override
    public int compareTo(Spacecraft s) {
        return spacecraftName.compareTo(s.spacecraftName);
    }

    @Override
    public String toString() {
        return spacecraftName;
    }
    
    
}
