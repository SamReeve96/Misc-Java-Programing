/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoursework2017;

/**
 *
 * @author Samuel
 */
public abstract class Pipe {

    private int plasticGrade, quantityOfPipes, colourPrint;
    private boolean chemicalResistance, innerInsulation, outerReinforcement;
    private double length, diameter, radius, volume, pipeCost;
    
//Basic constructor
    public Pipe(){
    }
    
    //Complex constructor
    public Pipe(int pG, int qOP, boolean cR, double Length, double Diameter){
        plasticGrade = pG;
        quantityOfPipes = qOP;
        chemicalResistance = cR;
        length = Length;
        diameter = Diameter;
    }

    //GETTERS
    
    public int getPlasticGrade(){
        return plasticGrade;
    }
    
    public int getColourPrint(){
        return colourPrint;
    }
    
    public int getQuantityOfPipes(){
        return quantityOfPipes;
    }
    
    public boolean getInnerInsulation(){
        return innerInsulation;
    }

    public boolean getOuterReinforcement(){
        return outerReinforcement;
    }
    
    public boolean getChemicalResistance(){
        return chemicalResistance;
    }
    
    public double getLength(){
        return length;
    }
    
    public double getDiameter(){
        return diameter;
    }
    
    public double getRadius(){
        return radius;
    }
    
    public double getVolume(){
        return volume;
    }
    
    public double getPipeCost(){
        return pipeCost;
    }
    
    //SETTERS  
    public void setPlasticGrade(int pg){
        plasticGrade = pg;
    }

    public void setColourPrint(int cp){
        colourPrint = cp;
    }

    public void setQuantityOfPipes(int QoP){
        quantityOfPipes = QoP;
    }

    public void setInnerInsulation(boolean iI){
        innerInsulation = iI;
    }
        
    public void setOuterReinforcement(boolean oR){
        outerReinforcement = oR;
    }
    
    public void setChemicalResistance(boolean cR){
        chemicalResistance = cR;
    }
    
    public void setLength(double Length){
        length = Length;
    }
    
    public void setDiameter(double Diameter){
        diameter = Diameter;
    }
    
    public void setRadius(double Radius){
        radius = Radius;
    }
    
    public void setVolume(double Volume){
        volume = Volume;
    }
    
    public void setPipeCost(double pC){
        pipeCost = pC;
    }
    
    //Misc Methods
    
    public double metresToInches(double metres){
        double inches = 39.37 * metres;
        return inches;
    }
    
    public double calculateRadius(double diameter){
        radius = diameter/2;
        return radius;
    }
    
    public double calculateVolume(double length, double radius){
        //Pipe thickness is 10% of the radius
        double smallRad = radius * 0.9;
        // pi r^2
        double SmallArea = (Math.PI * (smallRad * smallRad));
        double FullArea = (Math.PI * (radius * radius));
        volume = (FullArea - SmallArea) * metresToInches(length);
        return volume;
    }
    
    public double calcBaseCost(){
        //calc radius and volume

        radius = calculateRadius(diameter);
        volume = calculateVolume(length, radius);
        
        System.out.println("Grade is: " + plasticGrade);
        
        double[] gradeCosts = {0.4,0.6,0.75,0.8,0.95};
        
        //calc base cost, lookup the grade in the array (-1 due to array index)
        double baseCost = (volume * gradeCosts[plasticGrade - 1] * getQuantityOfPipes());
        return baseCost;
    }
   
    public abstract void calcAddCost();
}
