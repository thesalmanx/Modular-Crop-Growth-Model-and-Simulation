
public class VegetativePhase extends Plant{

    public double LAIS(double rm ,double PD, double EMP1, double n, double nb, double EMP2, double SWFAC1){

        //leaf number increase
        double dN = rm - PT;
        dLAI = SWFAC1 * PT * PD * dN * EMP1 * (calcA(EMP2,n,nb)/(1+calcA(EMP2,n,nb)));
        return dLAI;
    }
    public double calcA(double EMP2, double n, double nb){
        return Math.exp(EMP2*(n-nb));
    }


    public VegetativePhase() {
    }
}
