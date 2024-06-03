Redux and Redux Toolkit are JavaScript libraries commonly used in web development, especially with React, to manage the state of an application. Let's explore each of them individually:

### Redux:

**Redux** is a predictable state container for JavaScript applications. It provides a way to manage the state of an application in a more organized and predictable manner, especially when dealing with complex, data-driven web applications. The core concepts of Redux are:

1. **Store:** Redux stores the entire state of your application in a single JavaScript object called the "store." This state represents the current state of your application and is immutable.

2. **Actions:** Actions are plain JavaScript objects that describe changes to the state. They must have a `type` property that defines the type of action being performed. Actions are dispatched to trigger state changes.

3. **Reducers:** Reducers are pure functions that specify how the application's state changes in response to actions. They take the current state and an action as arguments and return a new state. Reducers are responsible for updating the state.

4. **Dispatch:** Dispatch is a method provided by Redux that allows you to send actions to the store. When an action is dispatched, Redux calls the appropriate reducer to update the state.

5. **Selectors:** Selectors are functions that allow you to access specific parts of the state tree. They help in extracting data from the store in a structured way.

Redux is particularly useful for applications with complex data flows, where multiple components need access to the same state, or where you need to maintain a history of actions for debugging or time-traveling purposes. However, setting up Redux and writing boilerplate code for actions and reducers can be verbose.

### Redux Toolkit:

**Redux Toolkit** is an official package from the Redux team that simplifies the process of working with Redux. It is designed to reduce the amount of boilerplate code required to set up a Redux store and write reducers. Some key features of Redux Toolkit are:

1. **CreateSlice:** Redux Toolkit introduces the `createSlice` function, which allows you to define a reducer and its associated actions in a single place. It automatically generates action creators and reducer functions, reducing the need for writing repetitive code.

2. **Immer Integration:** Redux Toolkit integrates with Immer, a library that simplifies immutable state updates. With Immer, you can write reducer logic that appears to be mutating the state directly, but it safely generates a new state behind the scenes.

3. **configureStore:** Redux Toolkit provides the `configureStore` function, which simplifies the store setup process by automatically including common middleware like Redux Thunk for handling asynchronous actions and Redux DevTools for debugging.

4. **createAsyncThunk:** Redux Toolkit provides a utility function called `createAsyncThunk` for handling asynchronous actions. It simplifies the process of dispatching actions for loading, success, and error states in asynchronous operations.

Overall, Redux Toolkit streamlines the development process and reduces the amount of boilerplate code required to manage state in a Redux-based application. It's a great choice for both beginners and experienced developers looking to work with Redux more efficiently.



React Redux Toolkit is a library that simplifies the process of managing state in a React application using Redux. It provides a set of utility functions and abstractions that make it easier to write Redux code.


npm install @reduxjs/toolkit
npm i bootstrap
npm install react react-dom redux react-redux @reduxjs/toolkit


// counterSlice.js
import { createSlice } from '@reduxjs/toolkit';

// Creating a Slice
const counterSlice = createSlice({})



// Three properties you need to provide to create a Slice.

1. name
2. initialState
3. reducers

const counterSlice = createSlice({
  name: 'counter',
  initialState: {},
  reducers: {},
});

// Slice provide sever useful fields
counterSlice.actions
counterSlice.reducer

export const { increment, decrement } = counterSlice.actions;

export default counterSlice.reducer;

reducers: these are the key and function paried values.

// Creating a store

import { configureStore } from '@reduxjs/toolkit';
const store = configureStore({ ... })

const store = configureStore({
  reducer: {
    counter: counterReducer,
  },
});


---

initialState: {value : 0}

increase : state => {
	state.value += 1;
}

reducer : {
	counter : //...
}

const value = useSelect(state => state.counter.value);


Action object:
{"type":"counter/addValue","payload":""}


payload: undefined
type: "auth_local/login"
---

**Immer** is a JavaScript library that simplifies the process of working with immutable data. It's commonly used in conjunction with state management libraries like Redux and Redux Toolkit to handle updates to complex data structures in a more intuitive and readable way.

Immer's main feature is its ability to produce a "draft" of an object or array, which you can freely modify as if it were mutable. Behind the scenes, Immer takes care of creating a new copy of the data with the modifications, ensuring that the original data remains unchanged. This is incredibly helpful when working with deeply nested or complex state structures, such as those found in Redux stores.

Here's how Immer works:

1. You start with an immutable object or array.

2. You create a "draft" of that object or array using Immer's `produce` function.

3. You can modify the draft as if it were mutable, using standard JavaScript operations.

4. Immer keeps track of the modifications and generates a new, immutable object or array based on the draft.

Here's a simple example of how you can use Immer with Redux Toolkit:

```javascript
import { createSlice } from "@reduxjs/toolkit";
import produce from "immer";

const initialState = {
  items: [],
};

const mySlice = createSlice({
  name: "mySlice",
  initialState,
  reducers: {
    addItem: (state, action) => {
      state.items.push(action.payload); // This looks like mutable code, but Immer handles it for us.
    },
  },
});

export const { addItem } = mySlice.actions;

export default mySlice.reducer;
```

In this example, the `addItem` reducer appears to modify the `state.items` array directly, but Immer ensures that it's handled immutably behind the scenes.

Now, as for best practices for creating reducers, here are some guidelines:

1. **Keep Reducers Pure:** Reducers should be pure functions, meaning they should not have side effects or modify the input data directly. They should take the current state and an action as input and return a new state.

2. **Use Immer with Redux Toolkit:** When using Redux Toolkit, take advantage of Immer to simplify state updates. Write reducer logic as if you're modifying the state directly, and let Immer handle immutability.

3. **Single Responsibility:** Keep reducers focused on a single slice of your state. Avoid having a single, monolithic reducer for your entire application. Instead, use Redux Toolkit's `createSlice` to create smaller, more manageable reducers.

4. **Separate Logic from Reducers:** Complex logic, especially asynchronous operations, should be handled outside of reducers. Use Redux Thunk or other middleware for asynchronous operations.

5. **Immutable Updates:** When updating state, always create a new copy of the state or modify the draft using Immer. Never modify the existing state object or array directly.

6. **Use Descriptive Action Types:** Use meaningful action type names that describe what the action does. This makes it easier to understand your codebase.

7. **Avoid Deep Nesting:** Keep your state structure as flat as possible. Deeply nested state can make updates and selectors more complex.

8. **Testing:** Write tests for your reducers to ensure they behave as expected. Tools like Jest make testing Redux code straightforward.

By following these best practices, you can create maintainable and predictable Redux reducers that are easier to understand and debug.


# non-draftable values

In the context of Redux Toolkit and the Immer library, a "non-draftable" value refers to a JavaScript value that cannot be directly modified or mutated using Immer's draft update mechanism. Immer provides a convenient way to work with immutable data in Redux reducers by creating a "draft" copy of the state that can be safely mutated, but this mechanism has some limitations.

Here are some examples of non-draftable values:

1. **Primitive Values:** Primitive values like strings, numbers, and booleans are non-draftable. You cannot directly modify them using Immer because they are immutable by nature in JavaScript.

   ```javascript
   const name = "John";
   // You cannot do something like this with Immer:
   // produce(name, (draftName) => {
   //   draftName = "Alice";
   // });
   ```

2. **Frozen Objects:** Objects that have been explicitly frozen using `Object.freeze()` are non-draftable. When an object is frozen, it cannot be modified in any way.

   ```javascript
   const person = Object.freeze({ name: "John" });
   // Immer cannot modify this object:
   // produce(person, (draftPerson) => {
   //   draftPerson.name = "Alice"; // This will not work
   // });
   ```

3. **Immutable Data Structures:** Some libraries, like Immutable.js, provide data structures that are inherently immutable. Immer cannot directly modify these data structures.

   ```javascript
   const immutableList = Immutable.List([1, 2, 3]);
   // Immer cannot modify this list:
   // produce(immutableList, (draftList) => {
   //   draftList.push(4); // This will not work
   // });
   ```

Immer works most effectively with plain JavaScript objects and arrays that are not deeply frozen or have not been turned into non-draftable values by other means. When working with non-draftable values, you may need to handle updates differently, such as by creating new instances or objects to represent the updated state.


What is Redux?
Redux is a state management library that allows you to manage the state of your JavaScript applications more efficiently and predictably.


Why Should I Use Redux?

Redux can help simplify the state management process, especially when dealing with complex and interconnected components. Here are some reasons why you might want to use Redux in your application:

Centralized state management: With Redux, you can maintain the state of your entire application in a single store, making it easier to manage and access data across components.

Predictable state updates: Redux has a clear flow of data, which means changes to the state can only happen when you create an action and send it through Redux. This makes it easy to understand how your application's data will change in response to user actions.

Easier debugging: With Redux DevTools, you have a clear record of all the changes to your application's state. This makes locating and fixing issues in your code easier, saving you time and effort in the debugging process.

Better performance: By minimizing the number of state updates and reducing the need for prop drilling, Redux helps improve your application's performance.




27-09-2023

Redux Toolkit in 5 words:

- Provider
- configureStore
- createSlice
- useDispatch hook
- useSelector hook



1. Provider:

import { Provider } from 'react-redux';

<Provider store={activeStore}>
	<App />
</Provider>

2. configureStore

import { configureStore } from "@reduxjs/toolkit"

const store = configureStore({
    reducer: {
		//... All the reducers
    }
});


3. createSlice


const mySlice = createSlice(
	{
		name : '...',
		initialState : {...},
		reducers : {...}
	}
)

4. useDispatch hook

import { useDispatch } from 'react-redux';

const dispatch = useDispatch();
dispatch(login())
dispatch(login({email: '', pwd: ''}))
dispatch(addValue(inputRef.current.value));

5. useSelector hook
import { useSelector } from 'react-redux';

const state = useSelector(state => state);
const value = useSelector(state => state.counter.value);
{
	counter: {
		value: 102
	}
}







How to install Redux
Redux requires a few dependencies for its operations, namely:

Redux: The core library enables the redux architecture.
React Redux: Simplifies connecting your React components to the Redux store.
Redux Thunk: Allows you to write asynchronous logic in your Redux actions.
Redux DevTools Extension: Connects your Redux application to Redux DevTools



How Does Redux Work?
1. Store
2. Actions
3. Dispatch
4. Reducers


import { createSlice } from "@reduxjs/toolkit";
import { configureStore } from "@reduxjs/toolkit";

What is slice?
- A slice the segment of the data in the store.
- Which can be created, updated, deleted individually without effecting other fields.

How to create Slice?
- createSlice method can be used to create new slice.
- createSlice method return A slice object.
- We can get actions and reduce of the slice using appropriate methods.
- Every slice has a name, initialState and a set of Actions which are enclosed inside reducers.


const mySlice = createSlice(
	{
		name : '...',
		initialState : {...},
		reducers : {...}
	}
)

How to create Reducer functions?
- While creating the Slice, need to provide the initialState and a few set of methods that can modifty that date.
- Those modifying fuctions are called Reducer fuctions.
- reducer fucntions need to get loading in side reducer.


reducers : {
	login : (s, a) => {},
	logout : (s, a) => {},
	getUser : (s, a) => {},
	refresh : (s, a) => {},
}


*s : State
*a : Action


- Every function will take two parameters
1. Previous State: It is the previous state of the slice
2. Action object: It contains the payload object where data is provided. Dispatch function will call the Reducer function with Action object.

Ex:- 

Note:
- For primitive datatypes you should RETURN NEW STATE.
- For reference types you should MUTATE THE PREVIOUS STATE.

Ex 1:-

```javascript
initialState : 100

dispatch(addValue());

reducers: {
	addValue: (value) => {
		return value + 1;
    }
}
```

Ex 2:-

Note: Action object contains payload. you should not use payload directly.

```javascript
initialState : 100

dispatch(addValue(123));

reducers: {
	addValue: (value, action) => {
		return value + action.payload; // 100 + 123
    }
}
```

Actions:
- An action is an object that describes what changes need to be made to the state of your application.
- It sends data from your application to the Redux store and serves as the only way to update the store.
- Actions method on Slice will return a set of methods which are declared inside reducers.
Ex:-
const {login,logout, getUser,refresh} = mySlice.actions;

What is Slice Reducer?
- A reducer is a function that takes in the current state of an application and an action as arguments, and returns a new state based on the action.
- We can get the Slice reducer by calling mySlice.reducer method.


const myReducer mySlice.reducer;

Redux store:
- The Redux store is like a giant container that holds all the data for your application.
- The store is the single source of truth for your application's state.
- This means that any component in your application can access it to retrieve and update data
- Every store contains a reducer.
- Configure Store method used to create the new store.
- A Store has a Reducer that can be combination of the multiple Reducers.


The root reducer
- It combines all the individual reducers in the application.
- Every store has a root reducer
- configureStore and combineReducers methods can be used to create a store combining all the reducer in redux.


const store = configureStore({
    reducer: {
		//... All the reducers
    }
});

Ex:-

const store = configureStore({
    reducer: {
        counter: counterReducer,
        auth: authReducer,
        list: listReducer,
        auth_local: authReducer_LS,
        menu: menuReducer
    }
});






Dispatch
In Redux, dispatch is a function provided by the store that allows you to send an action to update the state of your application.



import { Provider } from 'react-redux';
<Provider store={store}>
	<App />
</Provider>


# Simplifies

### Step 1:

- Whole application should be wrapped inside the Redux Provider.
- A Store should provide the the Provider
- The Provider will share the store to whole application.

<Provider store={store}>
	<App />
</Provider>

### Step 2: 

How to create store?
- A Redux store can be created using configureStore method.
- configureStore will take the a bunch of slice reducers to create a root reducer.

const store = configureStore({
    reducer: {
		//... All the reducers
    }
});

Ex:- 

const store = configureStore({
    reducer: {
        counter: counterReducer,
        auth: authReducer,
        list: listReducer
    }
});


### Step 3:

How to create a Slice?
- A slice can be created using the create Slice method.

const mySlice = createSlice(
	{
		name : '...',
		initialState : {...},
		reducers : {...}
	}
)

### Step 4:

Getting Reducer and Actions from Slice

mySlice.actions:
- It will provide a object of actions.
- Destructured the `mySlice.actions` to get the actions.

Ex:-
export const { login, logout } = mySlice.actions;

mySlice.reducer:
- It will return a reducer function

Ex:-
export const myReducer = mySlice.reducer;

### Step 5:

How to call an action?

import { useDispatch } from "react-redux";
const dispatch = useDispatch();


dispatch(login());
dispatch(logout());

### Step 6:

Dispatching with parameters

dispatch(itemActions.addItem({ item, cost }));

addItem: (state, action) => {
	// action.payload will hold the data send by dispatcher
}

### Step 7:

STORE STRUCTURE:

import { configureStore, createSlice } from "@reduxjs/toolkit"
import authReducer_LS from "./authSlice_LS";
const slice1 = createSlice({
    name: 'slice1',
    initialState: 1234,
})

const slice2 = createSlice({
    name: 'slice2',
    initialState: false,
})

const slice3 = createSlice({
    name: 'slice3',
    initialState: 'name',
})

const slice4 = createSlice({
    name: 'slice4',
    initialState: [1, 2, 3, 4, 5],
})

const slice5 = createSlice({
    name: 'slice5',
    initialState: {
        id: 101,
        name: 'Sujith',
        active: false
    },
})

export const reducer1 = slice1.reducer;
export const reducer2 = slice2.reducer;
export const reducer3 = slice3.reducer;
export const reducer4 = slice4.reducer;
export const reducer5 = slice5.reducer;


const fakeStore = configureStore({
    reducer: {
        data1 : reducer1,
        data2 : reducer2,
        data3 : reducer3,
        data4 : reducer4,
        data5 : reducer5,
        auth_local: authReducer_LS,
    }
})

export { fakeStore };


### Store
```json
{
    "data1": 1234,
    "data2": false,
    "data3": "name",
    "data4": [1, 2, 3, 4, 5],
    "data5": {
        "id": 101,
        "name": "Sujith",
        "active": false
    },
    "auth_local": {
        "isLogin": true
    }
}
```

How to select the data from STORE?

const state = useSelector(state => state); // Total state
const state = useSelector(state => state.data1); // 1234
const state = useSelector(state => state.data4); // [1, 2, 3, 4, 5]
const state = useSelector(state => state.data5.name); // Sujith
const state = useSelector(state => state.data4[1]); // 2














