import React, { useState } from 'react'

// components
import Popup from 'reactjs-popup'

// assets
import './signUpModal.scss'
import { MdMailOutline } from 'react-icons/md'
import { MdLockOutline } from 'react-icons/md'

function SignUpModal () {
  const [inputValue, setInputValue] = useState({
    email: '',
    password: '',
    checkbox: false
  })

  function handleChange (evt) {
    const value = evt.target.type === 'checkbox' ? evt.target.checked : evt.target.value
    setInputValue({
      ...inputValue,
      [evt.target.name]: value
    })
  }

  function handleSubmit(evt) {
    evt && evt.preventDefault()
    // dealing with the request here...
  }

  return (
    <Popup
      trigger={<button className="btn btn__filled btn__filled--blue">Not a member? Sign up here!</button>}
      modal
      closeOnDocumentClick
    >
      <div className='container d-flex justify-content-center'>
        <div className='login text-center'>
          <h1 className='login--title mb-4'>Create your account</h1>
          <form id='login-form' className='login--form' onSubmit={handleSubmit}>
            <div className='row justify-content-center'>
              <div className='col-12 d-flex justify-content-center text-center mb-4'>
                <input
                  type='text'
                  className='login--form__input'
                  name='email'
                  id='email'
                  placeholder='E-mail'
                  value={inputValue.email}
                  onChange={handleChange}
                />
                <div className='login--icon'>
                  <MdMailOutline />
                </div>
              </div>
              <div className='col-12 d-flex justify-content-center text-center'>
                <input
                  type='password'
                  className='login--form__input'
                  name='password'
                  placeholder='Password'
                  id='password'
                  value={inputValue.password}
                  onChange={handleChange}
                />   
                <div className='login--icon'>
                  <MdLockOutline />
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </Popup>
  )
}

export default SignUpModal
