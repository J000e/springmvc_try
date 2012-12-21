CREATE TABLE 
	APP.track_location (
		location_id INT NOT NULL PRIMARY KEY, 
		city VARCHAR(40), 
		street VARCHAR(70));
		
CREATE TABLE 
	APP.track (
		track_id INT NOT NULL PRIMARY KEY, 
		name VARCHAR(50), 
		location_id INT,
		CONSTRAINT fk_location FOREIGN KEY (location_id)
		REFERENCES APP.track_location(location_id));
		
CREATE TABLE 
	APP.pilot (
		pilot_id INT NOT NULL PRIMARY KEY, 
		pilot_name VARCHAR(70));
		
CREATE TABLE 
	APP.gokart (
		gokart_id INT NOT NULL PRIMARY KEY, 
		number INT, 
		ccm INT, 
		track_id INT,
		CONSTRAINT fk_track FOREIGN KEY (track_id)
		REFERENCES APP.track(track_id));

CREATE TABLE 
	APP.lap_time (
		time_id INT NOT NULL PRIMARY KEY, 
		lap_time INT, 
		date_of_the_lap DATE, 
		section_number INT, 
		gokart_id INT, 
		pilot_id INT, 
		track_id INT,
		CONSTRAINT fk_gokart FOREIGN KEY (gokart_id)
		REFERENCES APP.gokart(gokart_id),
		CONSTRAINT fk_pilot FOREIGN KEY (pilot_id)
		REFERENCES APP.pilot(pilot_id),
		CONSTRAINT fk_lap_track FOREIGN KEY (track_id)
		REFERENCES APP.track(track_id));

