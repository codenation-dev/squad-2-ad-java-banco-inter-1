import React, { useRef, useState } from 'react'
import base64 from 'base-64'
import { withRouter } from "react-router-dom"
import { login } from "./../../services/auth"

// assets
import './style.scss';

function FormSignin ({ onClick, history }) {
  const messageSignin = useRef()
  const [formMessage, setFormMessage] = useState('Something went wrong.')
  const [inputValue, setInputValue] = useState({
    email: '',
    password: ''
  })

  function handleChange (evt) {
    const name = evt.target.name
    const value = evt.target.value

    setInputValue({
      ...inputValue,
      [name]: value
    })
  }

  function handleSubmit (evt) {
    evt && evt.preventDefault()
    signinUser()
  }

  function signinUser () {
    const { email, password } = inputValue
    const centralPass = 'centralerros'
    const centralUser = 'centralerros'
    let form = new FormData()
    let headers = new Headers()

    form.append("grant_type", "password")
    form.append("username", email)
    form.append("password", password)

    headers.append('Authorization', 'Basic ' + base64.encode(centralUser + ":" + centralPass))

    fetch('http://localhost:8100/oauth/token', {
      method: 'POST',
      headers: headers,
      body: form
    })
    .then(response => response.json())
    .then(json => {
      login(json.access_token)
      history.push('/dashboard')
    })
    .catch((err) => {
      showMessage()
    })
  }

  function showMessage (callbackSuccess) {
    const msg = messageSignin.current
    msg.classList.add('active')
    setTimeout(() => {
      msg.classList.remove('active')
      if (callbackSuccess) {
        callbackSuccess()
      }
    }, 2000)
    setFormMessage('')
  }

  return (
    <div className='signin'>
      <header>
        <h3>Sign In</h3>
        <button data-to='0' onClick={onClick}>Create Account</button>
      </header>
      <form className='form-signin' onSubmit={handleSubmit} method='post'>
        <div className='form-signin__item'>
          <label htmlFor=''>E-mail</label>
          <input type='email' name='email' onChange={handleChange} />
        </div>
        <div className='form-signin__item'>
          <label htmlFor=''>Password</label>
          <input type='password' name='password' onChange={handleChange} />
        </div>
        <input className='form-signin__submit' type='submit' name='Acessar' value='Log in' />
        <p ref={messageSignin} className={'form-signin__message'}>{formMessage}</p>
      </form>
    </div>
  )
}

export default withRouter(FormSignin)