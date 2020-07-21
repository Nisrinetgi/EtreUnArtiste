package fr.eseo.poo.projet.artiste.vue.formes;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest {

	public VueCercleTest() {
		testConstructeurParDefaut();
	}
	
	@Test
	private void testConstructeurParDefaut() {
		JFrame maFenetre = new JFrame("Etre un Artiste");
		PanneauDessin panneauDessin = new PanneauDessin();
		VueEllipse vueCercle1 = new VueEllipse(new Cercle());
		VueEllipse vueCercle2 = new VueEllipse(new Cercle(new Coordonnees()));
		VueEllipse vueCercle3 = new VueEllipse(new Cercle(50));
		VueEllipse vueCercle4 = new VueEllipse(new Cercle(new Coordonnees(300,600),90)); 
		
		maFenetre.setPreferredSize(new Dimension(1200, 600));
		maFenetre.pack();
		maFenetre.setVisible(true);
		maFenetre.setLocationRelativeTo(null);
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		maFenetre.add(panneauDessin);

		panneauDessin.ajouterVueForme(vueCercle1);
		panneauDessin.ajouterVueForme(vueCercle2);
		panneauDessin.ajouterVueForme(vueCercle3);
		panneauDessin.ajouterVueForme(vueCercle4);
		
		maFenetre.pack();
		maFenetre.setVisible(true);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueCercleTest();
			}
		});
	}
}