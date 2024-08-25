How does hashset works?

- I will depend on two methods one hashCode and equals.
- If a element is entered into set, it will consider the hashcode and calculate the bucket number it has to go in.
- If the secound element comes, if the hashcode is not equals it will directly add it to another bucket.

Adding a element in Set
-----------------------

1. Calculate the hash code of the new element.
2. Determine the index of the bucket where the element should be stored based on its hash code.
3. If the bucket at the calculated index is empty:
     - Add the new element directly to that bucket.
4. If the bucket is not empty (collision occurs):
     - Iterate over each existing element in the bucket.
     - For each existing element:
         - Call its equals() method to compare it with the new element.
         - If the equals() method returns true (indicating equality):
             - The new element is considered a duplicate and is not added to the set.
     - If none of the existing elements in the bucket are equal to the new element:
         - Add the new element to the bucket.
		 
		 
When checking for the presence of an element
--------------------------------------------

   - Calculate the hash code of the element.
   - Determine the index of the bucket using the hash code.
   - If the bucket is empty, the element is not in the set.
   - If the bucket contains elements:
     - Traverse the linked list within the bucket.
     - Compare each element in the linked list with the target element using the equals() method.
     - If a match is found, the element is present in the set.

When removing an element
------------------------

   - Calculate the hash code of the element.
   - Determine the index of the bucket using the hash code.
   - If the bucket is empty, the element is not in the set.
   - If the bucket contains elements:
     - Traverse the linked list within the bucket.
     - If a match is found with the target element:
       - Remove the element from the linked list.

Ensure efficiency
-----------------

   - Use a good hash function to distribute elements evenly across buckets.
   - Adjust the size of the array dynamically to maintain a good balance between space and efficiency.