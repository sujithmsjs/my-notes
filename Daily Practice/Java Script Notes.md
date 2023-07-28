
## Expressions
```javascript
1 / 0       // Infinity
NaN + 1     // NaN
3 * NaN     // NaN
"not a number" / 2 - 1      // NaN
null == ''		// false
null == null		// true
null == undefined	// true
undefined == null	// true
undefined == undefined	// true
123 === '123'		// false
123 == '123'		// true
{} == {}		// SyntaxError
{} === {}		// SyntaxError
[] == []		// false
[] === []		// false
100 + '200' + 300	// '100200300'
'100' + 200 + 300	// '100200300'
100 + 200 + '300'	// '300300'
100 + 200 - '300'	// 0
100 + 200 * '300'	// 60100
'100' - 200 + 300	// 200
0x1234 			// 4660
0b1010 			// 10
0xff 			// 255
1e1			// 10
7e6			// 7000000
7e6.toString()		// '7000000'
10000..toString(2);	// '10011100010000'
typeof 1e6		// 'number
10 + '5'		// '105'
10 - '5'		// 5
10 + 5			// 15
'100' - 50 		// 50
1234.toString(16)	// SyntaxError
1234..toString(16)	// '4d2'
5 ** 5			// 312
typeof 231332424n	// bigint
/^[0-9]$/.test(2)	// true
/^[0-9]$/.test('7')	// true
/^[0-9]$/.test('7')		// true
/^[0-9]{4}$/.test('1234')	// true
/^[0-9]{4}$/.test(4561)		// true
/^Sujith$/i.test('SuJiTH')	// true
/[0-9]/.constructor.name	// 'RegExp'

typeof undefined	// "undefined"
typeof 0	// "number"
typeof 10n	// "bigint"
typeof true	// "boolean"
typeof "foo"	// "string"
typeof Symbol("id")	// "symbol"
typeof Math	// "object"  (1)
typeof null	// "object"  (2)
typeof alert	// "function"  (3)

!!''	// false
!! ' '	// true
!! false	// false
!!true		// true
!!0	// false
!!23432	// true
!!0.001 	// true
!!0.0001	// true
!! NaN		// false
!! Infinity	// true
!! -Infinity	// true

true - true	// 0
true - false	// 1
false - true	// -1
false - false	// 0
true * true	// 1
true + true	// 2

3 + +'7'	// 10
3 + -'7'	// -4
3*'7'	// 21
"6" / "2"	// 3
```

`typeof x` as same as `typeof(x)`

## String Metods
```javascript
let email = 'sujithmsjs@gmail.com'

'sujithmsjs@gmail.com'
email.substring(10)	// '@gmail.com'
email.substring(6,10);	// 'msjs'
email.substring(0,6);	// 'sujith'
email.substring(11,email.length);	// 'gmail.com'
email.charAt(0)		// 's'
email.charAt(email.length)	// ''
email.charAt(email.length - 1)	// 'm'
email.charCodeAt(0)		// 115
email.concat('.in','.co')	// 'sujithmsjs@gmail.com.in.co'
email.endsWith('co')		// false
email.endsWith('com')		// true
email.includes('com')		//	true
email.includes('msjs', 9)	// false
email.indexOf('m')		// 6
email.lastIndexOf('m')		// 19
email.lastIndexOf('x')	// -1
email.split('') // ['s', 'u', 'j', 'i', 't', 'h', 'm', 's', 'j', 's', '@', 'g', 'm', 'a', 'i', 'l', '.', 'c', 'o', 'm']

email.split('.') // ['sujithmsjs@gmail', 'com']

email.search(/sujith/)	// 0
email.search(/sujitH/)	// -1
email.search(/sujitH/i)	// 0
email.search(/MSJS/i)	// 6
"sujith".padEnd(10,'*')	// 'sujith****'
"sujith".padStart(10,'*')	// '****sujith'
email.toUpperCase()	// 'SUJITHMSJS@GMAIL.COM'
email.toLowerCase()	// 'sujithmsjs@gmail.com'
'  Sujith  '.trim()	// 'Sujith'
'  Sujith \n\n\n'.trim()	// 'Sujith'
'\t\t\t\n\n  Sujith \t\t\n\n\n'.trim()	// 'Sujith'
'4355'.match(/^[0-9]$/)	 	// null
'4355'.match(/^[0-9]$/)		// null
'4355'.match(/^[0-9]$/);	// null
'4355'.match(/[0-9]/);		// ['4', index: 0, input: '4355', groups: undefined]
'4355'.match(/^[0-9]+$/); 	// ['4355', index: 0, input: '4355', groups: undefined]
'4355'.match(/^[0-9]{4}$/); 	// ['4355', index: 0, input: '4355', groups: undefined]
'4355'.match(/^[0-9]{5}$/); 	//null
'Sujith'.match(/^[a-zA-Z]+$/) 	// ['Sujith']
'Sujith'.match(/^[a-z]+$/)	// null
'Sujith'.match(/^[a-z]+$/i) 	// ['Sujith', index: 0, input: 'Sujith', groups: undefined]
email.slice(0,6)		// 'sujith'
email.slice(-4)		// '.com'
email.slice(-9,-4)	// 'gmail'

```
## Data types

Seven primitive data types
1. Number
2. BigInt
3. String
4. Boolean
5. null
6. undefined
7. Objects
And one non-primitive data type:
8. Symbols
9. Arrays

## 1. Number

// no error
let message = "hello";
message = 123456;

let n = 123;
n = 12.345;

12321.toString(23) // SyntaxError
12321..toString(23);


## 2. BigInt

typeof 231332424n	// Postfix with 'n'
1e30n	// SyntaxError!

## 3. String

## 4. Boolean (logical type)
- true
- false

> undefined is NaN as a number, not 0.0
> "0" and space-only strings like " " are true as a boolean.
> Five Falsy values: (0, null, undefined, NaN, "") 

## 5. null
## 6. undefined
## 7. Objects
	And one non-primitive data type:
## 8. Symbols
## 9. Arrays


## Interaction

```javascript
alert("Hello");
let age = prompt('How old are you?', 100);
let isBoss = confirm("Are you the boss?");
```

## Type Conversions

String -> Number
Number -> String
Boolean -> String
String -> Boolean
Number -> Boolean
Boolean -> Number

```javascript
alert( Number("   123   ") ); // 123
alert( Number("123z") );      // NaN (error reading a number at "z")
alert( Number(true) );        // 1
alert( Number(false) );       // 0


String('234324'); 	// '234324'
312321313 + ''		// '312321313'
String(true)		// 'true'
String(false)		// 'false'
String(null)		// 'null'

parseInt(123.456)	// 123
parseInt('123.456in')	// 123
parseFloat('123.456in')	// 123.456
parseFloat('123.456in')	// 123.456
parseFloat('123px')	// 123
parseInt('123px')	// 123
parseInt('123.0px')	// 123
parseInt('99%')		// 99

alert( Boolean(1) ); // true
alert( Boolean(0) ); // false
alert( Boolean("hello") ); // true
alert( Boolean("") ); // false

> undefined is NaN as a number, not 0.
> "0" and space-only strings like " " are true as a boolean.


"" + 1 + 0	// '10'
"" == 0		// true
"" - 1 + 0	// -1
true == 1	// true
false == 0	// true
'0' == 0	// true
true + false	// 1 
true + true	// 2
parseInt(true)	// NaN
6 / "3"		// 
"2" * "3"	// 
4 + 5 + "px"	// 
"$" + 4 + 5	// 
"4" - 2		// 
"4px" - 2	//
"  -9  " + 5	// 
"  -9  " - 5	// 
null + 1	// 
undefined + 1	// 
" \t \n" - 2	// 


```

```javascript
+true	// 1
+false	// 0
+''	// 0
-'-20'	// 20
+'-300'	// -300

// No effect on numbers
let x = 1;
alert( +x ); // 1

let y = -2;
alert( +y ); // -2

// Converts non-numbers
alert( +true ); // 1
alert( +"" );   // 0
```

```javascript
let apples = "2";
let oranges = "3";

// "23", the binary plus concatenates strings
alert( apples + oranges );

// both values converted to numbers before the binary plus
alert( +apples + +oranges ); // 5
```

### Assignment

```javascript
let a, b, c;
a = b = c = 2 + 2;
```

### Modify-in-place
> We often need to apply an operator to a variable and store the new result in that same variable.

```javascript
let n = 2;
n = n + 5;
n = n * 2;
```

### Boolean Expressions

```javascript
// `a = 10` in every line
10 > (a = a + 1)	// false
10 > (a = a + 0)	// false
10 > (a = a - 1)	// true
```

```javascript
let a = 10, b = 20, c = 30;
let d = (a,b,c)
d	// 30
d = (a + b. b + c, a + c)
d	// 40
(1 + 2, 3 + 4)	// 7
```

```javascript
// Example 1
let a = 1, b = 1;
let c = ++a;
let d = b++;

a	// 2
b	// 2
c	// 2
d	// 1

// Example 2
let a = 2, b = 4
let c = ++a * b++;
c	// 12

// Example 3
let a = 5;
let b = ++a + a++;
b	// 12

// Example 4
let a = 2;
1 + (a *= 2);	// 5
```

### Weird Conversions
```javascript
typeof typeof 10;	// 'string'
~5	// 6
+[]	// 0
!+[]	// true
```

## Comparisons

#### String comparison
> To see whether a string is greater than another, JavaScript uses the so-called “dictionary” or “lexicographical” order
```javascript
'Z' > 'A'	// true
'Z' > 'a'	// false
'App' > 'Ape'	// true
'Bee' > 'Be'	// true
'Glow' > 'Glee'	// true
'10' > '0'	// true
'10' > '1'	// true
'10' > '2'	// false
'10' > 2	// true
10 > '2'	// true

null == undefined ); // true
null === undefined ); // false
null == "\n0\n"
null === +"\n0\n"


// Strange result: null vs 0
alert( null > 0 );  // (1) false
alert( null == 0 ); // (2) false
alert( null >= 0 ); // (3) true


// An incomparable undefined
// The value undefined shouldn’t be compared to other values
alert( undefined > 0 ); // false (1)
alert( undefined < 0 ); // false (2)
alert( undefined == 0 ); // false (3)
```


### Conditional operator ‘?’
```javascript
let result = condition ? value1 : value2;
let accessAllowed = (age > 18) ? true : false;
```

### Nullish coalescing operator '??'
> `&&` will give first falsy value or last truly value.

Falsy Values:
1. FALSE
2. BLANK STRING('')
3. NOT A NUMBER(NaN)
4. UNDEFINED
5. ZERO INTEGER(0)
6. NULL

```javascript
5 && 10 && 20	// 20
5 && 0 && 20	// 0
0 && 10 && 20	// 0
10 && Infinity && 30	// 30
10 && -Infinity && 30	// 30
10 && NaN && 30 // NaN
10 && undefined && 30	// undefined
```

> `||` will give first truly value or last falsy value.

```javascript
undefined || null || 'Hello'	// 'Hello'
false || '' || undefined || null || 0 || NaN || 1234 //	1234
```

> `??` Won't consider `0,'',NaN,false` as falsy values

```javascript
null ?? 0 ?? 10		// 0
undefined ?? 0 ?? null	// 0
undefined ?? null ?? false ?? 'Str'	// false
undefined ?? null ?? NaN ?? 'Str'	// NaN
```

> Due to safety reasons, JavaScript forbids using ?? together with && and || operators, unless the precedence is explicitly specified with parentheses.

```javascript
let x = 1 && 2 ?? 3;  	// Syntax error
let x = (1 && 2) ?? 3; 	// Works
10 ?? 5 * 3 ?? 20	// 10
(10 ?? 5) * (3 ?? 20)	// 30
```


## Functions
- Can access outer varable
- Local varable scope is limitted to the function

```javascript
function show(){
}

function max(...nums){
}

function pow(base, exp){
}

// Default values
function area(length = 5, width = 10){
}

// Complex expression
function showMessage(from, text = anotherFunction()) {
}

function showObject({name, age}){
}

function showObject({name = 'Sujith', age = 27 }){
}
```


## Function expressions
> A function is a value representing an “action”

```javascript
let sayHi = function() {
  console.info( "Hello" );
};

sayHi	// shows the function code
sayHi()	// Invokes the function
```

## Callback functions

```javascript
let sayHi = function() {
  console.info( "Hello" );
};

sayHi	// shows the function code
sayHi()	// Invokes the function

let x = sayHi;
x();	// Invokes the actual function

// Call back function
function run(myFun){
	myFun(); // Invoking a function
}

run(x);
run(sayHi);
```

## Arrow functions

```javascript
let func = (arg1, arg2, ..., argN) => expression;

let welcome = (age < 18) ?
  () => alert('Hello!') :
  () => alert("Greetings!");

welcome(); // invoking function
```

## Objects

CRUD Operation on objects

```javascript
const person = {
	name : 'Altman',
	age : 30,
}

// Read as JSON
console.info(JSON.stringify(person) );

// Read properties

// Delete a property
delete person.name;

// Update a property
person.age = 40;

// Add new Property
person.salary = 1e5;
```

## Sample Objects
```javascript
let fname = 'Global name';

const person = {
	fname: 'Altman',
	age: 30,
	addr: {
		fname: 'Jernifar lawrence',
		street: 'Nehru Nager',
		pin: 507123,
		findPeople() {
			console.info(6, `You're neibhour is ${this.fname}`)
		}
	},
	sayHi() {
		let fname = 'Sujith'; // Local varible
		console.info(7, `Instance name:${this.fname}; Local name:${fname}`);
	},
	accessGlobalVar() {
		// Note: You can NOT access class instance variables without `this` keyword.
		console.info(8.1, `Global name:${fname}`);
	},
	toString() {
		return JSON.stringify(this, null, 5);
	}
}

// Read as JSON
console.info(JSON.stringify(person));

// Read properties
console.info(1, person.fname);
console.info(2, person['fname']);
console.info(3.1, person['addr']['street']);
console.info(3.2, person.addr['street']);
console.info(4.1, person.addr.pin);
console.info(4.2, person['addr'].pin);
console.info(4.3, person['addr']?.pin); //Optional chaining
console.info(4.4, person.addr.pin);
console.info(4.5, person['addr']['pin']);
console.info(4.6, person['addr']?.['pin']);

// Invoking Functions
person['addr']['findPeople']();
person.addr.findPeople();
person.sayHi();
person['sayHi']();
person.accessGlobalVar();
person.accessInstanceVar();

// Optional chaining
person?.addr?.findPeople?.();
person?.['addr']?.['findPeople']?.();
person.sayBye?.(); // Avoid calling undefined function
person['sayBye']?.();
person.sayHi(); // Invoking function

// Delete a property
delete person.fname;

// Deleting a subproperty
delete person.addr.pin;

// Update a property
person.age = 40;

// Update a sub property
person.addr.fname = '24 Area';

// Add new Property
person.salary = 1e5;

// Add a Sub property
console.info(person.toString());
```


Output 
```
1 Altman
2 Altman
3.1 Nehru Nager
3.2 Nehru Nager
4.1 507123
4.2 507123
4.3 507123
4.4 507123
4.5 507123
4.6 507123
6 You're neibhour is Jernifar lawrence
6 You're neibhour is Jernifar lawrence
7 Instance name:Altman; Local name:Sujith
7 Instance name:Altman; Local name:Sujith
8.1 Global name:Global name
8.2 Access name:Global name
6 You're neibhour is Jernifar lawrence
6 You're neibhour is Jernifar lawrence
7 Instance name:Altman; Local name:Sujith
{
     "age": 40,
     "addr": {
          "fname": "24 Area",
          "street": "Nehru Nager"
     },
     "salary": 100000
}
```

# JS has 8 Data types, 7 are primitives.
> Propertry is a "Key:Value" pair.

> Usually, the figure brackets `{...}`are used. That declaration is called an `object literal`.

### multiword property names
### object literal

### Trailing comma
```javascript
const myArray = [1, 2, 3,]; // Trailing comma after the last element
```

### Hanging comma
### dot access?


```javascript
let user = {
  name: "John",
  age: 30
};
	
let key = "name";

user.key (Undifined)
user[name]
```

### Computed properties
> We can use square brackets in an object literal, when creating an object. That’s called computed properties.
> Square brackets are much more powerful than dot notation.


### Property value shorthand

```javascript
function makeUser(name, age) {
  return {
    name, // same as name: name
    age,  // same as age: age
    // ...
  };
}
```

### Example : 001

```javascript
function getBox(l, b) {
    return {
        l,b
    }
};

function fun() {
    let n = getBox(10, 20);
    key = 'name';
    console.info('Length: ', n.l);
    console.info('Breadth: ', n.b);
    let flag = key in n;
    console.info(flag)
    console.info(l in n) // ReferenceError: key is not defined
} 
```
### Property existence test, “in” operator
> Objects are associative arrays with several special features.
> They store properties (key-value pairs), where: Property keys must be strings or symbols (usually strings). Values can be of any type.


### To access a property, we can use:
1. The dot notation
2. Square brackets notation


### Additional operators:
> To delete a property: delete obj.prop.
> To check if a property with the given key exists: "key" in obj.
> To iterate over an object: for (let key in obj) loop.

```javascript
const person = {
    name : 'Sujith',
    status : 'Single',
    dept : 'Development',
    company : 'OnPassive'
}

for(let x in person ){
        console.info('Key: '+x);
        console.info(`Value: ${person[x]} `);
}
```
> Functions that are stored in object properties are called “methods”.

> One of the fundamental differences of objects versus primitives is that objects are stored and copied “by reference”, whereas primitive values: strings, numbers, booleans, etc – are always copied “as a whole value”.

Cloning and merging
-------------------
```javascript
 const box = { name : 'Sujith', dept : 'Java'}
 const box2 = {};

 for(let x in box){
 	box2[x] = box[x];
 }
```


Object.assign
-------------
```javascript
Object.assign(dest, ...sources)
```


deep cloning?
---------------

Garbage collection
--------------------------

> Unreachable island
It is possible that the whole island of interlinked objects becomes unreachable and is removed from the memory.


THIS Keyword
------------

A function that is a property of an object is called its method.
https://javascript.info/object-methods
```javascript
let user = {
  name: "John",
  age: 30
};

user.sayHi = function() {
  alert("Hello!");
};

user.sayHi(); // Hello!
```


Method shorthand
-----------------
```javascript
// these objects do the same
user = {
  sayHi: function() {
    alert("Hello");
  }
};

// method shorthand looks better, right?
user = {
  sayHi() { // same as "sayHi: function(){...}"
    alert("Hello");
  }
};
```
Function Calling Types
----------------------
```javascript
const box = {
    x: 100,
    y: 200,
    sum() {
        return this.x + this.y;
    },
    mul() {
        return this.x + this.y;
    }
}

function sayHi() {
    alert(this.x);
}

function fun2() {
    let x = box;
    let y = box;

    x.fun = sayHi;
    y.f = sayHi;
    let f = 'fun';

    x.f();
    x['fun']();
    x[f]();
}

function box(x, y) {
    return {
        x,
        y,
        add() {
            return this.x + this.y;
        }
    }
}
function fun2() {
    let x = box(10, 20);
    let y = box(5, 50);

    console.log(`Sum : ${x.add()}`)
    console.log(`Sum : ${y.add()}`)
}
let calculator = {
    x : 5,
    y : 10,
    read(){
       this.x = BigInt(document.getElementById('num1').value);
       this.y =  BigInt(document.getElementById('num2').value);
    },
    sum(){
        document.getElementById('ans').innerHTML = `sum : ${ this.x + this.y}`;
    },
    mul(){
        document.getElementById('ans').innerHTML = `sum : ${ this.x * this.y}`;
    },
};

function sum() {
    let x = calculator;
    x.read();    
    x.sum();
}

function mul() {
    let x = calculator;
    x.read();    
    x.mul();
}
```


```javascript
const person = {
    name : 'Sujith'
}

function sum() {
    let dept = 'dept' // Okay
    person[dept] = 'Java'; // Okay
    person['sal'] = 12000; // Okay
    person.status = 'Single' // Okay    
    person[id] = 1234 // Error: id not defined
    let a = document.getElementById('num1').value;
    alert(`Just demo ${JSON.stringify(person)}`);
}
```

### Symbol Example
```javascript
const person = {
    name : 'Sujith'
}

function sum() {
    let id = Symbol('id');
    person[id] = 1234
	person.status = 'Single' // Valid

    let a = document.getElementById('num1').value;
    
    alert(`Just demo ${JSON.stringify(person)}`); // {'name' : 'Sujith'}
    alert(`Just demo ${person['id']}`); // undefined
    alert(`Just demo ${person[id]}`); // 124
}
```


Constructor function
--------------------

> There are two conventions though:
They are named with capital letter first.
They should be executed only with "new" operator.

When a function is executed with new, it does the following steps:

1. A new empty object is created and assigned to this.
2. The function body executes. Usually it modifies this, adds new properties to it.
3. The value of this is returned.
```javascript
function User(name) {
  this.name = name;
  this.isAdmin = false;
}

// Above code will be compiled into
function User(name) {
  // this = {};  (implicitly)
  // add properties to this
  this.name = name;
  this.isAdmin = false;
  // return this;  (implicitly)
}
```
### This constructor function may be converted to a class declaration.
> The same constructor function can be written as 
```javascript
class Person {
    constructor(name, dept) {
        this.name = name;
        this.dept = dept;
    }
}
```
### What is the XHR request?
>XMLHttpRequest (XHR) is a JavaScript class containing methods to asynchronously transmit HTTP requests from a web browser to a web server. 

### Important Questions
What is implicit semicolon?
What is  automatic semicolon insertion?
What is incomplete expression?
What is ES5?
What is strict mode?
How many basic data types in JS?
What is typeof operator in JS?

What is "use strict" or modern mode?
The directive looks like a string: "use strict" or 'use strict'. When it is located at the top of a script, the whole script works the “modern” way.

We recommend putting semicolons between statements even if they are separated by newlines. This rule is widely adopted by the community.

### Data types

How many basic data types in JS?
There are eight basic data types in JavaScript.

Seven primitive data types
1. Number
2. BigInt
3. String
4. Boolean
5. null
6. undefined
7. Objects
And one non-primitive data type:
8. Symbols
9. Arrays


***Number:*** Represents numeric values, including integers and floating-point numbers. For example: 10, 3.14.

***String:*** Represents sequences of characters enclosed in single ('') or double ("") quotes. For example: 'Hello', "JavaScript".

***Boolean:*** Represents logical values, either true or false, used for conditional statements and logical operations.

***Null:*** Represents the intentional absence of any object value. It is a special value denoting the absence of an object reference.

***Undefined:*** Represents a variable that has been declared but not assigned a value. It is the default value of variables that have not been initialized.

***Object:*** Represents a collection of key-value pairs and is used to store complex data structures. Objects can contain properties and methods. For example: { name: 'John', age: 25 }.

***Array:*** Represents an ordered list of values enclosed in square brackets ([]). Arrays can contain elements of any data type, and each element has an index starting from 0. For example: [1, 'apple', true].

***Symbol:*** Represents a unique and immutable value that can be used as an identifier for object properties. Symbols are often used to add non-enumerable properties to objects.

***BigInt:*** Represents integers with arbitrary precision. It is used when numbers exceed the safe integer limit of the Number data type. BigInts are created by appending n to the end of an integer literal or by using the BigInt() function.

The number type represents both integer and floating point numbers.
Besides regular numbers, there are so-called “special numeric values” which also belong to this data type: Infinity, -Infinity and NaN.

What is String Interpolation?

What are the Interaction?
```javascript
alert > alert("Hello");
prompt(i/p text) > result = prompt(title, [default]);
confirm(true/false) > let isBoss = confirm("Are you the boss?");
```

> Basic operators, maths.

> Terms: “unary”, “binary”, “operand”
> Sometimes, people call these “arguments” instead of “operands”.

- Addition +,
- Subtraction -,
- Multiplication *,
- Division /,
- Remainder %,
- Exponentiation **.



> What is Chaining assignments?
> What is Modify-in-Place?
> What is character precedence?

### Comma Operator
```javascript
let b = 5;
let a = (b = b + 5, 3 + 4);
console.warn(b);

// three operations in one line
for (a = 1, b = 3, c = a * b; a < 10; a++) {
}
```


### How Comparision work in String comparison?

> To see whether a string is greater than another, JavaScript uses the so-called “dictionary” or “lexicographical” order.

> Difference between == and ===


What is Strict equality?
```javascript
let cond = (year == 2015); // equality evaluates to true or false
```

### Quoted Property Names
```javascript
const obj = {
  'my property name': 'value',
  'another_property': 'value'
};
```

### Constructor Function
> How this function can be a contructor
```javascript
function Box(l, b) {
    this.l = l;
    this.b = b;
};
```

> This constructor function may be converted to a class declaration.

> In JavaScript, a constructor function is a special type of function that is used to create objects. It is conventionally written with an uppercase letter to differentiate it from regular functions.

What kind of additional code added by compiler
```javascrip
function Box(l, b) {
    this.l = l;
    this.b = b;
};
```

>Above Constructor function can be converted into class as it was shown below

```javascript
class Box {
    constructor(l, b) {
        this.l = l;
        this.b = b;
    }
};
```

CRUD Operation:
```javascript
const inFun = {
  name: 'Sujith',
  dept: 'Computer Science',
  loc: 'Khammam'
};

// Read operation
console.log(inFun.name); // Output: Sujith

// Update operation
inFun.dept = 'Information Technology';
console.log(inFun.dept); // Output: Information Technology

// Create operation
inFun.age = 25;
console.log(inFun.age); // Output: 25

// Delete operation
delete inFun.loc;
console.log(inFun.loc); // Output: undefined
```

# Example 004

```java
const outFun = {};
let index = 0;

class D {
    constructor(val) {
        this.val = val;
    }
}

function fun2() {

    const arr = [12, 34, 32, 'Sujith']

    let d = new D(34);
    console.log(d.val);
    console.log(typeof (d));
    console.log(d.constructor.name);
    console.log(arr.constructor.name);
}

function fun() {

    const arr = [43, 32, 12, 86, 12];

    const inFun = {};
    inFun.name = 'Sujith'
    inFun.dept = 'Computer Science'
    inFun.loc = 'Khammam'

   

    for (let x of arr) {
        console.info('Index: ', x," ",arr[x]);
    }

    
    arr.forEach(e => console.info(e));

   

    arr.forEach(e => console.info(e));

    console.info('Before delation: ');
    printObj(inFun);
    delete inFun.name;
    console.info('After delation: ');
    printObj(inFun);


    console.info(typeof (arr));

}

function printObj(obj){
    for (let l in obj) {
        console.info(l, ' : ', obj[l]);
    }
}
```
# How many types can we itterate over Objects
```javascript
const employee = {
    name: 'John Doe',
    age: 30,
    department: 'IT',
    salary: 50000
  };
  
  // for...in loop
  console.log('Using for...in loop:');
  for (let key in employee) {
    console.log(key, employee[key]);
  }
  
  console.log('---------------------------');
  
  // Object.keys()
  console.log('Using Object.keys():');
  Object.keys(employee).forEach(key => {
    console.log(key, employee[key]);
  });
  
  console.log('---------------------------');
  
  // Object.values()
  console.log('Using Object.values():');
  Object.values(employee).forEach(value => {
    console.log(value);
  });
  
  console.log('---------------------------');
  
  // Object.entries()
  console.log('Using Object.entries():');
  Object.entries(employee).forEach(([key, value]) => {
    console.log(key, value);
  });
```
***In JavaScript, setting the length of an array to a shorter value than its current length removes the elements from the array starting from the new length.***


So `stack.length = 0`; effectively removes all the elements from the stack array, making it an empty array. It doesn't delete the data itself, but it clears the array by discarding its contents.

```javascript
stack.length = 0; // Clear the array
delete stack; // Delete the array variable
```

Stack DS
----------
```javascript
const stack = [];
const stackContent = document.getElementById('stack-content');
const stackInput = document.getElementById('stack-input');

function updateStackUI() {
    stackContent.innerHTML = stack.join(', ');
}

function pushElement() {
    console.info(stackInput.constructor.name); //HTMLInputElement
    const element = stackInput.value;
    console.info(element);
    if (element) { 
        stack.push(element);
        stackInput.value = '';
        updateStackUI();
    }else{
        console.info('Empty value')
    }
}

function popElement() {
    if (stack.length > 0) {
        stack.pop();
        updateStackUI();
    }
}

function peekElement() {
    if (stack.length > 0) {
        const topElement = stack[stack.length - 1];
        alert(`Top Element: ${topElement}`);
    }
}

function clearStack() {
    stack.length = 0;
    updateStackUI();
}
```


## Hosting
this -> function, object method, class method
Rest Operator
Spread Operator


#### Example 005
```javascript
let inputName = document.getElementById('name');
let colorBox = document.getElementById('color');

function showName() {
    console.info('Inside showName');
    let name = inputName.value;
    console.info(name);
    let size =  name + 'px';
    console.info('Size: ',size);
    try{
        inputName.style.fontSize = size; // Set the font size as '100px'
        console.info(inputName.style.fontSize.constructor.name);
    }catch(ex){
        console.warn(ex);
    }
    
    console.info(inputName.style.constructor.name) //CSSStyleDeclaration
    colorBox.style.backgroundColor = name; //
    getProperties(colorBox.style);
}

function getProperties(obj) {
    const properties = Object.keys(obj);
    
    for (let property of properties) {
      const type = typeof obj[property];
      console.log(`${property}: ${type}`);
    }
  }
```

All the Array Methods
---------------------
concat, join, push, pop, shift, unshift, slice, splice, reverse, sort, filter, map, reduce, forEach, find, indexOf, includes, some, every

Method: concat
Description: Combines two or more arrays and returns a new array.
Example:
```javascript
const arr1 = [1, 2];
const arr2 = [3, 4];
const combined = arr1.concat(arr2);
console.log(combined); // Output: [1, 2, 3, 4]
```
Method: join
Description: Joins all elements of an array into a string using a specified separator.
Example:
const arr = ["Hello", "World"];
const joined = arr.join(", ");
console.log(joined); // Output: "Hello, World"

Method: push
Description: Adds one or more elements to the end of an array and returns the new length.
Example:
const arr = [1, 2];
const length = arr.push(3, 4);
console.log(arr); // Output: [1, 2, 3, 4]
console.log(length); // Output: 4

Method: pop
Description: Removes the last element from an array and returns that element.
Example:
const arr = [1, 2, 3];
const removed = arr.pop();
console.log(arr); // Output: [1, 2]
console.log(removed); // Output: 3

Method: shift
Description: Removes the first element from an array and returns that element.
Example:
const arr = [1, 2, 3];
const removed = arr.shift();
console.log(arr); // Output: [2, 3]
console.log(removed); // Output: 1

Method: unshift
Description: Adds one or more elements to the beginning of an array and returns the new length.
Example:
const arr = [2, 3];
const length = arr.unshift(1);
console.log(arr); // Output: [1, 2, 3]
console.log(length); // Output: 3

Method: slice
Description: Extracts a section of an array and returns a new array.
Example:
const arr = [1, 2, 3, 4, 5];
const sliced = arr.slice(1, 4);
console.log(sliced); // Output: [2, 3, 4]

Method: splice
Description: Adds or removes elements from an array at a specified position.
Example:
const arr = [1, 2, 3, 4, 5];
const removed = arr.splice(2, 2);
console.log(arr); // Output: [1, 2, 5]
console.log(removed); // Output: [3, 4]

Method: reverse
Description: Reverses the order of elements in an array.
Example:
const arr = [1, 2, 3];
arr.reverse();
console.log(arr); // Output: [3, 2, 1]

Method: sort
Description: Sorts the elements of an array in place or based on a provided sorting function.
Example:
const arr = [3, 1, 2];
arr.sort();
console.log(arr); // Output: [1, 2, 3]

Method: filter
Description: Creates a new array with all elements that pass a test provided by a callback function.
Example:
const arr = [1, 2, 3, 4, 5];
const filtered = arr.filter(num => num > 2);
console.log(filtered); // Output: [3, 4, 5]

Method: map
Description: Creates a new array with the results of calling a provided function on every element in the array.
Example:
const arr = [1, 2, 3];
const doubled = arr.map(num => num * 2);
console.log(doubled); // Output: [2, 4, 6]

Method: reduce
Description: Applies a function to reduce the array to a single value.
Example:
const arr = [1, 2, 3, 4];
const sum = arr.reduce((acc, num) => acc + num, 0);
console.log(sum); // Output: 10

Method: forEach
Description: Executes a provided function once for each array element.
Example:
const arr = [1, 2, 3];
arr.forEach(num => console.log(num));
// Output:
// 1
// 2
// 3

Method: find
Description: Returns the first element in the array that satisfies the provided testing function.
Example:
const arr = [1, 2, 3, 4, 5];
const found = arr.find(num => num > 2);
console.log(found); // Output: 3

Method: indexOf
Description: Returns the first index at which a given element can be found in the array, or -1 if not found.
Example:
const arr = [1, 2, 3, 4, 5];
const index = arr.indexOf(3);
console.log(index); // Output: 2

Method: includes
Description: Determines whether an array contains a specific element.
Example:
const arr = [1, 2, 3, 4, 5];
const isIncluded = arr.includes(3);
console.log(isIncluded); // Output: true

Method: some
Description: Checks if at least one element in the array satisfies a provided testing function.
Example:
const arr = [1, 2, 3, 4, 5];
const hasEven = arr.some(num => num % 2 === 0);
console.log(hasEven); // Output: true

Method: every
Description: Checks if all elements in the array satisfy a provided testing function.
Example:
const arr = [1, 2, 3, 4, 5];
const allEven = arr.every(num => num % 2 === 0);
console.log(allEven); // Output: false



```javascript
alert( 1 || 0 ); // 1 (1 is truthy)
alert( null || 1 ); // 1 (1 is the first truthy value)
alert( null || 0 || 1 ); // 1 (the first truthy value)
alert( undefined || null || 0 ); // 0 (all falsy, returns the last value)

// if the first operand is truthy,
// AND returns the second operand:
alert( 1 && 0 ); // 0
alert( 1 && 5 ); // 5

// if the first operand is falsy,
// AND returns it. The second operand is ignored
alert( null && 5 ); // null
alert( 0 && "no matter what" ); // 0

alert( !true ); // false
alert( !0 ); // true

alert( Boolean("non-empty string") ); // true
alert( Boolean(null) ); // false
```
Short-circuit evaluation
------------------------

A double NOT !!
---------------
A double NOT !! is sometimes used for converting a value to boolean type:
Example:
alert( !!"non-empty string" ); // true
alert( !!null ); // false



Precedence
The precedence of the ?? operator is the same as ||. They both equal 3 in the MDN table.


Using ?? with && or ||
----------------------
Due to safety reasons, JavaScript forbids using ?? together with && and || operators, unless the precedence is explicitly specified with parentheses.

let x = 1 && 2 ?? 3; // Syntax error
let x = (1 && 2) ?? 3; // Works

he nullish coalescing operator ?? provides a short way to choose the first “defined” value from a list.

??= Operator
------------
x ??= 10
is same as
x = x ?? 10



---


What is Alternative default parameters?
Example:
```javascript
function showMessage(text) {
  // ...
  if (text === undefined) { // if the parameter is missing
    text = 'empty message';
  }

  alert(text);
}
showMessage(); // empty message
```
Example :
```javascript
function showCount(count) {
  // if count is undefined or null, show "unknown"
  alert(count ?? "unknown");
}

showCount(0); // 0
showCount(null); // unknown
showCount(); // unknown
```
### Arrow functions
### Template literals
### Destructuring
### Spread syntax
### Rest syntax

Functions
---------
```javascript
let f = function(){
    alert('Hellow');
}


console.info("f: "+f);
console.info("f.constructor.name: "+f.constructor.name);
console.info("typeof(f): "+typeof(f));
console.info("typeof f: "+typeof f);
f();
```
Output:
```javascript
f: function(){
    alert('Hellow');
}
f.constructor.name: Function
typeof(f): function
typeof f: function
```

What are the Local Variables?
What are the Outer Variables?
How you assign Default values to function parameters?
What are the differences between Function expressions and Function Declaration?
Can we pass Function is a value? If yes then how?

```javascript
function runFunction(fun){
    fun();
}

let sayHi = function(){
    alert('Hellow');
}

let sayBye = function(){
    alert('Bye');
}

runFunction(sayBye);
```

What is Callback functions in JS?
Function will be called according the logic instead of the given flow.

- Functions are values. They can be assigned, copied or declared in any place of the code.


- If the function is declared as a separate statement in the main code flow, that’s called a “Function Declaration”.


- If the function is created as a part of an expression, it’s called a “Function Expression”.

- Function Declarations are processed before the code block is executed. They are visible everywhere in the block.

- Function Expressions are created when the execution flow reaches them.

- In most cases when we need to declare a function, a Function Declaration is preferable, because it is visible prior to the declaration itself. That gives us more flexibility in code organization, and is usually more readable.

- So we should use a Function Expression only when a Function Declaration is not fit for the task. We’ve seen a couple of examples of that in this chapter, and will see more in the future.


Arrow functions
---------------
```javascript
let add = (a,b) => a+b;
alert('Addition: ' + add(10,20));

let sqr = n => n**2;
alert('Square: ' + sqr(10));

let show = () => alert('This is Arrow function');
show();

let isEven = n => n%2==0;
let isOdd = n => n%2==1;

function checkNumber(num, fun){
    flag = fun(num);
    console.info(`Num ${num} Fun ${fun} and Ans ${flag}`);
}

checkNumber(1010,isEven);
checkNumber(1010,isOdd);
checkNumber(1211,isEven);
checkNumber(1211,isOdd);
```

Automated Linters
------------------
https://javascript.info/coding-style
Linters are tools that can automatically check the style of your code and make improving suggestions.

Object:
-------
An object can be created with figure brackets {…} with an optional list of properties. A property is a “key: value” pair, where key is a string (also called a “property name”), and value can be anything.

Empty Object:
```javascript
let user = new Object(); // "object constructor" syntax
let user = {};  // "object literal" syntax
```
Usually, the figure brackets `{...}` are used. That declaration is called an object literal.


***How to access Object values:***
- Dot operator
- Square brace operator: Can also work with "multiword property names"



That is called a “trailing” or “hanging” comma. 



Computed properties:
--------------------
> We can use square brackets in an object literal, when creating an object. That’s called computed properties. It will used to generate dynamic key names.

Example:
```javascript
let fruit = prompt("Which fruit to buy?", "apple");

let bag = {
  [fruit]: 5, // the name of the property is taken from the variable fruit
};

alert( bag.apple ); // 5 if fruit="apple"

Example:
let fruit = prompt("Which fruit to buy?", "apple");
let bag = {};

// take property name from the fruit variable
bag[fruit] = 5;
```

Property value shorthand
------------------------
Example:
```javascript
function makeUser(name, age) {
  return {
    name, // same as name: name
    age,  // same as age: age
    // ...
  };
}
```

Property names limitations
--------------------------
> There are no limitations on property names. They can be any strings or symbols (a special type for identifiers, to be covered later).
> For instance, a number 0 becomes a string "0" when used as a property key.

Property existence test, “in” operator
---------------------------------------


```javascript
const emp = {
    name : 'Max',
    'first name' : 'Suijth',
    'Secound name': 'Manchala',
    0 : 'Zero'
}

console.info(emp['name'])
console.info(emp.name)
console.info(emp['first name'])
console.info(emp['Secound name'])
console.info(emp['0'])  // Zero
console.info(emp[0])    // Zeor 
//console.info(emp[game])  ReferenceError: game is not defined
console.info(emp.game) // undefined
console.info(emp['game']) // undefined

console.info(emp['game'] === undefined) // true
console.info(emp.game === undefined) // true
console.info(emp.name === undefined) // false

console.info('name' in emp) // true
console.info('blablabla' in emp) // false

for(let k in emp){
    console.info(k," : ",emp[k]," : ",emp.k)
}
```

***How you do Property existence test in JS?***
A notable feature of objects in JavaScript, compared to many other languages, is that it’s possible to access any property. There will be no error if the property doesn’t exist!

### Object references and copying
> When an object variable is copied, the reference is copied, but the object itself is not duplicated.
### Cloning and merging, Object.assign
### Object.assign(dest, ...sources)
### structuredClone

### Method shorthand
> There exists a shorter syntax for methods in an object literal:
```javascript
// these objects do the same

user = {
  sayHi: function() {
    alert("Hello");
  }
};

// method shorthand looks better, right?
user = {
  sayHi() { // same as "sayHi: function(){...}"
    alert("Hello");
  }
};
```


### Constructor function
```javascript
function User(name) {
  // this = {};  (implicitly)

  // add properties to this
  this.name = name;
  this.isAdmin = false;

  // return this;  (implicitly)
}

let user = new User("Jack");

alert(user.name); // Jack
alert(user.isAdmin); // false
```



```javascript
const user = {
    name: 'Sujith'
}

console.log('User: ', user.addr);  // undifined
console.log('User name: ', Boolean(user.name)); // true
console.log('User: ', Boolean(user.addr)); // false
console.log('User: ', Boolean(null)); // false
console.log('User: ', Boolean(undefined)); // false
console.log('User: ', user.addr?.street); // undifined
console.log('User: ', user?.['name']); // Sujith
console.log('User: ', user.addr.street); // TypeError: Cannot read properties of undefined (reading 'street')
```

### Optional chaining
> Short-circuiting
> Other variants: `?.(), ?.[]`


> The optional chaining `?.` syntax has three forms:

`obj?.prop` – returns obj.prop if obj exists, otherwise undefined.
`obj?.[prop]` – returns obj[prop] if obj exists, otherwise undefined.
`obj.method?.()` – calls obj.method() if obj.method exists, otherwise returns undefined.
As we can see, all of them are straightforward and simple to use. The ?. checks the left part for null/undefined and allows the evaluation to proceed if it’s not so.

A chain of `?.` allows to safely access nested properties.

Still, we should apply `?.` carefully, only where it’s acceptable, according to our code logic, that the left part doesn’t exist. So that it won’t hide programming errors from us, if they occur.

### Symbol type
> only two primitive types may serve as object property keys:
> `string type` or `symbol type`.

```javascript
const randomNum = Math.random();
const roundedNum = Math.floor(3.7);
const roundedUpNum = Math.ceil(2.1);
const roundedNum = Math.round(4.5);
const absoluteValue = Math.abs(-6);
const largestNum = Math.max(2, 6, 1, 9);
const smallestNum = Math.min(5, 8, 3, 2);
const result = Math.pow(2, 3);
const squareRoot = Math.sqrt(25);
const circleArea = Math.PI * radius * radius;
const randomNumber = Math.floor(Math.random() * 11) + 10;
console.log(randomNumber);
```


String Methods
-----------------
> Strings can be enclosed within either single quotes, double quotes or backticks:
```javascript
const str = "Hello, World!";
const length = str.length; // 13
const char = str.charAt(7); // "W"
const uppercaseStr = str.toUpperCase(); // "HELLO"
const lowercaseStr = str.toLowerCase(); // "world"
const concatenatedStr = str1.concat(", ", str2);
const index = str.indexOf("o"); // 4
const substring = str.substring(7, 12); // "World"
const array = str.split(","); // ["Hello", "World", "!"]
const replacedStr = str.replace("Hello", "Hi");
const trimmedStr = str.trim();
```



Rest parameters and spread syntax
---------------------------------

Rest parameters
---------------
```javascript
function add() {
    console.info('Inside add function');
}
function add(a, b) {
    console.info('Inside add with params function ' + (a + b));
}

add(); // Inside add with params function NaN
add(1, 2, 3, 4); // Inside add with params function 3
add(1, 'Sujith'); // Inside add with params function 1Sujith
```

> In JavaScript, function overloading is not directly supported. This means that when you define multiple functions with the same name, the earlier definitions are simply overwritten by the later ones. As a result, when you invoke the `add()` function without any arguments or with additional arguments beyond the defined parameters, the last defined version of the function is the one that gets executed.

In the given example, there are two versions of the `add()` function defined. The first version doesn't accept any parameters and simply logs a message to the console. The second version accepts two parameters `a` and `b`, calculates their sum, and logs the result to the console.

When you invoke `add()` without any arguments, it matches the first version of the function which doesn't require parameters. Therefore, it executes that version and logs the message `'Inside add function'`.

Similarly, when you invoke `add(1, 2, 3, 4)`, it matches the second version of the function, but the extra arguments `3` and `4` are ignored since the function definition only expects two parameters. The function executes and logs the result of `1 + 2`, which is `3`.

Lastly, when you invoke `add(1, 'Sujith')`, it again matches the second version of the function. JavaScript is a dynamically typed language, so it allows you to perform operations between different data types. In this case, it tries to concatenate the numeric value `1` with the string `'Sujith'`. The result of the concatenation is the string `'1Sujith'`, and it is logged to the console.

In summary, because function overloading is not directly supported in JavaScript, the last defined version of the function is the one that gets executed when you call `add()`. The behavior of the function depends on the number and types of arguments passed during the function invocation.

### Rest Parameters

```javascript
function add(a, b) {
  if (typeof a === 'undefined' && typeof b === 'undefined') {
    console.info('Inside add function');
  } else if (typeof a === 'number' && typeof b === 'number') {
    console.info('Inside add with params function ' + (a + b));
  } else {
    console.error('Invalid arguments for add function');
  }
}

add(); // Inside add function
add(1, 2); // Inside add with params function 3
add(1, 'Sujith'); // Invalid arguments for add function
```

`(...)`gather the remaining parameters into an array.
The rest parameters must be at the end

```javascript
console.info(typeof 100);       // number
console.info(typeof 100.1234);  // number
console.info(typeof '100');     // string

addAll(1, 2, 3, true, false, 'Sujith', '75', 5, false);

function addAll(...args) {
    console.info(args.constructor.name);
    args.forEach(e => console.info(e));

    let sum = 0;
    for (let x of args) {
        console.info(x);
        if (typeof x == 'number') {
            sum += x;
        }
    }
    console.info('Sum: ' + sum);
    return sum;
}
```

### Spread syntax
> The spread syntax internally uses iterators to gather elements, the same way as `for..of` does.
> Spread syntax to the rescue! It looks similar to rest parameters, also using `...`, but does quite the opposite.
> When `...arr` is used in the function call, it “expands” an iterable object arr into the list of arguments.

```javascript
let arr = [3, 5, 1];
alert( Math.max(...arr) ); // 5 (spread turns array into a list of arguments)
```

> We can even combine the spread syntax with normal values:
```javascript
let arr1 = [1, -2, 3, 4];
let arr2 = [8, 3, -8, 1];
alert( Math.max(1, ...arr1, 2, ...arr2, 25) ); // 25
```
> Also, the spread syntax can be used to merge arrays:
```javascript
let arr = [3, 5, 1];
let arr2 = [8, 9, 15];

let merged = [0, ...arr, 2, ...arr2];
```
> Array.from operates on both array-likes and iterables.
> The spread syntax works only with iterables.




https://javascript.info/var


Here are 10 JavaScript interview questions along with their answers:

1. What is JavaScript?
   Answer: JavaScript is a popular programming language primarily used for web development. It provides interactivity and dynamic functionality to websites.

2. What are the different data types in JavaScript?
   Answer: JavaScript has several built-in data types, including number, string, boolean, object, null, undefined, and symbol (added in ES6).

3. What is the difference between `null` and `undefined`?
   Answer: `null` represents the intentional absence of any object value, while `undefined` represents the absence of a defined value. In other words, `null` is a value assigned by developers, whereas `undefined` is the default value assigned by JavaScript.

4. Explain hoisting in JavaScript.
   Answer: Hoisting is a JavaScript behavior where variable and function declarations are moved to the top of their respective scopes during the compilation phase. However, only the declarations are hoisted, not the initializations.

5. What is the difference between `==` and `===` operators?
   Answer: The `==` operator checks for equality after performing type coercion, while the `===` operator checks for equality without type coercion. In other words, `===` performs a strict equality check, including both value and type.

6. What are closures in JavaScript?
   Answer: Closures are functions that have access to variables defined in their outer (enclosing) function, even after the outer function has finished executing. The inner function retains a reference to its outer lexical environment, allowing it to access variables and parameters.

7. What is the event loop in JavaScript?
   Answer: The event loop is a mechanism in JavaScript that handles asynchronous operations. It continuously checks the call stack for any pending tasks and executes them one by one, ensuring that the program remains responsive.

8. How can you handle errors in JavaScript?
   Answer: JavaScript provides try-catch-finally blocks to handle errors. The code within the `try` block is executed, and if an error occurs, it is caught in the `catch` block where you can handle or log the error. The `finally` block is executed regardless of whether an error occurred or not.

9. Explain the concept of prototypal inheritance in JavaScript.
   Answer: JavaScript uses prototypal inheritance, where objects can inherit properties and methods from other objects. Each object has an internal link to its prototype, and if a property or method is not found in the object itself, it is looked up in its prototype chain.

10. How can you prevent event propagation in JavaScript?
    Answer: Event propagation can be stopped using the `stopPropagation()` method. When called on an event object within an event handler, it prevents the event from bubbling up the DOM tree or capturing down the DOM tree, depending on the event phase.

These are just a few JavaScript interview questions to get you started. It's important to thoroughly understand the concepts and practice coding examples to prepare effectively for JavaScript interviews.



# Clouser
```javascript
function counter() {
  var count = 0;
  function increment() {
    count++;
    console.log(count);
  }
  return increment;
}

var incrementCounter = counter();
incrementCounter(); // Outputs: 1
incrementCounter(); // Outputs: 2
incrementCounter(); // Outputs: 3
```

# In how many ways can read properies in a object in JS
- Dot notation
- Bracket notation
- Object destructuring
- Object methods
- for...in loop

# Object destructuring
```javascript
const obj = { name: 'John', age: 30 };
const { name, age } = obj; // Destructuring object properties
console.log(name, age); // Output: John 30
```

> In JavaScript, you can use object destructuring to copy values from one object to another. Here's an example:

```javascript
const source = { name: 'John', age: 30 };
const destination = { ...source };

console.log(destination);
```

In the example above, the spread operator (`...`) is used to create a shallow copy of the `source` object and assign it to the `destination` object. This means that the `destination` object will have the same properties and values as the `source` object.

After executing the code, the `console.log(destination)` statement will output:

```
{ name: 'John', age: 30 }
```

Note that this method creates a shallow copy, which means that if the properties of the source object are objects themselves (nested objects), they will be copied by reference rather than creating separate copies.

If you want to perform a deep copy, including nested objects, you would need to use other techniques like recursive functions or libraries like Lodash's `cloneDeep()` method.



In how many ways can we clone JS Object
---------------------------------------
1. Spread Operator(`...`) :  To create a shallow copy of an object.
2. Object.assign(): To copy the values of all enumerable properties from one or more source objects to a target object.
3. JSON.parse() and JSON.stringify(): 
 - For creating a deep copy of an object
 - Only works with serializable objects((i.e., it doesn't contain functions, symbols, or circular references)
4. Object.create():

```javascript
const originalObj = { name: 'John', age: 30 };
const clonedObj = Object.create(Object.getPrototypeOf(originalObj), Object.getOwnPropertyDescriptors(originalObj));
```
5. Custom cloning function:


new Date v/s new Date()
-----------------------

The empty parentheses explicitly indicate that no arguments are being passed to the constructor.
The parentheses are optional when no arguments need to be passed to the constructor. However, the presence or absence of the parentheses does not affect the behavior or result in this case.







### Date Methods:
```javascript
Number getDate()
Number getDay()
Number getFullYear()
Number getHours()
Number getMilliseconds()
Number getMinutes()
Number getMonth()
Number getSeconds()
Number getTime()
Number getTimezoneOffset()
Number getUTCDate()
```



setInterval Parameters
-----------------------
1. Function(Required)
	- Function Reference
	- Anonymous Function
		-- Lambda function
		-- Function expression
2. Delay(Required)
3. Arguments(Optional)

```javascript
// Anonymous Function
const sum = function (a, b) {
  return a + b;
};
```
- Short-lived purpose
- Callback function

###  C L O C K
   
```javascript
console.info('Checking...')
let td = document.getElementById('time');

for( let n in td){
	if(typeof td[n] === 'string'){
		console.info(n,' :: ',td[n],' :: ',typeof td[n]);
		//console.info(n,' : ',typeof td[n]);
	}
}

fun = function(){
	let d = new Date();
	td.innerHTML = d.getSeconds();
}

setInterval(fun, 1000);

let td = document.getElementById('time');
let tds = window.getComputedStyle(td);
let data = ''; // Initialize an empty string to store the data


for (let i in td.style ) {

  if (typeof td.style[i] === 'string') {
    data += i + "\n"; // Append each value to the data string
  }
}

// Assign the data to the textarea value
let textarea = document.getElementById('notes');
textarea.value = notes + '\n' + data;
```

Array method in JS give me list with return type and paramters in below format
`<Return Type> <Method name>(<Parameters>)`

Array methods in JS give me list give me in below format
`<Return Type> <Method name>(<Parameters>)`


Rest parameters and spread syntax
- Built-in Support
- Arbitrary number of arguments

Example:
`Math.max(arg1, arg2, ..., argN)` – returns the greatest of the arguments.
`Object.assign(dest, src1, ..., srcN)` – copies properties from src1..N into dest.


Rest parameters & Spread syntax
-------------------------------
A function can be called with any number of arguments, no matter how it is defined.

- Excessive Arguments
- The rest parameters must be at the end
- SyntaxError: Rest parameter must be last formal parameter

```javascript
function addAll(...args){
	let sum = 0;
	for(let i of args){
		sum += i;
	}
	return sum;
}

let arr = [1,2,3,4,5,6];
let arr2 = [100,200];

let a = addAll(...arr, ...arr2); // Spreading an array
let a2 = addAll(1,2,3,4,5); // Spreading an array


console.info(`Answer 1 is ${a}`);
console.info(`Answer 2 is ${a2}`);

Example:
console.info( Math.max(...arr) );
console.info( Math.max(...arr, ...arr2) );
console.info( Math.max(1, ...arr, 2, ...arr2, 25) );
let merged = [0, ...arr, 2, ...arr2];
```



# Cloning an Array
------------------
```javascript
let arr = [1, 2, 3];

let arrCopy = [...arr]; // spread the array into a list of parameters
                        // then put the result into a new array

// do the arrays have the same contents?
alert(JSON.stringify(arr) === JSON.stringify(arrCopy)); // true

// are the arrays equal?
alert(arr === arrCopy); // false (not same reference)

// modifying our initial array does not modify the copy:
arr.push(4);
alert(arr); // 1, 2, 3, 4
alert(arrCopy); // 1, 2, 3
```



# Guess the OutPut

```javascript
let arr = [1,2,3,4,5];
console.info(arr);

// let arr2 = ...arr; SyntaxError: Unexpected token '...'

let arr2 = [...arr];
let arr3 = arr;
console.info(arr2);

console.info(arr === arr2);
console.info(arr === arr3);
```

# Cloning an Object


> JSON.stringify(value, replacer, indentation level);

```javascript
function print(obj){
	console.info(JSON.stringify(obj, null, 5));
}

const emp = {
	name : 'Sujith',
	dept : 'CSE',
	status : 'Single'
}

const emp2 = emp;
const emp3 = {...emp}


print(emp);
print(emp2);
print(emp3);

print(emp === emp2);
print(emp === emp3);
console.info('After conversion');
emp.name = 'Manchala';
print(emp);
print(emp2);
print(emp3);
```



Spread V/s Rest
---------------
> When we see `...` in the code, it is either rest parameters or the spread syntax.

There’s an easy way to distinguish between them:

When `...` is at the end of function parameters, it’s “rest parameters” and gathers the rest of the list of arguments into an array.
When `...` occurs in a function call or alike, it’s called a “spread syntax” and expands an array into a list.


Use patterns:

Rest parameters are used to create functions that accept any number of arguments.
The spread syntax is used to pass an array to functions that normally require a list of many arguments.


### Code blocks

- Object literal {...}
- Isolate a piece of code that does its own task
- Block-local variables


### Nested functions

- Can be returned
- Can be used somewhere else.
- Has access to the same outer variables.



### Guess the output

```javascript
function counter() {

  	let count = 0;
	console.info(1);

	function countInc(){
		console.info(2);
		return	count++;
	}
	console.info(3);
	function get(){
		console.info(4);
		return count;
	}
	console.info(5);
 	return function(){
		console.info(6);
		return 100;
	}
	console.info(7);
}

let c = counter();


console.info( c() );
console.info( c() );
console.info( c() );
```


## Closure

- A Function
- As any JavaScript object, it’s only kept in memory while it’s reachable.
- Closure Function is Alive, all the variables are retained
- All functions are naturally closures
- Contains hidden property [[Environment]]
- Access to Outer Lexical Environment
- Usually, a Lexical Environment is removed from memory with all the variables after the function call finishes
- Closure functions are alive
- Lexical Env still reachable even after the completion of the Fun.



#### Guess the O/P

```javascript
function cals(){
	let n = 0;
	
	return function(v){
		n += v;
	 	return n;
	}
}

let c = cals();
c(100);
c(10);
let ans = c(122);
console.info(ans);
```


#### Guess the O/P

```javascript
let name = 'Sujith';

function sayHi(){
	console.info(`Hello ${name}`);
}

name = 'Maximus';

console.info(name);
```



#### Guess the O/P

```javascript
let name = 'Sujith';

function sayHi(){
	let name = 'Iron Man';

	return function(){
		//console.info(`Hello ${name}`);
	return name;
	}
}
let f = sayHi();
console.info( f() );
```

Note:
- Every closure function has it's own independent outer Lexical Environments.


#### Guess the O/P

```javascript
function Counter(){
	let count = 0;
	// let index = 1000;	

	this.up = function(){
		// return index = count = 100; 
		return count += 1;
	}

	//return this;
}

let f = new Counter();

for(let i=1;i <= 10;i++){
	console.info(f.up());
}
```


#### Guess the O/P

```javascript
function Counter(){
	let count = 0;
	
	this.up = function(){
		return count+=1;
	}

	this.down = function(){
		return count-=1;
	}
	
	// return this; implicitly added

}

let f = new Counter();

console.info(f.up());
console.info(f.up());
console.info(f.down());
console.info(f.up());
console.info(f.down());
```



#### Guess the O/P

```javascript
function add(sum){
	return function(num){
		 return sum += num;
		//turn this;
	}
}
console.info( add(12)(-24) );
```


Array functions
---------------
```javascript
Array.length
Array.push(element1, element2, ..., elementN)
Array.pop()
Array.unshift(element1, element2, ..., elementN)
Array.shift()
Array.concat(array2, array3, ..., arrayN)
Array.slice(start, end)
Array.splice(start, deleteCount, item1, item2, ..., itemN)
Array.join(separator)
Array.indexOf(element)
Array.lastIndexOf(element)
Array.includes(element)
Array.find(callback)
Array.findIndex(callback)
Array.filter(callback)
Array.map(callback)
Array.reduce(callback, initialValue)
Array.reduceRight(callback, initialValue)
Array.every(callback)
Array.some(callback)
Array.sort(compareFunction)
Array.reverse()
Array.forEach(callback)
Array.keys()
Array.values()
Array.entries()
Array.fill(value, start, end)
Array.from(arrayLike, mapFn, thisArg)
Array.isArray(value)
Array.of(element1, element2, ..., elementN)
const arr = [1,2,3,4,5,6];
const sum = arr.reduce( (a, v) => a + v ,0);
console.info(sum);
```

#### Guess the O/P
```javascript
function extract(fullName){
	[firstName, lastName] = fullName.split(" ")

	console.info(`firstName ${firstName} `);
	console.info(`lastName ${lastName} `);
}

extract('Sujith Manchala');

let arr = ["Apple", "Mongo","Grapes","Watermelon"];

[a,,, b] = arr;
console.info(a);
console.info(b);
```

#### Guess the O/P
```javascript
let fruits = ["Apple", "Mongo","Grapes","Watermelon"];
let veggies = ['Tamoto','Potato','Cabbage','Carrots'];

let allMix = ['Sapota',...fruits,...veggies,'Orange'];

let [a,b,c] = allMix;

console.info(`allMix : ${allMix}`);
console.info(a);
console.info(b);
console.info(c);
```

#### Guess the O/P

```javascipt
let fruits = ["Apple", "Mongo","Grapes","Watermelon"];
let veggies = ['Tamoto','Potato','Cabbage','Carrots'];
let all = fruits.concat(['Oakland'],veggies);
console.info(`All ${all}`)
```

#### Guess the O/P
```javascript
function getFullName( { firstName, lastName} ){
	console.info(`${firstName} ${lastName}`);
}

const employee = {
	firstName : 'Sujith',
	lastName : 'Manchala'
}

const emp = {
	first : employee.firstName, // SyntaxError: Invalid shorthand property initializer
	last : employee.lastName
}

getFullName(employee);
getFullName(emp);
```


#### Guess the O/P
```javascript
function print(obj){
	console.info(JSON.stringify(obj, null, 5));
}

const employee = {
	firstName : 'Sujith',
	lastName : 'Manchala'
}

const emp = {...employee};


print(employee === emp)

emp.lastName = 'Maximus';
print(employee);
print(emp);
```



#### Guess the O/P
```javascript
function print(obj){
	console.info(JSON.stringify(obj, null, 5));
}

const employee = {
	firstName : 'Sujith',
	lastName : 'Manchala',
	middleName : 'Suji'
}

const {firstName : f, lastName : l, middleName : m = 'Mark'} = employee;
// let [firstName, lastName] = employee; // TypeError: employee is not iterable

print(f);
print(l);
print(m);
```




#### Guess the O/P
```javascript
function print(obj){
	console.info(JSON.stringify(obj, null, 5));
}

const originalObject = {
  prop1: 'value1',
  prop2: 'value2',
  prop3: 'value3',
  prop4: 'value4',
  prop5: 'value5',
  prop6: 'value6',
  prop7: 'value7',
  prop8: 'value8',
  prop9: 'value9',
  prop10: 'value10'
};

const { prop1, prop3, prop7 } = originalObject;

const newObject = {
  prop1,
  prop3,
  prop7
};

let name = 'Sujith';
let age = '27';
let salary = '10000';

const emp = {
	name,
	age,
	salary
}

print(newObject);
print(emp);
```



#### Guess the O/P
```javascript
const answer = (( a,b ) => a + b) (10,20);\
console.info(answer);

const que = {
	a : 100,
	b : 200
}

const answer =( ({a, b}) => a + b) ({a : 10, b : 29});
const answer2 =( ({a, b}) => a + b) (que);

console.info(answer);
console.info(answer2);
```



#### Guess the O/P
```javascript
const user = {
	name : 'Sujith',
	age : 27,
	sal : 10_000
}

const emp = {
	name : user.name,	
	//age : user.age,
	age : 30,
	sal : user.sal,
}

print(user);
print(emp);
```




#### Guess the O/P
```javascript
// Define the student object
var student = {};

// Define the employee object
var employee = {
  firstName: "John",
  lastName: "Doe",
  salary: 50000,
  age: 30
};


(
	{
		firstName: student.firstName,
		lastName: student.lastName
	} = employee
);


({ firstName, lastName} = employee);

({firstName : f = 'Sujith', lastName : l = 'Manchala'} = student);


console.log(student);
console.log(f);
console.log(l);
```


# Prototypal inheritance

```javascript
function print(obj){
	console.info(JSON.stringify(obj, null, 5));
}

const animal = {

	name : 'kitty',
	age : 2,
	
	 sayName: function(){
		console.info(`You're name is ${this.name}`);
	}
}

const cat = {
	name : 'Mark',
	sound : 'Meowwwwwww',
}

const cat2 = {
	name : 'John',
	sound : 'Mewwwoooow',
}

Object.setPrototypeOf(cat, animal);
Object.setPrototypeOf(cat2, animal);

print(animal);
print(cat);
print(cat.name);
print(cat.age);
print(cat.sound);
animal.sayName();
cat.sayName();
cat2.sayName();

console.log(Object.getPrototypeOf(animal) );
console.log(Object.getPrototypeOf(cat2) );
```



```javascript
function print(obj){
	console.info(JSON.stringify(obj, null, 5));
}

const  emp = {
	fname : 'Sujith',
	lname : 'Manchala',

	set setFullName(name){
		[this.fname, this.lname] = name.split(" ");
	}
}

emp.setFullName = 'Sam Altman';
print(emp); 
```

Observation:
- getPrototypeOf works as same as in Java classes.
- Every object has it's own set of Lexicals.
- You can find by looping through over the object.
- You can use for..in for that



```javascript
function print(obj){
	console.info(JSON.stringify(obj, null, 5));
}

function loopIt(obj){
	console.info(`Looping through...`);
	for(let e in obj){
		console.info(` ${e} : ${obj[e]}`);
	}
}

const  emp = {
	fname : 'Sujith',
	lname : 'Manchala',

	set setFullName(name){
		[this.fname, this.lname] = name.split(" ");
	}
}

const dev = {
	tech : 'Java',
	sal : 10_000

}

Object.setPrototypeOf(dev, emp);


emp.setFullName = 'Sam Altman';

print(emp);
print(dev);
print(dev.fname);
dev.setFullName = 'Sujith Manchala';
print(dev);

loopIt(dev);
loopIt(emp);
```



```javascript
const email = 'sujith.manchala@onpassive.com';

let s = email.indexOf('@') + 1;

console.info(s);
let e = email.indexOf('.', s);

console.info(e);
console.info(email.length);
const domain = email.substring(s, e);

const email2 =  email.replace(domain, 'gmail');
console.info(email2);
```

F.prototype
-----------

Note: Setting Rabbit.prototype = animal literally states the following: "When a new Rabbit is created, assign its [[Prototype]] to animal".


```javascript
let ani = {
	fname : 'Animal'
}

function Ani(name){
	this.lname = name;
}

Ani.prototype = ani;

let a = new Ani('Peacock');

console.info(a);

for(e in a){
	console.info(e);
}
```


```javascript
function Rabbit() {}
// by default:
// Rabbit.prototype = { constructor: Rabbit }

console.info( Rabbit.prototype.constructor == Rabbit ); // true
console.info( Rabbit.constructor == Rabbit ); // false

let rab = new Rabbit;

console.info( rab.prototype?.constructor == Rabbit ); // false
console.info( rab.constructor == Rabbit ); // true

Rabbit.prototype.jumps = true

console.info(Rabbit.prototype);
```


```javascript
function Rabbit(eats) {
    this.eats = eats;
}

// Rabbit.prototype = {
//  eats: true,
//  constructor : Rabbit
// };


let rabbit = new Rabbit();

console.info(Rabbit.prototype.eats);
console.info(Rabbit.prototype.constructor.name);

console.info(rabbit.eats);
console.info(rabbit.constructor.name);

let pro = Object.getPrototypeOf(rabbit);

console.info(pro);
```

```javascript
function User(name, sal){
    this.name = name;
    this.sal = sal;
}

const dev = {
    dept : 'JAVA'
}

User.prototype = dev;

let u1 = new User('Sujith',10_000);

User.prototype = {};

let u2 = new User('Sujith',10_000);

console.info(u1.dept);
console.info(u2.dept);
```



### Workig with Strings

```javascript
- charAt(index: number): string
- charCodeAt(index: number): number
- codePointAt(pos: number): number
- concat(...strings: string[]): string
- endsWith(searchString: string, length?: number): boolean
- includes(searchString: string, position?: number): boolean
- indexOf(searchValue: string, fromIndex?: number): number
- lastIndexOf(searchValue: string, fromIndex?: number): number
X localeCompare(compareString: string, locales?: string | string[], options?: CollatorOptions): number
X match(regexp: string | RegExp): RegExpMatchArray | null
X matchAll(regexp: string | RegExp): IterableIterator<RegExpMatchArray>
X normalize(form?: "NFC" | "NFD" | "NFKC" | "NFKD"): string
X padEnd(targetLength: number, padString?: string): string
X padStart(targetLength: number, padString?: string): string
- repeat(count: number): string
- replace(searchValue: string | RegExp, replaceValue: string | ((substring: string, ...args: any[]) => string)): string
replaceAll(searchValue: string | RegExp, replaceValue: string): string
search(regexp: string | RegExp): number
- slice(start?: number, end?: number): string
split(separator: string | RegExp, limit?: number): string[]
startsWith(searchString: string, position?: number): boolean
substring(start: number, end?: number): string
toLocaleLowerCase(locales?: string | string[], options?: Intl.LocaleOptions): string
toLocaleUpperCase(locales?: string | string[], options?: Intl.LocaleOptions): string
- toLowerCase(): string
- toString(): string
- toUpperCase(): string
valueOf(): string
toLocaleString(locales?: string | string[], options?: Intl.DateTimeFormatOptions): string
substring(start: number, end?: number): string
toLocaleLowerCase(locales?: string | string[]): string
toLocaleUpperCase(locales?: string | string[]): string
- trim(): string
- trimEnd(): string
- trimStart(): string
```

### indexOf v/s search
indexOf: Performs a simple string search, which has a time complexity of O(n), where n is the length of the string.
search: Performs a regular expression search, which can have varying time complexities depending on the complexity of the regular expression pattern.

const regex = /[0-9]{2}-[0-9]{2}-[0-9]{4}/; // Example regex pattern for date in the format dd-mm-yyyy
const dateString = '23-07-2023';
const matches = dateString.match(regex);
console.log(matches); // Output: ["23-07-2023"]


### Code Sinppits
```javascript
const myArr = text.match('/AIN/gi');
const myArr = text.match(/ain/i);
const myArr = text.match(/ain/g);
let length = text.length;
let newText = text.replace("MICROSOFT", "W3Schools");
let newText = text.replace(/MICROSOFT/i, "W3Schools");
// The search() method cannot take a second start position argument.
// The indexOf() method cannot take powerful search values (regular expressions).
(method) Array<number>.splice(start: number, deleteCount?: number | undefined): number[]

const arr = ['A', 'B', 'C', 'D'];

// Insert first
arr.splice(0, 0, 'Z');

// Replace first
arr.splice(0, 1, 'F');

// Delete first
arr.splice(arr.length, 0, 'X');

// Insert last
arr.splice(0, 1);

// Replace last
arr.splice(0, 1, 'R');

// Delete last
arr.splice(arr.length - 1, 1);

// Insert at N
let n = 2;
arr.splice(n, 1, 'ABC');

// Replace at N
arr.splice(n, 1, 'X');

// Delete at N
arr.splice(n, 1);
console.info(arr);
```

Note: splice return deleted elemens in an array.

Slicing an Array:
-----------------
Slice is work exactly as substring method but here it slices the array.

Sorting an array:
----------------
const points = [40, 100, 1, 5, 25, 10];
points.sort(function(n,m){return n-m});
points.sort((n,m)=> n-m);
console.info(points);

Sorting an Array in Random Order:

const points = [40, 100, 1, 5, 25, 10];
points.sort(function(){return 0.5 - Math.random()});

- Sorting an Array
- Number Sort
- The Compare Function
- The Fisher Yates Shuffle
- Min/Max Object
- Sorting Object Arrays
- Stable Array sort
- Iteration forEach()


```javascript
const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
// Filter even numbers
const evenNumbers = numbers.filter(i => i % 2 === 0 );
console.log(evenNumbers);
// Output: [2, 4, 6, 8, 10]
```

```javascript
const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
// Filter even numbers
const evenNumbers = numbers.map(function (e) {
    return {
        val: e,
        sqr: e * e,
        cube: e * e * e
    }
});
console.log(evenNumbers);
// Output: [2, 4, 6, 8, 10]

console.info(numbers);

//Wrap the object literal in parentheses
const arr = numbers.map(e => ({ e: e }));

console.info(arr);
```





```javascript
const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let n = arr.reduce((ac, iv) => {
    console.info(`Acc : ${ac}, Iv : ${iv}`);
    return ac + iv;
});
console.info(n);
```



```javascript
const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

const objArr = arr.map( e => ({v: e}));

let n = objArr.reduce((ac, iv) => {
    console.info(`Acc : ${JSON.stringify(ac)}, Iv : ${JSON.stringify(iv)}`);
    return  {v : ac.v + iv.v};
}).v;
console.info(n);
```


```javascript
var femaleEmps = employees.filter(e => e.gender === 'Female');
console.info(femaleEmps);

// Find sum of all employees salary
let n = employees.reduce((a,e) => {
    return { salary: a.salary + e.salary }
})
console.info(n);
```



JS Stream Function
--------------------

- map
- filter
- reduce
- every
- some
- findIndex


```javascript
// Create Employee objects
const employee1 = { id: 1, ename: 'John Doe', salary: 50000, gender: 'Male' };
const employee2 = { id: 1, ename: 'John Doe', salary: 50000, gender: 'Male' };

console.info(employee1 == employee2);

function areEqual(obj1, obj2) {
    const keys1 = Object.keys(obj1);
    const keys2 = Object.keys(obj2);

    if (keys1.length !== keys2.length) {
        return false;
    }

    for (let key of keys1) {
        if (obj1[key] !== obj2[key]) {
            return false;
        }
    }
    return true;
}

console.log(areEqual(employee1, employee2)); // Output: true
```




### Simple Color changing program
```html
<!DOCTYPE html>
<html>

<head>
  <style>
    .container {
      width: 200px;
      height: 200px;
      background-color: lightblue;
      margin: 0 auto;
    }

    .buttons {
      text-align: center;
      margin-top: 10px;
    }
  </style>
</head>

<body>
  <div class="container" id="container" style="display: flex; align-items: center; justify-content: center;">
    <h1 id="text" contenteditable="true">Text Content</h1>
  </div>


  <div class="buttons">
    <button onclick="changeBgColor()">Change BG</button>
    <button onclick="changeTextColor()">Change Text</button>
  </div>
  <script src="demo002.js"></script>
</body>

</html>
```

```javascript
function changeBgColor() {
    let container = document.getElementById('container');
    container.style.backgroundColor = getRandomColor();
}

function changeTextColor(){
    let text = document.getElementById('text');
    text.style.color = getRandomColor();
}

function getRandomColor() {
    let r = Math.floor(Math.random() * 256);
    let g = Math.floor(Math.random() * 256);
    let b = Math.floor(Math.random() * 256);
    let rgb = `rgb( ${r}, ${g}, ${b})`;
    console.info(rgb);
    return rgb;
}
```


```javascript
let len = 50;

const shape = {
	len: 30
}

// Shorted variables
const circle = {
	len, // OK to add outer vars
	//scope.len // Error! Not possible without keyname
	scope: shape.len,
	[shape.len]: shape.len,
}

console.info(circle);
```
### Simple class

```javascript
class User {
    #firstName = '';
    #lastName = '';

    constructor(name, salary, gender) {
        this.#name = name;
        [this.#firstName, this.#lastName] = name.split(' ');
        this.salary = salary;
        this.gender = gender;
    }

    equals(user) {
        if (this.#name !== user.#name) return false;
        if (this.salary !== user.salary) return false;
        if (this.gender !== user.gender) return false;
        return true;
    }

    toString() {
        return JSON.stringify(this, null, 5);
    }

    valueOf() {
        let code = 0;
        for (let char of this.#name) {
            code += char.charCodeAt(0);
        }
        return code;
    }

    set name(name) {
        this.#name = name;
        [this.#firstName, this.#lastName] = name.split(' ');
    }

    get name() {
        return this.#name;
    }
}

let u1 = new User('Sujith Manchala', 20_000, 'Male');
let u2 = new User('Sujith Manchala', 20_000, 'Male');
let u3 = new User('Pranisha Choppari', 20_000, 'Male');

console.info(u1.equals(u2));
console.info(u2.equals(u3));
console.info(u1.equals(u3));

u1.name = 'Vineeth Manchala';
u2.name = 'Sumanth Pittala';
console.info(u1);

console.info(u1.valueOf());
console.info(u1 + 6);
console.info('hellow' + u1 + 6);
```


### Can't declare class instance variables with let/const.
```javascript
"use strict"
// Can't declare variable with let or const.
class Box {
	static name = 'box';
	len = 30;
	wid = 100;
	//let len = 30; // Error!
	//const width = 100; //Error!
	constructor(len, wid) {
		this.len = len;
		this.wid = wid;
	}
}

let b1 = Box;
console.info(1.1, b1); // [class box] { name: 'box' }

let b2 = new Box; // Same as new Box();
console.info(1.2, b2); // box { len: undefined, wid: undefined }

let b3 = new Box(50);
console.info(1.3, b3); // box { len: 50, wid: undefined }

let b4 = new Box(10,20);
console.info(1.3, b4); // 1.3 box { len: 10, wid: 20 }
```
### Need not to declare variables inside class use constructor instead.
***You can also set default variables.***
```javascript
"use strict"
// Can't declare variable with let or const.
class Box {
	static name = 'box';
	// len = 30; 	// No Need
	// wid = 100;	// No Need
	//let len = 30; // Error!
	//const width = 100; //Error!
	constructor(len = 10, wid = 20) {
		this.len = len;
		this.wid = wid;
	}
}

let b1 = new Box(1, 2);
let b2 = new Box(5, 10);
let b3 = new Box(10, 20);
let b4 = new Box(35, 70);

let arr = [b1, b2, b3, b3];
arr.forEach(e => console.log(e));
```


### Example 001
```javascript
let arr = [23,45,43,46,32,12,1000];

let emp = {
	name : 'Sujith',
	age : 28,
	sal : 1_00_000

}

function max(...arr){
	console.info('Received array '+ arr)
	let max = -9999999999;
	let max2 = max;
	for(let val of arr){
		console.info('Elements : ' + val);
		if(val > max){
			let temp = max;
			max = val;	
			max2 = temp;
		}else if(val > max2){
			 max2 = val;
		}
			
	}
	return max2;
}
console.info(`Max value: ${max(...[1,23,45],343,532,112,...arr,500)}`)
console.info(`Max value: ${max(...[1,23,6])}`)
```


### Example 002
```javascript
let arr = [23,45,43,46,32,12,1000];

let emp = {
	name : 'Sujith',
	age : 28,
	sal : 1_00_000
}

function max(...arr){
	console.info('Elements: ');
	for(let i=0;i < arr.length -1 ;i++){
		console.info( arr[i]);
		let min = i;
		for(let j=i + 1;j < arr.length;j++){
			// Find the minimun 
			if(arr[j] < arr[min]){
				min = j;
			}
		}
		// Swap
		let temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
	}
	return arr;
}
console.info(`Max value: ${max(...arr)}`)
```


### Example 003
```javascript
let arr = [23,45,1,43,46,32,12,1000];

arr.shift();
arr.shift();
arr.unshift(100);
arr.pop();
arr.push(222);
arr.sort( (a,b)=> a - b ); // [12, 32, 43, 46, 100, 222]
ans = arr.filter(e => e % 2 == 1).reduce( (ans, val) => ans + val  );
let arr2 = arr.slice(0,1);
console.info(arr);
console.info(arr2);
console.info(`Sum of even numbers : ${ans}`);

arr.length = 3;

console.info(arr);
```


### Example 004
```javascript
let name = 'Sujith';
let status = 'Single';
let emp = {
	name,
	age : 26,
	status,
	sayHi(){
		console.info(`Hello Mr.${name}`);
	}
}
//emp.sayBye(); // Error: emp.sayBye is not a function
emp.sayBye?.(); // To avoid Error!
emp['sayHi']?.();
emp.sayHi(); 
emp['sayHi']();
console.info(emp);
```

# You may also come across another syntax: typeof(x). It’s the same as typeof x.
```javascript
let x = 3.14;    // A number with decimals
let y = 3;       // A number without decimals
let x = 123e5;    // 12300000
let y = 123e-5;   // 0.00123
let x = 100 / "Apple"; // NaN
let f = isNaN(x);
let x = 100 / "10"; // String is Numeric
```
**Note: If you use NaN in a mathematical operation, the result will also be NaN**
```javascript
typeof NaN; // NaN
let x =  2 // 0; Infinity
let y = -2 / 0; // -Infinity
let x = 0xFF; 
```
**Note: A BigInt value is created by appending n to the end of an integer.**
```javascript
let b = 123n; // BigInt
let y = x / 3; // Arithmetic between a BigInt and a Number is not allowed
let hex = 0x20000000000003n; // 0x
let oct = 0o400000000000000003n // 0o
let bin = 0b1000011n; // 0b
let x = Number.MAX_SAFE_INTEGER;
let x = Number.MIN_SAFE_INTEGER;
Number.isInteger()
Number.isSafeInteger()
```
Number Methods:
- toExponential()
- toString()
- toFixed
- toPrecision
- ValueOf

```javascript
let x = 9.656;
console.info(x.toExponential()) // 9.656e+0
console.info(x.toExponential(2)) // 9.66e+0
console.info(x.toExponential(4)) // 9.6560e+0
console.info(x.toExponential(6)) // 9.656000e+0
```

**There are 7 primitive types: string, number, bigint, boolean, symbol, null and undefined.**

**Note: Never use constructor of the Javascript `Primitive Wrappers`**

```javascript
let billion = 1_000_000_000;
let billion = 1000000000;

let billion = 1e9;  // 1 billion, literally: 1 and 9 zeroes

1e3 === 1 * 1000; // e3 means *1000
1.23e6 === 1.23 * 1000000; // e6 means *1000000
let a = 0b11111111; // binary form of 255
let b = 0o377; // octal form of 255

toString(base) // base 36 is max
let num = 255;
alert( num.toString(16) );  // ff
alert( num.toString(2) );   // 11111111
```



**Two dots to call a method**
```javascript
alert( 123456..toString(36) ); // 2n9c
alert( 123456.toString(36) ); // Error!!!


boolean isFinite(int)
boolean isNan(int)

alert( parseInt('100px') ); // 100
alert( parseFloat('12.5em') ); // 12.5
alert( parseInt('12.3') ); // 12, only the integer part is returned
alert( parseFloat('12.3.4') ); // 12.3, the second point stops the reading
string parseInt(str, int radix)
```
0x : Hex
0o : Oct
0b : Binary

let num = 0xff342343423422;
let b36 = num.toString(36);
console.info(b36);


Iterables

Iterable objects are a generalization of arrays.
for..of loop


# Symbol.iterator

/^[7-9]{2}\d{8}$/.test('8808188021') //true



let range = {
  	from: 1,
	to: 5,
	[Symbol.iterator]() {
		console.info('Inside Symbol.iterator')
    		this.current = this.from;
    		return this;
  	},

  	next() {
    		if (this.current <= this.to) {
			console.info('Inside done: false')
      			return { done: false, value: this.current++ };
    		} else {
			console.info('done: true')
      			return { done: true };
    		}
  	}
};

for(let r of range){ // TypeError: range is not iterable
	console.info(r);
}


Keywords
JavaScript was invented by Brendan Eich in 1995, and became an ECMA standard in 1997.
ECMA-262 is the official name of the standard. ECMAScript is the official name of the language.
• Transpire
• Interactive
• exciting
• Transpiled
• Transpilation
• Javascript engine
• ECMA Script
• Embedded Engine
• Javascript virtual machine
• Codename
• V8
• Spider Monkey
• evolving into a versatile and indispensable language for web development.
Type coercion in JavaScript
• refers to
• Automatic conversation
• Implicit conversation
• Occurs in
• leads to
• Unexpected results
• Unintuitive results
A closure in JavaScript
• lexical environment
• retain
• access
• outer function
• inner function
• nested function
Hoisting
• Containing scope
• Compilation phase
• hoisting
• variable declarations
• function declaration
• top of scope
• undefined
• hoistedFunction
• Improve code clarity
• Avoid potential issues
===
• Strict equality comparison
Function declaration
• function name
• parameter list
• function body
• current scope
Function Expression
• Involves assigning a function to a variable or a property of an object.
Prototypal inheritance
• [[Prototype]]
• prototype link
• parent object
• child object
• Object.create()
• prototype chain
• Inherited properties
• prototype chain
• circular reference not possible
• JavaScript's object-oriented programming paradigm.
Object Properties
• Data properties
• Accessor properties
• behind the scenes
• Virtual properly
Property flags and descriptors
• Special attributes
• Writable / Non-Writable (readonly)
• Enumerable /Non-enumerable (doesn't show up in for..in and in Object.keys/entries/values)
• Configurable / Non-configurable (configurable: false prevents changes of property flags and its
deletion, while allowing to change its value)
• A non-configurable property cannot be deleted or altered with defineProperty.
• get Own Property Descriptor
• define Property
• Flag violation
• Strict mode/Non strict mode
• forever sealed constant (non-writable,
non-configurable) ex:Math.PI
• flags aware cloning
• let clone = Object.defineProperties({}, Object.getOwnPropertyDescriptors(obj));
Sealing an object globally
• Prevent extension
• Seal
• Freeze
Class
• A class is technically a function
• Function Declaration
• Function Expression
• Class Declaration
• Class Expression
• Class Constructor
• Named function expression
• Computed key names
• losing 'this' problem
• Syntactic sugar
Constructor function
• Two conventions
!! convert to boolean operator
?? Nullish coalescing operator
?: Conditional operator
?. Optional chaining
alert( user?.address?.street );
${} String interpolation
Properties
• Data properties
• Accessor properties
Accessors
• functions
• look like regular properties
• Represented by Getters and Setters
• Smart getters and setters contains logic before set and getting.
Conditional branching
• 0, "", null, undignified, NaN consider as falsy values.
• All the remaining values consider as truly values.
Private properties
• Privatisation of the properties isn't supported by JS.
• Use can you conventions by added understand as a prefix to warn the developer not to access
directly.
Each new version brings additional improvements and enhancements to the language.
ES6 (ES2015):
1. `let` - Declaration of block-scoped variables.
2. `const` - Declaration of block-scoped constants.
3. Arrow Functions (`() => {}`) - A concise syntax for writing functions.
4. Template Literals (``) - A syntax for creating multi-line strings and embedding expressions.
Template literals, also known as template strings. introduced in ES6 (ES2015) that allow for
more flexible string interpolation in JavaScript. They are denoted by backticks ( ) instead of
single or double quotes.
5. `...` (Spread/Rest Operator) - Used to spread an array into individual elements or gather
multiple elements into an array.
6. Destructuring Assignment - A concise syntax for extracting values from arrays or objects.
7. `class` - A syntax for defining classes in JavaScript.
8. Modules (`import`/`export`) - A mechanism for organizing and sharing code across multiple
files.
9. `Promise` - A built-in object for handling asynchronous operations.
10. `Map`, `Set`, `WeakMap`, `WeakSet` - New data structures for storing collections of unique
values.
ES2016:
1. Exponentiation Operator (`**`) - A shorthand notation for exponentiation.
ES2017:
1. Async/Await - A syntax for writing asynchronous code in a more synchronous style using
`async` and `await` keywords.
ES2018:
1. `Object.entries()` - Returns an array of a given object's own enumerable property `[key,
value]` pairs.
2. `Object.values()` - Returns an array of a given object's own enumerable property values.
3. `Object.getOwnPropertyDescriptors()` - Returns all property descriptors of a given object.
4. Rest/Spread Properties - Allows for the spreading of properties in object literals and the
gathering of remaining properties.
5. Asynchronous Iteration - Enables asynchronous iteration over objects and arrays using
`for-await-of` loop.
ES2019:
1. Array.prototype.flat() and Array.prototype.flatMap() - Methods for manipulating arrays with
nested sub-arrays.
2. Optional Catch Binding - Allows for catch clauses without a binding variable.
ES2020:
1. Optional Chaining (`?.`) - Allows for safe navigation of nested properties or method calls
when intermediate values may be `null` or `undefined`.
2. Nullish Coalescing Operator (`??`) - Provides a way to provide default values for variables
when the value is `null` or `undefined`.
3. BigInt - A new numeric primitive for representing arbitrarily large integers.
4. Dynamic Import - Allows for importing modules asynchronously on-demand using a `import()`
function.
• import { function1, function2 } from 'library-name';
• import LibraryName from 'library-name';
The axios library provides a convenient and intuitive API for handling HTTP requests and
responses. It abstracts away many of the complexities of working with the XMLHttpRequest
object or the fetch() API directly.
• setInterval(updateClock, 1000);
• tinycolor2
• npm install randomcolor
• npm install tinygradient
• npm install random-gradient
• npm install randomfont
• Chance.js - Random data generator
Install: npm install chance
• Faker.js - Fake data generator
Install: npm install faker
• Paper.js - Vector graphics library
Install: npm install paper
• Howler.js - Audio library
Install: npm install howler
• Babylon.js - 3D graphics engine
Install: npm install babylonjs
• NES.css - NES-inspired CSS framework
Install: npm install nes.css
A Promise is an object that represents the eventual completion (or failure) of an asynchronous
operation and its resulting value. It is a way to handle asynchronous operations in a more
structured and manageable manner.
A Promise can be in one of three states:
• Pending: The initial state of a Promise. It is neither fulfilled nor rejected.
• Fulfilled: The Promise has successfully completed, and a value is available. This is typically
referred to as resolving the Promise.
• Rejected: The Promise encountered an error or failure during execution. This is typically
referred to as rejecting the Promise.
Unlike synchronous operations, which are executed sequentially and block the program until
they are completed, asynchronous operations allow the program to continue executing other
tasks while waiting for the completion of the asynchronous task.
Note:
for...of only work with iterables, not with object. For array it will give values instead of indexes.
for...in works with iterables as well as objects. For array, it will give indexes. For an object it will
give key values.

```javascript
let arr = ["A", "B"]
let [x, y] = arr;

alert(x); // A
alert(y);  // B


let [firstName, surname] = "John Smith".split(' ');
alert(firstName); // John
alert(surname);  // Smith

// Ignore elements using commas
let [l, , , m] = ["A", "B", "C", "D"];
console.info(l);	// 'A'
console.info(m);	// 'D'
```


**Works with any iterable on the right-side**
> Works with any iterable 
> It’s a kind of syntax sugar for calling `for..of`

```javascript
let [a, b, c] = "abc";
let [one, two, three] = new Set([1, 2, 3]);
````


**Assign to anything at the left-side**

```javascript
let user = {};
[user.name, user.surname] = "John Smith".split(' ');

alert(user.name); // John
alert(user.surname); // Smith
```

***Looping with .entries()***


```javascript
let user = {
  name: "John",
  age: 30
};


for (let [key, value] of Object.entries(user)) {
  alert(`${key}:${value}`);
}
```

```javascript
let user = new Map();
user.set("name", "John");
user.set("age", "30");


for (let [key, value] of user) {
  alert(`${key}:${value}`);
}
```


**Swap variables trick**

```javascript
let guest = "Jane";
let admin = "Pete";

[guest, admin] = [admin, guest];

alert(`${guest} ${admin}`);
```


**The rest `…`**

```javascript
let [name1, name2, ...titles] = [`A`,`B`,`C`,`D`,`E`];
```

***Default values***

```javascript
let [firstName, surname] = [];
let [x = "A", y = "B"] = ["Julius"];


let {var1, var2} = {var1:…, var2:…}
let {height, width, title} = { title: "Menu", height: 200, width: 100 }
```


```javascript
let options = {
  title: "Menu",
  width: 100,
  height: 200
};

let {width: w, height: h, title} = options;

alert(title);  // Menu
alert(w);      // 100
alert(h); 
```



```javascript
let options = {
  title: "Menu"
};

let {width = 100, height = 200, title} = options;

alert(title);  // Menu
alert(width);  // 100
alert(height); // 200
alert(h); 
```


```javascript
let options = {
  title: "Menu"
};

let {width: w = 100, height: h = 200, title} = options;

alert(title);  // Menu
alert(w);      // 100
alert(h);      // 200
```


### Class and Constructors

```javascript

class User {
	// Note: no need to declare member variables as it in java.

	// id = 1234;
	// name = 'Sujith';
	// age = 25;	
 	// salary = 1e5;
	
	constructor(id ,name, age, salary){

	// Using this will automatically adds property even if that property on a class memeber.

		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
}

// Constructor calls
let u = new User; // same as new User()
let u2 = new User();
let u3 = new User(101, 'SamAlt Man'); // Remaining propertis will be undefined
let u4 = new User(102, 'Mark', 30, 1e7, 'Extra variable'); // Extra fields will be ignored

console.info(u);
console.info(u2);
console.info(u3);
console.info(u4);

// Copying properties
let u5 = {...u4};
console.info(u5);

// Update

let update = {
	salary : 123456,
	name : 'Eminem'
};
let u6 = {...u5, ...update};
console.info(u6);

class UserService {
	
	constructor(users){
		
		this.users = users ?? [];
		this.loadData();
	}

	loadData(){
		this.users = [u,u2,u3,u4,u5,u6];
	}

	findAllUsers(){
		return this.users; // without this it won't work
	}

	findAllUsers2(){
		let i = 0;
		return this.users.map( u =>  u = {...u,...{id : i++ }} );
	}
	
	deleteByIndex(id){
	 	let idx = users.findIndex(u => u.id == id)
		if(idx !== -1){
			this.users.splice(idx,1);
			return true;
		}
		return false;
	}

	saveUser(user){
		this.users.push(user);
	}

	saveUser2( {id, name, dept, salary} = user){
		this.users.push({id, name, dept, salary});
	}

	print(){
		console.info(JSON.stringify(this.findAllUsers(), null, 4));
	}
}

let us = new UserService();

// Note: undefined will be excluded in Stringity
console.info(JSON.stringify(us.findAllUsers(),null,5));
console.info(JSON.stringify(us.findAllUsers()[4], null, 4));

// find method will return whole object where as findIndex return index
let a = us.findAllUsers().find(u => u.id === 102);
console.info(typeof a);
console.info(a.id +" : "+ typeof a.id)
console.info(us.findAllUsers()[102]); // undefined

// Find an in indexed element
let i = us.findAllUsers().findIndex(u => u.id === 102);
console.info(typeof i);
console.info(i +" : "+ typeof i)
console.info(us.findAllUsers()[i]); // undefined

// Add index to every object
let users = us.findAllUsers2();
console.info('User along with the index');
console.info(users);

// Delete an object
console.info( 'Is deleted? ' + us.deleteByIndex(4));
console.info(us.findAllUsers2());

// Save all the properties
us.saveUser({ id : 450 ,game : 300, middlename : 'Manchala', name : 'Elon Musk'});
us.print();

// Restrict unwanted properties
us.saveUser2({ id : 450 ,game : 300, middlename : 'Manchala', name : 'Elon Musk'});
us.print();
```

```

arr = [10,1,7,2,3,4,5,6,7,2,1];

for(let i in arr){
	//console.log(i, arr[i]);
}

//arr.map( (e, i) => {console.info(i,e); return e;})


for(let e of arr){
	//console.log(e);
}

let set = new Set(arr);

console.log('Array to Set:',[...new Set(arr)].sort((a,b)=> a-b));	// Set
//console.log(set.constructor.name );	// Set
//console.log([...set].constructor.name); // Array
//console.log([].constructor.name); 	// Array
//console.log([...set].sort());			// [1, 2, 3, 4, 5, 6, 7 ]
//console.log([...set].sort().map(e => e*e));	// [ 1,  4,  9, 16, 25, 36, 49]
```


```
// Adjust the last item's percentage to make sure it adds up to 100%
// arr[arr.length - 1].per += 100 - totalPercentage;


console.info(JSON.stringify(arr, null, 5));
console.info('Total percentage' ,totalPercentage );

// Find percentage and add
// let name = 'Manchala';
// let arr2 = arr.map( e => ({ name ,...e})	);
// console.info(JSON.stringify(arr2, null, 5));

// arr.forEach( e => e.name = name);
// console.info(JSON.stringify(arr2, null, 5));

```






```
const arr = [
  {
    item: 'Book',
    cost: 24020,
    quenty: 3,
  },
  {
    item: 'Pen',
    cost: 3220,
    quenty: 10,
  },
  {
    item: 'Bottle',
    cost: 1232350,
    quenty: 1,
  },
  {
    item: 'Mouse',
    cost: 402320,
    quenty: 2,
  },
	{
    item: 'PlayStation',
    cost: 402320,
    quenty: 10,
  },
];

// Find total cost
let total = arr.reduce((a, i) => a + i.cost, 0);
console.info('Total cose: ',total);

// Calculate percentages and adjust to make sure they sum up to 100%
let totalPercentage = 0;
arr.forEach((e) => {
	e.total = e.quenty * e.cost; 
  	e.per = Math.round( e.cost  / total * 100 );
	console.info('e.cost  / total',e.cost  / total);
	console.info('e.cost  / total * 100',e.cost  / total * 100);
	console.info(
'Math.round(e.cost  / total * 100)',Math.round( e.cost  / total * 100 ));
  	totalPercentage += e.per;
});

console.info(JSON.stringify(arr, null, 5));
console.info('Total percentage' ,totalPercentage );
```

Till 18:59 28-07-2023





































































































































