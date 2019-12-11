import React, { useState, useEffect } from 'react'

// assets
import './login.scss'
import { MdMailOutline } from 'react-icons/md'
import { MdLockOutline } from 'react-icons/md'

function Login() {
  const [inputValue, setInputValue] = useState({
    email: '',
    password: ''
  })

  function handleChange (evt) {
    setInputValue({
      ...inputValue,
      [evt.target.name]: evt.target.value
    })
  }

  function handleSubmit(evt) {
    evt && evt.preventDefault()
  }

  return (
    <div className='container d-flex justify-content-center'>
      <div className='login text-center'>
        <h1 className='login--title mb-5'>Login</h1>
        <form className='login--form' onSubmit={handleSubmit}>
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
          </div>
        </form>
      </div>
    </div>
  )
}

export default Login
