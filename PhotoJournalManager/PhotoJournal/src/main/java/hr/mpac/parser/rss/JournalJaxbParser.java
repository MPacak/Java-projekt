/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.mpac.parser.rss;

import hr.algebra.factory.UrlConnectionFactory;
import hr.algebra.model.PhotoJournal;
import hr.algebra.model.PhotoJournalList;
import hr.algebra.utilities.JAXBUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;


/**
 *
 * @author majap
 */
public class JournalJaxbParser {
     private static final String RSS_URL = "https://photojournal.jpl.nasa.gov/rss/gallery/universe";
   
    public static List<PhotoJournal> parse() throws IOException, XMLStreamException, JAXBException {
        
        HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(RSS_URL);
       
       try (InputStream is = con.getInputStream()) {
         if (is == null) {
            throw new IllegalArgumentException("Input stream cannot be null");
        }

         PhotoJournalList photoJournalList = JAXBUtils
        .load(PhotoJournalList.class, is);
        System.out.println("Parsed photo journals: " +
        photoJournalList.getPhotoJournals().size());
            return photoJournalList.getPhotoJournals();
        
       }
    }
   
}
