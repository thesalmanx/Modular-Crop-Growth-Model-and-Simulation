import java.io.IOException;

public class Plant {
    protected double dLAI; //change in leaf area index
    protected double PT; // calculated in method 1
    protected double PG;

    //// Method 1:
    // to calculate the effect of temperature on daily plant growth rate and rate of leaf number increase.
    public double PTS(double TMIN, double TMAX){
        // The growth rate reduction factor (PT)
            PT = 1-0.0025*Math.pow((((0.25*TMIN)+(0.25*TMAX))-26),2);
        return PT;
    }


    //// Method 2:
    //calculate the daily plant weight increase
    public double PGS(double SRAD, double ROWSPC, double PD, double Lai){
        //potential daily total dry matter increase (PG)
        double Y1 = (1.5-0.768)*Math.pow((Math.pow((ROWSPC*0.01),2)*PD),0.1);
                PG = (SRAD/PD)*(1-Math.exp(-Y1*Lai));
        return PG;
    }




        ////Integration ////
    public void Integration(){


    }


    public double getdLAI() {
        return dLAI;
    }

    public double getPT() {
        return PT;
    }

    public double getPG() {
        return PG;
    }

    public void setdLAI(double dLAI) {
        this.dLAI = dLAI;
    }

    public void setPT(double PT) {
        this.PT = PT;
    }

    public void setPG(double PG) {
        this.PG = PG;
    }
}