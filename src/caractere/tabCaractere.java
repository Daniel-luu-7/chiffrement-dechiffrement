package src.caractere;

public class tabCaractere {

  //ATTRIBUTS
  public char tableauCaratere[];

  //CONSTRUCTEURS
  public tabCaractere() {
    this.tableauCaratere = new char[154];
  }

  //METHODES
  public void remplirTableauCaractere() {
    char c;

    //Remplir le tableau avec des lettres
    for (int i = 0; i <= 153; i++) {
      int j = i + 32; //lettre A à Z correspond au code ASCII de 97 à 122
      c = (char) j;

      this.tableauCaratere[i] = c;
      j++;
    }

    System.out.println("Tableau de caractères");
    System.out.println(this.tableauCaratere);
  }

  public int taille() {
    return this.tableauCaratere.length;
  }
}
