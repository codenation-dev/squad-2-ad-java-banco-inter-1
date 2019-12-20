import React, { useState, useEffect } from 'react'

// components
import Menu from '../../components/Menu'
import DashboardComponent from './../../components/Dashboard/Dashboard.js'

// assets
import './dashboard.scss'

function Dashboard ({ location }) {
  const [userInfo, setUserInfo] = useState({
    name: '',
    id: ''       
  })

  const { email, accessToken } = location.state

  useEffect(() => {
    async function getUserData () {
      const headers = new Headers()

      headers.append('Authorization', 'Bearer ' + accessToken)

      try {
        const res = await fetch(`http://localhost:8080/api/v1/user/${email}`, {
          method: 'GET',
          headers: headers
        })
        const data = await res.json()
        await setUserInfo({
          ...userInfo,
          ['name']: data.name,
          ['id']: data.id
        })
      } catch (err) {
        console.log(err)
      }
    
    }

    getUserData()
  }, [])

  return (
    <>
      <div style={{ background: 'gray' }} className='mb-4'>
        <Menu name={userInfo.name} accessToken={accessToken} />
      </div>
      <DashboardComponent id={userInfo.id} />
    </>
  )
}

export default Dashboard
