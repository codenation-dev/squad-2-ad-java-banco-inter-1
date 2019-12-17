import React, { useRef } from 'react'

// assets
import './slider.scss'

function Slider ({ children }) {
  const sliderList = useRef()
  const sliderListItem = useRef()

  function handleClick (evt) {
    const index = parseInt(evt.target.getAttribute('data-to'))
    const sliderListEl = sliderList.current
    const sliderListItemEl = sliderListItem.current
    const translate = sliderListItemEl.offsetWidth * index
    sliderListEl.style.transform = `translateX(-${translate}px)`
  }

  const sliderItems = children.map((item, index) => {
    return (
      <li key={index} ref={sliderListItem} className='slider__list-item'>
        {<item.type onClick={handleClick}></item.type>}
      </li>
    )
  })

  return (
    <div className='slider'>
      <ul ref={sliderList} className='slider__list'>
        {sliderItems}
      </ul>
    </div>
  )
}

export default Slider
