import React, { useRef, useState, useEffect } from 'react'
import axios from 'axios'
import { withRouter } from 'react-router-dom'

import './formSignUp.scss'

function FormSignup ({ onClick }) {
  const buttonLogin = useRef()
  const messageSignup = useRef()
  const [formSubmit, setFormSubmit] = useState(false)
  const [inputValue, setInputValue] = useState({
    name: '',
    email: '',
    password: '',
    formMessage: ''
  })

  useEffect(() => {
    registerUser()
  }, [inputValue.formMessage])

  function registerUser () {
    const { name, email, password } = inputValue
    const body = {
      name,
      email,
      password
    }

    const headers = {
      'Content-type': 'application/json'
    }

    if(inputValue.formMessage === '') {
      // salvando o usuario
      axios.post('http://localhost:8080/api/v1/user/save', {body}, {
        headers: headers
      }).then(res => {
        buttonLogin.current.click()
      })
      .catch(err => {
        setInputValue({
          ...inputValue,
          ['formMessage']: 'Something went wrong.'
        })
      })
    } else {
      showMessage()
    }
  }

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
    validateField()
  }

  function validateField () {
    const { formMessage, name, email, password } = inputValue
    let formMsg = formMessage
    let nameValid = /^[a-zA-Z ]{2,30}$/.test(name)
    let emailValid = /^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i.test(email)
    let passwordValid = password.length >= 4;

    if (!nameValid) {
      formMsg = 'Invalid name.'
    }  else if (!emailValid) {
      formMsg = 'Invalid e-mail field.'
    } else if (!passwordValid) {
      formMsg = 'The password is too short.'
    } else {
      formMsg = '';
    }

    setInputValue({
      ...inputValue,
      ['formMessage']: formMsg
    })
  }

  function showMessage (callbackSuccess) {
    const msg = messageSignup.current
    msg.classList.add('active')
    setTimeout(() => {
      msg.classList.remove('active')
      if (callbackSuccess) {
        callbackSuccess()
      }
    }, 2000)
  }

  return (
    <div className='signup'>
      <header>
        <h3>Sign Up</h3>
        <button ref={buttonLogin} data-to='1' onClick={onClick}>Log In</button>
      </header>
      <form className='form-signup' onSubmit={handleSubmit} method='post'>
        <div className='form-signup__item'>
          <label htmlFor=''>Name</label>
          <input type='text' name='name' onChange={handleChange} />
        </div>
        <div className='form-signup__item'>
          <label htmlFor=''>E-mail</label>
          <input type='email' name='email' onChange={handleChange} />
        </div>
        <div className='form-signup__item'>
          <label htmlFor=''>Password</label>
          <input type='password' name='password' onChange={handleChange} />
        </div>
        <input className='form-signup__submit' type='submit' name='Cadastrar' value='Create account' />
      </form>
      <p ref={messageSignup} className={'form-signup__message'}>{inputValue.formMessage}</p>
    </div>
  )
}


export default withRouter(FormSignup)
