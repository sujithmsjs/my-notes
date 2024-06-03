React Router Dom
------------------


npm i react-router-dom


import {
	createBrowserRouget,
	RouterProvider
	createRoutesFromElements
} from 'react-router-dom'

createBrowserRouter({
	...

})

const router = createBrowserRouter({
	{path : '/', element : < />},
	{path : '/', element : <JSX code>},
	{...}
})


function App(){
	return <RouterProvider router={router}>
}

---

Alternative approach


const routerFromElements = createRoutesFromElements(
	<Route>
		<Route path="/" element={</>}></Route>
		<Route path="/" element={</>}></Route>
	</Route>
)
const router = createBrowserRouget(routerFromElements);



---

Navigation between pages and links


import {Link} ...

<Link to="/">Home</Link>
<Link to="/products">Products</Link>


---
Layouts and Nested Routes


const router = createBrowserRouter([
{
	path : '/',
	element: <RootLayout />,
	children : [
		{
			path 	: '/',
			element : <HomePage />
		},
		{
			path 	: '/prods',
			element : <ProductsPage />
		}
	]
}

])

<Outlet> : where child routers are get rendered, it can be added to the root layout.

---

Showing error pages



const router = createBrowserRouter([
{
	path : '/',
	element: <RootLayout />,
	errorElement : <ErrorPage />
	children : [
		{
			path 	: '/',
			element : <HomePage />
		},
		{
			path 	: '/prods',
			element : <ProductsPage />
		}
	]
}

])

---
Nav link

<NavLink
		to="/"
		endA
		className={({}) => isActive? classes.active : undefined
		}
	> Home
</NavLink>


3 Props 

- to
- end
- className
---

Navigate Programatically

const navigate = useNavigate();
navigate('/products')

---

Dynamic Routes

path: '/products/:prodId'

const params = useParams();
const prodId = params.prodId;


---

Relative and Absolute Paths

Absolute Paths starts with '/', it means that it will come after the domin name.

Absolute paths:
{
	path: '/root'
	children: [
		{ path : '/' ...}
		{ path : '/products' ...}
		{ path : '/products/:prodId' ...}
	]
}

Problem with the above approch is actually child roots are not actually start with '/'

Relative Path: Relative to the currently active route path.
{
	path: '/root'
	children: [
		{ path : '' ...}
		{ path : 'products' ...}
		{ path : 'products/:prodId' ...}
	]
}

Goto to back page
<Link to="..">Back</Link>
.. go back to one level.


By default:
<Link to=".." relative='route' > Back </Link>

<Link to=".." relative='path' > Back </Link>

---

Index property

{
	path: '/root'
	children: [
		{ index : true,}
		{ path : 'products'}
		{ path : 'products/:prodId'}
	]
}


---




LOADERS



loader property

{
	path,
	element,
	loader : async () => { return data;}
}

import {useLoaderData} ...

const data = useLoaderData();

YOU CAN USE useLoaderData hook in the same level or lower level but not in the higher level.

You can use useLoaderData() in the element that's assigned to a route AND in all components that might be used inside that element.



---

Where can I added loader code:

export async function eventsLoader() {
	return data;
}

{
	path,
	element,
	loader : eventsLoader
}


---
when exactly loader will execute?

import {useNavigation} ...

const navigation = useNavigation();

if(navigate.state === 'loading'){
	...
}


---

Returning Responses in loader(s)

return data; // Generally
return new Response('Any data', {status : 201})
return response;
return await fetch(...)
return {isError: true, message : '...'}
throw {message : ''}

Fallback page :When the error was thrown, it will be handled by nearest possible error handle.

---

JSON utility error handling

import {json} ...

return json(
	{
		message : 'Could not fetch events.'
	},
	{
		status : 500
	}
)


---

Use Router Loader Data


{
	path,
	id,
	index,
	loader,
}


---

ACTIONS

import {Form}

<Form method='post'>



</Form>


export async function action({request, params}){
	const data = request.formData();
	
	data.get('title');
	data.get('images');
	data.get('data');
	
 	await fetch('', {});
	
	return redirect('/events')
}

---

Submitting data programmatically

const submit = useSubmit();
submit({}, { method : 'delete', action :'/...'})


---

const navigation = useNavigation()

navigation.state === 'submitting'


---

Validating user input

const data = useActionData();

---

import {useFetcher} from 'react-router-dom'

const fetcher =  useFetcher();

<Form>
	...
	...
</Form>
We move to the diffrent route with Form


<fetcher.Form>
	...
	...
</fetcher.Form>

We don't move to the different route with fetcher.Form

const {data, state}= fetcher;
state = idle/loading/submitting



---
479

D E F E R function

export function loader(){
	return defer({...})
}


export function loader(){
	return defer({
		events: loadEvents()
	})
}


function DemoComponent(){
	const {events} = useLoaderData();
	
	return
	<Suspense fallback={</p>Loading... </p>}>
		<Await resolve={events}>
			{
				(loadedEvents) => 
					<EventList
						events={loadedEvents}
					/>
				
			}
		</Await>
	</Suspense>
}

---

A U T H E N T I C A T I O N


- Persistence and Auto-Logout

{
	path : 'auth',
	element : <AuthPage />
}

QUERY PARAMTERS

Toggle between signup and login, that can be done using query parameters.

http://localhost:3000?mode=


const [searhchParams, setSearchParams] = useSearchparams();

const isLogin = searhchParams.get('mode') === 'login';

<Link to=`?mode=${isLogin? 'signup' : 'login'}`>

</Link>


---


const searchParams =  new URL(request.url).searchParams;

const mode = searchParams.get('mode');


{

	const resData = await response.json();
	const token = resData.token;
	localStorage.setItem('token', token);
	
	return direct('/')
}


export function getAuthToken(){
	const token = localStorage.getItem('token');
	return token;
}

---

Adding Logout


export fucntion action{
	localStorage.removeItem('token');
	return redirect('/');
}


{
	path: '/logout',
	action : logoutAction
}

<Form action='/logout'>
	<button>Logout</logout>
</Form>

---

export async function action({ request }) {
}

3 types of function endings

1. Return data
return response;

2. Return redirect
return redirect('/');

3. throw error
throw json({ message: 'Could not authenticate user.' }, { status: 500 });

---




















































































































































































































































































