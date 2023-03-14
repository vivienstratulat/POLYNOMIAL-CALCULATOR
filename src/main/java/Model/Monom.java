package Model;

public class Monom {
    private int degree;
    private double coefficient;

    public Monom(int degree,double coefficient){
        this.coefficient=coefficient;
        this.degree=degree;
    }

    public int getDegree() {return degree;}
    public void setDegree(int degree) {this.degree = degree;}
    public double getCoefficient() {return coefficient;}
    public void setCoefficient(double coefficient) {this.coefficient = coefficient;}
    public void printMonom(){
        if(coefficient>0)
            System.out.println("+ "+coefficient+"x^"+degree+" ");
        else if(coefficient<0)
            System.out.println(coefficient+"x^"+degree+" ");
        else
            System.out.println("+"+0+" ");
    }
    public String toString(){
        String mon;
        if(degree==0) {
            mon = String.valueOf(coefficient);
            return mon;
        }else if(degree==1)
        {
            if(coefficient==1){
                mon="x";
                return mon;
            }
            else if(coefficient==-1){
                mon="-x";
                return mon;
            }
            else{
                mon=String.valueOf(coefficient)+"x";
                return mon;
            }
        }
        else{
            if(coefficient==1){
                mon="x"+"^"+String.valueOf(degree);
                return mon;
            }
            else if(coefficient==-1){
                mon="-x"+"^"+String.valueOf(degree);
                return mon;
            }
            else{
                mon=String.valueOf(coefficient)+"x"+"^"+String.valueOf(degree);
                return mon;
            }
        }



    }



}