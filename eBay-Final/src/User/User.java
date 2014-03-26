package User;

abstract class User{
	public int id;
	public String nom;
	public String prenom;
	public String login;
	
	public User(String nom, String prenom, String login){
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
	}
	private String getNom(){
		return nom;
	}
	private void setNom(String nom){
		this.nom = nom;
	}
	private String getPrenom(){
		return prenom;
	}
	private void setPrenom(String prenom){
		this.prenom = prenom;
	}
	private String getLogin(){
		return login;
	}
	private void setLogin(String login){
		this.login = login;
	}
}
