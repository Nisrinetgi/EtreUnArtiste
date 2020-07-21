package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.BoxLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEnregistrer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionOuvrir;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

public class PanneauBarreOutils extends JPanel {

	private static final long serialVersionUID = 1L;

	private PanneauDessin panneauDessin;
	public static final String BRANCHE_SPINNER_NOM = "Nb. Branches";
	public static final String LONGUEUR_SPINNER_NOM = "Hauteur Branche";
	private SpinnerModel valueLongueur;
	private SpinnerModel valueBranche;

	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.initComponents();
	}

	public void initComponents() {

		// BOUTON EFFACER :

		ActionEffacer actionEffacer = new ActionEffacer(this.panneauDessin);
		JButton bouttonEffacer = new JButton(actionEffacer);
		bouttonEffacer.setName(ActionEffacer.NOM_ACTION);
		this.add(bouttonEffacer);

		// BOUTON OUTILS - OutilLigne, OutilEllipse, OutilCercle :

		ButtonGroup buttonGroup = new ButtonGroup();

		ActionChoisirForme actionFormeLigne = new ActionChoisirForme(this.panneauDessin, this,
				ActionChoisirForme.NOM_ACTION_LIGNE);
		ActionChoisirForme actionFormeEllipse = new ActionChoisirForme(this.panneauDessin, this,
				ActionChoisirForme.NOM_ACTION_ELLIPSE);
		ActionChoisirForme actionFormeCercle = new ActionChoisirForme(this.panneauDessin, this,
				ActionChoisirForme.NOM_ACTION_CERCLE);
		ActionSelectionner actionSelectionner = new ActionSelectionner(this.panneauDessin);

		ActionChoisirForme actionFormeEtoile = new ActionChoisirForme(this.panneauDessin, this,
				ActionChoisirForme.NOM_ACTION_ETOILE);

		JToggleButton jToggleButtonLigne = new JToggleButton(actionFormeLigne);
		JToggleButton jToggleButtonEllipse = new JToggleButton(actionFormeEllipse);
		JToggleButton jToggleButtonCercle = new JToggleButton(actionFormeCercle);
		JToggleButton jToggleButtonSelectionner = new JToggleButton(actionSelectionner);
		JToggleButton jToggleButtonEtoile = new JToggleButton(actionFormeEtoile);

		jToggleButtonLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		jToggleButtonEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		jToggleButtonCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		jToggleButtonSelectionner.setName(ActionSelectionner.NOM_ACTION);
		jToggleButtonEtoile.setName(ActionChoisirForme.NOM_ACTION_ETOILE);

		this.add(jToggleButtonLigne);
		this.add(jToggleButtonEllipse);
		this.add(jToggleButtonCercle);
		this.add(jToggleButtonSelectionner);
		this.add(jToggleButtonEtoile);

		buttonGroup.add(jToggleButtonLigne);
		buttonGroup.add(jToggleButtonEllipse);
		buttonGroup.add(jToggleButtonCercle);
		buttonGroup.add(jToggleButtonSelectionner);
		buttonGroup.add(jToggleButtonEtoile);

		// BOUTON CHOISIR COULEUR :

		ActionChoisirCouleur actionChoisirCouleur = new ActionChoisirCouleur(this.panneauDessin);
		JButton bouttonChoisirCouleur = new JButton(actionChoisirCouleur);
		bouttonChoisirCouleur.setName(ActionChoisirCouleur.NOM_ACTION);
		this.add(bouttonChoisirCouleur);

		// CHECKBOX CHOISIR REMPLISSAGE:

		ActionChoisirRemplissage actionChoisirRemplissage = new ActionChoisirRemplissage(this.panneauDessin);
		JCheckBox checkBoxChoisirRemplissage = new JCheckBox(actionChoisirRemplissage);
		checkBoxChoisirRemplissage.setName(ActionChoisirRemplissage.NOM_ACTION);
		this.add(checkBoxChoisirRemplissage);

		// ETOILE

		JLabel labelBranche = new JLabel(BRANCHE_SPINNER_NOM);
		this.valueBranche = new SpinnerNumberModel(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 3, 15, 1);
		JSpinner spinnerBranche = new JSpinner(valueBranche);
		spinnerBranche.setName(BRANCHE_SPINNER_NOM);
		this.add(labelBranche);
		this.add(spinnerBranche);

		JLabel labelLongueur = new JLabel(LONGUEUR_SPINNER_NOM);
		this.valueLongueur = new SpinnerNumberModel(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, 0.00, 1.00, 0.01);
		JSpinner spinnerLongueur = new JSpinner(valueLongueur);
		spinnerLongueur.setName(LONGUEUR_SPINNER_NOM);
		this.add(labelLongueur);
		this.add(spinnerLongueur);

		// OUVRIR SVG :

		ActionOuvrir actionOuvrir = new ActionOuvrir(this.panneauDessin);
		JButton bouttonOuvrir = new JButton(actionOuvrir);
		bouttonOuvrir.setName(ActionOuvrir.NOM_ACTION);
		this.add(bouttonOuvrir);

		// ENREGISTRER SVG
		ActionEnregistrer actionEnregistrer = new ActionEnregistrer(this.panneauDessin);
		JButton bouttonEnregistrer = new JButton(actionEnregistrer);
		bouttonEnregistrer.setName(ActionEnregistrer.NOM_ACTION);
		this.add(bouttonEnregistrer);

	}

	public int getNbBranches() {
		int valeurNbBranche = (int) this.valueBranche.getValue();
		return valeurNbBranche;
	}

	public double getLongueurBranche() {
		double valeurLongueurBranche = (double) this.valueLongueur.getValue();
		return valeurLongueurBranche;

	}
}
