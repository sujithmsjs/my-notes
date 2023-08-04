

# Which values will get rendered

```jsx
<h1>{true}</h1>
<h1>{false}</h1>
<h1>{NaN}</h1>
<h1>{null}</h1>
<h1>{undefined}</h1>
<h1>{""}</h1>
<h1>{[]}</h1>
<h1>{[1, 2, 3]}</h1>
<h1>{}</h1>
<h1>{Infinity}</h1>
<h1>{-Infinity}</h1>
<h1>{0}</h1>
<h1>{1}</h1>
```
> **Note:**
> `true`, `false`, `null`,`undefined`,`Blank String('')`,`Empty Array([])`,`Empty Object ({})` **won't get rendered.**

#### Output
```html
<h1></h1>
<h1></h1>
<h1>NaN</h1>
<h1></h1>
<h1></h1>
<h1></h1>
<h1></h1>
<h1>123</h1>
<h1></h1>
<h1>Infinity</h1>
<h1>-Infinity</h1>
<h1>0</h1>
<h1>1</h1>
```

#### To avoid empty div's we can use Fragments
```jsx
<>
    // Your code
</>
```
#### Render a array nodes
```jsx
return (
    <div className="App">{[<h1>Hey</h1>, <h1>Hey</h1>, <h1>Hey</h1>]}</div>
);
```





> In `package.json` we can find {"main": "src/index.js"} where the main js file will get loaded.



#### index.js
```jsx
import { StrictMode } from "react";
import { createRoot } from "react-dom/client";

import App from "./App";

const rootElement = document.getElementById("root");
const root = createRoot(rootElement);

root.render(
  <StrictMode>
    <App />
  </StrictMode>
);
```



```jsx
let name = 'Java';
const myElement = <h1>I Love {name}</h1>;
const myElements = [
	<h1>I Love {name}</h1>,
	<h1>I Love JSX!</h1>,
	<h1>I Love JSX!</h1>,
	<h1>I Love JSX!</h1>
];

const eles = [];

for(let i=1;i<=10;i++){
	eles.push(<h1>2 x {i}  = {2 * i} </h1>);
}	

return <div>
	{myElements}
	{eles}
	</div>;
}

const container = document.body;
const root = ReactDOM.createRoot(container);
root.render(<Hello />)
```


```jsx
import Display from './Display'
import "./styles.css";

export default function App() {
  return (
    <div className="App">
      <Display />
      <Display />
      <Display />
    </div>
  );
}
```

```jsx
import "./styles.css";

export default function Display() {
  const emp = {
    id : 12345,
    name : 'Sujith',
    slary : 1000.45,
    hiredate : new Date()
  }

  const input = <input type="text" />;
  return (
    <div id="centeredDiv">
       <p> {emp.id} </p>
       <h1> {emp.name} </h1>
       <h3> {emp.slary} </h3>
       <p> {emp.hiredate.toLocaleString()} </p>
    </div>
  );
}
```

# Transfering props
1. Directly in JSX
2. Spread operator with JSX
3. Using named props
4. Passing functions as props
5. Using Object Destructuring
6. Using a Functional Component
7. Using Class Component
8. Using the React.cloneElement method


```js
const details = {
	title: "Hello",
	subTitle: "Welcome",
	cost: 50_0000
};
```

#### Passing Props #1

```jsx
<Box title="Hello" subTitle="World" cost={1234.53} />

// Using spread operator from Props
const Box = (props) => {
  const { title, subTitle, cost } = props;
}

// Using Props and DOT operator
const Box = (props) => {
	console.info(props.title);
	console.info(props.subTitle);
	console.info(props.cost);
}

// Spread operator
const Box = ({ title, subTitle, cost }) => {}

// Spread operator with default values
const Box = ({ title, subTitle, cost: c = '1' }) => {}

// Spread operator with alias name default values
const Box = (
    { 
        title : t,
        subTitle = 'Welcome',
        cost: c = '1'
    }
) => {}
```

#### Passing Props #2
```jsx
<Box data={details} />

const Box = (props) => {
  const { title, subTitle, cost } = props.data;
}

const Box = ({ data }) => {
	const { title, subTitle, cost } = data;
}

const Box = ({ data: { title, subTitle, cost } }) => {
	 return <h1>{[title, subTitle, cost]} </h1>;
};
```
#### Passing Props #3
```jsx
<Box {...details} cost={5678.21} />
<Box {...details, cost } />
<Box {...details, ...data } />
<Box title="Special Title" {...details} />

// Using props
const Box = (props) => {
    console.info(props.title);
    console.info(props.subTitle);
    console.info(props.footer);
    console.info(props.cost);
}
```
#### Passing Props #4
```jsx
<Box data={details} cost={42.42} />

// Using props
const Box = (props) => {
    const { title, subTitle, cost } = props.data;
    console.info(props.cost);
}
```
#### Passing Props #5
```jsx
import styles from "./Box.module.css";

<Box className={styles.box} data={emp} />

const Box = ({ className, data: { title, subTitle, cost } }) => {
  return <h1 className={className}>{[className, title, subTitle, cost]} </h1>;
};
```


#### Dynamic Colors

```jsx
// Caller
<Display color={color} />

// Callee
function Display(props){
	const styles = {
		backgroundColor: props.color,
	}	
	return <div style={styles}>...</div>
}
```

#### bootstrap

```jsx
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
https://source.unsplash.com/featured/300x201
bootstrap\dist\js\bootstrap.bundle.min.js
```
## Button event
```jsx
import "./styles.css";

export default function App() {
  const handleClick = (event) => {
    console.info(event.target.id); // showBtn
    console.info(event.target.type); // submit
    console.info(event.target.name); // showBtn
    console.info(event.target.title);
    console.info(event.target.tagName); // BUTTON
    console.info(event.target.className); // btn
    console.info(event.target.innerText); // Show
    console.info(event.target.outerText); // Show
    console.info(event.target.localName); // button
  };

  return (
    <button className="btn" id="showBtn" name="showBtn" onClick={handleClick}>
      Show
    </button>
  );
}
```

## Passing attribute to button event handler and composition card


```jsx
import "./styles.css";

export default function App() {
  const handleClick = (event, name, salary) => {
    console.info(`Name: ${name}, Salary: ${salary}`);
  };

  return (
    <Card>
      <button onClick={(e) => handleClick(e, "Suijth", 1e6)}>Show</button>
    </Card>
  );
}

const Card = (props) => {
  return (
    <div style={{ border: "3px solid black", padding: "10px" }}>
      {props.children}
    </div>
  );
};
```

#### Above code can be written like below


```jsx
import "./styles.css";

export default function App() {
  const handleClick = (event, name, salary) => {
    console.info(`Name: ${name}, Salary: ${salary}`);
  };

  function fun(event) {
    handleClick(event, "Sujith", 1e5);
  }

  return (
    <button className="btn" id="showBtn" name="showBtn" onClick={fun}>
      Show
    </button>
  );
}
```

## useState Hook

```jsx
import "./styles.css";
import { useState } from "react";

export default function App() {
  const [flag, setFlag] = useState(true);

  const handleHide = () => {
    setFlag((prevFlag) => !prevFlag);
  };

  return (
    <div>
      <button onClick={handleHide}>Hide</button>
      {flag || <h1>Hey, welcome!</h1>}
    </div>
  );
}
```

#### Setting State Value
```jsx
setValue( prevValue => [...prevValue, newValue] );
```



#### Note

> In React, you should not directly modify the props passed to a component. Props are intended to be read-only and should not be mutated inside the component.


```jsx
const CardDiv = (props) => {
 	props.color = 'green'; // Won't work
};
```


## Styles

// Importing Styles from .CSS file
```jsx
import "./Text.css";

const Text = (props) => {

  const styles = {
    color: "yellow",
    backgroundColor: "black"
  };

  return <h1 style={styles}>{props.value}</h1>;
};
```

## Random color Pkg

```jsx
import rc from "randomcolor";

const randomHslColor = rc.randomColor({
    hue: "random",
    luminosity: "bright",
    saturation: "100",
    format: "hsl"
});

luminosity : bright/light/dark/random
format : rgb/hsl/...


const getRandomColor = () => {
  const hue = Math.floor(Math.random() * 360); // Random hue between 0 and 359
  return `hsl(${hue}, 100%, 50%)`;
};
```

# Create new React Project

```bash
npx create-react-app --version
npm install --save-dev @faker-js/faker
```

> **Note:**
>The issue with the provided code is that the input field is a controlled component, meaning its value is managed by the value state and cannot be changed directly by user input. In a controlled component, the value is only updated through the value prop and the onChange event.

### Rendering a list
> Warning: Each child in a list should have a unique "key" prop.

```jsx
import "./styles.css";

export default function App() {
  const arr = ["Lavender", "Olive", "Teal", "SteelBlue"];

  const handleDel = (event, index, ele) => {
    console.info(`Element : ${ele}, Index: ${index}`);
  };

  return (
    <Card>
      <ul>
        {arr.map((ele, idx) => (
          <li key={idx}>
            {ele}
            <button onClick={(e) => handleDel(e, idx, ele)}>Del</button>
          </li>
        ))}
      </ul>
    </Card>
  );
}
```



### Faker API

```jsx
import { faker } from '@faker-js/faker';

faker.datatype.uuid(),
faker.internet.email(),
faker.internet.domainName(),
faker.image.avatar(),
faker.internet.password(),
faker.date.recent(30)
```

```jsx
import { faker } from "@faker-js/faker";

const generateItem = () => {
  return {
    name: faker.commerce.productName(),
    cost: faker.random.numeric({ min: 500, max: 1000 }),
    year: faker.date.between("2018-01-01", "2023-12-31").getFullYear()
  };
};

const fakeData = Array.from({ length: 10 }, generateItem)
```


### Working with Arrays

```jsx
setEmployees((prevEmployees) => [...prevEmployees, generateEmployee()]);
export default EmployeeList;
```



# useForm Hook

```jsx
onSubmit={(event) => {
	event.preventDefault();
	const formData = new FormData(event.target);

       	const newItem = {
            id: data.length + 1,
            item: formData.get('item'),
            cost: parseInt(formData.get('cost'), 10),
            quantity: parseInt(formData.get('quantity'), 10),
            date: formData.get('date'),
      	};

	setData((prevData) => [...prevData, newItem]);
	event.target.reset();
}
```


# useEffect Hook

`useEffect` is a React hook used for handling side effects in functional components. Side effects can include data fetching, subscriptions, or manually interacting with the DOM. It allows you to perform certain actions after the component has rendered or after a specific prop or state has changed.

- To perform side effects
- Ex: fetching data, directly updating the DOM, and timers.
- Syntax: useEffect(<function>, <dependency>)

```jsx
useEffect(
	
	() => {
		//...	
	},

	[]
)
```

#### Three types of useages:
1. No dependency passed
2. An empty array
3. With dependencies(Props or state values)


> Note:
> Only state variables will render in the given HTML 



# Props

#### public/index.html
```html
<div id="top-root"></div>
<div id="root"></div>
```

#### src/App.js
```jsx
return (
    <div className="App">
      <h1>Hello CodeSandbox</h1>
      <div>
        <div>
          <div>
            <div>
              <Msg />
            </div>
          </div>
        </div>
      </div>
      <h2>Start editing to see some magic happen!</h2>
    </div>
```

#### src/Msg.js
```jsx
import { createPortal } from "react-dom";

export default () => {
  return (
    <>
	{
		createPortal(<h1>Hello</h1>, document.getElementById("top-root"))
	}
    </>
  );
};
```

#### Output:
```html
<div id="top-root"><h1>Hello</h1></div>
<div id="root">
  <div class="App">
    <h1>Hello CodeSandbox</h1>
    <div>
      <div>
        <div><div></div></div>
      </div>
    </div>
    <h2>Start editing to see some magic happen!</h2>
  </div>
</div>
```
## useRef and Style Modules

Applying mutlipule module styles to the single element

1. Template literals 

```jsx
<h1 className={`${styles.box} ${styles.invalid}`}>
  Invalid inputs
</h1>
```

2. String concatenation

```jsx
<h1 className={styles.box + ' ' + styles.invalid}>
  Invalid inputs
</h1>
```

#### src/Box.module.css
```css
.box {
  padding: 10px;
  margin: 10px;
  font-size: 20px;
  display: inline-block;
}

.valid {
  color: green;
}

.invalid {
  color: red;
}
```

#### src/App.js

```jsx
import "./styles.css";
import { useState, useRef } from "react";
import styles from "./Box.module.css";

export default function App() {
  const [data, setData] = useState({});

  const fnInputRef = useRef();
  const lnInputRef = useRef();

  const handleHide = (event) => {
    event.preventDefault();

    const firstName = fnInputRef.current.value;
    const lastName = lnInputRef.current.value;

    setData(() => ({
      firstName,
      lastName
    }));
  };

  return (
    <div>
      <form>
        <input className={styles.box} type="text" ref={fnInputRef} />
        <input className={styles.box} type="text" ref={lnInputRef} />
        <button className={styles.box} onClick={handleHide}>
          Show
        </button>
      </form>

      <Box className={styles.box} data={data} />
    </div>
  );
}

const Box = ({ className, data: { firstName, lastName } }) => {
  let invalid = firstName?.trim().length < 1 || lastName?.trim().length < 1;
  return (
    <div>
      {invalid ? (
        <h1 className={`${styles.box} ${styles.invalid}`}>Invalid inputs</h1>
      ) : (
        <h1 className={`${styles.box} ${styles.valid}`}>
          {firstName + " " + lastName}
        </h1>
      )}
    </div>
  );
};
```
