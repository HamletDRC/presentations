// Generated from fizz-buzz.mirah
public class Fizz-buzz extends java.lang.Object {
  public static void main(java.lang.String[] argv) {
    int __xform_tmp_2 = 0;
    int __xform_tmp_3 = 0;
    int n = 0;
    boolean a = false;
    boolean b = false;
    boolean __xform_tmp_1 = false;
    __xform_tmp_2 = 1;
    __xform_tmp_3 = 100;
    label1:
    while ((__xform_tmp_2 <= __xform_tmp_3)) {
      n = __xform_tmp_2;
      label2:
       {
        if ((a = ((n % 3) == 0))) {
          java.io.PrintStream temp$3 = java.lang.System.out;
          temp$3.print("Fizz");
        }
        if ((b = ((n % 5) == 0))) {
          java.io.PrintStream temp$4 = java.lang.System.out;
          temp$4.print("Buzz");
        }
        boolean temp$5 = false;
        __xform_tmp_1 = a;
        temp$5 = __xform_tmp_1 ? (__xform_tmp_1) : (b);
        if (temp$5) {
        }
        else {
          java.io.PrintStream temp$6 = java.lang.System.out;
          temp$6.print(n);
        }
        java.io.PrintStream temp$7 = java.lang.System.out;
        temp$7.print("\n");
      }
      __xform_tmp_2 = (__xform_tmp_2 + 1);
    }
  }
}
