package com.pendu.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.pendu.modeles.Accueil;
import com.pendu.modeles.Party;
import com.pendu.modeles.Regles;

public class Fenetre extends JFrame
{
	//variables de la bare de menu
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fichier = new JMenu("Fichier");
	private JMenu aPropos = new JMenu("A propos");
	private JMenuItem nouveau = new JMenuItem("Nouveau");
	private JMenuItem score = new JMenuItem("Score");
	private JMenuItem regles = new JMenuItem("Règles");
	private JMenuItem home = new JMenuItem("Accueil");
	
	

	
	//instances d'objets

	private Accueil accueil = new Accueil();
	private Regles rules = new Regles();
	private Party party = new Party();
	
	//constructeur
	public Fenetre()
	{
		this.setTitle("Jeu du pendu");
		this.setSize(1024,800);
		this.setContentPane(accueil);
		initMenuBar();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	//configuration de la bare de menu
	public void initMenuBar()
	{
		nouveau.addActionListener(new PartyListener());
		
		this.fichier.add(nouveau);
		this.fichier.add(score);
		
		regles.addActionListener(new ReglesListener());
		
		this.fichier.add(regles);
		
		home.addActionListener(new AccueilListener());
		
		this.aPropos.add(home);

		this.menuBar.add(fichier);
		this.menuBar.add(aPropos);
		this.setJMenuBar(menuBar);
		
		
	}
	
	class PartyListener implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) 
		{
			setContentPane(party);
			validate();
			
		}
		
	}
	
	class ReglesListener implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) 
		{
			setContentPane(rules);
			validate();
			
		}
		
	}
	
	class AccueilListener implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) 
		{
			
			setContentPane(accueil);
			validate();
		}
		
	}
	


	//main
	public static void main(String[] args)
	{
		
		
		Fenetre fen = new Fenetre();
		fen.setVisible(true);	}

	
	
}
