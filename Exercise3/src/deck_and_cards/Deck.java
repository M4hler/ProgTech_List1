package deck_and_cards;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Deck
{
	public static Card[] cards; //array of objects of type Card
	
	public int numberOfCards; //used in loops
	public int numberOfColors; //used in loops
	public int pointer; //used to determine the top card in the deck
	
	public Deck(int sizeOfDeck)
	{
		numberOfCards = sizeOfDeck;
		pointer = sizeOfDeck;
		cards = new Card[numberOfCards]; //initializing the array
		numberOfColors = Card.possibleColors.length;
		
		int startingValue = 0; //assigning a default value
		
		//place to decide what card we want to start a deck with
		if(numberOfCards == 24)
		{
			startingValue = Card.Find(Card.firstCardIn24CardDeck);
		}
		
		if(numberOfCards == 32)
		{
			startingValue = Card.Find(Card.firstCardIn32CardDeck);
		}
		
		if(numberOfCards == 52)
		{
			 startingValue = Card.Find(Card.firstCardIn52CardDeck);
		}
		
		//creating the cards, that are used e.g. in Texas Hold'em
		for(int i = 0; i < numberOfCards / numberOfColors; i++)
		{
			for(int j = 0; j < numberOfColors; j++)
			{
				cards[i * numberOfColors + j] = new Card(Card.possibleValues[startingValue], Card.possibleColors[j % numberOfColors]);
			}
			startingValue++;
		}
		
		System.out.println("New deck");
		List();
	}
	
	//printing out the cards to see the changes
	public void List()
	{
		for(int i = 0; i < numberOfCards; i++)
		{
			System.out.println(cards[i].value + " " + cards[i].color);
		}
		System.out.println("");
	}
	
	//shuffling the deck
	public void Shuffle()
	{
		Random random = new Random();
		for(int i = 0; i < numberOfCards; i++)
		{
			//switching place of 2 cards
			int tmp_int1 = random.nextInt(numberOfCards);
			int tmp_int2 = random.nextInt(numberOfCards);
			Card tmp_object = cards[tmp_int1];
			cards[tmp_int1] = cards[tmp_int2];
			cards[tmp_int2] = tmp_object;
		}
		
		pointer = numberOfCards; //after shuffling the top card has again the biggest index
		System.out.println("Shuffled deck");
		List();
	}
	
	//sorting the deck using bubble sort
	public void Sort()
	{
		for(int i = 0; i < numberOfCards; i++)
		{
			for(int j = 0; j < numberOfCards - i - 1; j++)
			{
				//10 is weight, because card value is more important than its color
				int tmp_value1 = cards[j].value * 10 + Card.Find(cards[j].color);
				int tmp_value2 = cards[j + 1].value * 10 + Card.Find(cards[j + 1].color);
				
				if(tmp_value1 > tmp_value2)
				{
					Card tmp = cards[j];
					cards[j] = cards[j + 1];
					cards[j + 1] = tmp;
				}
			}
		}
		
		pointer = numberOfCards; //after sorting the top card has again the biggest index
		System.out.println("Sorted deck");
		List();
	}
	
	//return a card from the top
	public Card TopCard()
	{
		if(pointer == 0)
			return null;
		else
		{
			pointer--;
			return cards[pointer];
		}
	}
	
	public static void main(String[] args) 
	{
		int deckInitializer = 0;
		do
		{
			System.out.println("Give number of cards: ");
			
			@SuppressWarnings("resource")
			Scanner numberInput = new Scanner(System.in); //Scanner isn't closed because its method closes the System.in buffer as well
			
			try
			{
				deckInitializer = numberInput.nextInt();
			}
			catch(InputMismatchException ex)
			{
				System.out.println("Incorrect input");
			}
			
			numberInput.nextLine();
		} while(deckInitializer != 24 && deckInitializer != 32 && deckInitializer != 52);
		
		Deck deck = new Deck(deckInitializer); //instance of a deck
		//a few calls of functions to see how the deck class is working
		deck.Shuffle();
		Card n = deck.TopCard();
		System.out.println("TOP: " + n.value + " " + n.color);
		n = deck.TopCard();
		System.out.println("TOP: " + n.value + " " + n.color);
		n = deck.TopCard();
		System.out.println("TOP: " + n.value + " " + n.color);
		deck.Sort();
	}
}
