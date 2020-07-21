package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleurTest {
	
	public ActionChoisirCouleurTest() {
			testActionChoisirCouleur();
		}

		@Test
		private void testActionChoisirCouleur() {
			JFrame maFenetre = new JFrame("Etre un Artiste - ActionChoisirCouleurTest");
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
					new ActionChoisirCouleurTest();
				}
			});
		}

	}
