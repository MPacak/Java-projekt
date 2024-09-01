/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.utilities;

import java.io.File;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author dnlbe
 */
//pretvaranje iz i u xml
public class JAXBUtils {

    private JAXBUtils() {
    }
    
    /*   public static void save(Object object, String filename) throws JAXBException {
    JAXBContext context = JAXBContext.newInstance(object
    .getClass());
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.marshal(object, new File(filename));
    }*/
       public static <T> void save(T t, String filename) throws JAXBException {
          
        JAXBContext context = JAXBContext.newInstance(t
                .getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(t, new File(filename));
    }


         public static <T> T load(Class<T> clazz, InputStream in)
                 throws JAXBException {
              if (in == null) {
            throw new IllegalArgumentException("Input stream cannot be null");
        }
        JAXBContext context = JAXBContext.newInstance(clazz);
        
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(in);
    }
    
}
