MODUL3 / Module 04 SOLID — Order Management System (Java)

How to run (from project root):
1) Compile:
   javac -d out (Windows: use ; instead of :) -sourcepath src src/modul3/Demo.java

   Example (Linux/Mac):
   javac -d out -sourcepath src src/modul3/Demo.java

2) Run:
   java -cp out modul3.Demo

Project structure:
src/modul3/...
- order      : Order, items, status
- payment    : IPayment and implementations
- delivery   : IDelivery and implementations
- notification: notifications + center
- discount   : Discount rules + calculator
- service    : OrderService orchestration
