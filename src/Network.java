import java.util.Random;

class Network {

    private Random random = new Random();
    private double wSl1 = random.nextInt(7) - 3;
    private double wSw1 = random.nextInt(7) - 3;
    private double wPl1 = random.nextInt(7) - 3;
    private double wPw1 = random.nextInt(7) - 3;
    private double w11 = random.nextInt(7) - 3;

    private double wSl2 = random.nextInt(7) - 3;
    private double wSw2 = random.nextInt(7) - 3;
    private double wPl2 = random.nextInt(7) - 3;
    private double wPw2 = random.nextInt(7) - 3;
    private double w12 = random.nextInt(7) - 3;

    private String species = "";

    private int result1(Flowers flower){
        int res = 0;
        double counting = flower.getPetal_Length() * wPl1 + flower.getPetal_Width() * wPw1 + flower.getSepal_Length() * wSl1 +
                flower.getSepal_Width() * wSw1 + 1 * w11;
        if(counting >= 0)
            res = 1;
        return res;
    }

    private int result2(Flowers flower){
        int res = 0;
        double counting = flower.getPetal_Length() * wPl2 + flower.getPetal_Width() * wPw2 + flower.getSepal_Length() * wSl2 +
                flower.getSepal_Width() * wSw2 + 1 * w12;
        if(counting >= 0)
            res = 1;
        return res;
    }

    private void learn(Flowers flower){
        double mi = 0.5;
        wPl1 += mi *(flower.getSpecies1() - result1(flower)) * flower.getPetal_Length();
        wPl2 += mi *(flower.getSpecies2() - result2(flower)) * flower.getPetal_Length();
        wPw1 += mi *(flower.getSpecies1() - result1(flower)) * flower.getPetal_Width();
        wPw2 += mi *(flower.getSpecies2() - result2(flower)) * flower.getPetal_Width();
        wSl1 += mi *(flower.getSpecies1() - result1(flower)) * flower.getSepal_Length();
        wSl2 += mi *(flower.getSpecies2() - result2(flower)) * flower.getSepal_Length();
        wSw1 += mi *(flower.getSpecies1() - result1(flower)) * flower.getSepal_Width();
        wSw2 += mi *(flower.getSpecies2() - result2(flower)) * flower.getSepal_Width();
        w11 += mi *(flower.getSpecies1() - result1(flower)) * 1;
        w12 += mi *(flower.getSpecies2() - result2(flower)) * 1;
    }

    void learning(Flowers flower){
        while(result1(flower) != flower.getSpecies1()){
            learn(flower);
        }
        while(result2(flower) != flower.getSpecies2()){
            learn(flower);
        }
        species = speciesRes(flower);
    }

    void check(Flowers flower){
        while(!species.equals(flower.getSpecies()))
            learning(flower);
        System.out.println(species);
    }

    private String speciesRes(Flowers flower){
        if(result1(flower) == 1 && result2(flower) == 1)
            species= "\"setosa\"";
        else if(result1(flower) == 1 && result2(flower) == 0)
            species="\"versicolor\"";
        else if(result1(flower) == 0 && result2(flower) == 1)
            species="\"virginica\"";
        else
            species="\"unknown\"";

        return species;
    }
}