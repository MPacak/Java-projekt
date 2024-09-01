/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.mpac.view.model;

import hr.algebra.model.PhotoJournal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author majap
 */
public class PhotoJournalTableModel extends AbstractTableModel {
  private static final String[] COLUMNS = {
        "Id",
        "Title",
        "Category", 
        "Description text",
        "Credits",
        "picture path",
        "Mission",
        "Instrument", 
        "Spacecraft",
        "Target",
        "Published date"
    };
  private List<PhotoJournal> photoJournals;
 

    public PhotoJournalTableModel(List<PhotoJournal> photoJournals) {
        this.photoJournals = photoJournals;
    }

    public void setPhotoJournals(List<PhotoJournal> photoJournals) {
        this.photoJournals = photoJournals;
         fireTableDataChanged();
    }


    @Override
    public int getRowCount() {
       return photoJournals.size();
    }

    @Override
    public int getColumnCount() {
       return COLUMNS.length;
    }
 @Override
 public String getColumnName(int column) {
     return COLUMNS[column];
 }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
     case 0:
         return photoJournals.get(rowIndex).getId();
     case 1:
         return photoJournals.get(rowIndex).getTitle();
     case 2:
         return photoJournals.get(rowIndex).getCategory();
     case 3:
         return photoJournals.get(rowIndex).getDescriptionText();
     case 4:
         return photoJournals.get(rowIndex).getCredits();
         case 5:
         return photoJournals.get(rowIndex).getPictureLink();
     case 6:
         return photoJournals.get(rowIndex).getMissionName();
     case 7:
         return photoJournals.get(rowIndex).getInstrumentName();
     case 8:
         return photoJournals.get(rowIndex).getSpacecraftName();
     case 9:
         return photoJournals.get(rowIndex).getTarget();
     case 10:
         return photoJournals.get(rowIndex).getPublishedDate();
     default:
         throw new AssertionError();
        }
    }
   public void Distinctive(List<PhotoJournal> photoJournals) {
      
       setPhotoJournals( photoJournals
               .stream()
               .distinct()
               .toList());
   }
    
}
