const value = {
  username: false,
  email: false,
  address: false,
  age: false,
  phoneNumber: false,
  postalCode: false,
};

Object.entries(value).forEach(([key, val]) => {
  console.log(`${key}: ${val}`);
});
