import React, { useState } from 'react'

// components
import TextField from '@material-ui/core/TextField';
import SearchIcon from '@material-ui/icons/Search';

// assets
import './formFilter.scss'

function FormFilter () {
  const [formFilter, setFormFilter] = useState('')

  function handleChange (evt) {
    setFormFilter(evt.target.value)
  }

  return (
    <>
      <div className='position-relative'>
        <TextField
          style={{ width: '100%' }}
          id='filled-search'
          label='Search field'
          type='search'
          variant='filled'
          name='formFilter'
          onChange={handleChange}
          value={formFilter}
        />
        <div className='search-icon'>
          <SearchIcon style={{ fontSize: 30 }} />
        </div>
      </div>
    </>
  )
}

export default FormFilter
