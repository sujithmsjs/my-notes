`useMemo` and `useCallback` are both React Hooks that serve similar purposes in terms of optimization, but they are used in different contexts and have subtle differences in their behavior.

useCallback
-----------

- It is used for memoizing functions, particularly when passing functions as props to child components.
- It's helpful when you want to prevent the recreation of functions on each render, which can potentially cause unnecessary renders in child components.

```jsx
import React, { useCallback } from 'react';

const ParentComponent = () => {
  const handleClick = useCallback(() => {
    // Click handler logic
    console.log('Button clicked');
  }, []); // No dependencies means the callback never changes

  return <ChildComponent onClick={handleClick} />;
};

const ChildComponent = ({ onClick }) => {
  // Child component receives the memoized onClick function
  return <button onClick={onClick}>Click me</button>;
};
```


# useCallback

const cachedFn = useCallback(fn, dependencies)

- Use `useCallback` when you want to memoize a function.
- It takes a function and an array of dependencies. It memoizes the function itself based on changes in dependencies.
- It returns the memoized function.
