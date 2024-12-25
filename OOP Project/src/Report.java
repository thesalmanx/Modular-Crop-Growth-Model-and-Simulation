

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Report extends JPanel {
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JLabel PT;
    private JLabel jcomp4;
    private JLabel PG;
    private JLabel jcomp6;
    private JLabel dLAI;
    private JLabel jcomp8;
    private JLabel S;
    private JLabel jcomp10;
    private JLabel THE;
    private JLabel jcomp12;
    private JLabel POTINF;
    private JLabel jcomp14;
    private JLabel DRN;
    private JLabel jcomp16;
    private JLabel ETp;
    private JLabel jcomp18;
    private JLabel ESa;
    private JLabel jcomp20;
    private JLabel INF;
    private JLabel jcomp22;
    private JLabel jcomp23;
    private JLabel jcomp24;
    private JLabel ESp;
    private JLabel jcomp26;
    private JLabel EPp;
    private JLabel jcomp28;
    private JLabel Tmed;
    private JLabel jcomp30;
    private JLabel EEQ;
    private JLabel jcomp32;
    private JLabel SWC_ADJ;
    private JLabel jcomp34;
    private JLabel WTABLE;
    private JLabel jcomp36;
    private JLabel DWT;
    private JLabel PlantPlase;
    PlantInputUpdates updates1; SoilWaterBalance soilWaterBalance; Weather weather; Plant plant; SoilInputUpdates updates2;
    String phaseOfPlant; double dLai;
    public Report(PlantInputUpdates updates1, SoilInputUpdates updates2, Weather weather, Plant plant, SoilWaterBalance soilWaterBalance, String phaseOfPlant,double dLai) {
        this.updates1 = updates1;  // Plant Input Updates
        this.updates2 = updates2;  // Soil Input Updates
        this.dLai = dLai;
        this.phaseOfPlant = phaseOfPlant;
        this.soilWaterBalance = soilWaterBalance;  // Soil Water Balance
        this.plant = plant;  // Plant
        this.weather = weather;  // weather
        //construct components
        jcomp1 = new JLabel ("        Plant Growth Report");
        jcomp1.setFont(new Font("Serif", Font.PLAIN, 25));
        jcomp2 = new JLabel ("Growth rate reduction factor (PT)");
        PT = new JLabel (String.valueOf(plant.PT));
        jcomp4 = new JLabel (" Potential daily total dry matter increase (PG)");
        PG = new JLabel (String.valueOf(plant.getPG()));
        jcomp6 = new JLabel ("   Leaf number increase(dLAI)");
        dLAI = new JLabel (String.valueOf(dLai));
        jcomp8 = new JLabel ("Soil Storage capacity(S)");
        S = new JLabel (String.valueOf(soilWaterBalance.getS()));
        jcomp10 = new JLabel ("THE threshold soil water content(THE)");
        THE = new JLabel (String.valueOf(soilWaterBalance.getTHE()));
        jcomp12 = new JLabel ("Potential Infiltration(POTINF)");
        POTINF = new JLabel (String.valueOf(soilWaterBalance.getPOTINF()));
        jcomp14 = new JLabel ("Drainage of soil water in mm(DRN)");
        DRN = new JLabel (String.valueOf(soilWaterBalance.getDRN()));
        jcomp16 = new JLabel (" DAILY EVAPOTRANSPIRATION RATE (ETp)");
        ETp = new JLabel (String.valueOf(soilWaterBalance.getETp()));
        jcomp18 = new JLabel ("Actual daily evaporation rate(ESa)");
        ESa = new JLabel (String.valueOf(soilWaterBalance.getESa()));
        jcomp20 = new JLabel (" Infiltration(INF)");
        INF = new JLabel (String.valueOf(soilWaterBalance.getINF()));
        jcomp22 = new JLabel ("Daily surface water runoff rates(ROF)");
        jcomp23 = new JLabel (String.valueOf(soilWaterBalance.getROF()));
        jcomp24 = new JLabel ("Soil evaporation(ESp)");
        ESp = new JLabel (String.valueOf(soilWaterBalance.getESp()));
        jcomp26 = new JLabel ("Plant transpiration(EPp)");
        EPp = new JLabel (String.valueOf(soilWaterBalance.getEPp()));
        jcomp28 = new JLabel ("Average temperature during day(Tmed)");
        Tmed = new JLabel (String.valueOf(soilWaterBalance.getTmed()));
        jcomp30 = new JLabel ("Equilibrium evaporation(EEQ)");
        EEQ = new JLabel (String.valueOf(soilWaterBalance.getEEQ()));
        jcomp32 = new JLabel ("Additional adjustment factor(SWC_ADJ)");
        SWC_ADJ = new JLabel (String.valueOf(soilWaterBalance.getSWC_ADJ()));
        jcomp34 = new JLabel ("Soil Profile(WTABLE)");
        WTABLE = new JLabel (String.valueOf(soilWaterBalance.getWTABLE()));
        jcomp36 = new JLabel ("Water table(DWT)");
        DWT = new JLabel (String.valueOf(soilWaterBalance.getDWT()));
        PlantPlase = new JLabel (phaseOfPlant);

        //adjust size and set layout
        setPreferredSize (new Dimension (987, 569));
        setLayout (null);

        //add components
        add (jcomp1);
        add (jcomp2);
        add (PT);
        add (jcomp4);
        add (PG);
        add (jcomp6);
        add (dLAI);
        add (jcomp8);
        add (S);
        add (jcomp10);
        add (THE);
        add (jcomp12);
        add (POTINF);
        add (jcomp14);
        add (DRN);
        add (jcomp16);
        add (ETp);
        add (jcomp18);
        add (ESa);
        add (jcomp20);
        add (INF);
        add (jcomp22);
        add (jcomp23);
        add (jcomp24);
        add (ESp);
        add (jcomp26);
        add (EPp);
        add (jcomp28);
        add (Tmed);
        add (jcomp30);
        add (EEQ);
        add (jcomp32);
        add (SWC_ADJ);
        add (jcomp34);
        add (WTABLE);
        add (jcomp36);
        add (DWT);
        add (PlantPlase);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (395, 5, 400, 25);
        jcomp2.setBounds (80, 60, 190, 25);
        PT.setBounds (380, 55, 75, 20);
        jcomp4.setBounds (75, 90, 260, 40);
        PG.setBounds (380, 100, 100, 25);
        jcomp6.setBounds (70, 140, 220, 25);
        dLAI.setBounds (380, 140, 100, 25);
        jcomp8.setBounds (500, 50, 145, 25);
        S.setBounds (845, 45, 100, 25);
        jcomp10.setBounds (500, 80, 220, 30);
        THE.setBounds (845, 80, 100, 25);
        jcomp12.setBounds (500, 120, 170, 25);
        POTINF.setBounds (845, 120, 100, 25);
        jcomp14.setBounds (495, 220, 205, 30);
        DRN.setBounds (845, 225, 100, 25);
        jcomp16.setBounds (490, 385, 320, 40);
        ETp.setBounds (845, 400, 100, 25);
        jcomp18.setBounds (495, 425, 205, 30);
        ESa.setBounds (845, 435, 100, 25);
        jcomp20.setBounds (495, 190, 135, 25);
        INF.setBounds (845, 195, 100, 25);
        jcomp22.setBounds (500, 155, 230, 25);
        jcomp23.setBounds (845, 160, 100, 25);
        jcomp24.setBounds (495, 260, 150, 25);
        ESp.setBounds (845, 260, 100, 25);
        jcomp26.setBounds (495, 290, 205, 30);
        EPp.setBounds (845, 295, 100, 25);
        jcomp28.setBounds (495, 325, 245, 25);
        Tmed.setBounds (845, 330, 100, 25);
        jcomp30.setBounds (495, 355, 240, 30);
        EEQ.setBounds (845, 365, 100, 25);
        jcomp32.setBounds (495, 460, 245, 30);
        SWC_ADJ.setBounds (845, 470, 100, 25);
        jcomp34.setBounds (495, 500, 160, 25);
        WTABLE.setBounds (845, 505, 100, 25);
        jcomp36.setBounds (495, 535, 150, 25);
        DWT.setBounds (845, 535, 100, 25);
        PlantPlase.setBounds (75, 190, 330, 25);



//        ImageIcon background_Image = new ImageIcon("C:\\Users\\SALMAN\\Desktop\\ProjectImages\\Crops.jpg");
//        Image img = background_Image.getImage();
//        Image temp_img = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
//        background_Image = new ImageIcon(temp_img);
//        JLabel background = new JLabel("", background_Image, JLabel.CENTER);
//        background.setBounds(0, 0, 900, 600);
//        add(background);
    }


    public void DisplayFrames() {
        JFrame frame = new JFrame ("Report");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Report(updates1, updates2, weather, plant, soilWaterBalance,phaseOfPlant,dLai));
        frame.pack();
        frame.setVisible (true);
        frame.setLocationRelativeTo(null);
    }
}
