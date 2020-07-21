package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.Remplissable;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
public class VueLigne extends VueForme {

	public VueLigne(fr.eseo.poo.projet.artiste.modele.formes.Ligne ligne) {
		super(ligne); 
	}
	
	@Override
	public void affiche(Graphics2D g2d) {
	int positionX1 = (int) this.forme.getPosition().getAbscisse(); 
	int positionY1 = (int) this.forme.getPosition().getOrdonnee(); 
	int positionX2 = (int) (positionX1 + this.forme.getLargeur()); 
	int positionY2 = (int) (positionY1 + this.forme.getHauteur()); 
	
	Color sauvegardeCcte = g2d.getColor();
	
	g2d.setColor(this.getForme().getCouleur());
	g2d.drawLine( positionX1,positionY1, positionX2,positionY2);
	g2d.setColor(sauvegardeCcte);
	
	}
	
	
}
