Sure, let's illustrate both BSON and EJSON formats using an example document:

Consider the following document:

```json
{
  "_id": ObjectId("61744a820a88f264fe15bcb8"),
  "name": "John Doe",
  "age": 30,
  "email": "john@example.com",
  "registered_at": ISODate("2022-10-23T08:00:00Z")
}
```

Now, let's represent this document in both BSON and EJSON formats:

1. **BSON Format**:
BSON is the primary storage format used internally by MongoDB.
It is a binary-encoded serialization of JSON-like documents.
BSON extends JSON to include additional data types such as Date, Binary Data, ObjectId, and others.
BSON is more efficient for storage and data manipulation compared to plain JSON due to its binary encoding.
It is optimized for fast read and write operations within MongoDB.

   The BSON format is binary-encoded and not directly readable as text. Below is a hexadecimal representation of the BSON document:

   ```
   5F 69 64 00 A8 D6 4B 44 61 0A 88 F2 64 FE 15 BC B8
   02 6E 61 6D 65 00 09 00 00 00 4A 6F 68 6E 20 44 6F
   65 00 10 61 67 65 00 1E 00 00 00 02 65 6D 61 69 6C
   00 6A 6F 68 6E 40 65 78 61 6D 70 6C 65 2E 63 6F 6D
   00 11 72 65 67 69 73 74 65 72 65 64 5F 61 74 00 02
   10 23 00 00 00 00
   ```

   As you can see, the BSON format is not human-readable and is optimized for efficient storage and data manipulation within MongoDB.

2. **EJSON Format**:

   EJSON is an extension of JSON and can be represented as plain text. Below is the EJSON representation of the document:

EJSON is a superset of JSON that extends the JSON format to include additional data types beyond what BSON supports.
EJSON includes data types such as Date, Binary Data, Regular Expressions, and JavaScript Code, making it more suitable for representing MongoDB documents in JavaScript-based environments.
EJSON is primarily used in MongoDB's JavaScript-based interfaces, such as the MongoDB shell and JavaScript-based drivers.
While EJSON is more expressive than BSON in terms of supported data types, it is not used as the primary storage format within MongoDB itself.


   ```json
   {
     "_id": {"$oid": "61744a820a88f264fe15bcb8"},
     "name": "John Doe",
     "age": 30,
     "email": "john@example.com",
     "registered_at": {"$date": "2022-10-23T08:00:00.000Z"}
   }
   ```

   In EJSON, special key-value pairs are used to represent additional data types such as ObjectId (`"$oid"`) and Date (`"$date"`), making it suitable for JavaScript-based environments.

Both formats represent the same document, but in different ways optimized for their specific use cases within MongoDB.