import java.util.*; 
 
public class ContactManager { 
     public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 

        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0111")); 
        contacts.put("Grace Allen", new Contact("Grace Allen", "+1 617 565 0121")); 
        contacts.put("Tom Jones", new Contact("Tom Jones", "+1 617 755 0131")); 
        contacts.put("Joe Blow", new Contact("Joe Blow", "+1 617 558 0141")); 
        contacts.put("John Won", new Contact("John Won", "+1 617 595 0151")); 

        System.out.println("=== Contact Search ===");
        String searchName = "Ada Lovelace";
        Contact searchResult = contacts.get(searchName);

        if(searchResult != null ) {
            System.out.println(searchResult);
        } else {
            System.out.println("Contact not found.");
        }
        System.out.println("");
 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());  
        sorted.sort((a, b) -> a.getName().compareTo(b.getName())); 

        System.out.println("=== All Contacts ===");
        for (Contact contact : sorted) {
            System.out.println(contact);
        } 
    }
}