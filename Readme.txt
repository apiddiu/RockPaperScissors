-- Application RUN
Prerequisites: Maven tool has to be installed in the running machine.

On windows environments you can simply run Start.bat, it will clean, build and run the application (the application packaging skips unit tests)
Otherwise you can run this command in a console:
	mvn clean package -DskipTests exec:java -Dexec.mainClass=com.aldo.rockpaperscissors.MainApp