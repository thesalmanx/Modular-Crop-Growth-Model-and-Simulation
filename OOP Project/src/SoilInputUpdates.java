import javax.swing.*;
import java.io.*;

public class SoilInputUpdates {

    private double CN, DP, DRNp, FCp, STp, SWC, WPp;
    double[] value = new double[7];

    public SoilInputUpdates() {
    }


    // select the file and take input in value[07] array
    public String chooseFile() throws IOException {
        JFileChooser jChooser = new JFileChooser();
        String message;
        int f = jChooser.showSaveDialog(null);
        jChooser.showSaveDialog(null);

        if (f == JFileChooser.APPROVE_OPTION) {

            File infile = new File(jChooser.getSelectedFile().getAbsoluteFile().toURI());
            BufferedReader br = new BufferedReader(new FileReader(infile));

            String st;
            int count = 0;

            while ((st = br.readLine()) != null) {
                try {
                    value[count] = Double.parseDouble(st);
                }
                catch (Exception e){
                    System.out.println("Exception found");
                    return "Please select Valid File";
                }
                count++;
            }
            return  "File selected";

        } else {return  "No file selected";}
    }


    // initializes the values and set to their respective parameters
    public void initializeValues() {
        CN = value[0];
        DP = value[1];
        DRNp = value[2];
        FCp = value[3];
        STp = value[4];
        SWC = value[5];
        WPp = value[6];
    }

    public double getCN() {
        return CN;
    }
    public double getDP() {
        return DP;
    }
    public double getDRNp() {
        return DRNp;
    }
    public double getFCp() {
        return FCp;
    }
    public double getSTp() {
        return STp;
    }
    public double getSWC() {
        return SWC;
    }
    public double getWPp() {
        return WPp;
    }
    public double[] getValue() {
        return value;
    }

    public void setCN(double CN) {
        this.CN = CN;
    }

    public void setDP(double DP) {
        this.DP = DP;
    }

    public void setDRNp(double DRNp) {
        this.DRNp = DRNp;
    }

    public void setFCp(double FCp) {
        this.FCp = FCp;
    }

    public void setSTp(double STp) {
        this.STp = STp;
    }

    public void setSWC(double SWC) {
        this.SWC = SWC;
    }

    public void setWPp(double WPp) {
        this.WPp = WPp;
    }

    public void setValue(double[] value) {
        this.value = value;
    }
}