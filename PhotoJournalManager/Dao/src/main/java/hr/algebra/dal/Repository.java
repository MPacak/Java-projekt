/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal;


import hr.algebra.model.Instrument;
import hr.algebra.model.Mission;
import hr.algebra.model.PhotoJournal;
import hr.algebra.model.Spacecraft;
import hr.algebra.model.User;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author majap
 */
public interface Repository {

    int createJournal (PhotoJournal photoJournal) throws Exception;
    
    void createJournals(List<PhotoJournal> photoJournal) throws Exception;
    
    void updateJournal(int id, PhotoJournal data) throws Exception;
    
    void deleteJournal(int id) throws Exception;
    
    Optional<PhotoJournal> selectJournal(int id) throws Exception;
    
    List<PhotoJournal> selectJournals() throws Exception;
    
    int createMission(Mission mission) throws Exception;
    int createInstrument(Instrument instrument) throws Exception;
    int createSpacecraft(Spacecraft spacecraft) throws Exception;
    
    void createMissions(Set<Mission> missions) throws Exception;
   void createInstruments(Set<Instrument> instruments) throws Exception;
   void createSpacecrafts(Set<Spacecraft> spacecrafts) throws Exception;
    
    void updateMission(int id,Mission mission) throws Exception;
    void updateInstruments(int id,Instrument instrument) throws Exception;
    void updateSpacecraft(int id,Spacecraft spacecraft) throws Exception;
    
    Set<Instrument> selectInstruments() throws Exception; 
    Set<Spacecraft> selectSpacecrafts() throws Exception;
    Set<Mission> selectMissions() throws Exception;
    boolean deleteAll() throws Exception;
    int createUser(User user) throws Exception;
    boolean checkUser(User user) throws Exception;
    Optional<Boolean> checkRole(User user) throws Exception;
}
