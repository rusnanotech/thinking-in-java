/****************** Exercise 23 *****************
 * Inside invoke() in SimpleDynamicProxy.java,
 * try to print the proxy argument and explain
 * what happens.
 ************************************************/
package biz.markov.thinking.typeinfo;
//: typeinfo/Ex23_SimpleDynamicProxy.java

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class Ex23_DynamicProxyHandler implements InvocationHandler {
  private Object proxied;
  public Ex23_DynamicProxyHandler(Object proxied) {
    this.proxied = proxied;
  }
  public Object
  invoke(Object proxy, Method method, Object[] args)
  throws Throwable {
    System.out.println("**** proxy: " + proxy +
      ", method: " + method + ", args: " + args);
    if(args != null)
      for(Object arg : args)
        System.out.println("  " + arg);
    long start = System.nanoTime();
    Object obj = method.invoke(proxied, args);
    long duration = System.nanoTime() - start;
    System.out.println("Duration: " + duration + " ns");
    return obj;
  }
}

class Ex23_SimpleDynamicProxy {
  public static void consumer(Interface iface) {
    iface.doSomething();
    iface.somethingElse("bonobo");
  }
  public static void main(String[] args) {
    RealObject real = new RealObject();
    consumer(real);
    // Insert a proxy and call again:
    Interface proxy = (Interface)Proxy.newProxyInstance(
      Interface.class.getClassLoader(),
      new Class[]{ Interface.class },
      new Ex23_DynamicProxyHandler(real));
    consumer(proxy);
  }
}
// Exception in thread "main" java.lang.StackOverflowError