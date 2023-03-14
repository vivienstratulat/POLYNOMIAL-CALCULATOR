package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Polinom {
    private ArrayList<Monom> poly = new ArrayList<>();

    public ArrayList<Monom> getPoly() {
        return this.poly;
    }

    public void printPoly() {
        for (Monom mon : poly) {
            mon.printMonom();
        }
        System.out.println(" ");
    }
    public String toStringg(){
        String polynomial="";
        for(Monom mon: poly)
        {
            if(mon.getCoefficient()==0)
                continue;
            else if(mon.getCoefficient()>0)
            {
                System.out.println(mon.getCoefficient());
                polynomial+="+"+mon.toString();
            }
            else
            {
                polynomial+=mon.toString();
            }
        }
        if(polynomial.equals("")){
            return "0";
        }
        else if(polynomial.charAt(0)=='+'){
            String newPoly=polynomial.substring(1,polynomial.length());
            return  newPoly;
        }
        return polynomial;
    }

    public Monom getDegree(int degree) {
        Monom resMonom = null;
        for (Monom mon : poly) {
            if (mon.getDegree() == degree)
                resMonom = mon;
        }
        return resMonom;
    }
    public void sortPoly(){
        Collections.sort(poly, new Comparator<Monom>() {
            @Override
            public int compare(Monom o1, Monom o2) {
                if(o1.getDegree()>o2.getDegree())
                    return -1;
                else if(o1.getDegree()==o2.getDegree())
                return 0;
                else return 1;
            }
        });
    }
}
