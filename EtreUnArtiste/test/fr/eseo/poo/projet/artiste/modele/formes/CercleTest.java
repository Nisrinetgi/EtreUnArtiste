package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import java.awt.Color;

import javax.swing.UIManager;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CercleTest {
	private static final double EPSILON = 0.001;
	
	@Test
	public void testConstructeurVide() {
		Cercle cercle = new Cercle();
		assertEquals(new Coordonnees(), cercle.getPosition());
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, cercle.getLargeur(), EPSILON);
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, cercle.getHauteur(), EPSILON);
	}
	
	@Test
	public void testConstructeurUnPDouble() {
		Cercle cercle = new Cercle(25);
		assertEquals(new Coordonnees(0,0), cercle.getPosition());
		assertEquals(25, cercle.getLargeur(), EPSILON);
		assertEquals(25, cercle.getHauteur(), EPSILON);
	}
	
	@Test
	public void testConstructeurUnPCoord() {
		Cercle cercle = new Cercle(new Coordonnees(10,10));
		assertEquals(new Coordonnees(10,10), cercle.getPosition());
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, cercle.getLargeur(), EPSILON);
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, cercle.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurDeuxP() {
		Cercle cercle = new Cercle(new Coordonnees(10,10),25);
		assertEquals(new Coordonnees(10,10), cercle.getPosition());
		assertEquals(25, cercle.getLargeur(), EPSILON);
		assertEquals(25, cercle.getHauteur(), EPSILON);
	}

	
	@Test
	public void testsetHauteur() {
		Cercle cercle = new Cercle(new Coordonnees(10,10),25);
		cercle.setLargeur(333);
		assertEquals("Erreur Largeur", 333, cercle.getLargeur(), EPSILON);
		assertEquals("Erreur Hauteur", 333, cercle.getHauteur(), EPSILON);
		
	}
	
	@Test
	public void testsetLargeur() {
		Cercle cercle = new Cercle(new Coordonnees(10,10),25);
		cercle.setHauteur(333);
		assertEquals("Erreur Hauteur", 333, cercle.getHauteur(), EPSILON);
		assertEquals("Erreur Largeur", 333, cercle.getLargeur(), EPSILON);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurOneException() {
		Cercle cercle = new Cercle(new Coordonnees(10,10),-25);
		cercle.setLargeur(80);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetTailleException() {
		Cercle cercle = new Cercle(new Coordonnees(10,10),25);
		cercle.setLargeur(-80);
	}

	
	@Test
	public void testAire() {
		Cercle cercle = new Cercle(new Coordonnees(10,10),25);
		assertEquals("Erreur Perimetre", 490.8738, cercle.aire(), EPSILON);
	}
	
	@Test
	public void testPerimetre() {
		Cercle cercle = new Cercle(new Coordonnees(10,10),25);
		assertEquals("Erreur Perimetre", 78.54, cercle.perimetre(), EPSILON);
	}
	
	@Test
	public void testToString() {
		Cercle cercle = new Cercle(new Coordonnees(10,10),25);
		assertEquals("Erreur ToString","[Cercle] : pos (10.0 , 10.0) dim 25,0 x 25,0 périmètre : 78,54 aire : 490,87 couleur = R0,V0,B0"
				,cercle.toString());
		
		cercle.setRempli(true);
		assertEquals("Erreur ToString","[Cercle-Rempli] : pos (10.0 , 10.0) dim 25,0 x 25,0 périmètre : 78,54 aire : 490,87 couleur = R0,V0,B0"
				,cercle.toString());
	
	}
	
	@Test
	public void testContientSurface() {
		Cercle cercle = new Cercle(new Coordonnees(128,78),40);
		assertTrue(cercle.contient(new Coordonnees (128,98)));
	}
	
	@Test
	public void testContientInterieur() {
		Cercle cercle = new Cercle(new Coordonnees(128,78),40);
		assertTrue(cercle.contient(new Coordonnees (142,98)));
	}
	
	@Test
	public void testContientPas() {
		Cercle cercle = new Cercle(new Coordonnees(128,78),40);
		assertFalse(cercle.contient(new Coordonnees (162,118)));
	}
	
	@Test
	public void testRemplissage() {
		Cercle cercle = new Cercle();
		assertFalse(cercle.estRempli());
		cercle.setRempli(true);
		assertTrue(cercle.estRempli());
	}
	
	@Test
	public void testGetCouleur() {
		Cercle cercle = new Cercle();
		 Color couleurDefaut = UIManager.getColor("Panel.foreground"); 
		assertEquals(couleurDefaut, cercle.getCouleur());
	}

	@Test
	public void testSetCouleur() {
		Cercle cercle = new Cercle();
		cercle.setCouleur(Color.BLUE);
		assertEquals(Color.BLUE, cercle.getCouleur());
	}
	
	
}