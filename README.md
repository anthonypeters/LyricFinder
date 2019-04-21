# LyricFinder
# By: Anthony Peters and Peter Radev
# Read Me written by Anthony Peters

This was a program created mostly by myself with the help of Peter. The goal of this program was to create a database, and
working algorithm, that found songs for users based off of catchy lyrics as input from the user. A lot of times, people 
struggle to identify catchy songs that they hear out in public and if the song changes too quick or the people forget to use 
shazam, there is no real way for people to find songs based off of one line of lyric that they just so happen to remember.

What we did to solve this problem was create a textfile database with a few catchy songs. It was formatted using semi-colons,
so that we could use a delimiter to read every line seperatley. Unfortunatley, the text files need very precise formatting in
order to properly retrieve songs based on lyrics, and we never ended up finalizing the text files, but they still work for the
most part. 
  - What I want to do is edit the program to store a better database, maybe one that has been pre-created for a similar 
    program.

I created the Song class and LyricFinder class that work together to retrieve the contents from the text files, and 
properly format the output string, showing the songs contents. Peter helped retrieve the algorithm from an online source and
we used the algorithm to measure the edit distance of the user input and the different lines of lyrics in all of the songs, 
in order to properly align the user input with the closest song that matches. 
  - Instead of using a local alignment algorithm, I would like to use a global alignment algorithm that would read the 
    entirety of the lyrics and look for similarities. This is an edit we need to make, but we would use something like 
    Needleman-Wunsch algorithm to accomplish this task.
    
We failed in creating a successful GUI as well, due to time constraints on the project, but this is another addition I would 
like to make to the program.

At the end of the day, this program works by taking input from the user, comparing the input to every single line in every 
single song in our databse, and then returning the song with the edit distance value that most closely aligns with user input.
