/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author majap
 */
public class MissionTransferable implements Transferable {
     private static final DataFlavor MISSION_FLAVOR = new DataFlavor (Mission.class, "Mission");
      private static final DataFlavor[] SUPPORTED_FLAVORS = {MISSION_FLAVOR};
      private final Mission mission;

    public MissionTransferable(Mission mission) {
        this.mission = mission;
    }
      
    @Override
    public DataFlavor[] getTransferDataFlavors() {
       return SUPPORTED_FLAVORS;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return MISSION_FLAVOR.equals(flavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (isDataFlavorSupported(flavor)) {
           
            return mission;
        }
        throw new UnsupportedFlavorException(flavor);      
    }
    
}
