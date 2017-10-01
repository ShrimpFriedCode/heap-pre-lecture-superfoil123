# Pre-lecture assignment about heaps

Implement the `max_heapify` method within the Heap class.
Many of the heap operations need to turn an array that is almost a max
heap, except for one element, into a max heap. The max_heapify
operation moves the element at position i into the correct position.

The tree rooted at i is not a max heap, but the subtrees
left(i) and right(i) are max heaps.

Example: 4 is greater than one of its children so we swap it with
the larger child and repeat.

~~~~
             ___16___
            /        \
          *4*         10
         /  \        /  \
        /    \      9    3
       14      7
      / \    /
     2   8  1
~~~~
	
~~~~	
             ___16___
            /        \
          14          10
         /  \        /  \
        /    \      9    3
      *4*     7
      / \    /
     2   8  1
~~~~
	
~~~~	
             ___16___
            /        \
          14          10
         /  \        /  \
        /    \      9    3
       8      7
      / \    /
     2  *4* 1
~~~~
