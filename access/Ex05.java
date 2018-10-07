// default package

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
