package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Debugger {
	private static final double EPSILON = 0.001;
	public static void main(String[] args) {
	

		Etoile etoile = new Etoile(new Coordonnees(10, 10), 10, 4, Math.PI / 2, 0.5);

		assertEquals("Erreur ToString",
				"[Etoile] : pos (0.0 , 0.0) dim 10,0 x 10,0 périmètre : 29,47 aire : 35,36 couleur = R0,V0,B0",
				etoile.toString());

		etoile.setNombreBranches(5);
		assertEquals(5, etoile.getNombreBranches(), EPSILON);
		assertEquals("Erreur ToString",
				"[Etoile] : pos (0.0 , 0.0) dim 10,0 x 10,0 périmètre : 33,2 aire : 36,74 couleur = R0,V0,B0",
				etoile.toString());
	}
}
