/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XMLAdapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author majap
 */
public class StringAdapter extends XmlAdapter<String, String>{

    @Override
    public String unmarshal(String vt) throws Exception {
          if (vt == null || vt.trim().isEmpty()) {
            return null;
        }
        return vt.trim();
    }

    @Override
    public String marshal(String bt) throws Exception {
         return bt;
    }
    
}
