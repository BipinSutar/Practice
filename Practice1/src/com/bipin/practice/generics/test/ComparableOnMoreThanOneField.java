package com.bipin.practice.generics.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Movie {
	int releaseYear, ratings;
	String name;

	Movie(int releaseYear, int ratings, String name) {
		this.releaseYear = releaseYear;
		this.ratings = ratings;
		this.name = name;
	}

	@Override
	public String toString() {
		return "ReleaseYear = " + releaseYear + " ratings = " + ratings + " name = " + name;
	}
}

class MovieSortByReleaseYear implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {

		return o1.releaseYear - o2.releaseYear;
	}

}

class MovieSortByRatings implements Comparator<Movie> {
	@Override
	public int compare(Movie o1, Movie o2) {
		return o1.ratings - o2.ratings;
	}
}

public class ComparableOnMoreThanOneField {

	public static void main(String[] args) {
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie(2000, 6, "Lagan"));
		movies.add(new Movie(2000, 5, "Tere bin"));
		movies.add(new Movie(1998, 4, "DDLJ"));
		movies.add(new Movie(1997, 3, "Boss"));
		movies.add(new Movie(2003, 2, "Andha kanoon"));
		for (Movie e : movies) {
			System.out.println(e);
		}
		System.out.println();
		MovieSortByReleaseYear sortbyyear = new MovieSortByReleaseYear();
		Collections.sort(movies, sortbyyear);
		for (Movie e : movies) {
			System.out.println(e);
		}
		System.out.println();
		MovieSortByRatings sortbyrating = new MovieSortByRatings();
		Collections.sort(movies, sortbyrating);
		for (Movie e : movies) {
			System.out.println(e);
		}
		System.out.println();
		Collections.sort(movies, new Comparator<Movie>() {
			@Override
			public int compare(Movie o1, Movie o2) {
				int yearCompare = o1.releaseYear - o2.releaseYear;

				return yearCompare == 0 ? o1.ratings - o2.ratings : yearCompare;
			}
		});
		for (Movie e : movies) {
			System.out.println(e);
		}

	}

}
