# Endpoints Documentation

## Web Page Endpoints

- "/index"
- "/ourGoal"
- "/report"
- "/welcomeF"
- "/welcomeR"

## API Endpoints

- "/api/signup"
  - Description: Signs up new resident or farmer
  - HTTP method: POST
  - Expected JSON field names in request:
    - userType: "resident" | "farmer"
    - username
    - email
    - password
  - Response:
    - JSON object with message attribute
    - OK status on success
- "/login"
  - Description: Logs in resident or farmer
  - HTTP method: POST
  - Expects HTML form with following elements and name attributes correspondingly:
    - username
    - password
- "api/reportissue"
  - Description: Reports issue
  - HTTP method: POST
  - Expected JSON field names in request:
    - firstName
    - lastName
    - email
    - blockAddress
    - description
  - Response:
    - JSON object with message attribute
    - OK status on success
- "/api/toiletblocks"
  - Description: Gets list of all toilet blocks and their toilets
  - HTTP method: GET
  - Response:
    - List of all toilet blocks and their toilets
- "/api/toilet/{id}"
  - Description: Update status of toilet by its id
  - HTTP method: PUT
  - Expected JSON field names in request:
    - toiletStatus
  - Response:
    - JSON object with message attribute
    - OK status on success

