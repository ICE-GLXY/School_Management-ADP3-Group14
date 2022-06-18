Application Development Practice 3

Course code: ADP372S

June Assignment


School Management System

Group: ADP3 Group14
Group members and student numbers:
   - Chante Lewis:216118395
   - Titilayo Akinjole: 220283982
   - Lelihle Gazi: 214258041
   - Abdul Aleem Chilwan: 220108447
   - Mogammad Taariq Phillips:220166153 
   - Moegammad Tasreeq Adams:216173027
   
Group leader: Mogammad Taariq Phillips:220166153 


Task/Entity allocation:
- Name - Titilayo Akinjole 
- Employee- Mogammad Taariq Phillips
- EmployeeAddress- Abdul Aleem Chilwan
- Address- Lelihle Gazi 
- City- Moegammad Tasreeq Adams
- Country -Moegammad Tasreeq Adams
- Student -Chante Lewis 
- Student address-Chante Lewis


Structure of Code

Packaging:
- controller
- domain
- factory
- repository
- service
- Test packages for domain, factory, service, and controller.

Problem Statement 

In the quest for seamless and effective organisational processes in a college, the technology
department of the college has been given the task to digitize and automate its academic-facing
processes.

Requirements For Assignment

1. Create a Maven Java project called school_management.

2. In the root package of your project, create domain, factory, repository and service packages.

3. Use the appropriate design pattern where necessary.
 
4. Use helper classes and methods for re-occurring functionalities.

5. Consider the abstraction and adoption of good packaging principles in your project.

Improvements that could be made to the assignment.
- Normalized Tables for UML diagram.
- Read,Update,Delete anomalies.
- Flawed design = more expensive and complex to handle .
- Loose coupling instead of tightly coupling to make entities dependable.
- The entities on the UML are tightly connected, which means they are reliant on one another, limiting their flexibility. Instead of being a value object, Address should have been a complete entity. This would allow StudentAddress and EmployeeAddress to act as a bridge entity, as it should when two Entities share a composite key. Employee and EmployeeAddress will become an OneToMany relationship, while Student and StudentAddress will become an OneToMany relationship.








