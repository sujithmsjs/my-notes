# MongoDB Quotes Project


In MongoDB, the insert operation has been deprecated in favor of using insertOne, insertMany, or insert with the insertOne and insertMany methods being preferred. Below are examples of these variations:


db.collection('yourCollection').insertOne({ key: 'value' });


db.collection('yourCollection').insertMany([
  { key1: 'value1' },
  { key2: 'value2' },
  // additional documents
]);

db.collection('quotes').insertMany([
	{
		title: 'Title 1',
		cat : 'Cat 1',
		tags: ['t1','t2','t3']
	},
	{
		title: 'Title 2',
		cat : 'Cat 1',
		tags: ['t1','t3','t4']
	},
	{
		title: 'Title 3',
		cat : 'Cat 2',
		tags: ['t1','t2','t4']
	},
	{
		title: 'Title 4',
		cat : 'Cat 2',
		tags: ['t3','t4']
	},
	{
		title: 'Title 5',
		cat : 'Cat 1',
		tags: ['t1','t2','t4']
	},
	{
		title: 'Title 6',
		cat : 'Cat 1',
		tags: ['t1','t3','t4']
	}

]);


// Assume you have a collection named 'yourCollection' with documents containing a 'fieldName' field.

// Search for documents where 'fieldName' contains the string 'searchTerm'.
db.yourCollection.find({ fieldName: { $regex: /searchTerm/ } });

// Case-insensitive search for documents where 'fieldName' contains the string 'searchTerm'.
db.yourCollection.find({ fieldName: { $regex: /searchTerm/i } });



```java
public interface YourEntityRepository extends MongoRepository<YourEntity, String> {
    @Query("{ 'fieldName' : { $regex: ?0, $options: 'i' } }")
    List<YourEntity> findByRegexSearchTerm(String searchTerm);
	
	// or
	
	List<YourEntity> findByFieldNameIgnoreCase(@Param("searchTerm") String searchTerm);
}
```

Great! With the provided MongoDB collection structure, you can perform various queries based on different criteria. Here are a few examples:

### 1. Find documents with a specific category:

```javascript
db.quotes.find({ cat: 'Cat 1' });
```

### 2. Find documents with a specific tag:

```javascript
db.quotes.find({ tags: 't2' });
```

### 3. Find documents with a specific title:

```javascript
db.quotes.find({ title: 'Title 3' });
```

### 4. Find documents where tags include a specific value:

```javascript
db.quotes.find({ tags: 't4' });
```

### 5. Find documents where tags include multiple values:

```javascript
db.quotes.find({ tags: { $all: ['t1', 't2'] } });
```

Output:
['t1','t2']
['t1','t3','t2]
['t1','t4','t2]
['t1','t5','t2]


### 6. Find documents with a specific category and a tag:

```javascript
db.quotes.find({ cat: 'Cat 1', tags: 't3' });
```


### 7. Find documents with a specific category or a tag:

```javascript
db.quotes.find({ $or: [{ cat: 'Cat 1' }, { tags: 't3' }] });
```

### 8. Find documents where tags match any value in an array:

```javascript
db.quotes.find({ tags: { $in: ['t1', 't4'] } });
```

Output: 
[t1]
[t1,t4]
[t1,t4,t5]
[t4]


### 9. Find documents where tags do not include a specific value:

```javascript
db.quotes.find({ tags: { $ne: 't3' } });
```

### 10. Exact tags match: Only records that contains exact match of given tags in terms of count and order of tags.
db.getCollection('quotes').find({tags :  ['t1','t2','t3']  }) 
db.getCollection('quotes').find({tags :  ['t3','t2','t1']  })

**Note** Both are not same. 


These are just a few examples, and you can create more complex queries based on your specific use cases. Adjust the field names and values according to your actual data and requirements.




To find documents in the `quotes` collection that contain both 't1' and 't2' tags but do not contain the 't3' tag, you can use the `$all` and `$nin` operators. Here's the query for your requirement:

```javascript
db.quotes.find({
  tags: {
    $all: ['t1', 't2'],
    $nin: ['t3']
  }
});
```

This query uses the following operators:

- `$all`: Matches arrays that contain all elements specified in the query.
- `$nin`: Matches documents where the value of the field is not in the specified array.

So, the query above finds documents where the 'tags' field contains both 't1' and 't2' but does not contain 't3'.




MongoDB provides a variety of array operators and methods to perform operations on arrays within documents. Here's a list of some commonly used array functions in MongoDB:

### Array Operators:

1. **`$all`**: Matches arrays that contain all elements specified in the query.
   ```javascript
   db.collection.find({ field: { $all: [value1, value2] } });
   ```

2. **`$elemMatch`**: Matches documents that contain an array element with certain properties.
   ```javascript
   db.collection.find({ field: { $elemMatch: { key: value } } });
   ```

3. **`$size`**: Matches arrays with a specific number of elements.
   ```javascript
   db.collection.find({ field: { $size: 2 } });
   ```

4. **`$push`**: Adds an element to an array.
   ```javascript
   db.collection.updateOne({ _id: ObjectId('documentId') }, { $push: { field: value } });
   ```

5. **`$pull`**: Removes all occurrences of a specified value from an array.
   ```javascript
   db.collection.updateOne({ _id: ObjectId('documentId') }, { $pull: { field: value } });
   ```

6. **`$addToSet`**: Adds elements to an array only if they do not already exist in the set.
   ```javascript
   db.collection.updateOne({ _id: ObjectId('documentId') }, { $addToSet: { field: value } });
   ```

7. **`$pop`**: Removes the first or last element of an array.
   ```javascript
   db.collection.updateOne({ _id: ObjectId('documentId') }, { $pop: { field: 1 } }); // Removes last element
   ```

8. **`$each`**: Modifies `$push` and `$addToSet` to add multiple values to an array.
   ```javascript
   db.collection.updateOne({ _id: ObjectId('documentId') }, { $push: { field: { $each: [value1, value2] } } });
   ```

9. **`$slice`**: Returns a subset of an array.
   ```javascript
   db.collection.find({ _id: ObjectId('documentId') }, { field: { $slice: 2 } });
   ```

### Array Methods (Aggregation Framework):

1. **`$filter`**: Filters the elements of an array.
   ```javascript
   { $project: { filteredField: { $filter: { input: "$arrayField", as: "item", cond: { $gte: ["$$item.value", 5] } } } } }
   ```

2. **`$map`**: Applies an expression to each element in an array.
   ```javascript
   { $project: { modifiedField: { $map: { input: "$arrayField", as: "item", in: { $multiply: ["$$item", 2] } } } } }
   ```

3. **`$reduce`**: Applies an expression to each element in an array and combines them into a single value.
   ```javascript
   { $project: { reducedField: { $reduce: { input: "$arrayField", initialValue: 0, in: { $add: ["$$value", "$$this"] } } } } }
   ```

These are just a few examples, and MongoDB provides more array operators and methods that you can use based on your specific requirements. The MongoDB documentation is a valuable resource for learning more about array functions: [MongoDB Array Operators](https://docs.mongodb.com/manual/reference/operator/query-array/) and [MongoDB Aggregation Array Operators](https://docs.mongodb.com/manual/reference/operator/aggregation-array/).



4. Know the Tags and Their count

db.quotes.aggregate([
  {
    $unwind: "$tags" // Deconstruct the tags array into separate documents
  },
  {
    $group: {
      _id: "$tags", // Group by each unique tag
      count: { $sum: 1 } // Count occurrences of each tag
    }
  },
  
  {
    $project: {
      _id: 0, // Exclude _id field from the result
      tag: "$_id", // Rename _id to 'tag'
      count: 1 // Include the 'count' field
    }
  },
  { 
    $sort: { tag: 1 } // Sort by tag name in ascending order
  }
]);




5. Count Cats and their counts

db.quotes.aggregate([
  {
    $group: {
      _id: "$cat",
      count: { $sum: 1 }
    }
  },
  
  {
    $project: {
      _id: 0,
      tag: "$_id",
      count: 1
    }
  },
  { 
    $sort: { tag: 1 }
  }
]);


[{
 $match: {
  cat: 'Cat 1'
 }
}, {
 $unwind: {
  path: '$tags'
 }
}, {
 $group: {
  _id: '$tags',
  count: {
   $sum: 1
  }
 }
}, {
 $project: {
  _id: 0,
  tag: '$_id',
  count: 1
 }
}]


db.collection('proverbs').insertMany([
	{
		quote: '',
		cat : '',
		chapter: 1,
		verse: 1,
		tags: ['','','']
	}
]


There was a really one mistake I do all the time is that I would easily slip to another task aother then the one I is vital. So many times I did the same.
I need to confess that. There are only few questions that are going to ask you in the interview but the problem is I never prepare for those instead I try to improve my skill in real.
I tried to develop webside so that I could use them in the future. Today I really wanted to change this behaviour. I need to focus on essiential things instead of unwanted things.

- There should be concise plan about what you're going to learn.
- Prepare a list of tast that you're willing to do.
- Sort them by priority.
- Select first few and try to finish them.
- There should be a deal line for that.
- Try to finish it before the DEAD LINKE.
- Prepare and collect the resource before hand.
- Make a full picture in your mind even before project hasn't started.
- You must know what you're doing.

Picture the end result:
Have you ever seen the sculptor? When he first see the stonge he comes up with an idea what to do with that stone. All the sculpture already been pictured in his brain.
Likewise, you need to picture the end results so you can find out what it takes to reach that state.

Wrong turn:
So many times I like to do pleasing tasks. Coding is my favorate thing to do, however I would slide back on doing the unimportant webside and writing useless code. Trying to be the perfect.
I waste so much time and do nothing at all. I shot around the bush and never done anything. I need to break this habit.

My past mistaks:
- I used to design game by wasting my valuable times.
- I used to read book and not following it.
- I try to create application that are not useful for me at all.
- Try to seach for the methods thats not gonna useful in long run.

My friends are used to nothing but they just practice a bit of sylabol those are useful just for interview purpose. I am here trying to learn everything and stumble upon my own prefectionism.

- So whatever is important for interview learn those things only.
- Try to take help of the people those are already professionals in that field.
- Don't think that you need to know everything.
- All you need it problem solving skills.





















