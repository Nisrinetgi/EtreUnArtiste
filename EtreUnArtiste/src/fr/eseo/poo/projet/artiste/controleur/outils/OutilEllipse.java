package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme {

	public OutilEllipse() {
		super();
	}

	@Override
	protected VueForme creerVueForme() {
		double largeur = Math.abs(getDebut().getAbscisse() - getFin().getAbscisse());
		double hauteur = Math.abs(getDebut().getOrdonnee() - getFin().getOrdonnee());
		
		Ellipse ellipse = new Ellipse(new Coordonnees(Math.min(getDebut().getAbscisse(), getFin().getAbscisse()),
				Math.min(getDebut().getOrdonnee(), getFin().getOrdonnee())), largeur, hauteur);
		
		ellipse.setCouleur(getPanneauDessin().getCouleurCourante());
		ellipse.setRempli(getPanneauDessin().getModeRemplissage());
		
		VueEllipse vueEllipse = new VueEllipse(ellipse);
		
		return vueEllipse;
	}
}
