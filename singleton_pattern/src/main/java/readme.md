<h2>How to implement Singleton Pattern</h2>

Before we answer the question how to implement Singleton Pattern, we need to know:
1. How to 1 class has only one instance
2. How to globally access to the instance

Answer:
- We need to declare class's private constructor to ensure another class can not access and create new instance
- Declare 1 private static variable which is the only expression of this class
- Create 1 public static method to globally access this instance