use PHOTOJOURNAL
Go
create table EndUser (
IDEndUser int identity primary key, 
UserName nvarchar(max) not null,
Pass nvarchar(max) not null,
UserRole bit  null
)
GO

--USER PROCEDURE
create or alter procedure createUser
@UserName nvarchar(max),
@Pass nvarchar(max),
@UserRole bit,
@IDEndUser int output
as
begin
insert into EndUser values (@Username, @Pass, @UserRole)
set @IDEndUser = SCOPE_IDENTITY()
end 
GO
create or alter procedure checkUser 
@UserName nvarchar(max),
@Pass nvarchar(max),
@UserExists bit output 
as
begin
if exists (select * from EndUser where UserName = @UserName and Pass = @Pass)
begin
set @UserExists = 1
end
else
begin 
set @UserExists = 0
end
end
GO
create or alter procedure checkRole 
@UserName nvarchar(max),
@Pass nvarchar(max),
@UserRole bit output 
as
begin
select @UserRole = UserRole from EndUser where UserName = @UserName and Pass = @Pass
end



create table Mission (
IDMission int identity primary key,
MissionName nvarchar(max) 
)
GO
create table Spacecraft (
IDSpacecraft int identity primary key,
SpacecraftName nvarchar(max) 
)
GO
create table Instrument (
IDInstrument int identity primary key,
InstrumentName nvarchar(max) 
)
GO
create table Category (
IDCategory int identity primary key,
CategoryName nvarchar(100)
)
create table PhotoJournal (
IDPhotoJournal int identity primary key,
Title nvarchar(max) not null,
CategoryID int foreign key references Category(IDCategory),
DescriptionText nvarchar(max),
Credits nvarchar(100),
PictureLink nvarchar(200) not null,
MissionID int foreign key references Mission(IDMission),
InstrumentID int foreign key references Instrument(IDInstrument),
SpacecraftID int foreign key references Spacecraft(IDSpacecraft),
Target nvarchar(100),
PublishedDate datetime2 not null
)
--Journal Crude

create or alter procedure createJournal 
@Title nvarchar(200),
@CategoryID int,
@DescriptionText nvarchar(max),
@Credits nvarchar (100), 
@PictureLink nvarchar(200),
@MissionName nvarchar(max),
@InstrumentName nvarchar(max),
@SpacecraftName nvarchar(max),
@Target nvarchar(100),
@PublishedDate datetime2,
@IDPhotoJournal int output
as
begin
declare @IDM  int
declare @IDI int
declare @IDS int
exec selectMission @MissionName, @IDM output
exec selectInstrument @InstrumentName, @IDI OUTPUT;
exec selectSpacecraft @SpacecraftName, @IDS OUTPUT;
insert into PhotoJournal values (@Title, @CategoryID, @DescriptionText, @Credits,@PictureLink, @IDM, @IDI,@IDS, @Target, @PublishedDate)
set @IDPhotoJournal = SCOPE_IDENTITY()
END
GO
create or alter procedure updateJournal 
@IDPhotoJournal int, 
@Title nvarchar(200),
@CategoryID int,
@DescriptionText nvarchar(max),
@Credits nvarchar (100), 
@PictureLink nvarchar(200),
@MissionName nvarchar(max),
@InstrumentName nvarchar(max),
@SpacecraftName nvarchar(max),
@Target nvarchar(100),
@PublishedDate datetime2
as
begin
declare @IDM  int
declare @IDI int
declare @IDS int
exec selectMission @MissionName, @IDM output
exec selectInstrument @InstrumentName, @IDI OUTPUT;
exec selectSpacecraft @SpacecraftName, @IDS OUTPUT;
update PhotoJournal set
Title = @Title,
CategoryID = @CategoryID,
DescriptionText = @DescriptionText,
Credits = @Credits,
PictureLink = @PictureLink,
MissionID =  @IDM,
InstrumentID = @IDI,
SpacecraftID = @IDS,
Target = @Target,
PublishedDate = @PublishedDate
where 
IDPhotoJournal = @IDPhotoJournal
end
GO
create or alter procedure deleteJournal
@IDPhotoJournal int
as
begin
delete from PhotoJournal where IDPhotoJournal = @IDPhotoJournal
end

create or alter procedure selectJournal
@IDPhotoJournal int
as
begin
select p.IDPhotoJournal,p.Title,p.CategoryID,p.DescriptionText,p.Credits,p.PictureLink, m.MissionName, i.InstrumentName, s.SpacecraftName, p.Target,p.PublishedDate from PhotoJournal as p
left outer join Mission as m on m.IDMission = p.MissionID
left outer join Instrument as i on i.IDInstrument = p.InstrumentID
left outer join Spacecraft as s on s.IDSpacecraft = p.SpacecraftID
where IDPhotoJournal = @IDPhotoJournal
end

create or alter procedure selectJournals
as
begin
select p.IDPhotoJournal,p.Title,p.CategoryID,p.DescriptionText,p.Credits,p.PictureLink, m.MissionName, i.InstrumentName, s.SpacecraftName, p.Target,p.PublishedDate from PhotoJournal as p
left outer join Mission as m on m.IDMission = p.MissionID
left outer join Instrument as i on i.IDInstrument = p.InstrumentID
left outer join Spacecraft as s on s.IDSpacecraft = p.SpacecraftID
end 

--Mission Crud


create or alter procedure createMission
@MissionName nvarchar(256),
@IDMission  int output
as
begin
 if exists (select 1 from Mission where MissionName = @MissionName)   
   begin
   SELECT @IDMission = IDMission FROM Mission WHERE MissionName = @MissionName;
   end
   else
   begin 
   
   INSERT INTO Mission (MissionName) VALUES (@MissionName);
  SET @IDMission = SCOPE_IDENTITY();
   end
end

create or alter procedure updateMission
@IDMission  int,
@MissionName nvarchar(max)
as
begin
update Mission set
MissionName = @MissionName
where IDMission = @IDMission 
end

create or alter procedure deleteMission
@IDMission  int
as
begin
delete from Mission 
where IDMission = @IDMission 
end

create or alter procedure selectMission
@Name nvarchar(max),
@IDMission int output
as
begin
select @IDMission = IDMission from Mission 
where MissionName  = @Name 
end
create or alter procedure selectMissions
as
begin
select * from Mission 
end

--INSTRUMENT CRUD
create or alter procedure createInstrument
@InstrumentName nvarchar(max),
@IDInstrument int output
as
begin
 if exists (select 1 from Instrument where InstrumentName = @InstrumentName)   
   begin
  select @IDInstrument = IDInstrument from Instrument where InstrumentName = @InstrumentName;
   end
   else
   begin 
  insert into Instrument values (@InstrumentName)
	set @IDInstrument = SCOPE_IDENTITY()
   end
end

create or alter procedure updateInstrument
@IDInstrument int,
@InstrumentName nvarchar(max)
as
begin
update Instrument set
InstrumentName = @InstrumentName
where IDInstrument = @IDInstrument
end
GO
create or alter procedure deleteInstrument
@IDInstrument int
as
begin
delete from Instrument 
where IDInstrument = @IDInstrument
end
GO
create or alter procedure selectInstrument
@Name nvarchar(max),
@IDInstrument int output
as
begin
select @IDInstrument = IDInstrument from Instrument 
where InstrumentName = @Name
end
create or alter procedure selectInstruments
as
begin
select * from Instrument 
end

--SPACECRAFT CRUD
create or alter procedure createSpacecraft
@SpacecraftName nvarchar(max),
@IDSpacecraft int output
as
begin
if exists (select 1 from Spacecraft where SpacecraftName = @SpacecraftName)   
   begin
  select @IDSpacecraft = IDSpacecraft from Spacecraft where SpacecraftName = @SpacecraftName;
   end
   else
   begin 
  insert into Spacecraft values (@SpacecraftName )
	set @IDSpacecraft = SCOPE_IDENTITY()
   end
end
GO
create or alter procedure updateSpacecraft
@IDSpacecraft int,
@SpacecraftName nvarchar(max)
as
begin
update Spacecraft set
SpacecraftName = @SpacecraftName
where IDSpacecraft = @IDSpacecraft
end
GO
create or alter procedure deleteSpacecraft
@IDSpacecraft int
as
begin
delete from Spacecraft 
where IDSpacecraft = @IDSpacecraft
end
GO
create or alter procedure selectSpacecraft
@Name nvarchar(max),
@IDSpacecraft int output
as
begin
select @IDSpacecraft = IDSpacecraft from Spacecraft 
where SpacecraftName = @Name 
end
GO
create or alter procedure selectSpacecrafts
as
begin
select * from Spacecraft 
end


--DELETEALL
create or alter procedure deleteAll
@Success bit output
as
begin
begin try
delete from PhotoJournal
delete from Mission
delete from Spacecraft
delete from Instrument
set @Success = 1;
end try
begin catch
set @Success = 0
end catch
end

