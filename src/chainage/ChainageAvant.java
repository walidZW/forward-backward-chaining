package chainage;

import java.util.ArrayList;

public class ChainageAvant{
    public static void solve(ArrayList<String> bf,Br bRegle,String f){
        ArrayList<Regle> treeRegle = new ArrayList<Regle>();
        try {
            while (!bf.contains(f) && bRegle.countRegleApplicable(bf)>0) {
                Regle regAppl =  bRegle.getRegleApplicable(bf);
                regAppl.deactivate();
                System.out.println("la regle applicable est : \n"+regAppl.toString()+"\n");
                treeRegle.add(regAppl);
                bf.addAll(regAppl.action);
                System.out.println("BF pour cet iteration:  "+ bf.toString() + "\n");

            }
            if(bf.contains(f)){
                System.out.println( "La regle: " + f + "  est etabli");
                System.out.println("Les regles utilisees pour demontrer {" + f +"} :");
                for (Regle r : treeRegle) {
                    System.out.println(r);
                }

                
            }else{
                System.out.println( "La regle: " + f + "  n'est pas etabli");

            }
        } catch (Exception e) {
                System.out.println(e);
        }
        

       
    }
}


