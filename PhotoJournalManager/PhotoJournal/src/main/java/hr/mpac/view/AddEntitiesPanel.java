/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hr.mpac.view;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Instrument;
import hr.algebra.model.Mission;
import hr.algebra.model.Spacecraft;
import hr.algebra.utilities.MessageUtils;

import java.util.Set;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author majap
 */
public class AddEntitiesPanel extends javax.swing.JPanel {
private Repository repo;
private int selectedId;

private final DefaultListModel<Instrument> instrumentsModel = new DefaultListModel<>();
private final DefaultListModel<Mission> missionsModel = new DefaultListModel<>();
private final DefaultListModel<Spacecraft> spacecraftsModel = new DefaultListModel<>();

private Set<Mission> missionSet;

    /**
     * Creates new form AddEntitiesPanel
     */
    public AddEntitiesPanel() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfName = new javax.swing.JTextField();
        btnAddMission = new javax.swing.JButton();
        btnUpdateMission = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsInstruments = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lsMissions = new javax.swing.JList<>();
        btnAddSpacecraft = new javax.swing.JButton();
        btnUpdateSpacecraft = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsSpacecraft = new javax.swing.JList<>();
        btnAddInstrument = new javax.swing.JButton();
        btnUpdateInstrument = new javax.swing.JButton();
        lbError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        btnAddMission.setText("Add mission");
        btnAddMission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMissionActionPerformed(evt);
            }
        });

        btnUpdateMission.setText("Update mission");
        btnUpdateMission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMissionActionPerformed(evt);
            }
        });

        lsInstruments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsInstrumentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lsInstruments);

        lsMissions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsMissionsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lsMissions);

        btnAddSpacecraft.setText("Add spacecraft");
        btnAddSpacecraft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSpacecraftActionPerformed(evt);
            }
        });

        btnUpdateSpacecraft.setText("Update spacecraft");
        btnUpdateSpacecraft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSpacecraftActionPerformed(evt);
            }
        });

        lsSpacecraft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsSpacecraftMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lsSpacecraft);

        btnAddInstrument.setText("Add instrument");
        btnAddInstrument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddInstrumentActionPerformed(evt);
            }
        });

        btnUpdateInstrument.setText("Update instrument");
        btnUpdateInstrument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateInstrumentActionPerformed(evt);
            }
        });

        lbError.setForeground(new java.awt.Color(255, 0, 0));
        lbError.setText("X");

        jLabel1.setText("Entity name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(btnUpdateInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(17, 17, 17)
                            .addComponent(btnUpdateMission, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnUpdateSpacecraft, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAddInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnAddMission, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnAddSpacecraft, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(342, 342, 342))
            .addGroup(layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbError)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbError))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddMission)
                    .addComponent(btnAddInstrument)
                    .addComponent(btnAddSpacecraft))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateMission)
                    .addComponent(btnUpdateSpacecraft)
                    .addComponent(btnUpdateInstrument))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMissionActionPerformed
      createEntity(Mission.class, tfName.getText().trim(), repo::createMission);
        initMissionList();
    }//GEN-LAST:event_btnAddMissionActionPerformed

    private void btnAddSpacecraftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSpacecraftActionPerformed
          createEntity(Spacecraft.class, tfName.getText().trim(), repo::createSpacecraft);
          initSet(repo::selectSpacecrafts, spacecraftsModel, lsSpacecraft);
    }//GEN-LAST:event_btnAddSpacecraftActionPerformed

    private void btnAddInstrumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInstrumentActionPerformed
         createEntity(Instrument.class, tfName.getText().trim(), repo::createInstrument);
          initSet(repo::selectInstruments, instrumentsModel, lsInstruments);
    }//GEN-LAST:event_btnAddInstrumentActionPerformed

    private void btnUpdateInstrumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateInstrumentActionPerformed
       
        updateEntity(
        selectedId, 
        () -> new Instrument(tfName.getText().trim()), 
        repo::updateInstruments, 
        instrumentsModel, 
        lsInstruments
    );
       initSet(repo::selectInstruments, instrumentsModel, lsInstruments);
            
    }//GEN-LAST:event_btnUpdateInstrumentActionPerformed

    private void btnUpdateMissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMissionActionPerformed
       updateEntity(
        selectedId, 
        () -> new Mission(tfName.getText().trim()), 
        repo::updateMission, 
        missionsModel, 
        lsMissions
    );
        initMissionList();
    }//GEN-LAST:event_btnUpdateMissionActionPerformed

    private void btnUpdateSpacecraftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSpacecraftActionPerformed
          updateEntity(
        selectedId, 
        () -> new Spacecraft(tfName.getText().trim()), 
        repo::updateSpacecraft, 
        spacecraftsModel, 
        lsSpacecraft
    );
       initSet(repo::selectSpacecrafts, spacecraftsModel, lsSpacecraft);
    }//GEN-LAST:event_btnUpdateSpacecraftActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        initJLists();
       initMissionList();
    }//GEN-LAST:event_formComponentShown

    private void lsInstrumentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsInstrumentsMouseClicked
        selectedId = lsInstruments.getSelectedValue().getId();
        tfName.setText(lsInstruments.getSelectedValue().getInstrumentName());
    }//GEN-LAST:event_lsInstrumentsMouseClicked

    private void lsMissionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsMissionsMouseClicked
         selectedId = lsMissions.getSelectedValue().getId();
        tfName.setText(lsMissions.getSelectedValue().getMissionName());
    }//GEN-LAST:event_lsMissionsMouseClicked

    private void lsSpacecraftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsSpacecraftMouseClicked
         selectedId = lsSpacecraft.getSelectedValue().getId();
        tfName.setText(lsSpacecraft.getSelectedValue().getSpacecraftName());
    }//GEN-LAST:event_lsSpacecraftMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddInstrument;
    private javax.swing.JButton btnAddMission;
    private javax.swing.JButton btnAddSpacecraft;
    private javax.swing.JButton btnUpdateInstrument;
    private javax.swing.JButton btnUpdateMission;
    private javax.swing.JButton btnUpdateSpacecraft;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbError;
    private javax.swing.JList<Instrument> lsInstruments;
    private javax.swing.JList<Mission> lsMissions;
    private javax.swing.JList<Spacecraft> lsSpacecraft;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables

    private void init() {
   
            hideErrors();
            initRepository();
            
            
    }
    private void initRepository() {
    repo = RepositoryFactory.getRepository();
    }

    private void hideErrors() {
        lbError.setVisible(false);
    }

    private boolean formValid() {
        hideErrors();
        boolean ok = true;
        ok &= !tfName.getText().trim().isEmpty();
        lbError.setVisible(tfName.getText().trim().isEmpty());
        return ok;
    }

    private void clearForm() {
       tfName.setText("");
    }
     private <T> void createEntity(Class<T> clazz, String name, CheckedConsumer<T> saveFunction) {
    if (!formValid()) {
        return;
    }
    
    try {
       
        T entity = clazz.getConstructor(String.class).newInstance(name);

      
        saveFunction.accept(entity);

        clearForm();
    } catch (Exception ex) {
        Logger.getLogger(AddEntitiesPanel.class.getName()).log(Level.SEVERE, null, ex);
        MessageUtils.showErrorMessage("Error", "Unable to add " + clazz.getSimpleName().toLowerCase());
    }
     }
     private <T> void updateEntity(
    int selectedId, 
    Supplier<T> entitySupplier, 
    CheckedBiConsumer<Integer, T> updateFunction, 
    DefaultListModel<T> model, 
    JList<T> list) {

    if (selectedId == 0) {
        return; 
    }
    if (!formValid()) {
        return;
    }
    try {
        
        T entity = entitySupplier.get();

        
        updateFunction.accept(selectedId, entity);

        clearForm();
    } catch (Exception e) {
        Logger.getLogger(AddJournalPanel.class.getName())
               .log(Level.SEVERE, null, e);
        MessageUtils.showErrorMessage("Error", "Unable to update");
    }
}

private <T> void initSet(CheckedSupplier<Set<T>> dataSupplier, DefaultListModel<T> model, JList<T> list) {
    try {
        model.clear();
        Set<T> data = dataSupplier.get();
        data.forEach(model::addElement);
        list.setModel(model);
    } catch (Exception e) {
     
        MessageUtils.showErrorMessage("Error", "Unable to initialize the set");
    }
}
    private void initJLists() {
            initSet(repo::selectInstruments, instrumentsModel, lsInstruments);
           initSet(repo::selectSpacecrafts, spacecraftsModel, lsSpacecraft);

    }

    private void initMissionList() {
        try {
            missionsModel.clear();
             missionSet = repo.selectMissions();
             missionSet.stream()
                     .sorted()
                     .forEach(
                             missionsModel::addElement);
             lsMissions.setModel(missionsModel);
            
        } catch (Exception e) {
             MessageUtils.showErrorMessage("Error", "Unable to initialize the list" + e.getMessage());
        }
       
    }

     public interface CheckedConsumer<T> {
    void accept(T t) throws Exception;
}
public interface CheckedSupplier<T> {
    T get() throws Exception;
}
public interface CheckedBiConsumer<T, U> {
    void accept(T t, U u) throws Exception;
}
}
