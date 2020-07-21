package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class PanneauDessin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int LARGEUR_PAR_DEFAUT = 1000;
	public static final int HAUTEUR_PAR_DEFAUT = 600;
	public static final Color COULEUR_FOND_PAR_DEFAUT = Color.LIGHT_GRAY;
	private Color couleurCourante = Forme.COULEUR_PAR_DEFAUT; 

	// private fr.eseo.poo.projet.artiste.vue.formes.VueForme vueForme;
	private final List<VueForme> vueFormes = new ArrayList<VueForme>();
	private Outil outilCourant;
	private boolean modeRemplissage; 
	
	

	public PanneauDessin() {
		this(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, COULEUR_FOND_PAR_DEFAUT);
	}

	public PanneauDessin(int largeur, int hauteur, Color fond) {
		super();
		this.setPreferredSize(new Dimension(largeur, hauteur));
		this.setBackground(fond);
		this.setOutilCourant(getOutilCourant());
		this.setModeRemplissage(false);
		
	}

	public List<VueForme> getVueFormes() {
		return this.vueFormes;
	}

	public void ajouterVueForme(VueForme vueForme) {
		this.vueFormes.add(vueForme);
	}

	@Override
	protected void paintComponent(Graphics g2d) {
		super.paintComponent(g2d);
		Graphics2D g2D = (Graphics2D) g2d.create();
		for (VueForme vueForme : vueFormes) {
			vueForme.affiche(g2D);
		}
		g2D.dispose();
	}

	/***
	 * on ajoute un écouteur d’événement à la souris pour le this, avec le
	 * MouseAdapter qui va faire le lien avec l’événement voulu juste après cad le
	 * getOutilCourant().
	 * 
	 */

	public void associerOutil(Outil outil) {

		if (this.getOutilCourant() != outil) {
			this.dissocierOutil();
			this.setOutilCourant(outil);
			getOutilCourant().setPanneauDessin(this);
		}
		this.addMouseListener(getOutilCourant());
		this.addMouseMotionListener(getOutilCourant());

	}

	private void dissocierOutil() {

		if (this.getOutilCourant() != null) {
			this.removeMouseListener(getOutilCourant());
			this.removeMouseMotionListener(getOutilCourant());
		
			
			this.getOutilCourant().setPanneauDessin(null); 
			this.setOutilCourant(null);
		}

	}

	public Outil getOutilCourant() {
		return outilCourant;
	}

	private void setOutilCourant(Outil outil) {
		this.outilCourant = outil;
	}
	
	public Color getCouleurCourante() {
		return couleurCourante; 
	}
	public void setCouleurCourante(Color couleur) {
		this.couleurCourante = couleur; 
	}
	
	public boolean getModeRemplissage() {
		return modeRemplissage; 
	}
	
	public void setModeRemplissage(boolean modeRemplissage) {
		this.modeRemplissage = modeRemplissage; 
	}
	
}
