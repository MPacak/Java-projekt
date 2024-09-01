/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author majap
 */
public final class Instrument implements Comparable<Instrument> {
    private int id;
    private String instrumentName;

    public Instrument() {
    }

    public Instrument(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public Instrument(int id, String instrumentName) {
        this(instrumentName);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    @Override
    public int compareTo(Instrument i) {
       return instrumentName.compareTo(i.instrumentName);
    }

    @Override
    public String toString() {
        return instrumentName;
    }



    
}
