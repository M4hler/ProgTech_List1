package deck_and_cards;

import junit.framework.TestCase;

public class DeckTesting extends TestCase
{
	private Deck deck;
	
	protected void setUp() throws Exception 
	{
		super.setUp();
		deck = new Deck(24);
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
		deck =null;
	}

	public void testDeck() 
	{
		String str = deck.cards[0].color;
		assertEquals("Incorrect color of card",str, "diamond");
	}

	public void testList() 
	{
		for(int i = 0; i < deck.numberOfCards; i++)
		{
			assertNotNull(i + " card is null",deck.cards[i]);
		}
	}

	public void testShuffle() 
	{
		assertFalse("Pointer is out of range", deck.pointer > deck.numberOfCards);
	}

	public void testSort() 
	{
		for(int i = 0; i < deck.numberOfCards - 1; i++)
		{
			assertNotSame("Two cards are same",deck.cards[i], deck.cards[i + 1]);
		}
	}

	public void testTopCard() 
	{
		assertTrue("Pointer is less than or equal to 0", deck.pointer > 0);
	}

}
