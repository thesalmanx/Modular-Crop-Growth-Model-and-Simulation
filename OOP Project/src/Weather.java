import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Weather {
    private double DATE; // date in YY-DD format
    private double PAR; // daily photosynthetically active radiation
    private double RAIN; // daily rainfall
    private double SRAD; // daily solar radiation
    private double TMAX; // daily maximum temperature
    private double TMIN; // daily minimum temperature

    double[] value = new double[6];

    public Weather(){};

    // select the file and take input in value[6] array
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
        DATE = value[0];
        PAR = value[1];
        RAIN = value[2];
        SRAD = value[3];
        TMAX = value[4];
        TMIN = value[5];
    }

    public double getDATE() {
        return DATE;
    }
    public double getPAR() {
        return PAR;
    }
    public double getRAIN() {
        return RAIN;
    }
    public double getSRAD() {
        return SRAD;
    }
    public double getTMAX() {
        return TMAX;
    }
    public double getTMIN() {
        return TMIN;
    }
    public double[] getValue() {
        return value;
    }

    public void setDATE(double DATE) {
        this.DATE = DATE;
    }

    public void setPAR(double PAR) {
        this.PAR = PAR;
    }

    public void setRAIN(double RAIN) {
        this.RAIN = RAIN;
    }

    public void setSRAD(double SRAD) {
        this.SRAD = SRAD;
    }

    public void setTMAX(double TMAX) {
        this.TMAX = TMAX;
    }

    public void setTMIN(double TMIN) {
        this.TMIN = TMIN;
    }

    public void setValue(double[] value) {
        this.value = value;
    }
}
