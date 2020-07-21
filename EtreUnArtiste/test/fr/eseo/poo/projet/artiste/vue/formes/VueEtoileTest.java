package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEtoileTest {

	public VueEtoileTest() {
		testConstructeurParDefaut();
	}

	@Test
	private void testConstructeurParDefaut() {
		JFrame maFenetre = new JFrame("Etre un Artiste");
		PanneauDessin panneauDessin = new PanneauDessin();

		VueEtoile vueEtoile1 = new VueEtoile(new Etoile());
		VueEtoile vueEtoile2 = new VueEtoile(new Etoile(new Coordonnees(20, 50)));
		VueEtoile vueEtoile3 = new VueEtoile(new Etoile(30));
		VueEtoile vueEtoile4 = new VueEtoile(new Etoile(new Coordonnees(200, 300), 20));
		VueEtoile vueEtoile5 = new VueEtoile(new Etoile(new Coordonnees(100, 200), 50, 14, Math.PI / 2, 0.75));

		maFenetre.add(panneauDessin);
		
		panneauDessin.ajouterVueForme(vueEtoile1);
		panneauDessin.ajouterVueForme(vueEtoile2);
		panneauDessin.ajouterVueForme(vueEtoile3);
		panneauDessin.ajouterVueForme(vueEtoile4);
		panneauDessin.ajouterVueForme(vueEtoile5);

		maFenetre.pack();
		maFenetre.setVisible(true);
		maFenetre.setLocationRelativeTo(null);
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueEtoileTest();
			}
		});
	}
}
