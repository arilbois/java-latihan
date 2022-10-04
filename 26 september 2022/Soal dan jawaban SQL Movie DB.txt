1.Write a query in SQL to find the name of all reviewers who have rated their ratings with a NULL value.

SELECT rev_name 
FROM reviewer 
INNER JOIN rating
ON reviewer.rev_id = rating.rev_id
WHERE num_o_ratings IS NULL 

2.Write a query in SQL to list the first and last names of all the actors who were cast in the movie 'Annie Hall', and the roles they played in that production.

SELECT actor.act_fname, actor.act_lname,movie.mov_title, movie_cast.role 
FROM actor
INNER JOIN movie_cast
ON movie_cast.act_id = actor.act_id
INNER JOIN movie
ON movie.mov_id = movie_cast.mov_id
WHERE movie.mov_title= 'Annie Hall'

3.Write a query in SQL to find the name of movie and director (first and last names) who directed a movie that casted a role for 'Eyes Wide Shut'.

Query :

SELECT director.dir_fname, director.dir_lname,movie.mov_title
FROM director
INNER JOIN movie_direction
ON movie_direction.dir_id = director.dir_id
INNER JOIN movie
ON movie.mov_id = movie_direction.mov_id
WHERE movie.mov_title= 'Eyes Wide Shut'


4.Write a query in SQL to find the name of movie and director (first and last names) who directed a movie that casted a role as Sean Maguire.

Query :

SELECT director.dir_fname, director.dir_lname,movie.mov_title
FROM director
INNER JOIN movie_direction
ON movie_direction.dir_id = director.dir_id
INNER JOIN movie
ON movie.mov_id = movie_direction.mov_id
INNER JOIN movie_cast
ON movie.mov_id = movie_cast.mov_id
WHERE movie_cast.role= 'Sean Maguire'

5.Write a query in SQL to list all the actors who have not acted in any movie between 1990 and 2000.

Query :

SELECT actor.act_fname, actor.act_lname
FROM actor 
INNER JOIN movie_cast
ON movie_cast.act_id = actor.act_id
INNER JOIN movie
ON movie.mov_id = movie_cast.mov_id
WHERE mov_year NOT BETWEEN 1990 AND 2000
ORDER BY mov_year

6.Write a query in SQL to list first and last name of all the directors with number of genres movies the directed with genres name, and arranged the result alphabetically with the first and last name of the director. 

Query :

SELECT director.dir_fname, director.dir_lname, COUNT(*) AS total_Genre,genres.gen_title
FROM director
INNER JOIN movie_direction 
ON director.dir_id = movie_direction.dir_id
INNER JOIN movie 
ON movie_direction.mov_id =  movie.mov_id
INNER JOIN movie_genres 
ON movie.mov_id = movie_genres.mov_id
INNER JOIN genres 
ON movie_genres.gen_id = genres.gen_id
GROUP BY genres.gen_title,director.dir_fname,director.dir_lname,genres
ORDER BY director.dir_fname, director.dir_lname ASC



7.Write a query in SQL to list all the movies with year and genres.

Query :

SELECT mov_title,mov_year,gen_title 
FROM movie
INNER JOIN movie_genres
ON movie.mov_id = movie_genres.mov_id
INNER JOIN genres
ON genres.gen_id = movie_genres.gen_id

8. Write a query in SQL to list all the movies with year, genres, and name of the director.

Query :

SELECT 
mov_title,mov_year,
gen_title,dir_fname, 
dir_lname 
FROM 
movie
INNER JOIN movie_genres
ON movie.mov_id = movie_genres.mov_id
INNER JOIN genres
ON genres.gen_id = movie_genres.gen_id
INNER JOIN movie_direction
ON movie_direction.mov_id = movie.mov_id
INNER JOIN director
ON movie_direction.dir_id = director.dir_id

9.Write a query in SQL to list all the movies with title, year, date of release, movie duration, and first and last name of the director which released before 1st january 1989, and sort the result set according to release date from highest date to lowest.

SELECT 
mov_title,
mov_year,
mov_dt_rel,
mov_time,
dir_fname, 
dir_lname 
FROM 
movie
INNER JOIN movie_direction
ON movie_direction.mov_id = movie.mov_id
INNER JOIN director
ON movie_direction.dir_id = director.dir_id
WHERE mov_dt_rel < '1989-01-01'
ORDER BY mov_dt_rel


10.Write a query in SQL to compute a report which contain the genres of those movies with their average time and number of movies for each genres.

11.Write a query in SQL to find those lowest duration movies along with the year, director's name, actor's name and his/her role in that production.

12.Write a query in SQL to find all the years which produced a movie that received a rating of 3 or 4, and sort the result in increasing order.

13.Write a query in SQL to return the reviewer name, movie title, and stars in an order that reviewer name will come first, then by movie title, and lastly by number of stars.

14.Write a query in SQL to find movie title and number of stars for each movie that has at least one rating and find the highest number of stars that movie received and sort the result by movie title.

15.Write a query in SQL to find the director's first and last name together with the title of the movie(s) they directed and received the rating.

16.Write a query in SQL to find the movie title, actor first and last name, and the role for those movies where one or more actors acted in two or more movies.

17.Write a query in SQL to find the first and last name of a director and the movie he or she directed, and the actress appeared which first name was Claire and last name was Danes along with her role in that movie. 

18.Write a query in SQL to find the first and last name of an actor with their role in the movie which was also directed by themselve.

19.Write a query in SQL to find the cast list for the movie Chinatown.

20.Write a query in SQL to find the movie in which the actor appeared whose first and last name are 'Harrison' and 'Ford'.

21.Write a query in SQL to find the highest-rated movie, and report its title, year, rating, and releasing country.

22.Write a query in SQL to find the highest-rated Mystery movie, and report the title, year, and rating.

23.Write a query in SQL to generate a report which shows the year when most of the Mystery movies produces, and number of movies and their average rating.

24.Write a query in SQL to generate a report which contain the columns movie title, name of the female actor, year of the movie, role, movie genres, the director, date of release, and rating of that movie.






