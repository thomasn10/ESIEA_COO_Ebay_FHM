package Enchere;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import Alerte.Observateur;

public class Enchere {
	
	public String limite;
	public Double prixMin;
	public Double prixMax;
	public EtatEnchere etatEnchere;
	public Object object;
	public LinkedList<Offre> listoffre = new LinkedList<Offre>(); 
	private ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();
	
	public Enchere(String limite, double prixMin, EtatEnchere etatEnchere, Object object, Offre offre) {
		this.listoffre.add(offre);
		this.object = object;
		this.limite = limite;
		this.prixMin = prixMin;
		this.etatEnchere = etatEnchere;
	}
	//ajouter une offre et faire une alerte
	public void nouvelleOffre(Offre offre){
		listoffre.add(offre);
		this.updateObservateur();
	}
	//ajouter un observateur
	public void addObservateur(Observateur obs){
		this.listObservateur.add(obs);
	}
	//retirer tout les observateur
	public void delObservateur(){
		this.listObservateur = new ArrayList<Observateur>();
	}
	  //Avertit les observateurs que l'objet observable a changé 
	  //et invoque la méthode update() de chaque observateur
	public void updateObservateur() {
	    for(Observateur obs : this.listObservateur )
	      obs.update(this.limite);
	}
	public void creerEnchere() {
		System.out.println("publier Enchere");
		this.etatEnchere = EtatEnchere.CREER;		
	}
	public void publierEnchere() {
		System.out.println("publier Enchere");
		this.etatEnchere = EtatEnchere.PUBLIER;		
	}
	public void annulerOffre() {
		System.out.println("annuler Enchere");
		this.etatEnchere = EtatEnchere.ANNULER;
	}
	public void terminerEnchere() {
		System.out.println("terminer Enchere");
		this.etatEnchere = EtatEnchere.TERMINER;		
	}
	private Object getObject(){
		return object;
	}
	private void setObject(Object object){
		this.object = object;
	}
	private String limite(){
		return limite;
	}
	private void setLimite(String limite){
		this.limite = limite;
	}
	private Double getPrixMin(){
		return prixMin;
	}
	private void setPrixMin(double prixMin){
		this.prixMin = prixMin;
	}
	private Double getPrixMax(){
		return prixMax;
	}
	private void setPrixMax(double prixMax){
		this.prixMax = prixMax;
	}
	private EtatEnchere getEtat(){
		return etatEnchere;
	}
	public LinkedList<Offre> getListoffre() {
		return listoffre;
	}
}
