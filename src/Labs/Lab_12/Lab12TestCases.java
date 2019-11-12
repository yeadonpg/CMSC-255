package Labs.Lab_12;

import java.time.Month;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Lab12TestCases {

	// Card test cases

	@Test
	public void CardInstanceVariablesTest() {
		Card testCard = new Card();
		@SuppressWarnings("rawtypes")
		Class c = testCard.getClass();
		try {
			c.getDeclaredField("name");

			assertEquals(
					"You must only have the instance variables specified in the lab manual. When looking at the number of instance variables we",
					1, c.getDeclaredFields().length);

			assertEquals("You must make your instance variables private.", true,
					Modifier.isPrivate(c.getDeclaredField("name").getModifiers()));

			assertEquals("Your instance variables must NOT be static.", false,
					Modifier.isStatic(c.getDeclaredField("name").getModifiers()));

			assertEquals("You must make your name instance variable of type String.", (String.class),
					c.getDeclaredField("name").getType());

		} catch (NoSuchFieldException e) {
			fail("Could not find the " + e.getLocalizedMessage().toString() + " instance variable");
		} catch (Exception e) {
			fail("Something weird went wrong");
		}
	}

	@Test
	public void CardDefaultConstructor() {
		Card testCard = new Card();
		@SuppressWarnings("rawtypes")
		Class c = testCard.getClass();
		try {

			Field name = c.getDeclaredField("name");
			name.setAccessible(true);
			String nameValue = (String) name.get(testCard);
			assertEquals("When checking the value of name we", "", nameValue);

		} catch (Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public void CardParameterizedConstructor() {
		Card myCard = new Card("Franklin Pierce");
		@SuppressWarnings("rawtypes")
		Class c = myCard.getClass();
		try {
			Field name = c.getDeclaredField("name");
			name.setAccessible(true);
			String nameValue = (String) name.get(myCard);
			assertEquals("When checking the value of name we", "Franklin Pierce", nameValue);

		} catch (Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public void CardToString() {
		Card myCard = createCard("Millard Filmore");
		assertEquals("After calling the cardToString method, we", "Card Holder: Millard Filmore",
				myCard.toString());
	}

	private Card createCard(String aName) {
		Card myCard = new Card();
		@SuppressWarnings("rawtypes")
		Class c = myCard.getClass();
		try {
			Field name = c.getDeclaredField("name");
			name.setAccessible(true);
			name.set(myCard, aName);
		} catch (Exception e) {
			fail(e.toString());
		}
		return myCard;
	}

	// DebitCard test cases

	@Test
	public void DebitCardSuperClass() {
		DebitCard myDebitCard = new DebitCard();
		assertEquals("When Testing if the DebitCard Super Class is Card, we", true, (myDebitCard instanceof Card));
	}

	@Test
	public void DebitCardInstanceVariablesTest() {
		DebitCard testDebitCard = new DebitCard();
		@SuppressWarnings("rawtypes")
		Class c = testDebitCard.getClass();
		try {
			c.getDeclaredField("cardNumber");
			c.getDeclaredField("pin");

			assertEquals(
					"You must only have the instance variables specified in the lab manual. When looking at the number of instance variables we",
					2, c.getDeclaredFields().length);

			assertEquals("You must make your instance variables private.", true,
					Modifier.isPrivate(c.getDeclaredField("cardNumber").getModifiers()));
			assertEquals("You must make your instance variables private.", true,
					Modifier.isPrivate(c.getDeclaredField("pin").getModifiers()));

			assertEquals("Your instance variables must NOT be static.", false,
					Modifier.isStatic(c.getDeclaredField("cardNumber").getModifiers()));
			assertEquals("Your instance variables must NOT be static.", false,
					Modifier.isStatic(c.getDeclaredField("pin").getModifiers()));

			assertEquals("You must make your cardNumber instance variable of type int.", (int.class),
					c.getDeclaredField("cardNumber").getType());
			assertEquals("You must make your pin instance variable of type int.", (int.class),
					c.getDeclaredField("pin").getType());

		} catch (NoSuchFieldException e) {
			fail("Could not find the " + e.getLocalizedMessage().toString() + " instance variable");
		} catch (Exception e) {
			fail("Something weird went wrong");
		}
	}

	@Test
	public void DebitCardDefaultConstructor() {
		DebitCard testDebitCard = new DebitCard();
		@SuppressWarnings("rawtypes")
		Class c = testDebitCard.getClass();
		@SuppressWarnings("rawtypes")
		Class superC = c.getSuperclass();
		try {

			Field name = superC.getDeclaredField("name");
			name.setAccessible(true);
			String nameValue = (String) name.get(testDebitCard);
			assertEquals("When checking the value of name we", "Jane Doe", nameValue);

			Field cardNumber = c.getDeclaredField("cardNumber");
			cardNumber.setAccessible(true);
			int cardNumberValue = (int) cardNumber.get(testDebitCard);
			assertEquals("When checking the value of cardNumber we", 00000000, cardNumberValue);

			Field pin = c.getDeclaredField("pin");
			pin.setAccessible(true);
			int pinValue = (int) pin.get(testDebitCard);
			assertEquals("When checking the value of pin we", 0, pinValue);

		} catch (Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public void DebitCardParameterizedConstructor() {
		DebitCard testDebitCard = new DebitCard("Zachary Taylor", 18491850, 1234);
		@SuppressWarnings("rawtypes")
		Class c = testDebitCard.getClass();
		@SuppressWarnings("rawtypes")
		Class superC = c.getSuperclass();
		try {

			Field name = superC.getDeclaredField("name");
			name.setAccessible(true);
			String nameValue = (String) name.get(testDebitCard);
			assertEquals("When checking the value of name we", "Zachary Taylor", nameValue);

			Field cardNumber = c.getDeclaredField("cardNumber");
			cardNumber.setAccessible(true);
			int cardNumberValue = (int) cardNumber.get(testDebitCard);
			assertEquals("When checking the value of cardNumber we", 18491850, cardNumberValue);

			Field pin = c.getDeclaredField("pin");
			pin.setAccessible(true);
			int pinValue = (int) pin.get(testDebitCard);
			assertEquals("When checking the value of pin we", 1234, pinValue);

		} catch (Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public void DebitCardCardToString() {
		DebitCard myDebitCard = createDebitCard("James K. Polk", 12345678, 1234);
		assertEquals("After calling the cardToString method, we", "Card Holder: James K. Polk Card Number: 12345678",
				myDebitCard.toString());
	}

	private DebitCard createDebitCard(String aName, int aCardNumber, int aPin) {

		DebitCard myDebitCard = new DebitCard();
		@SuppressWarnings("rawtypes")
		Class c = myDebitCard.getClass();
		@SuppressWarnings("rawtypes")
		Class superC = c.getSuperclass();
		try {
			Field name = superC.getDeclaredField("name");
			name.setAccessible(true);
			name.set(myDebitCard, aName);

			Field cardNumber = c.getDeclaredField("cardNumber");
			cardNumber.setAccessible(true);
			cardNumber.set(myDebitCard, aCardNumber);

			Field pin = c.getDeclaredField("pin");
			pin.setAccessible(true);
			pin.set(myDebitCard, aPin);

		} catch (Exception e) {
			fail(e.toString());
		}
		return myDebitCard;
	}

	// IDCard test cases

	@Test
	public void IDCardSuperClass() {
		IDCard myIDCard = new IDCard();
		assertEquals("Testing if the IDCard Super Class is a Card, we", true, (myIDCard instanceof Card));
	}

	@Test
	public void IDCardInstanceVariablesTest() {
		IDCard testIDCard = new IDCard();
		@SuppressWarnings("rawtypes")
		Class c = testIDCard.getClass();
		try {
			c.getDeclaredField("idNumber");

			assertEquals(
					"You must only have the instance variables specified in the lab manual. When looking at the number of instance variables we",
					1, c.getDeclaredFields().length);

			assertEquals("You must make your instance variables private.", true,
					Modifier.isPrivate(c.getDeclaredField("idNumber").getModifiers()));

			assertEquals("Your instance variables must NOT be static.", false,
					Modifier.isStatic(c.getDeclaredField("idNumber").getModifiers()));

			assertEquals("You must make your idNumber instance variable of type int.", (int.class),
					c.getDeclaredField("idNumber").getType());

		} catch (NoSuchFieldException e) {
			fail("Could not find the " + e.getLocalizedMessage().toString() + " instance variable");
		} catch (Exception e) {
			fail("Something weird went wrong");
		}
	}

	@Test
	public void IDCardDefaultConstructor() {
		IDCard testIDCard = new IDCard();
		@SuppressWarnings("rawtypes")
		Class c = testIDCard.getClass();
		@SuppressWarnings("rawtypes")
		Class superC = c.getSuperclass();
		try {

			Field name = superC.getDeclaredField("name");
			name.setAccessible(true);
			String nameValue = (String) name.get(testIDCard);
			assertEquals("When checking the value of name we", "Jane Smith", nameValue);

			Field idNumber = c.getDeclaredField("idNumber");
			idNumber.setAccessible(true);
			int idNumberValue = (int) idNumber.get(testIDCard);
			assertEquals("When checking the value of cardNumber we", 0, idNumberValue);

		} catch (Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public void IDCardParameterizedConstructor() {
		IDCard testIDCard = new IDCard("John Tyler", 10);
		@SuppressWarnings("rawtypes")
		Class c = testIDCard.getClass();
		@SuppressWarnings("rawtypes")
		Class superC = c.getSuperclass();
		try {

			Field name = superC.getDeclaredField("name");
			name.setAccessible(true);
			String nameValue = (String) name.get(testIDCard);
			assertEquals("When checking the value of name we", "John Tyler", nameValue);

			Field idNumber = c.getDeclaredField("idNumber");
			idNumber.setAccessible(true);
			int idNumberValue = (int) idNumber.get(testIDCard);
			assertEquals("When checking the value of cardNumber we", 10, idNumberValue);

		} catch (Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public void IDCardCardToString() {
		IDCard myIDCard = createIDCard("William Henry Harrison", 9);
		assertEquals("After calling the cardToString method, we", "Card Holder: William Henry Harrison ID Number: 9",
				myIDCard.toString());
	}

	private IDCard createIDCard(String aName, int anidNumber) {
		IDCard myIDCard = new IDCard();
		@SuppressWarnings("rawtypes")
		Class c = myIDCard.getClass();
		@SuppressWarnings("rawtypes")
		Class superC = c.getSuperclass();
		try {
			Field name = superC.getDeclaredField("name");
			name.setAccessible(true);
			name.set(myIDCard, aName);

			Field cardNumber = c.getDeclaredField("idNumber");
			cardNumber.setAccessible(true);
			cardNumber.set(myIDCard, anidNumber);
		} catch (Exception e) {
			fail(e.toString());
		}
		return myIDCard;
	}

	// DriversLicense test cases

	@Test
	public void DriversLicenseSuperClass() {
		DriversLicense myDriversLicense = new DriversLicense();
		assertEquals("Testing if the DriversLicense Super Class is a IDCard, we", true,
				(myDriversLicense instanceof IDCard));
		assertEquals("Testing if the DriversLicense Super Class is a Card, we", true,
				(myDriversLicense instanceof Card));
	}

	@Test
	public void DriversLicenseInstanceVariablesTest() {
		DriversLicense testDriversLicense = new DriversLicense();
		@SuppressWarnings("rawtypes")
		Class c = testDriversLicense.getClass();
		try {
			c.getDeclaredField("expirationYear");
			c.getDeclaredField("expirationMonth");

			assertEquals(
					"You must only have the instance variables specified in the lab manual. When looking at the number of instance variables we",
					2, c.getDeclaredFields().length);

			assertEquals("You must make your instance variables private.", true,
					Modifier.isPrivate(c.getDeclaredField("expirationYear").getModifiers()));

			assertEquals("Your instance variables must NOT be static.", false,
					Modifier.isStatic(c.getDeclaredField("expirationYear").getModifiers()));

			assertEquals("You must make your expirationYear instance variable of type int.", (int.class),
					c.getDeclaredField("expirationYear").getType());
			assertEquals("You must make your instance variables private.", true,
					Modifier.isPrivate(c.getDeclaredField("expirationMonth").getModifiers()));

			assertEquals("Your instance variables must NOT be static.", false,
					Modifier.isStatic(c.getDeclaredField("expirationMonth").getModifiers()));

			assertEquals("You must make your expirationYear instance variable of type int.", (Month.class),
					c.getDeclaredField("expirationMonth").getType());

		} catch (NoSuchFieldException e) {
			fail("Could not find the " + e.getLocalizedMessage().toString() + " instance variables");
		} catch (Exception e) {
			fail("Something weird went wrong");
		}
	}

	@Test
	public void DriversLicenseDefaultConstructor() {
		DriversLicense testDriversLicense = new DriversLicense();
		@SuppressWarnings("rawtypes")
		Class c = testDriversLicense.getClass();
		@SuppressWarnings("rawtypes")
		Class superC = c.getSuperclass();
		@SuppressWarnings("rawtypes")
		Class grandparrentC = superC.getSuperclass();
		try {

			Field name = grandparrentC.getDeclaredField("name");
			name.setAccessible(true);
			String nameValue = (String) name.get(testDriversLicense);
			assertEquals("When checking the value of name we", "Jane Smith", nameValue);

			Field idNumber = superC.getDeclaredField("idNumber");
			idNumber.setAccessible(true);
			int idNumberValue = (int) idNumber.get(testDriversLicense);
			assertEquals("When checking the value of cardNumber we", 0, idNumberValue);

			Field expirationYear = c.getDeclaredField("expirationYear");
			expirationYear.setAccessible(true);
			int expirationYearValue = (int) expirationYear.get(testDriversLicense);
			assertEquals("When checking the value of expirationYear we", 1969, expirationYearValue);
			
			Field expirationMonth = c.getDeclaredField("expirationMonth");
			expirationMonth.setAccessible(true);
			Month expirationMonthValue = (Month) expirationMonth.get(testDriversLicense);
			assertEquals("When checking the value of expirationMonth we", Month.JANUARY, expirationMonthValue);

		} catch (Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public void DriversLicenseParameterizedConstructor() {
		DriversLicense testDriversLicense = new DriversLicense("Martin Van Buren", 8, 1841, Month.JULY);
		@SuppressWarnings("rawtypes")
		Class c = testDriversLicense.getClass();
		@SuppressWarnings("rawtypes")
		Class superC = c.getSuperclass();
		@SuppressWarnings("rawtypes")
		Class grandparrentC = superC.getSuperclass();
		try {

			Field name = grandparrentC.getDeclaredField("name");
			name.setAccessible(true);
			String nameValue = (String) name.get(testDriversLicense);
			assertEquals("When checking the value of name we", "Martin Van Buren", nameValue);

			Field idNumber = superC.getDeclaredField("idNumber");
			idNumber.setAccessible(true);
			int idNumberValue = (int) idNumber.get(testDriversLicense);
			assertEquals("When checking the value of cardNumber we", 8, idNumberValue);

			Field expirationYear = c.getDeclaredField("expirationYear");
			expirationYear.setAccessible(true);
			int expirationYearValue = (int) expirationYear.get(testDriversLicense);
			assertEquals("When checking the value of expirationYear we", 1841, expirationYearValue);
			
			Field expirationMonth = c.getDeclaredField("expirationMonth");
			expirationMonth.setAccessible(true);
			Month expirationMonthValue = (Month) expirationMonth.get(testDriversLicense);
			assertEquals("When checking the value of expirationMonth we", Month.JULY, expirationMonthValue);

		} catch (Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public void DriversLicenseCardToString() {
		DriversLicense myDriversLicense = createDriversLicense(Month.JULY, 1861, "James Buchanan", 15);
		assertEquals("For cardToString", "Card Holder: James Buchanan ID Number: 15 Expiration Month & Year: JULY 1861",
				myDriversLicense.toString());
	}

	private DriversLicense createDriversLicense(Month anExpirationMonth, int anExpirationYear, String aName, int anidNumber) {
		DriversLicense testDriversLicense = new DriversLicense();
		@SuppressWarnings("rawtypes")
		Class c = testDriversLicense.getClass();
		@SuppressWarnings("rawtypes")
		Class superC = c.getSuperclass();
		@SuppressWarnings("rawtypes")
		Class grandparrentC = superC.getSuperclass();
		try {

			Field name = grandparrentC.getDeclaredField("name");
			name.setAccessible(true);
			name.set(testDriversLicense, aName);

			Field cardNumber = superC.getDeclaredField("idNumber");
			cardNumber.setAccessible(true);
			cardNumber.set(testDriversLicense, anidNumber);

			Field expirationYear = c.getDeclaredField("expirationYear");
			expirationYear.setAccessible(true);
			expirationYear.set(testDriversLicense, anExpirationYear);
			
			Field expirationMonth = c.getDeclaredField("expirationMonth");
			expirationMonth.setAccessible(true);
			expirationMonth.set(testDriversLicense, anExpirationMonth);

		} catch (Exception e) {
			fail(e.toString());
		}
		return testDriversLicense;
	}

}
