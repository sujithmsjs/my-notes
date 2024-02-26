Certainly! Here are some JavaScript operators along with their descriptions:

| Operator          | Description                                      | Example                             |
|-------------------|--------------------------------------------------|-------------------------------------|
| `!!`              | Double Negation - Converts a value to a boolean by applying the logical NOT operator twice. | `!!"hello"` returns `true`          |
| `??`              | Nullish Coalescing Operator - Returns the right-hand operand if the left-hand operand is `null` or `undefined`, otherwise returns the left-hand operand. | `null ?? "default"` returns `"default"` |
| `?:`              | Conditional (Ternary) Operator - Returns one of two values based on a condition. | `x > 0 ? "positive" : "negative"`   |
| `${}`             | String Interpolation - Allows embedding expressions into string literals. | ```javascript `Hello, ${name}!` ``` |
| `?.`              | Optional Chaining - Allows you to access properties of an object without worrying if the intermediate properties exist or not. | `user?.address?.city`               |
| `**`              | Exponentiation Operator - Returns the base to the exponent power. | `2 ** 3` returns `8`                 |
| `===`             | Strict Equality Operator - Checks if two values are equal in value and type without type coercion. | `5 === "5"` returns `false`          |
| `!==`             | Strict Inequality Operator - Checks if two values are not equal in value or type without type coercion. | `5 !== "5"` returns `true`           |
| `typeof`          | Unary Operator - Returns a string indicating the type of the unevaluated operand. | `typeof x` returns `"number"`        |
| `instanceof`      | Binary Operator - Checks if an object is an instance of a specific class or constructor. | `obj instanceof MyClass`             |

These operators provide various functionalities in JavaScript, including type conversion, conditional operations, string manipulation, and type checking.


------------
For Loop
----------
**`for...of loop`**
The `for...of` loop is used to iterate over the values of an iterable object (`arrays, strings, maps, sets`, etc.).
**`for...in loop`**
The `for...in` loop is used to iterate over the properties of an object.
```js
for(let value of iterable){} // Prints Values
for(let index in iterable){} // Prints Indexes
for(let key of object){} // TypeError: emp is not iterable
for(let key in object){} // Prints Fields of Object

for(let [k,v] of Object.entries(employee)){
    console.info(k, v);
}

// Reading values from a Map
for (let [key, value] of myMap) {
    console.log(key, value);
}

// Reading values from forEach
myMap.forEach((value, key) => {
    console.log(key, value);
});
```



**`forEach loop (Array method)`**
The `forEach` loop is a method available for arrays to iterate over each element.
```js
arr.forEach( (value, index, arr) => {
} )
```

--------------------------
`var` v/s `let` v/s `const`
--------------------------

| Feature           | `var`                                          | `let`                                          | `const`                                        |
|-------------------|------------------------------------------------|------------------------------------------------|------------------------------------------------|
| Scope             | Function-scoped                                | Block-scoped                                   | Block-scoped                                   |
| Hoisting          | Hoisted to the top of the function or global scope | Hoisted to the top of the block scope        | Hoisted to the top of the block scope          |
| Reassignment      | Can be redeclared and reassigned              | Can be reassigned but not redeclared          | Cannot be reassigned or redeclared             |
| Initialization   | Can be initialized without assignment          | Can be initialized without assignment          | Must be initialized at the time of declaration |

This table summarizes the main differences between `var`, `let`, and `const` in terms of scope, hoisting, reassignment, and initialization.


--------------------
**Primitive types**
----------------------
There are 7 primitive types: 
1. string
2. **number:** The number type represents both integer and floating point numbers.
Besides regular numbers, there are so-called “special numeric values” which also belong to this data type: Infinity, -Infinity and NaN.
3. bigint
4. boolean
5. symbol
6. null
7. undefined.
*Note: Never use constructor of the Javascript `Primitive Wrappers`*


# Regular Expressions
```js
let searchTerm = "yourDynamicSearchTerm";
let n = text.search(new RegExp(searchTerm, "igm")); // Example using flags
```
-----------------------
Regular Expressions
-------------------------
```js
let searchTerm = "yourDynamicSearchTerm";
let n = text.search(new RegExp(searchTerm, "igm")); // Example using flags
```


**Arrow functions**
Arrow functions are used to write functions with a short and concise syntax.

**Closures**
- A closure is a combination of a function bundled together (enclosed) with references to its surrounding state (the lexical environment). This combination allows the function to retain access to variables from its containing scope even after the scope has closed.
- Closures are functions that have access to variables defined in their outer (enclosing) function, even after the outer function has finished executing. The inner function retains a reference to its outer lexical environment, allowing it to access variables and parameters.

- As any JavaScript object, it’s only kept in memory while it’s reachable.
- Closure Function is Alive, all the variables are retained
- All functions are naturally closures
- Contains hidden property [[Environment]]
- Access to Outer Lexical Environment
- Usually, a Lexical Environment is removed from memory with all the variables after the function call finishes
- Closure functions are alive
- Lexical Env still reachable even after the completion of the Fun.

**Note:**
- Every closure function has it's own independent outer Lexical Environments.

**Hoisting**
- Hoisting is a JavaScript behavior where variable and function declarations are moved to the top of their respective scopes ( local or global ) during the compilation phase. However, only the declarations are hoisted, not the initializations.


**Interaction**
```javascript
alert("Hello");
let age = prompt('How old are you?', 100);
let isBoss = confirm("Are you the boss?");
```

**Modify-in-place**
We often need to apply an operator to a variable and store the new result in that same variable.

**String comparison**
To see whether a string is greater than another, JavaScript uses the so-called `dictionary` or `lexicographical` order.

**Conditional operator ‘?’**

**Nullish coalescing operator '??'**
`&&` will give first falsy value or last truly value.
`||` will give first truly value or last falsy value.
`??` Won't consider `0,'',NaN,false` as falsy values

*The precedence of the ?? operator is the same as ||. They both equal 3 in the MDN table.*

*Due to safety reasons, JavaScript forbids using `??` together with `&&` and `|| operators, unless the precedence is explicitly specified with parentheses.*
```js
let x = 1 && 2 ?? 3; // Syntax error
let x = (1 && 2) ?? 3; // Works
```
**??= Operator**
```js
x ??= 10
// Is same as
x = x ?? 10
```
**Falsy Values:**
1. FALSE
2. BLANK STRING('')
3. NOT A NUMBER(NaN)
4. UNDEFINED
5. ZERO INTEGER(0)
6. NULL


**CRUD Operation on objects**
- Objects are associative arrays with several special features.
- They store properties (key-value pairs), where: Property keys must be strings or symbols (usually strings). Values can be of any type.
- To access a property, we can use:
    1. The dot notation
    2. Square brackets notation

- Functions that are stored in object properties are called “methods”.
- One of the fundamental differences of objects versus primitives is that objects are stored and copied “by reference”, whereas primitive values: strings, numbers, booleans, etc – are always copied “as a whole value”.

**Additional operators:**
- To delete a property: `delete obj.prop`.
- To check if a property with the given key exists ( Property existence): `"key" in obj`.
- To iterate over an object: `for (let key in obj)` loop.


**Trailing comma and Hanging comma**
`[1, 2, 3,];` // Trailing comma after the last element

**Computed properties**
- We can use square brackets in an object literal, when creating an object. That’s called computed properties.
- Square brackets are much more powerful than dot notation.

**Cloning and merging**

**Unreachable island**
It is possible that the whole island of interlinked objects becomes unreachable and is removed from the memory by `Garbage collection`


**Constructor function**
In JavaScript, a constructor function is a special type of function that is used to create objects. It is conventionally written with an uppercase letter to differentiate it from regular functions.

There are two conventions though:
1.   They are named with capital letter first.
2. They should be executed only with `new` operator.



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

This constructor function may be converted to a class declaration.
The same constructor function can be written as 
```javascript
class Person {
    constructor(name, dept) {
        this.name = name;
        this.dept = dept;
    }
}
```

**XHR request**
XMLHttpRequest (XHR) is a JavaScript class containing methods to asynchronously transmit HTTP requests from a web browser to a web server. 

**Optional chaining `?.`**
A chain of `?.` allows to safely access nested properties.
Other variants: `?.(), ?.[]`
- `obj?.prop`
- `obj?.[prop]`
- `obj?.[method]()`
- `obj.method?.()`

**String Interpolation**
**Chaining assignments**
**Modify-in-Place**
**haracter precedence**

**Comma Operator**
```javascript
let b = 5;
let a = (b = b + 5, 3 + 4);
console.warn(b);
```

**How many types can we itterate over Objects**
1. `for...in` loop
2. `Object.keys(obj).forEach(k => {})`
3. `Object.values(obj).forEach(v => {})`
4. `Object.entries(employee).forEach(([key, value]) => {})`
*In JavaScript, setting the length of an array to a shorter value than its current length removes the elements from the array starting from the new length.*

In how many ways can read properies in a object in JS.
- Dot notation
- Bracket notation
- Object destructuring
- Object methods
- for...in loop

**Array Tricks**
- `stack.length = 0;` // Clear the array
- `delete stack;` // Delete the array variable
- Methods
concat, join, push, pop, shift, unshift, slice, splice, reverse, sort, filter, map, reduce, forEach, find, indexOf, includes, some, every


**A double NOT !!**
A double NOT !! is sometimes used for converting a value to boolean type:
`alert( !!"non-empty string" );` // true

-----------------
Template literals
-----------------
Template Literals (``) - A syntax for creating multi-line strings and embedding expressions.
Template literals, also known as template strings. introduced in ES6 (ES2015) that allow for
more flexible string interpolation in JavaScript. They are denoted by backticks ( ) instead of
single or double quotes.


--------------------
Rest Parameters
---------------------
A function can be called with any number of arguments, no matter how it is defined.

- Excessive Arguments
- The rest parameters must be at the end
- SyntaxError: Rest parameter must be last formal parameter
- Built-in Support
- Arbitrary number of arguments

    Example:
    `Math.max(arg1, arg2, ..., argN)` – returns the greatest of the arguments.
    
    - `(...)`gather the remaining parameters into an array.
    - The rest parameters must be at the end.
    ```js
    function sum(...numbers) {
    }
    ```
**Spread syntax**
- The spread syntax internally uses iterators to gather elements, the same way as `for..of` does.
- Spread syntax to the rescue! It looks similar to rest parameters, also using `...`, but does quite the opposite.
- When `...arr` is used in the function call, it “expands” an iterable object arr into the list of arguments.

    Example:
    `Object.assign(dest, src1, ..., srcN)` – copies properties from src1..N into dest.
    ```javascript
    let arr = [3, 5, 1];
    alert( Math.max(...arr) ); // 5 (spread turns array into a list of arguments)
    sum(...arrr);
    ```

**Spread V/s Rest**
> When we see `...` in the code, it is either rest parameters or the spread syntax.

There’s an easy way to distinguish between them:

When `...` is at the end of function parameters, it’s “rest parameters” and gathers the rest of the list of arguments into an array.
When `...` occurs in a function call or alike, it’s called a “spread syntax” and expands an array into a list.


Use patterns:

Rest parameters are used to create functions that accept any number of arguments.
The spread syntax is used to pass an array to functions that normally require a list of many arguments.


**Null v/s Undefined**
- `null` represents the intentional absence of any object value, while `undefined` represents the absence of a defined value.
- In other words, `null` is a value assigned by developers, whereas `undefined` is the default value assigned by JavaScript.

**== v/s ===**
- The `==` operator checks for equality after performing type coercion, while the `===` operator checks for equality without type coercion.
- In other words, `===` performs a strict equality check, including both value and type.

**Event loop**
The event loop is a mechanism in JavaScript that handles asynchronous operations. It continuously checks the call stack for any pending tasks and executes them one by one, ensuring that the program remains responsive.

**Handle errors in JavaScript**
- JavaScript provides try-catch-finally blocks to handle errors.
- The code within the `try` block is executed, and if an error occurs, it is caught in the `catch` block where you can handle or log the error.
- The `finally` block is executed regardless of whether an error occurred or not.


**Prototypal inheritance**
- JavaScript uses prototypal inheritance, where objects can inherit properties and methods from other objects.
- Each object has an internal link to its prototype, and if a property or method is not found in the object itself, it is looked up in its prototype chain.


**event propagation**
**Preventing event propagation**
Event propagation can be stopped using the `stopPropagation()` method. When called on an event object within an event handler, it prevents the event from bubbling up the DOM tree or capturing down the DOM tree, depending on the event phase.

**Object destructuring**
In JavaScript, you can use object destructuring to copy values from one object to another.
```javascript
const source = { name: 'John', age: 30 };
const destination = { ...source };
```

**In how many ways can we clone JS Object**

If you want to perform a deep copy, including nested objects, you would need to use other techniques like recursive functions or libraries like Lodash's `cloneDeep()` method.

1. Spread Operator(`...`) :  To create a shallow copy of an object.
2. Object.assign(): To copy the values of all enumerable properties from one or more source objects to a target object.
3. JSON.parse() and JSON.stringify(): 
 - For creating a deep copy of an object
 - Only works with serializable objects((i.e., it doesn't contain functions, symbols, or circular references)
4. Object.create()
    ```javascript
    const originalObj = { name: 'John', age: 30 };
    const clonedObj = Object.create(Object.getPrototypeOf(originalObj), Object.getOwnPropertyDescriptors(originalObj));
    ```
5. Custom cloning function:

**Shallow copy v/s Deep copy**

**The empty parentheses Constructor**
Example:
```new Date v/s new Date()```

- The empty parentheses explicitly indicate that no arguments are being passed to the constructor.
- The parentheses are optional when no arguments need to be passed to the constructor.
- However, the presence or absence of the parentheses does not affect the behavior or result in this case.


**Anonymous Function**
- Lambda function
- Function expression

**indexOf v/s search**
**indexOf:** Performs a simple string search, which has a time complexity of O(n), where n is the length of the string.
**search:** Performs a regular expression search, which can have varying time complexities depending on the complexity of the regular expression pattern.


------------------------
The Fisher-Yates Shuffle
------------------------

The Fisher-Yates Shuffle is an algorithm used to shuffle the elements of an array randomly. It ensures that every permutation of the original array is equally likely. The algorithm works by iterating over the array in reverse order and swapping each element with a randomly selected element from the unshuffled portion of the array.

------------------------
Implicit Type Coercion
------------------------

- Implicit type coercion refers to the automatic conversion of values from one data type to another by the JavaScript engine.
- This occurs in situations where operands of different types are used together in an expression or operation.
- For example, when using the + operator with a string and a number, JavaScript will implicitly convert the number to a string and concatenate the two values.

------------------------
Immediately Invoked Function (IIFE):
------------------------
- Also called as Self-Invoking Function.
- An Immediately Invoked Function Expression (IIFE) is a function that is executed immediately after it's created.
- It is typically wrapped in parentheses to ensure it's treated as an expression and followed by an additional pair of parentheses to invoke it immediately.
    ```js
    (function() {
        console.log("I am immediately invoked!");
    })();
    ```

-----------------------------------
Strict Mode
-----------------------------------
Strict mode is a feature in JavaScript that enables a stricter set of rules for writing JavaScript code. It helps catch common coding mistakes and prevents certain unsafe actions. It is activated by adding the "use strict"; directive at the beginning of a script or a function.


Strict mode in JavaScript provides a way to opt in to a restricted variant of JavaScript where certain "bad" or "unsafe" code is not allowed. It helps catch common coding errors and make code more secure. There are several reasons why developers use strict mode:

1. **Catch Common Coding Mistakes:**
   - Strict mode helps catch common coding mistakes and "silent" errors that would otherwise fail silently or exhibit non-standard behavior.
   - For example, assigning a value to an undeclared variable will throw a `ReferenceError` in strict mode, whereas it would create an implicit global variable in non-strict mode.

2. **Prevent Implicit Globals:**
   - In non-strict mode, forgetting to declare a variable with `var`, `let`, or `const` will create an implicit global variable. This can lead to hard-to-find bugs and unexpected behavior.
   - Strict mode prohibits the use of implicit global variables, helping developers write cleaner and more maintainable code.

3. **Make `eval()` Safer:**
   - In strict mode, the `eval()` function creates a new variable scope, preventing it from polluting the enclosing scope with new variable declarations.
   - Without strict mode, `eval()` can introduce security vulnerabilities and make code harder to reason about.

4. **Disallow Octal Numeric Literals:**
   - In strict mode, Octal literals (e.g., `077`) are not allowed. They are deprecated in ECMAScript 5 and can lead to confusion due to their behavior (e.g., `010 === 8`).
   - Strict mode requires using the `0o` prefix for octal literals (`0o77`).

5. **Prohibit Re-assigning Immutable Bindings:**
   - Strict mode prohibits re-assigning variables declared with `const`. This helps enforce immutability for variables that are intended to be constant.
   - In non-strict mode, re-assigning a `const` variable would fail silently or throw an error depending on the JavaScript engine.

6. **Eliminate `with` Statement:**
   - The `with` statement is not allowed in strict mode. It is considered harmful because it introduces ambiguity and can lead to unexpected behavior by changing variable scopes dynamically.

Overall, strict mode promotes safer and more predictable coding practices, reduces the likelihood of bugs, and helps ensure compatibility with future versions of JavaScript. It's recommended to use strict mode in all JavaScript codebases to leverage these benefits.

-----------------------------------
Higher-Order Function:
-----------------------------------
- A higher-order function is a function that takes another function as an argument or returns a function as a result.
- This allows for functions to be composed, passed around, and used as building blocks for more complex operations.
    ```js
    function applyOperation(num1, num2, operation) {
        return operation(num1, num2);
    }
    
    function add(a, b) {
        return a + b;
    }
    
    console.log(applyOperation(5, 3, add)); // Output: 8
    ```
-----------------------------------
Currying
-----------------------------------
- Currying is the process of converting a function with multiple arguments into a sequence of nested functions, each taking a single argument.
- It allows for partial application of functions and enables the creation of more specialized functions from more general ones.

    ```js
    function multiply(x) {
        return function(y) {
            return x * y;
        };
    }
    
    const multiplyBy2 = multiply(2);
    console.log(multiplyBy2(5)); // Output: 10
    ```

-----------------------------------
Memoization
-----------------------------------
Memoization is an optimization technique used to store the results of expensive function calls and return the cached result when the same inputs occur again. It helps improve performance by avoiding redundant computations.

-----------------------------------
BOM (Browser Object Model)
-----------------------------------
- The Browser Object Model (BOM) is a collection of objects provided by the web browser to interact with the browser window, such as manipulating the browser history, controlling the browser location, and managing browser windows.
- BOM is the Browser Object Model where users can interact with browsers that is a window, an initial object of the browser.
- The window object consists of a document, history, screen, navigator, location, and other attributes. Nevertheless, the window’s function can be called directly as well as by referencing the window.
    ```js
    console.log(window.innerWidth);
    console.log(window.location.href);
    ```

------------------------
Generator Function
------------------------
- Generator functions are declared with a special class of functions and keywords using function*.
- It does not execute the code, however, it returns a generator object and handles the execution.
- A generator function is a special type of function in JavaScript that can be paused and resumed.
- It allows for the generation of a sequence of values lazily, on demand, using the yield keyword.
    ```js
    function* generateNumbers() {
        yield 1;
        yield 2;
        yield 3;
    }
    
    const iterator = generateNumbers();
    console.log(iterator.next().value); // Output: 1
    console.log(iterator.next().value); // Output: 2
    console.log(iterator.next().value); // Output: 3
    ```

------------------------
Callback Function
------------------------
- A callback function is a function that is passed as an argument to another function and is executed after a particular operation has been completed.
- Callbacks are commonly used in asynchronous programming to handle the result of asynchronous operations.

------------------------
Prototypal Inheritance
------------------------
Prototypal inheritance is a mechanism in JavaScript where objects inherit properties and methods from other objects through prototypes. Each object has an internal link to another object called its prototype, which it inherits properties and methods from.

------------------------
Temporal Dead Zone
------------------------

The Temporal Dead Zone (TDZ) refers to the period within a block scope where a variable exists but cannot be accessed before its declaration due to the effects of hoisting. Accessing a variable in the TDZ results in a ReferenceError.

------------------------
Lexical Scoping
------------------------
Lexical scoping is a feature in JavaScript that determines the scope of variables based on their location within the source code. Variables are resolved based on where they are defined in the code, regardless of where they are invoked.

------------------------------
DOM (Document Object Model)
-------------------------------
The Document Object Model (DOM) is a programming interface provided by web browsers that represents the structure of HTML documents as a hierarchical tree of nodes. It allows JavaScript to interact with and manipulate the content and structure of web pages dynamically.



------------------------------------
Interpreted Programming Languages
-----------------------------------
Interpreted programming languages are languages where the source code is executed directly by an interpreter, without the need for compilation into machine code. JavaScript is an example of an interpreted programming language.




------------------------
Variable Scopes
------------------------
Variable scope refers to the visibility and accessibility of variables within a program. JavaScript has function-level scope by default, meaning variables are accessible only within the function in which they are defined. However, with the introduction of let and const, block-level scope is also possible.


-----------------------------------
Function Declaration V/s Function Expression:
-----------------------------------
Here's a comparison of Function Declaration vs Function Expression presented in a table format:

| **Feature**                | **Function Declaration**                                     | **Function Expression**                                  |
|----------------------------|--------------------------------------------------------------|----------------------------------------------------------|
| **Hoisting**               | Yes                                                          | No                                                       |
| **Syntax**                 | Begins with the `function` keyword followed by the function name. | Can be named (function name is optional) or anonymous. |
| **Usage**                  | Can be used before it's declared (due to hoisting).           | Must be defined before it's used.                       |
| **Example**                | ```javascript                                               | ```javascript                                            |
|                            | function myFunction() {                                      | const myFunction = function() {                          |
|                            |     return "Hello, world!";                                  |     return "Hello, world!";                              |
|                            | }                                                            | };                                                        |
| **Named Function**         | Yes (function name is mandatory).                            | Optional (can be named or anonymous).                   |
| **Anonymous Function**     | No                                                           | Yes (function without a name).                          |
| **Function Type**          | Statement                                                     | Expression                                               |
| **Assignment to Variable** | Not applicable                                               | Assigned to a variable (e.g., const, let, var).         |
| **Example**                | ```javascript                                               | ```javascript                                            |
|                            | function myFunction() {                                      | const myFunction = function() {                          |
|                            |     return "Hello, world!";                                  |     return "Hello, world!";                              |
|                            | }                                                            | };                                                        |

This table provides a clear comparison between Function Declaration and Function Expression in JavaScript, highlighting their differences in terms of hoisting, syntax, usage, and other features.

-----------------------------------
Storages:
-----------------------------------
Storages refer to mechanisms in web browsers for storing data persistently on the client-side. This includes mechanisms such as localStorage, sessionStorage, and cookies, which can be used to store data locally on the user's device.

LocalStorage:
LocalStorage allows storing key-value pairs in a web browser with no expiration date. The data persists even after the browser is closed and reopened.

SessionStorage:
SessionStorage is similar to LocalStorage but with the key difference that data persists only for the duration of the page session. Data is cleared when the tab or window is closed.

Cookies:
Cookies are small pieces of data stored on the client's machine. They can be set with an expiration date and can be accessed by both the client and the server.

IndexedDB:
IndexedDB is a low-level API for client-side storage of significant amounts of structured data, including files/blobs. It provides a way to store and retrieve data using an indexed database.

Web Storage API:
The Web Storage API consists of the localStorage and sessionStorage objects, providing a simple key-value storage mechanism in the browser. It's a convenient way to store data on the client-side.

-------------------------------
LocalStorage vs SessionStorage
--------------------------------
Here's a comparison of LocalStorage vs SessionStorage presented in a tabular format:

| **Feature**            | **LocalStorage**                                                  | **SessionStorage**                                                      |
|------------------------|--------------------------------------------------------------------|--------------------------------------------------------------------------|
| **Data Persistence**   | Data persists even after the browser is closed and reopened.        | Data persists only for the duration of the page session.                 |
| **Storage Limit**      | Typically 5-10MB depending on the browser.                         | Same as LocalStorage (5-10MB depending on the browser).                  |
| **Scope**              | Shared across all tabs and windows under the same origin.           | Limited to the tab or window that created it.                            |
| **Expiration**         | Data does not expire unless explicitly cleared by the user or script. | Data is cleared when the page session ends (tab or window is closed).    |
| **Usage**              | Suitable for long-term storage of data such as user preferences, cached data, etc. | Suitable for storing temporary data needed during the current session.    |
| **Example**            | ```javascript                                                     | ```javascript                                                           |
|                        | localStorage.setItem('username', 'JohnDoe');                      | sessionStorage.setItem('isLoggedIn', 'true');                          |
|                        | const username = localStorage.getItem('username');                | const isLoggedIn = sessionStorage.getItem('isLoggedIn');               |
|                        | console.log(username); // Output: "JohnDoe"                       | console.log(isLoggedIn); // Output: "true"                              |

This comparison table highlights the key differences between LocalStorage and SessionStorage in terms of data persistence, scope, expiration, usage, and examples. Choose the appropriate storage mechanism based on your application's requirements for data storage and accessibility.


------------
ES6 (ES2015)
------------
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






----------
ES2016
-----------
1. Exponentiation Operator (`**`) - A shorthand notation for exponentiation.
ES2017:
1. Async/Await - A syntax for writing asynchronous code in a more synchronous style using
`async` and `await` keywords.


----------
ES2018
----------
1. `Object.entries()` - Returns an array of a given object's own enumerable property `[key,
value]` pairs.
2. `Object.values()` - Returns an array of a given object's own enumerable property values.
3. `Object.getOwnPropertyDescriptors()` - Returns all property descriptors of a given object.
4. Rest/Spread Properties - Allows for the spreading of properties in object literals and the
gathering of remaining properties.
5. Asynchronous Iteration - Enables asynchronous iteration over objects and arrays using
`for-await-of` loop.
----------
ES2019
----------
1. Array.prototype.flat() and Array.prototype.flatMap() - Methods for manipulating arrays with
nested sub-arrays.
2. Optional Catch Binding - Allows for catch clauses without a binding variable.
----------
ES2020
----------
1. Optional Chaining (`?.`) - Allows for safe navigation of nested properties or method calls
when intermediate values may be `null` or `undefined`.
2. Nullish Coalescing Operator (`??`) - Provides a way to provide default values for variables
when the value is `null` or `undefined`.
3. BigInt - A new numeric primitive for representing arbitrarily large integers.
4. Dynamic Import - Allows for importing modules asynchronously on-demand using a `import()`
function.

