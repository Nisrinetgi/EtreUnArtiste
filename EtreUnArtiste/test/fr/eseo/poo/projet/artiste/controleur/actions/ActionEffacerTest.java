package fr.eseo.poo.projet.artiste.controleur.actions;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionEffacerTest {

	public ActionEffacerTest() {
		testActionEffacer();
	}

	@Test
	private void testActionEffacer() {
		JFrame maFenetre = new JFrame("Etre un Artiste - ActionEffacerTest");
		PanneauDessin panneauDessin = new PanneauDessin();
		PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneauDessin);
		OutilLigne outilLigne = new OutilLigne(); 
		
		maFenetre.add(panneauBarreOutils, BorderLayout.EAST);
		panneauDessin.associerOutil(outilLigne);
		
		maFenetre.setPreferredSize(new Dimension(1200, 550));
		maFenetre.add(panneauDessin);
		
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		maFenetre.pack();
		maFenetre.setLocationRelativeTo(null);
		maFenetre.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ActionEffacerTest();
			}
		});
	}

}
