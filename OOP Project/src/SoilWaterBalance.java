public class SoilWaterBalance {
    private double WP;         // wilting point
    private double FC;         // field capacity
    private double ST;         // saturation
    private double THE; // threshold soil water content

    private double SWFAC1, SWFAC2;


    /////////////////////////
    private double TRAIN; // rainfall
    private double TIRR; // irrigation
    private double TESA; // soil evaporation
    private double TEPA; // plant transpiration
    private double TROF; // runoff
    private double TDRN; //vertical drainage
    private double TINF; //infiltration

    public SoilWaterBalance (){
        TRAIN = 0;
        TIRR = 0;
        TESA = 0;
        TEPA = 0;
        TROF = 0;
        TDRN = 0;
        TINF = 0;
    };

    public void volumetricConversions (double DP, double WPp, double FCp, double STp){
        WP = DP * WPp * 10.0;
        FC = DP * FCp * 10.0;
        ST = DP * STp * 10.0;
    }

    private double S; //Soil Storage capacity
    public double RUNOFF (double CN){
        S = 254 * ((100/CN) - 1);
        return S;
    }

    public double STRESS (){
        // THE threshold soil water content
        THE = WP + 0.75 * (FC - WP);
        return THE;
    }



        ///////////////////////////////////////////
                // RATE CALCULATION //

        private double POTINF; //Potential Infiltration
        public double calPOTINF (double RAIN, double IRR) {
            POTINF = RAIN + IRR; // Potential infiltration
            TIRR = IRR;
            TRAIN = RAIN;
            return POTINF;
        }


        //// TO CALCULATE VERTICAL DRAINAGE OF SOIL (DRN in mm) ////
        private double ROF; // daily surface water runoff rates
        private double INF; // Infiltration
        private double DRN; // drainage of soil water in mm
        public double[] DRAINE (double SWC, double DRNp, double CN){
        DRN = (SWC - FC) * DRNp;

        if (POTINF > 0){
                ROF = RUNOFF(CN);  // to compute daily surface water runoff rates
        }else if (POTINF > (0.2*S)) {
                ROF = ((POTINF-0.2*S)*2)/(POTINF+0.8*RUNOFF(CN));
        }else   ROF = 0;

            INF = POTINF - ROF;
            return new double[]{ROF,INF,DRN};
    }

    double ESp; // soil evaporation
    double EPp; // plant transpiration
    double ETp = 0; //evapotranspiration rate
    double ALB; // surface albedo
    private double Tmed; // average temperature during day
    double EEQ; // equilibrium evaporation

    //// TO CALCULATE DAILY EVAPOTRANSPIRATION RATE (ETp) ////
        public void ETpS (double LAI, double TMIN, double TMAX, double SRAD, double f){
            ALB = 0.1 * Math.exp(-0.7*LAI) + 0.2 * (1-Math.exp(-0.7*LAI));
            Tmed = 0.6 * TMAX + 0.4 * TMIN;
            EEQ = SRAD * (4.88-4.37*ALB)*(Tmed+29);
            ETp = f+ETp;
            ESp = ETp * Math.exp(-0.7*LAI);
            EPp = ETp * (1-Math.exp(-0.7*LAI));

        }


    //// TO CALCULATE ACTUAL DAILY SOIL EVAPORATION (ESa) ////
    private double ESa; // actual daily evaporation rate
    private double a;

        public void ESaS(double SWC){
                if (FC < WP){
                    System.out.println("No evaporation occurs");
                }else if(FC > WP){
                    System.out.println("potential evaporation is met");
                }
                if (SWC < WP) {
                    a = 0;
                }else if(SWC > FC){
                    a = 1;
                }else a = (SWC-WP)/(FC-WP);

                ESa = ESp * a;
                EPp -= SWFAC1;

        }

        ///////////////////////////////////////////
                // INTEGRATION //

    private double SWC_ADJ; // Additional adjustment factor
    private double WTABLE; // Soil Profile
    private double DWT;    // Water table
    private final double STRESS_DEPTH = 250;
        public void integration (double SWC, double DP){

            SWC = SWC + (TINF - ESa - ESp - DRN);

            if (SWC > ST){
                ROF = ROF + (SWC - ST);
                SWC = ST;
            } else if (SWC < 0) {
                SWC_ADJ = SWC_ADJ-SWC;
                SWC = 0;
            }

            if (SWC < WP){
                SWFAC1 = 0.0;
            } else if (SWC >THE) {
                SWFAC1 = 1.0;
            } else SWFAC1 =( SWC - WP)/(THE - WP);
            WTABLE = (SWC - FC)/(ST - FC)*DP *10;
            DWT = DP*10 - WTABLE;

            if (DWT > STRESS_DEPTH){
                SWFAC2 = 1.0;
            }else SWFAC2 = DWT / STRESS_DEPTH;

        }


    public double getWP() {
        return WP;
    }

    public double getFC() {
        return FC;
    }

    public double getST() {
        return ST;
    }

    public double getTHE() {
        return THE;
    }

    public double getSWFAC1() {
        return SWFAC1;
    }

    public double getSWFAC2() {
        return SWFAC2;
    }

    public double getTRAIN() {
        return TRAIN;
    }

    public double getTIRR() {
        return TIRR;
    }

    public double getTESA() {
        return TESA;
    }

    public double getTEPA() {
        return TEPA;
    }

    public double getTROF() {
        return TROF;
    }

    public double getTDRN() {
        return TDRN;
    }

    public double getTINF() {
        return TINF;
    }


    public double getPOTINF() {
        return POTINF;
    }

    public double getROF() {
        return ROF;
    }

    public double getINF() {
        return INF;
    }

    public double getDRN() {
        return DRN;
    }

    public double getESp() {
        return ESp;
    }

    public double getEPp() {
        return EPp;
    }

    public double getETp() {
        return ETp;
    }

    public double getALB() {
        return ALB;
    }

    public double getTmed() {
        return Tmed;
    }

    public double getEEQ() {
        return EEQ;
    }

    public double getESa() {
        return ESa;
    }

    public double getA() {
        return a;
    }

    public double getSWC_ADJ() {
        return SWC_ADJ;
    }

    public double getWTABLE() {
        return WTABLE;
    }

    public double getDWT() {
        return DWT;
    }

    public double getSTRESS_DEPTH() {
        return STRESS_DEPTH;
    }

    public double getS(){
            return S;
    }

}
