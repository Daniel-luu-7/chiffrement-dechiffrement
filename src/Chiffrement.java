package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class Chiffrement {

  //ATTRIBUT
  private int cleChiffrement;
  private int K_nbr;
  private int NbCle;

  //CONSTRUCTEUR
  public Chiffrement() {}

  public Chiffrement(int NbCle) {
    this.K_nbr = 0;
    this.cleChiffrement = 0;
    this.NbCle = NbCle;
  }

  //METHODE
  public int getK() {
    return this.K_nbr;
  }

  public int getCleChiffrement() {
    return this.cleChiffrement;
  }

  public int getNbCle() {
    return this.NbCle;
  }

  public void setK(int K_nbr) {
    this.K_nbr = K_nbr;
  }

  public void setCleChiffrement(int cleChiffrement) {
    this.cleChiffrement = cleChiffrement;
  }

  public void K_nbr() {
    Random rand = new Random();
    int K_nbr = rand.nextInt(this.getNbCle() + 1);

    while (K_nbr == 0) {
      K_nbr = rand.nextInt(this.getNbCle() + 1); //Entre 0 et 100
    }

    this.setK(K_nbr);
  }

  public void selectionCle() {
    String str = "";

    File f = new File("./Keys.txt");
    FileReader fr;

    try {
      fr = new FileReader(f);
      BufferedReader bw = new BufferedReader(fr);

      //Lecture des données
      str = bw.readLine();

      bw.close();
      fr.close();
    } catch (Exception e) {}

    this.setCleChiffrement(
        Integer.parseInt(str.substring((this.getK() * 2) - 2, this.getK() * 2))
      );
  }

  public String concatenuationK(int K_nbr) {
    String Kconca = "";

    if (K_nbr < 10) Kconca = "00" + K_nbr; else if (
      K_nbr > 10 && K_nbr < 100
    ) Kconca = "0" + K_nbr;

    return Kconca;
  }

  public int indiceCaractere(char c, char[] tabCaractere) {
    for (int i = 0; i < tabCaractere.length; i++) if (
      c == tabCaractere[i]
    ) return i;

    System.out.println(c);
    System.out.println("Erreur ! Caractere non trouvé !");

    return 0;
  }

  public char caractereChiffre(char c, char[] tabCaractere) {
    int indiceCaractere = indiceCaractere(c, tabCaractere);
    int newIndice = indiceCaractere + this.getCleChiffrement();

    if (newIndice > 153) newIndice = newIndice - 153;

    char cC = tabCaractere[newIndice];

    return cC;
  }

  public void chiffrementFichier(char[] tabCaractere) {
    File f1 = new File("./Clair.txt");
    File f2 = new File("./Chiffre.txt");
    FileReader fr;
    FileWriter fw;
    String str;
    char c;

    K_nbr();
    this.selectionCle();

    try {
      fr = new FileReader(f1);
      fw = new FileWriter(f2);

      BufferedReader bw = new BufferedReader(fr);

      //Lecture des données
      str = bw.readLine();

      for (int i = 0; i < str.length(); i++) {
        c = caractereChiffre(str.charAt(i), tabCaractere);
        fw.write(c);
      }

      fw.write(this.concatenuationK(K_nbr));

      fw.close();
      bw.close();
      fr.close();
    } catch (Exception e) {}
  }
}
