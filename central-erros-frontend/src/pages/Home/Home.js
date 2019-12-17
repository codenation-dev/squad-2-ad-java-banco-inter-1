import React from 'react'

// components
import FormSignup from '../../components/FormSignup'
import FormSignin from '../../components/FormSignin'
import Slider from '../../components/Slider'

// assets
import './home.scss'

function Home () {
  return (
    <main className='home'>
      <section className='home__card'>
        <div className='home__card-image'>
          <h2>Central de Erros</h2>
        </div>
        <Slider>
            <FormSignup></FormSignup>
            <FormSignin></FormSignin>
        </Slider>
      </section>
    </main>
  )
}

export default Home
