/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XMLAdapters;

import hr.algebra.utilities.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author majap
 */
public class PictureAdapter extends XmlAdapter<String, String> {
private static final String EXT = ".jpg";
    private static final String DIR = "assets";
    @Override
    public String unmarshal(String vt) throws Exception {
        if (vt == null || vt.isEmpty()) {
            return null;
        }

        try {
            String ext = vt.substring(vt.lastIndexOf("."));

            if (ext.length() > 4) {
                ext = EXT;
            }

            String pictureName = UUID.randomUUID() + ext;
            String localPicturePath = DIR + File.separator + pictureName;
            FileUtils.copyFromUrl(vt, localPicturePath);
            return localPicturePath;
        } catch (IOException ex) {
            Logger.getLogger(PictureAdapter.class.getName()).log(Level.SEVERE, null, ex);
            return null; 
        }
    }

    @Override
    public String marshal(String bt) throws Exception {
        return bt; 
    }
    
}
