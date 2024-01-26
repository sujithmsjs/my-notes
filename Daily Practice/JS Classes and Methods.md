Array Methods:
- Remove duplicates using reducer
- Remove duplicates using filter
- Find the secound max value
- Find the secound min value

const arr = Array.from({
  length: 10
}, (_, i) => Math.round(Math.random() * 100));
console.info(arr);

// Returns a random integer from 1 to 100:
Math.floor(Math.random() * 100) + 1;

function getRndInteger(min, max) {
  return Math.floor(Math.random() * (max - min) ) + min;
}


const sum = users.reduce( (total, user, index) =>  total + user.marks, 0 );
console.info(sum/users.length);


*pedicate = e ==> boolean;

length variable
delete keyword

arr	some( predicate )
arr	every( predicate )
int	indexOf()
arr	reduce( (value, element) => value, initialValue );
str 	toString()
obj	pop()
length	push()
obj	shift()
obj	unshift()
str	join(string)

arr	concat(...arrays)
arr	concat(element)

arr	flat()
void 	splice(index, deleteElementsCount, ...addElements)
arr 	slice(index)
arr 	slice(end)
arr 	slice(start, end)
arr	mutable	sort()
arr	sort((a, b) => b - a)


ele	find(predicate)
int	findIndex(predicate)
ele	findLast(predicate)
int	findLastIndex(predicate)

Array.from("foo"); // [ "f", "o", "o" ]
const set = new Set(["foo", "bar", "baz", "foo"]);


map(MapFn) and Array.from(arr, MapFN) both are equal.
"A".charCodeAt(0) // To know the ACIEE value

What is Shallow copy and Deep copy?

A shallow copy of an object is a copy whose properties share the same references (point to the same underlying values) as those of the source object from which the copy was made. As a result, when you change either the source or the copy, you may also cause the other object to change too. That behavior contrasts with the behavior of a deep copy, in which the source and copy are completely independent.





Regular Expression

/pattern/modifiers;


text.search(/w3schools/i);



const regex = new RegExp(searchString, 'i');
return regex.test(inputText);


const arr = [2, 3, 5, 1, 3, 5, 76, 5, 3, 2, 8, 2];

const sum = arr.reduce((sum, value) => sum + value, 0);
console.info('Summation: ', sum);

arr.sort((a, b) => a - b);
console.info('Sorted: ', arr);

// Remove duplicates with reduce

const uniArr = arr.reduce((uni, ele) => {
    if (uni.indexOf(ele) === -1) {
      uni.push(ele);
    }
    return uni;
  },
  []);
console.info('Unique: ', uniArr);


// Remove duplicate with filter
 const uniArr2 = arr.filter(
  (ele, index, arr) => arr.indexOf(ele) === index)
  
console.info('Unique 2: ', uniArr2);

// Remove duplicate with filter using Index of
const arr3 = arr.map(
	(ele, index, arr) => ({ id : ele}) )



// Remove duplicate in an objects

const uniArr3 = arr3.filter(
	(ele, i, a) => a.findIndex( e => e.id === ele.id ) === i 
)

console.info('Unique 3: ', uniArr3);

// Use set to remove duplciates.

const arr4 = Array.from( {length : 20},( (a, b) =>  i + 1, 0));
console.info(arr4);



---
ES 6 Features

https://www.w3schools.com/js/js_es6.asp

---

// Dynamic Search

const searchResult = games.filter( e => e.title.search(new RegExp('te', 'i')) > -1);
console.log(searchResult);






























