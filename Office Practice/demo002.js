import * as movieApi from './ApiService.js'
import axios from 'axios';

let data;



async function fetchData() {
	try {
		const response = await axios.get('http://localhost:9000/api/movies');
		return response.data;
	} catch (error) {
		console.error(error);
		return null;
	}
}

data = fetchData();
console.log('Result a bit early : ');

