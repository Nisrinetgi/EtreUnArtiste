package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilEtoileTest {

	public OutilEtoileTest() {
		testOutilEtoile();
	}

	@Test
	private void testOutilEtoile() {
		JFrame maFenetre = new JFrame("Etre un Artiste - OutilCercleTest");
		PanneauDessin panneauDessin = new PanneauDessin();
		PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneauDessin);

	

		OutilEtoile outilEtoile = new OutilEtoile(panneauBarreOutils);

		panneauDessin.associerOutil(outilEtoile);
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
				new OutilEtoileTest();
			}
		});
	}
}
