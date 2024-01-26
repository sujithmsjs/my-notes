# NEW ARRAY METHODS

Static method:

of, at, from, isArray, join,
entries, keys, values


Array.of:

Array.of(7); // [7]
Array(7); // array of 7 empty slots

Array.of(1, 2, 3); // [1, 2, 3]
Array(1, 2, 3); // [1, 2, 3]


Array.from:
The Array.from() static method creates a new, shallow-copied Array instance from an iterable or array-like object.


const arr = Array.from({length : 10}, (_, i) => i + 1)
console.info(arr)

### Array from a Map
```javascript

const map1 = new Map();

map1.set('a', 1);
map1.set('b', 2);
map1.set('c', 3);

console.log(map1.size);
console.log(map1.get('a'));
// Expected output: 1

map1.set('a', 97);

console.log(map1.get('a'));
// Expected output: 97

console.log(map1.size);
// Expected output: 3

map1.delete('b');

console.log(map1.size);
// Expected output: 2

console.log(Array.from(map1));
// [ [ 'a', 97 ], [ 'c', 3 ] ]

console.log(map1.values());
// [Map Iterator] { 97, 3 }

console.log(Array.from(map1.values()));
// [ 97, 3 ]

console.log(map1.keys());
// [Map Iterator] { 'a', 'c' }

console.log(Array.from(map1.keys()));
// [ 'a', 'c' ]
```










find, findIndex, findLast, findLastIndex
includes, indexOf, lastIndexOf

filter, map, reduce, flat, flatMap

forEach,

toReverse, toSorted, toLocaleString, toSpliced, toSting


some, every




string		toString()
array		Array.of(...element)
boolean 	Array.isArray(value)
array		Array.from(arrayLike, mapFn)

element 	at(index)
array 		concat(...elements)
array 		copyWithin(target, start)
array		copyWithin(target, start, end)

iterator	entries()
iterator	keys()

boolean 	some(callbackFn)
boolean	every(callbackFn)


element	find(callbackFn)
index		findIndex(callbackFn)
element	findLast(callbackFn)
index		findLastIndex(callbackFn)

array		filter(callbackFn)
array		flat()
array		flat(depth)

array		flatMap(callbackFn)

void		forEach(callbackFn)


boolean 	includes(searchElement)
boolean 	includes(searchElement, fromIndex)

index 		indexOf(searchElement)
index		indexOf(searchElement, fromIndex)



string 		join()
string 		join(separator)

array		reverse()
array		flatMap()
array		map()
array		reduce()
array		reduceRight()
array		slice()
array		toSorted()
array		toSorted(compareFn)
array		toReversed()
array		toSorted()
array		toSpliced()
array		with(index, value)


Ex: 
Array.from(set);
Array.from(string);
Array.from(map);
Array.from(map);



# values

### MUTABLE METHODS

array		fill(value)
array 		fill(value, start)
array		fill(value, start, end)
array		

copyWithin()
pop()
push()
reverse()
shift()
unshift
sort()
sort(compareFn)
splice()

function compareFn(a, b) {
  return 0;
}

function mapFn(element, index){
	return object;
}

JavaScript array-copy operations create shallow copies. (All standard built-in copy operations with any JavaScript objects create shallow copies, rather than deep copies).



















