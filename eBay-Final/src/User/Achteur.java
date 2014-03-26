package User;

import java.util.List;

import Enchere.Enchere;
import Enchere.Offre;

public class Achteur extends User{
	private Offre offre;
	public Achteur(String nom, String prenom, String login, Offre offre) {
		super(nom, prenom, login);
	}

	private List<Enchere> getEncheres(List Enchere){
		return Enchere;	
	}
	
}
