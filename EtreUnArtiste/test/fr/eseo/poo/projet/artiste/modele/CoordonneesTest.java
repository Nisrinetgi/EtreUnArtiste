package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordonneesTest {
	
	private static final double EPSILON = 0.001;
	
	// Test Constructeurs : 
	
	@Test
	public void testConstructeurVide() {
		Coordonnees coordonnees = new Coordonnees();
		assertEquals(0, coordonnees.getAbscisse(), EPSILON);
		assertEquals(0, coordonnees.getOrdonnee(), EPSILON);
	}

	@Test
	public void testConstructeur() {
		Coordonnees coordonnees = new Coordonnees(0,0);
		assertEquals(new Coordonnees(), coordonnees);
	}

	// Test DeplacerDe OK :
	// deplacer de NEGNEG
	@Test
	public void testDeplacerDeNegNegResPos(){
		Coordonnees p1 = new Coordonnees(20.1234,15.1234);
		Coordonnees p2 = new Coordonnees(10.1234,5.1234);
		
		p1.deplacerDe(-10, -10);
		assertEquals(p2,p1);
	}
	
	@Test
	public void testDeplacerDeNegNegResNeg(){
		Coordonnees p1 = new Coordonnees(0.1234,5.1234);
		Coordonnees p2 = new Coordonnees(-9.8766,-4.8766);
		
		p1.deplacerDe(-10, -10);
		assertEquals(p2,p1);
	}
	
	@Test
	public void testDeplacerDeNegNegResNegPos(){
		Coordonnees p1 = new Coordonnees(0.1234,10.1234);
		Coordonnees p2 = new Coordonnees(-9.8766,0.1234);
		
		p1.deplacerDe(-10, -10);
		assertEquals("Problème d'abscisse", p2.getAbscisse(), p1.getAbscisse(), EPSILON);
		assertEquals("Problème d'ordonnee", p2.getOrdonnee(), p1.getOrdonnee(), EPSILON);
		
	}
	
	@Test
	public void testDeplacerDeNegNegResPosNeg(){
		Coordonnees p1 = new Coordonnees(10.1234,0.1234);
		Coordonnees p2 = new Coordonnees(0.1234,-9.8766);
		
		p1.deplacerDe(-10, -10);
		assertEquals("Problème d'abscisse", p2.getAbscisse(), p1.getAbscisse(), EPSILON);
		assertEquals("Problème d'ordonnee", p2.getOrdonnee(), p1.getOrdonnee(), EPSILON);
		
	}
	// déplacer de POSNEG à résultat ...
	@Test
	public void testDeplacerDePosNegResPos(){
		Coordonnees p1 = new Coordonnees(5.1234,10.1234);
		Coordonnees p2 = new Coordonnees(10.1234,0.1234);
		
		p1.deplacerDe(5, -10);
		assertEquals("Problème d'abscisse", p2.getAbscisse(), p1.getAbscisse(), EPSILON);
		assertEquals("Problème d'ordonnee", p2.getOrdonnee(), p1.getOrdonnee(), EPSILON);
		
	}
	
	@Test
	public void testDeplacerDePosNegResNeg(){
		Coordonnees p1 = new Coordonnees(-10.1234,5.1234);
		Coordonnees p2 = new Coordonnees(-5.1234,-4.8766);
		
		p1.deplacerDe(5, -10);
		assertEquals(p2,p1);
	}
	
	@Test
	public void testDeplacerDePosNegResPosNeg(){
		Coordonnees p1 = new Coordonnees(-0.1234,5.1234);
		Coordonnees p2 = new Coordonnees(4.8766,-4.8766);
		
		p1.deplacerDe(5, -10);
		assertEquals(p2,p1);
	}
	@Test
	public void testDeplacerDePosNegResNegPos(){
		Coordonnees p1 = new Coordonnees(-10.1234,10.1234);
		Coordonnees p2 = new Coordonnees(-5.1234,0.1234);
		
		p1.deplacerDe(5, -10);
		
		assertEquals("Problème d'abscisse", p2.getAbscisse(), p1.getAbscisse(), EPSILON);
		assertEquals("Problème d'ordonnee", p2.getOrdonnee(), p1.getOrdonnee(), EPSILON);
				
	}
		
	// Test Deplacer Vers
	// Deplacer Pos Vers ...
	@Test
	public void testDeplacerVersPosVPos() {
		Coordonnees p1 = new Coordonnees(0.1234,5.1234);
		Coordonnees p2 = new Coordonnees(10.1234,0.1234);
		
		p1.deplacerVers(10.1234,0.1234);
		assertEquals(p2,p1);
	}
	
	@Test
	public void testDeplacerVersPosVNeg() {
		Coordonnees p1 = new Coordonnees(0.1234,5.1234);
		Coordonnees p2 = new Coordonnees(-10.1234,-0.1234);
		
		p1.deplacerVers(-10.1234,-0.1234);
		assertEquals(p2,p1);
	}
	
	@Test
	public void testDeplacerVersPosVPosNeg() {
		Coordonnees p1 = new Coordonnees(0.1234,5.1234);
		Coordonnees p2 = new Coordonnees(10.1234,-0.1234);
		
		p1.deplacerVers(10.1234,-0.1234);
		assertEquals(p2,p1);
	}
	
	@Test
	public void testDeplacerVersPosVNegPos() {
		Coordonnees p1 = new Coordonnees(0.1234,5.1234);
		Coordonnees p2 = new Coordonnees(-10.1234,0.1234);
		
		p1.deplacerVers(-10.1234,0.1234);
		assertEquals(p2,p1);
	}
		
	
	// Déplacer Neg Vers ...
	
	@Test
	public void testDeplacerVersNegVPos() {
		Coordonnees p1 = new Coordonnees(-10.1234,-0.1234);
		Coordonnees p2 = new Coordonnees(0.1234,5.1234);
		p1.deplacerVers(0.1234,5.1234);
		assertEquals(p2,p1);
	}
	
	@Test
	public void testDeplacerVersNegVNeg() {
		
		Coordonnees p1 = new Coordonnees(-10.1234,-0.1234);
		Coordonnees p2 = new Coordonnees(-0.1234,-5.1234);
		p1.deplacerVers(-0.1234,-5.1234);
		assertEquals(p2,p1);
	}
	
	@Test
	public void testDeplacerVersNegVPosNeg() {
		Coordonnees p1 = new Coordonnees(-0.1234,-5.1234);
		Coordonnees p2 = new Coordonnees(10.1234,-0.1234);
		
		p1.deplacerVers(10.1234,-0.1234);
		assertEquals(p2,p1);
	}
	
	@Test
	public void testDeplacerVersNegVNegPos() {
		Coordonnees p1 = new Coordonnees(-0.1234,-5.1234);
		Coordonnees p2 = new Coordonnees(-10.1234,0.1234);
		
		p1.deplacerVers(-10.1234,0.1234);
		assertEquals(p2,p1);
	}
		

	//Test DistanceVers

	@Test
	public void testDistanceVersEst() {
		Coordonnees p1 = new Coordonnees(0.9876,0.1234);
		Coordonnees p2 = new Coordonnees(10.9876,0.1234);
		
		assertEquals("Erreur distance.", 10, p1.distanceVers(p2), EPSILON);
	}
	
	@Test
	public void testDistanceVersOuest() {
		Coordonnees p1 = new Coordonnees(0.1234,0.9876);
		Coordonnees p2 = new Coordonnees(-4.8766,0.9876);
		
		assertEquals("Erreur distance.", 5, p1.distanceVers(p2), EPSILON);
	}
	
	@Test
	public void testDistanceVersSud() {
		Coordonnees p1 = new Coordonnees(0.9876,0.1234);
		Coordonnees p2 = new Coordonnees(0.9876,20.1234);
		
		assertEquals("Erreur distance.", 20, p1.distanceVers(p2), EPSILON);
	}
	
	@Test
	public void testDistanceVersNord() {
		Coordonnees p1 = new Coordonnees(0.9876,0.1234);
		Coordonnees p2 = new Coordonnees(0.9876,-4.8766);
		
		assertEquals("Erreur distance.", 5, p1.distanceVers(p2), EPSILON);
	}

//	//public double angleVers(Coordonnees autreCoordonnees) {
//	return Math.atan2(this.getOrdonnee() - autreCoordonnees.getOrdonnee(), autreCoordonnees.getAbscisse() - this.getAbscisse());
//}
	
	
	
	// Méthodes nommées pour l'orientation par rapport à un référentiel points cardinaux classique 
		// (Nord vers le haut, donc à l'opposé de l'axe des ordonnées)
	// TestAngleVers()
	@Test
	public void testAngleVersSE() {
		Coordonnees c1 = new Coordonnees(0,0);
		Coordonnees c2 = new Coordonnees(1,1);
		assertEquals("Erreur angle.",0.7853981634,c1.angleVers(c2), EPSILON);
	}
	
	@Test
	public void testAngleVersNE() {
		Coordonnees c1 = new Coordonnees(0,0);
		Coordonnees c2 = new Coordonnees(1,-1);
		assertEquals("Erreur angle.",0.7853981634,c1.angleVers(c2), EPSILON);
	}
	
	@Test
	public void testAngleVersNO() {
		Coordonnees c1 = new Coordonnees(0,0);
		Coordonnees c2 = new Coordonnees(-1,-1);
		assertEquals("Erreur angle.",-2.35619449,c1.angleVers(c2), EPSILON);
	}
	
	@Test
	public void testAngleVersSO() {
		Coordonnees c1 = new Coordonnees(0,0);
		Coordonnees c2 = new Coordonnees(-1,1);
		assertEquals("Erreur angle.",2.35619449,c1.angleVers(c2), EPSILON);
	}
	
	// TestToString()
	@Test
	public void testToStringPos() {
		Coordonnees p1 = new Coordonnees(15.50 , 17.35);
		assertEquals("(15.5 , 17.35)",p1.toString()); // remarque : String are object
	}
	
	@Test
	public void testToStringNeg() {
		Coordonnees p1 = new Coordonnees(-15.50 , -17.35);
		assertEquals("(-15.5 , -17.35)",p1.toString()); // remarque : String are object
	}
	
	@Test
	public void testToStringNegPos() {
		Coordonnees p1 = new Coordonnees(-15.50 , 17.35);
		assertEquals("(-15.5 , 17.35)",p1.toString()); // remarque : String are object
	}
	
	@Test
	public void testToStringPosNeg() {
		Coordonnees p1 = new Coordonnees(15.50 , -17.35);
		assertEquals("(15.5 , -17.35)",p1.toString()); // remarque : String are object
	}
	
	
	


	
}
