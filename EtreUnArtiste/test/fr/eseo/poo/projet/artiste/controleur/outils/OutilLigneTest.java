package fr.eseo.poo.projet.artiste.controleur.outils;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilLigneTest {

	public OutilLigneTest() {
		testOutilLigne();
	}

	@Test
	private void testOutilLigne() {
		JFrame maFenetre = new JFrame("Etre un Artiste - OutilLigneTest");
		PanneauDessin panneauDessin = new PanneauDessin();
		OutilLigne outilLigne = new OutilLigne(); 
		
		panneauDessin.associerOutil(outilLigne);
		
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
				new OutilLigneTest();
			}
		});
	}
}