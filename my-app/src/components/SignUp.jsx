import React, { useState } from 'react';
import toast, { Toaster } from 'react-hot-toast';

export default function SignUp() {
    const error = ['نباید خالی باشد', 'به صورت درست وارد کنید']
    const [value, setValue] = useState({
        username: '',
        address: '',
        age: '',
        phoneNumber: '',
        postalCode: '',
        email: ''
    });

    const [didEdit, setDidEdit] = useState({
        username: false,
        email: false,
        address: false,
        age: false,
        phoneNumber: false,
        postalCode: false
    })

    const handleSubmit = (e) => {
        e.preventDefault();

        console.log(value);

        let flag = true;
        Object.entries(value).forEach(([key, val]) => {
            if (flag && key != 'email' && val.length === 0) {
                flag = false;
                return toast.error(error[1]);
            }
        });

        if (value.postalCode.length != 10) {
            flag = false
            return toast.error(error[1])
        }

        if (value.phoneNumber.length != 11) {
            flag = false
            return toast.error(error[1])
        }
        if (flag)
            console.log('https request...');

    }

    const handleBlur = (identifier) => {
        setDidEdit((pre) => {
            return {
                ...pre,
                [identifier]: true
            }
        })
    }

    const handleError = (identifier) => {
        return didEdit[identifier] && value[identifier].length === 0 ? error[0] : null
    }

    const handleSetValue = (e, identifier) => {
        setValue((pre) => {
            return {
                ...pre,
                [identifier]: e.target.value
            }
        })
    }

    const handleFocus = (identifier) => {
        setDidEdit((pre) => {
            return {
                ...pre,
                [identifier]: false
            }
        })
    }
    return (
        <div className='m-4'>
            <form onSubmit={handleSubmit} className="max-w-md mx-auto p-4 bg-white shadow-xl rounded-lg">
                <h2 className="text-2xl font-bold text-center mb-6">ثبت نام</h2>

                <div className="mb-4">
                    <label htmlFor="username" className="block text-sm font-medium text-gray-700">نام و نام خانوادگی</label>
                    <input
                        type="text"
                        id="username"
                        name="username"
                        placeholder='برای مثال محمدرضایی'
                        onChange={(e) => { handleSetValue(e, 'username') }}
                        onBlur={() => handleBlur('username')}
                        onFocus={() => handleFocus('username')}
                        className="mt-1 block w-full p-2 border border-gray-300 rounded-md focus:ring focus:ring-blue-500 focus:border-blue-500"
                    />
                    {
                        didEdit.username && value.username.length === 0 &&
                        (
                            <span className='text-red-700 text-[12px] mt-1 translate-x-[-10px] font-bold'>{error[0]}</span>
                        )
                    }
                </div>

                <div className="mb-4">
                    <label htmlFor="phoneNumber" className="block text-sm font-medium text-gray-700">شماره تلفن</label>
                    <input
                        type="number"
                        id="phoneNumber"
                        name="phoneNumber"
                        placeholder='برای مثال 09123456789'
                        onChange={(e) => { handleSetValue(e, 'phoneNumber') }}
                        onFocus={() => { handleFocus('phoneNumber') }}
                        onBlur={() => handleBlur('phoneNumber')}
                        className="mt-1 block w-full p-2 border border-gray-300 rounded-md focus:ring focus:ring-blue-500 focus:border-blue-500"
                    />

                    <span className='text-red-700 text-[12px] mt-1 translate-x-[-10px] font-bold'>{handleError('phoneNumber')}</span>

                    {
                        didEdit.phoneNumber && value.phoneNumber.length !== 11 && value.phoneNumber.length > 0 && !value.phoneNumber.includes("09") &&
                        (
                            <span className='text-red-700 text-[12px] mt-1 translate-x-[-10px] font-bold'>{error[1]}</span>
                        )
                    }
                </div>

                <div className="mb-4">
                    <label htmlFor="age" className="block text-sm font-medium text-gray-700">سن</label>
                    <input
                        type="number"
                        id='age'
                        name='age'
                        onChange={(e) => { handleSetValue(e, 'age') }}
                        onBlur={() => handleBlur('age')}
                        onFocus={() => handleFocus('age')}
                        className="mt-1 block w-full p-2 border border-gray-300 rounded-md focus:ring focus:ring-blue-500 focus:border-blue-500"
                    />
                    {
                        <span className='text-red-700 text-[12px] mt-1 translate-x-[-10px] font-bold'>{handleError('age')}</span>
                    }
                    {
                        didEdit.age && value.age.length > 2 &&
                        (
                            <span className='text-red-700 text-[12px] mt-1 translate-x-[-10px] font-bold'>{error[1]}</span>
                        )
                    }
                </div>

                <div className="mb-4">
                    <label htmlFor="address" className="block text-sm font-medium text-gray-700">ادرس</label>
                    <textarea
                        name="address"
                        id="address"
                        onChange={(e) => { handleSetValue(e, 'address') }}
                        onBlur={() => handleBlur('address')}
                        onFocus={() => handleFocus('address')}
                        className="mt-1 block w-full p-2 border border-gray-300 rounded-md focus:ring focus:ring-blue-500 focus:border-blue-500"
                    ></textarea>

                    <span className='text-red-700 text-[12px] mt-1 translate-x-[-10px] font-bold'>{handleError('address')}</span>


                </div>

                <div className="mb-4">
                    <label htmlFor="postalCode" className="block text-sm font-medium text-gray-700">کد پستی</label>
                    <input
                        type="number"
                        name="postalCode"
                        onChange={(e) => { handleSetValue(e, 'postalCode') }}
                        onBlur={() => handleBlur('postalCode')}
                        onFocus={() => handleFocus('postalCode')}
                        className="mt-1 block w-full p-2 border border-gray-300 rounded-md focus:ring focus:ring-blue-500 focus:border-blue-500"
                    />
                    <span className='text-red-700 text-[12px] mt-1 translate-x-[-10px] font-bold'>{handleError('postalCode')}</span>


                    {
                        didEdit.postalCode && value.postalCode.length !== 10 && value.postalCode.length > 0 &&
                        (
                            <span className='text-red-700 text-[12px] mt-1 translate-x-[-10px] font-bold'>{error[1]}</span>
                        )
                    }
                </div>

                <div className="mb-4">
                    <label htmlFor="email" className="block text-sm font-medium text-gray-700">ایمیل (اختیاری)</label>
                    <input
                        type="email"
                        id="email"
                        name="email"
                        onChange={(e) => { handleSetValue(e, 'email') }}
                        onBlur={() => handleBlur('email')}
                        onFocus={() => handleFocus('email')}
                        className="mt-1 block w-full p-2 border border-gray-300 rounded-md focus:ring focus:ring-blue-500 focus:border-blue-500"
                    />{
                        value.email.length !== 0 && !value.email.includes('@') &&
                        (
                            <span className='text-red-700 text-[12px] mt-1 translate-x-[-10px] font-bold'>فرمت ایمیل درست وارد کنید</span>
                        )
                    }
                </div>

                <button
                    type='submit'
                    className="w-full bg-blue-600 text-white font-medium py-2 rounded-md hover:bg-blue-700"
                >
                    تایید
                </button>

            </form><Toaster
                position="bottom-right"
                reverseOrder={false}
            />
        </div>
    );
}