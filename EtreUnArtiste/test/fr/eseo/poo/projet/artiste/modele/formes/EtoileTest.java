package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EtoileTest {

	private static final double EPSILON = 0.001;
//
//	// Test Constructeurs :
//
//	@Test
//	public void testConstructeurVide() {
//		Etoile etoile = new Etoile();
//		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT, etoile.getPosition().getAbscisse(), EPSILON);
//		assertEquals(Coordonnees.ORDONNEE_PAR_DEFAUT, etoile.getPosition().getOrdonnee(), EPSILON);
//		assertEquals(Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, etoile.getAnglePremiereBranche(), EPSILON);
//		assertEquals(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, etoile.getLongueurBranche(), EPSILON);
//		assertEquals(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, etoile.getNombreBranches(), EPSILON);
//	}
//
//	@Test
//	public void testConstructeurCoordonnee() {
//		Etoile etoile = new Etoile(new Coordonnees(50, 80));
//		assertEquals(50, etoile.getPosition().getAbscisse(), EPSILON);
//		assertEquals(80, etoile.getPosition().getOrdonnee(), EPSILON);
//	}
//
//	@Test
//	public void testConstructeurTaille() {
//		Etoile etoile = new Etoile(90);
//		assertEquals(90, etoile.getLargeur(), EPSILON);
//		assertEquals(90, etoile.getHauteur(), EPSILON);
//	}
//
//	@Test
//	public void testConstructeurCoordonneeTaille() {
//		Etoile etoile = new Etoile(new Coordonnees(15, 10), 45);
//		assertEquals(15, etoile.getPosition().getAbscisse(), EPSILON);
//		assertEquals(10, etoile.getPosition().getOrdonnee(), EPSILON);
//		assertEquals(45, etoile.getLargeur(), EPSILON);
//	}
//
//	@Test
//	public void testConstructeurToutParamametre() {
//		Etoile etoile = new Etoile(new Coordonnees(50, 80), 15, 10, Math.PI / 2, 0.70);
//		assertEquals(50, etoile.getPosition().getAbscisse(), EPSILON);
//		assertEquals(80, etoile.getPosition().getOrdonnee(), EPSILON);
//		assertEquals(10, etoile.getNombreBranches(), EPSILON);
//		assertEquals(15, etoile.getLargeur(), EPSILON);
//		assertEquals(Math.PI/2, etoile.getAnglePremiereBranche(), EPSILON);
//		assertEquals(0.70, etoile.getLongueurBranche(), EPSILON);
//
//	}
//
//	@Test(expected = IllegalArgumentException.class)
//	public void testConstructeurCoordonneeTailleException() {
//		new Etoile(new Coordonnees(20, 30), -10);
//	}
//
//	@Test(expected = IllegalArgumentException.class)
//	public void testConstructeurToutParametreExceptionAngle() {
//		new Etoile(new Coordonnees(50, 80), 15, 10, -3 * Math.PI / 2, 0.70);
//	}
//
//	@Test(expected = IllegalArgumentException.class)
//	public void testConstructeurToutParametreException() {
//		new Etoile(new Coordonnees(50, 80), 15, 10, Math.PI / 2, 1.5);
//	}
//
//	@Test
//	public void testsetHauteur() {
//		Etoile etoile = new Etoile(new Coordonnees(50, 80), 15, 10, Math.PI / 2, 0.70);
//		etoile.setHauteur(30);
//		assertEquals(30, etoile.getHauteur(), EPSILON);
//		assertEquals(30, etoile.getLargeur(), EPSILON);
//	}
//
//	@Test
//	public void testSetLargeur() {
//		Etoile etoile = new Etoile(new Coordonnees(50, 80), 15, 10, Math.PI / 2, 0.70);
//		etoile.setLargeur(30);
//		assertEquals(30, etoile.getLargeur(), EPSILON);
//		assertEquals(30, etoile.getHauteur(), EPSILON);
//	}
//
//	@Test
//	public void testSetPosition() {
//		Etoile etoile = new Etoile(new Coordonnees(60, 80), 15, 10, Math.PI / 2, 0.70);
//		etoile.setPosition(new Coordonnees(50, 50));
//		assertEquals(50, etoile.getPosition().getAbscisse(), EPSILON);
//		assertEquals(50, etoile.getPosition().getOrdonnee(), EPSILON);
//	}

	@Test
	public void testSetNombreBranches() {
		Etoile etoile = new Etoile(new Coordonnees(), 10, 4, Math.PI / 2, 0.5);

		assertEquals(4, etoile.getNombreBranches(), EPSILON);
		
		// TEST POUR TROUVER ERREUR CONTIENT : 
//		assertEquals("Erreur ToString", "[Etoile] : pos (0.0 , 0.0) dim 10,0 x 10,0 périmètre : 29,47 aire : 35,36 couleur = R0,V0,B0",
//				etoile.toString());
//		
//		etoile.setNombreBranches(5);
//		assertEquals(5, etoile.getNombreBranches(), EPSILON);
//		assertEquals("Erreur ToString", "[Etoile] : pos (0.0 , 0.0) dim 10,0 x 10,0 périmètre : 33,2 aire : 36,74 couleur = R0,V0,B0",
//				etoile.toString());
	}

	@Test
	public void testSetLongueurBranche() {
		Etoile etoile = new Etoile(new Coordonnees(50, 80), 15, 10, Math.PI / 2, 0.70);
		etoile.setLongueurBranche(1);
		assertEquals(1, etoile.getLongueurBranche(), EPSILON);
	}

	@Test
	public void testSetAnglePremiereBranche() {
		Etoile etoile = new Etoile(new Coordonnees(50, 80), 15, 10, Math.PI / 2, 0.70);
		etoile.setAnglePremiereBranche(0);
		assertEquals(0, etoile.getAnglePremiereBranche(), EPSILON);
	}

	@Test
	public void testGetNombreBranches() {
		Etoile etoile = new Etoile(new Coordonnees(50, 80), 15, 10, Math.PI / 2, 0.70);
		assertEquals(10, etoile.getNombreBranches(), EPSILON);
	}

	@Test
	public void testGetLongueurBranche() {
		Etoile etoile = new Etoile(new Coordonnees(50, 80), 15, 10, Math.PI / 2, 0.70);
		assertEquals(0.70, etoile.getLongueurBranche(), EPSILON);
	}

	@Test
	public void testGetAnglePremiereBranche() {
		Etoile etoile = new Etoile(new Coordonnees(50, 80), 15, 10, Math.PI / 2, 0.70);
		assertEquals(Math.PI / 2, etoile.getAnglePremiereBranche(), EPSILON);
	}

	@Test
	public void testAire() {
		Etoile etoile = new Etoile(new Coordonnees(), 10, 4, Math.PI / 2, 0.5);
		assertEquals("Erreur Aire", 35.3553, etoile.aire(), EPSILON);
	}

	@Test
	public void testPerimetre() {
		Etoile etoile = new Etoile(new Coordonnees(), 10, 4, Math.PI / 2, 0.5);
		assertEquals("Erreur Perimetre", 29.4725, etoile.perimetre(), EPSILON);
	}

	@Test
	public void testToString() {
		Etoile etoile = new Etoile(new Coordonnees(), 10, 4, Math.PI / 2, 0.5);
		assertEquals("Erreur ToString",
				"[Etoile] : pos (0.0 , 0.0) dim 10,0 x 10,0 périmètre : 29,47 aire : 35,36 couleur = R0,V0,B0",
				etoile.toString());
	}

	// TEST REMPLISSAGE
	@Test
	public void testEstRempli() {
		Etoile etoile = new Etoile(new Coordonnees(50, 80), 15, 10, Math.PI / 2, 0.70);
		assertFalse(etoile.estRempli());
	}

	@Test
	public void testEstPasRempli() {
		Etoile etoile = new Etoile(new Coordonnees(50, 80), 15, 10, Math.PI / 2, 0.70);
		etoile.setRempli(true);
		assertTrue(etoile.estRempli());
	}

	// TEST CONTIENT
	@Test
	public void testContientSurface() {
		Etoile etoile = new Etoile(new Coordonnees(50, 80), 10, 10, Math.PI / 2, 0.70);
		assertTrue(etoile.contient(new Coordonnees(50, 80)));
	}

	@Test
	public void testContientInterieur() {
		Etoile etoile = new Etoile(new Coordonnees(50, 80), 5, 3, Math.PI / 2, 0.70);
		assertTrue(etoile.contient(new Coordonnees(52.5, 87.5)));
	}

	@Test
	public void testContientPas() {
		Etoile etoile = new Etoile(new Coordonnees(50, 80), 3, 10, Math.PI / 2, 0.70);
		assertFalse("Ne contient pas ", etoile.contient(new Coordonnees(65, 95)));
	}

}
