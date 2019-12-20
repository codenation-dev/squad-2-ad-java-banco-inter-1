import React from 'react'

// components
import Menu from '../../components/Menu'
import DashboardComponent from './../../components/Dashboard/Dashboard.js'

// assets
import './dashboard.scss'

function Dashboard () {
  return (
    <>
      <div style={{ background: 'gray' }} className='mb-4'>
        <Menu />
      </div>
      {/* <Chart /> */}
      <DashboardComponent />
    </>
  )
}

export default Dashboard
