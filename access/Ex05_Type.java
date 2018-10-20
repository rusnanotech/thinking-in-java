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

public class Ex05_Type {
    public Ex05_Type() {
        System.out.println("Constructor");
    }

    public String strPublic = "Public field";
    protected String strProtected = "Protected field";
    String strPackage = "Package field";
    private String strPrivate = "Private field";

    public void fPublic() {
        System.out.println("Public method");
    }

    protected void fProtected() {
        System.out.println("Protected method");
    }

    void fPackage() {
        System.out.println("Package method");
    }

    private void fPrivate() {
        System.out.println("Private method");
    }
}
