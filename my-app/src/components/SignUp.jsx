import React, { useRef, useState } from 'react'
import toast, { Toaster } from 'react-hot-toast'
import ButtonBeforeLogin from './ButtonBeforeLogin'
import ButtonAfterLogin from './ButtonAfterLogin'
import Input_layout from './Input' // Ensure the correct import path

export default function SignUp () {
  const usernameRef = useRef()
  const addressRef = useRef()
  const ageRef = useRef()
  const phoneRef = useRef()
  const postRef = useRef()
  const emailRef = useRef()

  const [sentRequestButton, setButton] = useState(false)
  const [value, setValue] = useState([
    {
      name: 'username',
      text: 'نام و نام خانوادگی',
      type: 'text',
      ref: usernameRef
    },
    {
      name: 'age',
      text: 'سن',
      type: 'number',
      ref: ageRef
    },
    {
      name: 'phoneNumber',
      text: 'شماره تلفن',
      type: 'number',
      ref: phoneRef
    },
    {
      name: 'postalCode',
      text: 'کد پستی',
      type: 'number',
      ref: postRef
    },
    {
      name: 'email',
      text: 'ایمیل',
      type: 'email',
      ref: emailRef
    }
  ])

  const handleSubmit = e => {
    e.preventDefault()
    console.log(addressRef.current.value)
  }

  return (
    <div className='m-4'>
      <form
        onSubmit={handleSubmit}
        className='max-w-md mx-auto p-4 bg-white shadow-xl rounded-lg'
      >
        <h2 className='text-2xl font-bold text-center mb-6'>ثبت نام</h2>

        {value.map((item, index) => (
          <Input_layout
            key={index} // Add a key prop for list items
            name={item.name}
            text={item.text}
            type={item.type}
            maxLen={item.maxLen} // Pass maxLen if it exists
            ref={item.ref} // Pass the ref here
          />
        ))}

        <div className='mb-4'>
          <label
            htmlFor='address'
            className='block text-sm font-medium text-gray-700'
          >
            ادرس
          </label>
          <textarea
            name='address'
            id='address'
            ref={addressRef}
            required
            onInvalid={e =>
              e.currentTarget.setCustomValidity(
                addressRef.current.value.length === 0
                  ? 'نباید خالی باشد'
                  : 'به درستی وارد کنید'
              )
            }
            className='mt-1 block w-full p-2 border border-gray-300 rounded-md focus:ring focus:ring-blue-500 focus:border-blue-500'
          ></textarea>
        </div>

        {sentRequestButton ? <ButtonAfterLogin /> : <ButtonBeforeLogin />}
      </form>
      <Toaster position='bottom-center' reverseOrder={false} />
    </div>
  )
}
