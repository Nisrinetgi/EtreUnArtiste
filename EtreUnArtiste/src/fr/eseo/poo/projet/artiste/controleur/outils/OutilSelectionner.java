package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilSelectionner extends Outil {

	private Forme formeSelectionnee;

	public OutilSelectionner() {
		super();
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		super.mouseClicked(event);
		Coordonnees pointClic = new Coordonnees(event.getX(), event.getY());

		for (VueForme formePanneauDessin : super.getPanneauDessin().getVueFormes()) {
			if (formePanneauDessin.getForme().contient(pointClic)) {
				this.formeSelectionnee = formePanneauDessin.getForme();
			}
		}
		JOptionPane.showMessageDialog(getPanneauDessin(), formeSelectionnee.toString(), ActionSelectionner.NOM_ACTION,
				JOptionPane.INFORMATION_MESSAGE);
	}
}
