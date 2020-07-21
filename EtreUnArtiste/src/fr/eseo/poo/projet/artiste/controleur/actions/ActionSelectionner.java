package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionSelectionner extends AbstractAction {
	
	
	public static final String NOM_ACTION = "Sélectionner";
	private PanneauDessin panneauDessin;

	public ActionSelectionner(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == NOM_ACTION) {
			this.panneauDessin.associerOutil(new OutilSelectionner());
		}
	}
}
