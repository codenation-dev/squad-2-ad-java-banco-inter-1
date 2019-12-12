import React, { useState, useEffect } from 'react'

// components
import SignUpModal from './../SignUpModal'

// assets
import './login.scss'
import { MdMailOutline } from 'react-icons/md'
import { MdLockOutline } from 'react-icons/md'

function Login() {
  const [inputValue, setInputValue] = useState({
    email: '',
    password: '',
    checkbox: false
  })
  const [showModal, setShowModal] = useState(false)

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

  function toggleModal () {
    setShowModal(!showModal)
  }

  return (
    <div className='container d-flex justify-content-center'>
      <div className='login text-center'>
        <h1 className='login--title mb-4'>Login</h1>
        <form id='login-form' className='login--form' onSubmit={handleSubmit}>
          <div className='row justify-content-center'>
            <div className='position-relative'>
              <div className='col-12 d-flex text-center mb-4'>
                <input
                  type='text'
                  class='login--form__input'
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
            </div>
            <div className='position-relative'>
              <div className='col-12 d-flex text-center'>
                <input
                  type='password'
                  class='login--form__input'
                  name='password'
                  placeholder='Password'
                  id='password'
                  value={inputValue.password}
                  onChange={handleChange}
                />   
              </div>
              <div className='login--icon'>
                <MdLockOutline />
              </div>
            </div>
            <div className='col-12 d-flex align-items-center justify-content-center text-center mt-5'>
                <input
                  type='checkbox'
                  class='login--form__input'
                  name='checkbox'
                  id='checkbox'
                  value={inputValue.checkbox}
                  onChange={handleChange}
                />   
                <label htmlFor='checkbox' className='pl-2'>Remember me</label>
            </div>
            <div className='col-12 mt-3'>
              <button className='btn btn__filled btn__filled--green' type='submit' form='login-form'>Sign in</button>
            </div>
            <div className='col-12 mt-5'>
              <p>Not a member? <span className='open-modal' onClick={toggleModal}>Sign up here</span></p>
            </div>
            <SignUpModal showModal={showModal} />
          </div>
        </form>
      </div>
    </div>
  )
}

export default Login
