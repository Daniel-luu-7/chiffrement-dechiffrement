package src;

import java.util.Scanner;

public class Menu extends Thread {

  public Menu() {}

  public void afficherPagePrincipale() {
    System.out.println("*************************");
    System.out.println("*       Bienvenue       *");
    System.out.println("*   dans le programme   *");
    System.out.println("* cryptage et décryptage*");
    System.out.println("*************************\n");

    tabCaractere t = new tabCaractere();
    t.remplirTableauCaractere();

    System.out.println("Nombre de clé à generer : ");
    Scanner sc = new Scanner(System.in);
    int NbCle = sc.nextInt();

    GenerationFichierCle G = new GenerationFichierCle(NbCle);
    G.Genere();

    System.out.println("Choississez un module : \n\n");
    System.out.println("1) Cryptage");
    System.out.println("2) Decryptage");
    System.out.println("3) Quitter");

    int choix;

    try {
      while (true) {
        System.out.println("\nChoix : ");
        choix = sc.nextInt();

        this.choixModule(choix, t.tableauCaratere, NbCle);
      }
    } catch (Exception e) {}
  }

  public void choixModule(int choix, char[] t, int NbCle)
    throws InterruptedException {
    switch (choix) {
      case 1:
        System.out.println("\n*Chiffremment de texte*\n");

        Chiffrement chif = new Chiffrement(NbCle);
        chif.chiffrementFichier(t);

        Thread.sleep(3000);

        System.out.println("Chiffremment Complet !!");
        break;
      case 2:
        System.out.println("\nDéchifremment de texte !");
        Dechiffrement dchif = new Dechiffrement();
        dchif.dechiffrementFichier(t);

        Thread.sleep(3000);
        break;
      case 3:
        System.out.println("Arrêt du programme !");
        System.exit(0);
        break;
      default:
        System.out.println("Veuillez tapez un numéro valide 1,2,3 !");
        break;
    }
  }
}
