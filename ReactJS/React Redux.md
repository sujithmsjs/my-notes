 import { Provider, useSelector, useDispatch  } from 'react-redux';
 import { createStore } from 'redux';
 import { combineReducers } from 'redux';
 
 
<Provider store={store}>
    <App />
</Provider>



const count = useSelector((state) => state.count);
const dispatch = useDispatch({});

dispatch({ type: 'INCREMENT' });


REDUX
-----

Redux is a state management library that allows you to manage the state of your JavaScript applications more efficiently and predictably.
Centralized state management: With Redux, you can maintain the state of your entire application in a single store, making it easier to manage and access data across components.

REDUX STORE
-----------

- The Redux store is like a giant container that holds all the data for your application.
- The store is the single source of truth for your application's state.
- This means that any component in your application can access it to retrieve and update data
- Every store contains a reducer.
- Configure Store method used to create the new store.
- A Store has a Reducer that can be combination of the multiple Reducers.

THE ROOT REDUCER
----------------

- It combines all the individual reducers in the application.
- Every store has a root reducer
- configureStore and combineReducers methods can be used to create a store combining all the reducer in redux.


How to install Redux
--------------------
Redux requires a few dependencies for its operations, namely:

Redux: The core library enables the redux architecture.
React Redux: Simplifies connecting your React components to the Redux store.
Redux Thunk: Allows you to write asynchronous logic in your Redux actions.
Redux DevTools Extension: Connects your Redux application to Redux DevTools

SLICE
-----

- A slice the segment of the data in the store.
- Which can be created, updated, deleted individually without effecting other fields.
- Allows you define a reducer and its associated actions in a single place.
- It automatically generates action creators and reducer functions, reducing the need for writing repetitive code.
- It encapsulate a piece of Redux state and the corresponding logic for updating that state.
- createSlice is a function provided by Redux Toolkit to define a slice of the Redux state.


Syntax:
```js
import { createSlice } from '@reduxjs/toolkit'
const {reducer, actions} = createSlice({name, initialState, reducers})
```

Three properties you need to provide to create a Slice.

1. name: The name of the slice.
2. initialState: The initial state of the slice.
3. reducers: An object containing reducer functions for updating the slice's state in response to specific actions.


When createSlice is called with this object, it returns another object with properties:

1. reducer: The reducer function generated by createSlice, which encapsulates the logic for updating the slice's state based on actions.
2. actions: An object containing action creators generated by createSlice, which can be used to dispatch actions to update the state.


Initial State:
Define the initial state object representing the initial state of the slice.

Reducers:
Inside the reducers field, define reducer functions (also known as "case reducers") for handling specific actions.
Each reducer function receives the current state and action object as arguments and mutates the state as needed based on the action.

Example:
reducer : {
	increment : (state, action) => state.count + 1,
	decrement : (state, action) => state.count + 1,
}

- Every function will take two parameters
1. Previous State: It is the previous state of the slice
2. Action object: It contains the payload object where data is provided. Dispatch function will call the Reducer function with Action object.


Action Creators:
- createSlice automatically generates action creators based on the reducer functions defined in the reducers field.
- These action creators can be directly imported and dispatched to update the state.

Example:
```js
const counterSlice = createSlice({
  name: 'counter',
  initialState: 0,
  reducers: {
    inc: c => c + 1,
    dec : c => c - 1
  },
});

const counterAction = counterSlice.actions;
const counterReducer = counterSlice.reducer;

export const { inc, dec } = counterAction;
```



STORE
-----

- Redux stores the entire state of your application in a single JavaScript object called the "store."
- This state represents the current state of your application and is immutable.

```js
import { configureStore } from '@reduxjs/toolkit'

const store = configureStore({
  reducer: {
    count: counterReducer,
  }
});
```

Redux Toolkit provides the `configureStore` function, which simplifies the store setup process by automatically including common middleware like Redux Thunk for handling asynchronous actions and Redux DevTools for debugging.


Immer Integration
-----------------
- Redux Toolkit integrates with Immer, a library that simplifies immutable state updates.
- With Immer, you can write reducer logic that appears to be mutating the state directly, but it safely generates a new state behind the scenes.

NOTE:
- For primitive datatypes you should RETURN NEW STATE.
- For reference types you should MUTATE THE PREVIOUS STATE.


SELECTORS
---------

const state = useSelector(state => state); // Total state
const data1 = useSelector(state => state.data1); // 1234
const arrList = useSelector(state => state.data4); // [1, 2, 3, 4, 5]
const name = useSelector(state => state.data5.name); // Sujith
const data4 = useSelector(state => state.data4[1]); // 2


DISPATCH
--------

const dispatch = useDispatch();
<button onClick={() => dispatch(inc())}>Click Me</button>










