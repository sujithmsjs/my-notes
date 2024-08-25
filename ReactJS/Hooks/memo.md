`useMemo` and `useCallback` are both React Hooks that serve similar purposes in terms of optimization, but they are used in different contexts and have subtle differences in their behavior.

memo
-------------------

**Defination**
- memo lets you skip re-rendering a component when its props are unchanged.
- Wrap a component in memo to get a memoized version of that component.
- memoization is a performance optimization.
- This memoized version of your component will usually not be re-rendered when its parent component is re-rendered as long as its props have not changed.
- Memoization only has to do with props that are passed to the component from its parent.
- By default, React will compare each prop with Object.is
- Even when a component is memoized, it will still re-render when its own state changes or when a context that it’s using changes.


**Syntax**
const MemoizedComponent = memo(SomeComponent, arePropsEqual?)

**Example**
const Cat = memo(BadCat, (a, b) => {
  return a.name === b.name;
});

**Memoized**
React normally re-renders a component whenever its parent re-renders. With memo, you can create a component that React will not re-render when its parent re-renders so long as its new props are the same as the old props. Such a component is said to be memoized.

**Pure rendering logic**
A React component should always have pure rendering logic. This means that it must return the same output if its props, state, and context haven’t changed.
