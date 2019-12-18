import React, { useRef, useState } from 'react';
import axios from 'axios'

// assets
import './style.scss';

function FormSignin ({ onClick }) {
  const messageSignin = useRef()
  const [formMessage, setFormMessage] = useState('')
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

    const form = new FormData();
    form.append("grant_type", "password")
    form.append("username", email)
    form.append("password", password)
    console.log(email)
    console.log(password)
    const session_url = 'http://localhost:8080/oauth/token'
    const basicAuth = 'Basic ' + btoa('centralerros' + ':' + 'centralerros')
    if (formMessage === '') {
      axios.post(session_url, form, {
        headers: {
          'Authorization': + basicAuth
        }
      }).then(res => {
        console.log('redirecting to the dashboard route: ', res)
      })
      .catch(err => {
        setFormMessage('Something went wrong.')
      })
    } else {
      showMessage()
    }
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

export default FormSignin