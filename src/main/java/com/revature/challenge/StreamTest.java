package com.revature.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.revature.models.Address;
import com.revature.models.MobileNumber;
import com.revature.models.Student;
import com.revature.models.TempStudent;

public class StreamTest {
	
    public static void main(String[] args) {
    	
    	/*
    	 * ============== Don't alter the code between lines 24 - 42 ==============
    	 */
 
        Student student1 = new Student(
            "Bob",
            20,
            new Address("1234"),
            Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
 
        Student student2 = new Student(
            "Alice",
            20,
            new Address("1235"),
            Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
 
        Student student3 = new Student(
            "Wally",
            20,
            new Address("1236"),
            Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
 
        List<Student> students = Arrays.asList(student1, student2, student3);
        
    	/*
    	 *========== Don't alter the code above (lines 24 - 42) ===============
    	 */
        
        /***************************************************************************
         (1) Get the student with the name "Bob" and print his name to the console.
             If "Bob" does not exist, print "No student found".
     	     HINT: Store students.stream()...etc to an Optional<Student> in the case that the student
             doesn't exist. Resource: https://www.geeksforgeeks.org/java-8-optional-class/
        ****************************************************************************/

        
        

        Optional<Student> bobStudent = students.stream()
        									  .filter(s -> s.getName().equals("Bob"))
        									  .findFirst();
        									  
    	if (bobStudent.isPresent()) {
			System.out.println(bobStudent.get());
		}else {
			System.out.println("No student found");
		}
        
        System.out.println("===========================================");
        /***************************************************************************
         (2) Get the student with matching address "1235" and print their name to the console.
             If the address does not exist, print "No student found".
             HINT: Store students.stream()...etc to an Optional<Student> in the case that the student
             doesn't exist. Resource: https://www.geeksforgeeks.org/java-8-optional-class/
        ****************************************************************************/

        
    	Optional<Student> addressStudent = students.stream()
				  .filter(s -> s.getAddress().getZipcode().equals("1235"))
				  .findFirst();
				  
    	if (addressStudent.isPresent()) {
    		System.out.println(addressStudent.get());
    	}else {
    		System.out.println("No student found");
    	}

        
        
        System.out.println("=============================================");
        
        /****************************************************************************
         (3) Get all the students that have the mobile number "3333" and print their
             names to the console.
        *****************************************************************************/
    	
    	List<Student> students3333 = students.stream()
    						.filter(s -> s.getMobileNumbers() .stream()
    								.anyMatch(n -> n.getNumber().equals("3333")))
    						.collect(Collectors.toList());
    		
    	
        students3333.forEach(n -> System.out.println(n.getName()));
        

        
        System.out.println("==================================================");
        
        
        /***************************************************************************
         (4) Get all student having mobile number "1233" and "1234" and print their
             names to the console.
         ***************************************************************************/
        	
        List<Student> students2nums = students.stream()
											.filter(s -> s.getMobileNumbers() 
													.stream()
													.anyMatch(n -> n.getNumber().equals("1233")))
											.filter( s -> s.getMobileNumbers()
													.stream()
													.anyMatch(n -> n.getNumber().equals("1234")))
											.collect(Collectors.toList());

        students2nums.forEach(n -> System.out.println(n.getName()));

        System.out.println("==================================================");
        
        
        
        
        
        
        /***************************************************************************
	     (5) Create a List<Student> from the tmpStudents List. Call it studentList.
	         Hint: Use Collectors.toList(). Print it to the console. 
	         Resource: https://www.geeksforgeeks.org/collectors-tolist-method-in-java-with-examples/
        ****************************************************************************/
        TempStudent tmpStud1 = new TempStudent(
            "Bob1",
            201,
            new Address("12341"),
            Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));
 
        TempStudent tmpStud2 = new TempStudent(
            "Alice1",
            202,
            new Address("12351"),
            Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));
 
        List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);
        
        // Code your Solution here, don't touch the code above
 

        
        List<Student> studentList = tmpStudents.stream()
        										.map(s -> new Student(s.name, s.age, s.address, s.mobileNumbers))
        										.collect(Collectors.toList());
       
        
        studentList.forEach(s -> System.out.println(s));
        
        System.out.println("===============================================================");
 
        /***************************************************************************
         (6) Convert the List<Student> called studentList that you made in question (5) to 
             List<String> of just their names. Call this new list "studentNames". 
             Print it to the console.
        ****************************************************************************/

         List<String> studentNames = studentList.stream()
        		 							.map( s -> s.getName())
        		 							.collect(Collectors.toList());
        
        
        studentNames.forEach( n -> System.out.println(n));
        
        System.out.println("================================================");
        
        /***************************************************************************
          (7) Convert List<Students> to a single String called name with just their names.
          	  Print that String to the console.
        ****************************************************************************/

        
        String names= students.stream()
        						.map( s -> s.getName())
        						.collect(Collectors.joining(", "));

        
        System.out.println(names);
        
        System.out.println("======================================================");
        /****************************************************************************
         (8) Change all the Strings within the List<String> nameList to Upper Case.
             Print it to the screen.
        *****************************************************************************/
        List<String> nameList =
            Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");
 
        nameList.stream()
       			.map( n -> n.toUpperCase())
       			.forEach(n -> System.out.println(n));

        
        
        
        
        /****************************************************************************
         (9) Sort List<String> namesList by natural order.
             Hint: Research .sorted() method https://www.geeksforgeeks.org/stream-sorted-in-java/#:~:text=Stream%20sorted()%20returns%20a,streams%2C%20no%20stability%20is%20guaranteed.
         *****************************************************************************/
        List<String> namesList =
            Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");
 
        namesList.stream()
        	.sorted()
        	.forEach(n -> System.out.println(n));


        
        
 
    }
    
    
}






