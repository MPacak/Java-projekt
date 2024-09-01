/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author majap
 */
@XmlRootElement(name = "rss")
public class PhotoJournalList {
   
   private List<PhotoJournal> photoJournals;
    @XmlElementWrapper(name="channel")
    @XmlElement(name = "item")
    public List<PhotoJournal> getPhotoJournals() {
    return photoJournals;
    }
    
    public void setPhotoJournals(List<PhotoJournal> photoJournals) {
    System.out.println("Setting photojournal: " + (photoJournals != null ? photoJournals.size() : "null"));
    this.photoJournals = photoJournals;
    }
}