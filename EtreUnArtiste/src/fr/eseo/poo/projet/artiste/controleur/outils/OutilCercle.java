package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilCercle extends OutilForme {
	public OutilCercle() {
		super();
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		super.mouseClicked(event);
	}

	@Override
	protected VueForme creerVueForme() {
	
		double taille = Math.max(Math.abs(getFin().getAbscisse() - getDebut().getAbscisse()),
				Math.abs(getFin().getOrdonnee() - getDebut().getOrdonnee()));
		
		double coordAb;
		double coordOrd;
		
		if (getFin().getAbscisse() > getDebut().getAbscisse()) {
			coordAb = getDebut().getAbscisse();
		} else {
			coordAb = getDebut().getAbscisse() - taille;
		}

		if (getFin().getOrdonnee() > getDebut().getOrdonnee()) {
			coordOrd = getDebut().getOrdonnee();
		} else {
			coordOrd = getDebut().getOrdonnee() - taille;
		}

		Cercle cercle = new Cercle(new Coordonnees(coordAb, coordOrd), taille);
		cercle.setCouleur(getPanneauDessin().getCouleurCourante());
		cercle.setRempli(getPanneauDessin().getModeRemplissage());
		VueForme vueCercle = new VueCercle(cercle);
		return vueCercle;

	}
}
