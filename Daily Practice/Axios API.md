
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



# Using Instance

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



```node
import axios from 'axios';

const errMsg = {
	status: 404,
	statusText: 'Not Found'
}

const fetch = () => {
	return new Promise(
		(resolve, reject) => {
			reject(errMsg);
		}
	);
}

fetch()
	.then(result => {
		console.info(result);
	}).
	catch(error => {
		console.info(error);
	});
```

```javascript
// apiService.js
import axios from 'axios';

const baseURL = 'http://localhost:9000/api'; // Your API base URL

const apiService = axios.create({
  baseURL,
  // You can set common headers or interceptors here
});

export const getMovieById = (movieId) => apiService.get(`/movies/${movieId}`);
export const updateMovieById = (movieId, movie) => apiService.put(`/movies/${movieId}`, movie);
export const deleteMovieById = (movieId) => apiService.delete(`/movies/${movieId}`);
export const saveMovie = (movie) => apiService.post(`/movies`, movie);
export const getAllMovies = () => apiService.get('/movies');
// Add more API functions here
```

```javascript
import * as movieApi from './ApiService.js'


// All users
movieApi.getAllMovies().then(results => {
	//console.info(results.data);
}).catch(error => {
	//console.info(results);
});

// Get User by ID
movieApi.getMovieById(10041).then(results => {
	console.info(results.data);
}).catch(error => {
	console.info(error.status);
});

const newMovie = {
	//id: 1,
	title: 'Sujith',
	genre: 'ACTION',
	director: 'Christopher Nolan',
	duration: 148,
	rating: 8.8,
	releaseDate: '2010-07-16',
	collection: '836.83'
}

movieApi.saveMovie(newMovie).then(results => {
	console.info(results.data);
	console.info(results);
}).catch(error => {
	console.info(error.response.data);
});

movieApi.updateMovieById(10041, newMovie).then(results => {
	console.info(results.data);
	console.info(results.status);
}).catch(error => {
	console.info(error.response.data);
});

const id = 10000;
movieApi.deleteMovieById(id).then(results => {
	console.info(results.data);
	if (results.status === 204) {
		console.info(`Your record ${id} deleted successfully.`);
	}

}).catch(error => {
	console.info(error.status);
}
);
```

### Guess the output

```javascrip
let data;
movieApi.getAllMovies().then(results => {
	console.log('Result a bit late : ', results.data.length);
	data = results.data;
}).catch(error => {
	console.info(error);
});
console.log('Result a bit early : ', data);
```









