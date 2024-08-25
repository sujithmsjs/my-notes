- the first element that matches, use find().
- the index of the last matching element in the array, use findLastIndex().
- the index of a value, use indexOf(). (It's similar to findIndex(), but checks each element for equality with the value instead of using a testing function.)
- whether a value exists in an array, use includes(). Again, it checks each element for equality with the value instead of using a testing function.
- if any element satisfies the provided testing function, use some().



element 	at(index); // index can be negative/positive
newArray 	concat(value1, value2, ..., valueN) // values can be arrays or objects
newArray 	flat() // By default depth is 1
newArray 	flat(depth) // Depth can be any number and also Infinity.
element		find(callbackFn)
element 	findLast(callbackFn)
number 		findIndex(callbackFn)
number 		findLastIndex(callbackFn)
boolean 	includes(searchElement)
boolean 	includes(searchElement, fromIndex)
number 		indexOf(searchElement)
number 		indexOf(searchElement, fromIndex)
boolean 	some(callbackFn)
boolean 	every(callbackFn)
string 			join()
string			join(separator)
arrayIterator 	keys()
arrayIterator 	entries()
arrayIterator 	values()
array			map(callbackFn)
array 			reverse()
lastElement		pop()
arrayLength 	push(element1, element2, ..., elementN)
removedElement 	shift()
newArrayLength 	unshift(element1, element2, ..., elementN)
newArray		with(index, value); // To change single value
sameArray		sort(compareFn)
void			splice(start, deleteCount, item1, item2, ..., itemN)
sameArray		reverse();
newArray 		toSpliced(start, deleteCount, item1, item2, ..., itemN)
newArray		toSorted(compareFn)
newArray		toReversed();
sameArray 		sort(compareFn);


const value = inventory.find( inv => inv.quantity > 4);
const value2 = inventory.find( ({quantity}) => quantity > 4);

const arr = ["a", , "c"];
const sparseKeys = Object.keys(arr);
const denseKeys = [...arr.keys()];
sparseKeys?
denseKeys?


