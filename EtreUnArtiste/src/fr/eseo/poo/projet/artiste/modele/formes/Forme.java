package fr.eseo.poo.projet.artiste.modele.formes;

import java.awt.Color;
import fr.eseo.poo.projet.artiste.modele.Coloriable;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import javax.swing.UIManager; 

public abstract class Forme implements Coloriable {
	public static final double LARGEUR_PAR_DEFAUT = 175;
	public static final double HAUTEUR_PAR_DEFAUT = 100;
	public static final Color COULEUR_PAR_DEFAUT = UIManager.getColor("Panel.foreground"); 
	
	private double largeur, hauteur;
	private Coordonnees position;
	private Color couleur; 
	
	public Forme() {
		this(new Coordonnees(),LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public Forme(double largeur, double hauteur){
		this(new Coordonnees(), largeur, hauteur); 
	}
	
	public Forme(Coordonnees position){
		this(position,LARGEUR_PAR_DEFAUT,HAUTEUR_PAR_DEFAUT);
	}
	
	public Forme(Coordonnees position, double largeur, double hauteur){
		setLargeur(largeur); 
		setHauteur(hauteur); 
		setPosition(position);
		setCouleur(COULEUR_PAR_DEFAUT); 
	}
	
	public Coordonnees getPosition() {
		return this.position;
	}

	public double getLargeur() {
		return this.largeur;
	}
	
	public double getHauteur() {
		return this.hauteur;
	}
	
	public double getCadreMinX() {
		return Math.min(getPosition().getAbscisse(),(getPosition().getAbscisse())+getLargeur()); 
	}
	
	public double getCadreMinY() {
		return Math.min(getPosition().getOrdonnee(), (getPosition().getOrdonnee())+getHauteur());
	}

	public double getCadreMaxX() {
		return Math.max(getPosition().getAbscisse(),(getPosition().getAbscisse())+getLargeur()); 
	}
	public double getCadreMaxY() {
		return Math.max(getPosition().getOrdonnee(), (getPosition().getOrdonnee())+getHauteur());
	}

	public void setPosition(Coordonnees position) {
		this.position = position;
	}
	
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	
	public void deplacerDe(double deltaX, double deltaY) {
		getPosition().deplacerDe(deltaX, deltaY);
	}
	
	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		getPosition().deplacerVers(nouvelleAbscisse, nouvelleOrdonnee);
	}
	
	
	public abstract double aire();

	public abstract double perimetre();
	
	public abstract boolean contient(Coordonnees coordonnee);
	
	
	@Override
	public Color getCouleur() {
		return couleur;
	}
	
	@Override
	public void setCouleur(Color couleur) {
		this.couleur =couleur; 
	}
}
