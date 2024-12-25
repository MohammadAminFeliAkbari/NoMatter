export default function ButtonAfterLogin () {
  return (
    <div className='text-center flex justify-center items-center gap-3 w-full bg-blue-600 text-white font-medium py-2 rounded-md hover:bg-blue-700 '>
      <div
        className='inline-block h-8 w-8 animate-spin rounded-full border-4 border-solid border-current border-r-transparent align-[-0.125em] text-primary motion-reduce:animate-[spin_1.5s_linear_infinite]'
        role='status'
      >
        <span className='!absolute !-m-px !h-px !w-px !overflow-hidden !whitespace-nowrap !border-0 !p-0 ![clip:rect(0,0,0,0)]'></span>
      </div>
      <span>در حال وارد شدن</span>
    </div>
  )
}
