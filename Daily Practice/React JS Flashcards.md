React is open-source front-end JavaScript library.
React was created by Jordan Walke.

A feature present in Class comp but on in Fun Comp is Error Boundaries.
How to create components in React	Function and Class Components
JSX gets __________ to a React.createElement()	transpiled
How to create React Element	React.createElement()
What is JSX	JavaScript XML
JSX provides syntactic sugar for _____ 	React.createElement()

Major features of React	VirtualDOM, server-side rendering, Unidirectional,reusable/composable UI components.


Component can be a class with a render() method
JSX gets transpiled to a React.createElement()
From React 16.8 with the addition of Hooks, you could use state , lifecycle methods.

# Pure Component
A React component is considered pure if it renders the same output for the same state and props.

PureComponent is similar to Component but it skips re-renders for same props and state.

class Greeting extends PureComponent {...}
PureComponent is a subclass of Component and supports all the Component APIs. Extending PureComponent is equivalent to defining a custom shouldComponentUpdate method that shallowly compares props and state.

# Transpilation:
Source-to-Source Transformation:

Definition: Transpilation, short for "source-to-source compilation," involves transforming source code from one high-level programming language to another high-level programming language.
Use Case: Commonly used to make code compatible with different environments, versions, or to introduce language features not supported in the target environment.
Example: Transpiling modern JavaScript (ES6+) to older JavaScript (ES5) using tools like Babel.

Intermediate Code: In transpilation, the code is transformed into an equivalent form in another language, often at a similar level of abstraction.
Purpose: The primary goal is typically compatibility, making the code runnable in environments that do not fully support the original language features.
Example Transpilers:

Babel: A popular JavaScript transpiler that converts modern JavaScript code to an older version for broader browser compatibility.


When you convert this component from a class to a function, wrap it in memo:
const Greeting = memo(function Greeting({ name }) {
  console.log("Greeting was rendered at", new Date().toLocaleTimeString());
  return <h3>Hello{name && ', '}{name}!</h3>;
}); 

Note
Unlike PureComponent, memo does not compare the new and the old state. In function components, calling the set function with the same state already prevents re-renders by default, even without memo.


# React features

React is a JavaScript library for building user interfaces, and it comes with several features that contribute to its popularity and effectiveness in developing modern web applications. Here are some key features of React
- Component-Based Architecture
- Virtual DOM
- JSX (JavaScript XML)
- Declarative Syntax
- One-Way Data Binding
- Unidirectional Data Flow
- Lifecycle Methods
- Reusable Components
- React Hooks
- React Router
- Ecosystem and Community

1. **Component-Based Architecture:**
   - React follows a component-based architecture, where UIs are composed of independent and reusable components. Components encapsulate their own state and behavior, making it easier to build and maintain complex applications.

2. **Virtual DOM:**
   - React uses a virtual DOM to optimize rendering performance. Instead of directly manipulating the actual DOM, React creates a lightweight virtual representation of it. This virtual DOM is compared to the real DOM, and only the necessary updates are applied, reducing the number of direct manipulations and improving efficiency.

3. **JSX (JavaScript XML):**
   - JSX is a syntax extension for JavaScript that looks similar to XML or HTML. It allows developers to write UI components using a syntax that closely resembles HTML, making the code more readable and expressive.

# Declarative Syntax vs Imperative
Declarative Syntax:
- React uses a declarative syntax, allowing developers to describe the desired outcome without specifying step-by-step instructions.
- This leads to more predictable and easier-to-understand code.

Imperative Syntax:
- Specifies the step-by-step process of how to achieve a task.
- It is more concerned with the specific instructions or operations.


5. **One-Way Data Binding:**
   - React enforces a one-way data flow, making it clear how data is passed between components. Data flows down the component tree, and changes to the child components do not directly affect their parents.

6. **Unidirectional Data Flow:**
   - React follows a unidirectional data flow, where data is passed down from parent components to child components. This ensures a clear and predictable flow of data, making it easier to debug and understand the application's state.

7. **Lifecycle Methods:**
   - React components have lifecycle methods that allow developers to define behavior at different stages of a component's life, such as mounting, updating, and unmounting. This enables developers to manage side effects, perform asynchronous operations, and optimize performance.

8. **Reusable Components:**
   - React's component-based architecture promotes reusability. Components can be reused across different parts of an application or even in different projects, enhancing code modularity.


10. **React Router:**
    - React Router is a library for handling navigation in React applications. It enables the creation of single-page applications with dynamic and declarative routing.

11. **Ecosystem and Community:**
    - React has a large and active community, which has led to the creation of a rich ecosystem of libraries, tools, and resources. This includes state management libraries (e.g., Redux), testing libraries (e.g., Jest), and many other utilities.

These features contribute to React's popularity and make it a powerful tool for building scalable and maintainable user interfaces.

# State:
State of a component is an object that holds some information that may change over the lifetime of the component.
Components often need to change what’s on the screen as a result of an interaction.

Unidirectional data flow:
A component may choose to pass its state down as props to its child components. This is commonly called a “top-down” or “unidirectional” data flow.

State: A Component's Memory.
In React, this kind of component-specific memory is called state.
- Retain the data between renders.
- Trigger Rerender

Using State Correctly:
- Do Not Modify State Directly
- State Updates May Be Asynchronous
- State Updates are Merged



Note:
Local variables don’t persist between renders.
Changes to local variables won’t trigger renders.

# Hooks

- Introduced in React 16.8
- Hooks—functions starting with use—can only be called at the top level of your components or your own Hooks.
- Hooks allow functional components to manage state and side effects.
- You can’t call Hooks inside conditions, loops, or other nested functions.
- Hooks are functions, but it’s helpful to think of them as unconditional declarations about your component’s needs.
-  They provide a more concise way to use state and lifecycle features in functional components, reducing the need for class components.


# Props
Props are inputs to components.
- passed to the comp
- Props are Read-Only
- All React components must act like pure functions with respect to their props.
- They are single values or objects containing a set of values that are passed to components on creation using a naming convention similar to HTML-tag attributes.
- Props are a mechanism for passing data from a parent component to a child component.
- They are immutable, meaning that the child component cannot modify the props it receives.
- Props are used to transmit data and configuration settings to child components.

# Component

Components let you split the UI into independent, reusable pieces, and think about each piece in isolation.

Conceptually, components are like JavaScript functions. They accept arbitrary inputs (called “props”) and return React elements describing what should appear on the screen.

Arbitrary inputs: refers to data or values that are chosen or assigned without any specific pattern, rule, or constraint. The term "arbitrary" implies a lack of a particular reason, structure, or order in the selection of these inputs.

If you imagine a component tree as a waterfall of props, each component’s state is like an additional water source that joins it at an arbitrary point but also flows down.

# Lifecycle Methods

Mounting:

useEffect(() => {
	/* componentDidMount */
}, [])

Runs after the first render. The empty dependency array ([]) ensures it runs once, like componentDidMount.

Updating:

useEffect(() => {
	/* componentDidUpdate */
}, [dependencies])

Runs after each render if the dependencies array changes.

Unmounting:

useEffect(() => {
	return () => { /* componentWillUnmount */ }
}, [])

Runs when the component is about to unmount. The returned function acts as the cleanup function.


Example:

const Box = () => {

    useEffect(
        () => {
            console.info('Box Mounted');

            return () => {
                console.info('Box Unmounted');
            }
        }, []
    )

    return (
        <div>Box</div>
    )
}










# Component can be stateful or stateless



# Handling Events

React events are named using camelCase, rather than lowercase.
With JSX you pass a function as the event handler, rather than a string.

synthetic event: 

function handleSubmit(e) {}
Here, e is a synthetic event. React defines these synthetic events according to the W3C spec, so you don’t need to worry about cross-browser compatibility.

# Conditional Rendering
- Inline If with Logical && Operator:
{unreadMessages.length > 0 &&
        <h2>
          You have {unreadMessages.length} unread messages.
        </h2>
      }
- isLoggedIn ? 'currently' : 'not'
{isLoggedIn
        ? <LogoutButton onClick={this.handleLogoutClick} />
        : <LoginButton onClick={this.handleLoginClick} />
      }
- Preventing Component from Rendering:
function WarningBanner(props) {
  if (!props.warn) {
    return null;
  }

  return (
    <div className="warning">
      Warning!
    </div>
  );
}


# Keys
Keys help React identify which items have changed, are added, or are removed. Keys should be given to the elements inside the array to give the elements a stable identity.
- Keys Must Only Be Unique Among Siblings

Controlled Components:
An input form element whose value is controlled by React in this way is called a “controlled component”.

In a controlled component, the React state is used to control the form elements. The state of the component is tied directly to the value of the form element, and any user input is handled through React state and event handlers. This means that the React component has full control over the form element.

<input type="text" value={inputValue} onChange={handleChange} />

Uncontrolled Components:
In an uncontrolled component, the form element maintains its own state, typically using the DOM directly. The React component does not manage the state of the form element, and you may use refs to interact with the DOM element.

<input type="text" ref={inputRef} />
 
# Single source of truth



# Lifting State Up

The term "Lifting State Up" in the context of React refers to the practice of moving the state of a component higher up the component tree, usually to a common ancestor, so that multiple child components can share and update that state. This promotes a unidirectional data flow and makes it easier to manage and synchronize state among different components.

The opposite of "Lifting State Up" can be described as "Prop Drilling" or "Passing State Down." In this scenario, instead of lifting the state up to a common ancestor, the state is passed down through a chain of components via props.


# Composition

Containment:

Some components don’t know their children ahead of time.
This is especially common for components like Sidebar or Dialog that represent generic “boxes”.
Such components use the special children prop to pass children elements directly into their output.

function Dialog(props) {
  return (
    <FancyBorder color="blue">
      {props.children}
    </FancyBorder>
  );
}


Specialization:



# Props vs State

 Props get passed to the component similar to function parameters
whereas state is managed within the component similar to variables declared within a
function.

Immutability:
Props: Immutable. Passed from parent to child, child components cannot modify their props.
State: Mutable. Managed within a component, can be modified using setState.

Modification:
Props: Can only be modified by the parent component that passes them.
State: Can be modified within the component that owns it.

Usage:
Props: Used for communication between components, often from parent to child.
State: Used for managing internal component state.

# useEffect

Find the below order of execution

```
// App componets
function App() {
  const [count, setCount] = useState(0)

  useEffect(() => {
    console.info('Count value changed to: ', count)
  }, [count]);

  console.info('App rendered');
  return (
    <>
      <div>
        {
          count % 2 == 0 && <Box />
        }
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
      </div>
    </>
  )
}

// Box Component
const Box = () => {

    useEffect(
        () => {
            console.info('Box Mounted');

            return () => {
                console.info('Box Unmounted');
            }
        }, []
    )
	
    return (
        <div>Box</div>
    )
}
```


# Find the output

function App() {
  const [count, setCount] = useState(0)

  useEffect(() => {
    console.info('App Mounted');
  }, [])

  useEffect(() => {
    console.info('Count value changed');
  }, [count]);

  console.info('App Rendered');
  return (
    <>
     <Box />
    </>
  )
}

const Box = () => {

    useEffect(
        () => {
            console.info('Box Mounted');

            return () => {
                console.info('Box Unmounted');
            }
        }, []
    )
	
    console.info('Box Rendered');
    return (
        <div style={styles}>Box</div>
    )
}

Output:
App Rendered
Box Rendered
Box Mounted
App Mounted
Count value changed

# Why should we not update the state directly?

In React, it's important not to update the state directly, and instead, use the setState method provided by React.
Modifying the state directly can lead to unexpected behavior and bugs. Here's why you should avoid updating the state directly


Reactivity Issues:
React relies on the ability to detect changes in state to trigger re-renders. When you update the state directly, React might not be aware of the change, and the component may not re-render as expected.

Batching of State Updates:
React may batch multiple setState calls for performance reasons.
If you update the state directly, you could unintentionally bypass this batching mechanism, leading to inefficient updates and potential performance issues.

Asynchronous Nature of setState:
The setState function in React is asynchronous.
If you update the state directly, you might not be working with the most up-to-date state when making changes.
setState ensures that you are working with the latest state.

Predictable State Transition:
Using setState provides a clear and predictable transition from the current state to the next state. It ensures that state updates are applied in the correct order and that any dependent logic or side effects can be properly handled.


# Use of Initializer function in state.

Passing the initializer function:
const [todos, setTodos] = useState(createInitialTodos);

Passing the initial state directly:
const [todos, setTodos] = useState(createInitialTodos());

# Difference between initializer function v/s useEffect mounting in state.

const [todos, setTodos] = useState(createInitialTodos);
v/s
useEffect(
	() => {
		setTodos( createInitialTodos() );
	}, []
)

In React, both the initializer function provided to `useState` and the `useEffect` with an empty dependency array (`[]`) can be used for executing code during the component's mounting phase. However, there are some differences between the two approaches:

### 1. **Execution Timing:**

- **Initializer Function (`useState`):**
  - The initializer function passed to `useState` is executed only once when the component is created and the state is initialized. It runs during the mounting phase.

- **`useEffect` with Empty Dependency Array:**
  - The function inside `useEffect` with an empty dependency array is also executed once, but it runs after the initial render and the rendering of subsequent updates. It still occurs during the mounting phase, but it happens after the initial rendering.

### 2. **Intended Use:**

- **Initializer Function (`useState`):**
  - Typically used when the initialization logic is directly related to the state itself. It's concise and straightforward.

- **`useEffect` with Empty Dependency Array:**
  - Used when you want to perform side effects during the mounting phase, such as data fetching, subscriptions, or other operations that don't directly relate to the state being initialized.

### Example:

```jsx
// Using Initializer Function with useState
const [todos, setTodos] = useState(createInitialTodos);

// Using useEffect for Mounting Logic
useEffect(() => {
  setTodos(createInitialTodos());
}, []);
```

In the examples above, both approaches achieve the same result of initializing the `todos` state during the mounting phase. The key difference lies in the timing of execution and the intended use.

- **Initializer Function:** Directly initializes the state during the mounting phase.
  
- **`useEffect` with Empty Dependency Array:** Allows for more flexibility, especially when additional side effects or asynchronous operations are needed during the mounting phase.

Choose the approach that best fits your specific use case. If you're only concerned with state initialization, the initializer function with `useState` is concise and clear. If you need to perform additional operations during mounting, consider using `useEffect` with an empty dependency array.


# What is the difference between HTML and React event handling?

HTML | JSX
lowercase as convention | pascalCase as convention
In HTML, you can return false to prevent default behavior
Whereas in React you must call preventDefault() explicitly

 In HTML, you need to invoke the function by appending () Whereas in react you
should not append () with the function name. (refer "activateLasers" function in
the first point for example)

# How to bind methods or event handlers in JSX callbacks?

# How to pass a parameter to an event handler or callback?

# What are synthetic events in React?
In web development, when you interact with a webpage by clicking a button, typing in a form, or doing anything that triggers an action, that's considered an "event." Each browser has its way of handling these events, and they may behave slightly differently.

Now, React, being a JavaScript library for building user interfaces, wants to make things consistent and easy for developers. So, instead of directly using the events provided by browsers (like clicking, typing, etc.), React introduces its own layer of events called "synthetic events."

- SyntheticEvent is a cross-browser wrapper around the browser's native event.
- Its API is same as the browser's native event, including stopPropagation() and preventDefault() , except the events work identically across all browsers.
- Synthetic events wrap native browser events and provide a consistent API regardless of the underlying browser. They are instances of the SyntheticEvent class in React.

# Lnline conditional expressions

- Basic Ternary Operator
- Conditional Rendering with Logical AND (&&)
- Nullish Coalescing (??)


# Keys

Why does React need keys:

Imagine that files on your desktop didn’t have names. Instead, you’d refer to them by their order — the first file, the second file, and so on. You could get used to it, but once you delete a file, it would get confusing. The second file would become the first file, the third file would be the second file, and so on.

File names in a folder and JSX keys in an array serve a similar purpose. They let us uniquely identify an item between its siblings. A well-chosen key provides more information than the position within the array. Even if the position changes due to reordering, the key lets React identify the item throughout its lifetime.

- JSX elements directly inside a map() call always need keys!

You need to give each array item a key — a string or a number that uniquely identifies it among other items in that array

Keys tell React which array item each component corresponds to, so that it can match them up later. This becomes important if your array items can move (e.g. due to sorting), get inserted, or get deleted. A well-chosen key helps React infer what exactly has happened, and make the correct updates to the DOM tree.

Rules of keys:
- Keys must be unique among siblings. However, it’s okay to use the same keys for JSX nodes in different arrays.
- Keys must not change or that defeats their purpose! Don’t generate them while rendering.


Where to get your key:

Data from a database: If your data is coming from a database, you can use the database keys/IDs, which are unique by nature.

Locally generated data: If your data is generated and persisted locally (e.g. notes in a note-taking app), use an incrementing counter, crypto.randomUUID() or a package like uuid when creating items.


# Difference between Refs and State
- Both can retains the values in renders.
- State change will trigger the rerender but ref change won't.
Refs:
- Primarily used to interact with the DOM directly or to hold a reference to a React component instance.
- Retain values across renders, similar to variables, but changes to refs don't trigger re-renders.
- Changes to refs do not cause a component to re-render. They are mutable and do not trigger a component update when modified.
State:
- Used to manage and store dynamic data within a component. Changes to state trigger re-renders.
- Retains values across renders, and changes to state trigger re-renders.
- Changes to state trigger a component re-render. State is meant for managing the visual and dynamic aspects of a component.

# Why don't we use ref in renderable content

Refs are mutable and can be modified at any time, even during render. However, changes to refs during the render phase do not trigger additional renders. This can lead to a mismatch between the rendered output and the component's internal state, causing bugs that are hard to trace.




