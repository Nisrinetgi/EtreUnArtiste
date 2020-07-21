package fr.eseo.poo.projet.artiste.vue.formes;

public abstract class VueForme {

	protected final fr.eseo.poo.projet.artiste.modele.formes.Forme forme;

	public VueForme(fr.eseo.poo.projet.artiste.modele.formes.Forme forme){
		this.forme = forme; 
		
	}

	public fr.eseo.poo.projet.artiste.modele.formes.Forme getForme()  {
		return forme;
	}

	 public abstract void affiche(java.awt.Graphics2D g2d); 
}
