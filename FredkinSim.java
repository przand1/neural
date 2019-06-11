import java.util.Arrays;

public class FredkinSim {

  // a ----o----------->
  //       |
  // b  --\|/---------->
  // c  --/ \---o------>
  //            |
  // d  -------\|/------> out1
  // e  -------/ \------>
  private static int out1(int[] input) {
    int a = input[0];
    int b = input[1];
    int c = input[2];
    int d = input[3];
    int e = input[4];
    switch(a) {
      case 0:
        switch(c) {
          case 0: return d;
          case 1: return e;
        }
      case 1:
        switch(b) {
          case 0: return d;
          case 1: return e;
        }
      default: return -1;
    }
  }

  // a -----o------------->
  //        |
  // b  --\ | /------o---->
  //       \|/       |
  //       / \       |
  // c  --/  \------\|/---> out2
  //                 |
  // d  ------------/ \--->
  private static int out2(int[] input) {
    int a = input[0];
    int b = input[1];
    int c = input[2];
    int d = input[3];
    switch(a) {
      case 0:
        switch(b) {
          case 0: return c;
          case 1: return d;
        }
      case 1:
        switch(c) {
          case 0: return b;
          case 1: return d;
        }
      default: return -1;
    }
  }

  public static void setup1() {
    int[] output = new int[4];
    int[] params = new int[5];
    for (int i=0;i <= 3 ;i++ ) {
      for (int j=0;j <= 3 ;j++ ) {
        for (int k=0;k <= 3 ;k++ ) {
          for (int l=0;l <= 3 ;l++ ) {
            for (int m=0;m <= 3 ;m++ ) {
              int outIter = 0;
              for (int n=0;n < 2 ;n++ ) {
                for (int o=0;o < 2 ;o++ ) {
                  switch(i) {
                    case 0: params[0] = 0;break;
                    case 1: params[0] = 1;break;
                    case 2: params[0] = n;break;
                    case 3: params[0] = o;
                  }
                  switch(j) {
                    case 0: params[1] = 0;break;
                    case 1: params[1] = 1;break;
                    case 2: params[1] = n;break;
                    case 3: params[1] = o;
                  }
                  switch(k) {
                    case 0: params[2] = 0;break;
                    case 1: params[2] = 1;break;
                    case 2: params[2] = n;break;
                    case 3: params[2] = o;
                  }
                  switch(l) {
                    case 0: params[3] = 0;break;
                    case 1: params[3] = 1;break;
                    case 2: params[3] = n;break;
                    case 3: params[3] = o;
                  }
                  switch(m) {
                    case 0: params[4] = 0;break;
                    case 1: params[4] = 1;break;
                    case 2: params[4] = n;break;
                    case 3: params[4] = o;
                  }
                  output[outIter] = out1(params);
                  outIter++;
                }
              }
              System.out.println("Input: "+i+j+k+l+m+"\tOutput: "+Arrays.toString(output));
            }
          }
        }
      }
    }
  }
  public static void setup2() {
    int[] output = new int[4];
    int[] params = new int[4];
    for (int i=0;i <= 3 ;i++ ) {
      for (int j=0;j <= 3 ;j++ ) {
        for (int k=0;k <= 3 ;k++ ) {
          for (int l=0;l <= 3 ;l++ ) {
            int outIter = 0;
            for (int n=0;n < 2 ;n++ ) {
              for (int o=0;o < 2 ;o++ ) {
                switch(i) {
                  case 0: params[0] = 0;break;
                  case 1: params[0] = 1;break;
                  case 2: params[0] = n;break;
                  case 3: params[0] = o;
                }
                switch(j) {
                  case 0: params[1] = 0;break;
                  case 1: params[1] = 1;break;
                  case 2: params[1] = n;break;
                  case 3: params[1] = o;
                }
                switch(k) {
                  case 0: params[2] = 0;break;
                  case 1: params[2] = 1;break;
                  case 2: params[2] = n;break;
                  case 3: params[2] = o;
                }
                switch(l) {
                  case 0: params[3] = 0;break;
                  case 1: params[3] = 1;break;
                  case 2: params[3] = n;break;
                  case 3: params[3] = o;
                }
                output[outIter] = out2(params);
                outIter++;
              }
            }
            if(output[0]==0&&output[1]==1&&output[2]==1&&output[3]==0)// XOR
            // if(output[0]==0&&output[1]==0&&output[2]==0&&output[3]==1)// AND
              System.out.println("Input: "+i+j+k+l+"\tOutput: "+Arrays.toString(output));
          }
        }
      }
    }
  }
  public static void main(String[] args) {
    setup2();
  }
}
