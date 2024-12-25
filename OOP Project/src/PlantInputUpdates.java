import javax.swing.*;
import java.io.*;
import java.nio.file.Path;

public class PlantInputUpdates {
    private double EMP1, EMP2, fc, intot, lai, Lfmax, n, nb, p1, PD, rm, sla, tb, w, wc, wr;
    double[] value = new double[16];
    String path;

    // select the file and take input in value[16] array
        public String chooseFile() throws IOException {
            JFileChooser jChooser = new JFileChooser();
            String message;
            int f = jChooser.showSaveDialog(null);
            jChooser.showSaveDialog(null);

            if (f == JFileChooser.APPROVE_OPTION) {
                path = String.valueOf(jChooser.getSelectedFile().getAbsoluteFile().toURI());
                File infile = new File(jChooser.getSelectedFile().getAbsoluteFile().toURI());
                BufferedReader br = new BufferedReader(new FileReader(infile));
                String st;
                int count = 0;

                while ((st = br.readLine()) != null) {
                    try {
                        value[count] = Double.parseDouble(st);
                    }
                    catch (Exception e){
                        System.out.println("Exception caught");
                        return "Please select Valid File";
                    }
                    count++;
                }
                br.close();
                return  "File selected";

            }
            else {
                return  "No file selected";
            }

           //return message;
        }

        // initializes the values and set to their respective parameters
        public void initializeValues() {
            EMP1 = value[0];
            EMP2 = value[1];
            fc = value[2];
            intot = value[3];
            lai = value[4];
            Lfmax = value[5];
            n = value[6];
            nb = value[7];
            p1 = value[8];
            PD = value[9];
            rm = value[10];
            sla = value[11];
            tb = value[12];
            w = value[13];
            wc = value[14];
            wr = value[15];
        }

    public void writeResult(String writeFileName, String text)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(writeFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(text);

            // Always close files.
            bufferedWriter.close();

        }
        catch(IOException ex) {
            System.out.println("Error writing to file '"+ writeFileName + "'");}
    }

    public double getEMP1() {
        return EMP1;
    }
    public double getEMP2() {
        return EMP2;
    }
    public double getLai() {
        return lai;
    }
    public double getLfmax() {
        return Lfmax;
    }
    public double getN() {
        return n;
    }
    public double getNb() {
        return nb;
    }
    public double getP1() {
        return p1;
    }
    public double getPD() {
        return PD;
    }
    public double getRm() {
        return rm;
    }
    public double getSla() {
        return sla;
    }
    public double getTb() {
        return tb;
    }
    public double getFc(){
            return fc;
    }
    public double getW() {
        return w;
    }

    public double getIntot() {
        return intot;
    }

    public void setEMP1(double EMP1) {
        this.EMP1 = EMP1;
    }

    public void setEMP2(double EMP2) {
        this.EMP2 = EMP2;
    }

    public void setFc(double fc) {
        this.fc = fc;
    }

    public void setIntot(double intot) {
        this.intot = intot;
    }

    public void setLai(double lai) {
        this.lai = lai;
    }

    public void setLfmax(double lfmax) {
        Lfmax = lfmax;
    }

    public void setN(double n) {
        this.n = n;
    }

    public void setNb(double nb) {
        this.nb = nb;
    }

    public void setP1(double p1) {
        this.p1 = p1;
    }

    public void setPD(double PD) {
        this.PD = PD;
    }

    public void setRm(double rm) {
        this.rm = rm;
    }

    public void setSla(double sla) {
        this.sla = sla;
    }

    public void setTb(double tb) {
        this.tb = tb;
    }

    public void setW(double w) {
        this.w = w;
    }

    public void setWc(double wc) {
        this.wc = wc;
    }

    public void setWr(double wr) {
        this.wr = wr;
    }

    public void setValue(double[] value) {
        this.value = value;
    }

    public void setPath(String path) {
        this.path = path;
    }
}