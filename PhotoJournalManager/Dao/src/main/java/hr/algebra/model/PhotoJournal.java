/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

import XMLAdapters.PictureAdapter;
import XMLAdapters.DateAdapter;
import XMLAdapters.StringAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author majap
 */
@XmlRootElement (name = "item")
public final class PhotoJournal {
    
   public static final DateTimeFormatter DATABASE_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS");
    
    private int id;
    private String title;
    private CategoryType category; 
    private String descriptionText;
    private String credits;
    private String pictureLink;
    private String missionName;
    private String instrumentName;
    private String spacecraftName;
    private String target;
    private LocalDateTime publishedDate;

  public PhotoJournal(){
        
    }

    public PhotoJournal(String title, CategoryType category, String descriptionText, 
            String credits, String pictureLink, String missionName, 
            String instrumentName, String spacecraftName, 
            String target, LocalDateTime publishedDate) {
        this.title = title;
        this.category = category;
        this.descriptionText = descriptionText;
        this.credits = credits;
        this.pictureLink = pictureLink;
        this.missionName = missionName;
        this.instrumentName = instrumentName;
        this.spacecraftName = spacecraftName;
        this.target = target;
        this.publishedDate = publishedDate;
    }

    
       public PhotoJournal(int id, String title, CategoryType category, 
               String descriptionText,String credits, String pictureLink, 
               String missionName,String instrumentName, String spacecraftName, 
            String target, LocalDateTime publishedDate) {
            this(title, category,descriptionText, credits,pictureLink, 
            missionName, instrumentName, spacecraftName,target, publishedDate);
            this.id = id;        
    }
 @XmlTransient
    public int getId() {
        return id;
    }
    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }

@XmlElement(name = "category")
@XmlJavaTypeAdapter(CategoryTypeAdapter.class)
    public CategoryType getCategory() {
        return category;
    }
@XmlElement(name = "descriptionText")
@XmlJavaTypeAdapter(StringAdapter.class)
    public String getDescriptionText() {
        return descriptionText;
    }
@XmlElement(name = "credits")
@XmlJavaTypeAdapter(StringAdapter.class)
    public String getCredits() {
        return credits;
    }
@XmlElement(name = "hiresJpeg")
@XmlJavaTypeAdapter(PictureAdapter.class)
    public String getPictureLink() {
        return pictureLink;
    }
@XmlElement(name = "mission")
@XmlJavaTypeAdapter(StringAdapter.class)
    public String getMissionName() {
        return missionName;
    }
@XmlElement(name = "instrument")
@XmlJavaTypeAdapter(StringAdapter.class)
    public String getInstrumentName() {
        return instrumentName;
    }
@XmlElement(name = "spacecraft")
@XmlJavaTypeAdapter(StringAdapter.class)
    public String getSpacecraftName() {
        return spacecraftName;
    }
@XmlElement(name = "target")
@XmlJavaTypeAdapter(StringAdapter.class)
    public String getTarget() {
        return target;
    }

@XmlElement(name = "pubDate")
 @XmlJavaTypeAdapter(DateAdapter.class)
    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public void setSpacecraftName(String spacecraftName) {
        this.spacecraftName = spacecraftName;
    }


    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "PhotoJournal{" + "title= " + title + ", category= " + category + 
                ", descriptionText= " + descriptionText + ", credits = " + credits
                + ", pictureLink=" + pictureLink + ", missionName=" + missionName 
                + ", instrumentName=" + instrumentName + ", spacecraftName=" 
                + spacecraftName + ", target=" + target + ", publishedDate=" 
                + publishedDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.title);
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
        final PhotoJournal other = (PhotoJournal) obj;
        return Objects.equals(this.title, other.title);
    }

}
