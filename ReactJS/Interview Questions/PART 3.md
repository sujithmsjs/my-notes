### lazy
lazy lets you defer loading component’s code until it is rendered for the first time.

Paramter: A function that returns a Promise or another thenable (a Promise-like object with a then method).
React will not call load until the first time you attempt to render the returned component.
After React first calls load, it will wait for it to resolve, and then render the resolved value’s .default as a React component.
Both the returned Promise and the Promise’s resolved value will be cached, so React will not call load more than once.
If the Promise rejects, React will throw the rejection reason for the nearest Error Boundary to handle.


lazy(load function)
Call lazy outside your components to declare a lazy-loaded React component.

```js
import { lazy } from 'react';
const MarkdownPreview = lazy(() => import('./MarkdownPreview.js'));
```


Load Function:
Receives no parameters. You need to return a Promise or some other thenable. It needs to eventually resolve to an object whose. default property is a valid React component type, such as a function, memo, or a forwardRef component.
Ex:
() => import('./MarkdownPreview.js')

load: A function that returns a Promise or another thenable (a Promise-like object with a then method).

Suspense Indicator:
lazy returns a `React component` you can render in your tree.
While the code for the lazy component is still loading, attempting to render it will suspend. Use <Suspense> to display a loading indicator while it’s loading.


### What are fragments?

It's a common pattern in React which is used for a component to return multiple
elements. Fragments let you group a list of children without adding extra nodes to the
DOM.
render() {
	return (
		<React.Fragment>
		<ChildA />
		<ChildB />
		<ChildC />
		</React.Fragment>
	)
}
There is also a shorter syntax, but it's not supported in many tools:
render() {
	return (
		<>
			<ChildA />
			<ChildB />
			<ChildC />
		</>
	)
}


### Pass the state down
### Lift the state up


### Transfering props
1. Directly in JSX
2. Spread operator with JSX
3. Using named props
4. Passing functions as props
5. Using Object Destructuring
6. Using a Functional Component


### useEffect Hook

`useEffect` is a React hook used for handling side effects in functional components. Side effects can include data fetching, subscriptions, or manually interacting with the DOM. It allows you to perform certain actions after the component has rendered or after a specific prop or state has changed.

- To perform side effects
- Ex: fetching data, directly updating the DOM, and timers.
- Syntax: useEffect(<function>, <dependency>)



