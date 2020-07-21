package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.junit.Test;

public class PanneauBarreOutilsTest {

	public PanneauBarreOutilsTest() {
		testActionEffacer();
	}

	@Test
	private void testActionEffacer() {
		JFrame maFenetre = new JFrame("Etre un Artiste - PanneauBarreOutilsTest");
		PanneauDessin panneauDessin = new PanneauDessin();
		PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneauDessin);
		
		maFenetre.add(panneauBarreOutils, BorderLayout.EAST);
		maFenetre.add(panneauDessin);
		maFenetre.pack();
		maFenetre.setVisible(true);
		maFenetre.setLocationRelativeTo(null);
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PanneauBarreOutilsTest();
			}
		});
	}

}
