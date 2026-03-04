Product: Creates a product in inventory with an ID, name, category, price, quantity in stock, and supplier.
ProductInventory: Is a collection of Product objects using a Vector. Methods such as adding, removing, searching, grouping, stock updates, capacity management, and Enumeration traversal.
OrderItem: Creates a single item in an order, including product details, quantity, unit price, and subtotal calculation.
Order: Using Vector to create multiple OrderItem objects. Includes adding, removing items, calculating totals, and tracking order status.
OrderManager: Manages multiple Order objects using a Vector. Supports finding orders, filtering by status or customer, canceling orders, and calculating total revenue.
VectorUtils: Generic utility methods that operate on Vector<T>, such as swapping elements and filtering using a Predicate.
GenericContainer<T>: A generic wrapper around Vector<T> that adds utility methods like returning copies of data and adding all elements from another Vector.
VectorComparisonDemo: Compares Vector and ArrayList performance by measuring add time, access time, and memory usage.
InventorySystemMain: Main class that demonstrates all system features.

To compile and run use 
```
javac *.java
java InventorySystemMain
```

Some challenges was I wasn't able to figure out the logics of some methods like hashCode() or filter in the VectorUtils because I didn't know what to expect out of it. ALso the Predicate I never heard of and how to get the memory of the Vector and ArrayList.

I got a better understanding of Vectors and ArrayList, how to create instance methods and how to use them. I learned about logics of the methods and how to properly create them. How to access the capacity and how to optimize them. Learned how to access the memory of
Vector and ArrayList. 