Blob

- Immutable object
- Raw data
- Text/Binary


const obj = { hello: "world" };
const blob = new Blob([JSON.stringify(obj, null, 2)], {
  type: "application/json",
});

props
size
type

methods

