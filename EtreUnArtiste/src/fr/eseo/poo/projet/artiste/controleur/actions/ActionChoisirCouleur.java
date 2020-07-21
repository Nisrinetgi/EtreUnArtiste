package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleur extends AbstractAction {
	
	public static final String NOM_ACTION = "Couleur"; 
	private PanneauDessin panneauDessin = new PanneauDessin(); 
	
	public ActionChoisirCouleur(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin; 
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Color nouvelleCouleur= JColorChooser.showDialog(this.panneauDessin, NOM_ACTION, panneauDessin.getCouleurCourante()); 
		if (nouvelleCouleur!= null) {
		    panneauDessin.setCouleurCourante(nouvelleCouleur); 
		}
	
	}
	
}
