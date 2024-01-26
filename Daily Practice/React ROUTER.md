# react-router-dom 


#### src\index.js

```jsx
<React.StrictMode>
    <BrowserRouter>
      <App />
     </BrowserRouter>
</React.StrictMode>
```

BrowserRouter -> Context

```jsx
import { Routes, Route } from 'react-router-dom';

<Routes>
        <Route path='/' element={<Home />} />
        <Route path='/books' element={<BookList />} />
        <Route path='/galary' element={<Galary />} />
        <Route path='/about' element={<About />} />
        <Route path='*' element={<ErrorPage />} />
</Routes>
```
### Exapmle 1
```jsx
import { Routes, Route, Link, useParams } from 'react-router-dom';

function App() {
  return (
    <div className="App">

      <h1>Welcome</h1>

      <nav>
        <ul>
          <li><Link to="/">Home </Link></li>
          <li><Link to="/books" >BookList</Link></li>
          <li><Link to="/books/new" >NewBook</Link></li>
          <li><Link to="/galary" >Galary</Link></li>
          <li><Link to="/about" >About</Link></li>
        </ul>
      </nav>

      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/books' element={<BookList />} />
        <Route path='/books/:id' element={<Book />} />
        <Route path='/books/new' element={<NewBook />} />
        <Route path='/galary' element={<Galary />} />
        <Route path='/about' element={<About />} />
        <Route path='*' element={<ErrorPage />} />
      </Routes>

    </div>
  )
}

export default App;


const Home = () => {
  return <h1>Home</h1>
}

const About = () => {
  return <h1>About</h1>
}

const Galary = () => {
  return <h1>Galary</h1>
}

const Book = () => {
  const {id} = useParams();
  return (<h1>Book {id}</h1>);
}

const NewBook = () => {
  return (<h1>NewBook</h1>);
}

const BookList = () => {
  return (
    <>
      <h1>BookList</h1>

      <nav>
        <ul>
          {
            [1, 2, 3,4,5,6,7,8,9,10].map(b =>
              <li> <Link to={`/books/${b}`}>{`Book ${b}`}</Link></li>
            )
          }
           <li> <Link to={`/books/new`}>New book</Link></li>
        </ul>
      </nav>
    </>
  );
}

const ErrorPage = () => {
  return <h1>ErrorPage: 4o4</h1>
}
```



---

Loader:

It received a object contains: request and params


const error = useRouteError();

{
     "status": 404,
     "statusText": "",
     "internal": false,
     "data": {
          "message": "Unable to fetch the user by id"
     }
}



---

Error Page:  {
     "status": 200,
     "statusText": "",
     "internal": false,
     "data": {
          "message": "Unable to fetch users list"
     }
}



The FormData interface provides a way to construct a set of key/value pairs representing form fields and their values.




Loader:

It received a object contains: request and params


useRouteError();

### const error = useRouteError();

{
     "status": 404,
     "statusText": "",
     "internal": false,
     "data": {
          "message": "Unable to fetch the user by id"
     }
}




### useNavigation()

useNavigation is a hook which gives access to navigation object. It's useful when you cannot pass the navigation prop into the component directly, or don't want to pass it in case of a deeply nested child.

useNavigation() returns the navigation prop of the screen it's inside.

state: idle, submitting, loading

1. idle: Being loaded
2. Submitting: the data to the action
3. loading: the next component

{
     "state": "submitting",
     "location": {
          "pathname": "/users/new",
          "search": "",
          "hash": "",
          "state": null,
          "key": "ypt0w1ej"
     },
     "formMethod": "post",
     "formAction": "/users/new",
     "formEncType": "application/x-www-form-urlencoded",
     "formData": {}
}

Inside UsersList:  {
     "state": "loading",
     "location": {
          "pathname": "/users/10019",
          "search": "",
          "hash": "",
          "state": null,
          "key": "h2nrk7ig"
     }
}



1xx Informational
2xx Success
3xx Redirection
4xx Client Error
5xx Server Error

200 OK
201 Created
204 No Content
400 Bad Request
401 Unauthorized
403 Forbidden
404 Not Found
409 Conflict
500 Internal Server Error

error.response.data
error.response.status
error.response.statusText

const actionData = useActionData();

const navigation = useNavigation();
const { state } = navigation;


const navigate = useNavigate();
navigate('/users');


# 27-09-2023
------------

REACT-ROUTER-DOM in 5 words

1. RouterProvider (Component)
2. createBrowserRouter (Method)
3. 


















import { RouterProvider, createBrowserRouter } from "react-router-dom";

































