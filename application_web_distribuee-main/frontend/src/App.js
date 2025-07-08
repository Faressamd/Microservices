import React from 'react';
import { useKeycloak } from '@react-keycloak/web';
import axios from 'axios';

function App() {
  const { keycloak, initialized } = useKeycloak();
  const [apiResult, setApiResult] = React.useState(null);

  if (!initialized) {
    return <div>Loading...</div>;
  }

  const login = () => keycloak.login();
  const logout = () => keycloak.logout();

  const callApi = async () => {
    try {
      const res = await axios.get('http://localhost:8082/your-protected-endpoint', {
        headers: {
          Authorization: `Bearer ${keycloak.token}`,
        },
      });
      setApiResult(res.data);
    } catch (err) {
      setApiResult(err.message);
    }
  };

  return (
    <div style={{ padding: 32 }}>
      <h1>Pet Care Microservices Demo</h1>
      {!keycloak.authenticated ? (
        <button onClick={login}>Login with Keycloak</button>
      ) : (
        <>
          <div>
            <strong>User:</strong> {keycloak.tokenParsed?.preferred_username}
          </div>
          <button onClick={logout}>Logout</button>
          <hr />
          <button onClick={callApi}>Call Protected API</button>
          {apiResult && (
            <pre style={{ background: '#eee', padding: 16 }}>{JSON.stringify(apiResult, null, 2)}</pre>
          )}
        </>
      )}
    </div>
  );
}

export default App; 