package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

public class VueEtoile extends VueForme {

	public VueEtoile(Etoile etoile) {
		super(etoile);
	}
	
	public void affiche(Graphics2D g2d) {
		Color sauvegardeCcte = g2d.getColor();
		g2d.setColor(this.getForme().getCouleur());

		Etoile etoile = ((Etoile) this.getForme());

		int pointAbscisse[] = new int[etoile.getNombreBranches() * 2];
		int pointOrdonnee[] = new int[etoile.getNombreBranches() * 2];

		for (int i = 0; i < etoile.getCoordonnees().size(); i++) {
			pointAbscisse[i] = (int) Math.round(etoile.getCoordonnees().get(i).getAbscisse());
			pointOrdonnee[i] = (int) Math.round(etoile.getCoordonnees().get(i).getOrdonnee());
		}

		GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, pointAbscisse.length);
		polygon.moveTo(pointAbscisse[0], pointOrdonnee[0]);

		for (int index = 1; index < pointAbscisse.length; index++) {
			polygon.lineTo(pointAbscisse[index], pointOrdonnee[index]);
		}

		polygon.closePath();
		g2d.draw(polygon);

		if (etoile.estRempli()) {
			g2d.fill(polygon);
		}
		g2d.setColor(sauvegardeCcte);

	}
}
