import React, { useState, useEffect } from 'react'

// assets
import './login.scss'

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
    <div className='login'>
      <form className='login--form' onSubmit={handleSubmit}>
        <div className='row justify-content-center'>
          <div className='col-12 text-center'>
            <input
              type='text'
              class='login--form__input'
              name='email'
              id='email'
              value={inputValue.email}
              onChange={handleChange}
            />
          </div>
          <div className='col-12 text-center'>
            <input
              type='password'
              class='login--form__input'
              name='password'
              id='password'
              value={inputValue.password}
              onChange={handleChange}
            />   
          </div>
        </div>
      </form>
    </div>
  )
}

export default Login
