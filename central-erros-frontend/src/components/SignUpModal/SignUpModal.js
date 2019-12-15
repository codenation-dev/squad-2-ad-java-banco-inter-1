import React, { useState } from 'react'

// components
import Popup from 'reactjs-popup'

// assets
import './signUpModal.scss'
import { MdMailOutline } from 'react-icons/md'
import { MdLockOutline } from 'react-icons/md'
import { MdPersonOutline } from 'react-icons/md'

function SignUpModal () {
  const [inputValue, setInputValue] = useState({
    name: '',
    email: '',
    password: '',
    checkPassword: ''
  })

  function handleChange (evt) {
    const value = evt.target.value
    setInputValue({
      ...inputValue,
      [evt.target.name]: value
    })
  }

  function handleSubmit(evt) {
    evt && evt.preventDefault()
    const { name, email, password } = inputValue
<<<<<<< HEAD
    console.log(name)
    console.log(email)
    console.log(password)
    // dealing with the request here...
=======
    const body = {
      name,
      email,
      password
    }

    const headers = {
      'Content-type': 'application/json'
    }

    axios.post('http://localhost:8080/api/v1/user/save', body, {
      headers: headers
    })
    .then(res => {
      console.log('response: ', res)
    })
    .catch(err => {
      console.log('error: ', err)
    })
>>>>>>> e06079877d54c1fe3effdba8f42b90e2c4170354
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
          <form id='signup-form' name='signup-form' className='login--form' onSubmit={handleSubmit}>
            <div className='row justify-content-center'>
              <div className='col-12 d-flex justify-content-center text-center mb-4'>
                <input
                  type='text'
                  className='login--form__input'
                  name='name'
                  id='name'
                  placeholder='Name'
                  value={inputValue.name}
                  onChange={handleChange}
                />
                <div className='login--icon'>
                  <MdPersonOutline />
                </div>
              </div>
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
              <div className='col-12 d-flex justify-content-center text-center mb-4'>
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
              <div className='col-12 d-flex justify-content-center text-center'>
                <input
                  type='password'
                  className='login--form__input'
                  name='passwordCheck'
                  placeholder='Type your password again'
                  id='passwordCheck'
                  value={inputValue.passwordCheck}
                  onChange={handleChange}
                />   
                <div className='login--icon'>
                  <MdLockOutline />
                </div>
              </div>
              <div className='col-12 mt-3'>
                <button className='btn btn__filled btn__filled--green mb-4' type='submit' value='Submit' form='signup-form'>Create account</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </Popup>
  )
}

export default SignUpModal
