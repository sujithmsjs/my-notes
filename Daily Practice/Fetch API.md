async function logMovies() {
  const response = await fetch("https://jsonplaceholder.typicode.com/users");
  const movies = await response.json();
  console.log(movies);
}

logMovies(); 


Content-Type

fetch(resource)
fetch(resource, options)

 const response = await fetch("https://example.com/profile", {
      method: "POST", // or 'PUT'
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });


const response  = await fetch(URL, {
	
	method: <method-type>

	headers: { }

	body: JSON.stringify(data);
})

const result = await response.json();