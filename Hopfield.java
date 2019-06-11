/*
  Andrzejewski Przemko
  Wprowadzenie do teorii sieci neuronowych cw.7
  java
*/
import java.util.Random;
import java.util.Scanner;

public class Hopfield {

  private static Random rand = new Random();
  private static Scanner scn = new Scanner(System.in);

  private static void tableDisplay5x5(double[] arr) {
    for (int i = 0;i < 5; i++) {
      for (int j = 0;j < 5; j++) {
        System.out.print(arr[i*5+j] == 1 ? '*' : ' ');
      }
      System.out.println();
    }
  }

  private static double[] randVector() {
    double[] v = new double[25];
    for (int i=0;i<25 ;i++ ) {
      v[i]=rand.nextInt(2);
    }
    return v;
  }

  private static double[][] CVector(double[] Xs) {
    double[][] C = new double[25][25];
    for (int i=0;i <25 ;i++ ) {
      for (int j=0;j <25 ;j++ ) {
        C[i][j] = i==j ? 0 : (Xs[i]-0.5)*(Xs[j]-0.5);
      }
    }
    return C;
  }

  private static double theta(double[] C) {
    double theta = 0.0;
    for (double d : C ) {
      theta += d;
    }
    return theta;
  }

  private static double[] newVector(double[][] C, double[] X) {
    double[] newX = new double[25];
    double uit = 0.0;
    for (int i=0; i<25; i++) {
      uit = 0.0;
      for (int j=0; j<25; j++) {
        uit += 2*C[i][j] * X[j];
      }
      uit -= theta(C[i]);

      if (uit>0) {
        newX[i] = 1.0;
      } else if (uit == 0) {
        newX[i] = X[i];
      } else {
        newX[i] = 0.0;
      }
    }
    return newX;
  }

  public static void main(String[] args) {

    double[] X = randVector();
    double[] Xs = new double[]{0,0,0,0,0,
                               0,1,1,0,0,
                               0,0,1,0,0,
                               0,0,1,0,0,
                               0,0,1,0,0};
    double[][] C = CVector(Xs);
    tableDisplay5x5(X);
    while(scn.nextLine().equals("")) {
      X = newVector(C,X);
      tableDisplay5x5(X);
    }
  }
}
