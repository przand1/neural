/*
  Andrzejewski Przemko
  Wprowadzenie do teorii sieci neuronowych cw.3
  java
*/
import java.io.*;
import java.util.Arrays;

public class AssociationModel {

  private static void tableDisplay5x5(double[] arr) {
    for (int i = 0;i < 5; i++) {
      for (int j = 0;j < 5; j++) {
        System.out.print(arr[i*5+j] == 1 ? '*' : ' ');
      }
      System.out.println();
    }
  }

  private static double sgn(double x) {
    return x >= 0 ? 1.0 : -1.0;
  }

  private static double[] SGN(double[] X) {
    double[] XX = new double[X.length];
    for (int i = 0;i < X.length ;i++ ) {
      XX[i] = sgn(X[i]);
    }
    return XX;
  }

  private static double[] F(double[][] W, double[] U) {
    double[] temp = new double[25];
    for (int i=0;i<25;i++ ) {
      temp[i] = 0.0;
      for (int j=0;j<25;j++ ) {
        temp[i] += (W[i][j] * U[j]);
      }
    }
    return SGN(temp);
  }

  public static void main(String[] args) {
    double[] Z0 = new double[]{-1.0,-1.0,-1.0,-1.0,-1.0,
                               -1.0, 1.0, 1.0, 1.0,-1.0,
                               -1.0, 1.0,-1.0, 1.0,-1.0,
                               -1.0, 1.0, 1.0, 1.0,-1.0,
                               -1.0,-1.0,-1.0,-1.0,-1.0};
    double[] Z1 = new double[]{-1.0,-1.0,-1.0,-1.0,-1.0,
                               -1.0, 1.0, 1.0,-1.0,-1.0,
                               -1.0,-1.0, 1.0,-1.0,-1.0,
                               -1.0,-1.0, 1.0,-1.0,-1.0,
                               -1.0,-1.0,-1.0,-1.0,-1.0};
    double[][] W = new double[25][25];
    for (int i = 0;i < 25; i++) {
      for (int j = 0;j < 25; j++) {
        W[i][j] = (Z0[i]*Z0[j] + Z1[i]*Z1[j])/25;
      }
    }
    double[] Z0p = new double[]{-1.0, 1.0, 1.0, 1.0,-1.0,
                               -1.0, 1.0,-1.0, 1.0,-1.0,
                               -1.0, 1.0,-1.0, 1.0,-1.0,
                               -1.0, 1.0, 1.0, 1.0,-1.0,
                               -1.0,-1.0,-1.0,-1.0,-1.0};
    double[] Z1p = new double[]{-1.0,-1.0, 1.0,-1.0,-1.0,
                               -1.0,-1.0, 1.0,-1.0,-1.0,
                               -1.0,-1.0, 1.0,-1.0,-1.0,
                               -1.0,-1.0, 1.0,-1.0,-1.0,
                               -1.0,-1.0, 1.0,-1.0,-1.0};

    System.out.println("Obraz Z0:");
    tableDisplay5x5(Z0);
    System.out.println("Obraz Z1:");
    tableDisplay5x5(Z1);
    System.out.println("Obraz F(W,Z0)");
    tableDisplay5x5(F(W,Z0));
    System.out.println("Obraz F(W,Z1)");
    tableDisplay5x5(F(W,Z1));
    System.out.println("Obraz Z0p:");
    tableDisplay5x5(Z0p);
    System.out.println("Obraz Z1p:");
    tableDisplay5x5(Z1p);
    System.out.println("Obraz F(W,Z0p)");
    tableDisplay5x5(F(W,Z0p));
    System.out.println("Obraz F(W,Z1p)");
    tableDisplay5x5(F(W,Z1p));
  }
}
