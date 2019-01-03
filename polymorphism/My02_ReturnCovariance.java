package biz.markov.thinking.polymorphism;

class A {
   A get() {
      System.out.println("A.get()");
      return null;
   }
}

class B extends A {
   B get() {
      System.out.println("B.get()");
      return null;
   }
}

public class My02_ReturnCovariance {
   public static void main(String[] args) {
      A a = new B();
      a.get();
   }
}

/* Bytecode of B class contains bridge get() method:

class biz/markov/thinking/polymorphism/B extends biz/markov/thinking/polymorphism/A {

  // compiled from: My02_ReturnCovariance.java

  // access flags 0x0
  <init>()V
   L0
    LINENUMBER 10 L0
    ALOAD 0
    INVOKESPECIAL biz/markov/thinking/polymorphism/A.<init> ()V
    RETURN
   L1
    LOCALVARIABLE this Lbiz/markov/thinking/polymorphism/B; L0 L1 0
    MAXSTACK = 1
    MAXLOCALS = 1

  // access flags 0x0
  get()Lbiz/markov/thinking/polymorphism/B;
   L0
    LINENUMBER 12 L0
    GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
    LDC "B.get()"
    INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
   L1
    LINENUMBER 13 L1
    ACONST_NULL
    ARETURN
   L2
    LOCALVARIABLE this Lbiz/markov/thinking/polymorphism/B; L0 L2 0
    MAXSTACK = 2
    MAXLOCALS = 1

  // access flags 0x1040
  synthetic bridge get()Lbiz/markov/thinking/polymorphism/A;
   L0
    LINENUMBER 10 L0
    ALOAD 0
    INVOKEVIRTUAL biz/markov/thinking/polymorphism/B.get ()Lbiz/markov/thinking/polymorphism/B;
    ARETURN
   L1
    LOCALVARIABLE this Lbiz/markov/thinking/polymorphism/B; L0 L1 0
    MAXSTACK = 1
    MAXLOCALS = 1
}
 */
