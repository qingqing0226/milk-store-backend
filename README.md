# Milk Store
This is the backend of the app. Click [here](https://github.com/qingqing0226/milk-store-frontend) to go to the frontend repo.

## Background

A small local milk shop needs help desperately. Lately they started getting a lot of business, and they feel that they need a proper website to take a load off their store. The milk at this store is sold by the liter, and if you thought there was only one type of milk you are waay off! There will be several different types of milk, and this website makes sure that the customer can easily find the type they want.

## Structure of the website
- landing page:
- display all the milk products available
- has a searchbar where the user can enter a name for milk
- has a filter where the user can filter out milk by type
- Order milk page:
- click any milk card to view its details, and order milk by liter



## Technologies and languages

Java, Spring Boot, PostgreSQL, Postman

## Endpoints
- http://localhost/api/milk - get all milk  
result:  
  `[{
  "name": "Dillion's unequaled cashew milk",
  "type": "Cashew milk",
  "storage": 99,
  "id": "301d5dcf-a2a8-4a34-b26b-efcaa103963c"
  },
  {
  "name": "Monet's powerful cashew milk",
  "type": "Cashew milk",
  "storage": 27,
  "id": "1277e861-b33b-485d-b86f-400769d25a82"
  }...]`
- http://localhost/api/milk/list - post milk
- http://localhost/api/milk supply with 
`
{
    "id": "301d5dcf-a2a8-4a34-b26b-efcaa103963c",
    "storage": 10
}
`
to update the milk storage