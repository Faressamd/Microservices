# Pet Care Microservices Frontend

## How to Run

1. Install dependencies:
   ```sh
   npm install
   ```
2. Start the app:
   ```sh
   npm start
   ```

- The app will open at http://localhost:3000
- Login with your Keycloak credentials (realm: JobBoardKeycloack, client: frontend-client)
- After login, you can call protected APIs via the Gateway.

## Requirements
- Backend stack (Keycloak, Gateway, Eureka, microservices) must be running.
- Update the API endpoint in `App.js` if your Gateway runs on a different port. 