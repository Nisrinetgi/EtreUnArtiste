package fr.eseo.poo.projet.artiste.controleur.outils;
import javax.swing.JFrame;

import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilCercleTest {

	public OutilCercleTest() {
		testOutilCercle();
	}

	@Test
	private void testOutilCercle() {
		JFrame maFenetre = new JFrame("Etre un Artiste - OutilCercleTest");
		PanneauDessin panneauDessin = new PanneauDessin();
		OutilCercle outilCercle = new OutilCercle();

		panneauDessin.associerOutil(outilCercle);

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
				new OutilCercleTest();
			}
		});
	}
}