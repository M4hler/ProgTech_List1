package deck_and_cards;

public class Card 
{
	public int value;
	public String color;
	
	public static int firstCardIn24CardDeck = 9;
	public static int firstCardIn32CardDeck = 7;
	public static int firstCardIn52CardDeck = 2;
	
	public static int[] possibleValues = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	public static String[] possibleColors = { "diamond", "heart", "spades", "club"};
	
	public Card(int cardValue, String cardColor)
	{
		value = cardValue;
		color = cardColor;
	}
	
	public static int Find(int arg)
	{
		for(int i = 0; i < possibleValues.length; i++)
		{
			if(possibleValues[i] == arg)
				return i;
			else
				continue;
		}
		return 0;
	}
	
	public static int Find(String arg)
	{
		for(int i = 0; i < possibleColors.length; i++)
		{
			if(possibleColors[i] == arg)
			{
				return i;
			}
		}
		return 0;
	}
}
