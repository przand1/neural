import java.io.*;
import java.util.Arrays;

public class Perceptron {
  private static double[] weights = new double[26];
  private static double[][] U = {
    {
      0.0,0.0,0.0,0.0,0.0,
      0.0,1.0,1.0,0.0,0.0,
      0.0,0.0,1.0,0.0,0.0,
      0.0,0.0,1.0,0.0,0.0,
      0.0,0.0,1.0,0.0,0.0,1.0
    },
    {
      0.0,0.0,1.0,1.0,0.0,
      0.0,0.0,0.0,1.0,0.0,
      0.0,0.0,0.0,1.0,0.0,
      0.0,0.0,0.0,0.0,0.0,
      0.0,0.0,0.0,0.0,0.0,1.0
    },
    {
      0.0,0.0,0.0,0.0,0.0,
      1.0,1.0,0.0,0.0,0.0,
      0.0,1.0,0.0,0.0,0.0,
      0.0,1.0,0.0,0.0,0.0,
      0.0,1.0,0.0,0.0,0.0,1.0
    },
    {
      0.0,0.0,0.0,0.0,0.0,
      0.0,1.0,1.0,1.0,0.0,
      0.0,1.0,0.0,1.0,0.0,
      0.0,1.0,1.0,1.0,0.0,
      0.0,0.0,0.0,0.0,0.0,1.0
    },
    {
      0.0,0.0,0.0,0.0,0.0,
      0.0,0.0,0.0,0.0,0.0,
      1.0,1.0,1.0,0.0,0.0,
      1.0,0.0,1.0,0.0,0.0,
      1.0,1.0,1.0,0.0,0.0,1.0
    }
  };
  private static void weightsInit() {
    for (int i=0;i<26;i++) weights[i] = 0.0;
  }
  private static void weightsCompute(double c,double z,double y,int t) {
    for (int i=0;i<26;i++) weights[i] = weights[i] + c*(z-y) * U[t%5][i];
  }
  private static double f(double x) { return x >= 0 ? 1.0 : 0.0; }
  private static double yCompute(int t) {
    double temp = 0.0;
    for (int i=0;i<26;i++) temp += (weights[i] * U[t%5][i]);
    return f(temp);
  }
  private static double zCompute(int t) { return t%5 <= 2 ? 1.0 : 0.0; }

  public static void main(String[] args) {
    int t,counter;
    double c,z,y;
    t = 1;
    c = 1.0;
    counter = 0;
    weightsInit();

    while(counter != 5) {
      y = yCompute(t);
      z = zCompute(t);
      weightsCompute(c,z,y,t);
      counter = z==y ? counter+1 : 0;
      t++;
    }

    System.out.println("t = "+t+'\n'+"Weights: "+Arrays.toString(weights));
  }
}
