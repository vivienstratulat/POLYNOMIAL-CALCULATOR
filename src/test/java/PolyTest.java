import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Model.CalcModel;
import Model.Monom;
import Model.Polinom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PolyTest {
    Polinom p1=new Polinom();
    Polinom p2=new Polinom();
    CalcModel myModel=new CalcModel();

    @BeforeEach
    public void setUp(){
        // myModel=new Model.CalcModel();

        Monom m1 = new Monom(3, -2);
        Monom m3 = new Monom(1, 3);
        Monom m4 = new Monom(0, 5);

        p1.getPoly().add(m1);
        p1.getPoly().add(m3);
        p1.getPoly().add(m4);

        System.out.println("P1:");
        p1.printPoly();

        Monom mm1=new Monom(1,1);
        Monom mm2=new Monom(0,2);

        p2.getPoly().add(mm1);
        p2.getPoly().add(mm2);

        System.out.println("P2:");
        p2.printPoly();

    }

    @Test
    public void testAdd() {
        myModel.add(p1, p2);
        System.out.println("Suma: ");
        myModel.getSum().printPoly();
        assertEquals(myModel.getSum().toStringg(), "-2.0x^3+4.0x+7.0");
    }

    @Test
    public void testSubstract() {
        myModel.substract(p1, p2);
        System.out.println("Diferenta:");
        myModel.getDifference().printPoly();
        assertEquals(myModel.getDifference().toStringg(), "-2.0x^3+2.0x+3.0");
    }

    @Test
    public void testIntegrate(){
        myModel.integrate(p1);
        System.out.println("Integrare: ");
        myModel.getIntegrated().printPoly();
        assertEquals(myModel.getIntegrated().toStringg(),"-0.5x^4+1.5x^2+5.0x");
    }

    @Test
    public void testDerivation() {
        myModel.derivation(p1);
        System.out.println("Derivare:");
        myModel.getDerivated().printPoly();
        assertEquals(myModel.getDerivated().toStringg(),"-6.0x^2+3.0");
    }

    @Test
    public void testMulty() {
        myModel.multiplication(p1, p2);
        System.out.println("Inmultire");
        myModel.getProduct().printPoly();
        assertEquals(myModel.getProduct().toStringg(),"-2.0x^4-4.0x^3+3.0x^2+11.0x+10.0");
    }
}

