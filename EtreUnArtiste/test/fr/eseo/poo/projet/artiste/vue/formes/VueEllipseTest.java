package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEllipseTest {

	public VueEllipseTest() {
		testConstructeurParDefaut();
	}

	@Test
	private void testConstructeurParDefaut() {
		JFrame maFenetre = new JFrame("Etre un Artiste");
		PanneauDessin panneauDessin = new PanneauDessin();
		VueEllipse vueEllipse1 = new VueEllipse(new Ellipse());
		VueEllipse vueEllipse2 = new VueEllipse(new Ellipse(new Coordonnees(700, 900)));
		VueEllipse vueEllipse3 = new VueEllipse(new Ellipse(133, 66));
		VueEllipse vueEllipse4 = new VueEllipse(new Ellipse(new Coordonnees(400,800), 900, 500));
		
		maFenetre.setPreferredSize(new Dimension(1200, 600));
		maFenetre.pack();
		maFenetre.setVisible(true);
		maFenetre.setLocationRelativeTo(null);
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		maFenetre.add(panneauDessin);

		panneauDessin.ajouterVueForme(vueEllipse1);
		panneauDessin.ajouterVueForme(vueEllipse2);
		panneauDessin.ajouterVueForme(vueEllipse3);
		panneauDessin.ajouterVueForme(vueEllipse4);
		
		maFenetre.pack();
		maFenetre.setVisible(true);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueEllipseTest();
			}
		});
	}
}
