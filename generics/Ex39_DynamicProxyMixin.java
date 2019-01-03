/****************** Exercise 39 *****************
 * Add a new mixin class Colored to
 * DynamicProxyMixin.java, mix it in to mixin, and
 * show that it works.
 ************************************************/
package biz.markov.thinking.generics;

import java.lang.reflect.*;
   import java.util.*;
   import net.mindview.util.*;
   import static net.mindview.util.Tuple.*;

class MixinProxy implements InvocationHandler {
   Map<String,Object> delegatesByMethod;
   public MixinProxy(TwoTuple<Object,Class<?>>... pairs) {
      delegatesByMethod = new HashMap<String,Object>();
      for(TwoTuple<Object,Class<?>> pair : pairs) {
         for(Method method : pair.second.getMethods()) {
            String methodName = method.getName();
            // The first interface in the map
            // implements the method.
            if (!delegatesByMethod.containsKey(methodName))
               delegatesByMethod.put(methodName, pair.first);
         }
      }
   }
   public Object invoke(Object proxy, Method method,
                        Object[] args) throws Throwable {
      String methodName = method.getName();
      Object delegate = delegatesByMethod.get(methodName);
      return method.invoke(delegate, args);
   }
   @SuppressWarnings("unchecked")
   public static Object newInstance(TwoTuple... pairs) {
      Class[] interfaces = new Class[pairs.length];
      for(int i = 0; i < pairs.length; i++) {
         interfaces[i] = (Class)pairs[i].second;
      }
      ClassLoader cl =
         pairs[0].first.getClass().getClassLoader();
      return Proxy.newProxyInstance(
         cl, interfaces, new MixinProxy(pairs));
   }
}

public class Ex39_DynamicProxyMixin {
   public static void main(String[] args) {
      Object mixin = MixinProxy.newInstance(
         tuple(new BasicImp(), Basic.class),
         tuple(new TimeStampedImp(), TimeStamped.class),
         tuple(new SerialNumberedImp(),SerialNumbered.class),
         tuple(new ColoredImp(), Colored.class));
      Basic b = (Basic)mixin;
      TimeStamped t = (TimeStamped)mixin;
      SerialNumbered s = (SerialNumbered)mixin;
      Colored c = (Colored)mixin;
      b.set("Hello");
      c.setColor(238, 245, 128);
      System.out.println(b.get());
      System.out.println(t.getStamp());
      System.out.println(s.getSerialNumber());
      System.out.println(c.getColor());
   }
}
