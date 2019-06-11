/*
  Andrzejewski Przemko
  Wprowadzenie do teorii sieci neuronowych cw.8
  java
*/
import java.util.Random;

public class Faktoryzacja {

  private static int GCD(int x,int y){
    return (x%y == 0) ? y : GCD(y,x%y);
  }

  private static int DL(int a, int n) {
    int r = 1;
  	while (Math.pow(a, r) % n != 1 && r <10) {
  		r++;
  	}
  	return r==10 ? -1 : r;
  }

  private static void f(int n) {
    int a = 1 + Math.abs(new Random().nextInt(n-1));
    int gcd = GCD(n,a);
    if (gcd>1) {
      System.out.println(n+" : "+gcd);
    } else if (gcd==1){
      int r = DL(a,n);
      if (r%2 == 0) {
        int x = GCD(n,(int)Math.pow(a,r/2) + 1);
        if (x>1) System.out.println(n+" : "+x);
        else {
          x = GCD(n,(int)Math.pow(a,r/2) - 1);
          if (x>1) System.out.println(n+" : "+x);
          else f(n);
        }
      } else {
        f(n);
      }
    }
  }

  public static void main(String[] args) {
      int N[] = new int[]{12,91,143,1737,1859,13843,988027};
      for (int n : N ) {
        f(n);
      }
  }
}
