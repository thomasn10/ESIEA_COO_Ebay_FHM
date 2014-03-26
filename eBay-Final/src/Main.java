import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JLabel;

import Alerte.Observateur;
import Enchere.Enchere;
import Enchere.EtatEnchere;
import Enchere.Object;
import Enchere.Offre;
import User.Achteur;
import User.Vendeur;


public class Main {

	private static String nom;
	private static String prenom;
	private static String login;
	private static LinkedList<Enchere> listEnchere = new LinkedList<Enchere>();
	private static LinkedList<Object> listObject = new LinkedList<Object>();
	public static void main(String [] args){
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Votre nom");
			nom = sc.nextLine();
			System.out.println("Votre prenom");
			prenom = sc.nextLine();
			System.out.println("Votre login");
			login = sc.nextLine();
			
			System.out.println("Etes-vous Vendeur? oui/non)");
			String str = sc.nextLine();

			int nb = 0;
			Offre offre = null;
			Object object = null;
			
			if(str.equals("non")){
				
				if(listObject.size() == 0)
					System.out.println("pas d'object");
				else{
				AffichageObject(listObject);
				System.out.println("Sur quel objet souhaitez vous faire une offre? (le premier objet etant le 0)");
				str = sc.nextLine();
				nb = Integer.parseInt(str);
				System.out.println("Montant de l'offre?");
				str = sc.nextLine();
				int ofr = Integer.parseInt(str);
				//offre.montant = ofr;
				//offre.emetteur = login;
				offre = new Offre(ofr,login);
				new Achteur(nom,prenom,login,offre);

				if(listEnchere.size() == 0)
				{
					Enchere enchere = new Enchere("date",2,EtatEnchere.CREER,listObject.get(nb),offre);
					listEnchere.add(enchere);
				}
				else
				{
					int ajout = 0;
					for(int z = 0 ; z < listEnchere.size(); z++)
					{
						if((listEnchere.get(z).object).equals(listObject.get(nb)))
						{
							listEnchere.get(nb).nouvelleOffre(offre);
							System.out.println("=======================================================");
							System.out.println("nouvelle offre sur "+ listEnchere.get(z).object.description);
							System.out.println("=======================================================");
							ajout = 1;
						}

					}
					if(ajout == 0)
					{
						Enchere enchere = new Enchere("date",2,EtatEnchere.CREER,listObject.get(nb),offre);
						listEnchere.add(enchere);
					}
					
				}
			}
				Affichage(listEnchere);
			}
			if(str.equals("oui")){
				System.out.println("description de l'objet à vendre");
				String desc = sc.nextLine();
				//object.description = desc;
				object = new Object(desc);
				new Vendeur(nom,prenom,login,object);
				listObject.add(object);
			}
		if(object != null && offre != null)
		{
			Enchere enchere = new Enchere("date",2,EtatEnchere.CREER,object,offre);
			listEnchere.add(enchere);

			enchere.addObservateur(new Observateur(){
			public void update(String limite){
					System.out.println(limite);
				}
			});

			enchere.publierEnchere();
		//enchere.listoffre.add(offre1);
			Affichage(listEnchere);
		}
	}
}
		/*private static void nouvelleOffre(Enchere enchere, Offre offre){
		enchere.listoffre.add(offre);
		.updateObservateur();
	}*/
	private static void AffichageObject(LinkedList<Object> listObject){
		for(int i = 0; i < listObject.size(); i++){
			System.out.println("Objet "+i+" description: "+listObject.get(i).description);
		}
	}
	private static void Affichage(LinkedList<Enchere> listEnchere){
		for(int i = 0; i < listEnchere.size(); i++){
			System.out.println("Objet "+i+" description: "+listEnchere.get(i).object.description);
			if(listEnchere.get(i).listoffre.get(0) != null)
			{
				for(int j = 0; j < listEnchere.get(i).listoffre.size(); j++){
					System.out.println(" offre "+listEnchere.get(i).listoffre.get(j).montant+" "+listEnchere.get(i).listoffre.get(j).emetteur);				
				}
			}
			else
				System.out.println("pas d'offre");
		}
	}
}
