#!/bin/bash
set -e # Exit immediately if a command exits with a non-zero status.

# Download OpenJDK 17
echo "Downloading OpenJDK 17..."
curl -L https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.9%2B9/OpenJDK17U-jdk_x64_linux_hotspot_17.0.9_9.tar.gz -o jdk17.tar.gz

# Extract
echo "Extracting Java..."
tar -xzf jdk17.tar.gz

# Set Environment Variables
export JAVA_HOME=$(pwd)/jdk-17.0.9+9
export PATH=$JAVA_HOME/bin:$PATH

# Verify Java Version
echo "Using Java Version:"
java -version

# Run Build
echo "Starting Gradle Build..."
./gradlew wasmJsBrowserDistribution --no-daemon --stacktrace
