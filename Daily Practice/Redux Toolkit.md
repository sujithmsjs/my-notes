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




