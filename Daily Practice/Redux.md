# React Redux
```
npm init
npm init -y
npm install redux
npm install react-redux
npm install redux react-redux
```

A reducer's function signature is: `(state, action) => newState`

Create a Redux store holding the state of your app.
Its API is { subscribe, dispatch, getState }.

let store = createStore(counterReducer)
{ subscribe, dispatch, getState } = store;



dispatch: It will called with the action object in it. corrospondent action will be executed and state get changed in the reduce function.

subscribe: It takes the function that would execute by react when the dispatch method called with the action.

Ex:
store.subscribe( () => {...})

getState: It will return present state of the application.
Ex:
store.getState()




**How store looks like:**

```js
const initialState = {
  user: {
    name: 'John Doe',
    email: 'john@example.com',
  },
  cart: {
    items: [],
  },
};
```




**useSelector:**
- Automatic Subscription
- Memoization
- Accessing Nested Data


`const userEmail = useSelector((state) => state.user.email);`


1. **Create a reducer function and with initialState.**
    ```
    const initialState = {
    };

    function myReducer(state = initialState, action) {
    }
    ```
2. **Create a store**
    ```jsx
    import { createStore } from 'redux';
    import counterReducer from './counterReducer';
    const store = createStore(counterReducer);
    export default store;
    ```
3. **Wrap up the whole application inside Provider.**
    ```jsx
    import { Provider } from 'react-redux';
    import store from './store';
    
    root.render(
      <React.StrictMode>
        <Provider store={store}>
          <App />
        </Provider>
      </React.StrictMode>
    );
    ```
4. **Import useSelector, useDispatch**
    ```jsx
    import { useSelector, useDispatch } from 'react-redux'
    ```
5. **Select the required data**
    ```jsx
    const count = useSelector((state) => state.count);
    onst dispatch = useDispatch({});
    ```

---

## Redux First App
### index.js

**Redux Provider:**
In src/index.js, the Provider component from react-redux wraps the App component. This provides the Redux store to the entire application so that components can access it.

```jsx
import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { Provider } from 'react-redux';
import store from './store';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Provider store={store}>
      <App />
    </Provider>
  </React.StrictMode>
);

reportWebVitals();
```

### store.js

**Redux Configuration:**
A Redux store is set up in the store.js file using the createStore function from Redux. It initializes the store with a reducer.

**Redux Reducer:**
The reducer function specifies how the state should change in response to dispatched actions.

```jsx
import { createStore } from "redux";

const initialState = {
    count: 0
};

const countReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'Inc':
            return { count: state.count + 1 };
        case 'Desc':
            return { count: state.count - 1 };
        default:
            return state;
    }
};

const store = createStore(countReducer);
export default store;
```

### App.js

**React Component:**
The main component of the application is defined in the src/App.js file. This component connects to the Redux store to read the count state and dispatch actions to update it.

```jsx
import { useSelector, useDispatch } from 'react-redux'
import './App.css';

function App() {
  const value = useSelector(state => state.count)
  const dispatch = useDispatch();

  const handleInc = () => {
    dispatch({ type: 'Inc' });
  }

  const handleDesc = () => {
    dispatch({ type: 'Desc' });
  }

  return (
    <div className="App">
      <h1>{value}</h1>
      <button onClick={handleInc}> Inc </button>
      <button onClick={handleDesc}> Desc </button>
    </div>
  );
}

export default App;
```
### What is Store?
In the context of Redux and state management in frontend applications, a "store" is a central container that holds the entire state of your application. It serves as a single source of truth for all the data and state in your app. Here's a more detailed explanation:

1. **Store as a Centralized Data Container**:
   - The store is typically a JavaScript object that holds various pieces of data, including application state, configuration settings, and other information.
   - In Redux, the store is an essential part of the architecture. It is responsible for maintaining the current state of the application.

2. **How Data Is Stored in the Store**:
   - Data is organized and stored within the store as a plain JavaScript object or a JSON-like structure.
   - In Redux, the data is typically organized into "slices" or "reducers." Each reducer manages a specific part of the application's state. When an action is dispatched, the relevant reducer is responsible for updating its portion of the state.

3. **Immutable State**:
   - One key principle of Redux is that the state within the store is immutable. This means that you never directly modify the existing state; instead, you create a new state object with the desired changes.
   - Immutability ensures predictability and helps with debugging because you can track changes more easily.

4. **Single Source of Truth**:
   - Redux promotes the idea of a single source of truth, which means that there's only one store for your entire application. All components read data from and write data to this central store.
   - This ensures that all components share the same data and can stay in sync with each other.

5. **Creating Multiple Stores**:
   - While it's possible to create multiple stores in Redux, it's generally not recommended unless you have a very specific use case for doing so.
   - A single store is usually sufficient to manage the state of your entire application, and it simplifies data flow and debugging.
   - In most scenarios, you can manage complex state by breaking it into smaller pieces using reducers and actions.

To summarize, a store in Redux is a central container for managing the state of your application. It holds data in an immutable manner and ensures that all parts of your app have access to the same state. While you can create multiple stores, it's generally best practice to use a single store for your application, organized into slices of state using reducers.

### Reducer Function
In Redux, a reducer function is responsible for specifying how a specific portion of the application's state should change in response to dispatched actions. Reducers are pure functions that take the current state and an action as input and return a new state. Here's how the reducer function works to change a portion of the data in the store:

1. **Reducer Function Signature**:
   - A reducer is defined as a JavaScript function that takes two parameters: the current state and an action.
   - The current state represents the state of the portion of the application's data that the reducer is responsible for.
   - The action describes what type of change should be made to the state.

   ```javascript
   function myReducer(state, action) {
     // Logic to handle the action and return a new state
   }
   ```

2. **Initial State**:
   - When your application starts, the store initializes the state by calling the reducer with no state and a special action called `@@redux/INIT`.
   - The reducer should provide an initial state for the portion of the data it manages. This state should be defined as the default value for the `state` parameter in the reducer function.

   ```javascript
   const initialState = {
     // Initial data for the portion of the state
   };

   function myReducer(state = initialState, action) {
     // Logic to handle actions and return a new state
   }
   ```

3. **Action Handling**:
   - The reducer uses a `switch` statement or other conditional logic to determine how to handle different types of actions.
   - Actions are typically plain JavaScript objects with a `type` property that describes the action's purpose.

   ```javascript
   function myReducer(state = initialState, action) {
     switch (action.type) {
       case 'INCREMENT':
         // Logic to handle an increment action
         break;
       case 'DECREMENT':
         // Logic to handle a decrement action
         break;
       default:
         // Return the current state if the action type is not recognized
         return state;
     }
   }
   ```

4. **Immutable Updates**:
   - Reducers must return a new state object, rather than modifying the current state in place. This ensures that the state remains immutable, which is a fundamental principle of Redux.

   ```javascript
   function myReducer(state = initialState, action) {
     switch (action.type) {
       case 'INCREMENT':
         // Create a new state object with the increment applied
         return { count: state.count + 1 };
       case 'DECREMENT':
         // Create a new state object with the decrement applied
         return { count: state.count - 1 };
       default:
         return state;
     }
   }
   ```

5. **Combining Reducers**:
   - In a typical Redux application, you may have multiple reducers, each managing a different portion of the state.
   - Redux provides a utility function called `combineReducers` to combine these reducers into a single reducer function.

   ```javascript
   import { combineReducers } from 'redux';

   const rootReducer = combineReducers({
     reducer1,
     reducer2,
     // ...other reducers
   });
   ```

6. **Dispatching Actions**:
   - To trigger a state change, you dispatch an action to the Redux store using the `dispatch` function.
   - The store then calls the relevant reducer(s) based on the action's type, and the reducers return a new state.

   ```javascript
   store.dispatch({ type: 'INCREMENT' });
   ```

7. **Updating the Store**:
   - When a reducer returns a new state, Redux updates the store's state with the new data.
   - Any connected components that subscribe to this portion of the state will re-render to reflect the changes.

In summary, reducer functions in Redux specify how a portion of the application's state should change in response to dispatched actions. They return a new state object, ensuring immutability, and can be combined to manage complex application state. Reducers play a central role in Redux's predictable state management.

### useSelector Hook

`useSelector` is a hook provided by the React Redux library. It allows you to select and extract data from your Redux store within a functional component. This hook simplifies the process of accessing and subscribing to specific parts of your application's state.

Here's how `useSelector` works and what it does:

1. **Importing `useSelector`**:
   You need to import `useSelector` from the `react-redux` library at the beginning of your component file.

   ```javascript
   import { useSelector } from 'react-redux';
   ```

2. **Usage Syntax**:
   You use `useSelector` by passing a selector function as an argument. The selector function specifies which part of the Redux store's state you want to access. The hook returns the selected data.

   ```javascript
   const selectedData = useSelector(selectorFunction);
   ```

3. **Example**:
   For instance, if you have a Redux store with a state object like this:

   ```javascript
   const initialState = {
     user: {
       name: 'John Doe',
       email: 'john@example.com',
     },
     cart: {
       items: [],
     },
   };
   ```

   You can use `useSelector` to access the `user` object:

   ```javascript
   const user = useSelector((state) => state.user);
   ```

4. **Automatic Subscription**:
   `useSelector` also automatically subscribes your component to updates from the selected part of the Redux store. If the selected data changes, your component will re-render.

   ```javascript
   const user = useSelector((state) => state.user);
   ```

5. **Memoization**:
   `useSelector` uses memoization to optimize performance. It only re-renders your component when the selected data actually changes, not on every render. This ensures efficient updates.

6. **Accessing Nested Data**:
   You can access nested data in the store by chaining selectors. For example, if you want to access the user's email:

   ```javascript
   const userEmail = useSelector((state) => state.user.email);
   ```

`useSelector` is a fundamental tool for connecting your React components to your Redux store. It allows you to read data from the store and automatically update your UI when that data changes. This makes it easier to build React applications that stay in sync with your application's state managed by Redux.



### useDispatcher

The `useDispatch` hook is a React Redux hook that provides access to the `dispatch` function, which is used to dispatch actions to your Redux store. Here's how you can use the `useDispatch` hook in a React functional component:

1. **Import the Hook**:
   First, import the `useDispatch` hook from the `react-redux` library:

   ```javascript
   import { useDispatch } from 'react-redux';
   ```

2. **Use `useDispatch` in Your Component**:
   Next, you can use the `useDispatch` hook in your component to get the `dispatch` function:

   ```javascript
   function MyComponent() {
     const dispatch = useDispatch();

     // You can now use the dispatch function to send actions to the Redux store

     return (
       // JSX for your component
     );
   }
   ```

3. **Dispatching Actions**:
   With the `dispatch` function available, you can dispatch actions to your Redux store. For example:

   ```javascript
   function MyComponent() {
     const dispatch = useDispatch();

     const handleButtonClick = () => {
       // Dispatch an action
       dispatch({ type: 'INCREMENT' });
     };

     return (
       <div>
         <button onClick={handleButtonClick}>Increment</button>
       </div>
     );
   }
   ```

In the example above, clicking the button will trigger the `handleButtonClick` function, which dispatches an action of type `'INCREMENT'`. This action will be processed by the appropriate reducer, causing the state to update.

The `useDispatch` hook simplifies the process of accessing the `dispatch` function within functional components, making it easier to interact with your Redux store.


---

## Maintain  multiple values in the store

In Redux, you can maintain multiple values in the store by organizing your state into a nested structure or using multiple reducers. Here's how you can achieve this:

1. **Using a Nested State Structure**:
   - You can maintain multiple values in the Redux store by creating a nested state structure. This is especially useful when you have related pieces of data that can be grouped together.
   - Define a state structure that reflects the hierarchy of your data.

   ```javascript
   const initialState = {
     user: {
       id: null,
       name: '',
       email: '',
     },
     products: [],
     cart: [],
   };
   ```

   In this example, the state includes `user` information, a list of `products`, and a `cart`.

2. **Using Multiple Reducers**:
   - To manage multiple pieces of state, you can create separate reducer functions, each responsible for a specific part of the state.
   - Use the `combineReducers` function from Redux to combine these reducers into a single root reducer.

   ```javascript
   import { combineReducers } from 'redux';

   // Reducers for different parts of the state
   const userReducer = (state = {}, action) => {
     switch (action.type) {
       // Handle user-related actions here
       default:
         return state;
     }
   };

   const productsReducer = (state = [], action) => {
     switch (action.type) {
       // Handle product-related actions here
       default:
         return state;
     }
   };

   const cartReducer = (state = [], action) => {
     switch (action.type) {
       // Handle cart-related actions here
       default:
         return state;
     }
   };

   // Combine the reducers into a single root reducer
   const rootReducer = combineReducers({
     user: userReducer,
     products: productsReducer,
     cart: cartReducer,
   });

   export default rootReducer;
   ```

   Each reducer handles actions related to its part of the state.

3. **Accessing Multiple Values in Components**:
   - To access multiple values from the Redux store in your components, you can use the `useSelector` hook from the `react-redux` library.
   - Specify which parts of the state you want to access by selecting them with `useSelector`.

   ```javascript
   import { useSelector } from 'react-redux';

   function MyComponent() {
     const user = useSelector((state) => state.user);
     const products = useSelector((state) => state.products);
     const cart = useSelector((state) => state.cart);

     // Use the user, products, and cart data in your component

     return (
       // JSX for your component
     );
   }
   ```

With this approach, you can maintain and access multiple values in the Redux store while keeping your code organized and modular. Each part of the state can have its own reducer and actions, making it easier to manage complex application state.


27-09-2023

const rootReducer = combineReducers({
	//... All the reducers
});

Ex:-

const rootReducer = combineReducers(
	{
		counter: counterReducer,
        auth: authReducer,
        list: listReducer,
        auth_local: authReducer_LS,
        menu: menuReducer
	}
);



















