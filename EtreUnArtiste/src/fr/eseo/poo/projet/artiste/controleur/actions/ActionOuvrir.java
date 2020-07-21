package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.xpath.XPathExpressionException;

import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;
import fr.eseo.poo.projet.artiste.xml.LecteurSVG;

public class ActionOuvrir extends AbstractAction {
	public static final String NOM_ACTION = "Ouvrir";
	private PanneauDessin panneauDessin = new PanneauDessin();

	public ActionOuvrir(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	public void actionPerformed(ActionEvent event) {

		JFileChooser fichier = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("SVG (*.svg)", "svg");
		fichier.setFileFilter(filter);

		if (fichier.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

			File fichierEnSelection = fichier.getSelectedFile();
			System.out.println(fichierEnSelection.getAbsolutePath());
			LecteurSVG lecteurSVG = new LecteurSVG();

			try {
				List<VueForme> dessin = lecteurSVG.lisDessin(fichier.getSelectedFile().getAbsolutePath());
				for (VueForme vueForme : dessin) {
					this.panneauDessin.ajouterVueForme(vueForme);
					this.panneauDessin.repaint();
				}

			} catch (FileNotFoundException | XPathExpressionException e) {
				e.printStackTrace();
			}
		}
	}

}
