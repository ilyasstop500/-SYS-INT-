
public class Main {
    public static void main(String[] args) {
        Echiquier e1 = new Echiquier(3);
        System.out.println(e1.toString());
        e1.placerReine(0, 0);
        System.out.println(e1.toString());
    }

}   
