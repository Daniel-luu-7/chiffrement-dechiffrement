package src.key;

import java.util.*;
import src.caractere.tabCaractere;
import src.menu.Chiffrement;
import src.menu.Dechiffrement;

public class extraireCle {

  public static void main(String args[]) {
    //On demande le nombre de clé à générer
    System.out.println("Nombre de clé à générer : ");
    Scanner sc = new Scanner(System.in);

    int NbCle = sc.nextInt();
    sc.close();

    GenerationFichierCle G = new GenerationFichierCle(NbCle);
    G.Genere();

    tabCaractere t = new tabCaractere();
    t.remplirTableauCaractere();

    Chiffrement chif = new Chiffrement(NbCle);
    chif.chiffrementFichier(t.tableauCaratere);

    Dechiffrement dchif = new Dechiffrement();
    dchif.dechiffrementFichier(t.tableauCaratere);
  }
}
