# VITE

- Vite is a lightning-fast build tool designed for modern web development.
- Focused on speed, it leverages native ES module imports for rapid development and efficient hot module replacement (HMR).
- Ideal for frameworks like Vue.js and React, Vite serves dependencies as separate files during development, optimizing load times.
- Its simplified configuration, plugin system, and seamless integration with Vue.js make it a developer-friendly choice.
- With a minimal setup and quick start, Vite transforms the development experience by delivering high-performance builds and significantly reducing iteration times during coding.

### All the required commands

```
node -v
npm -v
npm install -g create-vite
npm list -g --depth 0
create-vite <project-name> --template <template-name>
npm run dev
```

#### Step 1: Install Node.js and npm
```
node -v
```
v16.13.1
```
npm -v
```
8.1.2

#### Step 2: Install Vite
```
npm install -g create-vite
```

#### Step 3: Check Install Vite
```
npm list -g --depth 0
```
`npm list`: Lists installed packages.
`-g`: Indicates that you want to list globally installed packages.
`--depth 0`: Specifies that you only want to see the top-level packages and not their dependencies.

```
npm list -g --depth 0 | find "create-vite"
```
#### Step 4: Create a Vite React Project
```
create-vite <project-name> --template <template-name>
```

```
create-vite suspense-demo --template react --jsx react
```

```
create-vite my-react-vite-app --template react
```
#### Step 5: Install all the modules
by using `npm install`
#### Step 6: Run the server

The `npm start` command is not typically used with Vite.
Instead, Vite comes with its own command for starting the development server.
`npm run dev`



This command is configured in the package.json file of the Vite project and is set up to run the Vite development server. It provides features like hot module replacement (HMR) for faster development iterations.

---

# FONT AWESOME ICON


### [font awesome free solid icons](https://fontawesome.com/search?o=r&m=free&s=solid)


You can find all the icons in `node_modules\@fortawesome\free-solid-svg-icons\index.d.ts` file.

### Install
```
npm install @fortawesome/fontawesome-svg-core @fortawesome/free-solid-svg-icons @fortawesome/react-fontawesome@latest
```

### Command Explaination

#### 1. Add SVG Core
```
npm i --save @fortawesome/fontawesome-svg-core
```
This is the core package for FontAwesome that provides essential functionality for using FontAwesome icons in your project.

#### 2. Add Icon Packages
```
npm i --save @fortawesome/free-solid-svg-icons
```
This package contains free solid (filled) icons from FontAwesome. It includes a set of commonly used icons with a solid style.

#### 3. Add the React Component
```
npm i --save @fortawesome/react-fontawesome@latest
```	
This package provides a React component for FontAwesome icons. It allows you to easily use FontAwesome icons as React components in your React application.
```jsx
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

<FontAwesomeIcon icon={...} />
<FontAwesomeIcon icon="..." />
```

## 3 types of imports in FontAwesomeIcon

1. Global Import
2. Dynamic Import
3. Individual Import



### Global Import


**Import all the icons into the library in the initial file.**
```npm
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUpload, faGear, faReply, faArrowUp, faArrowDown } from '@fortawesome/free-solid-svg-icons';
import { library } from '@fortawesome/fontawesome-svg-core'
import { IconsDemo } from './IconsDemo';

// All the icon into the library
library.add(faUpload, faGear, faReply, faArrowDown, faArrowUp);

function App() {
 
  return (
		<div>
		  <IconsDemo />
		</div>
	);
}

export default App
```

**Now you can utilize the icon which are added to the library.**

```npm
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

export const IconsDemo = () => {
    return (
        <div>
            <button>Increase <FontAwesomeIcon icon="fa-reply" /></button>
            <button>Decrease <FontAwesomeIcon icon="fa-upload" /></button>
            <button>Decrease <FontAwesomeIcon icon="fa-gear" /></button>
        </div>
    )
}
```












### Individual Import
**Import Icons**

You can find all the icon names at `node_modules\@fortawesome\free-solid-svg-icons\index.d.ts`

```jsx
import { faUpload, faGear, faReply } from '@fortawesome/free-solid-svg-icons';

<FontAwesomeIcon icon={faUpload} />
<FontAwesomeIcon icon={faGear} />
<FontAwesomeIcon icon={faReply} />
```
### You're Ready to Add Icons!

**Do I need bootstrap for FontAwesome?**
No, you do not need Bootstrap for FontAwesome. FontAwesome is an independent icon library, and you can use it in your projects without any dependency on Bootstrap.

**Example:**

```npx
import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUpload, faGear, faReply } from '@fortawesome/free-solid-svg-icons';

function App() {
  const [count, setCount] = useState(0);
  
  return (
    <>
      <img src={reactLogo} />
      <img src={viteLogo} />  
      
      <h1>Hello there, count : {count}</h1>
      <button onClick={() => setCount(pv => pv + 1)}>Increase <FontAwesomeIcon icon={faUpload} /> </button>
      <button onClick={() => setCount(pv => pv - 1)}>Decrease <FontAwesomeIcon icon={faGear} /></button>
      <button onClick={() => setCount(pv => pv - 1)}>Decrease <FontAwesomeIcon icon={faReply} /></button>
    </>
  )
}

export default App
```


#### Additional Attributes:

**Boolean attibutes:**
- spin
- spinPulse
- spinReverse
- pulse
- beat
- fade
- beatFade
- bounce
- shake
- border
- fixedWidth
- inverse
- listItem
```
<FontAwesomeIcon  size='1x' spin={true}  />
<FontAwesomeIcon  size='2x' shake={true }  />
<FontAwesomeIcon  size='3x' spin={true}/>
<FontAwesomeIcon  size='4x'  />
```
---

# USE CONTEXT HOOK
#### CountContextProvider.jsx
```jsx
import { createContext, useContext, useState } from "react";

const CountContext = createContext(null);

export const CountContextProvider = ({ children }) => {

    const [count, setCount] = useState(60);

    const incCount = () => {
        setCount(pv => pv + 1);
    }

    const descCount = () => {
        setCount(pv => pv - 1);
    }

    return (
        <CountContext.Provider value={{ count, incCount, descCount }} >
            <div className="theme-wrapper">
                {children}
            </div>
        </CountContext.Provider>
    )
}

export const useCountContext = () => useContext(CountContext);
```

#### How to import
```jsx
import { CountContextProvider,useCountContext } from './ctx/CountContextProvider';
```
#### App.jsx

```jsx
<CountContextProvider>
	<IconsDemo />
</CountContextProvider>
```

#### IconsDemo.jsx
```jsx
export const IconsDemo = () => {
    const {count, incCount, descCount} = useCountContext();

    return (
        <div>
            <h1>{count}</h1>
            <button onClick={incCount}> + </button>
            <button onClick={descCount}> - </button>
        </div>
    )
}
```





---

# LAZY LOADING

const Home = lazy(() => import("src/features/home/homepage/Home"));


# REACT REDUX

  const { isPurchased } = useSelector(state => state.curriculum)
  const { userData } = useSelector(state => state.user)


const router = createBrowserRouter([

{
	path : '\',
	element: (
        <Suspense Suspense fallback={<Loader />}>
          <MainLayout />
        </Suspense>
      )

}


]);

return <RouterProvider router={router}></RouterProvider>;


src
	assets
		css
		images
	common
		encryptionService
		validations
		Pagination.js
	components
		


# MOMENT LIBRARY


import Lottie from "lottie-react";


It looks like you're importing the moment library in JavaScript or a JavaScript-based environment. moment is a popular library for working with dates and times in JavaScript. It provides a convenient way to parse, manipulate, and format dates.


import moment from "moment";
<span>{moment(wishlistItem?.updatedDate).format("LL")}</span>







# LOTTIE LIBRARY

import Lottie from "lottie-react";

Lottie is a library that allows you to embed animations in JSON format into your web or mobile applications. These animations can be created with various design tools and exported as JSON files, which can then be rendered using the Lottie library.



 <Lottie animationData={stroketofill} loop={false} />
 
# REACT STARS

It appears that you are importing the ReactStars component from the "react-stars" library in a JavaScript or React project. The "react-stars" library is often used to create star rating components in React applications.

This library provides a simple way to incorporate star rating functionality into your React components. It typically allows users to interactively rate something by clicking on a set of stars, and you can customize the appearance and behavior of the rating component. 
 
<div className="d-flex align-items-center">
                  <div className="reactStars">
                    <ReactStars
                      count={5}
                      size={24}
                      edit={false}
                      color2={"#FF7B01"}
                      value={rating}
                    />
                  </div>
 
 
 
 
 
# API CALLS 

const unWishItem = async (obj) => {
    const req_body = {...}
    try {
      const response = await api.post(LIKE_DISLIKE_WISHLIST_DETAILS, req_body)
      if (response.status === 201) {
        disLikeHandler(obj);
      }
    } catch (error) {
      console.log(error)
    }
  }


import { Card, Row, Col, Button, Modal, OverlayTrigger, Tooltip } from "react-bootstrap";




# DATE FNS

It looks like you are importing the format function from the "date-fns" library in a JavaScript or TypeScript project. The "date-fns" library is a popular date utility library in the JavaScript ecosystem, providing various functions for working with dates.

The format function from "date-fns" is used for formatting dates. It allows you to format a given date object or date string according to a specified format string. This is useful for displaying dates in a human-readable format or for generating date strings in a specific format.


```jsx
import { format } from 'date-fns';

const currentDate = new Date();
const formattedDate = format(currentDate, 'yyyy-MM-dd HH:mm:ss');

console.log(formattedDate);
```

# REACT DATEPICKER

npm install react-datepicker

**Simple Demo**
```
import React, { useState } from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';

const MyDatePicker = () => {
  // State to manage the selected date
  const [selectedDate, setSelectedDate] = useState(null);

  // Function to handle date change
  const handleDateChange = (date) => {
    setSelectedDate(date);
  };

  return (
    <div>
      <h2>React Datepicker Example</h2>
      <DatePicker
        selected={selectedDate}
        onChange={handleDateChange}
        dateFormat="dd/MM/yyyy" // Customize the date format
        placeholderText="Select a date"
      />
      {selectedDate && (
        <p>Selected Date: {selectedDate.toLocaleDateString()}</p>
      )}
    </div>
  );
};

export default MyDatePicker;
```

**DatePickers**
```jsx
import React, { useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

const DatePickers = () => {

  const [dateRange, setDateRange] = useState([null, null]);
  const [startDate, endDate] = dateRange;

  return (
    <div className="date-picker">
       <DatePicker
      selectsRange={true}
      startDate={startDate}
      endDate={endDate}
      placeholderText="Select Date"
      onChange={(update) => {
        setDateRange(update);
      }}
    />
     <div className='icon'>
        <img  src={require('../assets/images/student/calender.svg').default}
            alt="Money Spent" />
        </div>

    </div>
  )
}

export default DatePickers
```




# USE DROP ZONE


useDropzone hook from the "react-dropzone" library in a JavaScript or TypeScript project. The "react-dropzone" library is commonly used for creating file drop zones in React applications.

The useDropzone hook provides an easy way to handle file uploads and drops. It abstracts many of the complexities associated with handling file input and drag-and-drop functionality.





import React, { lazy, Suspense } from "react";

const Home = lazy(() => import("src/features/home/homepage/Home"));

<Suspense fallback={<Loader />}>
	<Home />
</Suspense>



Optimizing performance in React.js involves several strategies to ensure that your web applications are responsive and efficient. Here are some performance optimization techniques specific to React.js:

1. **Memoization with React.memo:**
   - Use `React.memo` to memoize functional components and prevent unnecessary re-renders.
   - Memoization helps to avoid rendering the component again if its props haven't changed.

    ```jsx
    const MemoizedComponent = React.memo(MyComponent);
    ```

2. **Use PureComponent and shouldComponentUpdate:**
   - For class components, extend `PureComponent` or implement `shouldComponentUpdate` to prevent unnecessary renders.
   - These methods perform shallow prop and state comparisons to determine if rendering is necessary.

    ```jsx
    class MyComponent extends React.PureComponent {
      // ...
    }
    ```

3. **Avoid Unnecessary Rendering:**
   - Avoid unnecessary re-renders by carefully managing state and props.
   - Consider using state wisely and use callback functions with `setState` to ensure the latest state is used.

4. **Virtualization for Long Lists:**
   - Implement virtualization techniques for long lists using libraries like `react-window` or `react-virtualized`.
   - Only render the items that are currently visible on the screen.

5. **Bundle Splitting:**
   - Use code splitting to create smaller bundles that load only the necessary code for a particular page or feature.
   - Tools like Webpack support code splitting.

6. **Lazy Loading:**
   - Lazy load components that are not immediately needed using React's `lazy` and `Suspense`.
   - This can reduce the initial bundle size and improve the loading performance.

    ```jsx
    const MyLazyComponent = React.lazy(() => import('./MyComponent'));
    ```

7. **Optimize Images:**
   - Optimize images by using compressed formats and lazy loading.
   - Consider using responsive images and the `loading="lazy"` attribute.

    ```jsx
    <img src="image.jpg" alt="Description" loading="lazy" />
    ```

8. **Use React DevTools Profiler:**
   - React DevTools includes a Profiler that helps identify performance bottlenecks.
   - Use it to analyze component render times and identify areas for improvement.

9. **Memoize Expensive Computations:**
   - Memoize expensive computations or calculations using memoization libraries like `memoize-one`.
   - This can prevent redundant calculations during re-renders.

10. **Optimize Event Handlers:**
    - Use event delegation when handling events for multiple elements.
    - Optimize event handlers to avoid unnecessary computations and updates.

11. **Reduce Unnecessary State Updates:**
    - Be mindful of the state updates triggered by `setState`.
    - Use the `useCallback` hook to memoize functions that are passed as props to child components.

    ```jsx
    const handleClick = useCallback(() => {
      // handle click
    }, []);
    ```

12. **React.Profiler for Performance Measurement:**
    - Use the `React.Profiler` component to measure the time a component takes to render.
    - It helps identify components that are causing performance issues.

    ```jsx
    <React.Profiler onRender={onRenderCallback}>
      <MyComponent />
    </React.Profiler>
    ```

Remember that performance optimization should be done based on actual profiling and measurement results. It's crucial to focus on the parts of your application that have the most significant impact on performance. Additionally, staying updated with the latest React.js releases and best practices is essential for ongoing performance improvements.




# PURE COMPONENT
PureComponent is similar to Component but it skips re-renders for same props and state. 

A React component should always have pure rendering logic. This means that it must return the same output if its props, state, and context haven’t changed. 

When you convert this component from a class to a function, wrap it in memo:

Unlike PureComponent, memo does not compare the new and the old state. In function components, calling the set function with the same state already prevents re-renders by default, even without memo.

```jsx
import { memo } from "react";
const Greeting = ({ name }) => {
  console.log("Greeting was rendered at", new Date().toLocaleTimeString());
  return (
    <h3>
      Hello{name && ", "}
      {name}!
    </h3>
  );
};
export default memo(Greeting);
```

https://intellipaat.com/blog/pure-components-in-react/#What_are_pure_components_in_react


Refrains
Shallow comparison
Separation of concerns
Maintainability
familiarizing
React’s reconciliation algorithm

<script defer src="script.js"></script>


defer:
to delay something until a later time; to postpone:
You can order the furniture now and defer payment until September.

defer action/a decision
defer tax/payment
defer doing sth

lazy
lazy lets you defer loading component’s code until it is rendered for the first time.


const MarkdownPreview = lazy(() => import("./MarkdownPreview.js"));





Warning: Functions are not valid as a React child. This may happen if you return a Component instead of <Component /> from render. Or maybe you meant to call this function rather than return it.

The error you're encountering indicates that you are trying to use a function as a direct child of the <Suspense> component, which is not allowed in React. The Suspense component can only have components (or elements) as its children, not functions.


// Error
export const Box = () => {
}

// Okay
const Box = () => {}
export default Box;









# CHECK BOXES

function App() {

  const [show, setShow] = useState(false);

  const handleShow3 = (event) => {
    setShow(event.target.checked);
  }

  return (
    <div>
      {
        show && <h1>React</h1>
      }
      {/* You provided a `checked` prop to a form field without an `onChange` handler. You provided a `checked` prop to a form field without an `onChange` handler. This will render a read-only field. If the field should be mutable use `defaultChecked`. Otherwise, set either `onChange` or `readOnly`. */}
      <input type='checkbox' name='show' checked={false} /> Show1
      <input type='checkbox' name='show' checked={false} readOnly /> Show2
      <input type='checkbox' name='show' defaultChecked={false} /> Show3
      <input type='checkbox' name='show' onChange={false} /> Show4
      <input type='checkbox' name='show' checked={show} onChange={handleShow3} /> Show5
    </div>
  )
}

export default App


# Material UI
Material UI is an open-source React component library that implements Google's Material Design.

It includes a comprehensive collection of prebuilt components that are ready for use in production right out of the box.

npm install @mui/material @emotion/react @emotion/styled @mui/icons-material

@mui/material
@emotion/react
@emotion/styled
@mui/icons-material


https://fonts.google.com/icons
https://mui.com/material-ui/material-icons/




npm install @mui/x-data-grid

```
import './App.css'

import { TextField, Button } from '@mui/material';
import Checkbox from '@mui/material/Checkbox';
import Pagination from '@mui/material/Pagination';
import VisibilityIcon from '@mui/icons-material/Visibility';
import BookmarkIcon from '@mui/icons-material/Bookmark';
import FavoriteBorder from '@mui/icons-material/FavoriteBorder';
import Favorite from '@mui/icons-material/Favorite';
import Stack from '@mui/material/Stack';
import DataTable from './DataTable';
import CheckCircleOutlineIcon from '@mui/icons-material/CheckCircleOutline';
import CheckCircleIcon from '@mui/icons-material/CheckCircle';

const App = () => {
    return (
        <>
            <TextField id="standard-basic" label="Number 1" variant="standard" />
            <TextField id="standard-basic" label="Number 2n" variant="standard" />
            <Button variant="contained" endIcon={<VisibilityIcon />}>Hello world      </Button>
            <Pagination count={10} shape="rounded" />
            <Pagination count={10} showFirstButton showLastButton />
            <Checkbox
            label='Show'
                icon={<CheckCircleOutlineIcon />}
                checkedIcon={<CheckCircleIcon />}
            />
        </>
    )
}

export default App
export default App
```


<Form action="edit">
	<button type="submit">Edit</button>
</Form>

<Form
            method="post"
            action="destroy"
            onSubmit={(event) => {
              if (
                !window.confirm(
                  "Please confirm you want to delete this record."
                )
              ) {
                event.preventDefault();
              }
            }}
          >


 <img key={contact.avatar} src={contact.avatar || null} alt="" />



 <li>
     <Form action="/logout" method="post">
     <button>Logout</button>
     </Form>
</li>




### useSubmit

submit(null, { action: '/logout', method: 'post' });
submit(null, { action: '/logout', method: 'post' });




---


#1. Root componet loader function get called.
#2. It will return the token which is inside the Local Storage.
#3. It the token is expired it will return 'EXPIRED' string.

{
    path: '/',
    element: <RootLayout />,
    errorElement: <ErrorPage />,
    id: 'root',
    loader: tokenLoader
}

export function tokenLoader() {
  const token = localStorage.getItem('token');

  if (!token) {
    return null;
  }

  const tokenDuration = getTokenDuration();

  if (tokenDuration < 0) {
    return 'EXPIRED';
  }

  return token;
}

#4 Token will get received through useLoaderData.
function RootLayout() {
	 const token = useLoaderData();
}

#5 Prompt to Logout is the Token is expired.

function RootLayout() {

  const token = useLoaderData();
  const submit = useSubmit();

  useEffect(() => {
    if (!token) {
      return;
    }

    if (token === 'EXPIRED') {
      submit(null, { action: '/logout', method: 'post' });
      return;
    }

    const tokenDuration = getTokenDuration();
    console.log(tokenDuration);

    setTimeout(() => {
      submit(null, { action: '/logout', method: 'post' });
    }, tokenDuration);
  }, [token, submit]);	
 
 }
 
 #6 use  const token = useRouteLoaderData('root'); wherever the token is need to render.
 
 
---

import { redirect } from 'react-router-dom';

export function getTokenDuration() {
  const storedExpirationDate = localStorage.getItem('expiration');
  const expirationDate = new Date(storedExpirationDate);
  const now = new Date();
  const duration = expirationDate.getTime() - now.getTime();
  return duration;
}

export function getAuthToken() {
  const token = localStorage.getItem('token');

  if (!token) {
    return null;
  }

  const tokenDuration = getTokenDuration();

  if (tokenDuration < 0) {
    return 'EXPIRED';
  }

  return token;
}

export function tokenLoader() {
  const token = getAuthToken();
  return token;
}

export function checkAuthLoader() {
  const token = getAuthToken();

  if (!token) {
    return redirect('/auth');
  }
}

---
const Time = ({ initialTime = 30, onTimeOut }) => {

    const [time, setTime] = useState(initialTime);



    useEffect(() => {
        const interval = setInterval(() => {
            setTime(pr => pr - 1);
        }, 1_000);
        return () => {
            clearInterval(interval);
        }
    }, [])

    useEffect(() => {
        if (time < 0) {
            onTimeOut();
        }
    }, [time]);
    console.info('Render time...');
    return <>
        <h1>{time}</h1>
    </>
}
