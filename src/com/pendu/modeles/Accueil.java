package com.pendu.modeles;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Accueil extends JPanel
{
	private JLabel bienvenue;
	private JPanel bienv;
	private JLabel imgPendu;
	private JPanel img;
	private JTextField notice;
	private JPanel not;
	private String welcome = "Bienvenue dans le jeu du PENDU";
	
	public Accueil()
	{
		
		//création d'une variable provoquant un retour é la ligne
		String newligne = System.getProperty("line.separator");
		
		//initialisation de variable de leur texte
		
		bienvenue = new JLabel(welcome);
		
		imgPendu = new JLabel(new ImageIcon("pendu/1.jpg"));
		
		String but = "Vous avez 7 coups pour trouver le mot caché !"
					+ newligne
					+" si vous reussissez... on recommence!"
					+ newligne
					+" Plus vous trouverez de mots, plus votre score sera élevé.";
		
		notice = new JTextField(but);
		notice.setEditable(false);
		
		
		//creation de panneau conteneurs 
		bienv = new JPanel();
		bienv.setPreferredSize(new Dimension(0, 100));
		
		bienv.add(bienvenue);
		
		img = new JPanel();
		img.setPreferredSize(new Dimension(0, 200));
		img.add(imgPendu);
		
		not = new JPanel();
		not.setPreferredSize(new Dimension(0, 200));
		not.add(notice);
		
		//initialisation du type de cadre
		this.setLayout(new BorderLayout());
		
		//ajout des panneaux conteneurs avec leur contenu dans le panneau principal
		this.add(bienv, BorderLayout.NORTH);
		this.add(img, BorderLayout.CENTER);
		this.add(not, BorderLayout.SOUTH);
	}



}
