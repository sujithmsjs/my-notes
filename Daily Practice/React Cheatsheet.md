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














