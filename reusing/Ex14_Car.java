//: reusing/Ex14_Ex14_Car.java
// Composition with public objects.
package biz.markov.thinking.reusing;

class Ex14_Engine {
  public void start() {}
  public void rev() {}
  public void stop() {}
  public void service() {}
}

class Ex14_Wheel {
  public void inflate(int psi) {}
}

class Ex14_Window {
  public void rollup() {}
  public void rolldown() {}
}

class Ex14_Door {
  public Ex14_Window window = new Ex14_Window();
  public void open() {}
  public void close() {}
}

public class Ex14_Car {
  public Ex14_Engine engine = new Ex14_Engine();
  public Ex14_Wheel[] wheel = new Ex14_Wheel[4];
  public Ex14_Door
    left = new Ex14_Door(),
    right = new Ex14_Door(); // 2-door
  public Ex14_Car() {
    for(int i = 0; i < 4; i++)
      wheel[i] = new Ex14_Wheel();
  }
  public static void main(String[] args) {
    Ex14_Car car = new Ex14_Car();
    car.left.window.rollup();
    car.wheel[0].inflate(72);
    car.engine.service();
  }
} ///:~
