/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.CategoryType;
import hr.algebra.model.Instrument;
import hr.algebra.model.Mission;
import hr.algebra.model.PhotoJournal;
import hr.algebra.model.Spacecraft;
import hr.algebra.model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import javax.sql.DataSource;

public class SqlRepository implements Repository {

    private static final String ID_PHOTOJURNAL = "IDPhotoJournal";
    private static final String TITLE = "Title";
     private static final String CATEGORY = "CategoryID";
    private static final String DESCRIPTION = "DescriptionText";
    private static final String CREDITS = "Credits";
    private static final String PICTURE_LINK = "PictureLink";
    private static final String ID_MISSION = "IDMission";
    private static final String ID_INSTRUMENT = "IDInstrument";
    private static final String ID_SPACECRAFT = "IDSpacecraft";
    private static final String TARGET = "Target";
    private static final String PUBLISHED_DATE = "PublishedDate";
    
    private static final String MISSION_NAME = "MissionName";
    private static final String INSTRUMENT_NAME= "InstrumentName";
    private static final String SPACECRAFT_NAME = "SpacecraftName";
    
    private static final String ID_ENDUSER = "IDEndUser";
    private static final String USERNAME = "UserName";
    private static final String PASSWORD = "Pass";
    private static final String ROLE = "UserRole";
     private static final String USER_EXISTS = "UserExists";
    
     private static final String DELETION_SUCCESS = "Success";

    private static final String CREATE_JOURNAL = "{ CALL createJournal (?,?,?,?,?,?,?,?,?,?,?) }";
    private static final String UPDATE_JOURNAL = "{ CALL updateJournal (?,?,?,?,?,?,?,?,?,?,?) }";
    private static final String DELETE_JOURNAL  = "{ CALL deleteJournal (?) }";
    private static final String SELECT_JOURNAL  = "{ CALL selectJournal (?) }";
    private static final String SELECT_JOURNALS = "{ CALL selectJournals }";
    private static final String DELETE_ALL = "{ CALL deleteAll (?) }";
    
    private static final String CREATE_MISSION = "{ CALL createMission (?,?) }";
    private static final String CREATE_INSTRUMENT = "{ CALL createInstrument (?,?) }";
    private static final String CREATE_SPACECRAFT = "{ CALL createSpacecraft (?,?) }";
    
     private static final String UPDATE_MISSION = "{ CALL updateMission (?,?) }";
    private static final String UPDATE_INSTRUMENT = "{ CALL updateInstrument (?,?) }";
    private static final String UPDATE_SPACECRAFT = "{ CALL updateSpacecraft (?,?) }";
    
    private static final String SELECT_INSTRUMENTS = "{ CALL selectInstruments }";
     private static final String SELECT_SPACECRAFTS = "{ CALL selectSpacecrafts }";
       private static final String SELECT_MISSIONS = "{ CALL selectMissions }";
    
     private static final String CREATE_USER = "{ CALL createUser (?,?,?,?) }";
    private static final String CHECK_ROLE = "{ CALL checkRole (?,?) }";
     private static final String CHECK_USER = "{ CALL checkUser (?,?,?) }";

      @Override
    public int createJournal(PhotoJournal photoJournal) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    //try with resources blok zatvara
    try (Connection con = dataSource.getConnection();
    CallableStatement stmt = con.prepareCall(CREATE_JOURNAL)) {
    
    stmt.setString(TITLE, photoJournal.getTitle());
   
    stmt.setInt(CATEGORY, photoJournal.getCategory().getId());
    stmt.setString(DESCRIPTION, photoJournal.getDescriptionText());
    stmt.setString(CREDITS, photoJournal.getCredits());
    stmt.setString(PICTURE_LINK, photoJournal.getPictureLink());
    stmt.setString(MISSION_NAME, photoJournal.getMissionName());
   stmt.setString(INSTRUMENT_NAME, photoJournal.getInstrumentName());
   stmt.setString(SPACECRAFT_NAME, photoJournal.getSpacecraftName());
    stmt.setString(TARGET, photoJournal.getTarget());
    stmt.setString(PUBLISHED_DATE, photoJournal.getPublishedDate()
    .format(PhotoJournal.DATABASE_DATE_FORMATTER));
    stmt.registerOutParameter(ID_PHOTOJURNAL, Types.INTEGER);
    
    stmt.executeUpdate();
    return stmt.getInt(ID_PHOTOJURNAL);
    }
    }
    
    @Override
    public void createJournals(List<PhotoJournal> photoJournals) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    CallableStatement stmt = con.prepareCall(CREATE_JOURNAL)) {
    
    for (PhotoJournal photoJournal : photoJournals) {
    stmt.setString(TITLE, photoJournal.getTitle());

    stmt.setInt(CATEGORY, photoJournal.getCategory().getId());
    stmt.setString(DESCRIPTION, photoJournal.getDescriptionText());
    stmt.setString(CREDITS, photoJournal.getCredits());
    stmt.setString(PICTURE_LINK, photoJournal.getPictureLink());
  stmt.setString(MISSION_NAME, photoJournal.getMissionName());
        

   stmt.setString(INSTRUMENT_NAME, photoJournal.getInstrumentName());
   stmt.setString(SPACECRAFT_NAME, photoJournal.getSpacecraftName());
       stmt.setString(TARGET, photoJournal.getTarget());
    stmt.setString(PUBLISHED_DATE, photoJournal.getPublishedDate()
    .format(PhotoJournal.DATABASE_DATE_FORMATTER));
    stmt.registerOutParameter(ID_PHOTOJURNAL, Types.INTEGER);
    
    stmt.executeUpdate();
    }
    }
    }
    
    @Override
    public void updateJournal(int id, PhotoJournal photoJournal) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    CallableStatement stmt = con.prepareCall(UPDATE_JOURNAL )) {
    stmt.setInt(ID_PHOTOJURNAL, id);
    stmt.setString(TITLE, photoJournal.getTitle());
    
    stmt.setInt(CATEGORY, photoJournal.getCategory().getId());
    stmt.setString(DESCRIPTION, photoJournal.getDescriptionText());
    stmt.setString(CREDITS, photoJournal.getCredits());
    stmt.setString(PICTURE_LINK, photoJournal.getPictureLink());
     stmt.setString(MISSION_NAME, photoJournal.getMissionName());
   stmt.setString(INSTRUMENT_NAME, photoJournal.getInstrumentName());
   stmt.setString(SPACECRAFT_NAME, photoJournal.getSpacecraftName());
   stmt.setString(TARGET, photoJournal.getTarget());
    stmt.setString(PUBLISHED_DATE, photoJournal.getPublishedDate()
    .format(PhotoJournal.DATABASE_DATE_FORMATTER));

    stmt.executeUpdate();
    }
    }
    
    @Override
    public void deleteJournal(int id) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    CallableStatement stmt = con.prepareCall(DELETE_JOURNAL )) {
    
    stmt.setInt(ID_PHOTOJURNAL, id);
    
    stmt.executeUpdate();
    }
    }
    
    @Override
    public Optional<PhotoJournal> selectJournal(int id) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    PreparedStatement stmt = con.prepareCall(SELECT_JOURNAL)) {
    
    stmt.setInt(1, id);
    try (ResultSet rs = stmt.executeQuery()) { 
   
    if (rs.next()) {
    return Optional.of(new PhotoJournal(
    rs.getInt(ID_PHOTOJURNAL),
    rs.getString(TITLE),
            CategoryType.from(rs.getInt(CATEGORY)),
    rs.getString(DESCRIPTION),
    rs.getString(CREDITS),
    rs.getString(PICTURE_LINK),
    rs.getString(MISSION_NAME),
     rs.getString(INSTRUMENT_NAME),
     rs.getString(SPACECRAFT_NAME),
     rs.getString(TARGET),
    LocalDateTime.parse(rs.getString
        (PUBLISHED_DATE), PhotoJournal.DATABASE_DATE_FORMATTER)));
    }
    }
    }
    return Optional.empty();
    }
    
    @Override
    public List<PhotoJournal> selectJournals() throws Exception {
    List<PhotoJournal> photoJournals = new ArrayList<>();
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    PreparedStatement stmt = con.prepareCall(SELECT_JOURNALS);
    ResultSet rs = stmt.executeQuery()) {
    while (rs.next()) {
    photoJournals.add(new PhotoJournal(
    rs.getInt(ID_PHOTOJURNAL),
    rs.getString(TITLE),
   CategoryType.from(rs.getInt(CATEGORY)),
    rs.getString(DESCRIPTION),
    rs.getString(CREDITS),
    rs.getString(PICTURE_LINK),
    rs.getString( MISSION_NAME),
    rs.getString(INSTRUMENT_NAME),
    rs.getString(SPACECRAFT_NAME),
    rs.getString(TARGET),
   
    LocalDateTime.parse(rs.getString
        (PUBLISHED_DATE), PhotoJournal.DATABASE_DATE_FORMATTER)));
    }
    }
    return photoJournals;
    }

    @Override
    public int createUser(User user) throws Exception {
         DataSource dataSource = DataSourceSingleton.getInstance(); 

    try  (Connection con = dataSource.getConnection();
           
    CallableStatement stmt = con.prepareCall(CREATE_USER)) {
    
    stmt.setString(USERNAME, user.getUserName());
    stmt.setString(PASSWORD, user.getPass());
    stmt.setBoolean(ROLE, user.isRole());
   
    stmt.registerOutParameter(ID_ENDUSER, Types.INTEGER);
    
    stmt.executeUpdate();
    return stmt.getInt(ID_ENDUSER);
    }
    }

    @Override
    public boolean checkUser(User user) throws Exception {
            DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    CallableStatement stmt = con.prepareCall(CHECK_USER)) {
    
    stmt.setString(USERNAME, user.getUserName());
    stmt.setString(PASSWORD, user.getPass());

    stmt.registerOutParameter(USER_EXISTS, Types.BOOLEAN);
    
    stmt.executeUpdate();
  
    return stmt.getBoolean(USER_EXISTS);
    }
    }

    @Override
    public Optional<Boolean> checkRole(User user) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
           
    CallableStatement stmt = con.prepareCall(CHECK_ROLE)) {
    
    stmt.setString(USERNAME, user.getUserName());
    stmt.setString(PASSWORD, user.getPass());
    
   try (ResultSet rs = stmt.executeQuery()) {
    if (rs.next()) {
 
    boolean userRole = rs.getBoolean(ROLE);
  
    return Optional.of(userRole);
    }
    }
    }
    return Optional.empty();
    };

    @Override
    public boolean deleteAll() throws Exception {
          DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    CallableStatement stmt = con.prepareCall(DELETE_ALL))    {
        stmt.registerOutParameter(DELETION_SUCCESS, Types.BOOLEAN);
        stmt.executeUpdate();
        return stmt.getBoolean(DELETION_SUCCESS);
    }
    }

    @Override
    public Set<Instrument> selectInstruments() throws Exception {
         Set<Instrument> instruments= new HashSet<>();
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    PreparedStatement stmt = con.prepareCall(SELECT_INSTRUMENTS);
    ResultSet rs = stmt.executeQuery()) {
    while (rs.next()) {
    instruments.add(new Instrument(
    rs.getInt(ID_INSTRUMENT),
    rs.getString(INSTRUMENT_NAME)));
    }
    }
    return instruments;
    }

    @Override
    public int createInstrument(Instrument instrument) throws Exception {
       DataSource dataSource = DataSourceSingleton.getInstance();
   
    try (Connection con = dataSource.getConnection();
    CallableStatement stmt = con.prepareCall(CREATE_INSTRUMENT)) {
    
    stmt.setString(INSTRUMENT_NAME, instrument.getInstrumentName());
   
 
    stmt.registerOutParameter(ID_INSTRUMENT, Types.INTEGER);
    
    stmt.executeUpdate();
    return stmt.getInt(ID_INSTRUMENT);
    }

    }
  
    @Override
    public Set<Spacecraft> selectSpacecrafts() throws Exception {
             Set<Spacecraft> spacecrafts= new TreeSet<>();
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    PreparedStatement stmt = con.prepareCall(SELECT_SPACECRAFTS);
    ResultSet rs = stmt.executeQuery()) {
    while (rs.next()) {
    spacecrafts.add(new Spacecraft(
    rs.getInt(ID_SPACECRAFT),
    rs.getString(SPACECRAFT_NAME)));
    }
    }
    return  spacecrafts;
    }

    @Override
    public int createMission(Mission mission) throws Exception {
       DataSource dataSource = DataSourceSingleton.getInstance();
   
    try (Connection con = dataSource.getConnection();
    CallableStatement stmt = con.prepareCall(CREATE_MISSION)) {
    
    stmt.setString(MISSION_NAME, mission.getMissionName());
 
    stmt.registerOutParameter(ID_MISSION, Types.INTEGER);
    
    stmt.executeUpdate();
    return stmt.getInt(ID_MISSION);
    }

    }

    @Override
    public int createSpacecraft(Spacecraft spacecraft) throws Exception {
            DataSource dataSource = DataSourceSingleton.getInstance();
   
    try (Connection con = dataSource.getConnection();
    CallableStatement stmt = con.prepareCall(CREATE_SPACECRAFT)) {
    
    stmt.setString(SPACECRAFT_NAME, spacecraft.getSpacecraftName());
 
    stmt.registerOutParameter(ID_SPACECRAFT, Types.INTEGER);
    
    stmt.executeUpdate();
    return stmt.getInt(ID_SPACECRAFT);
    }
    }

    @Override
    public void updateMission(int id,Mission mission) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    CallableStatement stmt = con.prepareCall(UPDATE_MISSION )) {
    stmt.setInt(ID_MISSION, id);
    stmt.setString(MISSION_NAME, mission.getMissionName());

    stmt.executeUpdate();
    }
    }

    @Override
    public void updateInstruments(int id,Instrument instrument) throws Exception {
          DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    CallableStatement stmt = con.prepareCall(UPDATE_INSTRUMENT )) {
    stmt.setInt(ID_INSTRUMENT, id);
    stmt.setString(INSTRUMENT_NAME, instrument.getInstrumentName());

    stmt.executeUpdate();
    }
    }

    @Override
    public void updateSpacecraft(int id,Spacecraft spacecraft) throws Exception {
          DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    CallableStatement stmt = con.prepareCall(UPDATE_SPACECRAFT )) {
    stmt.setInt(ID_SPACECRAFT, id);
    stmt.setString(SPACECRAFT_NAME, spacecraft.getSpacecraftName());

    stmt.executeUpdate();
    }
    }

    @Override
    public Set<Mission> selectMissions() throws Exception {
            Set<Mission> missions= new HashSet<>();
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    PreparedStatement stmt = con.prepareCall(SELECT_MISSIONS);
    ResultSet rs = stmt.executeQuery()) {
    while (rs.next()) {
    missions.add(new Mission(
    rs.getInt(ID_MISSION),
    rs.getString(MISSION_NAME)));
    }
    }
    return  missions;
    }

    @Override
    public void createMissions(Set<Mission> missions) throws Exception {
             DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    CallableStatement stmt = con.prepareCall(CREATE_MISSION)) {
    
    for (Mission mission : missions) {
    stmt.setString(MISSION_NAME, mission.getMissionName());
 
    stmt.registerOutParameter(ID_MISSION, Types.INTEGER);
    
    stmt.executeUpdate();
    }
    }
    }

    @Override
    public void createInstruments(Set<Instrument> instruments) throws Exception {
         DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    CallableStatement stmt = con.prepareCall(CREATE_INSTRUMENT)) {
    
    for (Instrument instrument : instruments) {
   stmt.setString(INSTRUMENT_NAME, instrument.getInstrumentName());
   
 
    stmt.registerOutParameter(ID_INSTRUMENT, Types.INTEGER);
    
    stmt.executeUpdate();
    }
    }
    }

    @Override
    public void createSpacecrafts(Set<Spacecraft> spacecrafts) throws Exception {
               DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
    CallableStatement stmt = con.prepareCall(CREATE_SPACECRAFT)) {
    
    for (Spacecraft spacecraft : spacecrafts) {
     stmt.setString(SPACECRAFT_NAME, spacecraft.getSpacecraftName());
 
    stmt.registerOutParameter(ID_SPACECRAFT, Types.INTEGER);
    
    stmt.executeUpdate();
    }
    }
    }
}
