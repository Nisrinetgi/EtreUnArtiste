package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import java.awt.Color;

import javax.swing.UIManager;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EllipseTest {
	private static final double EPSILON = 0.001;

	@Test
	public void testConstructeurVide() {
		Ellipse ellipse = new Ellipse();

		assertEquals(new Coordonnees(), ellipse.getPosition());
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, ellipse.getLargeur(), EPSILON);
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, ellipse.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurUnP() {
		Ellipse ellipse = new Ellipse(new Coordonnees(2, 200));
		assertEquals(2, ellipse.getPosition().getAbscisse(), EPSILON);
		assertEquals(200, ellipse.getPosition().getOrdonnee(), EPSILON);
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, ellipse.getLargeur(), EPSILON);
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, ellipse.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurDeuxP() {
		Ellipse ellipse = new Ellipse(100, 50);
		assertEquals(new Coordonnees(), ellipse.getPosition());
		assertEquals(100, ellipse.getLargeur(), EPSILON);
		assertEquals(50, ellipse.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurTroisP() {
		Ellipse ellipse = new Ellipse(new Coordonnees(2, 200), 100, 50);
		assertEquals(new Coordonnees(2, 200), ellipse.getPosition());
		assertEquals(100, ellipse.getLargeur(), EPSILON);
		assertEquals(50, ellipse.getHauteur(), EPSILON);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurOneException() {
		Ellipse ellipse = new Ellipse(new Coordonnees(2, 200), -100, 50);
		ellipse.setHauteur(80);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurTwoException() {
		Ellipse ellipse = new Ellipse(new Coordonnees(2, 200), 100, -50);
		ellipse.setHauteur(80);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurTroisException() {
		Ellipse ellipse = new Ellipse(new Coordonnees(2, 200), -100, -50);
		ellipse.setHauteur(80);
	}

	@Test
	public void testsetHauteur() {
		Ellipse ellipse = new Ellipse(new Coordonnees(2, 200), 100, 50);
		ellipse.setHauteur(80);
		assertEquals("Erreur Hauteur", 80, ellipse.getHauteur(), EPSILON);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testsetHauteurException() {
		Ellipse ellipse = new Ellipse(new Coordonnees(2, 200), 100, 50);
		ellipse.setHauteur(-80);
	}

	@Test
	public void testsetLargeur() {
		Ellipse ellipse = new Ellipse(new Coordonnees(2, 200), 100, 50);
		ellipse.setLargeur(93);
		assertEquals("Erreur Largeur", 93, ellipse.getLargeur(), EPSILON);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testsetLargeurException() {
		Ellipse ellipse = new Ellipse(new Coordonnees(2, 200), 100, 50);
		ellipse.setHauteur(-33.1234);
	}

	@Test
	public void testAire() {
		Ellipse ellipse = new Ellipse(new Coordonnees(2, 200), 100, 50);
		assertEquals("Erreur Aire", 3926.99, ellipse.aire(), EPSILON);
	}

	@Test
	public void testPerimetreLargSup() {
		Ellipse ellipse = new Ellipse(new Coordonnees(2, 200), 100, 50);
		assertEquals("Erreur Perimetre", 242.2112, ellipse.perimetre(), EPSILON);
	}

	@Test
	public void testPerimetreHautSup() {
		Ellipse ellipse = new Ellipse(new Coordonnees(2, 200), 50, 100);
		assertEquals("Erreur Perimetre", 242.2112, ellipse.perimetre(), EPSILON);
	}

	@Test
	public void testToString() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
		assertEquals("Erreur ToString",
				 "[Ellipse] : pos (10.0 , 10.0) dim 25,0 x 15,0 périmètre : 63,82 aire : 294,52 couleur = R0,V0,B0", ellipse.toString());

		ellipse.setRempli(true);
		assertEquals("Erreur ToString",
				"[Ellipse-Rempli] : pos (10.0 , 10.0) dim 25,0 x 15,0 périmètre : 63,82 aire : 294,52 couleur = R0,V0,B0",
				ellipse.toString());

	}

	@Test
	public void testContientSurface() {
		Ellipse ellipse = new Ellipse(new Coordonnees(25, 200), 100, 50);
		assertTrue(ellipse.contient(new Coordonnees(25, 225)));
	}

	@Test
	public void testContientInterieur() {
		Ellipse ellipse = new Ellipse(new Coordonnees(25, 200), 100, 50);
		assertTrue(ellipse.contient(new Coordonnees(75, 225)));
	}

	@Test
	public void testContientPas() {
		Ellipse ellipse = new Ellipse(new Coordonnees(25, 200), 100, 50);
		assertFalse(ellipse.contient(new Coordonnees(125, 250)));
	}

	@Test
	public void testRemplissage() {
		Ellipse ellipse = new Ellipse();
		assertFalse(ellipse.estRempli());
		ellipse.setRempli(true);
		assertTrue(ellipse.estRempli());

	}
	
	@Test
	public void testGetCouleur() {
		Ellipse ellipse = new Ellipse();
		 Color couleurDefaut = UIManager.getColor("Panel.foreground"); 
		assertEquals(couleurDefaut, ellipse.getCouleur());

	}

	@Test
	public void testSetCouleur() {
		Ellipse ellipse = new Ellipse();
		ellipse.setCouleur(Color.BLUE);
		assertEquals(Color.BLUE, ellipse.getCouleur());
		

	}
}
