new Promise((resolve, reject) => {
})


new Promise(executor)

Intially:
state: pending
result: undefined

After Resolve: 
state: fulfilled
result: data

After Reject:
status: rejected
result: error

Note: 
The executor should call only one resolve or one reject. Any state change is final. All further calls of resolve and reject are ignored.

// resolve runs the first function in .then
promise.then(
  result => alert(result), // shows "done!" after 1 second
  error => alert(error) // doesn't run
);


promise.then(f,f).finally(f);
*f callback function


Note:  throw new Error("Whoops!"); works exactly same as reject(new Error("Whoops!"));

1. What is executor?
2. States in Promise?
3. Demonstrate only one resolve or one reject is final.
4. How many paramters Resolve and Reject have?
5. Can we access properties state and result of the Promise?
6. Write code to access the each state of Promse.
7. What are the consumer functions in Promises?
8. How many parameters does then consumer have? What type of parameters are they? Demonstrage with an example.
9. What is Cleanup function in Promise? what is the use of it?
10. What is callback function.
11. Explain about finally handler
12. What is Promises chaining?
13.
Promise: then versus catch
Are these code fragments equal? In other words, do they behave the same way in any circumstances, for any handler functions?

promise.then(f1).catch(f2);
Versus:

promise.then(f1, f2);

14. Error handling with promises






Answers:

1. The function passed to new Promise is called the executor. When new Promise is created, the executor runs automatically. It contains the producing code which should eventually produce the result.  When it is finished with the attempt, it calls resolve if it was successful or reject if there was an error.

2. state — initially "pending", then changes to either "fulfilled" when resolve is called or "rejected" when reject is called. result — initially undefined, then changes to value when resolve(value) is called or error when reject(error) is called.

5. The properties state and result of the Promise object are internal. We can’t directly access them. We can use the methods .then/.catch/.finally for that.

7. Consumers: then, catch

8. The first argument of .then is a function that runs when the promise is resolved and receives the result. The second argument of .then is a function that runs when the promise is rejected and receives the error. The first function was executed and in the case of a rejection, the second one.

9. Cleanup: finally: The idea of finally is to set up a handler for performing cleanup/finalizing after the previous operations are complete.
Ex: E.g. stopping loading indicators, closing no longer needed connections, etc.

11.
- A finally handler doesn’t get the outcome of the previous handler (it has no arguments). This outcome is passed through instead, to the next suitable handler.
- If a finally handler returns something, it’s ignored.
- When finally throws an error, then the execution goes to the nearest error handler.


12. 
- One by one, in sequence

14.

fetch(...).then(f).catch(f)





