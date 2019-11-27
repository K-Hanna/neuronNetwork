import java.util.*;

public class Main {

    public static void main(String[] args) {

        Network network = new Network();

        List<Flowers> listFlowers = Flowers.generate("iristrain.csv");

        for (Flowers flowers : listFlowers){
            network.learning(flowers);
        }

        List<Flowers> flowerTest = Flowers.generate("iristest.csv");

        for (Flowers flower : flowerTest){
            network.check(flower);
        }
    }
}