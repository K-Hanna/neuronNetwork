import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Flowers {

    private String Sepal_Length, Sepal_Width, Petal_Length, Petal_Width, species;

    private Flowers(String sepal_Length, String sepal_Width, String petal_Length, String petal_Width, String species) {
        Sepal_Length = sepal_Length;
        Sepal_Width = sepal_Width;
        Petal_Length = petal_Length;
        Petal_Width = petal_Width;
        this.species = species;
    }

    double getSepal_Length() {
        return Double.parseDouble(Sepal_Length);
    }

    double getSepal_Width() {
        return Double.parseDouble(Sepal_Width);
    }

    double getPetal_Length() {
        return Double.parseDouble(Petal_Length);
    }

    double getPetal_Width() {
        return Double.parseDouble(Petal_Width);
    }

    public String getSpecies() {
        return species;
    }

    int getSpecies1() {
        int sp1 = 0;
        if(species.equals("\"setosa\"")|| species.equals("\"versicolor\""))
            sp1 = 1;
        return sp1;
    }

    int getSpecies2() {
        int sp2 = 0;
        if(species.equals("\"setosa\"")|| species.equals("\"virginica\""))
            sp2 = 1;
        return sp2;
    }

    static List generate(String path){
        List<Flowers> flowerList = new Vector<>();
        try{
            Scanner sc=new Scanner(new File(path));
            while(sc.hasNext()) {
                String[] elements = sc.next().split(",");
                flowerList.add(new Flowers(elements[1],elements[2],elements[3],elements[4], elements[5]));
            }
            sc.close();
        } catch(Exception e) {
            System.out.println("Brak pliku.");
        }
        return flowerList;
    }
}
