import java.io.*;

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
    return x >= 0 ? 1 : -1;
  }

  private static double[] SGN(double X) {
    double XX = new double[X.length];
    for (int i = 0;i < X.length ;i++ ) {
      XX[i] = sgn(X[i]);
    }
    return XX;
  }

  private static double[] F(double[] W, double[] U) {
    return SGN(W*U);
  }

  public static void main(String[] args) {
    double[] Z0 = new double[]{-1,-1,-1,-1,-1,
                               -1, 1, 1, 1,-1,
                               -1, 1,-1, 1,-1,
                               -1, 1, 1, 1,-1,
                               -1,-1,-1,-1,-1};
    double[] Z1 = new double[]{-1,-1,-1,-1,-1,
                               -1, 1, 1,-1,-1,
                               -1,-1, 1,-1,-1,
                               -1,-1, 1,-1,-1,
                               -1,-1,-1,-1,-1};
    double[][] W = new double[25][25];
    for (int i = 0;i < 25; i++) {
      for (int j = 0;j < 25; j++) {
        W[i][j] = (Z0[i]*Z0[j] + Z1[i]*Z0[j])/25;
      }
    }
    // for (double[] d : W) {
    //   for (double dd : d) {
    //     System.out.print(dd+" ");
    //   }System.out.println();
    // }
  }
}
