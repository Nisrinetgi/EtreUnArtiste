package fr.eseo.poo.projet.artiste.modele;

import java.text.DecimalFormat;
import java.util.Objects;

public class Coordonnees {

	private double abscisse;

	private double ordonnee;

	public static final double ABSCISSE_PAR_DEFAUT = 0.0;
	public static final double ORDONNEE_PAR_DEFAUT = 0.0;

	public Coordonnees() {
		this(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT);
	}

	public Coordonnees(double abscisse, double ordonnee) {
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		;
	}

	public double getAbscisse() {
		return this.abscisse;
	}

	public double getOrdonnee() {
		return this.ordonnee;
	}

	public void setAbscisse(double abscisse) {
		this.abscisse = abscisse;
	}

	public void setOrdonnee(double ordonnee) {
		this.ordonnee = ordonnee;
	}

	public void deplacerDe(double deltaX, double deltaY) {
		double coordAbscisse = this.getAbscisse() + deltaX;
		double coordOrdonnee = this.getOrdonnee() + deltaY;
		this.deplacerVers(coordAbscisse, coordOrdonnee);
	}

	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		this.setAbscisse(nouvelleAbscisse);
		this.setOrdonnee(nouvelleOrdonnee);
	}

	public double distanceVers(Coordonnees autreCoordonnees) {
		double deltaX = autreCoordonnees.getAbscisse() - this.getAbscisse();
		double deltaY = autreCoordonnees.getOrdonnee() - this.getOrdonnee();
		return (Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}

	public double angleVers(Coordonnees autreCoordonnees) {
		double coordAbscisse = autreCoordonnees.getAbscisse();
		double coordOrdonnee = autreCoordonnees.getOrdonnee();
		
		return (-Math.atan2(this.getOrdonnee() - coordOrdonnee,
				coordAbscisse - this.getAbscisse()));
	}

	public String toString() {
		String pattern = "0.0#";
		DecimalFormat df = new DecimalFormat(pattern);
		return ("(" + df.format(getAbscisse()) + " , " + df.format(getOrdonnee()) + ")");
	}

	@Override
	public int hashCode() {
		return Objects.hash(abscisse, ordonnee);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Coordonnees other = (Coordonnees) obj;
		return Double.doubleToLongBits(abscisse) == Double.doubleToLongBits(other.abscisse)
				&& Double.doubleToLongBits(ordonnee) == Double.doubleToLongBits(other.ordonnee);
	}

}
