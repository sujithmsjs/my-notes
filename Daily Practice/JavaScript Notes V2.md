
#### Destructure nested objects in JS with alias names
```js
const person = {
  name: 'John',
  age: 30,
  address: {
    street: '123 Main St',
    city: 'New York',
    zip: '10001'
  }
};

// Destructure with alias names
const { name, age, address: { street: streetName, city: cityName, zip: zipCode } } = person;

console.log(name);       // John
console.log(age);        // 30
console.log(streetName); // 123 Main St
console.log(cityName);   // New York
console.log(zipCode);    // 10001
```

# Understanding ASYNC and AWAIT

```js
const promise = new Promise(
    (resolve, reject) => {
        setTimeout(() => {
            resolve('Done');
        }, 3_000)
    }
)

let str1 = 'No_Results';
const fun1 = () => {
    console.info('Before Promise');

    promise.then(result => {
        console.info('Done');
        str1 = result;
    })

    console.info('Str1 : ', str2);
    console.info('After Promise');
}
console.info('Str1 : ', str1);

let str2 = 'No_Results';
const fun2 = async () => {
    console.info('Before Promise');
    
    const result = await promise;
    console.info('Result: ', result);
    str2 = result;

    console.info('Str2 : ', str2);
    console.info('After Promise');
}


fun1();
fun2();
```