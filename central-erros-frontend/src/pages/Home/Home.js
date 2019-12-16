import React, { useState } from 'react'
import axios from 'axios'

// components
import SignUpModal from './../../components/SignUpModal'

// assets
import './home.scss'
import { MdMailOutline } from 'react-icons/md'
import { MdLockOutline } from 'react-icons/md'

// context
import { useAuth } from './../../context/auth'

function Home () {
  const [inputValue, setInputValue] = useState({
    email: '',
    password: '',
    checkbox: false
  })
  const { setAuthTokens } = useAuth()

  function handleChange (evt) {
    const value = evt.target.type === 'checkbox' ? evt.target.checked : evt.target.value
    setInputValue({
      ...inputValue,
      [evt.target.name]: value
    })
  }

  function handleSubmit (evt) {
    evt && evt.preventDefault()
    // const { email, password } = inputValue   

    // axios.post('http://localhost:8080/oauth/token',
    //   {
    //     grant_type: 'password',
    //     username: email,
    //     password: password
    //   }
    // )
    // .then(res => {
    //   console.log('response: ', res)
    // })
    // .catch(err => {
    //   console.log('error: ', err)
    // })
  }

  return (
    <main className='main'>
      <div className='container d-flex justify-content-center'>
        <div className='login text-center'>
          <h1 className='login--title mb-4'>Login</h1>
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
              <div className='col-12 d-flex align-items-center justify-content-center text-center mt-5'>
                  <input
                    type='checkbox'
                    name='checkbox'
                    id='checkbox'
                    value={inputValue.checkbox}
                    onChange={handleChange}
                  />   
                  <label htmlFor='checkbox' className='pl-2'>Remember me</label>
              </div>
              <div className='col-12 mt-3'>
                <button className='btn btn__filled btn__filled--green mb-4' type='submit' form='login-form'>Sign in</button>
              </div>
            </div>
          </form>
          <div className='row'>
            <div className='col-12'>
              <SignUpModal />
            </div>
          </div>
        </div>
      </div>
    </main>
  )
}

export default Home
