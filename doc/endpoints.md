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
    - userType
    - username
    - email
    - password
  - Response:
    - JSON object with message attribute
    - OK status on success
- "/api/login"
  - Description: Logs in resident or farmer
  - HTTP method: POST
  - Expected JSON field names in request:
    - userType
    - username
    - password
  - Response:
    - JSON object with message attribute
    - OK status on success
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

