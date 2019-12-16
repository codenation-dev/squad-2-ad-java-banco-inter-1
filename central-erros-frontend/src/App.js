import React, { useState, Suspense, lazy } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom'
import { AuthContext } from './context/auth'

// components
import PrivateRoute from './PrivateRoute'

const Home = lazy(() => import ('./pages/Home'))
const Dashboard = lazy(() => import ('./pages/Dashboard'))

function App() {
  const [authToken, setAuthToken] = useState(true)

  const setToken = (data) => {
    localStorage.setItem('tokens', JSON.stringify(data))
    setAuthToken(data)
  }

  return (
    <AuthContext.Provider value={{ authToken, setAuthToken: setToken }}>
      <Router basename={process.env.PUBLIC_URL}>
        <Suspense fallback={<div>Loading...</div>}>
          <Route exact path='/' component={Home} />
          <PrivateRoute path='/dashboard' component={Dashboard} />
        </Suspense>
      </Router>
    </AuthContext.Provider>
  );
}

export default App;
