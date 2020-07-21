package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import java.awt.Color;

import javax.swing.UIManager;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import org.junit.Test;

public class LigneTest {
	private static final double EPSILON = 0.001;
	// TEST CONSTRUCTEUR : 
	
	@Test
	public void testConstructeurVide() {
		Ligne ligne = new Ligne();
		assertEquals(0, ligne.getC1().getAbscisse(), EPSILON);
		assertEquals(0, ligne.getC1().getOrdonnee(), EPSILON);
		assertEquals(175, ligne.getLargeur(), EPSILON);
		assertEquals(100, ligne.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurDeuxP() {
		Ligne ligne = new Ligne(-5, 20);
		assertEquals(0, ligne.getC1().getAbscisse(), EPSILON);
		assertEquals(0, ligne.getC1().getOrdonnee(), EPSILON);
		assertEquals(-5, ligne.getLargeur(), EPSILON);
		assertEquals(20, ligne.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurTroisP() {
		Ligne ligne = new Ligne(new Coordonnees(10, 10), -5, 20);
		assertEquals(10, ligne.getC1().getAbscisse(), EPSILON);
		assertEquals(10, ligne.getC1().getOrdonnee(), EPSILON);
		assertEquals(-5, ligne.getLargeur(), EPSILON);
		assertEquals(20, ligne.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurUnP() {
		Ligne ligne = new Ligne(new Coordonnees(10, 10));
		assertEquals(10, ligne.getC1().getAbscisse(), EPSILON);
		assertEquals(10, ligne.getC1().getOrdonnee(), EPSILON);
		assertEquals(175, ligne.getLargeur(), EPSILON);
		assertEquals(100, ligne.getHauteur(), EPSILON);
	}

	// Test AIRE : 
	@Test
	public void testAire() {
		Ligne P1 = new Ligne(50, 50);
		assertEquals("Erreur Aire", 0, P1.aire(), EPSILON);
	}

	// Test PERIMETRE : 
	@Test
	public void testPerimetre() {
		Ligne L1 = new Ligne(new Coordonnees(77, 177), 156, -100);
		assertEquals("Erreur Perimetre", 185.2997, L1.perimetre(), EPSILON);
	}

	@Test
	public void testPerimetreTwo() { // remarque que 20.61.... alors que sur sujet 20.62
		// avec le premier perimetre c'est ok car il fait le passage de
		// 185.29975715040752 à 185.3 Automatiquement
		Ligne L1 = new Ligne(new Coordonnees(10, 10), -5, 20);
		assertEquals("Erreur Perimetre", 20.6155, L1.perimetre(), EPSILON);
	}

	// Test TOSTRING() :
	@Test
	public void testToStringOne() {
		Ligne L1 = new Ligne(new Coordonnees(77, 177), 156, -100);
		assertEquals("Erreur ToString",
				"[Ligne] c1 : (77.0 , 177.0) c2 : (233.0 , 77.0) longueur : 185,3 angle : 327,34° couleur = R0,V0,B0", L1.toString());
	}

	@Test
	public void testToStringTwo() {
		Ligne L1 = new Ligne(new Coordonnees(10, 10), -5, 20);
		assertEquals("Erreur ToString", "[Ligne] c1 : (10.0 , 10.0) c2 : (5.0 , 30.0) longueur : 20,62 angle : 104,04° couleur = R0,V0,B0",
				L1.toString());
	}

	// TEST GetC1() :
	@Test
	public void testGetC1() {
		Ligne L1 = new Ligne(new Coordonnees(10, 10), -5, 20);
		assertEquals("", new Coordonnees(10, 10), L1.getC1());
	}

	@Test
	public void testGetC1Two() {
		Ligne L1 = new Ligne(new Coordonnees(77, 177), 156, -100);
		assertEquals("", new Coordonnees(77, 177), L1.getC1());
	}

	// TEST GetC2() :

	@Test
	public void testGetC2() {
		Ligne L1 = new Ligne(new Coordonnees(10, 10), -5, 20);
		assertEquals("", new Coordonnees(5, 30), L1.getC2());
	}
	@Test
	public void testGetC2Two() {
		Ligne L1 = new Ligne(new Coordonnees(77, 177), 156, -100);
		assertEquals("", new Coordonnees(233, 77), L1.getC2());
	}

	// TEST SETC1() : verifie si C1 correct et si C2 reste inchangé

	@Test
	public void testSetC1() {
		Ligne L1 = new Ligne(new Coordonnees(77, 177), 156, -100);
		L1.setC1(new Coordonnees(20, 20));

		assertEquals("Erreur mauvaise valeur de C1", new Coordonnees(20, 20), L1.getC1());
		assertEquals("Erreur la valeur de C2 change",new Coordonnees(233, 77) , L1.getC2());
	}

	@Test
	public void testSetC1Two() {
		Ligne L1 = new Ligne(new Coordonnees(77, 177), 156, -100);
		L1.setC1(new Coordonnees(-10, -10));

		assertEquals("Erreur mauvaise valeur de C1", new Coordonnees(-10, -10), L1.getC1());
		assertEquals("Erreur la valeur de C2 change",new Coordonnees(233, 77) , L1.getC2());
	}

	// TEST de SetC2() : verifie si C2 correct et si C1 reste inchangé

	@Test
	public void testSetC2() {
		Ligne L1 = new Ligne(new Coordonnees(77, 177), 156, -100);
		L1.setC2(new Coordonnees(250, 150));

		assertEquals("Erreur mauvaise valeur de C1",new Coordonnees(77, 177), L1.getC1());
		assertEquals("Erreur la valeur de C2 change",new Coordonnees(250, 150), L1.getC2());
	}

	@Test
	public void testSetC2Two() {
		Ligne L1 = new Ligne(new Coordonnees(77, 177), 156, -100);
		L1.setC2(new Coordonnees(-10, -10));
		
		assertEquals("Erreur la valeur de C1 change", new Coordonnees(77, 177), L1.getC1());
		assertEquals("Erreur mauvaise valeur de C2", new Coordonnees(-10, -10), L1.getC2());
	}

	// Test SetPosition()
	@Test
	public void testSetPosition() {
		Ligne L1 = new Ligne(new Coordonnees(20, 20), 156, -100);
		L1.setPosition(new Coordonnees(77, 177));

		assertEquals("Erreur mauvaise valeur de C2", new Coordonnees(77, 177), L1.getC1());
		// assertEquals("Erreur mauvaise valeur de C1",,L1.getC2());
	}
	
	@Test
	public void testSetPositionDeux() {
		Ligne L1 = new Ligne(new Coordonnees(20, 20), 156, -100);
		L1.setPosition(new Coordonnees(77, 177));
		
		assertEquals("Erreur mauvaise valeur de C1",new Coordonnees(77, 177),L1.getC1());
		assertEquals("Erreur mauvaise valeur de C2", new Coordonnees(233,77), L1.getC2());
	}
	
	@Test
	public void testSetPositionDeuxC2() {
		Ligne L1 = new Ligne(new Coordonnees(20, 20), 156, -100);
		L1.setPosition(new Coordonnees(77, 177));
		
		//assertEquals("Erreur mauvaise valeur de C1",new Coordonnees(77, 177),L1.getC1());
		assertEquals("Erreur mauvaise valeur de C2", new Coordonnees(233,77), L1.getC2());
	}
	
	@Test
	public void testContientPas() {
		Ligne L1 = new Ligne(new Coordonnees(77,177), 156, -100);
		assertFalse(L1.contient(new Coordonnees(177,233)));
	}
	
	@Test
	public void testContient() {
		Ligne L1 = new Ligne(new Coordonnees(77,177), 156, -100);
		assertTrue(L1.contient(new Coordonnees(155,127)));
	}
	
	@Test
	public void testContientProche() {
		Ligne L1 = new Ligne(new Coordonnees(77,177), 156, -100);
		assertTrue(L1.contient(new Coordonnees(155.01,127.01)));
	}
	
	@Test
	public void testContientProche2() {
		Ligne L1 = new Ligne(new Coordonnees(77,177), 156, -100);
		assertTrue(L1.contient(new Coordonnees(155.2,127.2)));
	}
	

    @Test
    public void testGetCouleurParDefaut() {
        Ligne ligne = new Ligne();
        Color couleurDefaut = UIManager.getColor("Panel.foreground"); 
        assertEquals( couleurDefaut, ligne.getCouleur());
    }
 
    @Test
    public void testGetCouleur() {
        Ligne ligne = new Ligne();
        ligne.setCouleur(Color.blue);
        
        assertEquals(Color.blue, ligne.getCouleur());
    }


}
