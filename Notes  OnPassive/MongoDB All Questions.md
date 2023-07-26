

String TICKET_HISTORY = "/getticketHistoryPage";
Request URL: https://ocrmdevapi.onpassive.com/api/getticketHistoryPage
Request Method: POST

{
  "productId": null,
  "category": null,
  "priority": null,
  "status": null,
  "objectId": "6184fdcc68b51a7ad0cff7a9",
  "pageNumber": 1,
  "pageSize": 10,
  "export": false,
  "ticketId": null,
  "email": null,
  "agentId": null,
  "country": null,
  "region": null,
  "excel": false
}

@PostMapping(value = { WebUrlConstants.TICKET_HISTORY, WebUrlConstants.TICKET_BACKEND_HISTORY })
public ResponseEntity<Response> getAdminTickets(@RequestBody HelperData helperDto, @RequestHeader("Authorization") String jwtToken) {
}


{
        "id": "OFOUGE000009000-O-Founders",
        "comment": "-",
        "priority": "Escalated",
        "status": "Pending",
        "subject": "OFOUGE000009000-O-Founders",
        "username": "Durga",
        "updatedDate": "Sep-15-2022 12:20:57",
        "lastupdatedDate": null,
        "createdDate": "Mar-22-2022 15:16:03",
        "userProfilePic": "https://d3ml53qlanzuye.cloudfront.net/O_FOUNDER_ORGANIC/AVTAR/avtar94.png",
        "region": "",
        "csCategory": "",
        "assigneeComments": null,
        "srNo": null,
        "closedDate": "",
        "paymentType": "no data",
        "ticketId": "OFOUGE000009000",
        "userId": "ghCCApx95hRVguZ/rRQz1A==",
        "category": "General Support",
        "agentName": "datlasiva",
        "transfer": null,
        "escalation": null,
        "product": null,
        "fileName": null,
        "userEMail": "QkZwOBsHu+BeR4HFzDJkyjzTP9inwNOSJXvbHQbvFg8=",
        "country": "Belgium",
        "startAuditTime": null,
        "isassigned": true
      }