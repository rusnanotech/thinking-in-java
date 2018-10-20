/****************** Exercise 5 ******************
 * Create a class with public, private,
 * protected, and package-access fields and
 * method members. Create an object of this class
 * and see what kind of compiler messages you get
 * when you try to access all the class members.
 * Remember that classes in the same directory
 * are part of the "default" package.
 ***********************************************/
// default package
package biz.markov.thinking.access;

public class Ex05 {
    public static void main(String args[]) {
        Ex05_Type x = new Ex05_Type();

        System.out.println(x.strPublic);
        System.out.println(x.strProtected);
        System.out.println(x.strPackage);
        //! System.out.println(x.strPrivate);

        x.fPublic();
        x.fProtected();
        x.fPackage();
        //! x.fPrivate();
    }
}
