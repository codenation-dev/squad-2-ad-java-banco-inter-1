import React, { useState } from 'react'
import { withRouter } from "react-router-dom"

// components
import Button from '@material-ui/core/Button'
import MaterialMenu from '@material-ui/core/Menu'
import MenuItem from '@material-ui/core/MenuItem'
import Fade from '@material-ui/core/Fade'
import { logout } from './../../services/auth'

// icons
import AccountCircleIcon from '@material-ui/icons/AccountCircle';

function Menu ({ history }) {
  const [anchorEl, setAnchorEl] = useState(null)
  const open = Boolean(anchorEl)

  function handleClick (evt) {
    setAnchorEl(evt.currentTarget)
  }

  function handleClose () {
    logout()
    history.push('/')
  }

  function handleMenuClose () {
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
            onClose={handleMenuClose}
            TransitionComponent={Fade}
          >
            <MenuItem onClick={handleClose}>Logout</MenuItem>
          </MaterialMenu>
        </div>
      </div>
    </div>
  )
}

export default withRouter(Menu)
