
public class Echiquier {

    private Cellule[][] echiquier;
    private int taille;

    private char libre = '-';
    private char reine = 'R';
    private char menacee = '*';

    public Echiquier(int taille) {
        this.taille = taille;
        echiquier = new Cellule[taille][taille];
        initialiserEchiquier();
    }

    public void initialiserEchiquier() {
        for (int x = 0; x < taille; x++) {
            for (int y = 0; y < taille; y++) {
                echiquier[x][y] = new Cellule(x, y, libre);
            }
        }
    }

    public void modifierCellule(int x, int y, char valeur) {
        echiquier[x][y].setOcc(valeur);
    }

    public void placerReine(int x, int y) {
        if (echiquier[x][y].getOcc() == libre) { // verification cellule libre

            for (int i = 0; i < echiquier.length; i++) { // marquer la colonne
                modifierCellule(i, y, menacee);

            }

            for (int i = 0; i < echiquier.length; i++) { // marquer la ligne
                modifierCellule(x, i, menacee);

            }

            for (int i = 0; i < echiquier.length; i++) {

                if (x + i < echiquier.length && y + i < echiquier.length) { // marquer la diagonale direction ↘
                    modifierCellule(x + i, y + i, menacee);

                }

                if (x - i > 0 && y - i > 0) { // marquer la diagonale direction ↖
                    modifierCellule(x - i, y - i, menacee);

                }

                if (x + i < echiquier.length && y - i > 0) { // marquer la diagonale direction ↙
                    modifierCellule(x + i, y - i, menacee);

                }

                if (x - i > 0 && y + i < echiquier.length) { // marquer la diagonale direction ↗
                    modifierCellule(x - i, y + i, menacee);

                }
            }

            modifierCellule(x, y, reine); // marquer la reine

        }
    }

    public String toString() {
        String resultat = "";
        for (int i = 0; i < echiquier.length; i++) {
            for (int j = 0; j < echiquier.length; j++) {
                resultat = resultat + " " + echiquier[i][j].getOcc();
            }
            resultat = resultat + "\n";

        }
        return resultat;

    }

    public int nbrReines() {
        placerReine(0, 0);

        for (int i = 0; i < echiquier.length; i++) {
            for (int j = 0; j < echiquier.length; j++) {
                if (echiquier[i][j] == libre) {

                }

            }

        }

    }

}
