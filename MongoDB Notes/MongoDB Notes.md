db.getCollection('agent_details').find({"status" : "Active"}).count()

---

db.getCollection('agent_details').find({"first_name" :  { $gt : "Geetha"}}).count()

--

db.getCollection('agent_details').find({"first_name" :  { $gt : "Geetha"}},{"_id" : 1, "first_name" : 1, "last_name" : 1})

--
Query Selectors
https://www.mongodb.com/docs/manual/reference/operator/query/

Comparison
$eq, $gt, $lt, $gte, $lte, $ne, $in, $nin

Logical
$and, $or, $not, $nor



--



Depending on the number of stages you have, the latter option might get illegible fairly quickly. In general, it helps to break the stages down in new lines for readability.

@Aggregation(pipeline = {
        "{'$match':{'transaction_type': #{#transactionType}, 'price' : {$gt : #{#price}}}",
})
List<Property> findPropertiesByTransactionTypeAndPriceGTNamed(@Param("transactionType") String transactionType, @Param("price") int price);

The latter is, admittedly, more verbose, but it does allow you to mix the order of parameters.








@Aggregation(pipeline = {
        "{'$match':{'transaction_type':?0, 'price': {$gt: ?1} }}",
        "{'$sample':{size:?2}}",
        "{'$sort':{'area':-1}}"
})
List<Property> findPropertiesByTransactionTypeAndPriceGT(String transactionType, int price, int sampleSize);