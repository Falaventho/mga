/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./*.html"],
  theme: {
    screens: {
      'print': {'raw': 'print'},
      // => @media print { ... }
      
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
        'hunyadi': '#EDAE49',
        'darkraisin': '#0F0016',
        'sunglow': '#CF5802',
        'blush': '#EEE5E9',
        'darkblush': '#DAC6CF',
        'brightpurple': '#7353BA',
        'darkraisinalt': '#15001e',
      },
      fontFamily: {
        'titlefont':'IBM Plex Sans Thai',
        'copyfont': 'Roboto',
      },
    },
  },
  plugins: [],
  safelist: [{
    pattern: /(bg|text|border)-(hunyadi|darkraisin|sunglow|blush|darkblush)/
  }],
}

