import React, { useRef, useState, useEffect } from 'react';
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

  useEffect(() => {
    signinUser()
  }, [formMessage])

  function handleChange (evt) {
    const name = evt.target.name
    const value = evt.target.value

    setInputValue({
      ...inputValue,
      [name]: value
    })
  }

  function validateField () {
    const { email, password } = inputValue
    let formMsg = formMessage
    let emailValid = /^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i.test(email)
    let passwordValid = password.length >= 4

    if (!emailValid) {
      formMsg = 'Invalid e-mail field.'
    } else if (!passwordValid) {
      formMsg = 'The password is too short'
    } else {
      formMsg = '';
    }

    setFormMessage(formMsg)
  }

  function handleSubmit (evt) {
    evt && evt.preventDefault()
    validateField()
  }

  function signinUser () {
    const { email, password } = inputValue

    const form = new FormData();
    form.append("grant_type", "password")
    form.append("username", "hyalen.neves@gmail.com")
    form.append("password", "hyalen")

    const session_url = 'http://localhost:8080/oauth/token'
    const basicAuth = 'Basic ' + btoa('centralerros' + ':' + 'centralerros')

    if(formMessage === '') {
      axios.post(session_url, form, {
        headers: {
          'Authorization': + basicAuth,
          'cache-control': 'no-cache',
          'postman-token': 'c698c8ae-204e-6966-7ee5-fdfd9117e97d'
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