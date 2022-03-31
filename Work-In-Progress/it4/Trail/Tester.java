import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        //ArrayList<ArrayList<Integer>>   vs ArrayList<int[]> .contains and .remove
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<int[]> aa = new ArrayList<>();

        for (int x =0; x<3; x++){
            ArrayList<Integer> l = new ArrayList<>();
            l.add(x);
            al.add(l);

            int [] p= {x};
            aa.add(p);
        }
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        if (al.contains(l)){
            System.out.println("Its in ArrayList<ArrayList<Integer>>");
        }
        int [] p = {1};
        if (aa.contains(p)){ System.out.println("Also contain :{");}

        System.out.println(""+al.size());
        al.remove(l);
        System.out.println(""+al.size());
        System.out.println("Next:");
        System.out.println(""+aa.size());
        aa.remove(p);
        System.out.println(""+aa.size());



        

    }

    public Tester(){

    }
}
