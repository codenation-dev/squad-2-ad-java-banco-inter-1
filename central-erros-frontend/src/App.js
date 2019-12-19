import React, { Suspense, lazy, useEffect } from 'react';
import { BrowserRouter as Router, Route, Redirect } from 'react-router-dom'
import { isAuthenticated, logout } from "./services/auth"

// components
import PrivateRoute from './PrivateRoute'

const Home = lazy(() => import ('./pages/Home'))
const Dashboard = lazy(() => import ('./pages/Dashboard'))

function App() {

  useEffect(() => {
    logout()
  }, [])

  return (
    <Router basename={process.env.PUBLIC_URL}>
      <Suspense fallback={<div>Loading...</div>}>
        <HomeRoute exact path='/' component={Home} />
        <PrivateRoute exact path='/dashboard' component={Dashboard} />
      </Suspense>
    </Router>
  );
}

const HomeRoute = ({ component: Component, ...rest }) => {
  return(
    <Route
      {...rest}
      render={props =>
        isAuthenticated() ? (
          <Redirect to='/dashboard' />
        ) : (
          <Component {...props} />
        )
      }
    />
  )  
}

export default App;
