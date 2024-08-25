Explain groups.$.users
In MongoDB, the positional operator ($) is used to update an element in an array based on its index or position.

In the context of the provided MongoDB record, groups.$.users represents the array of users within a specific group, where $ denotes the index or position of the matched element in the groups array.

For example, to update the second group's users with the ID 3030 and 3031, you can use the following query:

db.collection.update(
   { "groups.groupId": 2002 },
   { $set: { "groups.$.users": [3030, 3031, 3032, 3033] } }
)


db.getCollection('group_users').find({"groups.groupId" : 2001}, {"groups.$" : 1 })





db.getCollection('group_users').find({'groups' : { $exists : true} } )


db.getCollection('group_users').find(
{
        groups : { $exists : true}
}
)


db.getCollection('group_users').find(
{        'groups.groupId' : 2001 },
{        'groups.$' : 1 }
)
