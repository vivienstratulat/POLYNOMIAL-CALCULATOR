package App;
import Model.CalcModel;
import View.CalcView;
import Controller.CalcController;


public class Calc {
    public static void main(String[] args) {


        CalcView theView = new CalcView();
        CalcModel theModel = new CalcModel();
     CalcController theController = new CalcController(theView, theModel);

}}
