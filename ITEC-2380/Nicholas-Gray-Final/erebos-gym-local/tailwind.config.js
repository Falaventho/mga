/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js}"],
  theme: {
      screens: {
      '2xl': {'max': '1535px'},
      // => @media (max-width: 1535px) { ... }

      'xl': {'max': '1279px'},
      // => @media (max-width: 1279px) { ... }

      'lg': {'max': '1023px'},
      // => @media (max-width: 1023px) { ... }

      'md': {'max': '767px'},
      // => @media (max-width: 767px) { ... }

      'sm': {'max': '639px'},
      // => @media (max-width: 639px) { ... }
    },
    extend: {
      colors: {
        'jonquil': '#FACD1E',
        'lace': '#FFF5E6',
        'dutch': '#E5DBB7',
        'sage': '#CAC198',
        'falu': '#7F2122',
      },
      fontFamily: {
        'titlefont':'MedievalSharp',
        'copyfont': 'GFS Didot',
      },
      dropShadow: {
        'dark': '10px 10px 10px rgba(0, 0, 0, 0.25)',
      },
    },
  },
  plugins: [],
  safelist: [{
    pattern: /(bg|text|border)-(jonquil|lace|dutch|sage|falu)/
  }],
}

