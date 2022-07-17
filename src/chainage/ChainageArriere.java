package chainage;

import java.util.ArrayList;

public class ChainageArriere{
    public static Boolean solve(ArrayList<String> bf, Br bregle, ArrayList<String> f){
        Boolean res;
        if(f.size()==0){

            res = true;
        }else{
            System.out.println("Fait a verifier : " +  f.get(f.size()-1));
            String firstFait =  f.get(f.size()-1);
            if(demBut(bf, bregle, firstFait)){
                System.out.println("{" + firstFait + "} est verifie");
                bf.add(firstFait);
                f.remove(firstFait);
                res = solve(bf, bregle, f);
            }else{
                res = false;
                


            }
        }
        return res;
    }

    public static Boolean demBut(ArrayList<String> bf, Br bregle,String but){
        if(bf.contains(but)){
            return true;
        }else{

            boolean res =false ;
            while(bregle.countRegleChainageArriere(but) > 0  && !res){
                try {
                    Regle r = bregle.getRegleChainageArriere(but);
                    r.deactivate();


                    System.out.println("Premises a verifier : " +  r.premiss);
                    
                    res = solve(bf, bregle, r.premiss);


				} catch (Exception e) {
					e.printStackTrace();
				}
            }
            return res;
        }
    }
}