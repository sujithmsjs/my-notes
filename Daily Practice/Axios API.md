
```jsx
axios.get('/user?ID=12345')
	.then(response => { })
	.catch(error => { })
	.finally(() => { });
```


```
### Response status

config.base

data
status
statusText

### Error response

data
status
statusText
congig.method
config.url
config.data
baseURL
method
url
data
```


### HTTP METHODS
```javascript
axios.get();
axios.put();
axios.post();
axios.delete();
axios.patch();


axios.get('/user', {
    params: {
      ID: 12345
    }
  })

axios.get('/user?ID=12345')
	.then(response => { })
	.catch(error => { })
	.finally(() => { });

axios.get('/user', {
	params: {
		ID: 12345
	}
}).then().catch().finally();




const { data } = await axios.post('/user',
	{
		firstName: 'Fred',
		lastName: 'Flintstone'
	},
	{
		headers: {
			'Content-Type': 'application/json'
		}
	}
)




```





# Get all users

```jsx
import "./styles.css";
import React, { useState, useEffect } from "react";
import axios from "axios";

function App() {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    axios
      .get("https://jsonplaceholder.typicode.com/users")
      .then(function (response) {
        console.log(response.data);
        setPosts(() => [...response.data]);
      })
      .catch(function (error) {
        console.log(error.response.status);
      });
  }, []);

  return (
    <div>
      <table>
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Username</th>
            <th>Website</th>
          </tr>
        </thead>
        <tbody>
          {posts.map((e, i) => {
            return (
              <tr key={e.id}>
                <td>{e.id}</td>
                <td>{e.name}</td>
                <td>{e.username}</td>
                <td>{e.website}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
}
export default App;
```

## App.js

```jsx
import "./styles.css";
import { instance, handleAxiosError } from "./AxiosUtil";

export default function App() {
  instance
    .get("/users/10")
    .then((res) => {
      console.info("Success :)");
    })
    .catch(handleAxiosError);

  return <div className="App"></div>;
}
```

## AxiosUtil.js

```jsx
import axios from "axios";

export const instance = axios.create({
  baseURL: "https://jsonplaceholder.typicode.com",
  timeout: 2000,
  headers: { "X-Custom-Header": "foobar", name: "Sujith" }
});

export const handleAxiosError = (error) => {
  if (axios.isAxiosError(error)) {
    if (error.response) {
      const errorObj = {};
      if (error.response) {
        errorObj.type = "Response Error";
        errorObj.status = error.response.status;
        errorObj.data = error.response.data;
        errorObj.url = error.response.request.responseURL;
      } else if (error.request) {
        errorObj.type = "Request Error";
        errorObj.request = error.request;
      } else {
        errorObj.type = "Setup Error";
        errorObj.message = error.message;
      }
      console.error("Axios Error:", errorObj);
    } else {
      console.error("Request failed and no response received.");
    }
  } else {
    console.error("General error:", error.message);
  }
};
```




















