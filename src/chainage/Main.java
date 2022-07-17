package chainage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static ArrayList<String> bf = new ArrayList<String>();

    public static ArrayList<String> bf2 = new ArrayList<String>();

    public static void main(String[] args) throws Exception {

        String f = new String();
        ArrayList<String> fVal = new ArrayList<String>();
        Br bRegle = new Br();
        readFromFile( fVal,  bf,  bRegle );
        f+=fVal.get(0);
        System.out.println(bf.toString());
        System.out.println(bRegle.toString());
        System.out.println("Chainage Avant: -------------------\n");
        ChainageAvant.solve(bf,bRegle,f);
        System.out.println("--------------------------------------\n--------------------------------------");
        System.out.println("Chainage Arriere: --------------------\n");
        System.out.println("Base des faits ---> " + bf2.toString() +"\n");
        bRegle.init();
        System.out.println(ChainageArriere.solve(bf2, bRegle, fVal));
        System.out.println( ChainageArriere.solve(bf2, bRegle, fVal)? "La regle " + f + " est etabli": "La regle " + f + " n'est pas etabli" );
        System.out.println("Base des faits apres l'application du chainage arriere: \n" + bf2.toString() +"\n");
        

    }

    public static void readFromFile(ArrayList<String> f, ArrayList<String> bf, Br bRegle){
        BufferedReader reader;
        
        try {
            reader = new BufferedReader(new FileReader("fichier/input.txt"));
            String line = reader.readLine();
            f.add(line.trim());

            line = reader.readLine();
            bf.addAll(Arrays.asList(line.split(",")));
            bf2.addAll(Arrays.asList(line.split(",")));
            line= reader.readLine();
            Regle r ;
            String [] temp ;
            while(line !=null){
                temp = line.trim().split("\\s+");
                r = new Regle(temp[0].trim(), temp[1].trim());
                bRegle.addRegle(r);
                line= reader.readLine();  

            }
            reader.close();
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}