npm install -g create-react-app
npx create-react-app my-react-app
cd my-react-app
npm start
npm run build

---


npm i bootstrap

import 'bootstrap/dist/css/bootstrap.min.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
https://source.unsplash.com/featured/300x201

---



# npm i json-server
npm i -g json-server
npm install -g json-server
(Json Server)[https://www.npmjs.com/package/json-server#getting-started]

Add to scripts:
"serve-json": "json-server --watch db.json --port 4000"

npm run serve-json

Start JSON Server:
npm run serve-json
json-server --watch db.json --port 4000

GET    /posts
GET    /posts/1
POST   /posts
PUT    /posts/1
PATCH  /posts/1
DELETE /posts/1



_page=<number>
_limit=<number>
_start=<number>
_end=<number>

_sort=<field>
_order=<desc/asc>

_expand=<entity>

entity: posts
parent field: postId
?_expand=post(Note: It sould be post not posts)

_expand=<entity>

<field>_like=<RegExp> 
<field>_gte=<value>
<field>_lte=<value>
<field>_ne=<value>

q=<internet>
?<field>=<value>&<field>=<value>...
?<field.subfield>=<value>
?<field>=<value>&<field.subfield>=<value>

GET		/users?name.fname=Sujith
GET		/users?name.lname=Gulla







_page=<number>
http://localhost:4000/comments?_page=4

Header X-Total-Count contains total size of the pages.
In the Link header you'll get first, prev, next and last links.

Example :

<http://localhost:4000/comments?_page=1&_limit=5>; rel="first",
<http://localhost:4000/comments?_page=3&_limit=5>; rel="prev",
<http://localhost:4000/comments?_page=5&_limit=5>; rel="next",
<http://localhost:4000/comments?_page=7&_limit=5>; rel="last"




_limit=<number>


_sort=<field>
GET 	/comments?_sort=body&_page=2&_limit=2
GET 	/posts/1/comments?_sort=votes&_order=asc
GET 	/posts?_sort=user,views&_order=desc,asc


Uppercase letters first, lowercase letters next

_order=<desc/asc>
GET		/comments?_sort=body&_page=2&_limit=2&_order=desc
GET		/comments?_sort=body&_page=1&_limit=2&_order=asc




_embed
_expand : An entity which contains other entity primary id can be expanded.

Example: 

Comment: Simple comment object contains postId that can be expanded.
{
	"id": 1,
    "body": "some comment",
    "postId": 1 (Hey man! expand this)
}

Expanded Comment:
{
    "id": 1,
    "body": "some comment",
    "postId": 1,
    "post": {
        "id": 1,
        "title": "json-server",
        "author": "typicode"
    }
}

```json
{
  "posts": [
    {
      "id": 1,
      "title": "json-server",
      "author": "typicode"
    }
  ],
  "comments": [
    {
      "id": 1,
      "body": "some comment",
      "postId": 1
    }
  ],
  "profile": {
    "name": "typicode"
  }
}
```

GET		/posts?_embed=comments
GET		/posts/1?_embed=comments
I was saying that EMBED Comments to Posts.






NOTE: posts to comments is ONE TO MANY relationship



```json
[
    {
        "id": 1,
        "title": "json-server",
        "author": "typicode",
        "comments": [
            {
                "id": 1,
                "body": "some comment",
                "postId": 1
            }
        ]
    }
]
```

GET		/comments?_expand=post
GET		/comments/1?_expand=post

```json
{
    "id": 1,
    "body": "some comment",
    "postId": 1,
    "post": {
        "id": 1,
        "title": "json-server",
        "author": "typicode"
    }
}
```


Operators:

Eq

GET		/comments?body=mario
GET		/todos?userId=4

Case Sensitive search

<field>_like=<RegExp> 
Case Insensitive search

GET		/comments?body_like=mario

<field>_gte
GET		/comments?id_lte=5

<field>_lte
GET		/comments?id_lte=10&id_gte=5

<field>_ne
GET		/comments?id_lte=10&id_gte=5&id_ne=8
GET		/comments?_page=7&_limit=5
GET		/comments?id=1&id=2




















---

npm i react-toastify
[Toastify](https://fkhadra.github.io/react-toastify/introduction/)
npm install --save react-toastify

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

<ToastContainer
	position="top-center"
	autoClose={5000}
	hideProgressBar
	newestOnTop={false}
	closeOnClick
	rtl={false}
	pauseOnFocusLoss
	draggable
	pauseOnHover
	theme="colored"
/>

<ToastContainer />


toast("Wow so easy!");
toast.info('')
toast.success('')
toast.warning('')
toast.error('')


---














