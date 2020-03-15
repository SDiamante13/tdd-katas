# tdd-katas

## 1) Leap Year kata

Write a function that returns true or false depending on whether its input integer is a leap year or not.

A leap year is divisible by 4, but is not otherwise divisible by 100 unless it is also divisible by 400.

2001 is a typical common year
1996 is a typical leap year
1900 is an atypical common year 
2000 is an atypical leap year

## 2) Human Readable Time

Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)

HH = hours, padded to 2 digits, range: 00 - 99
MM = minutes, padded to 2 digits, range: 00 - 59
SS = seconds, padded to 2 digits, range: 00 - 59
The maximum time never exceeds 359999 (99:59:59)

## 3) Word Counter

A method that, given a delimited string, returns a collection of all of the 
unique words in it and the count of how many times they occurred.
Start off with a space between words, but later other delimiters wil
be added.

Example input:

	"boom,bang,boom"

Which would produce the following result:

	boom, 2
	bang, 1

## 4) Ohce

https://kata-log.rocks/ohce-kata

A short and simple exercise to practice outside-in TDD using test doubles.

ohce is a console application that echoes the reverse of what you input through the console.

Even though it seems a silly application, ohce knows a thing or two.

When you start oche, it greets you differently depending on the current time, but only in Spanish:
Between 20 and 6 hours, ohce will greet you saying: ¡Buenas noches < your name >!
Between 6 and 12 hours, ohce will greet you saying: ¡Buenos días < your name >!
Between 12 and 20 hours, ohce will greet you saying: ¡Buenas tardes < your name >!
When you introduce a palindrome, ohce likes it and after reverse-echoing it, it adds ¡Bonita palabra!
ohce knows when to stop, you just have to write Stop! and it'll answer Adios < your name > and end.
This is an example of using ohce during the morning:

$ ohce Pedro
> ¡Buenos días Pedro!
$ hola
> aloh
$ oto
> oto
> ¡Bonita palabra!
$ stop
> pots
$ Stop!
> Adios Pedro