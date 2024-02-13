# User API Spec 

## Register User 
- Endpoint : POST /api/users

Request Body :
```json
{
  "username": "affodilaj",
  "password" : "secret",
  "name" : "Affodilaj Fadil"
}
```

Response Body (Sucesses): 
```json
{
  "data" : "OK"
}
```

Response Body (Failed):
```json
{
  "errors" : "Username must not blank, ???"
}
```


## Login User
- Endpoint : POST /api/auth/login

Request Body :
```json
{
  "username": "affodilaj",
  "password" : "secret"
}
```

Response Body (Sucesses):
```json
{
  "data" : {
    "token" : "TOKEN",
    "expiredAt" : 777266618217
  }
}
```

Response Body (Failed, 401):
```json
{
  "errors" : "Username or password wrong"
}
```


## Get User
- Endpoint : GET /api/user/current

Request Header : 
- X-API-TOKEN : Token (Mandatory)

Response Body (Sucesses):
```json
{
  "data" : {
    "username" :"affodilaj", 
    "name" : "Affodilaj Fadil"
  }
}
```

Response Body (Failed, 401):
```json
{
  "errors" : "Unauthorized"
}
```


## Update User 
- Endpoint : PATCH /api/user/current

Request Header :
- X-API-TOKEN : Token (Mandatory)

Request Body :

```json

{
  "name" : "Affodilaj Fadil", //put if only want to update name
  "password" : "secret" //patch if only want to update password
}
```

Response Body (Sucesses):
```json
{
  "data" : {
    "token" : "TOKEN",
    "expiredAt" : 777266618217
  }
}
```


Response Body (Failed, 401):
```json
{
  "errors" : "Username or password wrong"
}
```


## Logout User
Endpoint : DELETE /api/auth/logout

Request Header :
- X-API-TOKEN : Token (Mandatory)
  (nanti api token akan di-delete dari database)

Response Body (Sucesses):
```json
{
  "data" : "OK"
}
```