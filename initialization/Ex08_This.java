/****************** Exercise 8 *****************
 * Create a class with two methods. Within the
 * first method call the second method twice to
 * see it work, the first time without using this,
 * and the second time using this.
 * (You should not use this form in practice.)
 ***********************************************/
package biz.markov.thinking.initialization;

public class Ex08_This {
    void f(String s) {
        System.out.println("f called " + s);
    }
    void g() {
        f("without using 'this'");
        this.f("with using 'this'");
    }
    public static void main(String args[]) {
        new Ex08_This().g();
    }
}
