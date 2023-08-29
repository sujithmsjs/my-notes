### SessionStorage

In React, you can use the sessionStorage object, which is provided by the browser, to store and retrieve data in the session storage. Session storage allows you to store data that will be available only for the duration of a page session, meaning it will be cleared when the user closes the tab or browser.

```javascript
sessionStorage.setItem('username', 'john_doe');
const username = sessionStorage.getItem('username');
sessionStorage.removeItem('username');
sessionStorage.clear();
```

### Local Storage

Using localStorage in a React application is relatively straightforward. localStorage is a browser feature that allows you to store data as key-value pairs on the client-side, and it persists even after the browser is closed and reopened.

```javascript
localStorage.setItem('username', 'john_doe');
const username = localStorage.getItem('username');
localStorage.removeItem('username');
localStorage.clear();
```

### Cookies

In a React application, you can use cookies to store small pieces of data on the client-side, which can be sent with every HTTP request to the server. Cookies are commonly used for tasks like user authentication, tracking user preferences, and maintaining session information.

`npm install js-cookie`

```javascript
import Cookies from 'js-cookie';

Cookies.set('username', 'john_doe', { expires: 7 }); // Expires in 7 days
const username = Cookies.get('username');
Cookies.set('username', 'new_username', { expires: 7 });
Cookies.remove('username');
```

