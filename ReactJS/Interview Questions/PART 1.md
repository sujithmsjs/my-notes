React
-----

- React is a front-end and open-source JavaScript library.
- React was created by Jordan Walke and created by Facebook.
- Useful for developing single page UI.
- Follows Component based Approach.
- Declarative Programming.
- React is used to build single-page applications.


Virtual DOM
-----------

- React uses virtual DOM to render the view.
- Virtual DOM is a virtual representation of the real DOM.
- Each time the data changes in a react app, a new virtual DOM gets created.
- Instead of manipulating the browser's DOM directly, React creates a virtual DOM in memory, where it does all the necessary manipulating, before making the changes in the browser DOM.
- React finds out what changes have been made, and changes only what needs to be changed.
- Creating a virtual DOM is much faster than rendering the UI inside the browser.
- Virtual representation of the real DOM.
- Lightweight
- In memory representation
- Reconciliation
- Batching Updates


How does React Work
-------------------

- React creates a VIRTUAL DOM in memory.
- Instead of manipulating the browser's DOM directly, React creates a virtual DOM in memory, where it does all the necessary manipulating, before making the changes in the browser DOM.
- React only changes what needs to be changed!
- React finds out what changes have been made, and changes only what needs to be changed.

Advantages of using React
-------------------------

- Component-Based Architecture
- Reusable components
- Virtual DOM
- Unidirectional Data Flow
- Gentle learning curve
- JSX
- Hooks
- Community Echosystem
- Server-Side Rendering
- Virtual DOM
- Unidirectional data binding
- Reusable or composable UI components
- Gentle learning curve
- SEO Friendly
- Huge Ecosystem


Unidirectional Data flow
------------------------


- Data flows in a single direction through a hierarchy of components.
- This predictable data flow makes it easier to understand how changes to data affect the UI and helps prevent bugs related to data synchronization.


Limitations of React
--------------------

- React is just a view library, not a full framework.
- There is a learning curve for beginners who are new to web development.
- Integrating React into a traditional MVC framework requires some additional configuration.
- The code complexity increases with inline templating and JSX.
- Too many smaller components leading to over engineering or boilerplate.

useState() in React
-------------------

useState()
- Built-In React Hook
- Allows to have a state variable in functional components.
- It should be used when the DOM has something that is dynamically manipulating/controlling.
- State in React is a built-in object that stores data that can change over time and affect a component's rendering.
- You can use the `useState` hook to manage state in functional components.


keys in React
-------------

**A key is a special string attribute that needs to be included when using lists of elements.**

- Avoid using array index as the key.
- Each item should have unique key.
- Keys help react identify which elements were added, changed or removed.
- Keys should be given to array elements for providing a unique identity for each element.
- Without keys, React does not understand the order or uniqueness of each element.
- With keys, React has an idea of which particular element was deleted, edited, and added.
- Keys are generally used for displaying a list of data coming from an API.

- Efficient Updates and Reconciliation
- Stable Identity
- Optimizing Animations and Transitions
- State Preservation
- Avoiding Duplicate Key Warnings
- Enhancing Predictability and Debugging


JSX
----

- JavaScript XML
- JSX is a syntax extension for JavaScript.
- It allows developers to write HTML-like code directly within their JavaScript files.
- It allows us to write HTML inside JavaScript and place them in the DOM without using functions like appendChild( ) or createElement( ).
- JSX provides syntactic sugar for React.createElement( ) function.
- We can create react applications without using JSX as well.

Attribute in JSX:
The class attribute is a much used attribute in HTML, but since JSX is rendered as JavaScript, and the class keyword is a reserved word in JavaScript, you are not allowed to use it in JSX.
Use attribute className instead. JSX solved this by using className instead. When JSX is rendered, it translates className attributes into class attributes.
- class -> className
- for 	-> htmlFor



### 7. What are the differences between functional and class components?
### 8. What is the virtual DOM? How does react use the virtual DOM to render the UI?


Controlled and Uncontrolled components
--------------------------------------

Controlled component:
- In a controlled component, the value of the input element is controlled by React.
- We store the state of the input element inside the code, and by using event-based callbacks, any changes made to the input element will be reflected in the code as well.

Uncontrolled component:
- In an uncontrolled component, the value of the input element is handled by the DOM itself.
- Input elements inside uncontrolled components work just like normal HTML input form elements.



Props
-----

- Props are arguments passed into React components.
- React Props are like function arguments in JavaScript and attributes in HTML.
- Props are passed to  React components via HTML attributes.
- Props are also how you pass data from one component to another, as parameters.
- Components can be passed as props, which stands for properties.
- Props are like function arguments, and you send them into the component as attributes.
- If you have a variable to send, and not a string, you just put the variable name inside curly brackets.
- React Props are read-only! You will get an error if you try to change their value.
- In React, you should not directly modify the props passed to a component.
- Props are intended to be read-only and should not be mutated inside the component.

React Events
------------

- Just like HTML DOM events, React can perform actions based on user events.
- React has the same events as HTML: click, change, mouseover etc.
- React events are written in camelCase syntax.
- React event handlers are written inside curly braces.
- To pass an argument to an event handler, use an arrow function.
- Event handlers have access to the React event that triggered the function.

### What is single source of truth?

MEMO
----
Using memo will cause React to skip rendering a component if its props have not changed. This can improve performance.

- The CHILD component re-renders even when the props have not changed.
- If this component was complex, it could cause performance issues.
- To fix this, we can use memo.
- Use memo to keep the Todos component from needlessly re-rendering.
- Wrap the Todos component export in memo:
- Now the Todos component only re-renders when the todos that are passed to it through props are updated.

export default memo(Todos);


### What is Server-Side Rendering (SSR)

### Static Site Generation (SSG)

### What is SEO-friendly web applications

- Libraries like Next.js and Gatsby provide solutions for implementing SSR and SSG with React.


Batching in React
-----------------

- React uses it to process multiple state updates.
- Apply several updates to the same state variable in a row.
- React waits until all code in the event handlers has run before processing your state updates.

BATCHING lets you update multiple state variables—even from multiple components—without triggering too many re-renders.
But this also means that the UI won’t be updated until after your event handler, and any code in it, completes.
This behavior, also known as batching, makes your React app run much faster.
It also avoids dealing with confusing “half-finished” renders where only some of the variables have been updated.


<button onClick={() => {
  setNumber(number + 5);
  setNumber(n => n + 1);
  setNumber(42);
}}>

Setting state does not change the variable in the existing render, but it requests a new render.
React processes state updates after event handlers have finished running. This is called batching.
To update some state multiple times in one event, you can use setNumber(n => n + 1) updater function.


State as a Snapshot
-------------------


- State variables might look like regular JavaScript variables that you can read and write to. However, state behaves more like a snapshot.
- Setting it does not change the state variable you already have, but instead triggers a re-render.

- State behaves more like a snapshot
- Setting it does not change the state variable you already have, but instead triggers a re-render.
- Directly doesn't change the value instead it will re-render.
- “Rendering” means that React is calling your component, which is a function.
- The JSX you return from that function is like a snapshot of the UI in time. 

React Components
-----------------

- Components are like functions that return HTML elements.
- Components are independent and reusable bits of code.
- They serve the same purpose as JavaScript functions, but work in isolation and return HTML.
- Components come in two types, Class components and Function components.


Fragments
---------

- Close empty elements with <></>

- One Top Level Element:
The HTML code must be wrapped in ONE top level element.
So if you like to write two paragraphs, you must put them inside a parent element, like a div element.

Portals
--------
<div id="bottom-root"></div>
const topRoot = document.getElementById('bottom-root');
ReactDOM.createPortal(<h1>This is Portal</h1>, topRoot)



Style Modules
--------------
import styles from "./Box.module.css";
<Box className={styles.box} data={data} />


Prop drilling
-------------

FormData
--------

Controlled Form Data
--------------------

If you pass value without onChange, it will be impossible to type into the input. When you control an input by passing some value to it, you force it to always have the value you passed. So if you pass a state variable as a value but forget to update that state variable synchronously during the onChange event handler, React will revert the input after every keystroke back to the value that you specified.

1. defaultValue
2. onChange
3. readOnly

You need to read e.target.checked rather than `e.target.value` for checkboxes.


Renderable Values
-----------------
Below values won't get rendered

- TRUE
- FALSE
- NULL
- UNDEFINED
- EMPTY STRING('')
- EMPTY ARRAY([])
- EMPTY OBJECT({})




### What are webpack, Babel, and ESLint?


### React Render HTML?

React renders HTML to the web page by using a function called createRoot() and its method render().
The render() : method is then called to define the React component that should be rendered.
The createRoot() : function takes one argument, an HTML element. The purpose of the function is to define the HTML element where a React component should be displayed.

### The Root Node?
The root node is the HTML element where you want to display the result.
It is like a container for content managed by React.


### What is the Use the new root API ?

import ReactDOM from 'react-dom/client';
const container = document.getElementById('mydiv');
const root = ReactDOM.createRoot(container);
root.render(<Hello />)

Styling React Using CSS
-----------------------

3 common ways:

1. Inline styling
2. CSS stylesheets
3. CSS Modules

**Inline styling:**

In JSX, JavaScript expressions are written inside curly braces, and since JavaScript objects also use curly braces, the styling in the example above is written inside two sets of curly braces {{}}.


style={{color: "red"}}

camelCased Property Names
Since the inline CSS is written in a JavaScript object, properties with hyphen separators, like background-color, must be written with camel case syntax:


**CSS stylesheets:**



**CSS Modules:**

- Another way of adding styles to your application is to use CSS Modules.
- CSS Modules are convenient for components that are placed in separate files.
- The CSS inside a module is available only for the component that imported it, and you do not have to worry about name conflicts.

Create the CSS module with the .module.css extension, example: my-style.module.css.

import styles from './my-style.module.css'; 
<h1 className={styles.bigblue}>


Sass
----

SCSS (Sassy CSS) is a superset of CSS (Cascading Style Sheets) that adds powerful features and capabilities to the basic CSS language.
It is a CSS preprocessor, which means it extends CSS with additional functionality, making it easier and more efficient to write and maintain styles for web applications.
Sass is a CSS pre-processor.
Sass files are executed on the server and sends CSS to the browser.
Install Sass by running this command in your terminal:

>npm i sass


Controlled v/s Uncontrolled components
----------------------------------------

The issue with the provided code is that the input field is a controlled component, meaning its value is managed by the value state and cannot be changed directly by user input. In a controlled component, the value is only updated through the value prop and the onChange event.

createElement v/s cloneElement
------------------------------

JSX elements will be transpiled to React.createElement() functions to create React elements which are going to be used for the object representation of UI. Whereas cloneElement is used to clone an element and pass it new props.

Higher-Order Components
-----------------------

- Higher-Order Components (HOCs) are a powerful and flexible pattern in React that allows you to reuse component logic.

- A Higher-Order Component is a function that takes a component and returns a new component with additional props or behavior.

- HOCs are commonly used for cross-cutting concerns, such as authentication, logging, or data fetching, that need to be applied to multiple components.


HOCs Work
---------

Accepts a Component:
- A HOC is a function that takes a component as its argument.
- Inside the HOC, a new component is created or the existing one is modified.
- Additional props, state, or behavior are added to the component.
- The HOC returns a new component that now possesses the enhanced features.

HOC can be used for many use cases:
1.	Code reuse, logic and bootstrap abstraction.
2.	Render hijacking.
3.	State abstraction and manipulation.
4. Props manipulation.

memo
----

It provides a higher order component which memoizes component unless the props change. To use it, simply
wrap the component using React.memo before you use it.


Lifting State Up v/s Passing state down
---------------------------------------

Lifting state up:
- It involves moving the state from a lower-level component to a common ancestor or a higher-level component in the component tree.
- It's often used when multiple components need to share the same state, or when a child component needs to update the state of its parent or a sibling component.

Passing state down:
- It involves keeping the state within a component and passing it down to its child components as props.
- It's suitable when the state is only relevant to a specific subtree of the component tree and doesn't need to be shared with other parts of the application.


Children prop
-------------

Reconciliation
--------------

When a component's props or state change, React decides whether an actual DOM
update is necessary by comparing the newly returned element with the previously
rendered one. When they are not equal, React will update the DOM. This process is
called reconciliation.

Babel Transpiler
----------------

Stateless v/s Stateless Functional Components
-----------------------------------------------

- Stateless functional components, often referred to as "functional components" or "presentational components," are defined as JavaScript functions.
- They don't manage any internal state or have lifecycle methods.
- They receive data and callbacks via props and return JSX to be rendered.
- Functional components are primarily concerned with rendering UI based on the provided props.
- With the introduction of React Hooks, functional components can now manage state and have lifecycle-like features.
- The most commonly used hook for managing state in functional components is the useState hook.




Hook Rules
-----------
Call useState at the top level of your component to declare a state variable.


useState
--------

- useState is a React Hook that lets you add a state variable to your component.

const [state, setState] = useState(initialState)
const initializer = () => {};
const [state, setState] = useState(initializer)

useReducer
----------

- useReducer is a React Hook that lets you add a reducer to your component.

const [state, dispatch] = useReducer(reducer, initialArg, initializer?)

Parameters:


reducer:
- The reducer function that specifies how the state gets updated.
- It must be pure, should take the state and action as arguments, and should return the next state.
- State and action can be of any types.

Ex:
function reducer(state, action) {
	// state : previous state
}

initialArg:
- The value from which the initial state is calculated. 
- It can be a value of any type.

optional initializer:
The initializer function that should return the initial state.
const initialState = initializer ?  initializer(initialArg) : initialArg;

Ex:
function TodoList({ username }) {
  // Wrong: Recreating the initial state
  const [state, dispatch] = useReducer(reducer, createInitialState(username));
  
  // Avoiding recreating the initial state
  const [state, dispatch] = useReducer(reducer, username, createInitialState);
}

Dispatch function:
- It lets you update the state to a different value and trigger a re-render.
- You need to pass the action as the only argument to the dispatch function.
- dispatch functions do not have a return value.

Syntax:
dispatch(action)

action:
- The action performed by the user.
- It can be a value of any type.
- Actions can have any shape.
- By convention, it’s common to pass objects with a type property identifying the action.
- It should include the minimal necessary information that the reducer needs to compute the next state.

dispatch({ type: 'incremented_age' })



useRef
------

useRef is a React Hook that lets you reference a value that’s not needed for rendering.

const ref = useRef(initialValue)

initialValue:
The value you want the ref object’s current property to be initially.
It can be a value of any type.
This argument is ignored after the initial render.
It an object with a single property

- You can mutate the ref.current property unless it hold rendering object.
- Changing a ref.current does not trigger a re-render. 
- You can store information between re-renders.
- Do not write or read ref.current during rendering, except for initialization.
- This means refs are perfect for storing information that doesn’t affect the visual output of your component.
- useRef returns an object with a single property: current

<div ref={myRef}>

- Refs are an escape hatch to hold onto values that aren’t used for rendering. You won’t need them often.
- A ref is a plain JavaScript object with a single property called current, which you can read or set.
- You can ask React to give you a ref by calling the useRef Hook.
- Like state, refs let you retain information between re-renders of a component.
- Unlike state, setting the ref’s current value does not trigger a re-render.
- Don’t read or write ref.current during rendering. This makes your component hard to predict.


useId
-----
- useId is a React Hook for generating unique IDs that can be passed to accessibility attributes.
- It returns a unique ID string associated with this particular useId call in this particular component.
- Do not call useId to generate keys in a list.
- Hardcoding IDs is not a good practice in React. 

const passwordHintId = useId();
 
<p id={passwordHintId}>
	The password should contain at least 18 characters
/p>


useEffect
---------
- useEffect is a React Hook that lets you synchronize a component with an external system.

useEffect(setup, dependencies?) 

setup: The function with your Effect’s logic. Your setup function may also optionally return a cleanup function.
dependencies: The list of all reactive values referenced inside of the setup code.

External system : 
Some components need to stay connected to the network, some browser API, or a third-party library, while they are displayed on the page.
These systems aren’t controlled by React, so they are called external.


- If you’re not trying to synchronize with some external system, you probably don’t need an Effect.

- Used for handling side effects in functional components.
- Side effects can include data fetching, subscriptions, or manually interacting with the DOM.
- It allows you to perform certain actions after the component has rendered or after a specific prop or state has changed.

- To perform side effects
- Ex: fetching data, directly updating the DOM, and timers.
- Syntax: useEffect(<function>, <dependency>)
- Even if your Effect was caused by an interaction (like a click), the browser may repaint the screen before processing the state updates inside your Effect. Usually, that’s what you want. However, if you must block the browser from repainting the screen, you need to replace useEffect with useLayoutEffect.


Three types of useages:
1. No dependency passed
2. An empty array
3. With dependencies(Props or state values)


Accidental Impurities
---------------------

If the inputs (props, state, and context) are the same, it should return exactly the same JSX. Reading or writing a ref during rendering breaks these expectations.


Pure Component
---------------
-> A component must be pure.
1. It minds its own business.
2. Same inputs, same output.


useMemo
-------

- useMemo is a React Hook that lets you cache the result of a calculation between re-renders.

User for:
- Skipping expensive recalculations
- Skipping re-rendering of components
- Memoizing a dependency of another Hook
- Memoizing a function

Syntax:
const cachedValue = useMemo(calculateValue, dependencies)

calculateValue:
- The function calculating the value that you want to cache.
- It should be pure, should take no arguments, and should return a value of any type.
- React will return the same value again if the dependencies have not changed since the last render. 
- Otherwise, it will call calculateValue, return its result, and store it so it can be reused later.

```js
const visibleTodos = useMemo(
    () => filterTodos(todos, tab),
    [todos, tab]
);
```

- React will compare each dependency with its previous value using the Object.is comparison.
- During next renders, it will either return an already stored value from the last render (if the dependencies haven’t changed), or call calculateValue again, and return the result that calculateValue has returned.

useCallback
-----------

- useCallback is a React Hook that lets you cache a function definition between re-renders.

Syntax:
const cachedFn = useCallback(fn, dependencies)


- The function value that you want to cache.
- It can take any arguments and return any values.
- React will return (not call!) your function back to you during the initial render.
- During subsequent renders, it will either return an already stored fn  function from the last render (if the dependencies haven’t changed), or return the fn function you have passed during this render.



useCallback v/s useMemo
-----------------------

### Key Differences:

1. **Use Case:**
   - Use `useMemo` when you want to memoize a value (e.g., the result of a computation).
   - Use `useCallback` when you want to memoize a function.

2. **Arguments:**
   - `useMemo` takes a function and an array of dependencies. It memoizes the result of the function based on changes in dependencies.
   - `useCallback` takes a function and an array of dependencies. It memoizes the function itself based on changes in dependencies.

3. **Return Value:**
   - `useMemo` returns the memoized value.
   - `useCallback` returns the memoized function.

While `useMemo` and `useCallback` share similarities, choosing between them depends on whether you are memoizing a value or a function. Use them judiciously to optimize your components when needed.




memo
----
- memo lets you skip re-rendering a component when its props are unchanged.
- Wrap a component in memo to get a memoized version of that component.
- memoization is a performance optimization.
- This memoized version of your component will usually not be re-rendered when its parent component is re-rendered as long as its props have not changed.
- Memoization only has to do with props that are passed to the component from its parent.
- By default, React will compare each prop with Object.is
- Even when a component is memoized, it will still re-render when its own state changes or when a context that it’s using changes.

Syntax:
const MemoizedComponent = memo(SomeComponent, arePropsEqual?)

const arePropsEqual = (oldProps, newProps) => {
	return oldProps === newProps;
}

- Usually, you will not specify arePropsEqual function. By default, React will compare each prop with Object.is.


A React component should always have pure rendering logic. This means that it must return the same output if its props, state, and context haven’t changed.


lazy
----


How to re-render the view when the browser is resized
-----------------------------------------------------

const MyComponent = () => {

  useEffect(() => {
    const handleResize = () => {
      // window.innerHeight
	  // window.innerWidth
    };

    window.addEventListener('resize', handleResize);
	
    return () => {
      window.removeEventListener('resize', handleResize);
    };
  }, []);

  return ...;
};


How to pass data between sibling components using React router
--------------------------------------------------------------


Automatic redirect after login
------------------------------
const navigation = useNavigation();
navigation('/home');



Hooks Rules:
------------

- React Hooks must be called only at the top level.
- It is not allowed to call them inside the nested functions, loops, or conditions.
- It is allowed to call the Hooks only from the React Function Components.


Side Effects
------------
Side effects in React refer to any operations or interactions that occur within a component that are not related to rendering the user interface.
These can include data fetching, subscriptions, manual DOM manipulation, and other operations that affect the external world.

Examples of Side Effects:
- Data fetching from APIs
- Subscription to external data sources
- Manual DOM manipulation
- Setting up and cleaning up timers
