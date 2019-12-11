import { useEffect } from 'react'

// solution that detects onClick events outside the component => https://reactjs.org/docs/accessibility.html
export default function useOnClickOutside (elementRef, toggleElement, handler) {
  useEffect(() => {
    toggleElement && window.addEventListener('click', onClickOutsideHandler)
    return () => { window.removeEventListener('click', onClickOutsideHandler) }
  }, [toggleElement])

  function onClickOutsideHandler (evt) {
    // if the element clicked is the component itself, nothing happens
    if (elementRef.current.contains(evt.target)) return

    // if the click was outside the component, then it should be closed
    handler(false)
  }
}