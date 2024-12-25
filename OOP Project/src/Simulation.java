

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import javax.swing.*;

public class Simulation extends JPanel {
    private JLabel jcomp1;
    private JButton choosefileBtn1;
    private JLabel jcomp3;
    private JLabel jcomp4;
    private JButton choosefileBtn2;
    private JLabel jcomp6;
    private JButton choosefileBtn3;
    private JLabel display1;
    private JLabel display2;
    private JLabel display3;
    private JButton generate1;
    public Simulation() {

        //// construct components ////
        jcomp1 = new JLabel ("Select file for Plant module");
        choosefileBtn1 = new JButton ("Choose File");
        jcomp3 = new JLabel ("   Welcome to Modular Crop Growth Model and Simulation");
        jcomp4 = new JLabel ("Choose file for Soil Water Balance module");
        choosefileBtn2 = new JButton ("Choose File");
        jcomp6 = new JLabel ("Choose file for weather module");
        choosefileBtn3 = new JButton ("Choose File");
        display1 = new JLabel ("L1");
        display2 = new JLabel ("L2");
        display3 = new JLabel ("L3");
        generate1 = new JButton("Generate");
        //adjust size and set layout
        setPreferredSize (new Dimension (770, 543));
        setLayout (null);

        //add components
        add (jcomp1);
        add (choosefileBtn1);
        add (jcomp3);
        add (jcomp4);
        add (choosefileBtn2);
        add (jcomp6);
        add (choosefileBtn3);
        add (display1);
        add (display2);
        add (display3);
        add (generate1);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (80, 115, 190, 35);
        choosefileBtn1.setBounds (380, 115, 100, 20);
        jcomp3.setBounds (225, 20, 335, 40);
        jcomp4.setBounds (80, 145, 250, 25);
        choosefileBtn2.setBounds (380, 145, 100, 20);
        jcomp6.setBounds (80, 175, 200, 25);
        choosefileBtn3.setBounds (380, 175, 100, 20);
        display1.setBounds (515, 115, 175, 20);
        display2.setBounds (515, 145, 175, 20);
        display3.setBounds (515, 175, 175, 20);
        generate1.setBounds(515,300,200,25);
        //// Selecting button 1 ////
        choosefileBtn1.addActionListener(e -> {
            try {
                selectionButtonPressed1();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        //// Selecting button 2 ////
        choosefileBtn2.addActionListener(e -> {
            try {
                selectionButtonPressed2();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        /// Selecting button 3 ////
        choosefileBtn3.addActionListener(e -> {
            try {
                selectionButtonPressed3();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        generate1.addActionListener(e-> {
            try {
                this.simulation();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        ImageIcon background_Image = new ImageIcon("plant.jpeg");
        Image img = background_Image.getImage();
        Image temp_img = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        background_Image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_Image, JLabel.CENTER);
        background.setBounds(0, 0, 900, 600);
        add(background);


    }

    PlantInputUpdates updates1 = new PlantInputUpdates();
    private void selectionButtonPressed1() throws IOException {
        display1.setText(updates1.chooseFile());
        updates1.initializeValues();
    }
    SoilInputUpdates updates2 = new SoilInputUpdates();
    private void selectionButtonPressed2() throws IOException {
        display2.setText(updates2.chooseFile());
        updates2.initializeValues();
    }

    Weather weather = new Weather();
    private void selectionButtonPressed3() throws IOException{
        display3.setText(weather.chooseFile());
        weather.initializeValues();
    }


    public void executeFrames () {
        JFrame frame = new JFrame ("FileChoose");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Simulation());
        frame.pack();
        frame.setVisible (true);
        frame.setLocationRelativeTo(null);
    }


    ///// SIMULATION OF PROJECT ////
    public void simulation() throws IOException {

        // INPUT VALUES ??
        double ROWSPAC = 1;
        double IRR = 1; double f = 1;

        ////// SOIL WATER CLASS SIMULATION /////
        SoilWaterBalance soilWaterBalance = new SoilWaterBalance();

        // INITIALIZE //
        soilWaterBalance.volumetricConversions(updates2.getDP(), updates2.getWPp(), updates2.getFCp(), updates2.getSTp());
        double S = soilWaterBalance.RUNOFF(updates2.getCN());
        double THE = soilWaterBalance.STRESS();
        System.out.println("S = " + S);
        System.out.println("THE = " + THE);

        // RATE CALCULATION //
        double POTINF = soilWaterBalance.calPOTINF(weather.getRAIN(), IRR);
        double[] ROF_INF_DRN = soilWaterBalance.DRAINE(updates2.getSWC(), updates2.getDRNp(), updates2.getCN());
        soilWaterBalance.ETpS(updates1.getLai(),weather.getTMIN(),weather.getTMAX(),weather.getSRAD(),f); //take value of f as input
        soilWaterBalance.ESaS(updates2.getSWC());
        System.out.println("POTINF = " + POTINF);
        System.out.println("ROF_INF_DRN = " + Arrays.toString(ROF_INF_DRN));

        //// CALLING INTEGRATION METHOD ////
        soilWaterBalance.integration(updates2.getSWC(), updates2.getDP());



        //////  PLANT CLASS SIMULATION //////

        String phaseOfPlant;
        double dLai;
        Plant plant = new Plant();

        //// CALLING METHOD 1 ////  (growth rate reduction factor)
        double PT = plant.PTS(weather.getTMIN(),weather.getTMAX());  //1st
        System.out.println("PT = " + PT);
        //// CALLING METHOD 2 ////  (potential dry matter increase)
        double PG = plant.PGS(weather.getSRAD(),ROWSPAC, updates1.getPD(), updates1.getLai());          //2nd
        System.out.println("PG = " + PG);
        //// CALLING METHOD 3 ////
        if (updates1.getLfmax() < updates1.getN()) {
            System.out.println(updates1.getLfmax());
            System.out.println(updates1.getN());
            System.out.println("Plant is in vegetative phase");
            phaseOfPlant = "Plant is in vegetative phase";
            VegetativePhase vegetativePhase = new VegetativePhase();
            dLai = vegetativePhase.LAIS(updates1.getRm(), updates1.getPD(),updates1.getEMP1(), updates1.getN(), updates1.getNb(), updates1.getEMP2(), soilWaterBalance.getSWFAC2());
        }else {
            System.out.println("Plant is in reproductive phase");
            phaseOfPlant = "Plant is in reproductive phase";
            ReproductivePhase reproductivePhase = new ReproductivePhase();
            dLai = reproductivePhase.LAIS(weather.getTMIN(),weather.getTMAX(), updates1.getTb(), updates1.getP1(),updates1.getSla(),updates1.getPD());
        }
        System.out.println("dLai  = " + dLai);

        //double[] values = {16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        updates1.writeResult("C:\\Users\\SALMAN\\Desktop\\OOP Project\\Test Files", "salman\nUmer");
        Report report = new Report(updates1, updates2, weather, plant, soilWaterBalance,phaseOfPlant,dLai);
        report.DisplayFrames();

    }


}