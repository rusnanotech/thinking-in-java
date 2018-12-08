/****************** Exercise 21 *****************
 * Modify SimpleProxyDemo.java so it measures
 * method-call times.
 ***********************************************/
package biz.markov.thinking.typeinfo;//: typeinfo/SimpleProxyDemo.java

import static net.mindview.util.Print.print;

interface Interface {
  void doSomething();
  void somethingElse(String arg);
}

class RealObject implements Interface {
  public void doSomething() { print("doSomething"); }
  public void somethingElse(String arg) {
    print("somethingElse " + arg);
  }
}

class SimpleProxy implements Interface {
  private Interface proxied;
  public SimpleProxy(Interface proxied) {
    this.proxied = proxied;
  }
  public void doSomething() {
    print("SimpleProxy doSomething at");
    long start = System.nanoTime();
    proxied.doSomething();
    long duration = System.nanoTime() - start;
    System.out.println("Duration: " + duration + " ns");
  }
  public void somethingElse(String arg) {
    print("SimpleProxy somethingElse");
    long start = System.nanoTime();
    proxied.somethingElse(arg);
    long duration = System.nanoTime() - start;
    System.out.println("Duration: " + duration + " ns");
  }
}

class SimpleProxyDemo {
  public static void consumer(Interface iface) {
    iface.doSomething();
    iface.somethingElse("bonobo");
  }
  public static void main(String[] args) {
    consumer(new RealObject());
    consumer(new SimpleProxy(new RealObject()));
  }
}
