public class Cellule {
    private int x; 
    private int y;
    private char typeOccupation; // free , queen or threathened 


    public Cellule (int x , int y , char typeOccupation ) {
        this.x = x ;
        this.y = y ; 
        this.typeOccupation = typeOccupation ; 

    }

    public int getx () {
        return x ;
    }

    public int gety () {
        return y ;
    }

    public char getOcc () {
        return typeOccupation ;
    }

    
    public void setx(int x) {
        this.x = x ;

    }

    public void sety(int y) {
        this.y = y ; 
    }

    public void setOcc(char typeOccupation) {
        this.typeOccupation = typeOccupation ;
    }




}
