# BankTransactionJavaSpring
A basic bank transfer transactions between two accounts

## ROUTES FOR TESTING FROM POSTMAN

- localhost:8080/api/account/add: for adding new user with balance of zero

    - {
    "id": 2,
    "name": "Daniel Yule",
    "pin": "1010",
    "bank": "Access",
    "number": "9876856786",
    "email": "dfgfdv@fgh.com",
    "balance": 0,
    "listOfTransactions": []
}

- localhost:8080/api/transaction: for processing transactions, it can only handle online and counter transfer

    - {
    	"transferType": "ONLINE_TRANSFER",
        "sourceAccountNumber": "9876856786",
        "sourceFullName":"Kayode Seun",
        "pin": "1010",
        "destinationAccountNumber":"234567896789",
        "destinationFullName":"Daniel Yule",
        "amount":5000
    }

- localhost:8080/api/transaction/account/all: for getting list of transactions successfully processed

    -   {
        "pin": "1010",
        "sourceAccountNumber":"9876856786"
        }

- localhost:8080/api/transaction/all: for getting all processed transaction

    -

### TODOS:

- Implement api authentication (looking into java spring jwt)
