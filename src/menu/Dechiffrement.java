package src.menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Dechiffrement extends Chiffrement {

  //CONSTRUCTEUR
  public Dechiffrement() {
    super();
  }

  //METHODE
  public char caractereDechiffre(char c, char[] tabCaractere) {
    int indiceCaractere = indiceCaractere(c, tabCaractere);
    int newIndice = indiceCaractere - this.getCleChiffrement();

    if (newIndice < 0) newIndice = 154 + newIndice;

    char cC = tabCaractere[newIndice];

    return cC;
  }

  public void lireK_nbr() {
    File f = new File("./Chiffre.txt");
    FileReader fr;
    String str;

    try {
      fr = new FileReader(f);
      BufferedReader br = new BufferedReader(fr);

      str = br.readLine();

      fr.close();

      this.setK(
          Integer.parseInt(str.substring(str.length() - 3, str.length()))
        );
    } catch (Exception e) {}
  }

  public void dechiffrementFichier(char[] tabCaractere) {
    File f1 = new File("./Chiffre.txt");
    File f2 = new File("./Resultat.txt");
    FileReader fr;
    FileWriter fw;
    String str;

    char c;
    this.lireK_nbr();
    this.selectionCle();

    try {
      fr = new FileReader(f1);
      fw = new FileWriter(f2);

      BufferedReader br = new BufferedReader(fr);

      //Lecture des données
      str = br.readLine();

      for (int i = 0; i < str.length() - 3; i++) {
        c = caractereDechiffre(str.charAt(i), tabCaractere);
        fw.write(c);
      }

      fw.close();
      br.close();
      fr.close();
    } catch (Exception e) {}

    compareFichier("./Resultat.txt", "./Clair.txt");
  }

  public void compareFichier(String Resultat, String Clair) {
    File fR = new File(Resultat);
    File fC = new File(Clair);
    FileReader frR;
    FileReader frC;
    String strR;
    String strC;

    try {
      frR = new FileReader(fR);
      frC = new FileReader(fC);

      BufferedReader bwR = new BufferedReader(frR);
      BufferedReader bwC = new BufferedReader(frC);

      //Lecture des données
      strR = bwR.readLine();
      strC = bwC.readLine();

      for (int i = 0; i < strC.length(); i++) {
        if (strR.charAt(i) != strC.charAt(i)) {
          System.out.println(strR.charAt(i));
          System.out.println(strC.charAt(i));
          System.out.println("Fichier non identique !");

          break;
        } else if (
          strR.charAt(i) == strC.charAt(i) && i == (strC.length() - 1)
        ) {
          System.out.println("Resultat.txt : " + strR);
          System.out.println("Clair.txt : " + strC);
          System.out.println("\nFichier identique !");
        }
      }

      bwR.close();
      bwC.close();
      frR.close();
      frC.close();
    } catch (Exception e) {}
  }
}
