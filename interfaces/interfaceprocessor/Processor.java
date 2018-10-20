//: interfaces/interfaceprocessor/Processor.java
package biz.markov.thinking.interfaces.interfaceprocessor;

public interface Processor {
  String name();
  Object process(Object input);
} ///:~
