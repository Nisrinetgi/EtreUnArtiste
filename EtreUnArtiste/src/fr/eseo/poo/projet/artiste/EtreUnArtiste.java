package fr.eseo.poo.projet.artiste;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class EtreUnArtiste {
	
	public static void main(String[] args) {
		
		JFrame maFenetre = new JFrame("Etre Un Artiste");
		PanneauDessin panneauDessin = new PanneauDessin();
		PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneauDessin); 
		
		maFenetre.add(panneauBarreOutils, BorderLayout.EAST);

		maFenetre.add(panneauDessin);
		maFenetre.pack();
		maFenetre.setVisible(true);
		maFenetre.setLocationRelativeTo(null);
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}
