package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;
import java.awt.event.ActionEvent;

public class ActionEffacer extends AbstractAction {

	public static final String NOM_ACTION = "Effacer Tout";
	private PanneauDessin panneauDessin = new PanneauDessin();

	public ActionEffacer(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	public void actionPerformed(ActionEvent event) {

		int input = JOptionPane.showConfirmDialog(panneauDessin, "Souhaitez-vous effacer toutes les formes?",
				NOM_ACTION, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (input == JOptionPane.YES_OPTION) {
			panneauDessin.getVueFormes().clear();
			panneauDessin.repaint();

		} else if (input == JOptionPane.NO_OPTION) {
			System.out.println("Non");

		} else if (input == JOptionPane.CLOSED_OPTION) {
			System.out.println("Fermeture de la fenêtre");
		}
	}

}
