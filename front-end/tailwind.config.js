/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./index.html", "./src/**/*.{vue,js}"],
  theme: {
    extend: {
      keyframes: {
        rolUp: {
          'from': {transform: 'rotate(0deg)'},
          'to': {transform: 'rotate(180deg)'}
        }
      },
      animation: {
        'rolToUp': 'rolUp .5s ease-in-out forwards'
      }
    },
  },
  plugins: [],
};
