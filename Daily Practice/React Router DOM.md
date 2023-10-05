# React Router DOM

```
{
    path: "/prods/:id",
    element: <Products />,
    loader: ({ request, params }) => {
      console.info(request.method);
      console.info(request.url);
      return request.url;
    }
  }
```
```
const method = request.method;
  const data = await request.formData();
  
  const searchParams = new URL(request.url).searchParams;
  const mode = searchParams.get('mode') || 'login';

  if (mode !== 'login' && mode !== 'signup') {
    throw json({ message: 'Unsupported mode.' }, { status: 422 });
  }
```
### Query Params(Search params)

```
https://www.flipkart.com/search?q=firebolt%20cobra%20screen%20gaurd&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off
```

```
 const [searchParams] = useSearchParams();
  const isLogin = searchParams.get('mode') === 'login';
```
```
{
    path: "/prods/:id",
    element: <Products />,
    loader: ({ request, params }) => {
      const searchParams = new URL(request.url).searchParams;
      console.info(searchParams.get("name"));
      console.info(searchParams.get("love"));
      console.info(searchParams.get("page"));
      return 100;
    }
  }
  ```
  ### Search Params Example
  ```javascript
  import {
  Link,
  useLoaderData,
  useParams,
  useSearchParams
} from "react-router-dom";
const Products = () => {
  const data = useLoaderData();
  const params = useParams();
  const [searchParams] = useSearchParams();
  const mode = searchParams.get("mode");
  const modeInvert = mode === "A" ? "B" : "A";
  return (
    <>
      <h1>Products</h1>
      <h4>Loader Data {data}</h4>
      <Link to="..">Back</Link>
      <h1>Mode : {mode}</h1>
      <Link to={`?mode=${modeInvert}`}>Mode {modeInvert}</Link>
    </>
  );
};
export default Products;
  ```
### Search Params inside loader
 ```javascript
 const router = createBrowserRouter([
  { path: "/", element: <Home /> },
  {
    path: "/prods/:id/:type",
    element: <Products />,
    loader: ({ request, params }) => {
      console.info(request.method);
      console.info(request.url);
      return [params.id, params.type].join();
    }
  },
  {
    path: "/prods/:id",
    element: <Products />,
    loader: ({ request, params }) => {
      const searchParams = new URL(request.url).searchParams;
      console.info(searchParams.get("name"));
      console.info(searchParams.get("mode"));
      console.info(searchParams.get("love"));
      console.info(searchParams.get("page"));
      return 100;
    }
  }
]);
 ```
  
 ### Throwing Json without values
 ```javascript
 throw json({}, {});
 ```
**Output**
 ```json
 {
     "status": 200,
     "statusText": "",
     "internal": false,
     "data": {}
}
 ```
  
 ### Throwing Json with values
 ```javascript
 if (true) {
    throw json(
        { message : 'This page not found'},
        {status : 404, statusText : 'NOT Found'}
    );
}
```
**Output**
```
{
     "status": 404,
     "statusText": "NOT Found",
     "internal": false,
     "data": {
          "message": "This page not found"
     }
}
 ```
  
 ### Count down timer
 ```javascript
 import React, { useState, useEffect } from "react";

function CountdownTimer({ initialTime, speed = 1000, onTimeout = () => {} }) {
  const [timeRemaining, setTimeRemaining] = useState(initialTime);
  console.info("Inside CountdownTimer");
  useEffect(() => {
    let intervalId;

    if (timeRemaining > 0) {
      intervalId = setInterval(() => {
        setTimeRemaining((prevTime) => prevTime - 1);
      }, speed);
    } else {
      onTimeout();
    }

    return () => {
      clearInterval(intervalId);
    };
  }, [timeRemaining]);

  return (
    <div>
      <h1>{timeRemaining}</h1>
    </div>
  );
}

export default React.memo(CountdownTimer);
 ```
 **Navidating on Timeout**
  ```javascript
<CountdownTimer
        initialTime={100}
        speed={100}
        onTimeout={() => navigate("/")}
/>
  ```
 ### From Action
 ```javascript
 action: async ({ request, params }) => {
          const data = await request.formData();
          const email = data.get("email");
          const isValid = email.endsWith("gmail.com");

          console.info("Method: ", request.method);

          if (isValid) {
            return redirect("/");
          } else {
            return "Invalid email address";
          }
        }
 ```

### Basics
```jsx
// Elements Provided by Router
1. <RouterProvider>
2. <Outlet />
3. <NavLink>
4. <Link>

// Hooks Provided by Router
1. useRouteLoaderData
2. useLoaderData
3. useActionData
4. useRouteError
5. useParams
6. useNavigation
7. useNavigate
8. useSubmit

// Methods Provided by Router

1. createBrowserRouter([])
2. json({}, {})
3. redirect('/events')


// Creating Router
const router = createBrowserRouter([
	// Routes
])

// Using Router Provider
<RouterProvider router={router} />


// A Route can have

{
	id  : 'fakeId'
	path : '/'
	index : true
	element : <>
	loader : ({request, params}) => {}
	action: ({request, params}) => {}
	errorElement: <>
	children: []
}

const data = useRouteLoaderData('route-id');
const data = useLoaderData();
const data = useActionData();
const error = useRouteError();
const params = useParams();

const navigation = useNavigation();
navigation.state === 'loading'

- idle
- loading
- submitting

const navigate = useNavigate();
navigate('/products');
navigate('..')

json-helper-functionjson(
      { message: 'Hello' },
      {
        status: 500,
      }
    );


const error = useRouteError();
 if (error.status === 500) {
    message = error.data.message;
  }

return redirect('/events');
throw json({ message: 'Could not save event.' }, { status: 500 });

// Progamatically submitting data
const submit = useSubmit();
submit(null, { method: 'delete' });


<Outlet />
<NavLink
              to="/"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
              end
>
              Home
</NavLink>
<Link to="/products">the list of products</Link>
```

```jsx
import { createBrowserRouter, RouterProvider } from 'react-router-dom';

import HomePage from './pages/Home';

const router = createBrowserRouter([
  { path: '/', element: <HomePage /> },
]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
---------------------------
import {
  createBrowserRouter,
  // createRoutesFromElements,
  RouterProvider,
  // Route,
} from 'react-router-dom';

import HomePage from './pages/Home';
import ProductsPage from './pages/Products';

// const routeDefinitions = createRoutesFromElements(
//   <Route>
//     <Route path="/" element={<HomePage />} />
//     <Route path="/products" element={<ProductsPage />} />
//   </Route>
// );

const router = createBrowserRouter([
  { path: '/', element: <HomePage /> },
  { path: '/products', element: <ProductsPage /> },
]);

// const router = createBrowserRouter(routeDefinitions);

function App() {
  return <RouterProvider router={router} />;
}

export default App;


<p>
        Go to <Link to="/products">the list of products</Link>.
      </p>
```
### 05-layout-wrapper-route


```jsx
const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    children: [
      { path: '/', element: <HomePage /> },
      { path: '/products', element: <ProductsPage /> },
    ],
  }
]);
```

```jsx
import { Outlet } from 'react-router-dom';

import MainNavigation from '../components/MainNavigation';
import classes from './Root.module.css';

function RootLayout() {
  return (
    <>
      <MainNavigation />
      <main className={classes.content}>
        <Outlet />
      </main>
    </>
  );
}

export default RootLayout;
```

```jsx
import { Outlet } from 'react-router-dom';
```

### 06-error-route-404

```jsx
const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    errorElement: <ErrorPage />,
    children: [
      { path: '/', element: <HomePage /> },
      { path: '/products', element: <ProductsPage /> },
    ],
  }
]);
```

### 07-using-navlinks

```jsx
import { NavLink } from 'react-router-dom';

<NavLink
              to="/"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
              // style={({ isActive }) => ({
              //   textAlign: isActive ? 'center' : 'left',
              // })}
              end
            >
              Home
            </NavLink>
```


### 08-navigating-programmatically

```jsx
import { Link, useNavigate } from 'react-router-dom';

function HomePage() {
  const navigate = useNavigate();

  function navigateHandler() {
    navigate('/products');
  }

  return (
    <>
      <h1>My Home Page</h1>
      <p>
        Go to <Link to="/products">the list of products</Link>.
      </p>
      <p>
        <button onClick={navigateHandler}>Navigate</button>
      </p>
    </>
  );
}

export default HomePage;
```

### 09-dynamic-routes

```jsx
const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    errorElement: <ErrorPage />,
    children: [
      { path: '/', element: <HomePage /> },
      { path: '/products', element: <ProductsPage /> },
      { path: '/products/:productId', element: <ProductDetailPage /> }
    ],
  }
]);
```

```jsx
import { useParams } from 'react-router-dom';

function ProductDetailPage() {
  const params = useParams();

  return (
    <>
      <h1>Product Details!</h1>
      <p>{params.productId}</p>
    </>
  );
}

export default ProductDetailPage;
```
### 10-absolute-relative-paths

```jsx
const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    errorElement: <ErrorPage />,
    children: [
      { path: '', element: <HomePage /> },
      { path: 'products', element: <ProductsPage /> },
      { path: 'products/:productId', element: <ProductDetailPage /> }
    ],
  }
]);

 <p><Link to=".." relative='path'>Back</Link></p>
 <Link to={prod.id}>{prod.title}</Link>
```

### 11-index-routes

```jsx
const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    errorElement: <ErrorPage />,
    children: [
      { index: true, element: <HomePage /> },
      { path: 'products', element: <ProductsPage /> },
      { path: 'products/:productId', element: <ProductDetailPage /> }
    ],
  }
]);
```

### 14-challenge-solution

```jsx
import { RouterProvider, createBrowserRouter } from 'react-router-dom';


const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    children: [
      { index: true, element: <HomePage /> },
      {
        path: 'events',
        element: <EventsRootLayout />,
        children: [
          { index: true, element: <EventsPage /> },
          { path: ':eventId', element: <EventDetailPage /> },
          { path: 'new', element: <NewEventPage /> },
          { path: ':eventId/edit', element: <EditEventPage /> },
        ],
      },
    ],
  },
]);
```

### 15-data-fetching-example

```jsx
import { RouterProvider, createBrowserRouter } from 'react-router-dom';

import EditEventPage from './pages/EditEvent';
import EventDetailPage from './pages/EventDetail';
import EventsPage from './pages/Events';
import EventsRootLayout from './pages/EventsRoot';
import HomePage from './pages/Home';
import NewEventPage from './pages/NewEvent';
import RootLayout from './pages/Root';

const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    children: [
      { index: true, element: <HomePage /> },
      {
        path: 'events',
        element: <EventsRootLayout />,
        children: [
          { index: true, element: <EventsPage /> },
          { path: ':eventId', element: <EventDetailPage /> },
          { path: 'new', element: <NewEventPage /> },
          { path: ':eventId/edit', element: <EditEventPage /> },
        ],
      },
    ],
  },
]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
```

### 16-added-loader

```jsx
{
            index: true,
            element: <EventsPage />,
            loader: async () => {
              const response = await fetch('http://localhost:8080/events');

              if (!response.ok) {
                // ...
              } else {
                const resData = await response.json();
                return resData.events;
              }
            },
          }
```

```jsx
import { useLoaderData } from 'react-router-dom';

import EventsList from '../components/EventsList';

function EventsPage() {
  const events = useLoaderData();

  return <EventsList events={events} />;
}

export default EventsPage;
```

### 17-loader-in-separate-file

```jsx
{
            index: true,
            element: <EventsPage />,
            loader: eventsLoader,
          }
```

```jsx
import { useLoaderData } from 'react-router-dom';

import EventsList from '../components/EventsList';

function EventsPage() {
  const events = useLoaderData();

  return <EventsList events={events} />;
}

export default EventsPage;

export async function loader() {
  const response = await fetch('http://localhost:8080/events');

  if (!response.ok) {
    // ...
  } else {
    const resData = await response.json();
    return resData.events;
  }
}
```

### 18-user-feedback-usenavigation

```jsx
import { Outlet, useNavigation } from 'react-router-dom';

const navigation = useNavigation();

{navigation.state === 'loading' && <p>Loading...</p>} 
```

### 19-returning-responses

### 20-error-handling
```jsx
export async function loader() {
  const response = await fetch('http://localhost:8080/events');

  if (!response.ok) {
    // return { isError: true, message: 'Could not fetch events.' };
    throw new Response(JSON.stringify({ message: 'Could not fetch events.' }), {
      status: 500,
    });
  } else {
    return response;
  }
}
```

### 21-json-helper-function

```jsx
export async function loader() {
  const response = await fetch('http://localhost:8080/events');

  if (!response.ok) {
    throw json(
      { message: 'Could not fetch events.' },
      {
        status: 500,
      }
    );
  } else {
    return response;
  }
}
```
```jsx
import { useRouteError } from 'react-router-dom';
import MainNavigation from '../components/MainNavigation';

import PageContent from '../components/PageContent';

function ErrorPage() {
  const error = useRouteError();

  let title = 'An error occurred!';
  let message = 'Something went wrong!';

  if (error.status === 500) {
    message = error.data.message;
  }

  if (error.status === 404) {
    title = 'Not found!';
    message = 'Could not find resource or page.';
  }

  return (
    <>
      <MainNavigation />
      <PageContent title={title}>
        <p>{message}</p>
      </PageContent>
    </>
  );
}

export default ErrorPage;
```

### 22-dynamic-routes-loader

```jsx
<Link to={event.id}>

export async function loader({request, params}) {
  const id = params.eventId;

  const response = await fetch('http://localhost:8080/events/' + id);

  if (!response.ok) {
    throw json({message: 'Could not fetch details for selected event.'}, {
      status: 500
    })
  } else {
    return response;
  }
}
```

### 23-userouteloaderdata
```jsx
{
            path: ':eventId',
            id: 'event-detail',
            loader: eventDetailLoader,
            children: [
              {
                index: true,
                element: <EventDetailPage />,
              },
              { path: 'edit', element: <EditEventPage /> },
            ],
          }
```
```
 const data = useRouteLoaderData('event-detail');
```

### 24-action-data-submission

```jsx
{ path: 'new', element: <NewEventPage />, action: newEventAction }
```

```jsx
import { json, redirect } from 'react-router-dom';

import EventForm from '../components/EventForm';

function NewEventPage() {
  return <EventForm />;
}

export default NewEventPage;

export async function action({ request, params }) {
  const data = await request.formData();

  const eventData = {
    title: data.get('title'),
    image: data.get('image'),
    date: data.get('date'),
    description: data.get('description'),
  };

  const response = await fetch('http://localhost:8080/events', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(eventData),
  });

  if (!response.ok) {
    throw json({ message: 'Could not save event.' }, { status: 500 });
  }

  return redirect('/events');
}
```

### 25-deleting

```jsx
import { Link, useSubmit } from 'react-router-dom';

function EventItem({ event }) {
  const submit = useSubmit();

  function startDeleteHandler() {
    const proceed = window.confirm('Are you sure?');

    if (proceed) {
      submit(null, { method: 'delete' });
    }
  }
  // ...
 }
```
```jsx
import { useRouteLoaderData, json, redirect } from 'react-router-dom';

import EventItem from '../components/EventItem';

function EventDetailPage() {
  const data = useRouteLoaderData('event-detail');

  return <EventItem event={data.event} />;
}

export default EventDetailPage;

export async function loader({ request, params }) {
  const id = params.eventId;

  const response = await fetch('http://localhost:8080/events/' + id);

  if (!response.ok) {
    throw json(
      { message: 'Could not fetch details for selected event.' },
      {
        status: 500,
      }
    );
  } else {
    return response;
  }
}

export async function action({ params, request }) {
  const eventId = params.eventId;
  const response = await fetch('http://localhost:8080/events/' + eventId, {
    method: request.method,
  });

  if (!response.ok) {
    throw json(
      { message: 'Could not delete event.' },
      {
        status: 500,
      }
    );
  }
  return redirect('/events');
}
```
### 26-form-submission-usenavigation

```jsx
import { Form, useNavigate, useNavigation } from 'react-router-dom';

import classes from './EventForm.module.css';

function EventForm({ method, event }) {
  const navigate = useNavigate();
  const navigation = useNavigation();

  const isSubmitting = navigation.state === 'submitting';

  function cancelHandler() {
    navigate('..');
  }

  return (
    <Form method="post" className={classes.form}>
      <p>
        <label htmlFor="title">Title</label>
        <input
          id="title"
          type="text"
          name="title"
          required
          defaultValue={event ? event.title : ''}
        />
      </p>
      <p>
        <label htmlFor="image">Image</label>
        <input
          id="image"
          type="url"
          name="image"
          required
          defaultValue={event ? event.image : ''}
        />
      </p>
      <p>
        <label htmlFor="date">Date</label>
        <input
          id="date"
          type="date"
          name="date"
          required
          defaultValue={event ? event.date : ''}
        />
      </p>
      <p>
        <label htmlFor="description">Description</label>
        <textarea
          id="description"
          name="description"
          rows="5"
          required
          defaultValue={event ? event.description : ''}
        />
      </p>
      <div className={classes.actions}>
        <button type="button" onClick={cancelHandler} disabled={isSubmitting}>
          Cancel
        </button>
        <button disabled={isSubmitting}>
          {isSubmitting ? 'Submitting...' : 'Save'}
        </button>
      </div>
    </Form>
  );
}

export default EventForm;
```

### 27-validation-returning-data

```jsx
import {
  Form,
  useNavigate,
  useNavigation,
  useActionData,
} from 'react-router-dom';


const data = useActionData();
const navigate = useNavigate();
const navigation = useNavigation();

const isSubmitting = navigation.state === 'submitting';

<Form method="post" className={classes.form}>
</Form>


```


### 28-reusing-action
```jsx
children: [
          {
            index: true,
            element: <EventsPage />,
            loader: eventsLoader,
          },
          {
            path: ':eventId',
            id: 'event-detail',
            loader: eventDetailLoader,
            children: [
              {
                index: true,
                element: <EventDetailPage />,
                action: deleteEventAction,
              },
              {
                path: 'edit',
                element: <EditEventPage />,
                action: manipulateEventAction,
              },
            ],
          },
          {
            path: 'new',
            element: <NewEventPage />,
            action: manipulateEventAction,
          },
        ]
```
