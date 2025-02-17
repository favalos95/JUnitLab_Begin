package csc131.junit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertThrows;

public class GiftCardTest
{
@Test
    public void getIssuingStore()
    {
        double       balance;
        GiftCard     card;
        int          issuingStore;
        issuingStore = 1337;
        balance      = 100.00;
        card = new GiftCard(issuingStore, balance);
        assertEquals("getIssuingStore()",
                     issuingStore, card.getIssuingStore());
    } 
@Test
	public void getBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("getBalance()",
				balance, card.getBalance(), 0.001);
	}
@Test 
	public void deduct_RemainingBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String s;
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		s = "Remaining Balance: " + String.format("%6.2f",  90.00);
		assertEquals("deduct(10.00)", s, card.deduct(10.00));
	}
@Test 
	public void deduct_AmountDue()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String s;
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		s = "Amount Due: " + String.format("%6.2f", 10.00);
		assertEquals("deduct(100.00)", s, card.deduct(110.00));
	}

@Test
	public void deduct_InvalidTransaction()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String s;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		s = "Invalid Transaction";
		assertEquals("deduct -10.00 from 100", s, card.deduct(-10.0));
			
	}
@Test
	public void constructor_IncorrectID_Low()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);}); 
	}

@Test
	public void constructor_IncorrectID_Balanced()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,100.00);}); 
	}




}