MongoDB
--------

{ <field1>: { <operator1>: <value1> }, ... }
----
db.getCollection('case_details').find({ "priority" : "High"})

db.getCollection('case_details').find( {"status" :{$in: ["Open","Closed"]}})


db.getCollection('case_details').find( {"status" :{$in: ["Open","Closed"]}, "priority" :{$eq:"Escalated" } })



	
String POST_ALL_AGENT_DASHBOARD_TICKETS_COUNT = "/getAllAgentTicketsCount";

db.getCollection('case_details').find({ "assigned_to_ref.$id" : {$eq: ObjectId("6184fdcc68b51a7ad0cff7a9")}})