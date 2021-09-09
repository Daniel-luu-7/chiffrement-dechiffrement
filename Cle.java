import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

//EXTRACTION DE LA CLE
public class Cle {

  //ATTRIBUT
  private int cle;
  private int NbCleG;

  //CONSTRUCTEUR
  public Cle(int NbCleG) {
    this.cle = 0;
    this.NbCleG = NbCleG;
  }

  //METHODE
  //Lire l'attribut cle
  public int getCle() {
    return this.cle;
  }

  public int getNbCleG() {
    return this.NbCleG;
  }

  //Genere K_nbr aléatoirement
  public int K_nbr() {
    Random rand = new Random();
    int K_nbr = rand.nextInt(this.getNbCleG() + 1);
    System.out.println("K_nbr = " + K_nbr);

    while (K_nbr == 0) {
      K_nbr = rand.nextInt(this.getNbCleG() + 1); //Entre 0 et 100
    }

    return K_nbr;
  }

  //Lecture du fichier Keys.txt et extraire la clé
  public int selectionCle() {
    int K_nbr = K_nbr();
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

    return (
      this.cle = Integer.parseInt(str.substring((K_nbr * 2) - 2, K_nbr * 2))
    );
  }
}
