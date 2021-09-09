import java.util.*;

public class extraireCle{

	public static void main(String args[]){
	
	
	
		
		//On demande le nombre de clé à générer
		System.out.println("Nombre de clé à générer : ");
		Scanner sc = new Scanner(System.in);
			
		int NbCle = sc.nextInt();
		sc.close();
		
		
		GenerationFichierCle G = new GenerationFichierCle(NbCle);
		G.Genere();
	
		
		/*Cle k = new Cle(NbCle);
		int cle=k.selectionCle();
		System.out.println("Cle = " + cle);*/
		
		
		tabCaractere t = new tabCaractere();
		t.remplirTableauCaractere();
			
		Chiffrement chif = new Chiffrement(NbCle);
		chif.chiffrementFichier(t.tableauCaratere);
		
		Dechiffrement dchif = new Dechiffrement();
		dchif.dechiffrementFichier(t.tableauCaratere);
				
}

	
}