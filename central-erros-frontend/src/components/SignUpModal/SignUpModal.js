import React from 'react'

// assets
import './signUpModal.scss'

function SignUpModal ({ showModal }) {
  return (
    showModal
      ? (
        <div className='modal'>

        </div>
      )
      : ''
  )
}

SignUpModal.defaultProps = {
  showModal: false
}

export default SignUpModal
