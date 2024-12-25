import React, { forwardRef } from 'react'

const Input_layout = forwardRef(({ text, name, type }, ref) => {
  return (
    <div className='mb-4'>
      <label htmlFor={name} className='block text-sm font-medium text-gray-700'>
        {text}
      </label>
      <input
        type={type}
        id={name}
        name={name}
        required
        onInvalid={e =>
          e.currentTarget.setCustomValidity('به درستی وارد کنید!')
        }
        ref={ref}
        className='mt-1 block w-full p-2 border border-gray-300 rounded-md focus:ring focus:ring-blue-500 focus:border-blue-500'
      />
    </div>
  )
})

export default Input_layout
