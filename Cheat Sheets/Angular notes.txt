## Environment Setup

Nodejs cmd> node -v 
Npm cmd>npm -v
Angular CLI cmd>ng version
IDE for writing your code

### Create new project

cmd> ng new my-dream-app // name of the project
cmd> cd my-dream-app
cmd> ng serve


### Fonder structure

1. e2e/ − end to end test folder.
2. node_modules/ The npm package installed is node_modules.
3. src/

### Files

4. angular.json − It basically holds the project name, version of cli, etc.
5. .editorconfig − This is the config file for the editor.
6. .gitignore − A .gitignore file should be committed into the repository, in order to share the ignore rules with any other users that clone the repository.
7. package.json − The package.json file tells which libraries will be installed into node_modules when you run npm install.

npm: Node Package Manager
Why ng? Because HTML has Angular brackets and "ng" sounds like "Angular".

---

Component
------------------
html
css
ts
spec.ts


Module
-----------
app-routing.module.ts
app.module.ts

app.component.ts
app.component.css
app.component.html
app.component.spec.ts


@NgModule({
  declarations: [],
  imports: [],
  providers: [],
  bootstrap: []
})
export class AppModule { }


export interface Itest
{
 exampleValue?: string; // optional
 neededValue: string; // non-optional
}

https://stackoverflow.com/questions/54815790/what-is-the-exact-difference-between-and-operators-in-angular



export class User {
    id!: string; // null/undefined
    title!: string; 
    firstName!: string;
    lastName!: string;
    email!: string;
    role!: Role;
    isDeleting: boolean = false;
}

let users: any[] = usersJSON ? JSON.parse(usersJSON) : [{
    id: 1,
    title: 'Mr',
    firstName: 'Joe',
    lastName: 'Bloggs',
    email: 'joe@bloggs.com',
    role: Role.User,
    password: 'joe123'
}];




export const environment = {
  production: false,
  apiUrl: 'http://localhost:4000'
};

const baseUrl = `${environment.apiUrl}/users`;

https://angular.io/guide/setup-local















ErrorPage("error")
Your error is: {{errorMsg}}
errorMsg = ''


<button routerLink="error">Show Error</button>

Data binding :communication between a component and the DOM. between your typescript code of your component and your template which user sees.

Data binding
1. One-way databinding: HTML template is changed when we make changes in TypeScript code. You can't update Model from the View.

Examples:
- Angular Interpolation
- String Interpolation
- Property Binding
- Event Binding

2. Two-way databinding: Automatic synchronization of data happens between the Model and the View.

---
# Data binding

1. String Interpolation: one-way databinding technique. {{ data }}

2. Property Binding: one-way data binding : In property binding, we bind a property of a DOM element to a field which is a defined property in our component TypeScript code.
<img [src]="imgUrl"/>
<input type="email" [value]="user.email">  

3. Event Binding: used to handle the events raised from the DOM
<button (click)="cookBacon()"></button>


4. Two-way binding: The two-way binding has a feature to update data from component to view and vice-versa. In two way data binding, property binding and event binding are combined together.
[(ngModel)] = "[property of your component]"

---

TypeScript - Variable

Variables can be declared using: var, let, and const

1. var
2. let
3. const

To solve problems with var declarations, ES6 introduced two new types of variable declarations in JavaScript, using the keywords let and const.



let employeeName = "John";
let employeeName:string = "John";

Note: Unlike variables declared with var, variables declared with let have a block-scope. 

Advantages of using let over var
1. Block-scoped let variables cannot be read or written to before they are declared.
2.  Let variables cannot be re-declared
3. Same Variable Name in Different Blocks

```code
let num:number = 1; 

function demo() {
    let num:number = 2;

    if(true) { 
        let num:number = 3;
        console.log(num); //Output: 3
    }

    console.log(num);//Output: 2
}
console.log(num); //Output: 1
demo();
```

Variables declared using let minimize the possibilities of runtime errors, as the compiler give compile-time errors.
This increases the code readability and maintainability.

CONST:
- A class member cannot have the 'const' keyword.
- Const variables have the same scoping rules as let variables.
- Const declaration must be initialized

const num:number = 100;

Note: Const variables allow an object sub-properties to be changed but not the object structure.

1. Object structure Protection Provided through CONST
2. It can provide Single Property change at a time, not able to change whole object.


--- 

### String

Template String: Template strings are used to embed expressions into strings.

// Pre-ES6 
let employeeDesc1: string = employeeName + " works in the " + employeeDept + " department.";

// Post-ES6 
let employeeDesc2: string = `${employeeName} works in the ${employeeDept} department.`;

---

### Boolean 

The upper case Boolean is an object type whereas lower case boolean is a primitive type.
It is recommended to use the primitive type boolean


---

### Arrays

let fruits: string[] = ['Apple', 'Orange', 'Banana'];
let fruits: Array<string> = ['Apple', 'Orange', 'Banana'];


let fruits: Array<string>;
fruits = ['Apple', 'Orange', 'Banana']; 

let ids: Array<number>;
ids = [23, 34, 100, 124, 44]; 

let values: (string | number)[] = ['Apple', 2, 'Orange', 3, 4, 'Banana']; 
// or 
let values: Array<string | number> = ['Apple', 2, 'Orange', 3, 4, 'Banana']; 


let fruits: string[] = ['Apple', 'Orange', 'Banana']; 
fruits[0]; // returns Apple
fruits[1]; // returns Orange
fruits[2]; // returns Banana
fruits[3]; // returns undefined


let fruits: string[] = ['Apple', 'Orange', 'Banana']; 




For Loop Type : 1
-----------------
for(var i = 0; i < fruits.length; i++)
{ 
    console.log(fruits[i]); // output: Apple Orange Banana
}

For Loop Type : 2(For-IN)
-----------------
for(var index in fruits)
{ 
    console.log(fruits[index]);  // output: Apple Orange Banana
}

For Loop Type : 3(For-OF)
-----------------
for(var index in fruits)
{ 
    console.log(fruits[index]);  // output: Apple Orange Banana
}


Array Methods
---------------
pop, push, sort, concat, indexOf

---

Tuples
- TypeScript introduced a new data type called Tuple.
-   Tuple can contain two values of different data types.

var empId: number = 1;
var empName: string = "Steve";        

// Tuple type variable 
var employee: [number, string] = [1, "Steve"];


var employee: [number, string] = [1, "Steve"];
var person: [number, string, boolean] = [1, "Steve", true];

var user: [number, string, boolean, number, string];// declare tuple variable
user = [1, "Steve", true, 20, "Admin"];// initialize tuple variable

Tuple Array
-----------
var employee: [number, string][];
employee = [[1, "Steve"], [2, "Bill"], [3, "Jeff"]];


[Union](https://www.tutorialsteacher.com/typescript/typescript-union)
------
let code: (string | number);
code = 123;   // OK
code = "ABC"; // OK

let empId: string | number;
empId = 111; // OK
empId = "E111"; // OK

Example: Function Parameter as Union Type

function displayType(code: (string | number))
{
    if(typeof(code) === "number")
        console.log('Code is number.')
    else if(typeof(code) === "string")
        console.log('Code is string.')
}

displayType(123); // Output: Code is number.
displayType("ABC"); // Output: Code is string.
displayType(true); //Compiler Error: Argument of type 'true' is not assignable to a parameter of type string | number


Ternary operator
---------------
Boolean expression? First statement : second statement



https://www.tutorialsteacher.com/typescript/typescript-function
https://stackoverflow.com/questions/1783405/how-do-i-check-out-a-remote-git-branch


---
Error:
<input type="text" class="form-control" ngModel placeholder="Last Name" min="4" max="15" required>

If ngModel is used within a form tag, either the name attribute must be set or the form
    control must be defined as 'standalone' in ngModelOptions.

---

-> maxLength in text, will restrict the length.

- Pristine
- Invalid
- Touched

NgForm/FormGroup/FormControl/properties
myForm.control.


Template Driven forms:

- Simple basic forms
- Easy to starts with
- Based on template HTML
- Using built in directives

STEP #1

Import FormsModule inside src\app\app.module.ts from @angular/forms package.
Without FormsModule it is not work.



 imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ]

STEP #2

<form (ngSubmit)="onSubmit(myform)" #myform="ngForm">

</form>

#myform : It's called 'Local Reference Variable' It creates NgForm object for the whole form.

#myform="ngForm"
ngForm is an directive. It has to be initialize with Local reference variable. If not, it will assign HTML DOM to the 'myForm' variable. If if init with 'ngForm' it will return as a Typescript object.

 (ngSubmit): is an event. Whenever submit button get pressend, ngSubmit event will be raised.

One method has to be binding to event, it will be called as Event Binding. Whenever event happens, binded method will be called.

STEP #3

Name and NgModel:

The use of name attributes for validation and form-element change tracking

Make sure every element contains name attribute, using name attribute Angular will bind the data.

Every input element must have 'ngModel' attribute.

Why each element must  have NgModel attribute?
It is an indication to the Angular that this element can be controller of the form. If there's no NgModel attribute, Angular won't consider that element as Controller.

---

Form contains FormGroups, FormGroups contains FormControllers.
Each an every HTML control even will be called FormControl. A group of FormControls can be FormGroup.
Multiple FormGroup embraced in Form.

<form #myform="ngForm">
	<div #nameGrp="ngModelGroup" ngModelGroup="name">
		<input #fname="ngModel">
		<input #lname="ngModel">
	<div>
	<input #email="ngModel">
</form>


Diff b/w #myform and #myform="ngForm"?

<form (ngSubmit)="onSubmit(myform)" #myform/> It will return HTML DOM. You can capture this variable using 'HTMLFormElement'

<form (ngSubmit)="onSubmit(myform)" #myform="ngForm"/> It will return typescript object as 'NgForm'



ngModelGroup:
- We can use validations on the entire group.
- We can use CSS on the entire group elements.
- We can also create Local Reference Variables.

Track control states:
---------------------
Adding the NgModel directive to a control adds class names to the control that describe its state. These classes can be used to change a control's style based on its state.

You use these CSS classes to define the styles for your control based on its status.

Accessing Boolean Data:
myform.valid
myform.touched
myform.dirty
myform.untouched
myform.pristine
myform.invalid

pristine: in its original condition; unspoilt. clean and fresh as if new; spotless.

Accessing Value Data:
myform.value.email

nameGrp.valid
nameGrp.touched
nameGrp.dirty

fname.valid
fname.touched
fname.dirty

Bootstrap Validations:
If an form input event contains 'is-valid' class, it  will be marked with valid mark. If else it has 'is-invalied' class, it will be displayed as invalied details.

How to add class dynamically?

[ngClass]="{'is-invalid' : !fname.valid,'is-valid' : fname.valid }"


@ViewChild
-------------

```html
<form (ngSubmit)="onSubmit()" #myfrom="ngForm">
```

```typescript

@ViewChild('myfrom')
form : NgForm

```



Validation
----------

[disabled]="myform.invalid" if you use this property binding, it will included in that tag it the provided value is true.

Note: You must use KNOWN property before binding. If unknown propery placed, it will give error as
Can't bind to 'random' since it isn't a known property of 'input'.

<input type="submit" class="btn btn-primary" disabled>

CODE SINPPETS

(click)="newHero(); heroForm.reset()"

Template reference variable: #myform

Use the template reference variable, #heroForm to access the form that contains the Submit button and create an event binding.


<form (ngSubmit)="onSubmit()" #heroForm="ngForm">

<button type="submit" class="btn btn-success" [disabled]="!heroForm.form.valid">Submit</button>


 [disabled]="myform.invalid"

Hiding entire div
-----------------

<div [hidden]="submitted">
</div>


<div [hidden]="power.valid || power.pristine">
</div>

[(ngModel)]="model.alterEgo"

(click)="newHero(); heroForm.reset()"



https://www.freecodecamp.org/news/how-to-validate-angular-template-driven-forms/


ng new angular-forms-validation --routing=false --style=scss

To Install BootStrap
npm install bootstrap --save



---
A function that receives a control and synchronously returns a map of validation errors if present, otherwise null.

export declare type ValidationErrors = {
    [key: string]: any;
};




---
https://angular.io/guide/user-input

<button type="button" (click)="onClickMe()">Click me!</button>

(click) -  Target of the binding. 
"onClickMe()"  - template statement.



Get user input from the $event object:

```html
<i/p (keyup)="onKey($event)">
<p>{{values}}</p>
```
```typescript
export class KeyUpComponent_v1 {
  values = '';

  onKey(event: any) { // without type info
    this.values += event.target.value + ' | ';
  }
}
```

Passing $event is a dubious practice
Dubious: hesitating or doubting.


---
<input #box (keyup)="onKey(box.value)">
<p>{{values}}</p>

export class KeyUpComponent_v2 {
  values = '';
  onKey(value: string) {
    this.values += value + ' | ';
  }
}



---
Using NgStyle

[ngStyle]="{border: '5px solid ' + value}" 
[ngStyle]="{color: value}

---

Signup form with [(ngModel)]

// Model
export class Emp {
  public name!: string
  public job !: string
  public hiredate !: Date
  public sal !: number
}

export class CreateEmpComponent {

	public employee: Emp = new Emp;

}
 <form (ngSubmit)="createEmployee()">
	<input [(ngModel)]="employee.name"></input>
	<input [(ngModel)]="employee.job"></input>
	<input [(ngModel)]="employee.hiredate"></input>
	<input [(ngModel)]="employee.sal"></input>
	<button type="submit" class="btn btn-primary">Save</button>
</form>


---
# Router

import { Router } from '@angular/router';

private router : Router

this.router.navigate(['emps'])


---

# [(ngModel)] v/s [ngModel]



---

ActivatedRoute vs Router


ActivatedRoute : It is used to extract @PathVariable from the current URL.

let id = this.activatedRoute.snapshot.params['id']


Observable<string>

---

Session Storage

declare var sessionStorage: Storage;


interface Storage {
	readonly length: number;
	clear(): void;
	 getItem(key: string): string | null;
	key(index: number): string | null;
	removeItem(key: string): void;
	setItem(key: string, value: string): void;
	[name: string]: any;
}


---

CRUD Operations

this.http.get(`https://api.countrystatecity.in/v1/countries/${countryCode}/states/${stateCode}/cities`,{ headers : this.headers});

headers = new HttpHeaders().set('X-CSCAPI-KEY','Q2c0YWZhVVQ5c1pHZVNCeGh6eTZpVm1SWGtna1J2QXFGSFJ1MHBYUA==')


---

Syntax structure

constructor( headers?: string | {
        [name: string]: string | string[ ];
});

---

Class v/s Declare class

---

TypeScript Tuples
A tuple is a typed array with a pre-defined length and types for each index.


// define our tuple
let ourTuple: [number, boolean, string];

// initialize correctly
ourTuple = [5, false, 'Coding God was here'];

Named Tuples:
const graph: [x: number, y: number] = [55.2, 41.3];


 post<T>(url: string, body: any | null, options?: {
        headers?: HttpHeaders | {
            [header: string]: string | string[];
        };
        context?: HttpContext;
        observe?: 'body';
        params?: HttpParams | {
            [param: string]: string | number | boolean | ReadonlyArray<string | number | boolean>;
        };
        reportProgress?: boolean;
        responseType?: 'json'; 
        withCredentials?: boolean;
    }): Observable<T>;


post<any>('my-url')
post<any>('my-url',null)
post<any>('my-url',{...}, { headers : {'Auth' : 'SecretKey'} })


declare class : abstract class in Java

---
Array Methods:


https://blog.canopas.com/typescript-array-methods-and-their-usages-daa8d498b4fd


---

Lifecycle hooks

Lifecycle event sequence

ngOnChanges()
ngOnInit()
ngDoCheck()
ngAfterContentInit()
ngAfterContentChecked()
ngAfterViewInit()
ngAfterViewChecked()
ngOnDestroy()


Name: Sujith Manchala
Designation: Software Engineer java
Product Name: ODESK-ADMIN
Today's accomplishments:  Worked on Redis Cache and JWT Token implementation
Plan for tomorrow : Will   work on the new Sprint.

====

controls
validatorOrOpts
asyncValidator

new FormGroup(controls: TControl, validatorOrOpts?: ValidatorFn | ValidatorFn[] | AbstractControlOptions | null, asyncValidator?: AsyncValidatorFn | AsyncValidatorFn[] | null)

refreshToken


---

*ngFor="let item of orderForm.get('items').controls; let i = index;"

*ngFor="let s of profileForm.get('skills')['controls']; let i = index;"

Name: Sujith Manchala
Designation: Software Engineer java
Product Name: ODESK-ADMIN
Today's accomplishments: Analyzed the implementation  of new Sprint(Redis Token, Roster Mgnt)
Plan for tomorrow : Need to work on assigned tasks




























































































