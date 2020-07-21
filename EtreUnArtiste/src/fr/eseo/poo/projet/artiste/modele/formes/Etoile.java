package fr.eseo.poo.projet.artiste.modele.formes;


import java.awt.geom.GeneralPath;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Etoile extends Forme implements Remplissable {	
	 
	public static final int NOMBRE_BRANCHES_PAR_DEFAUT = 5;
	public static final double ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT = Math.PI / 2;
	public static final double LONGUEUR_BRANCHE_PAR_DEFAUT = 0.5;

	private List<Coordonnees> coordonnees = new ArrayList<Coordonnees>();;
	private int nombreBranches;
	private double anglePremiereBranche;
	private double longueurBranche;
	protected boolean modeRemplissage;

	public Etoile() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				LONGUEUR_BRANCHE_PAR_DEFAUT);
	}

	public Etoile(double taille) {
		this(new Coordonnees(), taille, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				LONGUEUR_BRANCHE_PAR_DEFAUT);
	}

	public Etoile(Coordonnees coordonnees) {
		this(coordonnees, LARGEUR_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				LONGUEUR_BRANCHE_PAR_DEFAUT);

	}

	public Etoile(Coordonnees coordonnees, double taille) {
		this(coordonnees, taille, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				LONGUEUR_BRANCHE_PAR_DEFAUT);
	}

	public Etoile(Coordonnees coordonnees, double taille, int nombreBranches, double anglePremiereBranche,
			double longueurBranche) {

		super(coordonnees, taille, taille);

		if (taille < 0) {
			throw new IllegalArgumentException("La taille ne peut pas être inférieure à 0");
		}

		if (nombreBranches < 3 || nombreBranches > 15) {
			throw new IllegalArgumentException("Le nombre de branches doit être comprit entre 3 et 15");
		} else {
			this.nombreBranches = nombreBranches;
		}
		if (anglePremiereBranche < -Math.PI || anglePremiereBranche > Math.PI) {
			throw new IllegalArgumentException("L'angle de la première branche doit être compris entre -Pi et Pi");
		} else {
			this.anglePremiereBranche = anglePremiereBranche;
		}
		if (longueurBranche < 0 || longueurBranche > 1.0) {
			throw new IllegalArgumentException("La longueur des branche doit être comrpise entre 0 et 1");
		} else {
			this.longueurBranche = longueurBranche;
		}
		this.ajouterCoordonnees();
		setRempli(false);

	}

	public void ajouterCoordonnees() {

		double angle = this.getAnglePremiereBranche();
		double deltaAngle = Math.PI / this.getNombreBranches(); // (2*Pi)/(2*NombreDeBranches)

		for (int i = 0; i < this.getNombreBranches() * 2; i++) {

			double coordonneesAngleAb;
			double coordonneesAngleOrd;

			double centreAbscisse = this.getPosition().getAbscisse() + this.getLargeur() / 2;
			double centreOrdonnee = this.getPosition().getOrdonnee() + this.getLargeur() / 2;

			if (i % 2 != 0) {
				System.out.println("impair");
				coordonneesAngleAb = Math.cos(angle) * (1 - this.getLongueurBranche()) * (this.getLargeur() / 2)
						+ centreAbscisse;
				coordonneesAngleOrd = Math.sin(angle) * (1 - this.getLongueurBranche()) * (this.getLargeur() / 2)
						+ centreOrdonnee;

			} else {
				System.out.println("pair");
				coordonneesAngleAb = Math.cos(angle) * (this.getLargeur() / 2) + centreAbscisse;
				coordonneesAngleOrd = Math.sin(angle) * (this.getLargeur() / 2) + centreOrdonnee;
			}

			this.coordonnees.add(new Coordonnees(coordonneesAngleAb, coordonneesAngleOrd));
			angle += deltaAngle;
		}
	}

	@Override
	public void setHauteur(double hauteur) {
		if (hauteur < 0) {
			throw new IllegalArgumentException("La hauteur ne peut pas être inférieure à 0");
		} else {
			if (this.coordonnees == null) {
				this.coordonnees = new ArrayList<Coordonnees>();
			} else {
				this.coordonnees.clear();
				super.setHauteur(hauteur);
				super.setLargeur(hauteur);
				this.ajouterCoordonnees();
			}
		}
	}

	@Override
	public void setLargeur(double largeur) {
		if (largeur <= 0) {
			throw new IllegalArgumentException("La largeur ne peut pas être inférieure à 0");
		} else {
			if (this.coordonnees == null) {
				this.coordonnees = new ArrayList<Coordonnees>();
			} else {
				this.coordonnees.clear();
				super.setHauteur(largeur);
				super.setLargeur(largeur);
				this.ajouterCoordonnees();
			}
		}
	}

	@Override
	public void setPosition(Coordonnees position) {

		super.setPosition(position);
		this.ajouterCoordonnees();
	}

	public void setNombreBranches(int nbBranches) {

		this.nombreBranches = nbBranches;
		this.ajouterCoordonnees();

		if (nombreBranches < 3 || nombreBranches > 15) {
			throw new IllegalArgumentException("Le nombre de branches doit être comprit entre 3 et 15");
		}
	}

	public void setLongueurBranche(double longueur) {

		this.longueurBranche = longueur;
		this.ajouterCoordonnees();

		if (longueurBranche < 0 || longueurBranche > 1) {
			throw new IllegalArgumentException("La longueur des branche doit être comrpise entre 0 et 1");
		}
	}

	public void setAnglePremiereBranche(double angle) {

		this.anglePremiereBranche = angle;
		this.ajouterCoordonnees();

		if (anglePremiereBranche < (-1) * Math.PI || anglePremiereBranche > Math.PI) {
			throw new IllegalArgumentException("L'angle de la première branche doit être compris entre -Pi et Pi");
		}
	}

	public List<Coordonnees> getCoordonnees() {
		return coordonnees;
	}

	public int getNombreBranches() {
		return nombreBranches;
	}

	public double getLongueurBranche() {
		return longueurBranche;
	}

	public double getAnglePremiereBranche() {
		return anglePremiereBranche;
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
	public double aire() { // LOI DES SINUS
		double angleC = (2 * Math.PI) / (this.getNombreBranches() * 2);
		double coteB = this.getLargeur() / 2;
		double coteA = (this.getLargeur() / 2) * (1 - this.getLongueurBranche());
		double aireTriangle = (coteB * coteA * Math.sin(angleC)) / 2;
		double aireEtoile = aireTriangle * this.getNombreBranches() * 2;
		return aireEtoile;
	}

	@Override
	public double perimetre() { // LOI DES COSINUS

		double angleC = (2 * Math.PI) / (this.getNombreBranches() * 2);
		double coteB = this.getLargeur() / 2;
		double coteA = (this.getLargeur() / 2) * (1 - this.getLongueurBranche());
		double coteC = Math.sqrt(Math.pow(coteA, 2) + Math.pow(coteB, 2) - 2 * coteA * coteB * Math.cos(angleC));
		double perimetreEtoile = coteC * this.getNombreBranches() * 2;
		return perimetreEtoile;
	}

	@Override
	public boolean estRempli() {
		return modeRemplissage;
	}

	@Override
	public void setRempli(boolean modeRemplissage) {
		this.modeRemplissage = modeRemplissage;
	}

	@Override
	public boolean contient(Coordonnees coordonnees) {

		int pointAbscisseTab[] = new int[this.getNombreBranches() * 2];
		int pointOrdonneeTab[] = new int[this.getNombreBranches() * 2];

		for (int i = 0; i < this.getCoordonnees().size(); i++) {
			pointAbscisseTab[i] = (int) Math.round(this.getCoordonnees().get(i).getAbscisse());
			pointOrdonneeTab[i] = (int) Math.round(this.getCoordonnees().get(i).getOrdonnee());
		}

		GeneralPath polygoneEtoile = new GeneralPath(GeneralPath.WIND_NON_ZERO, pointAbscisseTab.length);

		polygoneEtoile.moveTo(pointAbscisseTab[0], pointOrdonneeTab[0]);

		for (int index = 1; index < pointAbscisseTab.length; index++) {
			polygoneEtoile.lineTo(pointAbscisseTab[index], pointOrdonneeTab[index]);
		}

		polygoneEtoile.closePath();

		for (int i = 0; i < this.getCoordonnees().size(); i++) {
			int j = (i != (this.getCoordonnees().size() - 1)) ? i + 1 : 0;

			Ligne ligneBord = new Ligne(this.getCoordonnees().get(i));
			ligneBord.setC2(this.getCoordonnees().get(j));

			if (ligneBord.contient(coordonnees)) {
				return true;
			}
		}

		return false;

	}

	

}
