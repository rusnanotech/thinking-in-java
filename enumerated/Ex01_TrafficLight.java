/****************** Exercise 1 *****************
 * Use a static import to modify TrafficLight.java
 * so you don’t have to qualify the enum instances.
 ***********************************************/

package biz.markov.thinking.enumerated;

import static biz.markov.thinking.enumerated.Signal.GREEN;
import static biz.markov.thinking.enumerated.Signal.RED;
import static biz.markov.thinking.enumerated.Signal.YELLOW;
import static net.mindview.util.Print.print;

// Define an enum type:
enum Signal {GREEN, YELLOW, RED,}

public class Ex01_TrafficLight {
    Signal color = RED;

    public static void main(String[] args) {
        Ex01_TrafficLight t = new Ex01_TrafficLight();
        for (int i = 0; i < 7; i++) {
            print(t);
            t.change();
        }
    }

    public void change() {
        switch (color) {
            // Note that you don't have to say Signal.RED
            // in the case statement:
            case RED:
                color = GREEN;
                break;
            case GREEN:
                color = YELLOW;
                break;
            case YELLOW:
                color = RED;
                break;
        }
    }

    public String toString() {
        return "The traffic light is " + color;
    }
} /* Output:
The traffic light is RED
The traffic light is GREEN
The traffic light is YELLOW
The traffic light is RED
The traffic light is GREEN
The traffic light is YELLOW
The traffic light is RED
*///:~
