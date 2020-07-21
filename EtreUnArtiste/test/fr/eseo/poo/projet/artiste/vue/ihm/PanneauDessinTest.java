package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Dimension;


import org.junit.Test;

public class PanneauDessinTest {

	public PanneauDessinTest() {
		testConstructeurParDefaut(); 
		testConstructeur(); 
	}

	@Test
	private void testConstructeurParDefaut() {
		JFrame maFenetre = new JFrame("Etre un Artiste");
		PanneauDessin panneauDessin = new PanneauDessin();

		
		maFenetre.setPreferredSize(new Dimension(1200,600));
		maFenetre.pack();
		maFenetre.setVisible(true);
		maFenetre.setLocationRelativeTo(null);
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		maFenetre.add(panneauDessin);

		
	

	}
	
	@Test
	private void testConstructeur() {
		JFrame maFenetre = new JFrame("Blues du Businessman");
		PanneauDessin panneauDessin = new PanneauDessin(600,500,Color.BLACK);
		maFenetre.setPreferredSize(new Dimension(600, 300));
		
		maFenetre.pack();
		maFenetre.setVisible(true);
		maFenetre.setLocationRelativeTo(null);
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		maFenetre.add(panneauDessin);

	}
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new PanneauDessinTest();		
			}

		});
	}
}
