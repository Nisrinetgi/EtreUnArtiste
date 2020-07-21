package fr.eseo.poo.projet.artiste.modele.formes;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse{
	
	public Cercle() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT);
	}

	public Cercle(double taille) {
		this(new Coordonnees(),taille);
	}

	public Cercle(Coordonnees coordonnees) {
		this(coordonnees, LARGEUR_PAR_DEFAUT);
	}

	public Cercle(Coordonnees coordonnees, double taille) {
		super(coordonnees,taille,taille);
		
	}
	
	@Override
	public void setHauteur(double hauteur) {
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
	}
	
	@Override
	public void setLargeur(double largeur) {
		super.setLargeur(largeur);
		super.setHauteur(largeur);
	}
	
	@Override
	public double perimetre() {
		return super.perimetre();
	}
	
	public String toString() {
		return super.toString(); 
	}
	
}
