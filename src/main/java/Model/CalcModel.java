package Model;

public class CalcModel {
     private Polinom sum;
     private Polinom difference;
      private  Polinom divided;
     private Polinom product;
     private Polinom integrated;
     private Polinom derivated;

    public Polinom replicatePolinom(Polinom poly) {
        Polinom replicaPoly = new Polinom();

        if(poly!= null){
       for(Monom mon: poly.getPoly()) {
            int degree = mon.getDegree();
            double coefficient = mon.getCoefficient();

            Monom replicaMonom = new Monom(degree, coefficient);
            replicaPoly.getPoly().add(replicaMonom);
        }}
        return replicaPoly;
    }

    //add
    public void add(Polinom poly1, Polinom poly2) {
        sum = replicatePolinom(poly1);
        if(poly2!= null){
        for(Monom mon:poly2.getPoly()) {
            int crtDegree = mon.getDegree();
            double crtCoefficient = mon.getCoefficient();

            Monom searchedMonom = sum.getDegree(crtDegree);
            if (searchedMonom == null)//nu avem termeni cu acest grad
            {
                sum.getPoly().add(mon);
            } else {
                double oldCoefficient = searchedMonom.getCoefficient();
                searchedMonom.setCoefficient(crtCoefficient + oldCoefficient);
            }
        }}
            sum.sortPoly();
    }

    //scadere
    public void substract(Polinom poly1,Polinom poly2){
        difference=replicatePolinom(poly1);
        if(poly2!= null){
       for(Monom mon:poly2.getPoly()){

            int crtDegree=mon.getDegree();
            double crtCoefficient=mon.getCoefficient();

            Monom searchedMonom=difference.getDegree(crtDegree);

            if(searchedMonom==null)
            {
                crtCoefficient=-crtCoefficient;
                Monom mon2=new Monom(crtDegree,crtCoefficient);
                difference.getPoly().add(mon2);
            }
            else{
                double oldCoefficient=searchedMonom.getCoefficient();
                searchedMonom.setCoefficient(oldCoefficient-crtCoefficient);
            }
        }}
        difference.sortPoly();

    }

    //integrare
    public void integrate(Polinom poly){
        integrated=new Polinom();
        //integrated=this.replicatePolinom(poly);
        Polinom replica=replicatePolinom(poly);
        for(Monom mon:replica.getPoly()){
            int degree=mon.getDegree();
            double coefficient= mon.getCoefficient();
            mon.setDegree(degree+1);
            mon.setCoefficient(coefficient/(degree+1));
            integrated.getPoly().add(mon);
        }
        integrated.sortPoly();

    }

    //derivare
    public void derivation(Polinom poly){
         derivated=new Polinom();
       for(Monom mon: poly.getPoly())
       {
            int degree=mon.getDegree();
            double coefficient= mon.getCoefficient();
            mon.printMonom();
                mon.setCoefficient(coefficient * degree);
                degree=degree-1;
                mon.setDegree(degree);
                mon.printMonom();
            derivated.getPoly().add(mon);
        }
       derivated.sortPoly();
    }

    //inumltire
    public void multiplication(Polinom poly1,Polinom poly2){
      product=new Polinom();

       Polinom poly1r=replicatePolinom(poly1);
     Polinom  poly2r=replicatePolinom(poly2);
      if(poly1!=null){
      for(Monom mon:poly1r.getPoly())
      {
          int degree1=mon.getDegree();
         double coefficient1= mon.getCoefficient();

         for(Monom mon2:poly2r.getPoly()){

             int degree2=mon2.getDegree();
             double coefficient2=mon2.getCoefficient();

            int finalDegree=degree1+degree2;
            double finalCoefficient=coefficient1*coefficient2;

            Monom searchedMonom=product.getDegree(finalDegree);
            if(searchedMonom==null) //daca nu avem inca termeni de acest grad
            {
                Monom newMon=new Monom(finalDegree,finalCoefficient);
                product.getPoly().add(newMon);
            }
            else{ //cazul in care avem deja un termen cu acest grad, ii actualizam coeficientul
                double oldCoefficient=searchedMonom.getCoefficient();
                searchedMonom.setCoefficient(oldCoefficient+finalCoefficient);
            }
         }
      }}
      product.sortPoly();

    }

//TO DO IMPARTIRE

    public Polinom getSum() {
        return sum;
    }

    public Polinom getDifference() {
        return difference;
    }

    public Polinom getDivided() {
        return divided;
    }

    public Polinom getProduct() {
        return product;
    }

    public Polinom getIntegrated() {
        return integrated;
    }

    public Polinom getDerivated() {
        return derivated;
    }
}