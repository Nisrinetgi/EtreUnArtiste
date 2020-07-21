package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public abstract class Outil implements MouseInputListener {
	
	private PanneauDessin panneauDessin;
	private Coordonnees debut;
	private Coordonnees fin;

	public Coordonnees getDebut() {
		return debut;
	}

	public void setDebut(Coordonnees coordonnees) {
		this.debut = coordonnees;
	}

	public Coordonnees getFin() {
		return fin;
	}

	public void setFin(Coordonnees coordonnees) {
		this.fin = coordonnees; 
	}

	public PanneauDessin getPanneauDessin() {
		return panneauDessin;
	}

	public void setPanneauDessin(PanneauDessin panneau) {
		this.panneauDessin = panneau;
	}

	/**
	 * Methodes issues de l'interface MouseListener :
	 */

	@Override
	public void mouseClicked(MouseEvent event) {
	}

	
	@Override
	public void mousePressed(MouseEvent event) {
		
		setDebut(new Coordonnees(event.getX(), event.getY()));
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		
		setFin(new Coordonnees(event.getX(), event.getY()));
	}

	@Override
	public void mouseEntered(MouseEvent event) {
	}

	@Override
	public void mouseExited(MouseEvent event) {
	}

	/**
	 * Méthodes issues de l'interface MouseMotionListener :
	 */

	@Override
	public void mouseDragged(MouseEvent event) {

	}

	@Override
	public void mouseMoved(MouseEvent event) {

	}

}
