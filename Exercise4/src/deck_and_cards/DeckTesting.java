package deck_and_cards;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class DeckTesting
{
	private Deck deck;
	
	@Before
	public void setUp() throws Exception 
	{
		deck = new Deck(32);
	}

	@After
	public void tearDown() throws Exception 
	{
		deck = null;
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testDeck() 
	{
		System.out.println(deck.cards[32]);
	}

	@Test(timeout = 100)
	public void testList() 
	{
		for(int i = 0; i < deck.numberOfCards; i++)
		{
			assertNotNull(i + " card is null",deck.cards[i]);
		}
	}

	@Test
	public void testShuffle() 
	{
		assertFalse("Pointer is out of range", deck.pointer > deck.numberOfCards);
	}

	@Test
	public void testSort() 
	{
		for(int i = 0; i < deck.numberOfCards - 1; i++)
		{
			assertNotSame("Two cards are same",deck.cards[i], deck.cards[i + 1]);
		}
	}

	@Ignore("Just to make use of this annotation") @Test
	public void testTopCard() 
	{
		assertTrue("Pointer is less than or equal to 0", deck.pointer > 0);
	}
	
}
