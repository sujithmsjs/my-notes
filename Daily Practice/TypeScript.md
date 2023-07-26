TypeScript
-----------
```sh
node -v
node --version
node

npm install -g typescript
npm install typescript --save-dev
tsc example.ts
node example.js
```


# TypeScript

> TypeScript is a `syntactic superset` of JavaScript which adds static typing.

**Syntactic Superset** means that it shares the same base syntax as JavaScript, but adds something to it.

**Java Script**
- Loosely typed language


**Installing the Compiler**

npm install typescript --save-dev
npx tsc
npx tsc --init

### TypeScript Simple Types
boolean, number, string, bigint, symbol

### Type Assignment
1. Explicit
let firstName: string = "Dylan";

2. Implicit
let firstName = "Dylan";

**Note: Having TypeScript "guess" the type of a value is called infer.**

```javascript
let firstName: string = "Dylan";
<var-name> <var-type> = <value>;
```

### Unable to Infer:
```javascript
const json = JSON.parse("55");
console.log(typeof json);
```

### TypeScript Special Types:
any, unknown, never, undefined, null

- ANY (Disables type checking)
- UNKNOWN (Prevent unknown types)
- NEVER ( Effectively throws an error whenever it is defined.)
- UNDEFINED
- NULL

any is a type that disables type checking and effectively allows all types to be used.



### TypeScript Arrays
```javascript
const names: string[] = [];
names.push("Dylan");
```
### Readonly Array
```javascript
const names: readonly string[] = ["Dylan"];
names.push("Jack"); // Error
```
### Type Inference of an Array
```javascript
const numbers = [1, 2, 3]; // inferred to type number[]
numbers.push(4); // No error
numbers.push("2"); // Error
let head: number = numbers[0]; // No error
```
### TypeScript Tuples

**Typed Arrays**
- Pre-defined length
- Pre-defined types
- Order of elements matters
- Type of elements matter


Ex:
```javascript
// define our tuple
let ourTuple: [number, boolean, string];

// initialize correctly
ourTuple = [5, false, 'Coding God was here'];
```
**Readonly Tuple**

```javascript
const ourReadonlyTuple: readonly [number, boolean, string] = [5, true, 'The Real Coding God'];
ourReadonlyTuple.push('Coding God took a day off'); // Error!
```

**Named Tuples**
```javascript
const graph: [x: number, y: number] = [55.2, 41.3];
```
**Destructuring Tuples**
```javascript
const graph: [number, number] = [55.2, 41.3];
const [x, y] = graph;
```

### Object Types
```javascript
const <obj-name> : {<name>:<type>, <name>:<type>, <name>:<type>,...}

const car: { type: string, model: string, year: number } = {
  type: "Toyota",
  model: "Corolla",
  year: 2009
};
```
Ex 01

```ts
const emp : {name : string, age : number} = {
    name : 'Sujith',
    age : 28,
    salary : 1e5 // Error! 'salary' does not exist in type
}
console.info('Hello');
```
**Type Inference**
```ts
Use delete operator only on optional properties other wise includes an optional property.

const emp : {name : string, age : number, dept ?: string} = {
    name : 'Sujith',
    age : 28,
    dept : 'CSE'
    salary : 1e5 	// Error! 'salary' does not exist in type
}

emp.name = 50; 		// Error! Type Inference
emp.name = 'Sujith';	// Ok
emp.salary = 1_00_000; 	// Error! Can't add new property
delete emp.name; 	// Delete works with warning.
emp.name = undefined;	// Ok! Lint Error!
delete emp.dept; 	// delete works without warning.

console.info(emp);
```

**Optional Properties**

```ts
// Error Property 'age' is missing
const emp: { name: string, age: number, dept: string } = {
    name: 'Sujith',
    dept: 'CSE'
}

// No Error
const emp: { name: string, age?: number, dept: string } = {
    name: 'Sujith',
    dept: 'CSE'
}
```

**Index Signatures**
```ts
const nameAgeMap: { [index: string]: number } = {};
nameAgeMap.Jack = 25; // no error
nameAgeMap.Sujith = 27; // no error
nameAgeMap.Bolenath = 33;
nameAgeMap.Mark = "Fifty"; // Error: Type 'string' is not assignable to type 'number'.

console.info(nameAgeMap);console.log(p.name);  
```

## TypeScript Enums

```ts
enum Direction {
    Up,
    Down,
    Left,
    Right
  }
  
  function move(direction: Direction) {
    switch (direction) {
      case Direction.Up:
        console.log("Moving up");
        break;
      case Direction.Down:
        console.log("Moving down");
        break;
      case Direction.Left:
        console.log("Moving left");
        break;
      case Direction.Right:
        console.log("Moving right");
        break;
      default:
        console.log("Invalid direction");
        break;
    }
  }
  
  move(Direction.Up);
  move(Direction.Right);
  move(Direction.Down);
  move(Direction.Left);
  move(5); // Invalid direction
```


## Type Aliases (Custom name)

```ts
type CarYear = number
type CarType = string
type CarModel = string
type Car = {
  year: CarYear,
  type: CarType,
  model: CarModel
}

const carYear: CarYear = 2001
const carType: CarType = "Toyota"
const carModel: CarModel = "Corolla"
const car: Car = {
  year: carYear,
  type: carType,
  model: carModel
};
```

## Interfaces

>Interfaces are similar to type aliases, except they only apply to object types.

```ts
interface Rectangle {
  height: number,
  width: number
}

const rectangle: Rectangle = {
  height: 20,
  width: 10
};
```

**Extending an interface means you are creating a new interface with the same properties as the original, plus something new.**

```ts
interface Rectangle {
  height: number,
  width: number
}

interface ColoredRectangle extends Rectangle {
  color: string
}

const coloredRectangle: ColoredRectangle = {
  height: 20,
  width: 10,
  color: "red"
};
```

## Union Types

```ts
let id: string | number;

id = 'Sujith';  // OK
id = 123123;    // Ok
id = false;     // Error!
id = null;      // Error!
console.info(id);
```

## TypeScript Functions

```ts
class Demo {

    // Rest Parameters
    addAll(a: number, b: number, ...rest: number[]) {
        return a + b + rest.reduce((p, c) => p + c, 0);
    }
    
    // Optional Parameters
    addition(a: number, b?: number, c = 1): number {
        return a + b + c;
    }

    // Default Parameters
    multiply(a: number, b: number, c = 1): number {
        return a * b * c;
    }

    // Object types Parameters
    desc(emp: { name: string, salary: number }) {
        console.info(`Hello ${emp.name} and your salary is ${emp.salary}`);
    }

    // Named Parameters
    desc2({name, salary}: { name: string, salary: number }) {
        console.info(`Hello ${name} and your salary is ${salary}`);
    }
}

let d = new Demo();
console.info(d.multiply(10, 20));       // 200
console.info(d.multiply(10, 20, 30));   // 6000
console.info(d.addition(10));           // NaN
console.info(d.addition(10, 20));       // 31
console.info(d.addAll(10, 20, 30, 40, 50));     // 150
//console.info(d.multiply(10, 20, '30'));       // Error!!
d.desc({ name: 'Sujith', salary: 123 });
d.desc2({ name: 'Sujith', salary: 123 }); 
```


## Type Casting 

```ts
let x: unknown = 'hello';
console.log(x.length);	 		// Error!
console.log((x as string).length); 	// Okay
console.log((<string>x).length); 	// Okay
```

## Class Members Visibility

**3 visibility modifiers**
Works same as Java
1. public
2. private
3. protected

```ts
class Person {
    public name: string;
    private age: number;
    protected salary: number;

    constructor(name, age = 18, salary ?: number){
        this.name = name;
        this.age = age;
        this.salary = salary ?? 0;
    }

    public getAge(){
        return this.age;
    }
}

const p = new Person('John');
console.log(p.name);        // John
console.log(p.age);         // Error
console.log(p.salary);  	// Error
console.log(p.getAge());    // 18
console.log(p);             // Person { name: 'John', age: 18 }
```

**Parameter Properties**



```ts
class Person {
  // name is a private member variable
  public constructor(private name: string) {}

  public getName(): string {
    return this.name;
  }
}
```

**Readonly Members**
> members cannot be changed after this initial definition.

```ts

class Person {
    public readonly name: string;
    constructor(name: string) {
        this.name = name; // Okay
    }

    public setName(name: string) {
        this.name = name; // Error
    }
}

const p = new Person('Altman');
//p.name = 'John'; // Error!
console.info(p.name)
```

**This not needed**

```ts
class A {
    constructor(private num: number){ 
    }
    getNum(){
        return this.num;
    }
}
let a = new A(12);
console.info(a.getNum());
```

## Interfaces

```ts
interface Animal {
    getName(): string;
}

interface Cat extends Animal {
    makeNoise(): void;
}

class Kitty implements Cat {

    public constructor(
        protected readonly name: string,
        protected readonly age: number) {
    }
    makeNoise(): void {
        console.info('Meow')
    }
    getName(): string {
        return this.name;
    }
}

const k = new Kitty('Kitty', 2);
k.makeNoise();              // Meow
console.info(k.getName());  // Kitty
console.info(k);            // Kitty { name: 'Kitty', age: 2 }
```

## Utility Types










