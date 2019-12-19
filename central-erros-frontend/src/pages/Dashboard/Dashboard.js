import React from 'react'

// components
import Menu from '../../components/Menu'
import Chart from './../../components/Chart/Chart.js'
import DashboardComponent from './../../components/Dashboard/Dashboard.js'
import Deposits from './../../components/Deposits/Deposits.js'
import { mainListItems } from './../../components/ListItems/ListItems'
import Orders from './../../components/Orders/Orders'
import Title from './../../components/Title/Title'

// assets
import './dashboard.scss'

function Dashboard () {
  return (
    <>
      <div style={{ background: 'gray' }} className='mb-4'>
        <Menu />
      </div>
      <Chart />
      {/* <DashboardComponent />
      <Deposits /> */}
    </>
  )
}

export default Dashboard
