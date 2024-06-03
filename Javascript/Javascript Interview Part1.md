### What’s the difference between let and var?

SCOPE:
Variables declared with var are function-scoped. 
Variables declared with let are block-scoped.

HOISTING:
Variables declared with var are hoisted to the top of their function or global scope and are initialized with undefined.
Variables declared with let are also hoisted to the top of their block scope, but unlike var, they are not initialized.

RE-DECLARATION:
Variables declared with var can be re-declared within the same scope without any errors.
Variables declared with let cannot be re-declared within the same scope. Attempting to do so will result in a SyntaxError.

### What are Closures in JavaScript?


In JavaScript, a closure is a combination of a function bundled together (enclosed) with references to its surrounding state (the lexical environment). This combination allows the function to retain access to variables from its containing scope even after the scope has closed.

Lexical Environment: This consists of any local variables that were in-scope at the time the closure was created. This includes the outer function's variables and parameters, as well as any global variables.


### What are Imports and Exports in JavaScript?
Imports and exports help in writing modular code for our JavaScript applications. With the help of imports and exports, we can split a JavaScript code into multiple files in a project. This greatly simplifies the application source code and encourages code readability.


### What is the difference between Undefined and Null in JavaScript?
UNDEFINED:
undefined is a primitive value automatically assigned to variables that have been declared but not initialized.
NULL:
null is also a primitive value, but it is explicitly assigned to a variable to indicate the absence of a value.
