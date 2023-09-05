# Use a base image with Java 17 support
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /zoostorestorageapp

# Copy the .jar file from the local directory to the container
COPY target/tinqin-storage.jar /zoostorestorageapp/

# Command to run when the container starts
CMD ["java", "-jar", "/zoostorestorageapp/tinqin-storage.jar"]

EXPOSE 8081