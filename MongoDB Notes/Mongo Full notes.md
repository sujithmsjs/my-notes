

Insert Documents


db.collection.insertOne()
db.collection.insertMany()



---
# Insert a Single Document
## insertOne

Syntax:

db.collection.insertOne(
   <document>,
   {
      writeConcern: <document>
   }
)

Example:

db.role.insertOne(
{
            "name" : "TL",
            "mod" : [100, 101, 102]
}

)

Explanation:
Inserts only one Document even if there were multiple documents.



---
# Insert Multiple Documents
## insertMany

Example:

db.role.insertMany([
{
            "name" : "Sujith",
            "mod" : [100, 101, 102]
},
{
            "name" : "Admin",
            "mod" : [100, 101, 102]
},
{
            "name" : "Manager",
            "mod" : [100, 101, 102]
}
]
)
	
---
db.collection.updateOne() when used with the upsert: true option.





db.collection.updateMany() when used with the upsert: true option.
db.collection.findAndModify() when used with the upsert: true option.
db.collection.findOneAndUpdate() when used with the upsert: true option.
db.collection.findOneAndReplace() when used with the upsert: true option.
db.collection.bulkWrite()
db.collection.replaceOne()

---

db.getCollection('inventory2').aggregate(
[
    {
        $unwind :
            {
                path: "$sizes",
                includeArrayIndex: "sno",
                preserveNullAndEmptyArrays: true 
            }
    }
]
)