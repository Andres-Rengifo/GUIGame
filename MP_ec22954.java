package OOP.ec22954.MP;

public class MP_ec22954 {

    public static void main (String[] args) {
        Visitable r = new House_ec22954();
        Visitor v = new GUIVisitor(System.out,System.in);
        r.visit(v , Direction.FROM_NORTH);
    }
}
