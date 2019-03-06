/*
  Andrzejewski Przemko
  Wprowadzenie do teorii sieci neuronowych cw.1
  java
*/
import java.io.*;

public class Main {
  public static void main(String[] args) {

    double[] andWeights = {0.3,0.3,-0.5};
    double[] nandWeights = {-0.3,-0.3,0.5};
    double[] notWeights = {-0.5,0.3};
    double[] orWeights = {0.5,0.5,-0.3};

    Neuron AND = new Neuron(andWeights);
    Neuron NAND = new Neuron(nandWeights);
    Neuron NOT = new Neuron(notWeights);
    Neuron OR = new Neuron(orWeights);

    double[] arg00 = {0,0,1};
    double[] arg01 = {0,1,1};
    double[] arg10 = {1,0,1};
    double[] arg11 = {1,1,1};
    double[] arg0 = {0,1};
    double[] arg1 = {1,1};

    System.out.println("AND(0,0) = "+AND.computeY(arg00));
    System.out.println("AND(0,1) = "+AND.computeY(arg01));
    System.out.println("AND(1,0) = "+AND.computeY(arg10));
    System.out.println("AND(1,1) = "+AND.computeY(arg11));
    System.out.println();
    System.out.println("NAND(0,0) = "+NAND.computeY(arg00));
    System.out.println("NAND(0,1) = "+NAND.computeY(arg01));
    System.out.println("NAND(1,0) = "+NAND.computeY(arg10));
    System.out.println("NAND(1,1) = "+NAND.computeY(arg11));
    System.out.println();
    System.out.println("OR(0,0) = "+OR.computeY(arg00));
    System.out.println("OR(0,1) = "+OR.computeY(arg01));
    System.out.println("OR(1,0) = "+OR.computeY(arg10));
    System.out.println("OR(1,1) = "+OR.computeY(arg11));
    System.out.println();
    System.out.println("NOT(0) = "+NOT.computeY(arg0));
    System.out.println("NOT(1) = "+NOT.computeY(arg1));

  }
}
