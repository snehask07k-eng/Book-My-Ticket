package com.jsp.book.util;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jsp.book.entity.Movie;
import com.jsp.book.entity.Theater;
import com.jsp.book.repository.MovieRepository;
import com.jsp.book.repository.TheaterRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Order(1) // Run before DataSeeder
public class CloudinaryMigrator implements CommandLineRunner {

	private static final String CLOUDINARY_PREFIX = "https://res.cloudinary.com";
	private static final String FALLBACK_IMAGE = "https://placehold.co/600x400/EEE/31343C";

	private final MovieRepository movieRepository;
	private final TheaterRepository theaterRepository;

	@Override
	public void run(String... args) {
		migrateMovies();
		migrateTheaters();
	}

	private void migrateMovies() {
		List<Movie> movies = movieRepository.findAll();
		boolean updated = false;

		for (Movie movie : movies) {
			String imageLink = movie.getImageLink();
			if (imageLink != null && imageLink.startsWith(CLOUDINARY_PREFIX)) {
				movie.setImageLink(FALLBACK_IMAGE);
				updated = true;
			}
		}

		if (updated) {
			movieRepository.saveAll(movies);
			System.out
					.println("[CloudinaryMigrator] Replaced Cloudinary URLs in Movie records with local placeholder.");
		}
	}

	private void migrateTheaters() {
		List<Theater> theaters = theaterRepository.findAll();
		boolean updated = false;

		for (Theater theater : theaters) {
			String imageLocation = theater.getImageLocation();
			if (imageLocation != null && imageLocation.startsWith(CLOUDINARY_PREFIX)) {
				theater.setImageLocation(FALLBACK_IMAGE);
				updated = true;
			}
		}

		if (updated) {
			theaterRepository.saveAll(theaters);
			System.out.println(
					"[CloudinaryMigrator] Replaced Cloudinary URLs in Theater records with local placeholder.");
		}
	}
}
