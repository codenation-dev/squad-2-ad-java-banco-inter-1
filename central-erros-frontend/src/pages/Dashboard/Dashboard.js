import React from 'react'

// components
import Menu from '../../components/Menu'
import Filters from '../../components/Filters'
import FormFilter  from '../../components/Filters/FormFilter'
import Table from './../../components/Table'

// assets
import './dashboard.scss'

function Dashboard () {
  return (
    <>
      <div style={{ background: 'gray' }} className='mb-4'>
        <Menu />
      </div>
      <div className='container'>
        <div className='row align-items-center mb-5'>
          <div className='col-12 col-lg-6 d-flex mb-4'>
            <Filters />
          </div>
          <div className='col-12 col-lg-6'>
            <FormFilter />
          </div>
        </div>
        <div className='row'>
          <div className='col-12'>
            <Table />
          </div>
        </div>
      </div>
    </>
  )
}

export default Dashboard
