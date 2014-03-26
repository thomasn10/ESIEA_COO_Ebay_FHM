package User;

import Enchere.Enchere;

public class Vendeur extends User{
	
		public Enchere enchere;
		
		public Vendeur(String nom, String prenom, String login, Object object) {
			super(nom, prenom, login);
		}	
}
