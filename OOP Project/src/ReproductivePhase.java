import java.io.IOException;

public class ReproductivePhase extends Plant{

    public ReproductivePhase() throws IOException {}

    public double LAIS(double TMIN, double TMAX, double tb, double p1, double sla, double PD) {
        double di = (TMIN - TMAX)/2 + tb;
        dLAI = -PD * di * p1 * sla;
        return dLAI;
    }

}