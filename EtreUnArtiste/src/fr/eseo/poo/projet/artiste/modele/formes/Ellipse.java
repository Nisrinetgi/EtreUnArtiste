package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Ellipse extends Forme implements Remplissable {

	protected boolean modeRemplissage;

	public Ellipse() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public Ellipse(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}

	public Ellipse(Coordonnees coordonnees) {
		this(coordonnees, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public Ellipse(Coordonnees coordonnees, double largeur, double hauteur) {
		super(coordonnees, largeur, hauteur);
		setRempli(false);
		if (largeur < 0 || hauteur < 0)
			throw new IllegalArgumentException("La hauteur ne peut pas être négative");
	}

	@Override
	public void setHauteur(double hauteur) {
		if (hauteur < 0) {
			throw new IllegalArgumentException("La hauteur ne peut pas être négative");
		} else {
			super.setHauteur(hauteur);
		}
	}

	@Override
	public void setLargeur(double largeur) {
		if (largeur < 0) {
			throw new IllegalArgumentException("La largeur ne peut pas être négative");
		} else {
			super.setLargeur(largeur);
		}
	}

	@Override
	public double aire() {
		return (Math.PI * super.getHauteur() * super.getLargeur()) / 4;
	}

	@Override
	public double perimetre() {
		double a; // a = le petit rayon
		double b; // b = le grand rayon

		if (super.getHauteur() > super.getLargeur()) {
			b = super.getHauteur() / 2;
			a = super.getLargeur() / 2;
		} else {
			b = super.getLargeur() / 2;
			a = super.getHauteur() / 2;
		}

		double h = Math.pow((a - b) / (a + b), 2);
		double fin = (3 * h) / (10 + Math.sqrt(4 - (3 * h)));
		double perimetre = Math.PI * (a + b) * (1 + fin);

		return perimetre;
	}
	
	public String toString() {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("0.0#");

		String pattern = "0.#";
		DecimalFormat decimf = new DecimalFormat(pattern);

		String debutChaine = "[" + getClass().getSimpleName();
		String remplissage = "-Rempli";
		String sansRemplissageFr = ("] : pos " + this.getPosition().toString() + " dim " + df.format(this.getLargeur())
				+ " x " + df.format(this.getHauteur()) + " périmètre : " + df.format(this.perimetre()) + " aire : "
				+ df.format(this.aire()) + " couleur = R" + decimf.format(super.getCouleur().getRed()) + ",V"
				+ decimf.format(super.getCouleur().getGreen()) + ",B" + decimf.format(super.getCouleur().getBlue()));

		String sansRemplissageEn = ("] : pos " + this.getPosition().toString() + " dim " + df.format(this.getLargeur())
				+ " x " + df.format(this.getHauteur()) + " périmètre : " + df.format(this.perimetre()) + " aire : "
				+ df.format(this.aire()) + " couleur = R" + decimf.format(this.getCouleur().getRed()) + ",G"
				+ decimf.format(this.getCouleur().getGreen()) + ",B" + decimf.format(this.getCouleur().getBlue()));

		if (Locale.getDefault().getLanguage().equals("fr")) {
			if (!modeRemplissage) {
				return debutChaine + sansRemplissageFr;
			} else {
				return debutChaine + remplissage + sansRemplissageFr;
			}
		} else {
			if (!modeRemplissage) {
				return debutChaine + sansRemplissageEn;
			} else {
				return debutChaine + remplissage + sansRemplissageEn;
			}
		}

	}

	@Override
	public boolean contient(Coordonnees coordonnee) {
		double petitAxe = (Math.min(super.getHauteur(), super.getLargeur())) / 2;
		double grandAxe = (Math.max(super.getHauteur(), super.getLargeur())) / 2;

		double petitAxeCentre;
		double grandAxeCentre;
		double petitAxeCoordPt;
		double grandAxeCoordPt;

		if (grandAxe == (super.getLargeur() / 2)) {
			grandAxeCentre = super.getCadreMinX() + grandAxe;
			grandAxeCoordPt = coordonnee.getAbscisse();

			petitAxeCentre = super.getCadreMinY() + petitAxe;
			petitAxeCoordPt = coordonnee.getOrdonnee();

		} else {

			grandAxeCentre = super.getCadreMinY() + grandAxe;
			grandAxeCoordPt = coordonnee.getOrdonnee();

			petitAxeCentre = super.getCadreMinX() + petitAxe;
			petitAxeCoordPt = coordonnee.getAbscisse();

		}

		double EqCart = Math.pow(((grandAxeCentre - grandAxeCoordPt) / grandAxe), 2)
				+ Math.pow(((petitAxeCentre - petitAxeCoordPt) / petitAxe), 2);

		if (EqCart <= 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean estRempli() {
		return modeRemplissage; 
	}

	@Override
	public void setRempli(boolean modeRemplissage) {
		this.modeRemplissage = modeRemplissage;
	}
	
}
