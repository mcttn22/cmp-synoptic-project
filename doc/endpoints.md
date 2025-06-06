# Endpoints Documentation

## Web Page Endpoints

- "/index"
- "/ourGoal"
- "/report"
- "/welcomeF"
- "/welcomeR"

## API Endpoints

- "/api/signup/resident"
  - Description: Signs up new resident
  - HTTP method: POST
  - Expected JSON field names in request:
    - username
    - password
    - fullName
    - address
  - Response:
    - JSON object with message attribute
    - OK status on success
- "/api/login/resident"
  - Description: Logs in resident
  - HTTP method: POST
  - Expected JSON field names in request:
    - username
    - password
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

