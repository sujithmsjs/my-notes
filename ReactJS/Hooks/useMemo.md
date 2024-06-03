`useMemo` and `useCallback` are both React Hooks that serve similar purposes in terms of optimization, but they are used in different contexts and have subtle differences in their behavior.

useMemo
-------------------------
- It is used for memoizing the result of a computation.
- Especially when the computation is expensive and you want to avoid recalculating it on every render.
- It is typically used for memoizing values.


# Syntax

const cachedValue = useMemo(calculateValue, dependencies)
- useMemo is a React Hook that lets you cache the result of a calculation between re-renders.


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

