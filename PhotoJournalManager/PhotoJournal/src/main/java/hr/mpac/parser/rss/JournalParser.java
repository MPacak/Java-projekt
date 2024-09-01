/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.mpac.parser.rss;

import hr.algebra.factory.ParserFactory;
import hr.algebra.factory.UrlConnectionFactory;
import hr.algebra.model.CategoryType;
import hr.algebra.model.PhotoJournal;
import hr.algebra.model.TagType;
import hr.algebra.utilities.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author majap
 */
public class JournalParser {
    private static final String RSS_URL = "https://photojournal.jpl.nasa.gov/rss/gallery/universe";
    
    private static final String ATTRIBUTE_URL = "url";
   
    private static final String EXT = ".jpg";

    private static final String DIR = "assets";

    public static List<PhotoJournal> parse() throws IOException, XMLStreamException {
        List<PhotoJournal> photoJournals = new ArrayList<>();
        
        HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(RSS_URL);
        
 
        try (InputStream is = con.getInputStream()) { 
          
            XMLEventReader reader = ParserFactory.createStaxParser(is);
           
            Optional<TagType> tagType = Optional.empty();
            PhotoJournal photoJournal = null;
            StartElement startElement = null;
            while (reader.hasNext()) {
              
                XMLEvent event = reader.nextEvent();
                
                switch (event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        
                        startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        tagType = TagType.from(qName);
                          System.out.println(tagType);

                        if (tagType.isPresent() && tagType.get().equals(TagType.ITEM)) {
                            photoJournal = new PhotoJournal();
                            photoJournals.add(photoJournal);
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:

                        if (tagType.isPresent() && photoJournal != null) {
                          
                            Characters characters = event.asCharacters();

                            String data = characters.getData().trim();
                            switch (tagType.get() ) {
                                case TITLE -> {
                                    if (!data.isEmpty()) {
                                        photoJournal.setTitle(data);
                                    }
                                    break;
                                }
                                case CATEGORY -> {
                                    if (!data.isEmpty()) {
                                        photoJournal.setCategory(CategoryType.getCategory(data));
                                    }
                                    break;
                                }
                                case DESCRIPTION -> {
                                     if (!data.isEmpty()) {
                                          photoJournal.setDescriptionText(data);
                                     }

                                    break;
                                }
                                case CREDITS -> {
                                    if (!data.isEmpty()) {
                                         photoJournal.setCredits(data);
                                    }

                                    break;
                                }

                                case PICTURELINK -> {
                          if (!data.isEmpty()) {

                                    if (startElement != null ) {
                                         handlePicture(photoJournal, data);
                                         /* Attribute urlAttribute = startElement
                                         .getAttributeByName(new QName(ATTRIBUTE_URL));
                                         System.out.println(urlAttribute.getValue());
                                         if (urlAttribute != null) {
                                         System.out.println(urlAttribute.getValue());
                                         handlePicture(photoJournal, urlAttribute.getValue());
                                         }*/
                                    }
                          }
                                    break;
                                }
                                 case MISSION -> {
                                   if (!data.isEmpty()) {
                                       photoJournal.setMissionName(data);
                                   }

                                    break;
                                }
                                case INSTRUMENT -> {
                                     if (!data.isEmpty()) {
                                           photoJournal.setInstrumentName(data);
                                     }
                                      
                                    
                                    break;
                                }
                                  case SPACECRAFT -> {
                                    if (!data.isEmpty()) {
                                          photoJournal.setSpacecraftName(data);
                                    }

                                    break;
                                }
                                   case TARGET -> {
                                    if (!data.isEmpty()) {
                                          photoJournal.setTarget(data);
                                    }

                                    break;
                                }
                                 case PUB_DATE -> {
                                    if (!data.isEmpty()) {
                                        ZonedDateTime zonedDateTime = ZonedDateTime
                                                .parse(data, DateTimeFormatter.RFC_1123_DATE_TIME);
                                        LocalDateTime publishedDate = zonedDateTime.toLocalDateTime();
                                                
                                        photoJournal.setPublishedDate(publishedDate);
                                    }
                                    break;
                                }
                            }
                        }
                        break;

                }
            }

        }
        return photoJournals;

    }
     private static void handlePicture(PhotoJournal photoJournal, String pictureUrl) {

        try {

            String ext = pictureUrl.substring(pictureUrl.lastIndexOf("."));

            if (ext.length() > 4) {

                ext = EXT;
            }

            String pictureName = UUID.randomUUID() + ext;
            String localPicturePath = DIR + File.separator + pictureName;
            FileUtils.copyFromUrl(pictureUrl, localPicturePath);
            photoJournal.setPictureLink(localPicturePath);
        } catch (IOException ex) {
            Logger.getLogger(JournalParser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
