- The loader will run only once when the component is initially mounted.
- A state can't be initialized twice.


 {
    path: '/',
    element: <RootLayout />,
    errorElement: <ErrorPage />,
    id: 'root',
    loader: tokenLoader
	...
	...
}

# Simple Auth without axios

- tokenLoader will return a string token to the root component.
	- In side tokenLoader
		- If token is not present, return null.
		- If present, check expire data.
		- If it is expred return 'Expired' or else 'Token'
	
- RootLayout will received the Token from tokenLoader using useLoaderData.
	- Inside useEffect when token is changed.
		- If token is present, nothing to do.
		- If token is expired, call logout.
		- If token is not expire, setTimeout.
		- When Time is out, call logout/refresh token.


- Inside Login Page
	- Firstly get action data using useActionData hook. You may receive a error string from the submitted form.
	- When button is clicked it will call the loginAction.
		- Inside Login Action
			- Received username and password
			- Call login API
			- API Response can be 200, 401 or 500.
				- 200: Received token will be set into Local storage, redirect to home page.
				- 401: Incorrect credential message will be return.
				- 500: Timeout message string will be return.


- Inside Logout Action
	- Simply remove token and expiredate from the local storage.
	- And redirect to home page.
	
	

+++++++++++++++++++++++++
# Simple Auth without axios
+++++++++++++++++++++++++
> Sujith manchala

You need to explain in this format, don't write code. How to implement authentical, refresh token, logout and login by using useContext hook, react-route-dom, axios.


- tokenLoader will return a string token to the root component.
	- In side tokenLoader
		- If token is not present, return null.
		- If present, check expire data.
		- If it is expred return 'Expired' or else 'Token'

- RootLayout will received the Token from tokenLoader using useLoaderData.
	- Inside useEffect when token is changed.
		- If token is present, nothing to do.
		- If token is expired, call logout.
		- If token is not expire, setTimeout.
		- When Time is out, call logout/refresh token.


- Inside Login Page
	- Firstly get action data using useActionData hook. You may receive a error string from the submitted form.
	- When button is clicked it will call the loginAction.
		- Inside Login Action
			- Received username and password
			- Call login API
			- API Response can be 200, 401 or 500.
				- 200: Received token will be set into Local storage, redirect to home page.
				- 401: Incorrect credential message will be return.
				- 500: Timeout message string will be return.


- Inside Logout Action
	- Simply remove token and expiredate from the local storage.
	- And redirect to home page.
	
	
loginComponent
loginAction
loginAPI
doLogin







