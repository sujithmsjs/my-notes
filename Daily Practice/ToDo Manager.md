# ToDo Manager


## App.js

```jsx
import React, { useReducer, useState } from "react";
import "./styles.css";

const reducer = (state, action) => {
  switch (action.type) {
    case "add":
      return [{ title: action.title, isDone: false }, ...state];
    case "toggle":
      return state.map((e, i) =>
        i !== action.index ? e : { ...e, isDone: !e.isDone }
      );
    default:
      return state;
  }
};

export default function App() {
  const [todoList, dispatch] = useReducer(reducer, [
    {
      title: "Learn React",
      isDone: false
    }
  ]);

  const [titleState, setTitle] = useState({
    value: "",
    isValid: false,
    isDirty: false
  });

  const validateTitle = (value) => {
    const isValid = value.length >= 4;
    return { value, isValid, isDirty: true };
  };

  const handleAdd = () => {
    if (titleState.isValid) {
      dispatch({ type: "add", title: titleState.value });
      setTitle({ value: "", isValid: false, isDirty: false });
    } else {
      setTitle((prev) => ({ ...prev, isDirty: true }));
    }
  };

  const handleTextField = (event) => {
    const value = event.target.value;
    setTitle(validateTitle(value));
  };

  const showError = titleState.isDirty && !titleState.isValid;

  return (
    <>
      <h1>ToDo Manager</h1>

      <input value={titleState.value} type="text" onChange={handleTextField} />

      {showError && <p>Please enter at least 4 characters</p>}

      <button onClick={handleAdd}>Add</button>
      <ul>
        {todoList.map((obj, index) => (
          <li

            style={{
              textDecoration: obj.isDone ? "line-through" : "none"
            }}

            className={obj.isDone ? "done" : ""}
            key={index}
            onClick={() => dispatch({ type: "toggle", index })}
          >
            {obj.title}
          </li>
        ))}
      </ul>
    </>
  );
}
```


```css
/* styles.css */

body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f4f4f4;
}

h1 {
  text-align: center;
  color: #333;
  padding: 20px 0;
}

input[type="text"] {
  width: 80%;
  padding: 10px;
  margin: 10px auto;
  display: block;
  font-size: 20px;
}

.log {
  padding-bottom: 10px;
  margin: 0px auto;
  display: block;
  width: 80%;
  color : cornflowerblue;
  font-size: 20px;
}

p {
  padding-bottom: 10px;
  margin: 0px auto;
  display: block;
  width: 80%;
  color: red;
  font-size: 20px;
}

input.error {
  border: solid red 3px;
}

button {
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  border: none;
  cursor: pointer;
  display: block;
  margin: 0 auto;
}

button:hover {
  background-color: #0056b3;
}

ul {
  list-style: none;
  padding: 0;
  margin: 10px;
}

li {
  background-color: #fff;
  padding: 10px;
  margin: 10px 0;
  cursor: pointer;
  border: 1px solid #ccc;
  transition: background-color 0.2s;
}

li:hover {
  background-color: #f4f4f4;
}
```