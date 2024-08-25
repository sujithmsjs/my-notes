
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




## Var key word

- NO Block scope
- Redeclarations
- Hoisting(Raising)

“var” has no block scope
“var” tolerates redeclarations
“var” variables can be declared below their use


## IIFE
immediately-invoked function expressions

(function () {})();
+function(){}();
!function(){}();


## Callback function

In JavaScript, a callback function is a function that is passed as an argument to another function and is executed after the completion of some asynchronous operation or at a later time. Callbacks are a way to handle operations that may take some time to complete, such as reading a file, making a network request, or handling user input.



