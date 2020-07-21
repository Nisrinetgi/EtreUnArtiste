package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;

public class VueEllipse extends VueForme {

	public VueEllipse(Ellipse ellipse) {
		super(ellipse);
	}

	public void affiche(java.awt.Graphics2D g2d) {
		Color sauvegardeCcte = g2d.getColor();
		g2d.setColor(this.getForme().getCouleur());

		int abscisse = (int) Math.round(this.getForme().getPosition().getAbscisse());
		int ordonnee = (int) Math.round(this.getForme().getPosition().getOrdonnee());

		int largeur = (int) Math.round(this.getForme().getLargeur());
		int hauteur = (int) Math.round(this.getForme().getHauteur());
		
		g2d.drawOval(abscisse, ordonnee, largeur, hauteur);
		
		if (((Ellipse) this.getForme()).estRempli()) {
			g2d.fillOval(abscisse, ordonnee, largeur, hauteur);
		}
		
		g2d.setColor(sauvegardeCcte);

	}
}
