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

    this.tableauCaratere[150] = '�';
    this.tableauCaratere[151] = '�';

    System.out.println(this.tableauCaratere);
    /*
		
		//Remplir le tableau avec l'espace	
		this.tableauCaratere[26]= ' ';
		
		
		//Remplir le tableau avec des chiffres	
		for(int i=27; i<=35; i++){
			int j=i+22;	//lettre 0 à 9 correspond au code ASCII de 48 à 57
			c = (char) j;
			this.tableauCaratere[i]=c;
			j++;
			}
		
		this.tableauCaratere[36]= '0';*/
  }

  public int taille() {
    return this.tableauCaratere.length;
  }
}
