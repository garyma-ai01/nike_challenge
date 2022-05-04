### shoe store remark
1. implemented V1.0 endpoint
2. added test case coverage

###Endpoint (this api will random calculate the result based on the current price)
V1.0 - /shoe/{research}


### Request - 
curl --location --request GET 'http://localhost:8080/shoe/Nike'


### response
{
"shoes": [
{
"model": " Nike Air Max 95 SE",
"curPrice": 179,
"tips": "Can wait for discount"
},
{
"model": " Nike Air Max 97 SE",
"curPrice": 52,
"tips": "Moderate state, can buy now!"
},
{
"model": " Nike Air Max Pre-Day",
"curPrice": 241,
"tips": "Can wait for discount"
},
{
"model": " Nike Air Max 270",
"curPrice": 59,
"tips": "Best time to buy"
},
{
"model": " Nike Renew Ride 3",
"curPrice": 238,
"tips": "Can wait for discount"
},
{
"model": " Nike Air Max 90",
"curPrice": 105,
"tips": "Best time to buy"
}
]
}


#UI - enter point - http://localhost:8080/index.html

