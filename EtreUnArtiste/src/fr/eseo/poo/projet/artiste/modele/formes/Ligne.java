package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Ligne extends Forme {
	public static final double EPSILON = 0.3;

	public Ligne() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public Ligne(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}

	public Ligne(Coordonnees coordonnees) {
		this(coordonnees, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public Ligne(Coordonnees coordonnees, double largeur, double hauteur) {
		super(coordonnees, largeur, hauteur);
		System.out.println(toString());
	}


	public Coordonnees getC1() {
		return super.getPosition();
	}

	public Coordonnees getC2() {
		return new Coordonnees(getC1().getAbscisse() + getLargeur(), getC1().getOrdonnee() + getHauteur());
	}

	public void setPosition(Coordonnees coordonnees) {
		super.setPosition(coordonnees);
	}

	public void setC2(Coordonnees coordonnees) {
		this.setLargeur(coordonnees.getAbscisse() - getC1().getAbscisse());
		this.setHauteur(coordonnees.getOrdonnee() - getC1().getOrdonnee());
	}

	public void setC1(Coordonnees coordonnees) {
		this.setLargeur(getC2().getAbscisse() - coordonnees.getAbscisse());
		this.setHauteur(getC2().getOrdonnee() - coordonnees.getOrdonnee());
		setPosition(coordonnees);
	}

	@Override
	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		return getC1().distanceVers(getC2());
	}

	public String toString() {
		double angleDeg;

		if (getC1().angleVers(getC2()) >= 0) {
			angleDeg = Math.toDegrees(getC1().angleVers(getC2()));

		} else {
			angleDeg = 360 + Math.toDegrees(getC1().angleVers(getC2()));
		}

		NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("0.0#");

		String pattern = "0.#";
		DecimalFormat decimf = new DecimalFormat(pattern);

		if (Locale.getDefault().getLanguage().equals("fr")) {
			System.out.println("frannnncais");
			return ("[" + getClass().getSimpleName() + "] c1 : " + getC1().toString() + " c2 : " + getC2().toString()
					+ " longueur : " + df.format(this.perimetre()) + " angle : " + df.format(angleDeg) + "° couleur = R"
					+ decimf.format(this.getCouleur().getRed()) + ",V" + decimf.format(this.getCouleur().getGreen())
					+ ",B" + decimf.format(this.getCouleur().getBlue()));
		} else {
			return ("[" + getClass().getSimpleName() + "] c1 : " + getC1().toString() + " c2 : " + getC2().toString()
					+ " longueur : " + df.format(this.perimetre()) + " angle : " + df.format(angleDeg) + "° couleur = R"
					+ decimf.format(this.getCouleur().getRed()) + ",G" + decimf.format(this.getCouleur().getGreen())
					+ ",B" + decimf.format(this.getCouleur().getBlue()));
		}

	}

	@Override
	public boolean contient(Coordonnees coordonnee) {
		double C1C = getC1().distanceVers(coordonnee);
		double CC2 = coordonnee.distanceVers(getC2());
		double C1C2 = getC1().distanceVers(getC2());

		if (((C1C + CC2) - C1C2) <= EPSILON) {
			return true;
		} else {
			return false;
		}
	}
	
}
