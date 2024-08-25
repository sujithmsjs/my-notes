Thinking in React

Single Responsibility principle:
- A component should ideally only do one thing.
- If it ends up growing, it should be decomposed into smaller subcomponents.


useReducer:
- React Hook that lets you add a reducer to your component.
- const [state, dispatch] = useReducer(reducer, initialArg, init?)
- Call useReducer at the top level of your component to manage its state with a reducer.
-  Each action describes a single interaction, even if that leads to multiple changes in data.
- State is read-only. Don’t modify any objects or arrays in state
- Avoiding recreating the initial state

const  createInitialState = (username) => {}
const [state, dispatch] = useReducer(reducer, username, createInitialState);
 


Updating Arrays in State:
- You should not mutate the array in react reducer or state.
- Alternatively, you can use Immer which lets you use methods from both columns.

Adding : concat, spread syntax
[value, ...arr]

Removing: filter, slice
arr.filter(...)

Update : map
Sorting : Copy the array
Reverse: 
const nextList = [...arr];
nextList.reverse();




<App>
	<AddTodo onAddTodo={handleAddTodo}/>
	<TaskList todos={todos} onChangeTodo={handleChangeTodo} onDeleteTodo={handleDeleteTodo}/>
</App>


<Task todo={todo} onChange={onChangeTodo} onDelete={onDeleteTodo} />


---

useReducer:

useReducer is a React Hook that lets you add a reducer to your component.

const [state, dispatch] = useReducer(reducer, initialArg, init?)