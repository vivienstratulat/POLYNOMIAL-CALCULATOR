package Controller;

import Model.CalcModel;
import Model.Monom;
import Model.Polinom;
import View.CalcView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController {
    private CalcView theView;
    private CalcModel theModel;
    private Polinom polynom1;
    private Polinom polynom2;

    public CalcController(CalcView theView, CalcModel theModel){
        this.theModel=theModel;
        this.theView=theView;
        this.theView.addAddButtonActionListener(new AddListener());
        this.theView.addSubstractActionListener(new SubstractListener());
        this.theView.addMultyActionListener(new MultyListener());
        this.theView.addIntegrateActionListener(new IntegrateListener());
        this.theView.addDerivateActionListener(new DerivateListener());
    }

    public Polinom getInput(String input){
        Polinom poly=new Polinom();
        String [] splitString=input.split("(?=[+-])");
        poly=createPoly(splitString);
        return poly;
    }
    public Polinom createPoly(String[] splitString){
        Polinom createdPoly=new Polinom();
        for(int i=0;i< splitString.length;i++){
            String [] split=splitString[i].split("[x^]");
            if(split.length==3){
                String CoefSign=split[0];
                switch(CoefSign){
                    case "-":
                        Monom mon1=new Monom(Integer.parseInt(split[2]),-1);
                        createdPoly.getPoly().add(mon1);
                        break;

                    case "+":

                    case "":
                        Monom mon2=new Monom(Integer.parseInt(split[2]),1);
                        createdPoly.getPoly().add(mon2);
                        break;

                    default:
                        Monom mon4=new Monom(Integer.parseInt(split[2]),Double.parseDouble(split[0]));
                        createdPoly.getPoly().add(mon4);
                        break;
                }
            }
            else if(split.length==1){
                if(splitString[i].contains("x")==false){
                    Monom mon1=new Monom(0,Double.parseDouble(split[0]));
                    createdPoly.getPoly().add(mon1);
                }
                else if(splitString[i].contains("x")==true){
                    String coefSignn=split[0];
                    switch (coefSignn){
                        case "-":
                            Monom mon2=new Monom(1,-1);
                            createdPoly.getPoly().add(mon2);
                            break;

                        case "+":
                            Monom mon3=new Monom(1,1);
                            createdPoly.getPoly().add(mon3);
                            break;

                        default:
                            Monom mon4=new Monom(1,Double.parseDouble(split[0]));
                            createdPoly.getPoly().add(mon4);
                            break;
                    }
                }
            }
            else if (split.length==0) //termenul e doar x
            {
                Monom mon=new Monom(1,1);
                createdPoly.getPoly().add(mon);
            }

        }
        return createdPoly;
    }

     class AddListener implements ActionListener {

         @Override
         public void actionPerformed(ActionEvent e) {
             String fpoly1 = theView.getFirstPoly();
             String fpoly2 = theView.getSecondPoly();
             if (fpoly1.isEmpty() || fpoly2.isEmpty())
                 JOptionPane.showMessageDialog(null,"Please enter both polynomials");
             else {
                 polynom1 = getInput(fpoly1);
                 polynom2 = getInput(fpoly2);
                 Polinom sum;
                  theModel.add(polynom1, polynom2);
                  sum= theModel.getSum();
                 theView.setResult(sum.toStringg());

                 sum.printPoly();
             }
         }
     }
     class SubstractListener implements  ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
          String fpoly1=theView.getFirstPoly();
          String fpoly2=theView.getSecondPoly();
          if (fpoly1.isEmpty() || fpoly2.isEmpty())
              JOptionPane.showMessageDialog(null,"Please enter both polynomials");
          else {
              polynom1 = getInput(fpoly1);
              polynom2 = getInput(fpoly2);
              Polinom difference;
              theModel.substract(polynom1, polynom2);
              difference= theModel.getDifference();
              theView.setResult(difference.toStringg());
              difference.printPoly();
          }
      }
  }
     class MultyListener implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
          String fpoly1=theView.getFirstPoly();
          String fpoly2=theView.getSecondPoly();
          if (fpoly1.isEmpty() || fpoly2.isEmpty())
              JOptionPane.showMessageDialog(null,"Please enter both polynomials");
          else {
              polynom1 = getInput(fpoly1);
              polynom2 = getInput(fpoly2);
              Polinom product = new Polinom();
              //product = theModel.multiplication(polynom1, polynom2);
              theModel.multiplication(polynom1,polynom2);
              product=theModel.getProduct();
              theView.setResult(product.toStringg());
              product.printPoly();
          }
      }
  }
     class IntegrateListener implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
          String fpoly1=theView.getFirstPoly();
          if(fpoly1.isEmpty())
              JOptionPane.showMessageDialog(null,"Please enter the polynomial");
          else{
          polynom1=getInput(fpoly1);
         Polinom integrated;
         theModel.integrate(polynom1);
         // integrated= theModel.integrate(polynom1);
              integrated= theModel.getIntegrated();
          theView.setResult(integrated.toStringg());
          integrated.printPoly();}
      }
  }
     class DerivateListener implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
          String fpoly1=theView.getFirstPoly();
          if(fpoly1.isEmpty())
              JOptionPane.showMessageDialog(null,"Please enter the polynomial");
          else{
          polynom1=getInput(fpoly1);
          Polinom derivated;
          theModel.derivation(polynom1);
          derivated= theModel.getDerivated();
          //derivated=theModel.derivation(polynom1);
          theView.setResult(derivated.toStringg());
          derivated.printPoly();}
      }
  }

    public Polinom getPolynom1() {return polynom1;}
    public Polinom getPolynom2() {return polynom2;}





}
