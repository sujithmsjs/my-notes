# React Interview Part-2



```jsx
import React, { useState, useEffect } from 'react';

const withLoadingSpinner = (WrappedComponent) => {
  return function WithLoading(props) {
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
      // Simulate data fetching
      const fetchData = async () => {
        // Simulating an API call delay
        await new Promise((resolve) => setTimeout(resolve, 2000));
        setIsLoading(false);
      };

      fetchData();
    }, []);

    return isLoading ? <div>Loading...</div> : <WrappedComponent {...props} />;
  };
};

// Usage of the Higher-Order Component
const MyComponent = ({ data }) => (
  <div>
    <h1>Data: {data}</h1>
  </div>
);

const MyComponentWithLoading = withLoadingSpinner(MyComponent);

// Render the enhanced component
const App = () => {
  return <MyComponentWithLoading data="Hello World!" />;
};

export default App;
```




### How to create props proxy for HOC component?



Creating a props proxy for a Higher-Order Component (HOC) involves manipulating the props of the wrapped component. You can do this by intercepting the props before passing them to the wrapped component, modifying them if necessary, and potentially adding new props. Here's a simple example of how you can create a props proxy for a functional component HOC.

// Higher-Order Component with a Props Proxy
const withPropsProxy = (WrappedComponent) => {
  // Define the HOC component
  const WithPropsProxy = (props) => {
    // Modify or add props as needed
    const modifiedProps = {
      ...props,
      additionalProp: 'This is an additional prop',
    };

    // Render the wrapped component with the modified props
    return <WrappedComponent {...modifiedProps} />;
  };

  // Return the HOC component
  return WithPropsProxy;
};



### What is React Fiber? What is the main goal of React Fiber?:

### Lifting State Up v/s Passing state down:

###  What is children prop?

### What is reconciliation?

When a component's props or state change, React decides whether an actual DOM
update is necessary by comparing the newly returned element with the previously
rendered one. When they are not equal, React will update the DOM. This process is
called reconciliation.

###  Babel transpiler


### Stateless Functional Components
- Stateless functional components, often referred to as "functional components" or "presentational components," are defined as JavaScript functions.
- They don't manage any internal state or have lifecycle methods.
- They receive data and callbacks via props and return JSX to be rendered.
- Functional components are primarily concerned with rendering UI based on the provided props.


```jsx
import React from 'react';

const MyComponent = (props) => {
  return (
    <div>
      <p>{props.message}</p>
      <button onClick={props.onClick}>Click me</button>
    </div>
  );
};

export default MyComponent;
```


### Stateful Functional Components with React Hooks
- With the introduction of React Hooks, functional components can now manage state and have lifecycle-like features.
- The most commonly used hook for managing state in functional components is the useState hook.

```jsx
import React, { useState } from 'react';

const Counter = () => {
  // Declare a state variable named 'count' with an initial value of 0
  const [count, setCount] = useState(0);

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
};

export default Counter;
```


### HOC v/s custom hooks

In React 16.3 and later, Higher-Order Components (HOCs) can still be used, but React Hooks offer a more straightforward and concise way to achieve similar effects in functional components. Instead of using HOCs, you can use custom hooks and leverage the power of React's built-in hooks like `useState`, `useEffect`, etc.

Let's consider a scenario where you want to create a custom hook that modifies or adds props to a functional component. Here's a simple example:

```jsx
import React, { useState } from 'react';

// Custom hook that acts as a props proxy
const usePropsProxy = (initialProps) => {
  const [additionalProp, setAdditionalProp] = useState('This is an additional prop');

  // Modify or add props as needed
  const modifiedProps = {
    ...initialProps,
    additionalProp,
  };

  // Return the modified props
  return modifiedProps;
};

// Functional component using the custom hook
const MyComponent = (props) => {
  // Use the custom hook to get modified props
  const modifiedProps = usePropsProxy(props);

  return (
    <div>
      <p>{modifiedProps.message}</p>
      <p>Additional Prop: {modifiedProps.additionalProp}</p>
    </div>
  );
};

export default MyComponent;
```

In this example:

1. The `usePropsProxy` custom hook is created, and it uses the `useState` hook to manage an additional prop.
2. The hook modifies or adds props as needed and returns the modified props.
3. The `MyComponent` functional component then uses the custom hook to get the modified props.

Using custom hooks in this way provides a more straightforward approach compared to creating a Higher-Order Component for props manipulation. Hooks encourage a modular and composable code structure, and you can easily reuse the custom hook in other components.

However, keep in mind that depending on your use case, you might not need to explicitly manipulate props in functional components. Many scenarios can be handled with direct use of React Hooks and their associated patterns. Always consider the specific requirements of your component logic when deciding on the best approach.


