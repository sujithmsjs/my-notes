import axios from "axios";

const getAllUsers = async () =>{
	
	try{
	 	const response = await axios.get('https://jsonplaceholder.typicode.com/comments/12');
		//console.info(response.data);
		return response.data;
	}catch(error) {
		console.info('Error: ', error.response.status);
	}finally{
		console.info('End')
	}
}


const fun = async () =>  {
	const response = await  getAllUsers();
	console.log(response);

}

fun();