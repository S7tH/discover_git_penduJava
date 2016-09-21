package com.pendu.modeles;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.CharArrayReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pendu.stream.Stream;

public class Party extends JPanel
{
	private JPanel screenResult = new JPanel();
	private JLabel wordCount = new JLabel();
	private JLabel score= new JLabel();
	private int wordsCount = 0;
	private int scores = 0;
	
	private JPanel ScreenImage = new JPanel();
	private JLabel hanged = new JLabel(new ImageIcon("pendu/2.jpg"));
	
	private JPanel keyboard = new JPanel();
	private String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private JButton[] keyboardTouch =  new JButton[alphabet.length];
	
	private JPanel screenHiddenWord = new JPanel();
	private JLabel hiddenWord = new JLabel();
	private Stream mixedWord = new Stream();
	
	private String dicoWord ="";
	private String uncompletedWord ="";
	private CharArrayReader carDico,carTouch,carUncompleteWord;
	private int faults = 0;


	
	public Party()
	{
		
		
		wordCount.setText("Nombre de mots trouvés : "+wordsCount);
		score.setText("Votre score actuel est de : "+scores);
		
		screenResult.setLayout(new GridLayout(2,1));
		screenResult.add(wordCount);
		screenResult.add(score);
		
		dicoWord();
		findWord("*");
		
		screenHiddenWord.add(hiddenWord);
		keyboardLetter();
		
		
		this.setLayout(new GridLayout(2,2));
		this.add(screenResult);
		this.add(screenHiddenWord);
		this.add(keyboard);
		this.add(ScreenImage);
		
		
	}
	
	public void keyboardLetter()
	{
		keyboard.setLayout(new GridLayout(4,7));
		
		for(int i = 0; i < alphabet.length; i++)
		{
			
			keyboardTouch[i] = new JButton(alphabet[i]);
			keyboardTouch[i].addActionListener(new TouchListener());
			keyboard.add(keyboardTouch[i]);
			
			
		}
	}
	
	public String dicoWord()
	{
		//on récupére le mot random du dico  
		return this.dicoWord = mixedWord.getTxt();
	}
	
	public void findWord(String touch)
	{
				String randomWord ="";
				carDico = new CharArrayReader(dicoWord.toCharArray());
				carTouch = new CharArrayReader(touch.toCharArray());
				carUncompleteWord = new CharArrayReader(uncompletedWord.toCharArray());
				
				int i;
				int j = 0;
				int k = 0;

			
			if(faults < 6)
			{
				try 
				{
					j = carTouch.read();
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				
				try {
					while((i = carDico.read()) != -1)
					{
						
						k = carUncompleteWord.read();
					 
						if((char) i == (char)j)
						{
						   randomWord += (char) j;
						}
						else if((char) i == (char)k)
						{
							randomWord += (char) k;
						}	
						else
						{
							randomWord += "*";
						}
						
					}
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				
				if(randomWord.equals(uncompletedWord))
				{
					int nImg = faults +3;
					hanged = new JLabel(new ImageIcon("pendu/"+ nImg + ".jpg"));
					faults++;
					
					
				}
				
				System.out.println(faults);
				
				uncompletedWord = randomWord;
				
				if (uncompletedWord.equals(dicoWord))
				{
					wordsCount++;
					scores++;
					wordCount.setText("Nombre de mots trouvés : "+wordsCount);
					score.setText("Votre score actuel est de : "+scores);
					hiddenWord.setText("GAGNE");
					
					faults =0; 
					
				}
				else
				{
					hiddenWord.setText(uncompletedWord);
				}
			

				ScreenImage.removeAll();
				ScreenImage.add(hanged);
		
				validate();
			}
			else
			{
				
				hanged = new JLabel(new ImageIcon("pendu/9.jpg"));
				ScreenImage.removeAll();
				ScreenImage.add(hanged);
				hiddenWord.setText("PERDU");
				
				
			
				faults = 0;
				
				
			}
				
		
	}
	
	class TouchListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String touch = ((JButton)e.getSource()).getText();
			findWord(touch);
		}
		
	}
	
}
