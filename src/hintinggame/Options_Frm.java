/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hintinggame;

import com.mysql.jdbc.Connection;
import java.awt.Image;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author pc
 */
public class Options_Frm extends javax.swing.JFrame {

    /**
     * Creates new form Options_Frm
     * @param mazeWidth
     */
    
    int[][] cordonees_x = {
        {130, 305, 480, 655},
        {110, 250, 390, 530, 670},
        {100, 217, 333, 450, 567, 683},
        {90, 190, 290, 390, 490, 590, 690},
        {83, 170, 258, 345, 433, 520, 608, 695}
    };
    
    int[][] cordonees_y = {
        {56, 156, 256, 356},
        {46, 126, 206, 286, 366},
        {40, 107, 173, 240, 307, 373},
        {34, 91, 148, 205, 262, 319, 377},
        {30, 80, 130, 180, 230, 280, 330, 380}
    };
    
    int[][] h_obs_cordonees_x = {
        {86, 261, 436, 611},
        {86, 226, 366, 506, 646},
        {86, 203, 320, 437, 554, 671},
        {86, 186, 286, 386, 486, 586, 686},
        {86, 173, 260, 347, 435, 523, 610, 698}
    };
    
    int[][] h_obs_cordonees_y = {
        {126, 226, 326},
        {106, 186, 266, 346},
        {92, 159, 226, 293, 360},
        {83, 140, 197, 254, 311, 368},
        {76, 126, 176, 226, 276, 326, 376}
    };
    
    int[][] v_obs_cordonees_x = {
        {240, 415, 590, 765},
        {206, 346, 486, 626, 766},
        {183, 300, 416, 533, 650, 766},
        {165, 265, 365, 465, 565, 665, 765},
        {152, 239, 327, 414, 502, 589, 677, 764}
    };
    
    int[][] v_obs_cordonees_y = {
        {40, 140, 240, 340},
        {40, 120, 200, 280, 360},
        {40, 107, 173, 240, 307, 373},
        {40, 97, 154, 211, 269, 326, 383},
        {40, 90, 140, 190, 240, 290, 340, 390}
    };
    
    private String thisMazeWidth, thisMazeLength, initXPos, initYPos, thisxTrgt, thisyTrgt;
    private int thisgame_id;
    
    private int v_obs_count = 0;
    private int h_obs_count = 0;
    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost/learninghintinggame";
    
    public Options_Frm(String mazeWidth, String mazeLength, String xPos, String yPos, String xTrgt, String yTrgt, int game_id) {
        super();
        initComponents();
        
        thisMazeWidth = mazeWidth;
        thisMazeLength = mazeLength;
        initXPos = xPos;
        initYPos = yPos;
        thisxTrgt = xTrgt;
        thisyTrgt = yTrgt;
        thisgame_id = game_id;
        
        String vImageName = "Calque_" + mazeWidth + "_v.png";
        Image imgv = new ImageIcon(this.getClass().getResource(vImageName)).getImage();
        v_calque_lbl.setIcon(new ImageIcon(imgv));
        String hImageName = "Calque_" + mazeLength + "_h.png";
        Image imgh = new ImageIcon(this.getClass().getResource(hImageName)).getImage();
        h_calque_lbl.setIcon(new ImageIcon(imgh));
        
        int intMazeWidth = Integer.parseInt(mazeWidth) - 4;
        int intMazeLength = Integer.parseInt(mazeLength) - 4;
        
        int intxPos = Integer.parseInt(xPos) - 1;
        int intyPos = Integer.parseInt(yPos) - 1;
        
        int TxPos = Integer.parseInt(thisxTrgt) - 1;
        int TyPos = Integer.parseInt(thisyTrgt) - 1;
        
        cheese_lbl.setLocation(cordonees_x[intMazeWidth][TxPos], cordonees_y[intMazeLength][TyPos]);
        mouse_lbl.setLocation(cordonees_x[intMazeWidth][intxPos], cordonees_y[intMazeLength][intyPos]);
        
        String hObstacleImageName = "h_" + mazeWidth + "_obstacle.png";
        Image obsimgh = new ImageIcon(this.getClass().getResource(hObstacleImageName)).getImage();
        hObs1_lbl.setIcon(new ImageIcon(obsimgh));
        hObs2_lbl.setIcon(new ImageIcon(obsimgh));
        hObs3_lbl.setIcon(new ImageIcon(obsimgh));
        
        String vObstacleImageName = "v_" + mazeLength + "_obstacle.png";
        Image obsimgv = new ImageIcon(this.getClass().getResource(vObstacleImageName)).getImage();
        vObs1_lbl.setIcon(new ImageIcon(obsimgv));
        vObs2_lbl.setIcon(new ImageIcon(obsimgv));
        vObs3_lbl.setIcon(new ImageIcon(obsimgv));
        
        int intMazewidth = Integer.parseInt(thisMazeWidth);
        cheeseXposCombo.removeAllItems();
        for(int i =1; i < intMazewidth; i++) {
            cheeseXposCombo.addItem(String.valueOf(i));
        }
        
        int intMazelength = Integer.parseInt(thisMazeLength);
        cheeseYposCombo.removeAllItems();
        for(int i =1; i <= intMazelength; i++) {
            cheeseYposCombo.addItem(String.valueOf(i));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mouse_lbl = new javax.swing.JLabel();
        cheese_lbl = new javax.swing.JLabel();
        hObs2_lbl = new javax.swing.JLabel();
        vObs3_lbl = new javax.swing.JLabel();
        vObs1_lbl = new javax.swing.JLabel();
        vObs2_lbl = new javax.swing.JLabel();
        hObs1_lbl = new javax.swing.JLabel();
        hObs3_lbl = new javax.swing.JLabel();
        h_calque_lbl = new javax.swing.JLabel();
        v_calque_lbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cheeseYposCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cheeseXposCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        typeCombo = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        gammatxt = new javax.swing.JTextField();
        alphatxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        crtxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        smrtxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        prtxt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        nbmitxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nbmetxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(null);

        mouse_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mouse_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hintinggame/Mouse.png"))); // NOI18N
        jPanel1.add(mouse_lbl);
        mouse_lbl.setBounds(390, 260, 90, 70);

        cheese_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cheese_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hintinggame/Cheese.png"))); // NOI18N
        jPanel1.add(cheese_lbl);
        cheese_lbl.setBounds(190, 360, 90, 70);

        hObs2_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hintinggame/h_7_obstacle.png"))); // NOI18N
        jPanel1.add(hObs2_lbl);
        hObs2_lbl.setBounds(70, 10, 240, 30);

        vObs3_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vObs3_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hintinggame/v_4_obstacle.png"))); // NOI18N
        vObs3_lbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(vObs3_lbl);
        vObs3_lbl.setBounds(20, 140, 40, 180);

        vObs1_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vObs1_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hintinggame/v_8_obstacle.png"))); // NOI18N
        vObs1_lbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(vObs1_lbl);
        vObs1_lbl.setBounds(20, 140, 40, 200);

        vObs2_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vObs2_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hintinggame/v_5_obstacle.png"))); // NOI18N
        vObs2_lbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(vObs2_lbl);
        vObs2_lbl.setBounds(20, 130, 40, 210);

        hObs1_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hintinggame/h_8_obstacle.png"))); // NOI18N
        jPanel1.add(hObs1_lbl);
        hObs1_lbl.setBounds(70, 10, 230, 30);

        hObs3_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hintinggame/h_7_obstacle.png"))); // NOI18N
        jPanel1.add(hObs3_lbl);
        hObs3_lbl.setBounds(70, 10, 220, 30);

        h_calque_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        h_calque_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hintinggame/Calque_4_h.png"))); // NOI18N
        jPanel1.add(h_calque_lbl);
        h_calque_lbl.setBounds(0, 0, 870, 480);

        v_calque_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        v_calque_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hintinggame/Calque_7_v.png"))); // NOI18N
        jPanel1.add(v_calque_lbl);
        v_calque_lbl.setBounds(0, 0, 870, 480);

        jButton1.setFont(new java.awt.Font("Albertus MT", 0, 14)); // NOI18N
        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Albertus MT", 0, 14)); // NOI18N
        jButton2.setText("Previous");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Obstacle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Albertus MT", 0, 14))); // NOI18N

        cheeseYposCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cheeseYposCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cheeseYposComboItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Albertus MT", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("X-Pos :");

        cheeseXposCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cheeseXposCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cheeseXposComboItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Albertus MT", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Y-Pos :");

        jLabel1.setFont(new java.awt.Font("Albertus MT", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Type :");

        typeCombo.setFont(new java.awt.Font("Albertus MT", 0, 14)); // NOI18N
        typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vertical", "Horizontal" }));
        typeCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeComboItemStateChanged(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Albertus MT", 0, 14)); // NOI18N
        jButton5.setText("Add Obstacle");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cheeseXposCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(cheeseYposCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(typeCombo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cheeseXposCombo)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cheeseYposCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Learning Settings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Albertus MT", 0, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Albertus MT", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Gamma :");

        gammatxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gammatxt.setText("0.07");

        alphatxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        alphatxt.setText("0.07");

        jLabel5.setFont(new java.awt.Font("Albertus MT", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Alpha :");

        crtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        crtxt.setText("999");
        crtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crtxtActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Albertus MT", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Catch-Reward :");

        smrtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        smrtxt.setText("-0.7");

        jLabel7.setFont(new java.awt.Font("Albertus MT", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Safe Move-Reward");

        jLabel10.setFont(new java.awt.Font("Albertus MT", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Punition Reward");

        prtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prtxt.setText("-2");
        prtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prtxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(gammatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(alphatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(smrtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(crtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(prtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(smrtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(gammatxt)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(alphatxt)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(crtxt)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(prtxt)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Training Limits", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Albertus MT", 0, 14))); // NOI18N

        nbmitxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nbmitxt.setText("500");
        nbmitxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nbmitxtActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Albertus MT", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("NB Max Interactions :");

        jLabel9.setFont(new java.awt.Font("Albertus MT", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("NB Max Episodes :");

        nbmetxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nbmetxt.setText("400");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nbmitxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(nbmetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(nbmitxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nbmetxt)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.setLocationRelativeTo(null);
        this.setTitle("Hinting Game Learning - Costumize");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        vObs1_lbl.setVisible(false);
        vObs2_lbl.setVisible(false);
        vObs3_lbl.setVisible(false);
        hObs1_lbl.setVisible(false);
        hObs2_lbl.setVisible(false);
        hObs3_lbl.setVisible(false);
        
        try {
            Image iconimage = ImageIO.read(getClass().getResource("Cheese.png"));
            this.setIconImage(iconimage);
        } catch (IOException ex) {
            Logger.getLogger(Options_Frm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String gamma = (String) gammatxt.getText();
        String alpha = (String) alphatxt.getText();
        String catchreward = (String) crtxt.getText();
        String safemovereward = (String) smrtxt.getText();
        String punitionreward = (String) prtxt.getText();
        String nbmaxinteraction = (String) nbmitxt.getText();
        String nbmaxepisodes = (String) nbmetxt.getText();
        
        Connection conn = null;
        
        try {
            conn = (Connection) DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement("insert into learningsettings (id, gamma, alpha, punitionreward, catchreward, safemovereward, nbmaxinteraction, nbmaxepisodes, gameid) values (NULL,?,?,?,?,?,?,?,?)");
            
            stmt.setString(1, gamma);
            stmt.setString(2, alpha);
            stmt.setString(3, punitionreward);
            stmt.setString(4, catchreward);
            stmt.setString(5, safemovereward);
            stmt.setString(6, nbmaxinteraction);
            stmt.setString(7, nbmaxepisodes);
            stmt.setInt(8, thisgame_id);
            
            System.out.println("Writing Game Setting to the DataBase ...");
            
            if (stmt.executeUpdate() != 0) {
                System.out.println("Done!");
            } else {
                System.out.println("Error!");
            }
            
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        this.setVisible(false);
        Main_Frm window = new Main_Frm();
        window.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Welcome_Frm window = new Welcome_Frm();
        window.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cheeseYposComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cheeseYposComboItemStateChanged
        
    }//GEN-LAST:event_cheeseYposComboItemStateChanged

    private void cheeseXposComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cheeseXposComboItemStateChanged
        
    }//GEN-LAST:event_cheeseXposComboItemStateChanged

    private void nbmitxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbmitxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nbmitxtActionPerformed

    private void typeComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typeComboItemStateChanged
        // TODO add your handling code here:
        if(typeCombo.getSelectedItem().equals("Vertical")) {
            int intMazewidth = Integer.parseInt(thisMazeWidth);
            cheeseXposCombo.removeAllItems();
            for(int i =1; i < intMazewidth; i++) {
                cheeseXposCombo.addItem(String.valueOf(i));
            }

            int intMazelength = Integer.parseInt(thisMazeLength);
            cheeseYposCombo.removeAllItems();
            for(int i =1; i <= intMazelength; i++) {
                cheeseYposCombo.addItem(String.valueOf(i));
            }
        } else {
            int intMazewidth = Integer.parseInt(thisMazeWidth);
            cheeseXposCombo.removeAllItems();
            for(int i =1; i <= intMazewidth; i++) {
                cheeseXposCombo.addItem(String.valueOf(i));
            }

            int intMazelength = Integer.parseInt(thisMazeLength);
            cheeseYposCombo.removeAllItems();
            for(int i =1; i < intMazelength; i++) {
                cheeseYposCombo.addItem(String.valueOf(i));
            }
        }
    }//GEN-LAST:event_typeComboItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int intMazeWidth = Integer.parseInt(thisMazeWidth) - 4;
        int intMazeLength = Integer.parseInt(thisMazeLength) - 4;
        
        int obsxpos = Integer.parseInt((String) cheeseXposCombo.getSelectedItem()) - 1;
        int obsypos = Integer.parseInt((String) cheeseYposCombo.getSelectedItem()) - 1;
        
        if(typeCombo.getSelectedItem().equals("Vertical")) {
            if(v_obs_count == 0) {
                setObstacle(thisgame_id, "V", obsxpos, obsypos);
                vObs1_lbl.setLocation(v_obs_cordonees_x[intMazeWidth][obsxpos], v_obs_cordonees_y[intMazeLength][obsypos]);
                vObs1_lbl.setVisible(true);
                v_obs_count++;
            } else if(v_obs_count == 1) {
                setObstacle(thisgame_id, "V", obsxpos, obsypos);
                vObs2_lbl.setLocation(v_obs_cordonees_x[intMazeWidth][obsxpos], v_obs_cordonees_y[intMazeLength][obsypos]);
                vObs2_lbl.setVisible(true);
                v_obs_count++;
            } else if(v_obs_count == 2) {
                setObstacle(thisgame_id, "V", obsxpos, obsypos);
                vObs3_lbl.setLocation(v_obs_cordonees_x[intMazeWidth][obsxpos], v_obs_cordonees_y[intMazeLength][obsypos]);
                vObs3_lbl.setVisible(true);
                v_obs_count++;
            }
        } else {
            if(h_obs_count == 0) {
                setObstacle(thisgame_id, "H", obsxpos, obsypos);
                hObs1_lbl.setLocation(h_obs_cordonees_x[intMazeWidth][obsxpos], h_obs_cordonees_y[intMazeLength][obsypos]);
                hObs1_lbl.setVisible(true);
                h_obs_count++;
            } else if(h_obs_count == 1) {
                setObstacle(thisgame_id, "H", obsxpos, obsypos);
                hObs2_lbl.setLocation(h_obs_cordonees_x[intMazeWidth][obsxpos], h_obs_cordonees_y[intMazeLength][obsypos]);
                hObs2_lbl.setVisible(true);
                h_obs_count++;
            } else if(h_obs_count == 2) {
                setObstacle(thisgame_id, "H", obsxpos, obsypos);
                hObs3_lbl.setLocation(h_obs_cordonees_x[intMazeWidth][obsxpos], h_obs_cordonees_y[intMazeLength][obsypos]);
                hObs3_lbl.setVisible(true);
                h_obs_count++;
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void prtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prtxtActionPerformed

    private void crtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crtxtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Options_Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Options_Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Options_Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Options_Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Options_Frm("6", "6", "1", "1", "1", "2", 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alphatxt;
    private javax.swing.JComboBox<String> cheeseXposCombo;
    private javax.swing.JComboBox<String> cheeseYposCombo;
    private javax.swing.JLabel cheese_lbl;
    private javax.swing.JTextField crtxt;
    private javax.swing.JTextField gammatxt;
    private javax.swing.JLabel hObs1_lbl;
    private javax.swing.JLabel hObs2_lbl;
    private javax.swing.JLabel hObs3_lbl;
    private javax.swing.JLabel h_calque_lbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel mouse_lbl;
    private javax.swing.JTextField nbmetxt;
    private javax.swing.JTextField nbmitxt;
    private javax.swing.JTextField prtxt;
    private javax.swing.JTextField smrtxt;
    private javax.swing.JComboBox<String> typeCombo;
    private javax.swing.JLabel vObs1_lbl;
    private javax.swing.JLabel vObs2_lbl;
    private javax.swing.JLabel vObs3_lbl;
    private javax.swing.JLabel v_calque_lbl;
    // End of variables declaration//GEN-END:variables

    private void setObstacle(int game_id, String type, int x_pos, int y_pos) {
        Connection conn = null;
        
        try {
            conn = (Connection) DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement("insert into obstacles (id, game_id, type, x_pos, y_pos) values (NULL,?,?,?,?)");
            
            stmt.setInt(1, game_id);
            stmt.setString(2, type);
            stmt.setInt(3, x_pos + 1);
            stmt.setInt(4, y_pos + 1);
            
            System.out.println("Adding obstacle to the DataBase ...");
            
            if (stmt.executeUpdate() != 0) {
                System.out.println("Done!");
            } else {
                System.out.println("Error!");
            }
            
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
