import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class GenerationFichierCle {


//ATTRIBUT
	private int NbCleG;


//CONSTRUCTEUR
	public GenerationFichierCle(int NbCleG){
		this.NbCleG=NbCleG;
		}


//METHODES
	public int getNbCleG(){
		return this.NbCleG;
		}
		
		
	public void Genere(){

		File f = new File("../Keys.txt");
		FileWriter fw;
		String cle;
		
 
 		try{
   			//Création de l'objet texte en écriture
     			fw = new FileWriter(f);
     		     	Random rand = new Random();
     		     	
			
			//NbCle est le nombre de clé à générer passé en paramètre
			int NbCle = this.getNbCleG();
			 
			//On écrit les cle dans le fichier
			for(int i=0; i<NbCle; i++){
   				cle = Integer.toString(rand.nextInt(37));
   					
   				while(Integer.parseInt(cle)==0)
   					cle = Integer.toString(rand.nextInt(37));
   						
   				if(Integer.parseInt(cle)<10)
   					cle = '0'+cle;
   						
   				fw.write(cle);
				}
			
			System.out.println("\nFichier Keys.txt cr�er !\n");
				
			//On ferme le flux
			fw.close();
			}
      
    		catch (Exception e) {}			
    		}
}
