// default package

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
