package fr.eseo.poo.projet.artiste.vue.formes;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;
public class VueLigneTest {

	public VueLigneTest() {
		testConstructeurParDefaut(); 
	}

	@Test
	private void testConstructeurParDefaut() {
		JFrame maFenetre = new JFrame("Etre un Artiste");
		PanneauDessin panneauDessin = new PanneauDessin();
		
		VueLigne vueligne1 = new VueLigne(new Ligne());
		VueLigne vueligne2 = new VueLigne(new Ligne(90, 200));
		VueLigne vueligne3 = new VueLigne(new Ligne(new Coordonnees(50,50)));
		VueLigne vueligne4 = new VueLigne(new Ligne(new Coordonnees(77,177), 156, -100));
		
		maFenetre.setPreferredSize(new Dimension(1200,600));
		maFenetre.pack();
		maFenetre.setVisible(true);
		maFenetre.setLocationRelativeTo(null);
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		maFenetre.add(panneauDessin);
		panneauDessin.ajouterVueForme(vueligne1);
		panneauDessin.ajouterVueForme(vueligne2);
		panneauDessin.ajouterVueForme(vueligne3);
		panneauDessin.ajouterVueForme(vueligne4);
		maFenetre.pack();
		maFenetre.setVisible(true);
		

	}
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueLigneTest();		
			}
		});
	}
}



