# hubino-api-creation-task

Endpoints


GET: http://localhost:8080/users/list

```
     request: 
          header: {
                    Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYwNjUxMTI2NCwiaWF0IjoxNjA2NDc1MjY0fQ.wF1EFEKbEa008GfQaY5GvfTvfGSj7E1lc8h6Ae_GhqM
                  }
            
      response:
          result: [
                      {
                          "id": 10,
                          "name": "abc",
                          "email": "abc@gmail.com",
                          "address":[
                                      {"id": 101, "city": "Chennai", "state": "Tamilnadu", "country": "India"…}
                                   ],
                           "role":{
                                  "id": 2,
                                   "rolename": "Employee"
                              },
                             "department":{
                                "id": 1002,
                                "deptname": "CSE"
                               }
                      },
                    {
                        "id": 20,
                        "name": "admin",
                        "email": "admin@gmail.com",
                        "address":[
                                {"id": 102, "city": "Madurai", "state": "Tamilnadu", "country": "India"…}
                        ],
                        "role":{
                            "id": 1,
                              "rolename": "Admin"
                          },
                          "department":{
                              "id": 1001,
                                "deptname": "ECE"
                          }
                      }
                  ]
                  
  ```                
                  
 POST : http://localhost:8080/users/register
 
    request:
        header :{
                  Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYwNjUxMTI2NCwiaWF0IjoxNjA2NDc1MjY0fQ.wF1EFEKbEa008GfQaY5GvfTvfGSj7E1lc8h6Ae_GhqM
                  Content-Type: application/json
                 }
        
        
        body :  {
                    "id": 22,
                    "name": "admin1",
                    "email": "admin1@gmail.com",
                    "password": "admin1",
                    "role":{
                          "id": 1,
                           "rolename": "Admin"
                     },
                     "department":{
                     "id": 1002,
                      "deptname": "CSE"
                      }
                   }
                   
            response: 
                  SUCCESS STATUS:200
                   
                   
 #To update/insert data from external api - http://api.ipstack.com/134.201.250.155?access_key=626053333c5203dcd83c391d63485afb              
 PUT: http://localhost:8080/users/update?param1=10&param2=134.201.250.155
 ```
    response :
        SUCCESS STATUS:200
 ```
 
 
 POST: http://localhost:8080/users/authenticate

```
      request:
             body: {
                "username":"admin",
                "password":"admin"
                }
 ```               
  ```              
      response:
              result: {
                    "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYwNjUxMTI2NCwiaWF0IjoxNjA2NDc1MjY0fQ.wF1EFEKbEa008GfQaY5GvfTvfGSj7E1lc8h6Ae_GhqM"
               }
```

