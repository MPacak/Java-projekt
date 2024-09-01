/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author majap
 */
public final class Mission implements Comparable<Mission>  {

    private int id;
    private String missionName;

    public Mission() {
    }

    public Mission(String missionName) {
        this.missionName = missionName;
    }

    public Mission(int id, String missionName) {
        this(missionName);
        this.id = id;
    
    }

    public int getId() {
        return id;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

     @Override
    public int compareTo(Mission m) {
    return missionName.toLowerCase().compareTo
    (m.missionName.toLowerCase());
    }

    @Override
    public String toString() {
        return missionName;
    }
    
    
    
}
