package fr.eseo.poo.projet.artiste.modele;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.eseo.poo.projet.artiste.modele.formes.CercleTest;
import fr.eseo.poo.projet.artiste.modele.formes.EllipseTest;
import fr.eseo.poo.projet.artiste.modele.formes.EtoileTest;
import fr.eseo.poo.projet.artiste.modele.formes.LigneTest;

@RunWith(Suite.class)
@SuiteClasses({ CoordonneesTest.class, LigneTest.class, EllipseTest.class, CercleTest.class, EtoileTest.class})
public class ModeleTests {

}
