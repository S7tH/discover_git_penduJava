package com.pendu.modeles;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Regles extends JPanel
{
	private JLabel titre;
	private JTextField notice;
	private JPanel title = new JPanel();
	private JPanel regles = new JPanel();
	
	public Regles()
	{
		titre = new JLabel("Le jeu du PENDU");
	
		titre.setHorizontalAlignment(JLabel.CENTER);
		
		String newligne = System.getProperty("line.separator");
		
		String texte = "Vous avez 7 coups pour trouver le mot caché ! si vous reussissez... on recommence! \n"
				+"Plus vous trouverez de mots, plus votre score sera élevé.\n"
				+ newligne
				+ newligne
				+"COMPTE DES POINTS:\n"
				+"\n"
				+" Mot trouvé sans erreur:     100Pts \n"
				+" Mot trouvé avec  1 erreur:  50Pts \n"
				+" Mot trouvé avec  2 erreurs: 35Pts \n"
				+" Mot trouvé avec  3 erreurs: 25Pts \n"
				+" Mot trouvé avec  4 erreurs: 15Pts \n"
				+" Mot trouvé avec  5 erreurs: 10Pts \n"
				+" Mot trouvé avec  6 erreurs:  5Pts \n"
				+"\n"
				+"\n"
				+"Je vous souhaite bien du plaisir...";
		
		
		notice = new JTextField(texte);
		
		notice.setEditable(false);

		
		this.setLayout(new BorderLayout());
		
		title.add(titre);
		regles.add(notice);
	
		
		this.add(title, BorderLayout.NORTH);
		this.add(regles,BorderLayout.CENTER);
	}
}
