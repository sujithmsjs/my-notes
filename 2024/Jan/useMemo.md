`useMemo` and `useCallback` are both React Hooks that serve similar purposes in terms of optimization, but they are used in different contexts and have subtle differences in their behavior.

### `useMemo`:

`useMemo` is used for memoizing the result of a computation, especially when the computation is expensive and you want to avoid recalculating it on every render. It is typically used for memoizing values.

```jsx
import React, { useMemo } from 'react';

const MyComponent = ({ data }) => {
  const expensiveResult = useMemo(() => {
    // Expensive computation based on 'data'
    return data.map(item => item * 2);
  }, [data]);

  return <div>{expensiveResult}</div>;
};
```

In this example, the `expensiveResult` will only be recomputed when the `data` dependency changes. If `data` remains the same between renders, the memoized result will be reused, avoiding unnecessary computations.

### `useCallback`:

`useCallback` is used for memoizing functions, particularly when passing functions as props to child components. It's helpful when you want to prevent the recreation of functions on each render, which can potentially cause unnecessary renders in child components.

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

In this example, `handleClick` is memoized using `useCallback`, ensuring that the same function reference is used across renders of `ParentComponent`. This can be important when passing the function as a prop to child components to avoid unnecessary re-renders.

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




# memo

**Defination**
Wrap a component in memo to get a memoized version of that component.
This memoized version of your component will usually not be re-rendered when its parent component is re-rendered as long as its props have not changed.

**Syntax**
const MemoizedComponent = memo(SomeComponent, arePropsEqual?)

**Example**
const Cat = memo(BadCat, (a, b) => {
  return a.name === b.name;
});



