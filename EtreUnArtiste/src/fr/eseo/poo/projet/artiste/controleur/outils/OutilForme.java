package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public abstract class OutilForme extends Outil {
	@Override
		public void mousePressed(MouseEvent event) {
			super.mousePressed(event);
		}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getClickCount() == 2) {
			super.mouseClicked(event);
		
			double largeur = Forme.LARGEUR_PAR_DEFAUT;
			double hauteur = Forme.HAUTEUR_PAR_DEFAUT;
			
			super.setDebut(new Coordonnees(event.getX(), event.getY()));
			super.setFin(new Coordonnees(event.getX() + largeur, event.getY() + hauteur));
			super.getPanneauDessin().ajouterVueForme(creerVueForme());
			super.getPanneauDessin().repaint(); 
		}

	}

	public void mouseReleased(MouseEvent event) {
		super.mouseReleased(event);
		if ((this.getDebut().getAbscisse() != this.getFin().getAbscisse())||
				(this.getDebut().getOrdonnee()) != this.getFin().getOrdonnee()) {
			
			super.getPanneauDessin().ajouterVueForme(creerVueForme());
			super.getPanneauDessin().repaint();
		} 
	}

	

	protected abstract VueForme creerVueForme();
}
