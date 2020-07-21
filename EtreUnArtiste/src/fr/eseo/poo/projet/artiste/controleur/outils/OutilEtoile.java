package fr.eseo.poo.projet.artiste.controleur.outils;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueEtoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

public class OutilEtoile extends OutilForme {
	
	private Etoile etoile = new Etoile(); 	
	private PanneauBarreOutils panneauBarreOutils; 
	
	public OutilEtoile(PanneauBarreOutils panneauBarreOutils) {
		super();
		this.panneauBarreOutils = panneauBarreOutils; 
	}

	@Override
	protected VueForme creerVueForme() {
		
		double distanceDF = getDebut().distanceVers(getFin());
        double angleDF = getDebut().angleVers(getFin());
        
        int nombreBranche = this.panneauBarreOutils.getNbBranches(); 
        double longueurBranche = this.panneauBarreOutils.getLongueurBranche(); 
        
        double positionAbscisse = getFin().getAbscisse() - distanceDF;
        double positionOrdonnee = getFin().getOrdonnee() - distanceDF;
        
        Coordonnees coordonneePosition = new Coordonnees(positionAbscisse, positionOrdonnee); 
        Etoile etoile = new Etoile( coordonneePosition, distanceDF*2, nombreBranche, angleDF, longueurBranche);
        etoile.setCouleur(getPanneauDessin().getCouleurCourante());
        etoile.setRempli(getPanneauDessin().getModeRemplissage()); 
        VueEtoile vueEtoile = new VueEtoile(etoile); 
        return  vueEtoile; 

	}
	
}



