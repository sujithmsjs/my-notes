
use-form-hook

{...register("name", { required: true, maxLength: 50 })}




## Conditional rendering an element
- Conditionally rendering an element
- Conditionally Registering an element


const watchShowAge = watch("showAge", false);

{watchShowAge && (
          <>
            <label>Age</label>
            <input type="number" {...register("age", { min: 50 })} />
            {errors.age && <p>{"The number must be greater then 49"}</p>}
          </>
)}



