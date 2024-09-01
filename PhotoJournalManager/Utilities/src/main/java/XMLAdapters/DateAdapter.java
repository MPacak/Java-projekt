/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XMLAdapters;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author majap
 */
public class DateAdapter extends XmlAdapter<String, LocalDateTime> {
 private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.RFC_1123_DATE_TIME;

    @Override
    public LocalDateTime unmarshal(String vt) throws Exception {
   
       
            String trimmedDate = vt.trim();
            //druga opcija umjesto trim replaceAll("\\s", "")

            ZonedDateTime zonedDateTime = ZonedDateTime.parse(trimmedDate, DATE_FORMATTER);

            return zonedDateTime.toLocalDateTime();
    }

    @Override
    public String marshal(LocalDateTime bt) throws Exception {
        return bt.format(DATE_FORMATTER);
    }
  
    
}
