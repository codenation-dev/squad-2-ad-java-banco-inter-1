import React, { useState } from 'react'

// components
import { makeStyles } from '@material-ui/core/styles'
import InputLabel from '@material-ui/core/InputLabel'
import MenuItem from '@material-ui/core/MenuItem'
import FormHelperText from '@material-ui/core/FormHelperText'
import FormControl from '@material-ui/core/FormControl'
import Select from '@material-ui/core/Select'

// assets
import './filters.scss'

const useStyles = makeStyles(theme => ({
  formControl: {
    margin: theme.spacing(1),
    minWidth: 120,
  },
  selectEmpty: {
    marginTop: theme.spacing(2),
  },
}));

function Filters () {
  const classes = useStyles()
  const [inputValue, setInputValue] = useState({
    envType: '',
    sortType: ''
  })

  function handleChange (evt) {
    setInputValue({
      ...inputValue,
      [evt.target.name]: evt.target.value
    })
  }

  return (
    <>
      <div className='mr-3'>
        <FormControl className={classes.formControl}>
          <InputLabel id='demo-simple-select-helper-label'>Environment</InputLabel>
          <Select
            labelId='demo-simple-select-helper-label'
            id='demo-simple-select-helper'
            value={inputValue.envType}
            onChange={handleChange}
            name='envType'
          >
            <MenuItem value=''>
              <em>None</em>
            </MenuItem>
            <MenuItem value={10}>Production</MenuItem>
            <MenuItem value={20}>Test</MenuItem>
            <MenuItem value={30}>Development</MenuItem>
          </Select>
          <FormHelperText>Choose the environment type</FormHelperText>
        </FormControl>
      </div>
      <div className='mr-3'>
        <FormControl className={classes.formControl}>
          <InputLabel id='demo-simple-select-helper-label'>Sort by</InputLabel>
          <Select
            labelId='demo-simple-select-helper-label'
            id='demo-simple-select-helper'
            value={inputValue.sortType}
            onChange={handleChange}
            name='sortType'
          >
            <MenuItem value=''>
              <em>None</em>
            </MenuItem>
            <MenuItem value={10}>Date</MenuItem>
            <MenuItem value={20}>Alphabetical order</MenuItem>
          </Select>
          <FormHelperText>Choose the sorting type</FormHelperText>
        </FormControl>
      </div>
    </>
  )
}

export default Filters
