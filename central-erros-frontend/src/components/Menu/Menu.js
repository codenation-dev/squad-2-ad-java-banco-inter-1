import React, { useState } from 'react'

// components
import Button from '@material-ui/core/Button'
import MaterialMenu from '@material-ui/core/Menu'
import MenuItem from '@material-ui/core/MenuItem'
import Fade from '@material-ui/core/Fade'

// icons
import AccountCircleIcon from '@material-ui/icons/AccountCircle';

function Menu () {
  const [anchorEl, setAnchorEl] = useState(null)
  const open = Boolean(anchorEl)

  function handleClick (evt) {
    setAnchorEl(evt.currentTarget)
  }

  function handleClose () {
    setAnchorEl(null)
  }

  return (
    <div className='container py-3'>
      <div className='row'>
        <div className='col-12 d-flex justify-content-end align-items-center'>
          <p className='mr-3'>Welcome, Hyalen! Your token is <strong>AdKadJhb3338103</strong></p>
          <Button aria-controls="fade-menu" aria-haspopup="true" onClick={handleClick}>
            <AccountCircleIcon style={{ fontSize: 40 }} />
          </Button>
          <MaterialMenu
            id="fade-menu"
            anchorEl={anchorEl}
            keepMounted
            open={open}
            onClose={handleClose}
            TransitionComponent={Fade}
          >
            <MenuItem onClick={handleClose}>Profile</MenuItem>
            <MenuItem onClick={handleClose}>My account</MenuItem>
            <MenuItem onClick={handleClose}>Logout</MenuItem>
          </MaterialMenu>
        </div>
      </div>
    </div>
  )
}

export default Menu
