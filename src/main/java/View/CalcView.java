package View;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class CalcView extends JFrame {
    private JTextField tf1 = new JTextField();
    private JTextField tf2 = new JTextField();

    private JLabel firstPoly = new JLabel("First polynomial :");
    private JLabel secondPoly = new JLabel("Second polynomial:");
    private JLabel result = new JLabel("Result: ");
    private JTextField result2 = new JTextField();

   private JButton multy = new JButton("Multiplicate");
  private  JButton divide = new JButton("Divide");
 private   JButton add = new JButton("Add");
 private   JButton substract = new JButton("Substract");
  private  JButton integrate = new JButton("Integrate");
  private  JButton derivate = new JButton("Derivate");


  private  Font f1 = new Font("Times New Roman", Font.ITALIC, 17);
   private Font f2 = new Font("Times New Roman", Font.BOLD, 20);//pt butoane


    public CalcView() {
        getContentPane().setBackground(Color.lightGray);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(200, 200, 800, 400);
        this.getContentPane().setLayout(null);


        firstPoly.setBounds(50, 20, 150, 30);
        firstPoly.setFont(f1);
        getContentPane().add(firstPoly);

        tf1.setBounds(200, 20, 400, 30);
        tf1.setFont(f1);
        getContentPane().add(tf1);

        secondPoly.setBounds(50, 70, 150, 30);
        secondPoly.setFont(f1);
        getContentPane().add(secondPoly);

        tf2.setBounds(200, 70, 400, 30);
        tf2.setFont(f1);
        getContentPane().add(tf2);


        add.setFont(f2);
        add.setBounds(150, 130, 180, 30);
        getContentPane().add(add);

        substract.setFont(f2);
        substract.setBounds(150, 170, 180, 30);
        getContentPane().add(substract);

        divide.setFont(f2);
        divide.setBounds(350, 130, 180, 30);
        getContentPane().add(divide);

        multy.setFont(f2);
        multy.setBounds(150, 210, 180, 30);
        getContentPane().add(multy);

        integrate.setFont(f2);
        integrate.setBounds(350, 170, 180, 30);
        getContentPane().add(integrate);

        derivate.setFont(f2);
        derivate.setBounds(350, 210, 180, 30);
        getContentPane().add(derivate);

        result.setFont(f1);
        result.setBounds(50, 280, 90, 30);
        getContentPane().add(result);

        result2.setFont(f1);
        result2.setBounds(120, 280, 400, 30);
        getContentPane().add(result2);


        this.setVisible(true);
    }

    //setter getter
    public String getResult() {return result2.getText();}
    public void setResult(String result) {result2.setText(result);}
    public void setFirstPoly(String firstPoly) {tf1.setText(firstPoly);}
    public String getFirstPoly() {return tf1.getText();}
    public void setSecondPoly(String secondPoly) {tf2.setText(secondPoly);}
    public String getSecondPoly() {return tf2.getText();}

    //action listeners
    public void addAddButtonActionListener(ActionListener actionListener) {add.addActionListener(actionListener);}
    public void addSubstractActionListener(ActionListener actionlistener) {substract.addActionListener(actionlistener);}
    public void addMultyActionListener(ActionListener actionListener) {multy.addActionListener(actionListener);}
    public void addDivideActionListener(ActionListener actionListener){divide.addActionListener(actionListener);}
    public void addIntegrateActionListener(ActionListener actionListener){integrate.addActionListener(actionListener);}
    public void addDerivateActionListener(ActionListener actionListener){derivate.addActionListener(actionListener);}






}
