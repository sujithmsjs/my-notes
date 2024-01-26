const emp = {
	name : 'Sujith',
	salary : 50,
	myFun(){}
};

const std = {};


emp.status = 'Single'; // Insert
delete emp.name; // Delete
 
emp.name = 'Maximus';
emp.name = 'Victor'; // Update

emp.myname = emp.name;

//console.info(JSON.stringify(emp));
let callMe = 'name';	
console.info(emp);
console.info('Name: ' + emp.name);
console.info('Name: ' + emp['name']);
console.info('Name: ' + emp[callMe]);
console.info('Name: ' + emp.callMe); // undefined

std.title = emp.name;

console.info(JSON.stringify(emp));

std.myFun = function() {
	console.info('Inside the function');
}

console.info(JSON.stringify(std));
std.myFun(); // Invokes the function
std.myFun; // Doesn't do anything

emp.myFun = std.myFun;

emp.myFun(); 

console.info('looping...');

for(let n in emp){
	console.info(n,' ',emp[n],' ',typeof emp[n], (typeof(emp[n]) === 'string'))
}

const keys = Object.keys(emp);
console.info('Keys',keys);

const values = Object.values(emp);
console.info('Values',values);

const entries = Object.entries(emp);
console.info('Entries',entries);


const fs = require('fs');



fs.readFile('data.json', 'utf8', (err, data) => {

  if (err) {
    console.error(err);
    return;
  }

  const jsonData = JSON.parse(data);
  // Do something with the JSON data
  console.log(jsonData);
});








