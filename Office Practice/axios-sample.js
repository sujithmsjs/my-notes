import axios from 'axios'


const findAllUsers = async () => {
	try {
		const results = await axios.get('http://localhost:8080/api/users');
		return results.data;
	} catch (err) {
		return 'my-success-error';
	}
}

const saveUser = async (user) => {
	try {
		const results = await axios.post('http://localhost:8080/api/users', user);
		return results.data;
	} catch (err) {
		return err.response.data;
	}
}

const findUserById = async (id) => {
	try{
		const result = await axios.get(`http://localhost:8080/api/users/${id}`);
		return result.data;
	}catch(err) {
		return null;
	}
}

const deleteUserById = async (id) => {
	try{
		const result = await axios.delete(`http://localhost:8080/api/users/${id}`);
		return result.data;
	}catch(err) {
		return null;
	}
}

const 	UserById = async (id) => {
	try{
		const result = await axios.delete(`http://localhost:8080/api/users/${id}`);
		return result.data;
	}catch(err) {
		return null;
	}
}




const newUser = {
	"id": 10000,
	"name": "sujith114",
	"email": "sujith@gmail.com",
	"gender": "MALE",
	"dob": "2023-09-01",
	"city": "Hyderabad"
}

const demo2 = async () => {
	const result = await findAllUsers(10000);
	console.info(result);
}

demo2();