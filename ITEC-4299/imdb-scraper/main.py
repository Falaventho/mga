import random
import requests
from bs4 import BeautifulSoup

# crawl IMDB Top 250 and randomly select a movie

URL = 'http://www.imdb.com/chart/top'

def main():
    response = requests.get(URL, headers={'User-Agent': 'Mozilla/5.0'})

    soup = BeautifulSoup(response.text, 'html.parser')

    #print(soup.prettify())

    movies = soup.select('.ipc-title__text')

    n_movies = len(movies)

    while(True):
        idx = random.randrange(0, n_movies)
        
        print(f'Movie: {movies[idx].text}')

        # comment the next line out to test user input with docker run -t -i
    
        user_input = input('Do you want another movie (y/[n])? ')
        if user_input != 'y':
            break
    

if __name__ == '__main__':
    main()