import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 
 
public class ContactTest { 
 
  @Test 
  void constructor_setsNameCorrectly() { 
    Contact c = new Contact("Ada Lovelace", "+1 617 555 0101"); 
    assertEquals("Ada Lovelace", c.getName()); 
  } 
 
  @Test
  void constructor_setsPhoneCorrectly() { 
    Contact c = new Contact("Ada Lovelace", "+1 617 555 0101"); 
    assertEquals("+1 617 555 0101", c.getPhone()); 
  } 
 
  @Test
  void getName_returnsExactString_notTransformed() { 
    Contact c = new Contact("Grace Hopper", "555-0000"); 
    assertEquals("Grace Hopper", c.getName());
  } 
 
  @Test
  void toString_containsName() { 
    Contact c = new Contact("Alan Turing", "555-0001"); 
    assertTrue(c.toString().contains("Alan Turing"));
  } 
 
  @Test
  void toString_containsPhone() {
    Contact c = new Contact("Alan Turing", "555-0001");
    assertTrue(c.toString().contains("555-0001"));
  }

  @Test
  void contactsWithSameName_maintainIndependentPhoneNumbers() {
    // Arrange: two distinct Contact instances sharing the same name
    Contact contact1 = new Contact("Ada Lovelace", "+1 617 555 0101");
    Contact contact2 = new Contact("Ada Lovelace", "+1 617 555 9999");

    // Assert: names are identical, but phone numbers and objects are distinct
    assertEquals(contact1.getName(), contact2.getName());
    assertNotEquals(contact1.getPhone(), contact2.getPhone());
    assertNotEquals(contact1.toString(), contact2.toString());
  }
} 