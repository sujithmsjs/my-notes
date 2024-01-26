useRef
------


const ref = useRef(initialValue)

Referencing x Rendering

-> useRef returns a ref object with a single current property initially set to the initial value you provided.

-> useRef is a React Hook that lets you reference a value that’s not needed for rendering.

-> Call useRef at the top level of your component to declare a ref.

-> useRef returns an object with a single property: current

-> You can mutate the ref.current property.

-> State is Immutable, Ref is Mutable.

-> Ref is a plain JavaScript object.

-> When you change the ref.current property, React does not re-render your component.

-> Do not write or read ref.current during rendering, except for initialization. This makes your component’s behavior unpredictable.

-> Calling it in a different order or with different arguments should not affect the results of other calls.
Reading or writing a ref during rendering breaks these expectations.

-> Do not write or read ref.current during rendering. You can read or write refs from event handlers or effects. If you have to read or write something during rendering, use state instead.

What are Accidental Impurities?


React:
If the inputs (props, state, and context) are the same, it should return exactly the same JSX. Reading or writing a ref during rendering breaks these expectations.


-> A component must be pure.
1. It minds its own business.
2. Same inputs, same output.

- Writing pure functions takes a bit of practice, but it unlocks the power of React’s paradigm.

- As a last resort, you can useEffect.

-
---
------
---------
------------
---------
------
---
-


useMemo

-> useMemo is a React Hook that lets you cache the result of a calculation between re-renders.


const cachedValue = useMemo(calculateValue, dependencies)

const visibleTodos = useMemo(() => filterTodos(todos, tab), [todos, tab]);

1. Calculation Function
2. List of dependencies








Memoization?

You should only rely on useMemo as a performance optimization. If your code doesn’t work without it, find the underlying problem and fix it first. Then you may add useMemo to improve performance.



How to tell if a calculation is expensive? 

console.time('filter array');
const visibleTodos = filterTodos(todos, tab);
console.timeEnd('filter array');

If your app is like this site, and most interactions are coarse (like replacing a page or an entire section), memoization is usually unnecessary.



useId
-----



















